package com.yonyou.writer;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Component;

import com.yonyou.entity.UhDcPi;
import com.yonyou.entity.UhDcPiAddress;
import com.yonyou.entity.UhDcPiCard;
import com.yonyou.entity.UhDcPiCrossIndex;
import com.yonyou.entity.UhDcPiLinkman;
import com.yonyou.hl7adapter.model.Address;
import com.yonyou.hl7adapter.model.Contact;
import com.yonyou.hl7adapter.model.Patient;
import com.yonyou.hl7adapter.model.PatientMinimal;
import com.yonyou.util.Constant;
import com.yonyou.util.DateUtils;
import com.yonyou.util.ObjectUtils;

/**
 * @author chenpana@yonyou.com
 * @ClassName: ST102Convertor
 * @Description:
 * @date 2017/6/28 15:44
 */

@Component
public class PatientConvertor {

    /**
     * Gets pi.
     *
     * @param patient     the patient
     * @param empiId      the empi id
     * @param currentTime the current time
     * @param pkPati      the pk pati
     * @return the pi
     */
    public static UhDcPi getPi(Patient patient, String empiId, Date currentTime, String pkPati, UhDcPi uhDcPiDB) {

        UhDcPi pi = new UhDcPi();

        /**
         * empi合并后应该只存最佳记录,不保存具体的patientId
         */
       /* pi.setPatiCode(patient.getPatientId());*/
        pi.setPkPati(pkPati);
        pi.setEmpi(empiId);
        pi.setCodeGroup(patient.getGroupCode());
        pi.setCodeOrg(patient.getOrgCode());
        pi.setPatiName(patient.getPatientName());
        pi.setIdNo(patient.getIdentityCardNo());
        pi.setHpCode(patient.getMedicalInsuranceTypeCode());
        pi.setHpName(patient.getMedicalInsuranceTypeName());
        pi.setAssNo(patient.getInsuranceNo());
        pi.setCodeSex(patient.getGenderCode());
        pi.setNameSex(patient.getGenderName());
        pi.setDateBirth(patient.getBirthDate());
        pi.setCodeAbo(patient.getAboCode());
        pi.setNameAbo(patient.getAboCode());
        pi.setCodeRh(patient.getRhCode());
        pi.setNameRh(patient.getRhName());
        pi.setCodeMari(patient.getMaritalStatusCode());
        pi.setNameMari(patient.getMaritalStatusName());
        pi.setCodeOccu(patient.getOccupationCode());
        pi.setNameOccu(patient.getOccupationName());
        pi.setCodeEdu(patient.getEducationLevelCode());
        pi.setNameEdu(patient.getEducationLevelName());

        //学位
        pi.setCodeDegree(null);
        pi.setNameDegree(null);

        pi.setCodeCountry(patient.getNationalityCode());
        pi.setNameCountry(patient.getNationalityName());
        pi.setCodeNation(patient.getNationCode());
        pi.setNameNation(patient.getNationName());
        pi.setTeleno(patient.getHomeTelNo());
        pi.setMobileno(patient.getTelephoneNo());
        pi.setEmail(patient.getEmail());
        pi.setNameWorkunit(patient.getWorkUnitName());
        pi.setAddrWorkunit(patient.getWorkFullAdress());
        pi.setPhoneWorkunit(patient.getWorkPhone());
        pi.setPostcodeWorkunit(patient.getWorkZipCode());

        //现住址 保存在地址信息中，不保存在主表
        pi.setPreAddr(null);

        pi.setCodeKind(patient.getSpecialCrowdCode());
        pi.setNameKind(patient.getSpecialCrowdName());

        if (uhDcPiDB == null) {
            pi.setCreateDate(currentTime);
            pi.setCreateTime(currentTime);
            pi.setFlagDel("0");
        } else {
            pi.setCreateDate(uhDcPiDB.getCreateDate());
            pi.setCreateTime(uhDcPiDB.getCreateTime());
            pi.setFlagDel("0");
            pi.setEditTime(currentTime);
        }

        return pi;
    }


