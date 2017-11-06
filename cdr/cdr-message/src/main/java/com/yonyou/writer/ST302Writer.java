
package com.yonyou.writer;

import com.yonyou.core.CommonWriter;
import com.yonyou.core.MessageStatus;
import com.yonyou.entity.UhDcMipMsgLog;
import com.yonyou.entity.UhDcOrd;
import com.yonyou.entity.UhDcOrdMedi;
import com.yonyou.entity.UhDcPv;
import com.yonyou.entity.UhDcPvPres;
import com.yonyou.hl7adapter.model.ST302.DisposeDetail;
import com.yonyou.hl7adapter.model.ST302.ST302;
import com.yonyou.hl7adapter.util.DateUtil;
import com.yonyou.service.MipMsgLogService;
import com.yonyou.service.OrderService;
import com.yonyou.service.PatientVisitService;
import com.yonyou.service.UhDcOrdMediService;
import com.yonyou.service.UhDcPvPresService;
import com.yonyou.util.Constant;
import com.yonyou.util.DateUtils;
import com.yonyou.util.ObjectUtils;

import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * 
 * 
 */
@Component(value = "ST302")
public class ST302Writer implements BaseProcessWriter<ST302> {

    private static Logger logger = LoggerFactory.getLogger("ST302Logger");

    @Autowired
    private OrderService orderService;
    @Autowired
    private PatientVisitService patientVisitService;
    @Autowired
	private UhDcPvPresService uhDcPvPresService;
    @Autowired
	private UhDcOrdMediService uhDcOrdMediService;
    
    @Autowired
    private MipMsgLogService msgLogService;

    private UhDcMipMsgLog mipMsgLog;

    private String msgId;

    private String tables;
    
