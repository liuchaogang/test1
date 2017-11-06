package com.yonyou.writer;

import com.yonyou.entity.UhDcPv;
import com.yonyou.entity.UhDcPvDiag;
import com.yonyou.entity.UhDcPvInp;
import com.yonyou.entity.UhDcPvOutp;
import com.yonyou.hl7adapter.model.ST201.ST201;
import com.yonyou.hl7adapter.model.ST203.Diagnosis;
import com.yonyou.hl7adapter.model.ST203.ST203;
import com.yonyou.hl7adapter.model.ST204.ST204;
import com.yonyou.hl7adapter.model.ST205.ST205;
import com.yonyou.util.DateUtils;
import com.yonyou.util.ObjectUtils;

import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * The type Visit convertor.
 *
 * @author chenpana @yonyou.com
 * @ClassName: VisitConvertor
 * @Description:
 * @date 2017 /6/30 11:39
 */
@Component
public class VisitConvertor {


    /**
     * Gets uh dc pv.
     *
     * @param st201       the st 201
     * @param empiId      the empi id
     * @param pkPati      the pk pati
     * @param currentTime the current time
     * @param uhDcPvDB    the uh dc pv db
     * @return the uh dc pv
     */
    public static UhDcPv getUhDcPv(ST201 st201, String empiId, String pkPati, Date currentTime, UhDcPv uhDcPvDB) {

        UhDcPv uhDcPv = new UhDcPv();

        if(ObjectUtils.isNotEmpty(uhDcPvDB)){
            uhDcPv.setPkDcpv(uhDcPvDB.getPkDcpv());

            uhDcPv.setEditTime(currentTime);
            uhDcPv.setCreateTime(uhDcPvDB.getCreateTime());
        }else{
            uhDcPv.setCreateTime(currentTime);
        }

        uhDcPv.setEmpi(empiId);
        uhDcPv.setCodeGroup(st201.getPatient().getGroupCode());
        uhDcPv.setCodeOrg(st201.getPatient().getOrgCode());
        uhDcPv.setPkPati(pkPati);
        uhDcPv.setCodePati(st201.getPatient().getPatientId());
        uhDcPv.setPvcode(st201.getVisitId());
        uhDcPv.setCodePvtype(st201.getVisitTypeCode());
        uhDcPv.setNamePvtype(st201.getVisitTypeName());
        uhDcPv.setInterid(st201.getVisitId());
        String visitTimes = st201.getVisitTimes();
        if(ObjectUtils.isNotEmpty(visitTimes)){
        	uhDcPv.setPvTimes(Integer.parseInt(visitTimes));
        }
        

        //患者信息
        uhDcPv.setPatiname(st201.getPatient().getPatientName());
        uhDcPv.setCodeSex(st201.getPatient().getGenderCode());
        uhDcPv.setNameSex(st201.getPatient().getGenderName());
        uhDcPv.setBirthday(DateUtils.getDateStr2Str(st201.getPatient().getBirthDate()));
        uhDcPv.setCodeMari(null);
        uhDcPv.setNameMari(null);

        uhDcPv.setCodePsnRegi(st201.getRegistrantCode());
        uhDcPv.setNamePsnRegi(st201.getRegistrantName());
        uhDcPv.setDateRegi(DateUtils.getDateStr2Str(st201.getRegisterTime()));

        uhDcPv.setFlagCanc("0");
        uhDcPv.setPvReason(st201.getVisitReason());

        uhDcPv.setCodePsnTre(st201.getVisitDoctorCode());
        uhDcPv.setNamePsnTre(st201.getVisitDoctorName());
        uhDcPv.setDateBegin(DateUtils.getDateStr2Str(st201.getVisitTime()));
        uhDcPv.setDeptPhyCode(st201.getVisitDeptCode());
        uhDcPv.setDeptPhyName(st201.getVisitDeptName());

        uhDcPv.setHpCode(st201.getInsuranceTypeCode());
        uhDcPv.setHpName(st201.getInsuranceTypeName());

        uhDcPv.setFlagDel("0");

        return uhDcPv;
    }

