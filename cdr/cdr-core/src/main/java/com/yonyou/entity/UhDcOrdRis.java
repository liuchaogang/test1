package com.yonyou.entity;
/******************************************************************
** 类    名：UhDcOrdRisEntity
** 描    述：
** 创 建 者：bianj
** 创建时间：2017-07-06 10:21:30
******************************************************************/

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

/**
 * (UH_DC_ORD_RIS)
 * 
 * @author bianj
 * @version 1.0.0 2017-07-06
 */
@Entity
@Table(name = "UH_DC_ORD_RIS", schema = "dbo", catalog = "MIP_DC_DEMO")
public class UhDcOrdRis implements java.io.Serializable {
    /** 版本号 */
    private static final long serialVersionUID = -8288868238153245622L;
    
    /**  */
    @Id
    @Column(name = "PK_DCORDRISREQ" )
    @GenericGenerator(name = "system-uuid", strategy = "uuid")
    @GeneratedValue(generator = "system-uuid")
    private String pkDcordrisreq;
    
    /**  */
    @Column(name = "PK_DCORD" )
    private String pkDcord;
    
    /**  */
    @Column(name = "CODE_GROUP" )
    private String codeGroup;
    
    /**  */
    @Column(name = "CODE_ORG" )
    private String codeOrg;
    
    /**  */
    @Column(name = "CODE_ORD" )
    private String codeOrd;
    
    /**  */
    @Column(name = "EMPI" )
    private String empi;
    
    /**  */
    @Column(name = "CODE_PATI" )
    private String codePati;
    
    /**  */
    @Column(name = "PATINAME" )
    private String patiname;
    
    /**  */
    @Column(name = "CODE_SEX" )
    private String codeSex;
    
    /**  */
    @Column(name = "NAME_SEX" )
    private String nameSex;
    
    /**  */
    @Column(name = "BIRTHDAY" )
    private String birthday;
    
    /**  */
    @Column(name = "ADDR_PRE" )
    private String addrPre;
    
    /**  */
    @Column(name = "TELENO_PRE" )
    private String telenoPre;
    
    /**  */
    @Column(name = "CODE_REQ" )
    private String codeReq;
    
    /**  */
    @Column(name = "CODE_ORG_REQ" )
    private String codeOrgReq;
    
    /**  */
    @Column(name = "NAME_ORG_REQ" )
    private String nameOrgReq;
    
    /**  */
    @Column(name = "CODE_DEPT_REQ" )
    private String codeDeptReq;
    
    /**  */
    @Column(name = "NAME_DEPT_REQ" )
    private String nameDeptReq;
    
    /**  */
    @Column(name = "CODE_PSN_REQ" )
    private String codePsnReq;
    
    /**  */
    @Column(name = "NAME_PSN_REQ" )
    private String namePsnReq;
    
    /**  */
    @Column(name = "TELE_PSN_REQ" )
    private String telePsnReq;
    
    /**  */
    @Column(name = "DATE_LAB" )
    private String dateLab;
    
    /**  */
    @Column(name = "DESC_ILLNESS" )
    private String descIllness;
    
    /**  */
    @Column(name = "CODE_DIAG" )
    private String codeDiag;
    
    /**  */
    @Column(name = "NAME_DIAG" )
    private String nameDiag;
    
    /**  */
    @Column(name = "DESC_DIAG" )
    private String descDiag;
    
    /**  */
    @Column(name = "DIAG_DATE" )
    private String diagDate;
    
    /**  */
    @Column(name = "DISEASE_PRE" )
    private String diseasePre;
    
    /**  */
    @Column(name = "PURP_RIS" )
    private String purpRis;
    
    /**  */
    @Column(name = "CODE_EU_TYPE" )
    private String codeEuType;
    
    /**  */
    @Column(name = "NAME_EU_TYPE" )
    private String nameEuType;
    
    /**  */
    @Column(name = "CODE_EU_BODY" )
    private String codeEuBody;
    
    /**  */
    @Column(name = "NAME_EU_BODY" )
    private String nameEuBody;
    
    /**  */
    @Column(name = "CODE_SRV" )
    private String codeSrv;
    
    /**  */
    @Column(name = "NAME_SRV" )
    private String nameSrv;
    
    /**  */
    @Column(name = "DATE_RIS" )
    private String dateRis;
    
