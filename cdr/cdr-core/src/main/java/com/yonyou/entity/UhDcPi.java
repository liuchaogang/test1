package com.yonyou.entity;

import java.util.Arrays;
import java.util.Date;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

/**
 * @author chenpana@yonyou.com
 * @ClassName: UhDcPi
 * @Description:
 * @date 2017/6/28 14:00
 */
@Entity
@Table(name = "uh_dc_pi", schema = "dbo", catalog = "MIP_DC_DEMO")
public class UhDcPi {

    private String pkPati;
    private String codeGroup;
    private String codeOrg;
    private String patiCode;
    private String empi;
    private String patiName;
    private byte[] patiPhoto;
    private String idNo;
    private String hpCode;
    private String hpName;
    private String assNo;
    private String codeSex;
    private String nameSex;
    private String dateBirth;
    private String codeAbo;
    private String nameAbo;
    private String codeRh;
    private String nameRh;
    private String codeMari;
    private String nameMari;
    private String codeOccu;
    private String nameOccu;
    private String codeEdu;
    private String nameEdu;
    private String codeDegree;
    private String nameDegree;
    private String codeCountry;
    private String nameCountry;
    private String codeNation;
    private String nameNation;
    private String teleno;
    private String mobileno;
    private String email;
    private String nameWorkunit;
    private String addrWorkunit;
    private String phoneWorkunit;
    private String postcodeWorkunit;
    private String preAddr;
    private String codeKind;
    private String nameKind;
    private String codeEntity;
    private String nameEntity;
    private Date createDate;
    private String codeCreateuser;
    private String nameCreateuser;
    private String levelSecrecy;
    private String dataSource;
    private String sourcePk;
    private Date createTime;
    private Date editTime;
    private String flagDel;

    @Id
    @Column(name = "pk_pati")
    @GenericGenerator(name = "system-uuid", strategy = "uuid")
    @GeneratedValue(generator = "system-uuid")
    public String getPkPati() {
        return pkPati;
    }

    public void setPkPati(String pkPati) {
        this.pkPati = pkPati;
    }

    @Basic
    @Column(name = "code_group")
    public String getCodeGroup() {
        return codeGroup;
    }

    public void setCodeGroup(String codeGroup) {
        this.codeGroup = codeGroup;
    }

    @Basic
    @Column(name = "code_org")
    public String getCodeOrg() {
        return codeOrg;
    }

    public void setCodeOrg(String codeOrg) {
        this.codeOrg = codeOrg;
    }

    @Basic
    @Column(name = "pati_code")
    public String getPatiCode() {
        return patiCode;
    }

    public void setPatiCode(String patiCode) {
        this.patiCode = patiCode;
    }

    @Basic
    @Column(name = "empi")
    public String getEmpi() {
        return empi;
    }

    public void setEmpi(String empi) {
        this.empi = empi;
    }

    @Basic
    @Column(name = "pati_name")
    public String getPatiName() {
        return patiName;
    }

    public void setPatiName(String patiName) {
        this.patiName = patiName;
    }

    @Basic
    @Column(name = "pati_photo")
    public byte[] getPatiPhoto() {
        return patiPhoto;
    }

    public void setPatiPhoto(byte[] patiPhoto) {
        this.patiPhoto = patiPhoto;
    }

    @Basic
    @Column(name = "id_no")
    public String getIdNo() {
        return idNo;
    }

    public void setIdNo(String idNo) {
        this.idNo = idNo;
    }

    @Basic
    @Column(name = "hp_code")
    public String getHpCode() {
        return hpCode;
    }

    public void setHpCode(String hpCode) {
        this.hpCode = hpCode;
    }

    @Basic
    @Column(name = "hp_name")
    public String getHpName() {
        return hpName;
    }

    public void setHpName(String hpName) {
        this.hpName = hpName;
    }

    @Basic
    @Column(name = "ass_no")
    public String getAssNo() {
        return assNo;
    }

    public void setAssNo(String assNo) {
        this.assNo = assNo;
    }

    @Basic
    @Column(name = "code_sex")
    public String getCodeSex() {
        return codeSex;
    }

    public void setCodeSex(String codeSex) {
        this.codeSex = codeSex;
    }

    @Basic
    @Column(name = "name_sex")
    public String getNameSex() {
        return nameSex;
    }

    public void setNameSex(String nameSex) {
        this.nameSex = nameSex;
    }

    @Basic
    @Column(name = "date_birth")
    public String getDateBirth() {
        return dateBirth;
    }

    public void setDateBirth(String dateBirth) {
        this.dateBirth = dateBirth;
    }

