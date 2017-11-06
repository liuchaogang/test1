package com.yonyou.writer;


import com.yonyou.core.CommonWriter;
import com.yonyou.core.MessageStatus;
import com.yonyou.entity.UhDcMipMsgLog;
import com.yonyou.service.MipMsgLogService;
import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.yonyou.entity.UhDcPv;
import com.yonyou.entity.UhDcTransDept;
import com.yonyou.hl7adapter.model.ST207.ST207;
import com.yonyou.service.PatientVisitService;
import com.yonyou.service.UhDcTransDeptService;
import com.yonyou.util.Constant;

/**
 * @author liuchaogang@yonyou.com
 * @ClassName:ST207Writer.java
 * @Description:
 * @date 2017年7月5日
 */
@Component(value = "ST207")
public class ST207Writer implements BaseProcessWriter<ST207> {
    private static Logger st207Logger = LoggerFactory.getLogger("ST207Logger");

    @Autowired
    private UhDcTransDeptService uhDcTransDeptService;
    @Autowired
    private PatientVisitService patientVisitService;

    private String orgCode;

    private String groupCode;

    @Autowired
    private MipMsgLogService msgLogService;

    private UhDcMipMsgLog mipMsgLog;

    private String msgId;

    private String tables;

    @Override
    public boolean validation(ST207 st207, Object reMsg) {

        msgId = st207.getMsgId();

        if (StringUtils.isEmpty(msgId)) {
            st207Logger.error("st207,msgId为空");
            return false;
        }

        mipMsgLog = msgLogService.getMsgLogByMsgId(msgId);
        orgCode = Constant.getOrgCode();
        groupCode = Constant.getGroupCode();

        if (st207.getPatient() == null) {
            msgLogService.saveMsgLog(CommonWriter.generateLog(mipMsgLog, null, MessageStatus.NULL_DTO));

            st207Logger.error("ST207-{},患者信息获取失败，请检查xml格式", st207.getMsgId());
            return false;
        }
        if (StringUtils.isEmpty(st207.getPatient().getGroupCode()))
            st207.getPatient().setGroupCode(groupCode);
        if (StringUtils.isEmpty(st207.getPatient().getOrgCode()))
            st207.getPatient().setOrgCode(orgCode);

        return true;
    }

    @Override
    public void businessWrite(ST207 st207) {
        st207Logger.debug("msgId:{}", st207.getMsgId());
        UhDcPv uhDcPv = patientVisitService.getUhDcPvByPvcode(st207.getVisitId());

        if (uhDcPv == null) {
            msgLogService.saveMsgLog(CommonWriter.generateLog(mipMsgLog, "patienId:" + st207.getPatient().getPatientId() +
                    ",visitLid:" + st207.getVisitId(), MessageStatus.DEPEND_NOT_EXIST));
            st207Logger.debug("没有该次就诊，就诊流水号为：", st207.getVisitId());
            return;
        }
        if (st207 != null) {
            //获取就诊表里记录的empi号
            st207.getPatient().setEmpiId(uhDcPv.getEmpi());

            UhDcTransDept uhDcTransDept = UhDcTransDeptConvertor.getUhDcTransDeptForST207(st207, uhDcPv.getPkDcpv());

            uhDcTransDeptService.saveUhDcTransDept(uhDcTransDept);

            tables += "UhDcTransDept";
            mipMsgLog.setBusinessTables(tables);
            msgLogService.saveMsgLog(CommonWriter.generateLog(mipMsgLog, "pkPati：" + uhDcPv.getPkPati() + ",pkPvCode：" + uhDcPv.getPkDcpv(), MessageStatus.OK));

        }


    }

    @Override
    public boolean checkPre(ST207 t) {
        // TODO Auto-generated method stub
        return true;
    }

}
