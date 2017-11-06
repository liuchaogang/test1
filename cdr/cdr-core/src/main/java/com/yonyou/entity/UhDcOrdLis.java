package com.yonyou.entity;
/******************************************************************
** 类    名：UhDcOrdLisEntity
** 描    述：
** 创 建 者：bianj
** 创建时间：2017-07-09 15:14:20
******************************************************************/

import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

/**
 * (UH_DC_ORD_LIS)
 * 
 * @author bianj
 * @version 1.0.0 2017-07-09
 */
@Entity
@Table(name = "UH_DC_ORD_LIS")
public class UhDcOrdLis implements java.io.Serializable {
    /** 版本号 */
    private static final long serialVersionUID = -1568109229701245051L;
    
    /**  */
    @Id
    @Column(name = "PK_ORDLAB" )
    @GenericGenerator(name = "system-uuid", strategy = "uuid")
    @GeneratedValue(generator = "system-uuid")
    private String pkOrdlab;
    
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
    @Column(name = "PURP_LIS" )
    private String purpLis;
    
    /**  */
    @Column(name = "CODE_DEPT_REQ" )
    private String codeDeptReq;
    
    /**  */
    @Column(name = "NAME_DEPT_REQ" )
    private String nameDeptReq;
    
    /**  */
    @Column(name = "CODE_EU_TYPE" )
    private String codeEuType;
    
    /**  */
    @Column(name = "NAME_EU_TYPE" )
    private String nameEuType;
    
    /**  */
    @Column(name = "CODE_SRV" )
    private String codeSrv;
    
    /**  */
    @Column(name = "NAME_SRV" )
    private String nameSrv;
    
    /**  */
    @Column(name = "CODE_PSN_REQ" )
    private String codePsnReq;
    
    /**  */
    @Column(name = "NAME_PSN_REQ" )
    private String namePsnReq;
    
    /**  */
    @Column(name = "CODE_SAMPTYPE" )
    private String codeSamptype;
    
    /**  */
    @Column(name = "NAME_SAMPTYPE" )
    private String nameSamptype;
    
    /**  */
    @Column(name = "DATE_LAB" )
    private String dateLab;
    
    /**  */
    @Column(name = "CODE_CURRY_PSN" )
    private String codeCurryPsn;
    
    /**  */
    @Column(name = "NAME_CURRY_PSN" )
    private String nameCurryPsn;
    
    /**  */
    @Column(name = "DATE_CURRY" )
    private String dateCurry;
    
    /**  */
    @Column(name = "CODE_PSN_REC" )
    private String codePsnRec;
    
    /**  */
    @Column(name = "NAME_PSN_REC" )
    private String namePsnRec;
    
    /**  */
    @Column(name = "DATE_REC" )
    private String dateRec;
    
    /**  */
    @Column(name = "FLAG_URGENT" )
    private Integer flagUrgent;
    
    /**  */
    @Column(name = "TELE_RESULT" )
    private String teleResult;
    
    /**  */
    @Column(name = "FEE" )
    private BigDecimal fee;
    
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
     * 获取pkOrdlab
     * 
     * @return pkOrdlab
     */
    public String getPkOrdlab() {
        return this.pkOrdlab;
    }
     
    /**
     * 设置pkOrdlab
     * 
     * @param pkOrdlab
     *          pkOrdlab
     */
    public void setPkOrdlab(String pkOrdlab) {
        this.pkOrdlab = pkOrdlab;
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
     * 获取purpLis
     * 
     * @return purpLis
     */
    public String getPurpLis() {
        return this.purpLis;
    }
     
    /**
     * 设置purpLis
     * 
     * @param purpLis
     *          purpLis
     */
    public void setPurpLis(String purpLis) {
        this.purpLis = purpLis;
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
     * 获取codeSamptype
     * 
     * @return codeSamptype
     */
    public String getCodeSamptype() {
        return this.codeSamptype;
    }
     
    /**
     * 设置codeSamptype
     * 
     * @param codeSamptype
     *          codeSamptype
     */
    public void setCodeSamptype(String codeSamptype) {
        this.codeSamptype = codeSamptype;
    }
    
    /**
     * 获取nameSamptype
     * 
     * @return nameSamptype
     */
    public String getNameSamptype() {
        return this.nameSamptype;
    }
     
    /**
     * 设置nameSamptype
     * 
     * @param nameSamptype
     *          nameSamptype
     */
    public void setNameSamptype(String nameSamptype) {
        this.nameSamptype = nameSamptype;
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
     * 获取codeCurryPsn
     * 
     * @return codeCurryPsn
     */
    public String getCodeCurryPsn() {
        return this.codeCurryPsn;
    }
     
    /**
     * 设置codeCurryPsn
     * 
     * @param codeCurryPsn
     *          codeCurryPsn
     */
    public void setCodeCurryPsn(String codeCurryPsn) {
        this.codeCurryPsn = codeCurryPsn;
    }
    
    /**
     * 获取nameCurryPsn
     * 
     * @return nameCurryPsn
     */
    public String getNameCurryPsn() {
        return this.nameCurryPsn;
    }
     
    /**
     * 设置nameCurryPsn
     * 
     * @param nameCurryPsn
     *          nameCurryPsn
     */
    public void setNameCurryPsn(String nameCurryPsn) {
        this.nameCurryPsn = nameCurryPsn;
    }
    
    /**
     * 获取dateCurry
     * 
     * @return dateCurry
     */
    public String getDateCurry() {
        return this.dateCurry;
    }
     
    /**
     * 设置dateCurry
     * 
     * @param dateCurry
     *          dateCurry
     */
    public void setDateCurry(String dateCurry) {
        this.dateCurry = dateCurry;
    }
    
    /**
     * 获取codePsnRec
     * 
     * @return codePsnRec
     */
    public String getCodePsnRec() {
        return this.codePsnRec;
    }
     
    /**
     * 设置codePsnRec
     * 
     * @param codePsnRec
     *          codePsnRec
     */
    public void setCodePsnRec(String codePsnRec) {
        this.codePsnRec = codePsnRec;
    }
    
    /**
     * 获取namePsnRec
     * 
     * @return namePsnRec
     */
    public String getNamePsnRec() {
        return this.namePsnRec;
    }
     
    /**
     * 设置namePsnRec
     * 
     * @param namePsnRec
     *          namePsnRec
     */
    public void setNamePsnRec(String namePsnRec) {
        this.namePsnRec = namePsnRec;
    }
    
    /**
     * 获取dateRec
     * 
     * @return dateRec
     */
    public String getDateRec() {
        return this.dateRec;
    }
     
    /**
     * 设置dateRec
     * 
     * @param dateRec
     *          dateRec
     */
    public void setDateRec(String dateRec) {
        this.dateRec = dateRec;
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
     * 获取teleResult
     * 
     * @return teleResult
     */
    public String getTeleResult() {
        return this.teleResult;
    }
     
    /**
     * 设置teleResult
     * 
     * @param teleResult
     *          teleResult
     */
    public void setTeleResult(String teleResult) {
        this.teleResult = teleResult;
    }
    
    /**
     * 获取fee
     * 
     * @return fee
     */
    public BigDecimal getFee() {
        return this.fee;
    }
     
    /**
     * 设置fee
     * 
     * @param fee
     *          fee
     */
    public void setFee(BigDecimal fee) {
        this.fee = fee;
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