    @Basic
    @Column(name = "code_ABO")
    public String getCodeAbo() {
        return codeAbo;
    }

    public void setCodeAbo(String codeAbo) {
        this.codeAbo = codeAbo;
    }

    @Basic
    @Column(name = "name_ABO")
    public String getNameAbo() {
        return nameAbo;
    }

    public void setNameAbo(String nameAbo) {
        this.nameAbo = nameAbo;
    }

    @Basic
    @Column(name = "code_RH")
    public String getCodeRh() {
        return codeRh;
    }

    public void setCodeRh(String codeRh) {
        this.codeRh = codeRh;
    }

    @Basic
    @Column(name = "name_RH")
    public String getNameRh() {
        return nameRh;
    }

    public void setNameRh(String nameRh) {
        this.nameRh = nameRh;
    }

    @Basic
    @Column(name = "code_mari")
    public String getCodeMari() {
        return codeMari;
    }

    public void setCodeMari(String codeMari) {
        this.codeMari = codeMari;
    }

    @Basic
    @Column(name = "name_mari")
    public String getNameMari() {
        return nameMari;
    }

    public void setNameMari(String nameMari) {
        this.nameMari = nameMari;
    }

    @Basic
    @Column(name = "code_occu")
    public String getCodeOccu() {
        return codeOccu;
    }

    public void setCodeOccu(String codeOccu) {
        this.codeOccu = codeOccu;
    }

    @Basic
    @Column(name = "name_occu")
    public String getNameOccu() {
        return nameOccu;
    }

    public void setNameOccu(String nameOccu) {
        this.nameOccu = nameOccu;
    }

    @Basic
    @Column(name = "code_edu")
    public String getCodeEdu() {
        return codeEdu;
    }

    public void setCodeEdu(String codeEdu) {
        this.codeEdu = codeEdu;
    }

    @Basic
    @Column(name = "name_edu")
    public String getNameEdu() {
        return nameEdu;
    }

    public void setNameEdu(String nameEdu) {
        this.nameEdu = nameEdu;
    }

    @Basic
    @Column(name = "code_degree")
    public String getCodeDegree() {
        return codeDegree;
    }

    public void setCodeDegree(String codeDegree) {
        this.codeDegree = codeDegree;
    }

    @Basic
    @Column(name = "name_degree")
    public String getNameDegree() {
        return nameDegree;
    }

    public void setNameDegree(String nameDegree) {
        this.nameDegree = nameDegree;
    }

    @Basic
    @Column(name = "code_country")
    public String getCodeCountry() {
        return codeCountry;
    }

    public void setCodeCountry(String codeCountry) {
        this.codeCountry = codeCountry;
    }

    @Basic
    @Column(name = "name_country")
    public String getNameCountry() {
        return nameCountry;
    }

    public void setNameCountry(String nameCountry) {
        this.nameCountry = nameCountry;
    }

    @Basic
    @Column(name = "code_nation")
    public String getCodeNation() {
        return codeNation;
    }

    public void setCodeNation(String codeNation) {
        this.codeNation = codeNation;
    }

    @Basic
    @Column(name = "name_nation")
    public String getNameNation() {
        return nameNation;
    }

    public void setNameNation(String nameNation) {
        this.nameNation = nameNation;
    }

    @Basic
    @Column(name = "teleno")
    public String getTeleno() {
        return teleno;
    }

    public void setTeleno(String teleno) {
        this.teleno = teleno;
    }

    @Basic
    @Column(name = "mobileno")
    public String getMobileno() {
        return mobileno;
    }

    public void setMobileno(String mobileno) {
        this.mobileno = mobileno;
    }

    @Basic
    @Column(name = "email")
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Basic
    @Column(name = "name_workunit")
    public String getNameWorkunit() {
        return nameWorkunit;
    }

    public void setNameWorkunit(String nameWorkunit) {
        this.nameWorkunit = nameWorkunit;
    }

    @Basic
    @Column(name = "addr_workunit")
    public String getAddrWorkunit() {
        return addrWorkunit;
    }

    public void setAddrWorkunit(String addrWorkunit) {
        this.addrWorkunit = addrWorkunit;
    }

    @Basic
    @Column(name = "phone_workunit")
    public String getPhoneWorkunit() {
        return phoneWorkunit;
    }

    public void setPhoneWorkunit(String phoneWorkunit) {
        this.phoneWorkunit = phoneWorkunit;
    }

    @Basic
    @Column(name = "postcode_workunit")
    public String getPostcodeWorkunit() {
        return postcodeWorkunit;
    }

    public void setPostcodeWorkunit(String postcodeWorkunit) {
        this.postcodeWorkunit = postcodeWorkunit;
    }

