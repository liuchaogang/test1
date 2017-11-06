package com.yonyou.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.yonyou.dao.UhDcPvDao;
import com.yonyou.dao.UhDcPvDiagDao;
import com.yonyou.dao.UhDcPvInpDao;
import com.yonyou.dao.UhDcPvOutpDao;
import com.yonyou.dao.UhDcTransDeptDao;
import com.yonyou.entity.UhDcPv;
import com.yonyou.entity.UhDcPvDiag;
import com.yonyou.entity.UhDcPvInp;
import com.yonyou.entity.UhDcPvOutp;
import com.yonyou.entity.UhDcTransDept;
import com.yonyou.service.PatientVisitService;
import com.yonyou.util.DateUtils;

/**
 * @author chenpana@yonyou.com
 * @ClassName: PatientVisitServiceImpl
 * @Description:
 * @date 2017/6/30 11:40
 */

@Service
public class PatientVisitServiceImpl implements PatientVisitService {

    @Autowired
    private UhDcPvDao uhDcPvDao;

    @Autowired
    private UhDcPvOutpDao uhDcPvOutpDao;

    @Autowired
    private UhDcPvInpDao uhDcPvInpDao;

    @Autowired
    private UhDcPvDiagDao uhDcPvDiagDao;

    @Autowired
    private UhDcTransDeptDao uhDcTransDeptDao;

    @Override
    public UhDcPv getUhDcPv(String patientId, String visitId, String visitTimes, String visitTypeCode, String groupCode, String orgCode) {

        return uhDcPvDao.getUhDcPvByVisitInfo(patientId, visitId, Integer.parseInt(visitTimes), visitTypeCode, groupCode, orgCode);
    }


    @Override
    public void CancelUhDcPv(String pkDcpv, String registerTime, String registrantCode, String registrantName, String groupCode, String orgCode) {
        uhDcPvDao.updateUhDcPv(pkDcpv, registerTime, registrantCode, registrantName);
    }

    @Override
    public void CancelUhDcPv(UhDcPv uhDcPvDB, String registerTime, String registrantCode, String registrantName) {
        uhDcPvDB.setFlagCanc("1");
        uhDcPvDB.setDateCanc(DateUtils.getDateTimeFormat(registerTime));
        uhDcPvDB.setCodePsnCanc(registrantCode);
        uhDcPvDB.setNamePsnCanc(registrantName);

        uhDcPvDao.save(uhDcPvDB);
    }

    @Override
    @Transactional
    public UhDcPv saveOrUpdate(UhDcPv uhDcPv, UhDcPvOutp uhDcPvOutp) {
        uhDcPv = uhDcPvDao.saveAndFlush(uhDcPv);

        uhDcPvOutp.setPkDcpv(uhDcPv.getPkDcpv());
        UhDcPvOutp uhDcPvOutpDB = uhDcPvOutpDao.findByPkDcpv(uhDcPv.getPkDcpv());
        if (uhDcPvOutpDB != null) {
            uhDcPvOutp.setPkOutpv(uhDcPvOutpDB.getPkOutpv());
        }
        uhDcPvOutpDao.save(uhDcPvOutp);
        
        return uhDcPv;
    }


    @Override
    @Transactional
    public void updateUhDcPvDateEnd(String pkDcpv, String leaveDate) {
        uhDcPvDao.updateUhDcPvDateEnd(pkDcpv, leaveDate);

    }


    @Override
    public UhDcPv saveOrUpdateInpInformation(UhDcPv uhDcPv, UhDcPvInp uhDcPvInp, List<UhDcPvDiag> diags) {
        // TODO Auto-generated method stub
        //保存就诊表
        uhDcPv = uhDcPvDao.saveAndFlush(uhDcPv);

        //取主键
        uhDcPvInp.setPkDcpv(uhDcPv.getPkDcpv());
        //通过就诊表的主键查找住院表里的记录
        UhDcPvInp uhDcPvInpDB = uhDcPvInpDao.findByPkDcpv(uhDcPv.getPkDcpv());
        if (uhDcPvInpDB != null) {
            uhDcPvInp.setPkInpv(uhDcPvInpDB.getPkInpv());
        }
        uhDcPvInpDao.save(uhDcPvInp);

        //給每條診斷記錄賦值就診主鍵
        if (diags != null) {
            for (UhDcPvDiag diag : diags) {
                diag.setPkDcpv(uhDcPv.getPkDcpv());
            }
            uhDcPvDiagDao.save(diags);
        }
        
        return uhDcPv;

    }

    public void saveOrUpdateDiag(UhDcPvDiag uhDcPvDiag) {
        // TODO Auto-generated method stub
        //保存就诊表
        uhDcPvDiag = uhDcPvDiagDao.save(uhDcPvDiag);

    }


    @Override
    public UhDcPv getUhDcPvByPvcode(String pvCode) {

        return uhDcPvDao.getUhDcPvByPvcode(pvCode);
    }

    @Override
    public void saveOrUpdateTransDept(UhDcTransDept transdept) {
        uhDcTransDeptDao.save(transdept);
    }


    @Override
    public void saveOrUpdateDcPvAndTransDept(UhDcPv uhDcPv,
                                             UhDcTransDept transdept) {
        // TODO Auto-generated method stub

        uhDcPv = uhDcPvDao.saveAndFlush(uhDcPv);
        transdept.setPkDcpv(uhDcPv.getPkDcpv());
        uhDcTransDeptDao.saveAndFlush(transdept);
    }


}
