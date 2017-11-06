package com.yonyou.service;

import com.yonyou.entity.*;

import java.util.List;

/**
 * The interface Patient service.
 *
 * @author chenpana @yonyou.com
 * @ClassName: PatientService
 * @Description: 患者相关业务处理
 * @date 2017 /6/28 14:38
 */
public interface PatientService {

    /**
     * 查询患者交叉索引信息
     *
     * @param patientId     患者本地ID
     * @param localTypeCode 患者类型编码
     * @param groupCode     集团编码
     * @param orgCode       机构编码
     * @return uh pi cross index
     */
    UhDcPiCrossIndex getUhPiCrossIndex(String patientId,
                                       String localTypeCode,
                                       String groupCode,
                                       String orgCode);

    /**
     * 保存交叉索引信息
     *
     * @param uhDcPiCrossIndex the uh dc pi cross index
     * @return uh dc pi cross index
     */
    UhDcPiCrossIndex saveUhPiCrossIndex(UhDcPiCrossIndex uhDcPiCrossIndex);

    /**
     * 保存患者相关信息
     *
     * @param uhDcPi      the uh dc pi
     * @param piCards     the pi cards
     * @param piAddresses the pi addresses
     * @param linkmen     the linkmen
     */
    void savePatientInfo(UhDcPi uhDcPi, List<UhDcPiCard> piCards, List<UhDcPiAddress> piAddresses, List<UhDcPiLinkman> linkmen);


    /**
     * Save patient info uh dc pi.
     *
     * @param uhDcPi the uh dc pi
     * @return the uh dc pi
     */
    UhDcPi savePatientInfo(UhDcPi uhDcPi);

    /**
     * Save patient info.
     *
     * @param piCards     the pi cards
     * @param piAddresses the pi addresses
     * @param linkmen     the linkmen
     */
    void savePatientInfo(List<UhDcPiCard> piCards, List<UhDcPiAddress> piAddresses, List<UhDcPiLinkman> linkmen);

    /**
     * Gets uh dc pi.
     *
     * @param empiId    the empi id
     * @param groupCode the group code
     * @param orgCode   the org code
     * @return the uh dc pi
     */
    UhDcPi getUhDcPi(String empiId, String groupCode, String orgCode);

    /**
     * Gets uh dc pi by cross index.
     *
     * @param patientId     the patient id
     * @param localTypeCode the local type code
     * @param groupCode     the group code
     * @param orgCode       the org code
     * @return the uh dc pi by cross index
     */
    UhDcPi getUhDcPiByCrossIndex(String patientId,String localTypeCode,String groupCode, String orgCode);

    /**
     * Gets tmp uh dc pi.
     *
     * @param empiId        the empi id
     * @param patientId     the patient id
     * @param localTypeCode the local type code
     * @param groupCode     the group code
     * @param orgCode       the org code
     * @return the tmp uh dc pi
     */
    UhDcPi getTmpUhDcPi(String empiId, String patientId, String localTypeCode, String groupCode, String orgCode);

    /**
     * Update old pi info.
     *
     * @param oldPkPiLists the old pk pi lists
     * @param pkPati       the pk pati
     * @param empiId       the empi id
     */
    void updateOldPiInfo(List<String> oldPkPiLists, String pkPati, String empiId);

    /**
     * Del patient all.
     *
     * @param empiId the empi id
     */
    void delPatientAll(UhDcPi uhDcPi);

    UhDcPi getUhDcPi(String empiId);
    
    
}
