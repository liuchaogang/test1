package com.yonyou.writer;

 
import java.util.Date;
 

import com.yonyou.entity.UhDcPv;
import com.yonyou.entity.UhDcTransDept;
 
import com.yonyou.hl7adapter.model.ST204.ST204;
import com.yonyou.hl7adapter.model.ST205.ST205;
import com.yonyou.hl7adapter.model.ST206.ST206;
import com.yonyou.hl7adapter.model.ST207.ST207;
import com.yonyou.util.Constant;
import com.yonyou.util.DateUtils;

public class UhDcTransDeptConvertor {
	
	public static UhDcTransDept getUhDcTransDeptForST204(ST204 st,UhDcPv uhDcPv,String type){
		UhDcTransDept uh=new UhDcTransDept();
		/////////////////////////////////////////////////////////////////////////////////////////////
		if(uhDcPv!=null)
		uh.setPkDcpv(uhDcPv.getPkDcpv());
	    uh.setPvcode(st.getVisitNo());
		uh.setCodePvtype(st.getPatientTypeCode());
	    uh.setNamePvtype(st.getPatientTypeName());
		//登記時間/出科時間
		uh.setDateIn(st.getRegistrationTime());
		uh.setEmpi(st.getEMPINo());
		//uh.setPkDcpv(st.getVisitNo());
	    uh.setCodePati(st.getPidCode());
	    uh.setPatiname(st.getPatientName());
	    uh.setCodeSex(st.getPatientSexName());
	    uh.setNameSex(st.getPatientSexCode());
	    uh.setBirthday(st.getPatientBirthTime());
	    uh.setCodeGroup(st.getGroupCode());
		uh.setCodeOrg(st.getOrgCode());
	    uh.setBedNoIn(st.getSickbedNo());
		uh.setWardNoIn(st.getSickroomNo());
		uh.setCodeDeptIn(st.getDepartmentNo());
		uh.setNameDeptIn(st.getDepartmentName());
		uh.setNameAreaIn(st.getInpatientAreaName());
		uh.setCodeAreaIn(st.getInpatientAreaNo());
	    uh.setCreateTime(new Date());
	    uh.setEditTime(new Date());
		uh.setFlagDel(0);
		uh.setTransType(Constant.getTransTypeName(type));
		return uh;
	}
	
	public static UhDcTransDept getUhDcTransDeptForST205(ST205 st,UhDcPv uhDcPv,String type){
		UhDcTransDept uh=new UhDcTransDept();
		if(uhDcPv!=null)
		uh.setPkDcpv(uhDcPv.getPkDcpv());
				    
	    uh.setPvcode(st.getVisitNo());
	    uh.setCodePvtype(st.getPatientTypeCode());
	    uh.setNamePvtype(st.getPatientTypeName());		    
	    uh.setDateOut(st.getRegistrationTime());
	    uh.setEmpi(st.getEMPINo());
	    uh.setCodePati(st.getPidCode());

	    uh.setPatiname(st.getPatientName());
	    uh.setCodeSex(st.getPatientSexName());
	    uh.setNameSex(st.getPatientSexCode());
	    uh.setBirthday(st.getPatientBirthTime());

	    uh.setCodeOrg(st.getOrgCode());
	    uh.setCodeGroup(st.getGroupCode());	    
	    uh.setCodePsnOp(st.getOutDepartmentCode());
	    uh.setNamePsnOp(st.getOutDepartmentName());		
	    uh.setBedNoOut(st.getSickbedNo());
		uh.setWardNoOut(st.getSickroomNo());
		uh.setCodeDeptOut(st.getDepartmentNo());
		uh.setNameDeptOut(st.getDepartmentName());
		uh.setNameAreaOut(st.getInpatientAreaName());
		uh.setCodeAreaOut(st.getInpatientAreaNo());
	    uh.setCreateTime(new Date());
	    uh.setEditTime(new Date());
		uh.setFlagDel(0);	
		uh.setTransType(Constant.getTransTypeName(type));
        
		return uh;
	}
	  
 
	
	public static UhDcTransDept getUhDcTransDeptForST206(ST206 st,String pkDcPv){
		
		UhDcTransDept uh=new UhDcTransDept();
		uh.setCodeGroup(st.getPatient().getGroupCode());
		uh.setCodeOrg(st.getPatient().getOrgCode());
		uh.setEmpi(st.getPatient().getEmpiId());
		uh.setPkDcpv(pkDcPv);
	    uh.setCodePati(st.getPatient().getPatientId());
		uh.setCodePvtype(st.getVisitTypeCode());
		uh.setNamePvtype(st.getVisitTypeName());
		uh.setDateIn(DateUtils.getDateStr2Str(st.getIntoTime()));
		uh.setBedNoIn(st.getIntoBedNo());
		uh.setWardNoIn(st.getIntoRoomNo());
		uh.setCodeDeptIn(st.getIntoDeptCode());
		uh.setNameDeptIn(st.getIntoDeptName());
		uh.setNameAreaIn(st.getIntoAreatName());
		uh.setCodeAreaIn(st.getIntoAreaCode());
		uh.setCodeDeptOut(st.getOriginalDeptCode());
		uh.setNameDeptOut(st.getOriginalDeptName());
		uh.setCodeAreaOut(st.getOriginalAreaCode());
		uh.setNameAreaOut(st.getOriginalAreatName());
		uh.setBedNoOut(st.getOriginalBedNo());
		uh.setWardNoOut(st.getOriginalRoomNo());
	    uh.setCreateTime(new Date());
	    uh.setEditTime(new Date());
		uh.setFlagDel(0);
		return uh;
	}

	public static UhDcTransDept getUhDcTransDeptForST207(ST207 st,String pkDcPv){
		UhDcTransDept uh=new UhDcTransDept();
		
		uh.setCodeGroup(st.getPatient().getGroupCode());
		uh.setCodeOrg(st.getPatient().getOrgCode());
		uh.setEmpi(st.getPatient().getEmpiId());
		uh.setPkDcpv(pkDcPv);
	    uh.setCodePati(st.getPatient().getPatientId());
		uh.setCodePvtype(st.getVisitTypeCode());
		uh.setNamePvtype(st.getVisitTypeName());	
		uh.setDateIn(DateUtils.getDateStr2Str(st.getDistributeTime()));
		uh.setDocCodeIn(st.getNowDoctorNo());
		uh.setDocNameIn(st.getNowDoctorName());
        uh.setDocCodeOut(st.getOriginalDoctorNo());
        uh.setDocNameOut(st.getNowDoctorName());
	    uh.setCreateTime(new Date());
	    uh.setEditTime(new Date());
		uh.setFlagDel(0);
		return uh;
	}
}