    /**  */
    @Column(name = "DATE_RESERVATION" )
    private String dateReservation;
    
    /**  */
    @Column(name = "EU_STATE" )
    private String euState;
    
    /**  */
    @Column(name = "FLAG_URGENT")
    private Integer flagUrgent;
    
    /**  */
    @Column(name = "FLAG_BED" )
    private Integer flagBed;
    
    /**  */
    @Column(name = "EU_DESC" )
    private String euDesc;
    
    /**  */
    @Column(name = "NOTE" )
    private String note;
    
    /**  */
    @Column(name = "DATA_SOURCE" )
    private String dataSource;
    
    /**  */
    @Column(name = "SOURCE_PK" )
    private String sourcePk;
    
    /**  */
    @Column(name = "CREATE_TIME" )
    private Date createTime;
    
    /**  */
    @Column(name = "EDIT_TIME" )
    private Date editTime;
    
    /**  */
    @Column(name = "FLAG_DEL" )
    private Integer flagDel;
    
    /**
     * 获取pkDcordrisreq
     * 
     * @return pkDcordrisreq
     */
    public String getPkDcordrisreq() {
        return this.pkDcordrisreq;
    }
     
    /**
     * 设置pkDcordrisreq
     * 
     * @param pkDcordrisreq
     *          pkDcordrisreq
     */
    public void setPkDcordrisreq(String pkDcordrisreq) {
        this.pkDcordrisreq = pkDcordrisreq;
    }
    
    /**
     * 获取pkDcord
     * 
     * @return pkDcord
     */
    public String getPkDcord() {
        return this.pkDcord;
    }
     
    /**
     * 设置pkDcord
     * 
     * @param pkDcord
     *          pkDcord
     */
    public void setPkDcord(String pkDcord) {
        this.pkDcord = pkDcord;
    }
    
    /**
     * 获取codeGroup
     * 
     * @return codeGroup
     */
    public String getCodeGroup() {
        return this.codeGroup;
    }
     
    /**
     * 设置codeGroup
     * 
     * @param codeGroup
     *          codeGroup
     */
    public void setCodeGroup(String codeGroup) {
        this.codeGroup = codeGroup;
    }
    
    /**
     * 获取codeOrg
     * 
     * @return codeOrg
     */
    public String getCodeOrg() {
        return this.codeOrg;
    }
     
    /**
     * 设置codeOrg
     * 
     * @param codeOrg
     *          codeOrg
     */
    public void setCodeOrg(String codeOrg) {
        this.codeOrg = codeOrg;
    }
    
    /**
     * 获取codeOrd
     * 
     * @return codeOrd
     */
    public String getCodeOrd() {
        return this.codeOrd;
    }
     
    /**
     * 设置codeOrd
     * 
     * @param codeOrd
     *          codeOrd
     */
    public void setCodeOrd(String codeOrd) {
        this.codeOrd = codeOrd;
    }
    
    /**
     * 获取empi
     * 
     * @return empi
     */
    public String getEmpi() {
        return this.empi;
    }
     
    /**
     * 设置empi
     * 
     * @param empi
     *          empi
     */
    public void setEmpi(String empi) {
        this.empi = empi;
    }
    
    /**
     * 获取codePati
     * 
     * @return codePati
     */
    public String getCodePati() {
        return this.codePati;
    }
     
    /**
     * 设置codePati
     * 
     * @param codePati
     *          codePati
     */
    public void setCodePati(String codePati) {
        this.codePati = codePati;
    }
    
    /**
     * 获取patiname
     * 
     * @return patiname
     */
    public String getPatiname() {
        return this.patiname;
    }
     
    /**
     * 设置patiname
     * 
     * @param patiname
     *          patiname
     */
    public void setPatiname(String patiname) {
        this.patiname = patiname;
    }
    
    /**
     * 获取codeSex
     * 
     * @return codeSex
     */
    public String getCodeSex() {
        return this.codeSex;
    }
     
    /**
     * 设置codeSex
     * 
     * @param codeSex
     *          codeSex
     */
    public void setCodeSex(String codeSex) {
        this.codeSex = codeSex;
    }
    
    /**
     * 获取nameSex
     * 
     * @return nameSex
     */
    public String getNameSex() {
        return this.nameSex;
    }
     
