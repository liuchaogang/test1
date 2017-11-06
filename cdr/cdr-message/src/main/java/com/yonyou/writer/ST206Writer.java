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
import com.yonyou.hl7adapter.model.ST206.ST206;
import com.yonyou.service.PatientVisitService;
import com.yonyou.service.UhDcTransDeptService;
import com.yonyou.util.Constant;

/**
 * @author liuchaogang@yonyou.com
 * @ClassName:ST206Writer.java
 * @Description:
 * @date 2017年7月5日
 */
@Component(value = "ST206")
public class ST206Writer implements BaseProcessWriter<ST206> {
    private static Logger st206Logger = LoggerFactory.getLogger("ST206Logger");

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
    public boolean validation(ST206 st206, Object reMsg) {

        msgId = st206.getMsgId();

        if (StringUtils.isEmpty(msgId)) {
            st206Logger.error("st206,msgId为空");
            return false;
        }

        mipMsgLog = msgLogService.getMsgLogByMsgId(msgId);


        orgCode = Constant.getOrgCode();

        groupCode = Constant.getGroupCode();


        if (st206.getPatient() == null) {
            msgLogService.saveMsgLog(CommonWriter.generateLog(mipMsgLog, null, MessageStatus.NULL_DTO));

            st206Logger.error("ST206-{},患者信息获取失败，请检查xml格式", st206.getMsgId());
            return false;
        }

        if (StringUtils.isEmpty(st206.getPatient().getGroupCode()))
            st206.getPatient().setGroupCode(groupCode);
        if (StringUtils.isEmpty(st206.getPatient().getOrgCode()))
            st206.getPatient().setOrgCode(orgCode);

        return true;
    }

    @Override
    public void businessWrite(ST206 st206) {
        st206Logger.debug("msgId:{}", st206.getMsgId());
        //st206.getVisitId()对应pv表中的pvcode
        UhDcPv uhDcPv = patientVisitService.getUhDcPvByPvcode(st206.getVisitId());

        if (uhDcPv == null) {

            msgLogService.saveMsgLog(CommonWriter.generateLog(mipMsgLog, "patienId:" + st206.getPatient().getPatientId() +
                    ",visitLid:" + st206.getVisitId(), MessageStatus.DEPEND_NOT_EXIST));
            st206Logger.debug("没有该次就诊，就诊流水号为：", st206.getVisitId());
            return;
        }

        if (st206 != null) {
            //获取就诊表里记录的empi号
            st206.getPatient().setEmpiId(uhDcPv.getEmpi());

            UhDcTransDept uhDcTransDept = UhDcTransDeptConvertor.getUhDcTransDeptForST206(st206, uhDcPv.getPkDcpv());

            uhDcTransDeptService.saveUhDcTransDept(uhDcTransDept);

            tables += "UhDcTransDept";
            mipMsgLog.setBusinessTables(tables);
            msgLogService.saveMsgLog(CommonWriter.generateLog(mipMsgLog, "pkPati：" + uhDcPv.getPkPati() + ",pkPvCode：" + uhDcPv.getPkDcpv(), MessageStatus.OK));
        }


    }


    public boolean checkPre(ST206 t) {

        return true;
    }

}