    @Override
    public boolean validation(ST302 st302, Object reMsg) {
    	
        msgId = st302.getMsgId();

        if (StringUtils.isEmpty(msgId)) {
            logger.error("st302,msgId为空");
            return false;
        }

        mipMsgLog = msgLogService.getMsgLogByMsgId(msgId);
 
        if (ObjectUtils.isEmpty(st302.getPvInfo())||ObjectUtils.isEmpty(st302.getPvInfo().getPatient())) {
            msgLogService.saveMsgLog(CommonWriter.generateLog(mipMsgLog, null, MessageStatus.NULL_DTO));
            logger.error("ST301-{},患者信息获取失败，请检查xml格式", st302.getMsgId());
            return false;
        }
        return true;
    }
    @Override
    public boolean checkPre(ST302 st302) {
        return true;
    }
    @Override
    @Transactional
    public void businessWrite(ST302 st302) {
    	UhDcPv uhDcPv = patientVisitService.getUhDcPvByPvcode(st302.getPvInfo().getPvId());
    	if(null==uhDcPv){
    		logger.info("st302没有找到就诊记录：就诊号pvcode:"+st302.getPvInfo().getPvId());
            msgLogService.saveMsgLog(CommonWriter.generateLog(mipMsgLog, "没有此就诊信息", MessageStatus.DEPEND_NOT_EXIST));

    		return;
    	}
    	 st302.getPvInfo().getPatient().setEmpiId(uhDcPv.getEmpi());
    	
    	if("U".equals(st302.getActionType()) || "D".equals(st302.getActionType())){
    		List<String> presIds = new ArrayList<String>();
    		if(!"".equals(st302.getId())){
    			presIds.add(st302.getId());
    		}
    		if(presIds.size() > 0){
    			List<UhDcPvPres> lstUhDcPvPres = uhDcPvPresService.getUhDcPvPresListByPresNos(presIds);
    			List<UhDcOrd> lstUhDcOrd = orderService.getUhDcOrdListByPresNos(presIds);
    			List<String> uhDcOrdPks = new ArrayList<String>();
    			for(UhDcOrd uhDcOrd : lstUhDcOrd){
    				uhDcOrdPks.add(uhDcOrd.getPkDcord());
    			}
    			if(uhDcOrdPks.size() > 0){
    				List<UhDcOrdMedi> lstUhDcOrdMedi = uhDcOrdMediService.getUhDcOrdMediListByUhDcOrdPks(uhDcOrdPks);
    				tables+="UhDcOrdMedi";
    				uhDcOrdMediService.deleteUhDcOrdMediList(lstUhDcOrdMedi);
    			}
    			tables+="UhDcPvPres";
    			uhDcPvPresService.deleteUhDcPvPresList(lstUhDcPvPres);
    			orderService.deleteUhDcOrdList(lstUhDcOrd);
    			tables+="UhDcOrd";
    			  mipMsgLog.setBusinessTables(tables);
                  msgLogService.saveMsgLog(CommonWriter.generateLog(mipMsgLog, "pkPati：" + uhDcPv.getPkPati() + ",pkPvCode：" + uhDcPv.getPkDcpv(), MessageStatus.OK));
    		}else{
    			logger.info("st302消息没有处方号:"+st302.getId());
                msgLogService.saveMsgLog(CommonWriter.generateLog(mipMsgLog, "st302消息没有处方号", MessageStatus.NULL_FIELD));

    			return;
    		}
    		if("D".equals(st302.getActionType())){
    			return;
    		}
    	}
    	
    	
    	
    	UhDcPvPres uhDcPvPres = new UhDcPvPres();
		setUhDcPvPres(uhDcPvPres, st302);
		uhDcPvPres.setPkDcpv(uhDcPv.getPkDcpv());
		tables+="UhDcPvPres";
		uhDcPvPresService.saveUhDcPvPres(uhDcPvPres);
		
		List<UhDcOrd> lstUhDcOrd = new ArrayList<UhDcOrd>();
		List<DisposeDetail> lstDisposeDetail = st302.getDisposeDetail();
		for(DisposeDetail dd : lstDisposeDetail){
			UhDcOrd uhDcOrd = new UhDcOrd();
			setUhDcOrd(uhDcOrd, dd, st302);
			uhDcOrd.setPkDcpv(uhDcPv.getPkDcpv());
			lstUhDcOrd.add(uhDcOrd);
		}
		tables+="UhDcOrd";
		orderService.saveUhDcOrdList(lstUhDcOrd);
		mipMsgLog.setBusinessTables(tables);
        msgLogService.saveMsgLog(CommonWriter.generateLog(mipMsgLog, "pkPati：" + uhDcPv.getPkPati() + ",pkPvCode：" + uhDcPv.getPkDcpv(), MessageStatus.OK));

    }
    
	
	private void setUhDcOrd(UhDcOrd uhDcOrd, DisposeDetail dd, ST302 st302) {
		// TODO Auto-generated method stub
		uhDcOrd.setCodePres(st302.getId());
		uhDcOrd.setCodeOrd(dd.getId());
		uhDcOrd.setNoteOrd(st302.getRemark());
		
		uhDcOrd.setDateCreate(DateUtils.getDateStr2Str(st302.getAuthorTime()));
		uhDcOrd.setCodePsnPhy(st302.getAuthorCode());
		uhDcOrd.setNamePsnPhy(st302.getAuthorName());
		uhDcOrd.setCodeDetpPhy(st302.getAuthorOrgcode());
		uhDcOrd.setNameDeptPhy(st302.getAuthorOrgName());
		uhDcOrd.setCodePsnRec(st302.getTranscriberCode());
		uhDcOrd.setNamePsnRec(st302.getTranscriberName());
		
		uhDcOrd.setCodeOrditemType(dd.getItemTypeCode());
		uhDcOrd.setNameOrditemType(dd.getItemTypeName());
		uhDcOrd.setDateBegin(DateUtils.getDateStr2Str(dd.getStartTime()));
		uhDcOrd.setDateOrderEffe(DateUtils.getDateStr2Str(dd.getEndTime()));
		uhDcOrd.setCodeOrditem(dd.getItemCode());
		uhDcOrd.setNameOrditem(dd.getItemName());
		uhDcOrd.setDescOrd(dd.getItemName());
		uhDcOrd.setAmountSrv(new BigDecimal(dd.getMoneyTotal()));
		uhDcOrd.setAmountSelf(new BigDecimal(dd.getMoneySelf()));
		uhDcOrd.setCodeDeptExec(dd.getExecOrgCode());
		uhDcOrd.setNameDeptExec(dd.getExecOrgName());
		uhDcOrd.setOrdEntrust(dd.getEntrust());
		
		uhDcOrd.setCodeGroup(Constant.getGroupCode());
		uhDcOrd.setCodeOrg(Constant.getOrgCode());
		uhDcOrd.setEmpi(st302.getPvInfo().getPatient().getEmpiId());
		uhDcOrd.setCodePati(st302.getPvInfo().getPatient().getPatientId());
		uhDcOrd.setCodePvtype(st302.getPvInfo().getPvTypeCode());
		uhDcOrd.setNamePvtype(st302.getPvInfo().getPvTypeName());
		uhDcOrd.setPvcode(st302.getPvInfo().getPvId());
		uhDcOrd.setPatiname(st302.getPvInfo().getPatient().getPatientName());
		uhDcOrd.setCodeSex(st302.getPvInfo().getPatient().getGenderCode());
		uhDcOrd.setNameSex(st302.getPvInfo().getPatient().getGenderName());
		uhDcOrd.setBirthday(DateUtils.getDateStr2Str(st302.getPvInfo().getPatient().getBirthDate()));
		uhDcOrd.setCodeDept(st302.getPvInfo().getPatient().getOrgCode());
		uhDcOrd.setNameDept(st302.getPvInfo().getPatient().getOrgName());
		uhDcOrd.setCodeArea(st302.getPvInfo().getAreaCode());
		uhDcOrd.setNameArea(st302.getPvInfo().getAreaName());
		uhDcOrd.setDataSource(st302.getSenderId());
		uhDcOrd.setSourcePk(st302.getPvInfo().getPvId());
		uhDcOrd.setCreateTime(new Date());
		uhDcOrd.setEditTime(new Date());
		uhDcOrd.setFlagDel(0);
	}
	