    /**
     * Gets pi cross index.
     *
     * @param patient     the patient
     * @param empiId      the empi id
     * @param currentTime the current time
     * @return the pi cross index
     */
    public static UhDcPiCrossIndex getPiCrossIndex(Patient patient,
                                                   String empiId,
                                                   Date currentTime,
                                                   UhDcPiCrossIndex piCrossIndex) {

        UhDcPiCrossIndex pic = new UhDcPiCrossIndex();

        pic.setPatiCode(patient.getPatientId());
        pic.setEmpi(empiId);
        pic.setLocalTypeCode(patient.getLocalTypeCode());
        pic.setHealthCardNo(patient.getHealthCardNo());
        pic.setOupatientNo(patient.getOupatientNo());
        pic.setInpatientNo(patient.getInpatientNo());
        pic.setInsuranceNo(patient.getInsuranceNo());

        pic.setCodeGroup(patient.getGroupCode());
        pic.setCodeOrg(patient.getOrgCode());


        if (piCrossIndex == null) {
            pic.setCreateTime(currentTime);
            pic.setFlagDel("0");
        } else {
            pic.setCreateTime(piCrossIndex.getCreateTime());
            pic.setEditTime(currentTime);
            pic.setPkIndex(piCrossIndex.getPkIndex());
            pic.setFlagDel("0");

        }

        return pic;
    }


    /**
     * Gets pi cross index.
     *
     * @param patMini       the pat mini
     * @param localTypeCode the local type code
     * @param empiId        the empi id
     * @param currentTime   the current time
     * @return the pi cross index
     */
    public static UhDcPiCrossIndex getPiCrossIndex(PatientMinimal patMini, String localTypeCode, String empiId, Date currentTime) {
        UhDcPiCrossIndex pic = new UhDcPiCrossIndex();

        pic.setPatiCode(patMini.getPatientId());
        pic.setEmpi(empiId);
        pic.setLocalTypeCode(localTypeCode);
        pic.setHealthCardNo(null);
        pic.setOupatientNo(patMini.getOupatientNo());
        pic.setInpatientNo(patMini.getInpatientNo());
        pic.setInsuranceNo(patMini.getInsuranceNo());

        pic.setCodeGroup(patMini.getGroupCode());
        pic.setCodeOrg(patMini.getOrgCode());


        pic.setCreateTime(currentTime);
        pic.setFlagDel("0");
        return pic;
    }

    /**
     * Gets pi card.
     *
     * @param patient     the patient
     * @param currentTime the current time
     * @param pkPati      the pk pati
     * @param groupCode   the group code
     * @param orgCode     the org code
     * @return the pi card
     */
    public static List<UhDcPiCard> getPiCard(Patient patient,
                                             Date currentTime,
                                             String pkPati,
                                             String groupCode,
                                             String orgCode) {

        List<UhDcPiCard> cards = null;
        if (StringUtils.isNotEmpty(patient.getOtherCardNo())) {
            cards = new ArrayList<>();

            UhDcPiCard piCard = new UhDcPiCard();

            piCard.setPkPati(pkPati);
            piCard.setCodeGroup(groupCode);
            piCard.setCodeOrg(orgCode);
            piCard.setCodeCardType(Constant.getOtherCardTypeCode());
            piCard.setNameCardType(Constant.getOtherCardTypeName());
            piCard.setCardNo(patient.getOtherCardNo());
            piCard.setCreateTime(currentTime);
            piCard.setFlagDel("0");

            cards.add(piCard);
        }

        return cards;
    }