    /**
     * Gets uh dc pv outp.
     *
     * @param st201       the st 201
     * @param empiId      the empi id
     * @param pkPati      the pk pati
     * @param currentTime the current time
     * @param uhDcPvDB    the uh dc pv db
     * @return the uh dc pv outp
     */
    public static UhDcPvOutp getUhDcPvOutp(ST201 st201, String empiId, String pkPati, Date currentTime, UhDcPv uhDcPvDB) {

        UhDcPvOutp uhDcPvOutp = new UhDcPvOutp();

        if(ObjectUtils.isNotEmpty(uhDcPvDB)){
            uhDcPvOutp.setPkDcpv(uhDcPvDB.getPkDcpv());

            uhDcPvOutp.setEditTime(currentTime);
            uhDcPvOutp.setCreateTime(uhDcPvDB.getCreateTime());
        }else{
            uhDcPvOutp.setCreateTime(currentTime);
        }

        
        uhDcPvOutp.setCodeGroup(st201.getPatient().getGroupCode());
        uhDcPvOutp.setCodeOrg(st201.getPatient().getOrgCode());

        uhDcPvOutp.setCodePati(st201.getPatient().getPatientId());
        uhDcPvOutp.setPvcode(st201.getVisitId());
        uhDcPvOutp.setCodePvtype(st201.getVisitTypeCode());
        uhDcPvOutp.setNamePvtype(st201.getVisitTypeName());
        uhDcPvOutp.setInterid(st201.getVisitId());

        uhDcPvOutp.setDtSrvtype(st201.getRegistrationTypeCode());
        uhDcPvOutp.setNameSrvtype(st201.getRegistrationTypeName());

        uhDcPvOutp.setCodePsnReg(st201.getVisitDoctorCode());
        uhDcPvOutp.setNamePsnReg(st201.getVisitDoctorName());
        uhDcPvOutp.setCodePsn(st201.getRegistrantCode());
        uhDcPvOutp.setNamePsn(st201.getRegistrantName());

        uhDcPvOutp.setFlagFirst(st201.getReturnVisitFlag());

        uhDcPvOutp.setFlagDel("0");

        return uhDcPvOutp;
    }
 
    
    public static UhDcPvInp getUhDcPvInp(ST203 st203, String empiId, String pkPati, Date currentTime, UhDcPv uhDcPvDB) {

        UhDcPvInp uhDcPvInp = new UhDcPvInp();

        if(uhDcPvDB!=null){
        	uhDcPvInp.setPkDcpv(uhDcPvDB.getPkDcpv());

        	uhDcPvInp.setEditTime(currentTime);
        	uhDcPvInp.setCreateTime(uhDcPvDB.getCreateTime());
        }else{
        	uhDcPvInp.setCreateTime(currentTime);
        }

        uhDcPvInp.setEmpi(empiId);
        uhDcPvInp.setPvIpRefmode(st203.getInhospitalWayCode());
        uhDcPvInp.setPvIpRefmodeName(st203.getInhospitalWayName());
        uhDcPvInp.setCodeGroup(st203.getGroupCode());
        uhDcPvInp.setCodeOrg(st203.getOrgCode());

        uhDcPvInp.setCodeChiefPsn(st203.getChiefPhysicianCode());
        uhDcPvInp.setNameChiefPsn(st203.getChiefPhysicianName());
        uhDcPvInp.setCodeBedPsn(st203.getResidentPhysicianCode());
        uhDcPvInp.setNameBedPsn(st203.getResidentPhysicianName());

        uhDcPvInp.setDeptPhyAdm(st203.getDepartmentNo());
        uhDcPvInp.setDeptPhyAdmName(st203.getDepartmentName());
        uhDcPvInp.setDeptNurseAdm(st203.getInpatientAreaNo());
        uhDcPvInp.setDeptNurseAdmName(st203.getInpatientAreaName());
        uhDcPvInp.setPvcode(st203.getVisitNo());

        uhDcPvInp.setFlagDel(0);

        return uhDcPvInp;
    }
    public static List<UhDcPvDiag> getUhDcPvDiag(ST203 st203, String empiId, String pkPati, Date currentTime, UhDcPv uhDcPvDB) {

        List<Diagnosis> diagnosis = st203.getDiagnosis();

        List<UhDcPvDiag> pDiagnosis = null;
        
    	if (diagnosis != null && !diagnosis.isEmpty()) {
    		pDiagnosis = new ArrayList<>();

    		String diagTypeCode = null;
    		String diagTypeName = null;
    		String diagCode = null;
    		String diagName = null;

    		for (Diagnosis diag : diagnosis) {

    			diagTypeCode = diag.getDiagTypeCode();
    			diagTypeName = diag.getDiagTypeName();
    			diagCode=diag.getDiagCode();
    			diagName=diag.getDiagName();
    				
    			if(StringUtils.isEmpty(diagCode)|| StringUtils.isEmpty(diagName)){
    				continue;
    			}
    			
    			UhDcPvDiag pDiag = new UhDcPvDiag();

    			pDiag.setCodeDiagtype(diagTypeCode);
    			pDiag.setNameDiagtype(diagTypeName);
    			pDiag.setCodeDiag(diagCode);
    			pDiag.setNameDiag(diagName);
    			pDiag.setCreateTime(currentTime);
    			pDiag.setFlagDel(0);
    			
    			pDiag.setCodeGroup(st203.getGroupCode());
    			pDiag.setCodeOrg(st203.getOrgCode());
    	      
    			pDiag.setCodePati(st203.getPidCode());
    			pDiag.setEmpi(empiId);
    			pDiag.setCodePvtype(st203.getPatientTypeCode());
    			pDiag.setNamePvtype(st203.getPatientTypeName());

    			pDiagnosis.add(pDiag);
    		}
    	}
        

  //      uhDcPvOutp.setFlagDel("0");

        return pDiagnosis;
    }
    
