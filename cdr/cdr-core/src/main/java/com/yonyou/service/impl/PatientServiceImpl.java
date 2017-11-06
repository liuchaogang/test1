package com.yonyou.service.impl;

import com.yonyou.dao.*;
import com.yonyou.entity.*;
import com.yonyou.service.PatientService;
import com.yonyou.util.Constant;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author chenpana@yonyou.com
 * @ClassName: PatientServiceImpl
 * @Description:
 * @date 2017/6/28 15:07
 */
@Service
public class PatientServiceImpl implements PatientService {


    @Autowired
    private PatientCrossIndexDao patientCrossIndexDao;

    @Autowired
    private PatientDao patientDao;

    @Autowired
    private PatientAddressDao patientAddressDao;

    @Autowired
    private PatientCardDao patientCardDao;

    @Autowired
    private PatientLinkManDao patientLinkManDao;

    @Override
    public UhDcPiCrossIndex getUhPiCrossIndex(String patientId, String localTypeCode, String groupCode, String orgCode) {

        return patientCrossIndexDao.findPiCrossIndex(patientId, localTypeCode, groupCode, orgCode);
    }

    @Override
    public UhDcPiCrossIndex saveUhPiCrossIndex(UhDcPiCrossIndex uhDcPiCrossIndex) {

        return patientCrossIndexDao.save(uhDcPiCrossIndex);
    }

    @Override
    @Transactional
    public void savePatientInfo(UhDcPi uhDcPi, List<UhDcPiCard> piCards, List<UhDcPiAddress> piAddresses, List<UhDcPiLinkman> linkmen) {
 
        UhDcPi dcPi = patientDao.saveAndFlush(uhDcPi);
        if (piCards != null && !piCards.isEmpty())
            patientCardDao.save(piCards);
        if (piAddresses != null && !piAddresses.isEmpty())
            patientAddressDao.save(piAddresses);
        if (linkmen != null && !linkmen.isEmpty())
            patientLinkManDao.save(linkmen);
    }

    @Override
    public UhDcPi savePatientInfo(UhDcPi uhDcPi) {
        UhDcPi dcPi = patientDao.saveAndFlush(uhDcPi);
        return dcPi;
    }

    @Override
    @Transactional
    public void savePatientInfo(List<UhDcPiCard> piCards, List<UhDcPiAddress> piAddresses, List<UhDcPiLinkman> linkmen) {
        if (piCards != null && !piCards.isEmpty())
            patientCardDao.save(piCards);
        if (piAddresses != null && !piAddresses.isEmpty())
            patientAddressDao.save(piAddresses);
        if (linkmen != null && !linkmen.isEmpty())
            patientLinkManDao.save(linkmen);

    }

    @Override
    public UhDcPi getUhDcPi(String empiId, String groupCode, String orgCode) {
        return patientDao.findUhDCPi(empiId, groupCode, orgCode);
    }

    @Override
    public UhDcPi getUhDcPiByCrossIndex(String patientId, String localTypeCode, String groupCode, String orgCode) {
        UhDcPi dcPi = patientDao.findUhDCPiJoinCrossIndex(patientId, localTypeCode, groupCode, orgCode);

        return dcPi;
    }

    @Override
    public UhDcPi getTmpUhDcPi(String empiId, String patientId, String localTypeCode, String groupCode, String orgCode) {
        return patientDao.findUhDCPi(empiId, patientId, localTypeCode, groupCode, orgCode);
    }

    @Override
    @Transactional
    public void updateOldPiInfo(List<String> oldPkPiLists, String pkPati, String empiId) {
        if (oldPkPiLists != null && !oldPkPiLists.isEmpty()) {
            for (String oldPkPati : oldPkPiLists) {
                patientAddressDao.deleteByPkPati(oldPkPati);
                patientCardDao.deleteByPkPati(oldPkPati);
                patientLinkManDao.deleteByPkPati(oldPkPati);

                //更新关联业务表empi和pkPati
                //由于不确定表名和数量，故采用在存储过程中实现
                patientDao.updateEmpiAndPkpiAll(empiId, pkPati, oldPkPati);
            }
        }
    }

    @Override
    public UhDcPi getUhDcPi(String empiId) {
        return patientDao.findByEmpi(empiId);
    }

    @Override
    @Transactional
    public void delPatientAll(UhDcPi uhDcPi) {

        if (uhDcPi != null) {
            //删除地址
            patientAddressDao.deleteByPkPati(uhDcPi.getPkPati());
            //删除证件
            patientCardDao.deleteByPkPati(uhDcPi.getPkPati());
            //联系人
            patientLinkManDao.deleteByPkPati(uhDcPi.getPkPati());

            //删除主索引
            patientCrossIndexDao.deleteByEmpi(uhDcPi.getEmpi());

        }

    }

}