    @Basic
    @Column(name = "pre_addr")
    public String getPreAddr() {
        return preAddr;
    }

    public void setPreAddr(String preAddr) {
        this.preAddr = preAddr;
    }

    @Basic
    @Column(name = "code_kind")
    public String getCodeKind() {
        return codeKind;
    }

    public void setCodeKind(String codeKind) {
        this.codeKind = codeKind;
    }

    @Basic
    @Column(name = "name_kind")
    public String getNameKind() {
        return nameKind;
    }

    public void setNameKind(String nameKind) {
        this.nameKind = nameKind;
    }

    @Basic
    @Column(name = "code_entity")
    public String getCodeEntity() {
        return codeEntity;
    }

    public void setCodeEntity(String codeEntity) {
        this.codeEntity = codeEntity;
    }

    @Basic
    @Column(name = "name_entity")
    public String getNameEntity() {
        return nameEntity;
    }

    public void setNameEntity(String nameEntity) {
        this.nameEntity = nameEntity;
    }

    @Basic
    @Column(name = "create_date")
    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    @Basic
    @Column(name = "code_createuser")
    public String getCodeCreateuser() {
        return codeCreateuser;
    }

    public void setCodeCreateuser(String codeCreateuser) {
        this.codeCreateuser = codeCreateuser;
    }

    @Basic
    @Column(name = "name_createuser")
    public String getNameCreateuser() {
        return nameCreateuser;
    }

    public void setNameCreateuser(String nameCreateuser) {
        this.nameCreateuser = nameCreateuser;
    }

    @Basic
    @Column(name = "level_secrecy")
    public String getLevelSecrecy() {
        return levelSecrecy;
    }

    public void setLevelSecrecy(String levelSecrecy) {
        this.levelSecrecy = levelSecrecy;
    }

    @Basic
    @Column(name = "data_source")
    public String getDataSource() {
        return dataSource;
    }

    public void setDataSource(String dataSource) {
        this.dataSource = dataSource;
    }

    @Basic
    @Column(name = "source_pk")
    public String getSourcePk() {
        return sourcePk;
    }

    public void setSourcePk(String sourcePk) {
        this.sourcePk = sourcePk;
    }

    @Basic
    @Column(name = "create_time")
    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    @Basic
    @Column(name = "edit_time")
    public Date getEditTime() {
        return editTime;
    }

    public void setEditTime(Date editTime) {
        this.editTime = editTime;
    }

    @Basic
    @Column(name = "flag_del")
    public String getFlagDel() {
        return flagDel;
    }