    /**
     * Gets pi addresses.
     *
     * @param addresses   the addresses
     * @param currentTime the current time
     * @param pkPati      the pk pati
     * @param groupCode   the group code
     * @param orgCode     the org code
     * @return the pi addresses
     */
    public static List<UhDcPiAddress> getPiAddresses(List<Address> addresses,
                                                     Date currentTime,
                                                     String pkPati,
                                                     String groupCode,
                                                     String orgCode) {
        List<UhDcPiAddress> piAddresses = null;
        if (addresses != null && !addresses.isEmpty()) {
            piAddresses = new ArrayList<>();

            String fullAdress = null;
            String provinceName = null;
            String cityName = null;
            String countyName = null;
            String townName = null;
            String villageName = null;
            String houseNo = null;
            String zipCode = null;
            String addressTypeCode = null;
            String addrssTypeName = null;

            for (Address addr : addresses) {

                fullAdress = addr.getFullAdress();
                provinceName = addr.getProvinceName();
                cityName = addr.getCityName();
                countyName = addr.getCountyName();
                townName = addr.getTownName();
                villageName = addr.getVillageName();
                houseNo = addr.getHouseNo();
                zipCode = addr.getZipCode();
                addressTypeCode = addr.getAddressType();
                if (StringUtils.isNotEmpty(addressTypeCode))
                    addrssTypeName = Constant.getAddrTypeName(addressTypeCode);

                if (StringUtils.isEmpty(fullAdress) && StringUtils.isEmpty(provinceName)
                        && StringUtils.isEmpty(cityName) && StringUtils.isEmpty(countyName)
                        && StringUtils.isEmpty(townName) && StringUtils.isEmpty(villageName)) {
                    continue;
                }

                UhDcPiAddress piAddr = new UhDcPiAddress();

                piAddr.setPkPati(pkPati);
                piAddr.setCodeGroup(groupCode);
                piAddr.setCodeOrg(orgCode);
                piAddr.setCodeAddrType(addressTypeCode);
                piAddr.setNameAddrType(addrssTypeName);
                piAddr.setAddrProv(provinceName);
                piAddr.setAddrCity(cityName);
                piAddr.setAddrCounty(countyName);
                piAddr.setAddrCountry(townName);
                piAddr.setAddrVillage(villageName);
                piAddr.setAddrHouseNum(houseNo);
                piAddr.setNostructureAddr(fullAdress);
                piAddr.setAddrZipcode(zipCode);

                piAddr.setCreateTime(currentTime);
                piAddr.setFlagDel("0");

                piAddresses.add(piAddr);

            }
        }

        return piAddresses;
    }


    /**
     * Gets linkmen.
     *
     * @param contacts    the contacts
     * @param currentTime the current time
     * @param pkPati      the pk pati
     * @param groupCode   the group code
     * @param orgCode     the org code
     * @return the linkmen
     */
    public static List<UhDcPiLinkman> getLinkmen(List<Contact> contacts,
                                                 Date currentTime,
                                                 String pkPati,
                                                 String groupCode,
                                                 String orgCode) {
        List<UhDcPiLinkman> piLinkmen = null;

        if (contacts != null && !contacts.isEmpty()) {
            piLinkmen = new ArrayList<>();

            String relationshipCode = null;
            String relationshipName = null;
            String contactPhone = null;
            String contactName = null;
            String contactFullAddr = null;

            for (Contact con : contacts) {

                relationshipCode = con.getRelationshipCode();
                relationshipName = con.getRelationshipName();
                contactPhone = con.getContactPhone();
                contactName = con.getContactName();
                contactFullAddr = con.getContactFullAdress();

                if (StringUtils.isEmpty(relationshipCode) && StringUtils.isEmpty(relationshipName)
                        && StringUtils.isEmpty(contactPhone) && StringUtils.isEmpty(contactName)
                        && StringUtils.isEmpty(contactFullAddr)) {
                    continue;
                }

                UhDcPiLinkman piLink = new UhDcPiLinkman();

                piLink.setPkPati(pkPati);
                piLink.setCodeGroup(groupCode);
                piLink.setCodeOrg(orgCode);
                piLink.setCodeContRelat(relationshipCode);
                piLink.setNameContRelat(relationshipName);
                piLink.setContactName(contactName);
                piLink.setContactTel(contactPhone);
                piLink.setContactAddr(contactFullAddr);


                piLink.setCreateTime(currentTime);
                piLink.setFlagDel("0");

                piLinkmen.add(piLink);
            }
        }
        return piLinkmen;
    }

    public static UhDcPi getMiniPi(PatientMinimal patient, String empiId, Date currentTime) {
        UhDcPi pi = new UhDcPi();

        pi.setEmpi(empiId);
        pi.setPatiCode(patient.getPatientId());
        pi.setCodeGroup(patient.getGroupCode());
        pi.setCodeOrg(patient.getOrgCode());
        pi.setPatiName(patient.getPatientName());
        pi.setCodeSex(patient.getGenderCode());
        pi.setNameSex(patient.getGenderName());
        pi.setIdNo(patient.getIdentityCardNo());
        String birthDate=patient.getBirthDate();
        if(ObjectUtils.isNotEmpty(birthDate)){
        	pi.setDateBirth(DateUtils.getDateStr2Str(birthDate));
        }
        
        pi.setTeleno(patient.getTelephoneNo());

        pi.setCreateTime(currentTime);
        pi.setFlagDel("0");

        return pi;
    }

}
