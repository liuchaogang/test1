package com.yonyou.writer;

 
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

 
import com.yonyou.entity.UhDcPi;
import com.yonyou.entity.UhDcPiCrossIndex;
import com.yonyou.hl7adapter.model.MergedPatient;
import com.yonyou.hl7adapter.model.Patient;
import com.yonyou.hl7adapter.model.ST102.ST102;
import com.yonyou.hl7adapter.model.ST105.ST105;
import com.yonyou.service.PatientService;
import com.yonyou.util.Constant;
 
import com.yonyou.core.CommonWriter;
import com.yonyou.core.MessageStatus;
import com.yonyou.entity.UhDcMipMsgLog;
import com.yonyou.entity.UhDcPi;
import com.yonyou.entity.UhDcPiCrossIndex;
import com.yonyou.hl7adapter.model.MergedPatient;
import com.yonyou.hl7adapter.model.Patient;
import com.yonyou.hl7adapter.model.ST102.ST102;
import com.yonyou.hl7adapter.model.ST105.ST105;
import com.yonyou.service.MipMsgLogService;
import com.yonyou.service.PatientService;
import com.yonyou.util.Constant;
 
import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.yonyou.entity.UhDcPi;
import com.yonyou.entity.UhDcPiCrossIndex;
import com.yonyou.hl7adapter.model.MergedPatient;
import com.yonyou.hl7adapter.model.ST105.ST105;
import com.yonyou.service.PatientService;
import com.yonyou.util.Constant;

/**
 * @author chenpana@yonyou.com
 * @ClassName: ST105Writer
 * @Description: ST105个人身份合并服务业务处理
 * @date 2017/6/27 15:37
 */
@Component(value = "ST105")
public class ST105Writer implements BaseProcessWriter<ST105> {

    private static Logger st105Logger = LoggerFactory.getLogger("ST105Logger");

    @Autowired
    private PatientService patientService;

    //消息中患者的empiId
    private String empiId;

    private Date currentTime;

    //患者empi号变更时，是否更新其他业务表的empi和pk_pati
    private Boolean isUpdateOtherBuss;

    private String orgCode;

    private String groupCode;
    /**
     * 新插入患者主键
     */
    private String pkPati;

    private List<String> oldPkPiLists;

    @Autowired
    private MipMsgLogService msgLogService;

    private UhDcMipMsgLog mipMsgLog;

    private String msgId;

    private String tables;


    @Override
    public boolean validation(ST105 st105, Object reMsg) {

        msgId = st105.getMsgId();
        if (StringUtils.isEmpty(msgId) || "uuid".equals(msgId)) {
            st105Logger.error("st105-{},msgId为空");
            return false;
        }
        mipMsgLog = msgLogService.getMsgLogByMsgId(msgId);

        orgCode = Constant.getOrgCode();

        groupCode = Constant.getGroupCode();


        if (st105.getBestPatient() == null) {
            msgLogService.saveMsgLog(CommonWriter.generateLog(mipMsgLog, null, MessageStatus.NULL_DTO));

            st105Logger.error("ST102-{},患者信息获取失败，请检查xml格式", st105.getMsgId());
            return false;
        }
        empiId = st105.getBestPatient().getEmpiId();

        if (StringUtils.isEmpty(empiId)) {
            msgLogService.saveMsgLog(CommonWriter.generateLog(mipMsgLog, "empiId为空", MessageStatus.NULL_FIELD));
            st105Logger.error("ST105-{},empiId为空", st105.getMsgId());
            return false;
        }

        currentTime = new Date();

        if (StringUtils.isEmpty(st105.getBestPatient().getGroupCode()))
            st105.getBestPatient().setGroupCode(groupCode);
        if (StringUtils.isEmpty(st105.getBestPatient().getOrgCode()))
            st105.getBestPatient().setOrgCode(orgCode);

        /*pkPati = YYStringUtils.getUUID();*/

        return true;
    }

    @Override
    public boolean checkPre(ST105 st105) {
        return true;
    }