    public void setFlagDel(String flagDel) {
        this.flagDel = flagDel;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        UhDcPi uhDcPi = (UhDcPi) o;

        if (pkPati != null ? !pkPati.equals(uhDcPi.pkPati) : uhDcPi.pkPati != null) return false;
        if (codeGroup != null ? !codeGroup.equals(uhDcPi.codeGroup) : uhDcPi.codeGroup != null) return false;
        if (codeOrg != null ? !codeOrg.equals(uhDcPi.codeOrg) : uhDcPi.codeOrg != null) return false;
        if (patiCode != null ? !patiCode.equals(uhDcPi.patiCode) : uhDcPi.patiCode != null) return false;
        if (empi != null ? !empi.equals(uhDcPi.empi) : uhDcPi.empi != null) return false;
        if (patiName != null ? !patiName.equals(uhDcPi.patiName) : uhDcPi.patiName != null) return false;
        if (!Arrays.equals(patiPhoto, uhDcPi.patiPhoto)) return false;
        if (idNo != null ? !idNo.equals(uhDcPi.idNo) : uhDcPi.idNo != null) return false;
        if (hpCode != null ? !hpCode.equals(uhDcPi.hpCode) : uhDcPi.hpCode != null) return false;
        if (hpName != null ? !hpName.equals(uhDcPi.hpName) : uhDcPi.hpName != null) return false;
        if (assNo != null ? !assNo.equals(uhDcPi.assNo) : uhDcPi.assNo != null) return false;
        if (codeSex != null ? !codeSex.equals(uhDcPi.codeSex) : uhDcPi.codeSex != null) return false;
        if (nameSex != null ? !nameSex.equals(uhDcPi.nameSex) : uhDcPi.nameSex != null) return false;
        if (dateBirth != null ? !dateBirth.equals(uhDcPi.dateBirth) : uhDcPi.dateBirth != null) return false;
        if (codeAbo != null ? !codeAbo.equals(uhDcPi.codeAbo) : uhDcPi.codeAbo != null) return false;
        if (nameAbo != null ? !nameAbo.equals(uhDcPi.nameAbo) : uhDcPi.nameAbo != null) return false;
        if (codeRh != null ? !codeRh.equals(uhDcPi.codeRh) : uhDcPi.codeRh != null) return false;
        if (nameRh != null ? !nameRh.equals(uhDcPi.nameRh) : uhDcPi.nameRh != null) return false;
        if (codeMari != null ? !codeMari.equals(uhDcPi.codeMari) : uhDcPi.codeMari != null) return false;
        if (nameMari != null ? !nameMari.equals(uhDcPi.nameMari) : uhDcPi.nameMari != null) return false;
        if (codeOccu != null ? !codeOccu.equals(uhDcPi.codeOccu) : uhDcPi.codeOccu != null) return false;
        if (nameOccu != null ? !nameOccu.equals(uhDcPi.nameOccu) : uhDcPi.nameOccu != null) return false;
        if (codeEdu != null ? !codeEdu.equals(uhDcPi.codeEdu) : uhDcPi.codeEdu != null) return false;
        if (nameEdu != null ? !nameEdu.equals(uhDcPi.nameEdu) : uhDcPi.nameEdu != null) return false;
        if (codeDegree != null ? !codeDegree.equals(uhDcPi.codeDegree) : uhDcPi.codeDegree != null) return false;
        if (nameDegree != null ? !nameDegree.equals(uhDcPi.nameDegree) : uhDcPi.nameDegree != null) return false;
        if (codeCountry != null ? !codeCountry.equals(uhDcPi.codeCountry) : uhDcPi.codeCountry != null) return false;
        if (nameCountry != null ? !nameCountry.equals(uhDcPi.nameCountry) : uhDcPi.nameCountry != null) return false;
        if (codeNation != null ? !codeNation.equals(uhDcPi.codeNation) : uhDcPi.codeNation != null) return false;
        if (nameNation != null ? !nameNation.equals(uhDcPi.nameNation) : uhDcPi.nameNation != null) return false;
        if (teleno != null ? !teleno.equals(uhDcPi.teleno) : uhDcPi.teleno != null) return false;
        if (mobileno != null ? !mobileno.equals(uhDcPi.mobileno) : uhDcPi.mobileno != null) return false;
        if (email != null ? !email.equals(uhDcPi.email) : uhDcPi.email != null) return false;
        if (nameWorkunit != null ? !nameWorkunit.equals(uhDcPi.nameWorkunit) : uhDcPi.nameWorkunit != null)
            return false;
        if (addrWorkunit != null ? !addrWorkunit.equals(uhDcPi.addrWorkunit) : uhDcPi.addrWorkunit != null)
            return false;
        if (phoneWorkunit != null ? !phoneWorkunit.equals(uhDcPi.phoneWorkunit) : uhDcPi.phoneWorkunit != null)
            return false;
        if (postcodeWorkunit != null ? !postcodeWorkunit.equals(uhDcPi.postcodeWorkunit) : uhDcPi.postcodeWorkunit != null)
            return false;
        if (preAddr != null ? !preAddr.equals(uhDcPi.preAddr) : uhDcPi.preAddr != null) return false;
        if (codeKind != null ? !codeKind.equals(uhDcPi.codeKind) : uhDcPi.codeKind != null) return false;
        if (nameKind != null ? !nameKind.equals(uhDcPi.nameKind) : uhDcPi.nameKind != null) return false;
        if (codeEntity != null ? !codeEntity.equals(uhDcPi.codeEntity) : uhDcPi.codeEntity != null) return false;
        if (nameEntity != null ? !nameEntity.equals(uhDcPi.nameEntity) : uhDcPi.nameEntity != null) return false;
        if (createDate != null ? !createDate.equals(uhDcPi.createDate) : uhDcPi.createDate != null) return false;
        if (codeCreateuser != null ? !codeCreateuser.equals(uhDcPi.codeCreateuser) : uhDcPi.codeCreateuser != null)
            return false;
        if (nameCreateuser != null ? !nameCreateuser.equals(uhDcPi.nameCreateuser) : uhDcPi.nameCreateuser != null)
            return false;
        if (levelSecrecy != null ? !levelSecrecy.equals(uhDcPi.levelSecrecy) : uhDcPi.levelSecrecy != null)
            return false;
        if (dataSource != null ? !dataSource.equals(uhDcPi.dataSource) : uhDcPi.dataSource != null) return false;
        if (sourcePk != null ? !sourcePk.equals(uhDcPi.sourcePk) : uhDcPi.sourcePk != null) return false;
        if (createTime != null ? !createTime.equals(uhDcPi.createTime) : uhDcPi.createTime != null) return false;
        if (editTime != null ? !editTime.equals(uhDcPi.editTime) : uhDcPi.editTime != null) return false;
        if (flagDel != null ? !flagDel.equals(uhDcPi.flagDel) : uhDcPi.flagDel != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = pkPati != null ? pkPati.hashCode() : 0;
        result = 31 * result + (codeGroup != null ? codeGroup.hashCode() : 0);
        result = 31 * result + (codeOrg != null ? codeOrg.hashCode() : 0);
        result = 31 * result + (patiCode != null ? patiCode.hashCode() : 0);
        result = 31 * result + (empi != null ? empi.hashCode() : 0);
        result = 31 * result + (patiName != null ? patiName.hashCode() : 0);
        result = 31 * result + Arrays.hashCode(patiPhoto);
        result = 31 * result + (idNo != null ? idNo.hashCode() : 0);
        result = 31 * result + (hpCode != null ? hpCode.hashCode() : 0);
        result = 31 * result + (hpName != null ? hpName.hashCode() : 0);
        result = 31 * result + (assNo != null ? assNo.hashCode() : 0);
        result = 31 * result + (codeSex != null ? codeSex.hashCode() : 0);
        result = 31 * result + (nameSex != null ? nameSex.hashCode() : 0);
        result = 31 * result + (dateBirth != null ? dateBirth.hashCode() : 0);
        result = 31 * result + (codeAbo != null ? codeAbo.hashCode() : 0);
        result = 31 * result + (nameAbo != null ? nameAbo.hashCode() : 0);
        result = 31 * result + (codeRh != null ? codeRh.hashCode() : 0);
        result = 31 * result + (nameRh != null ? nameRh.hashCode() : 0);
        result = 31 * result + (codeMari != null ? codeMari.hashCode() : 0);
        result = 31 * result + (nameMari != null ? nameMari.hashCode() : 0);
        result = 31 * result + (codeOccu != null ? codeOccu.hashCode() : 0);
        result = 31 * result + (nameOccu != null ? nameOccu.hashCode() : 0);
        result = 31 * result + (codeEdu != null ? codeEdu.hashCode() : 0);
        result = 31 * result + (nameEdu != null ? nameEdu.hashCode() : 0);
        result = 31 * result + (codeDegree != null ? codeDegree.hashCode() : 0);
        result = 31 * result + (nameDegree != null ? nameDegree.hashCode() : 0);
        result = 31 * result + (codeCountry != null ? codeCountry.hashCode() : 0);
        result = 31 * result + (nameCountry != null ? nameCountry.hashCode() : 0);
        result = 31 * result + (codeNation != null ? codeNation.hashCode() : 0);
        result = 31 * result + (nameNation != null ? nameNation.hashCode() : 0);
        result = 31 * result + (teleno != null ? teleno.hashCode() : 0);
        result = 31 * result + (mobileno != null ? mobileno.hashCode() : 0);
        result = 31 * result + (email != null ? email.hashCode() : 0);
        result = 31 * result + (nameWorkunit != null ? nameWorkunit.hashCode() : 0);
        result = 31 * result + (addrWorkunit != null ? addrWorkunit.hashCode() : 0);
        result = 31 * result + (phoneWorkunit != null ? phoneWorkunit.hashCode() : 0);
        result = 31 * result + (postcodeWorkunit != null ? postcodeWorkunit.hashCode() : 0);
        result = 31 * result + (preAddr != null ? preAddr.hashCode() : 0);
        result = 31 * result + (codeKind != null ? codeKind.hashCode() : 0);
        result = 31 * result + (nameKind != null ? nameKind.hashCode() : 0);
        result = 31 * result + (codeEntity != null ? codeEntity.hashCode() : 0);
        result = 31 * result + (nameEntity != null ? nameEntity.hashCode() : 0);
        result = 31 * result + (createDate != null ? createDate.hashCode() : 0);
        result = 31 * result + (codeCreateuser != null ? codeCreateuser.hashCode() : 0);
        result = 31 * result + (nameCreateuser != null ? nameCreateuser.hashCode() : 0);
        result = 31 * result + (levelSecrecy != null ? levelSecrecy.hashCode() : 0);
        result = 31 * result + (dataSource != null ? dataSource.hashCode() : 0);
        result = 31 * result + (sourcePk != null ? sourcePk.hashCode() : 0);
        result = 31 * result + (createTime != null ? createTime.hashCode() : 0);
        result = 31 * result + (editTime != null ? editTime.hashCode() : 0);
        result = 31 * result + (flagDel != null ? flagDel.hashCode() : 0);
        return result;
    }
}