    /**
     * 设置nameSex
     * 
     * @param nameSex
     *          nameSex
     */
    public void setNameSex(String nameSex) {
        this.nameSex = nameSex;
    }
    
    /**
     * 获取birthday
     * 
     * @return birthday
     */
    public String getBirthday() {
        return this.birthday;
    }
     
    /**
     * 设置birthday
     * 
     * @param birthday
     *          birthday
     */
    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }
    
    /**
     * 获取addrPre
     * 
     * @return addrPre
     */
    public String getAddrPre() {
        return this.addrPre;
    }
     
    /**
     * 设置addrPre
     * 
     * @param addrPre
     *          addrPre
     */
    public void setAddrPre(String addrPre) {
        this.addrPre = addrPre;
    }
    
    /**
     * 获取telenoPre
     * 
     * @return telenoPre
     */
    public String getTelenoPre() {
        return this.telenoPre;
    }
     
    /**
     * 设置telenoPre
     * 
     * @param telenoPre
     *          telenoPre
     */
    public void setTelenoPre(String telenoPre) {
        this.telenoPre = telenoPre;
    }
    
    /**
     * 获取codeReq
     * 
     * @return codeReq
     */
    public String getCodeReq() {
        return this.codeReq;
    }
     
    /**
     * 设置codeReq
     * 
     * @param codeReq
     *          codeReq
     */
    public void setCodeReq(String codeReq) {
        this.codeReq = codeReq;
    }
    
    /**
     * 获取codeOrgReq
     * 
     * @return codeOrgReq
     */
    public String getCodeOrgReq() {
        return this.codeOrgReq;
    }
     
    /**
     * 设置codeOrgReq
     * 
     * @param codeOrgReq
     *          codeOrgReq
     */
    public void setCodeOrgReq(String codeOrgReq) {
        this.codeOrgReq = codeOrgReq;
    }
    
    /**
     * 获取nameOrgReq
     * 
     * @return nameOrgReq
     */
    public String getNameOrgReq() {
        return this.nameOrgReq;
    }
     
    /**
     * 设置nameOrgReq
     * 
     * @param nameOrgReq
     *          nameOrgReq
     */
    public void setNameOrgReq(String nameOrgReq) {
        this.nameOrgReq = nameOrgReq;
    }
    
    /**
     * 获取codeDeptReq
     * 
     * @return codeDeptReq
     */
    public String getCodeDeptReq() {
        return this.codeDeptReq;
    }
     
    /**
     * 设置codeDeptReq
     * 
     * @param codeDeptReq
     *          codeDeptReq
     */
    public void setCodeDeptReq(String codeDeptReq) {
        this.codeDeptReq = codeDeptReq;
    }
    
    /**
     * 获取nameDeptReq
     * 
     * @return nameDeptReq
     */
    public String getNameDeptReq() {
        return this.nameDeptReq;
    }
     
    /**
     * 设置nameDeptReq
     * 
     * @param nameDeptReq
     *          nameDeptReq
     */
    public void setNameDeptReq(String nameDeptReq) {
        this.nameDeptReq = nameDeptReq;
    }
    
    /**
     * 获取codePsnReq
     * 
     * @return codePsnReq
     */
    public String getCodePsnReq() {
        return this.codePsnReq;
    }
     
    /**
     * 设置codePsnReq
     * 
     * @param codePsnReq
     *          codePsnReq
     */
    public void setCodePsnReq(String codePsnReq) {
        this.codePsnReq = codePsnReq;
    }
    
    /**
     * 获取namePsnReq
     * 
     * @return namePsnReq
     */
    public String getNamePsnReq() {
        return this.namePsnReq;
    }
     
    /**
     * 设置namePsnReq
     * 
     * @param namePsnReq
     *          namePsnReq
     */
    public void setNamePsnReq(String namePsnReq) {
        this.namePsnReq = namePsnReq;
    }
    
    /**
     * 获取telePsnReq
     * 
     * @return telePsnReq
     */
    public String getTelePsnReq() {
        return this.telePsnReq;
    }
     
    /**
     * 设置telePsnReq
     * 
     * @param telePsnReq
     *          telePsnReq
     */
    public void setTelePsnReq(String telePsnReq) {
        this.telePsnReq = telePsnReq;
    }
    
    /**
     * 获取dateLab
     * 
     * @return dateLab
     */
    public String getDateLab() {
        return this.dateLab;
    }
     
    /**
     * 设置dateLab
     * 
     * @param dateLab
     *          dateLab
     */
    public void setDateLab(String dateLab) {
        this.dateLab = dateLab;
    }
    
    /**
     * 获取descIllness
     * 
     * @return descIllness
     */
    public String getDescIllness() {
        return this.descIllness;
    }
     
    /**
     * 设置descIllness
     * 
     * @param descIllness
     *          descIllness
     */
    public void setDescIllness(String descIllness) {
        this.descIllness = descIllness;
    }
    
    /**
     * 获取codeDiag
     * 
     * @return codeDiag
     */
    public String getCodeDiag() {
        return this.codeDiag;
    }
     
    /**
     * 设置codeDiag
     * 
     * @param codeDiag
     *          codeDiag
     */
    public void setCodeDiag(String codeDiag) {
        this.codeDiag = codeDiag;
    }
    
    /**
     * 获取nameDiag
     * 
     * @return nameDiag
     */
    public String getNameDiag() {
        return this.nameDiag;
    }
     
    /**
     * 设置nameDiag
     * 
     * @param nameDiag
     *          nameDiag
     */
    public void setNameDiag(String nameDiag) {
        this.nameDiag = nameDiag;
    }
    
    /**
     * 获取descDiag
     * 
     * @return descDiag
     */
    public String getDescDiag() {
        return this.descDiag;
    }
     
    /**
     * 设置descDiag
     * 
     * @param descDiag
     *          descDiag
     */
    public void setDescDiag(String descDiag) {
        this.descDiag = descDiag;
    }
    
    /**
     * 获取diagDate
     * 
     * @return diagDate
     */
    public String getDiagDate() {
        return this.diagDate;
    }
     
    /**
     * 设置diagDate
     * 
     * @param diagDate
     *          diagDate
     */
    public void setDiagDate(String diagDate) {
        this.diagDate = diagDate;
    }
    
    /**
     * 获取diseasePre
     * 
     * @return diseasePre
     */
    public String getDiseasePre() {
        return this.diseasePre;
    }
     
    /**
     * 设置diseasePre
     * 
     * @param diseasePre
     *          diseasePre
     */
    public void setDiseasePre(String diseasePre) {
        this.diseasePre = diseasePre;
    }
    
    /**
     * 获取purpRis
     * 
     * @return purpRis
     */
    public String getPurpRis() {
        return this.purpRis;
    }
     
    /**
     * 设置purpRis
     * 
     * @param purpRis
     *          purpRis
     */
    public void setPurpRis(String purpRis) {
        this.purpRis = purpRis;
    }
    
    /**
     * 获取codeEuType
     * 
     * @return codeEuType
     */
    public String getCodeEuType() {
        return this.codeEuType;
    }
     
    /**
     * 设置codeEuType
     * 
     * @param codeEuType
     *          codeEuType
     */
    public void setCodeEuType(String codeEuType) {
        this.codeEuType = codeEuType;
    }
    
    /**
     * 获取nameEuType
     * 
     * @return nameEuType
     */
    public String getNameEuType() {
        return this.nameEuType;
    }
     
    /**
     * 设置nameEuType
     * 
     * @param nameEuType
     *          nameEuType
     */
    public void setNameEuType(String nameEuType) {
        this.nameEuType = nameEuType;
    }
    
    /**
     * 获取codeEuBody
     * 
     * @return codeEuBody
     */
    public String getCodeEuBody() {
        return this.codeEuBody;
    }
     
    /**
     * 设置codeEuBody
     * 
     * @param codeEuBody
     *          codeEuBody
     */
    public void setCodeEuBody(String codeEuBody) {
        this.codeEuBody = codeEuBody;
    }
    
    /**
     * 获取nameEuBody
     * 
     * @return nameEuBody
     */
    public String getNameEuBody() {
        return this.nameEuBody;
    }
     
    /**
     * 设置nameEuBody
     * 
     * @param nameEuBody
     *          nameEuBody
     */
    public void setNameEuBody(String nameEuBody) {
        this.nameEuBody = nameEuBody;
    }
    
    /**
     * 获取codeSrv
     * 
     * @return codeSrv
     */
    public String getCodeSrv() {
        return this.codeSrv;
    }
     
    /**
     * 设置codeSrv
     * 
     * @param codeSrv
     *          codeSrv
     */
    public void setCodeSrv(String codeSrv) {
        this.codeSrv = codeSrv;
    }
    
    /**
     * 获取nameSrv
     * 
     * @return nameSrv
     */
    public String getNameSrv() {
        return this.nameSrv;
    }
     
    /**
     * 设置nameSrv
     * 
     * @param nameSrv
     *          nameSrv
     */
    public void setNameSrv(String nameSrv) {
        this.nameSrv = nameSrv;
    }
    
    /**
     * 获取dateRis
     * 
     * @return dateRis
     */
    public String getDateRis() {
        return this.dateRis;
    }
     
    /**
     * 设置dateRis
     * 
     * @param dateRis
     *          dateRis
     */
    public void setDateRis(String dateRis) {
        this.dateRis = dateRis;
    }
    
    /**
     * 获取dateReservation
     * 
     * @return dateReservation
     */
    public String getDateReservation() {
        return this.dateReservation;
    }
     
    /**
     * 设置dateReservation
     * 
     * @param dateReservation
     *          dateReservation
     */
    public void setDateReservation(String dateReservation) {
        this.dateReservation = dateReservation;
    }
    
    /**
     * 获取euState
     * 
     * @return euState
     */
    public String getEuState() {
        return this.euState;
    }
     
    /**
     * 设置euState
     * 
     * @param euState
     *          euState
     */
    public void setEuState(String euState) {
        this.euState = euState;
    }
    
    /**
     * 获取flagUrgent
     * 
     * @return flagUrgent
     */
    public Integer getFlagUrgent() {
        return this.flagUrgent;
    }
     
    /**
     * 设置flagUrgent
     * 
     * @param flagUrgent
     *          flagUrgent
     */
    public void setFlagUrgent(Integer flagUrgent) {
        this.flagUrgent = flagUrgent;
    }
    
    /**
     * 获取flagBed
     * 
     * @return flagBed
     */
    public Integer getFlagBed() {
        return this.flagBed;
    }
     
    /**
     * 设置flagBed
     * 
     * @param flagBed
     *          flagBed
     */
    public void setFlagBed(Integer flagBed) {
        this.flagBed = flagBed;
    }
    
    /**
     * 获取euDesc
     * 
     * @return euDesc
     */
    public String getEuDesc() {
        return this.euDesc;
    }
     
    /**
     * 设置euDesc
     * 
     * @param euDesc
     *          euDesc
     */
    public void setEuDesc(String euDesc) {
        this.euDesc = euDesc;
    }
    
    /**
     * 获取note
     * 
     * @return note
     */
    public String getNote() {
        return this.note;
    }
     
    /**
     * 设置note
     * 
     * @param note
     *          note
     */
    public void setNote(String note) {
        this.note = note;
    }
    
    /**
     * 获取dataSource
     * 
     * @return dataSource
     */
    public String getDataSource() {
        return this.dataSource;
    }
     
    /**
     * 设置dataSource
     * 
     * @param dataSource
     *          dataSource
     */
    public void setDataSource(String dataSource) {
        this.dataSource = dataSource;
    }
    
    /**
     * 获取sourcePk
     * 
     * @return sourcePk
     */
    public String getSourcePk() {
        return this.sourcePk;
    }
     
    /**
     * 设置sourcePk
     * 
     * @param sourcePk
     *          sourcePk
     */
    public void setSourcePk(String sourcePk) {
        this.sourcePk = sourcePk;
    }
    
    /**
     * 获取createTime
     * 
     * @return createTime
     */
    public Date getCreateTime() {
        return this.createTime;
    }
     
    /**
     * 设置createTime
     * 
     * @param createTime
     *          createTime
     */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }
    
    /**
     * 获取editTime
     * 
     * @return editTime
     */
    public Date getEditTime() {
        return this.editTime;
    }
     
    /**
     * 设置editTime
     * 
     * @param editTime
     *          editTime
     */
    public void setEditTime(Date editTime) {
        this.editTime = editTime;
    }
    
    /**
     * 获取flagDel
     * 
     * @return flagDel
     */
    public Integer getFlagDel() {
        return this.flagDel;
    }
     
    /**
     * 设置flagDel
     * 
     * @param flagDel
     *          flagDel
     */
    public void setFlagDel(Integer flagDel) {
        this.flagDel = flagDel;
    }
}