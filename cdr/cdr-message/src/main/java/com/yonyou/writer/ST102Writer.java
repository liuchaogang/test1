package com.yonyou.writer;

 
 
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
 
 
 
import com.yonyou.core.CommonWriter;
import com.yonyou.core.MessageStatus;
 
import com.yonyou.entity.UhDcMipMsgLog;
import com.yonyou.entity.UhDcPi;
import com.yonyou.entity.UhDcPiCrossIndex;
import com.yonyou.hl7adapter.model.Patient;
import com.yonyou.hl7adapter.model.ST102.ST102;
import com.yonyou.service.MipMsgLogService;
import com.yonyou.service.PatientService;
import com.yonyou.util.Constant;
 
import com.yonyou.util.YYStringUtils;
 
import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

 
/**
 * @author chenpana@yonyou.com
 * @ClassName: ST102Writer
 * @Description: ST102新建主索引业务处理
 * @date 2017/6/27 15:37
 */
@Component(value = "ST102")
public class ST102Writer implements BaseProcessWriter<ST102> {

    private static Logger st102Logger = LoggerFactory.getLogger("ST102Logger");

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
    public boolean validation(ST102 st102, Object reMsg) {

        msgId = st102.getMsgId();

        if (StringUtils.isEmpty(msgId)) {
            st102Logger.error("ST102-{},msgId为空");
            return false;
        }

        mipMsgLog = msgLogService.getMsgLogByMsgId(msgId);

        orgCode = Constant.getOrgCode();

        groupCode = Constant.getGroupCode();

        if (st102.getBestPatient() == null) {
            msgLogService.saveMsgLog(CommonWriter.generateLog(mipMsgLog, null, MessageStatus.NULL_DTO));

            st102Logger.error("ST102-{},患者信息获取失败，请检查xml格式", st102.getMsgId());
            return false;
        }

        empiId = st102.getBestPatient().getEmpiId();

        if (StringUtils.isEmpty(empiId)) {

            msgLogService.saveMsgLog(CommonWriter.generateLog(mipMsgLog, "empiId为空", MessageStatus.NULL_FIELD));
            st102Logger.error("ST102-{},empiId为空", st102.getMsgId());

            return false;
        }

        currentTime = new Date();

        if (StringUtils.isEmpty(st102.getBestPatient().getGroupCode()))
            st102.getBestPatient().setGroupCode(groupCode);
        if (StringUtils.isEmpty(st102.getBestPatient().getOrgCode()))
            st102.getBestPatient().setOrgCode(orgCode);

        for (Patient linkPatient : st102.getLinkPatients()) {

            if (StringUtils.isEmpty(linkPatient.getGroupCode()))
                linkPatient.setGroupCode(groupCode);
            if (StringUtils.isEmpty(linkPatient.getOrgCode()))
                linkPatient.setOrgCode(orgCode);

        }

        /*pkPati = YYStringUtils.getUUID();*/

        return true;
    }

    @Override
    public boolean checkPre(ST102 st102) {
        return true;
    }

    @Override
    @Transactional
    public void businessWrite(ST102 st102) {
        st102Logger.debug("msgId:{}", st102.getMsgId());
        //根据patientId和localIdTypeCode查找患者交叉索引是否存在
        if (st102.getLinkPatients() != null && st102.getLinkPatients().size() > 0) {
            oldPkPiLists = new ArrayList<>();
            for (int i = 0; i < st102.getLinkPatients().size(); i++) {
                Patient linkPatient = st102.getLinkPatients().get(i);

                UhDcPiCrossIndex piCrossIndex = patientService.getUhPiCrossIndex(
                        linkPatient.getPatientId(), linkPatient.getLocalTypeCode(),
                        linkPatient.getGroupCode(), linkPatient.getOrgCode());

                //关联的患者已存在
                if (piCrossIndex != null) {
                    //更新交叉索引的empi
                    patientService.saveUhPiCrossIndex(PatientConvertor.getPiCrossIndex(linkPatient, empiId, currentTime, piCrossIndex));

                    //是否存在关联患者的临时患者信息,存在则删除相应的地址、证件、联系人、基本信息
                    UhDcPi tmpPi = patientService.getTmpUhDcPi(empiId, linkPatient.getPatientId(), linkPatient.getLocalTypeCode(),
                            linkPatient.getGroupCode(), linkPatient.getOrgCode());

                    if (tmpPi != null) {
                        oldPkPiLists.add(tmpPi.getPkPati());

                        isUpdateOtherBuss = true;
                    }

                } else {
                    //插入交叉索引信息
                    patientService.saveUhPiCrossIndex(PatientConvertor.getPiCrossIndex(linkPatient, empiId, currentTime, piCrossIndex));

                    isUpdateOtherBuss = false;

                }
            }
        }


        String groupCodeIn = st102.getBestPatient().getGroupCode();
        String orgCodeIn = st102.getBestPatient().getOrgCode();


        //根据empiId查询患者是否存在
        UhDcPi uhDcPiDB = patientService.getUhDcPi(empiId, groupCodeIn, orgCodeIn);
        if (uhDcPiDB == null) {
            //插入最佳记录相关信息
            //保存患者信息，获取返回主键
            UhDcPi uhDcPi = patientService.savePatientInfo(PatientConvertor.getPi(st102.getBestPatient(), empiId, currentTime, pkPati, uhDcPiDB));

            pkPati = uhDcPi.getPkPati();

            //保存证件、地址、联系人信息
            patientService.savePatientInfo(
                    PatientConvertor.getPiCard(st102.getBestPatient(), currentTime, pkPati, groupCodeIn, orgCodeIn),
                    PatientConvertor.getPiAddresses(st102.getBestPatient().getAddress(), currentTime, pkPati, groupCodeIn, orgCodeIn),
                    PatientConvertor.getLinkmen(st102.getBestPatient().getContact(), currentTime, pkPati, groupCodeIn, orgCodeIn)
            );
        } else {
            //更新
            pkPati = uhDcPiDB.getPkPati();
            st102Logger.debug("患者empiId:{},pkPati:{}已存在,更新", empiId, pkPati);
            //更新
            UhDcPi uhDcPi = patientService.savePatientInfo(PatientConvertor.getPi(st102.getBestPatient(), empiId, currentTime, pkPati, uhDcPiDB));
        }

        //临时患者信息或empi号更改过的患者业务处理，删除旧的地址、联系人、证件，更新关联业务表empi和pkPati
        patientService.updateOldPiInfo(oldPkPiLists, pkPati, empiId);

        tables = "UhDcPi;UhDcPiCrossIndex;UhDcPiCard;UhDcPiAddress;UhDcPiLinkman";
        mipMsgLog.setBusinessTables(tables);

        String desc = (uhDcPiDB == null ? "保存患者信息成功,pkPati:" + pkPati : "更新患者信息成功,pkPati:" + pkPati);
        msgLogService.saveMsgLog(CommonWriter.generateLog(mipMsgLog, desc, MessageStatus.OK));
    }


}