	private void setUhDcPvPres(UhDcPvPres uhDcPvPres, ST302 st302) {
		// TODO Auto-generated method stub
		uhDcPvPres.setCodePres(st302.getId());
		uhDcPvPres.setCodePresType(st302.getOrderCategoryCode());
		uhDcPvPres.setNamePresType(st302.getOrderCategoryName());
		uhDcPvPres.setCodeOrdmediType(st302.getOrderTypeCode());
		uhDcPvPres.setNameOrdmediType(st302.getOrderTypeName());
		uhDcPvPres.setNote(st302.getRemark());
		uhDcPvPres.setDateCreate(st302.getAuthorTime());
		uhDcPvPres.setCodePsnPhy(st302.getAuthorCode());
		uhDcPvPres.setNamePsnPhy(st302.getAuthorName());
		uhDcPvPres.setCodeDetpPhy(st302.getAuthorOrgcode());
		uhDcPvPres.setNameDeptPhy(st302.getAuthorOrgName());
		uhDcPvPres.setCodePsnAudit(st302.getReviewerCode());
		uhDcPvPres.setNamePsnAudit(st302.getReviewerName());
		
		uhDcPvPres.setCodeGroup(Constant.getGroupCode());
		uhDcPvPres.setCodeOrg(Constant.getOrgCode());
		uhDcPvPres.setEmpi(st302.getPvInfo().getPatient().getEmpiId());
		uhDcPvPres.setCodePati(st302.getPvInfo().getPatient().getPatientId());
		uhDcPvPres.setCodePvtype(st302.getPvInfo().getPvTypeCode());
		uhDcPvPres.setNamePvtype(st302.getPvInfo().getPvTypeName());
		uhDcPvPres.setPvcode(st302.getPvInfo().getPvId());
		uhDcPvPres.setPatiname(st302.getPvInfo().getPatient().getPatientName());
		uhDcPvPres.setCodeSex(st302.getPvInfo().getPatient().getGenderCode());
		uhDcPvPres.setNameSex(st302.getPvInfo().getPatient().getGenderName());
		uhDcPvPres.setBirthday(DateUtils.getDateStr2Str(st302.getPvInfo().getPatient().getBirthDate()));
		uhDcPvPres.setDataSource(st302.getSenderId());
		uhDcPvPres.setSourcePk(st302.getPvInfo().getPvId());
		uhDcPvPres.setCreateTime(new Date());
		uhDcPvPres.setEditTime(new Date());
		uhDcPvPres.setFlagDel(0);
	}
}