    @Override
    @Transactional
    public void businessWrite(ST105 st105) {
        st105Logger.debug("msgId:{}", st105.getMsgId());

        //根据patientId和localIdTypeCode查找患者交叉索引是否存在
        if (st105.getMergedPatients() != null && !st105.getMergedPatients().isEmpty()) {
            oldPkPiLists = new ArrayList<>();
            for (int i = 0; i < st105.getMergedPatients().size(); i++) {
                MergedPatient mergeP = st105.getMergedPatients().get(i);

                UhDcPiCrossIndex piCrossIndex = patientService.getUhPiCrossIndex(
                        mergeP.getPatientId(), mergeP.getLocalTypeCode(),
                        st105.getBestPatient().getGroupCode(), st105.getBestPatient().getOrgCode());

                //关联的患者已存在
                if (piCrossIndex != null) {
                    //更新交叉索引的empi
                    piCrossIndex.setEditTime(currentTime);
                    piCrossIndex.setEmpi(empiId);
                    patientService.saveUhPiCrossIndex(piCrossIndex);

                    //是否存在关联患者的临时患者信息,存在则删除相应的地址、证件、联系人、基本信息
                    UhDcPi tmpPi = patientService.getTmpUhDcPi(empiId, mergeP.getPatientId(), mergeP.getLocalTypeCode(),
                            st105.getBestPatient().getGroupCode(), st105.getBestPatient().getOrgCode());

                    if (tmpPi != null) {
                        oldPkPiLists.add(tmpPi.getPkPati());

                        isUpdateOtherBuss = true;
                    }

                } else {
                    isUpdateOtherBuss = false;

                }
            }
        }

        //最佳记录处理
        String groupCodeIn = st105.getBestPatient().getGroupCode();
        String orgCodeIn = st105.getBestPatient().getOrgCode();


        //根据empiId查询患者是否存在
        UhDcPi uhDcPiDB = patientService.getUhDcPi(empiId, groupCodeIn, orgCodeIn);
        if (uhDcPiDB == null) {
            //插入最佳记录相关信息
            //保存患者信息，获取返回主键
            UhDcPi uhDcPi = patientService.savePatientInfo(PatientConvertor.getPi(st105.getBestPatient(), empiId, currentTime, pkPati, uhDcPiDB));

            pkPati = uhDcPi.getPkPati();

            //保存证件、地址、联系人信息
            patientService.savePatientInfo(
                    PatientConvertor.getPiCard(st105.getBestPatient(), currentTime, pkPati, groupCodeIn, orgCodeIn),
                    PatientConvertor.getPiAddresses(st105.getBestPatient().getAddress(), currentTime, pkPati, groupCodeIn, orgCodeIn),
                    PatientConvertor.getLinkmen(st105.getBestPatient().getContact(), currentTime, pkPati, groupCodeIn, orgCodeIn)
            );
        } else {
            //更新
            pkPati = uhDcPiDB.getPkPati();
            st105Logger.debug("患者empiId:{},pkPati:{}已存在,更新", empiId, pkPati);
            //更新
            UhDcPi uhDcPi = patientService.savePatientInfo(PatientConvertor.getPi(st105.getBestPatient(), empiId, currentTime, pkPati, uhDcPiDB));
        }

        //临时患者信息或empi号更改过的患者业务处理，删除旧的地址、联系人、证件，更新关联业务表empi和pkPati
        patientService.updateOldPiInfo(oldPkPiLists, pkPati, empiId);


        tables = "UhDcPi;UhDcPiCrossIndex;UhDcPiCard;UhDcPiAddress;UhDcPiLinkman";
        mipMsgLog.setBusinessTables(tables);

        String desc = (uhDcPiDB == null ? "保存患者信息成功,pkPati:" + pkPati : "更新患者信息成功,pkPati:" + pkPati);
        msgLogService.saveMsgLog(CommonWriter.generateLog(mipMsgLog, desc, MessageStatus.OK));
    }


}
