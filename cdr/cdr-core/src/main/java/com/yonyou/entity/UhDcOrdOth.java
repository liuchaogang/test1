package com.yonyou.entity;
/******************************************************************
** 类    名：UhDcOrdOthEntity
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
 * (UH_DC_ORD_OTH)
 * 
 * @author bianj
 * @version 1.0.0 2017-07-06
 */
@Entity
@Table(name = "UH_DC_ORD_OTH", schema = "dbo", catalog = "MIP_DC_DEMO")
public class UhDcOrdOth implements java.io.Serializable {
    /** 版本号 */
    private static final long serialVersionUID = -2885145268974731716L;
    
    /**  */
    @Column(name = "PK_DCORD" )
    private String pkDcord;
    
    /**  */
    @Id
    @Column(name = "PK_MSPORD")
    @GenericGenerator(name = "system-uuid", strategy = "uuid")
    @GeneratedValue(generator = "system-uuid")
    private String pkMspord;
    
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
    @Column(name = "PURPOSE" )
    private String purpose;
    
    /**  */
    @Column(name = "DATE_APP" )
    private String dateApp;
    
    /**  */
    @Column(name = "CODE_MSP" )
    private String codeMsp;
    
    /**  */
    @Column(name = "NAME_MSP" )
    private String nameMsp;
    
    /**  */
    @Column(name = "DATE_RESERVATION" )
    private String dateReservation;
    
    /**  */
    @Column(name = "BEGIN_TIME" )
    private String beginTime;
    
    /**  */
    @Column(name = "STATE_REQ" )
    private String stateReq;
    
    /**  */
    @Column(name = "FLAG_URGENT")
    private Integer flagUrgent;
    
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
     * 获取pkMspord
     * 
     * @return pkMspord
     */
    public String getPkMspord() {
        return this.pkMspord;
    }
     
    /**
     * 设置pkMspord
     * 
     * @param pkMspord
     *          pkMspord
     */
    public void setPkMspord(String pkMspord) {
        this.pkMspord = pkMspord;
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
     * 获取purpose
     * 
     * @return purpose
     */
    public String getPurpose() {
        return this.purpose;
    }
     
    /**
     * 设置purpose
     * 
     * @param purpose
     *          purpose
     */
    public void setPurpose(String purpose) {
        this.purpose = purpose;
    }
    
    /**
     * 获取dateApp
     * 
     * @return dateApp
     */
    public String getDateApp() {
        return this.dateApp;
    }
     
    /**
     * 设置dateApp
     * 
     * @param dateApp
     *          dateApp
     */
    public void setDateApp(String dateApp) {
        this.dateApp = dateApp;
    }
    
    /**
     * 获取codeMsp
     * 
     * @return codeMsp
     */
    public String getCodeMsp() {
        return this.codeMsp;
    }
     
    /**
     * 设置codeMsp
     * 
     * @param codeMsp
     *          codeMsp
     */
    public void setCodeMsp(String codeMsp) {
        this.codeMsp = codeMsp;
    }
    
    /**
     * 获取nameMsp
     * 
     * @return nameMsp
     */
    public String getNameMsp() {
        return this.nameMsp;
    }
     
    /**
     * 设置nameMsp
     * 
     * @param nameMsp
     *          nameMsp
     */
    public void setNameMsp(String nameMsp) {
        this.nameMsp = nameMsp;
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
     * 获取beginTime
     * 
     * @return beginTime
     */
    public String getBeginTime() {
        return this.beginTime;
    }
     
    /**
     * 设置beginTime
     * 
     * @param beginTime
     *          beginTime
     */
    public void setBeginTime(String beginTime) {
        this.beginTime = beginTime;
    }
    
    /**
     * 获取stateReq
     * 
     * @return stateReq
     */
    public String getStateReq() {
        return this.stateReq;
    }
     
    /**
     * 设置stateReq
     * 
     * @param stateReq
     *          stateReq
     */
    public void setStateReq(String stateReq) {
        this.stateReq = stateReq;
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