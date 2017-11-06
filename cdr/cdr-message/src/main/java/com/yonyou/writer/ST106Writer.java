package com.yonyou.writer;

 
import java.util.Date;

 
import com.yonyou.entity.UhDcPi;
import com.yonyou.entity.UhDcPiCrossIndex;
import com.yonyou.hl7adapter.model.Patient;
import com.yonyou.hl7adapter.model.ST106.ST106;
import com.yonyou.service.PatientService;
import com.yonyou.util.Constant;
 
import com.yonyou.core.CommonWriter;
import com.yonyou.core.MessageStatus;
import com.yonyou.entity.UhDcMipMsgLog;
import com.yonyou.entity.UhDcPi;
import com.yonyou.entity.UhDcPiCrossIndex;
import com.yonyou.hl7adapter.model.Patient;
import com.yonyou.hl7adapter.model.ST106.ST106;
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
import com.yonyou.hl7adapter.model.ST106.ST106;
import com.yonyou.service.PatientService;
import com.yonyou.util.Constant;

 
 

/**
 * @author chenpana@yonyou.com
 * @ClassName: ST106Writer
 * @Description: ST106删除主索引业务处理
 * @date 2017/6/27 15:37
 */
@Component(value = "ST106")
public class ST106Writer implements BaseProcessWriter<ST106> {

    private static Logger st106Logger = LoggerFactory.getLogger("ST106Logger");

    @Autowired
    private PatientService patientService;

    //消息中患者的empiId
    private String empiId;

    private Date currentTime;

    private String orgCode;

    private String groupCode;

    @Autowired
    private MipMsgLogService msgLogService;

    private UhDcMipMsgLog mipMsgLog;

    private String msgId;

    private String tables;

    @Override
    public boolean validation(ST106 st106, Object reMsg) {

        msgId = st106.getMsgId();
        if (StringUtils.isEmpty(msgId) || "uuid".equals(msgId)) {
            st106Logger.error("st106-{},msgId为空");
            return false;
        }
        mipMsgLog = msgLogService.getMsgLogByMsgId(msgId);

        orgCode = Constant.getOrgCode();

        groupCode = Constant.getGroupCode();

        empiId = st106.getDelEmpiId();

        if (StringUtils.isEmpty(empiId)) {
            msgLogService.saveMsgLog(CommonWriter.generateLog(mipMsgLog, "empiId为空", MessageStatus.NULL_FIELD));
            st106Logger.error("st106-{},empiId为空", st106.getMsgId());
            return false;
        }

        currentTime = new Date();

        return true;
    }

    @Override
    public boolean checkPre(ST106 st106) {
        return true;
    }

    @Override
    @Transactional
    public void businessWrite(ST106 st106) {
        st106Logger.debug("msgId:{}", st106.getMsgId());

        UhDcPi uhDcPi = patientService.getUhDcPi(empiId);

        if (uhDcPi == null) {
            msgLogService.saveMsgLog(CommonWriter.generateLog(mipMsgLog, "删除的主索引信息不存在", MessageStatus.DEPEND_NOT_EXIST));
            st106Logger.info("msgId:{}-删除的主索引信息不存在，empiId:{}", st106.getMsgId(), empiId);
        } else {
            patientService.delPatientAll(uhDcPi);

            msgLogService.saveMsgLog(CommonWriter.generateLog(mipMsgLog, null, MessageStatus.OK));
        }

    }


}
