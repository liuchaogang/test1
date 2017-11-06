package com.yonyou.writer;

import java.util.Date;

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
import com.yonyou.entity.UhDcPvInp;
import com.yonyou.hl7adapter.model.ST209.ST209;
import com.yonyou.service.PatientVisitService;
import com.yonyou.service.UhDcPvInpService;

/**
 * @author liuchaogang@yonyou.com
 * @ClassName:ST209Writer.java
 * @Description:
 * @date 2017年7月6日 下午7:49:08
 */
@Component(value = "ST209")
public class ST209Writer implements BaseProcessWriter<ST209> {

    private static Logger logger = LoggerFactory.getLogger("ST209Logger");

    @Autowired
    private PatientVisitService patientVisitService;
    @Autowired
    private UhDcPvInpService uhDcPvInpServiceImpl;

    @Autowired
    private MipMsgLogService msgLogService;

    private UhDcMipMsgLog mipMsgLog;

    private String msgId;

    private String tables;


    @Override
    public boolean validation(ST209 t, Object reMsg) {
        msgId = t.getMsgId();

        if (StringUtils.isEmpty(msgId)) {
            logger.error("st209,msgId为空");
            return false;
        }

        mipMsgLog = msgLogService.getMsgLogByMsgId(msgId);

        if (t.getPatient() == null) {
            msgLogService.saveMsgLog(CommonWriter.generateLog(mipMsgLog, null, MessageStatus.NULL_DTO));

            logger.error("ST207-{},患者信息获取失败，请检查xml格式", t.getMsgId());
            return false;
        }
        return true;
    }

    @Override
    public boolean checkPre(ST209 t) {

        return true;
    }

    @Override
    public void businessWrite(ST209 t) {
        UhDcPv uhDcPvDB = patientVisitService.getUhDcPv(t.getPatient().getPatientId(),
                t.getVisitId(), t.getVisitTimes(), t.getPatientTypeCode(),
                t.getPatient().getGroupCode(), t.getPatient().getOrgCode());
        if (uhDcPvDB != null) {
            logger.debug("消息更新库uh_dc_pv（就诊信息），就诊流水号：" + t.getVisitId());
            //更新就诊记录表中就诊结束时间
            patientVisitService.updateUhDcPvDateEnd(uhDcPvDB.getPkDcpv(), t.getLeaveHospitalTime());

            tables += "uhDcPvDB;";
            UhDcPvInp uhDcPvInp = uhDcPvInpServiceImpl.findByPkDcpv(uhDcPvDB.getPkDcpv());

            if (uhDcPvInp != null) {
                logger.debug("消息更新库uh_dc_pv_inp（就诊_住院属性），就诊号：" + uhDcPvDB.getPkDcpv());
                uhDcPvInp.setDeptPhyDisc(t.getDischargeDeptCode());
                uhDcPvInp.setDeptPhyDiscName(t.getDischargeDeptName());
                uhDcPvInp.setAreaDisc(t.getDischargeAreaCode());
                uhDcPvInp.setAreaDiscName(t.getDischargeAreaName());
                uhDcPvInp.setEditTime(new Date());

                uhDcPvInpServiceImpl.saveUhDcPvInp(uhDcPvInp);

                tables += "uhDcPvInp;";
            }
            mipMsgLog.setBusinessTables(tables);
            msgLogService.saveMsgLog(CommonWriter.generateLog(mipMsgLog, "pkPati：" + uhDcPvDB.getPkPati() + ",pkPvCode：" + uhDcPvDB.getPkDcpv(), MessageStatus.OK));

        } else {
            msgLogService.saveMsgLog(CommonWriter.generateLog(mipMsgLog, "pkPati：" + uhDcPvDB.getPkPati() + ",pkPvCode：" + uhDcPvDB.getPkDcpv(), MessageStatus.DEPEND_NOT_EXIST));
        }
    }
}