    public static UhDcPv getUhDcPv(ST203 st203, String empiId, String pkPati, Date currentTime, UhDcPv uhDcPvDB) {

        UhDcPv uhDcPv = new UhDcPv();

        if(uhDcPvDB!=null){
            uhDcPv.setPkDcpv(uhDcPvDB.getPkDcpv());

            uhDcPv.setEditTime(currentTime);
            uhDcPv.setCreateTime(uhDcPvDB.getCreateTime());
        }else{
            uhDcPv.setCreateTime(currentTime);
        }

        uhDcPv.setEmpi(empiId);
        uhDcPv.setCodeGroup(st203.getGroupCode());
        uhDcPv.setCodeOrg(st203.getOrgCode());
        uhDcPv.setPkPati(pkPati);
        uhDcPv.setCodePati(st203.getPidCode());
        uhDcPv.setPvcode(st203.getVisitNo());
        uhDcPv.setCodePvtype(st203.getPatientTypeCode());
        uhDcPv.setNamePvtype(st203.getPatientTypeName());
        uhDcPv.setInterid(st203.getVisitNo());
        
        String visitTimes=st203.getVisitTimes();
        
        if(ObjectUtils.isNotEmpty(visitTimes)){
        	uhDcPv.setPvTimes(Integer.parseInt(visitTimes));
        }
        

        //患者信息
        uhDcPv.setPatiname(st203.getPatientName());
        uhDcPv.setCodeSex(st203.getPatientSexCode());
        uhDcPv.setNameSex(st203.getPatientSexName());
        uhDcPv.setBirthday(DateUtils.getDateStr2Str(st203.getPatientBirthTime()));

        uhDcPv.setCodePsnRegi(st203.getRegistrantCode());
        uhDcPv.setNamePsnRegi(st203.getRegistrantName());
        uhDcPv.setDateRegi(DateUtils.getDateStr2Str(st203.getRegistrationTime()));

        uhDcPv.setFlagCanc("0");
        uhDcPv.setPvReason(st203.getVisitReason());

        uhDcPv.setCodePsnPhy(st203.getChargeDoctorCode());
        uhDcPv.setNamePsnPhy(st203.getChargeDoctorName());
        uhDcPv.setCodePsnNs(st203.getPrimaryNurseCode());
        uhDcPv.setNamePsnNs(st203.getPrimaryNurseName());
        uhDcPv.setCodePsnTre(st203.getFirstDoctorCode());
        uhDcPv.setNamePsnTre(st203.getFirstDoctorName());
        uhDcPv.setDateBegin(st203.getFirstDoctorTime());
        uhDcPv.setRoom(st203.getSickroomNo());
        uhDcPv.setBed(st203.getSickbedNo());
        uhDcPv.setDeptPhyCode(st203.getDepartmentNo());
        uhDcPv.setDeptPhyName(st203.getDepartmentName());
        uhDcPv.setAreaPhyCode(st203.getInpatientAreaNo());
        uhDcPv.setAreaPhyName(st203.getInpatientAreaName());
        uhDcPv.setPvcode(st203.getVisitNo());

        uhDcPv.setHpCode(st203.getMedicalInsuranceTypeCode());
        uhDcPv.setHpName(st203.getMedicalInsuranceTypeName());

        uhDcPv.setFlagDel("0");

        return uhDcPv;
    }
    public static UhDcPv getUhDcPv(ST204 st204, String empiId, String pkPati, Date currentTime, UhDcPv uhDcPvDB) {

        UhDcPv uhDcPv = new UhDcPv();

        if(uhDcPvDB!=null){
            uhDcPv.setPkDcpv(uhDcPvDB.getPkDcpv());

            uhDcPv.setEditTime(currentTime);
            uhDcPv.setCreateTime(uhDcPvDB.getCreateTime());
        }else{
            uhDcPv.setCreateTime(currentTime);
        }

        uhDcPv.setEmpi(empiId);
        uhDcPv.setCodeGroup(st204.getGroupCode());
        uhDcPv.setCodeOrg(st204.getOrgCode());
        uhDcPv.setPkPati(pkPati);
        uhDcPv.setCodePati(st204.getPidCode());
        uhDcPv.setPvcode(st204.getVisitNo());
        uhDcPv.setCodePvtype(st204.getPatientTypeCode());
        uhDcPv.setNamePvtype(st204.getPatientTypeName());
        uhDcPv.setInterid(st204.getVisitNo());
        uhDcPv.setPvTimes(Integer.parseInt(st204.getVisitTimes()));

        //患者信息
        uhDcPv.setPatiname(st204.getPatientName());
        uhDcPv.setCodeSex(st204.getPatientSexCode());
        uhDcPv.setNameSex(st204.getPatientSexName());
        uhDcPv.setBirthday(st204.getPatientBirthTime());

        uhDcPv.setCodePsnRegi(st204.getRegistrantCode());
        uhDcPv.setNamePsnRegi(st204.getRegistrantName());
        uhDcPv.setDateRegi(st204.getRegistrationTime());

        uhDcPv.setFlagCanc("0");
        uhDcPv.setPvReason(st204.getVisitReason());

        uhDcPv.setCodePsnPhy(st204.getChargeDoctorCode());
        uhDcPv.setNamePsnPhy(st204.getChargeDoctorName());
        uhDcPv.setCodePsnNs(st204.getPrimaryNurseCode());
        uhDcPv.setNamePsnNs(st204.getPrimaryNurseName());

        uhDcPv.setRoom(st204.getSickroomNo());
        uhDcPv.setBed(st204.getSickbedNo());
        uhDcPv.setDeptPhyCode(st204.getDepartmentNo());
        uhDcPv.setDeptPhyName(st204.getDepartmentName());
        uhDcPv.setAreaPhyCode(st204.getInpatientAreaNo());
        uhDcPv.setAreaPhyName(st204.getInpatientAreaName());
        uhDcPv.setPvcode(st204.getVisitNo());


        uhDcPv.setFlagDel("0");

        return uhDcPv;
    }
    public static UhDcPv getUhDcPv(ST205 st205, String empiId, String pkPati, Date currentTime, UhDcPv uhDcPvDB) {

        UhDcPv uhDcPv = new UhDcPv();

        if(uhDcPvDB!=null){
            uhDcPv.setPkDcpv(uhDcPvDB.getPkDcpv());

            uhDcPv.setEditTime(currentTime);
            uhDcPv.setCreateTime(uhDcPvDB.getCreateTime());
        }else{
            uhDcPv.setCreateTime(currentTime);
        }

        uhDcPv.setEmpi(empiId);
        uhDcPv.setCodeGroup(st205.getGroupCode());
        uhDcPv.setCodeOrg(st205.getOrgCode());
        uhDcPv.setPkPati(pkPati);
        uhDcPv.setCodePati(st205.getPidCode());
        uhDcPv.setPvcode(st205.getVisitNo());
        uhDcPv.setCodePvtype(st205.getPatientTypeCode());
        uhDcPv.setNamePvtype(st205.getPatientTypeName());
        uhDcPv.setInterid(st205.getVisitNo());
        uhDcPv.setPvTimes(Integer.parseInt(st205.getVisitTimes()));

        //患者信息
        uhDcPv.setPatiname(st205.getPatientName());
        uhDcPv.setCodeSex(st205.getPatientSexCode());
        uhDcPv.setNameSex(st205.getPatientSexName());
        uhDcPv.setBirthday(st205.getPatientBirthTime());

        //uhDcPv.setCodePsnRegi(st205.getRegistrantCode());
        //uhDcPv.setNamePsnRegi(st205.getRegistrantName());
        uhDcPv.setDateRegi(st205.getRegistrationTime());

        uhDcPv.setFlagCanc("0");
        //uhDcPv.setPvReason(st205.getVisitReason());

        //uhDcPv.setCodePsnPhy(st205.getChargeDoctorCode());
        //uhDcPv.setNamePsnPhy(st205.getChargeDoctorName());
        //uhDcPv.setCodePsnNs(st205.getPrimaryNurseCode());
        //uhDcPv.setNamePsnNs(st205.getPrimaryNurseName());

        uhDcPv.setRoom(st205.getSickroomNo());
        uhDcPv.setBed(st205.getSickbedNo());
        uhDcPv.setDeptPhyCode(st205.getDepartmentNo());
        uhDcPv.setDeptPhyName(st205.getDepartmentName());
        uhDcPv.setAreaPhyCode(st205.getInpatientAreaNo());
        uhDcPv.setAreaPhyName(st205.getInpatientAreaName());
        uhDcPv.setPvcode(st205.getVisitNo());


        //uhDcPv.setFlagDel("0");

        return uhDcPv;
    }
    	
}
