package com.yonyou.service;

import java.util.List;

import com.yonyou.entity.UhDcPv;
import com.yonyou.entity.UhDcPvDiag;
import com.yonyou.entity.UhDcPvInp;
import com.yonyou.entity.UhDcPvOutp;
import com.yonyou.entity.UhDcTransDept;

/**
 * The interface Patient visit service.
 *
 * @author chenpana @yonyou.com
 * @ClassName: PatientVisitService
 * @Description:
 * @date 2017 /6/30 11:40
 */
public interface PatientVisitService {

    /**
     * Gets uh dc pv by patient visit info.
     *
     * @param patientId     the patient id
     * @param visitId       the visit id
     * @param visitTimes    the visit times
     * @param visitTypeCode the visit type code
     * @param groupCode     the group code
     * @param orgCode       the org code
     * @return the uh dc pv by patient visit info
     */
    UhDcPv getUhDcPv(String patientId,
                                       String visitId,
                                       String visitTimes,
                                       String visitTypeCode,
                                       String groupCode,
                                       String orgCode);

    /**
     * Cancel uh dc pv.
     *
     * @param pkDcpv         the pk dcpv
     * @param registerTime   the register time
     * @param registrantCode the registrant code
     * @param registrantName the registrant name
     * @param groupCode      the group code
     * @param orgCode        the org code
     */
    void CancelUhDcPv(String pkDcpv, String registerTime, String registrantCode, String registrantName, String groupCode, String orgCode);

    /**
     * Cancel uh dc pv.
     *
     * @param uhDcPvDB       the uh dc pv db
     * @param registerTime   the register time
     * @param registrantCode the registrant code
     * @param registrantName the registrant name
     */
    void CancelUhDcPv(UhDcPv uhDcPvDB, String registerTime, String registrantCode, String registrantName);

    /**
     * Save or update.
     *
     * @param uhDcPv     the uh dc pv
     * @param uhDcPvOutp the uh dc pv outp
     * @return 
     */
    UhDcPv saveOrUpdate(UhDcPv uhDcPv, UhDcPvOutp uhDcPvOutp);

    public  void updateUhDcPvDateEnd(String pkDcpv,String leaveDate); 

    
    UhDcPv saveOrUpdateInpInformation(UhDcPv uhDcPv, UhDcPvInp uhDcPvInp, List<UhDcPvDiag> uhDcPvDiags);

	UhDcPv getUhDcPvByPvcode(String pvCode);
	
	void saveOrUpdateTransDept(UhDcTransDept transdept);

	void saveOrUpdateDcPvAndTransDept(UhDcPv uhDcPv, UhDcTransDept transdept);
	    

    


}
