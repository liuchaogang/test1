package com.yonyou.writer;

import com.yonyou.entity.UhDcOrdRecord;
import com.yonyou.entity.UhDcPv;
import com.yonyou.hl7adapter.model.SD007.SD007;
import com.yonyou.service.PatientVisitService;
import com.yonyou.service.ReportService;
import com.yonyou.util.Constant;
import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @author chenpana@yonyou.com
 * @ClassName: SD007Writer
 * @Description:
 * @date 2017/7/10 16:52
 */
 
public class SD007Writer2 implements BaseProcessWriter<SD007> {

    private static Logger sd007Logger = LoggerFactory.getLogger("SD007Logger");

    @Autowired
    private PatientVisitService patientVisitService;

    @Autowired
    private ReportService reportService;

    private String orgCode;

    private String groupCode;

    private String pkPati;

    private String empi;

    private String pkDcPv;

    @Override
    public boolean validation(SD007 sd007, Object reMsg) {
        if (StringUtils.isEmpty(sd007.getVersionNo())) {
            reMsg = "CDA文档版本号不能为空";
            return false;
        }
        if (StringUtils.isEmpty(sd007.getDocumentNo())) {
            reMsg = "CDA文档流水号（报告号）不能为空";
            return false;
        }

        orgCode = Constant.getOrgCode();
        groupCode = Constant.getGroupCode();

        return true;
    }

    @Override
    public boolean checkPre(SD007 sd007) {
        return true;
    }

    @Override
    public void businessWrite(SD007 sd007) {
        //判断是新增还是修改
        if (Constant.getCDAVersionAdd().equals(sd007.getVersionNo())) {
            //新增
            UhDcPv uhDcPvDB = patientVisitService.getUhDcPv(sd007.getPatient().getPatientId(),
                    sd007.getPvSerialNum(), sd007.getPvTimes(),
                    sd007.getPatient().getPatientTypeCode(), orgCode,
                    groupCode);
            if (uhDcPvDB == null) {
                sd007Logger.error("患者就诊信息不存在，patientId:{},pvCode:{},visitType:{},orgCode:{},groupCode:{}",
                        sd007.getPatient().getPatientId(), sd007.getPvSerialNum(),
                        sd007.getPatient().getPatientTypeCode(), orgCode, groupCode);
                //就诊不存在后续处理
            } else {
                pkPati = uhDcPvDB.getPkPati();
                empi = uhDcPvDB.getEmpi();
                pkDcPv = uhDcPvDB.getPkDcpv();

                //根据报告号查找报告信息是否已存在
                UhDcOrdRecord ordRecordDB = reportService.getReportByCondition(sd007.getDocumentNo(), groupCode, orgCode, "0");
                if (ordRecordDB != null) {
                    sd007Logger.error("报告已存在，NO:{}", sd007.getDocumentNo());
                } else {
                    sd007Logger.info("UhDcOrdRecord新增报告记录，NO：{}", sd007.getDocumentNo());
                }
            }

        } else if (Constant.getCDAVersionModify().equals(sd007.getVersionNo())) {
            //修改

        } else {
            sd007Logger.error("不支持的操作类型：{}", sd007.getVersionNo());
        }


    }
}
