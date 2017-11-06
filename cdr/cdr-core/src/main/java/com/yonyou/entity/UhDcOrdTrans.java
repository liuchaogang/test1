package com.yonyou.entity;
/******************************************************************
** 类    名：UhDcOrdTransEntity
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
 * (UH_DC_ORD_TRANS)
 * 
 * @author bianj
 * @version 1.0.0 2017-07-09
 */
@Entity
@Table(name = "UH_DC_ORD_TRANS")
public class UhDcOrdTrans implements java.io.Serializable {
    /** 版本号 */
    private static final long serialVersionUID = 1735233785578346202L;
    
    /**  */
    @Id
    @Column(name = "PK_ORD_BT")
    @GenericGenerator(name = "system-uuid", strategy = "uuid")
    @GeneratedValue(generator = "system-uuid")
    private String pkOrdBt;
    
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
    @Column(name = "PV_TIME" )
    private Integer pvTime;
    
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
    @Column(name = "CODE_BTTYPE")
    private String codeBttype;
    
    /**  */
    @Column(name = "NAME_BTTYPE" )
    private String nameBttype;
    
    /**  */
    @Column(name = "CODE_BLOOD_ABO" )
    private String codeBloodAbo;
    
    /**  */
    @Column(name = "NAME_BLOOD_ABO")
    private String nameBloodAbo;
    
    /**  */
    @Column(name = "CODE_BLOOD_RH")
    private String codeBloodRh;
    
    /**  */
    @Column(name = "NAME_BLOOD_RH")
    private String nameBloodRh;
    
    /**  */
    @Column(name = "FLAG_LAB" )
    private Integer flagLab;
    
    /**  */
    @Column(name = "FLAG_BTHIST" )
    private Integer flagBthist;
    
    /**  */
    @Column(name = "BTCONT")
    private String btcont;
    
    /**  */
    @Column(name = "UNIT_BT" )
    private String unitBt;
    
    /**  */
    @Column(name = "QUAN_BT" )
    private Integer quanBt;
    
    /**  */
    @Column(name = "DATE_BP_APP" )
    private String dateBpApp;
    
    /**  */
    @Column(name = "FLAG_PREGHIST" )
    private Integer flagPreghist;
    
    /**  */
    @Column(name = "FLAG_ALLERGY" )
    private Integer flagAllergy;
    
    /**  */
    @Column(name = "FLAG_BP" )
    private Integer flagBp;
    
    /**  */
    @Column(name = "DATE_BP" )
    private String dateBp;
    
    /**  */
    @Column(name = "COUNT_BP" )
    private Integer countBp;
    
    /**  */
    @Column(name = "BBNOS" )
    private String bbnos;
    
    /**  */
    @Column(name = "NAME_PSN_BP" )
    private String namePsnBp;
    
    /**  */
    @Column(name = "CODE_PSN_BP" )
    private String codePsnBp;
    
    /**  */
    @Column(name = "BLOOD_PRO_STATE" )
    private String bloodProState;
    
    /**  */
    @Column(name = "ANTI_SCREEN" )
    private String antiScreen;
    
    /**  */
    @Column(name = "USE_TYPE" )
    private String useType;
    
    /**  */
    @Column(name = "TIME_USE" )
    private String timeUse;
    
    /**  */
    @Column(name = "TRANS_COM_NUM" )
    private String transComNum;
    
    /**  */
    @Column(name = "CODE_BLOOD_STATE" )
    private String codeBloodState;
    
    /**  */
    @Column(name = "NAME_BLOOD_STATE" )
    private String nameBloodState;
    
    /**  */
    @Column(name = "USE_PURP" )
    private String usePurp;
    
    /**  */
    @Column(name = "BLOOD_TYPE" )
    private String bloodType;
    
    /**  */
    @Column(name = "BLOOD_RECORD_THIS" )
    private String bloodRecordThis;
    
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
    @Column(name = "DATE_APPLY" )
    private String dateApply;
    
    /**  */
    @Column(name = "IS_CG" )
    private Integer isCg;
    
    /**  */
    @Column(name = "FEE" )
    private BigDecimal fee;
    
    /**  */
    @Column(name = "FEE_TYPE" )
    private String feeType;
    
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
     * 获取pkOrdBt
     * 
     * @return pkOrdBt
     */
    public String getPkOrdBt() {
        return this.pkOrdBt;
    }
     
    /**
     * 设置pkOrdBt
     * 
     * @param pkOrdBt
     *          pkOrdBt
     */
    public void setPkOrdBt(String pkOrdBt) {
        this.pkOrdBt = pkOrdBt;
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
     * 获取pvTime
     * 
     * @return pvTime
     */
    public Integer getPvTime() {
        return this.pvTime;
    }
     
    /**
     * 设置pvTime
     * 
     * @param pvTime
     *          pvTime
     */
    public void setPvTime(Integer pvTime) {
        this.pvTime = pvTime;
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
     * 获取codeBttype
     * 
     * @return codeBttype
     */
    public String getCodeBttype() {
        return this.codeBttype;
    }
     
    /**
     * 设置codeBttype
     * 
     * @param codeBttype
     *          codeBttype
     */
    public void setCodeBttype(String codeBttype) {
        this.codeBttype = codeBttype;
    }
    
    /**
     * 获取nameBttype
     * 
     * @return nameBttype
     */
    public String getNameBttype() {
        return this.nameBttype;
    }
     
    /**
     * 设置nameBttype
     * 
     * @param nameBttype
     *          nameBttype
     */
    public void setNameBttype(String nameBttype) {
        this.nameBttype = nameBttype;
    }
    
    /**
     * 获取codeBloodAbo
     * 
     * @return codeBloodAbo
     */
    public String getCodeBloodAbo() {
        return this.codeBloodAbo;
    }
     
    /**
     * 设置codeBloodAbo
     * 
     * @param codeBloodAbo
     *          codeBloodAbo
     */
    public void setCodeBloodAbo(String codeBloodAbo) {
        this.codeBloodAbo = codeBloodAbo;
    }
    
    /**
     * 获取nameBloodAbo
     * 
     * @return nameBloodAbo
     */
    public String getNameBloodAbo() {
        return this.nameBloodAbo;
    }
     
    /**
     * 设置nameBloodAbo
     * 
     * @param nameBloodAbo
     *          nameBloodAbo
     */
    public void setNameBloodAbo(String nameBloodAbo) {
        this.nameBloodAbo = nameBloodAbo;
    }
    
    /**
     * 获取codeBloodRh
     * 
     * @return codeBloodRh
     */
    public String getCodeBloodRh() {
        return this.codeBloodRh;
    }
     
    /**
     * 设置codeBloodRh
     * 
     * @param codeBloodRh
     *          codeBloodRh
     */
    public void setCodeBloodRh(String codeBloodRh) {
        this.codeBloodRh = codeBloodRh;
    }
    
    /**
     * 获取nameBloodRh
     * 
     * @return nameBloodRh
     */
    public String getNameBloodRh() {
        return this.nameBloodRh;
    }
     
    /**
     * 设置nameBloodRh
     * 
     * @param nameBloodRh
     *          nameBloodRh
     */
    public void setNameBloodRh(String nameBloodRh) {
        this.nameBloodRh = nameBloodRh;
    }
    
    /**
     * 获取flagLab
     * 
     * @return flagLab
     */
    public Integer getFlagLab() {
        return this.flagLab;
    }
     
    /**
     * 设置flagLab
     * 
     * @param flagLab
     *          flagLab
     */
    public void setFlagLab(Integer flagLab) {
        this.flagLab = flagLab;
    }
    
    /**
     * 获取flagBthist
     * 
     * @return flagBthist
     */
    public Integer getFlagBthist() {
        return this.flagBthist;
    }
     
    /**
     * 设置flagBthist
     * 
     * @param flagBthist
     *          flagBthist
     */
    public void setFlagBthist(Integer flagBthist) {
        this.flagBthist = flagBthist;
    }
    
    /**
     * 获取btcont
     * 
     * @return btcont
     */
    public String getBtcont() {
        return this.btcont;
    }
     
    /**
     * 设置btcont
     * 
     * @param btcont
     *          btcont
     */
    public void setBtcont(String btcont) {
        this.btcont = btcont;
    }
    
    /**
     * 获取unitBt
     * 
     * @return unitBt
     */
    public String getUnitBt() {
        return this.unitBt;
    }
     
    /**
     * 设置unitBt
     * 
     * @param unitBt
     *          unitBt
     */
    public void setUnitBt(String unitBt) {
        this.unitBt = unitBt;
    }
    
    /**
     * 获取quanBt
     * 
     * @return quanBt
     */
    public Integer getQuanBt() {
        return this.quanBt;
    }
     
    /**
     * 设置quanBt
     * 
     * @param quanBt
     *          quanBt
     */
    public void setQuanBt(Integer quanBt) {
        this.quanBt = quanBt;
    }
    
    /**
     * 获取dateBpApp
     * 
     * @return dateBpApp
     */
    public String getDateBpApp() {
        return this.dateBpApp;
    }
     
    /**
     * 设置dateBpApp
     * 
     * @param dateBpApp
     *          dateBpApp
     */
    public void setDateBpApp(String dateBpApp) {
        this.dateBpApp = dateBpApp;
    }
    
    /**
     * 获取flagPreghist
     * 
     * @return flagPreghist
     */
    public Integer getFlagPreghist() {
        return this.flagPreghist;
    }
     
    /**
     * 设置flagPreghist
     * 
     * @param flagPreghist
     *          flagPreghist
     */
    public void setFlagPreghist(Integer flagPreghist) {
        this.flagPreghist = flagPreghist;
    }
    
    /**
     * 获取flagAllergy
     * 
     * @return flagAllergy
     */
    public Integer getFlagAllergy() {
        return this.flagAllergy;
    }
     
    /**
     * 设置flagAllergy
     * 
     * @param flagAllergy
     *          flagAllergy
     */
    public void setFlagAllergy(Integer flagAllergy) {
        this.flagAllergy = flagAllergy;
    }
    
    /**
     * 获取flagBp
     * 
     * @return flagBp
     */
    public Integer getFlagBp() {
        return this.flagBp;
    }
     
    /**
     * 设置flagBp
     * 
     * @param flagBp
     *          flagBp
     */
    public void setFlagBp(Integer flagBp) {
        this.flagBp = flagBp;
    }
    
    /**
     * 获取dateBp
     * 
     * @return dateBp
     */
    public String getDateBp() {
        return this.dateBp;
    }
     
    /**
     * 设置dateBp
     * 
     * @param dateBp
     *          dateBp
     */
    public void setDateBp(String dateBp) {
        this.dateBp = dateBp;
    }
    
    /**
     * 获取countBp
     * 
     * @return countBp
     */
    public Integer getCountBp() {
        return this.countBp;
    }
     
    /**
     * 设置countBp
     * 
     * @param countBp
     *          countBp
     */
    public void setCountBp(Integer countBp) {
        this.countBp = countBp;
    }
    
    /**
     * 获取bbnos
     * 
     * @return bbnos
     */
    public String getBbnos() {
        return this.bbnos;
    }
     
    /**
     * 设置bbnos
     * 
     * @param bbnos
     *          bbnos
     */
    public void setBbnos(String bbnos) {
        this.bbnos = bbnos;
    }
    
    /**
     * 获取namePsnBp
     * 
     * @return namePsnBp
     */
    public String getNamePsnBp() {
        return this.namePsnBp;
    }
     
    /**
     * 设置namePsnBp
     * 
     * @param namePsnBp
     *          namePsnBp
     */
    public void setNamePsnBp(String namePsnBp) {
        this.namePsnBp = namePsnBp;
    }
    
    /**
     * 获取codePsnBp
     * 
     * @return codePsnBp
     */
    public String getCodePsnBp() {
        return this.codePsnBp;
    }
     
    /**
     * 设置codePsnBp
     * 
     * @param codePsnBp
     *          codePsnBp
     */
    public void setCodePsnBp(String codePsnBp) {
        this.codePsnBp = codePsnBp;
    }
    
    /**
     * 获取bloodProState
     * 
     * @return bloodProState
     */
    public String getBloodProState() {
        return this.bloodProState;
    }
     
    /**
     * 设置bloodProState
     * 
     * @param bloodProState
     *          bloodProState
     */
    public void setBloodProState(String bloodProState) {
        this.bloodProState = bloodProState;
    }
    
    /**
     * 获取antiScreen
     * 
     * @return antiScreen
     */
    public String getAntiScreen() {
        return this.antiScreen;
    }
     
    /**
     * 设置antiScreen
     * 
     * @param antiScreen
     *          antiScreen
     */
    public void setAntiScreen(String antiScreen) {
        this.antiScreen = antiScreen;
    }
    
    /**
     * 获取useType
     * 
     * @return useType
     */
    public String getUseType() {
        return this.useType;
    }
     
    /**
     * 设置useType
     * 
     * @param useType
     *          useType
     */
    public void setUseType(String useType) {
        this.useType = useType;
    }
    
    /**
     * 获取timeUse
     * 
     * @return timeUse
     */
    public String getTimeUse() {
        return this.timeUse;
    }
     
    /**
     * 设置timeUse
     * 
     * @param timeUse
     *          timeUse
     */
    public void setTimeUse(String timeUse) {
        this.timeUse = timeUse;
    }
    
    /**
     * 获取transComNum
     * 
     * @return transComNum
     */
    public String getTransComNum() {
        return this.transComNum;
    }
     
    /**
     * 设置transComNum
     * 
     * @param transComNum
     *          transComNum
     */
    public void setTransComNum(String transComNum) {
        this.transComNum = transComNum;
    }
    
    /**
     * 获取codeBloodState
     * 
     * @return codeBloodState
     */
    public String getCodeBloodState() {
        return this.codeBloodState;
    }
     
    /**
     * 设置codeBloodState
     * 
     * @param codeBloodState
     *          codeBloodState
     */
    public void setCodeBloodState(String codeBloodState) {
        this.codeBloodState = codeBloodState;
    }
    
    /**
     * 获取nameBloodState
     * 
     * @return nameBloodState
     */
    public String getNameBloodState() {
        return this.nameBloodState;
    }
     
    /**
     * 设置nameBloodState
     * 
     * @param nameBloodState
     *          nameBloodState
     */
    public void setNameBloodState(String nameBloodState) {
        this.nameBloodState = nameBloodState;
    }
    
    /**
     * 获取usePurp
     * 
     * @return usePurp
     */
    public String getUsePurp() {
        return this.usePurp;
    }
     
    /**
     * 设置usePurp
     * 
     * @param usePurp
     *          usePurp
     */
    public void setUsePurp(String usePurp) {
        this.usePurp = usePurp;
    }
    
    /**
     * 获取bloodType
     * 
     * @return bloodType
     */
    public String getBloodType() {
        return this.bloodType;
    }
     
    /**
     * 设置bloodType
     * 
     * @param bloodType
     *          bloodType
     */
    public void setBloodType(String bloodType) {
        this.bloodType = bloodType;
    }
    
    /**
     * 获取bloodRecordThis
     * 
     * @return bloodRecordThis
     */
    public String getBloodRecordThis() {
        return this.bloodRecordThis;
    }
     
    /**
     * 设置bloodRecordThis
     * 
     * @param bloodRecordThis
     *          bloodRecordThis
     */
    public void setBloodRecordThis(String bloodRecordThis) {
        this.bloodRecordThis = bloodRecordThis;
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
     * 获取dateApply
     * 
     * @return dateApply
     */
    public String getDateApply() {
        return this.dateApply;
    }
     
    /**
     * 设置dateApply
     * 
     * @param dateApply
     *          dateApply
     */
    public void setDateApply(String dateApply) {
        this.dateApply = dateApply;
    }
    
    /**
     * 获取isCg
     * 
     * @return isCg
     */
    public Integer getIsCg() {
        return this.isCg;
    }
     
    /**
     * 设置isCg
     * 
     * @param isCg
     *          isCg
     */
    public void setIsCg(Integer isCg) {
        this.isCg = isCg;
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
     * 获取feeType
     * 
     * @return feeType
     */
    public String getFeeType() {
        return this.feeType;
    }
     
    /**
     * 设置feeType
     * 
     * @param feeType
     *          feeType
     */
    public void setFeeType(String feeType) {
        this.feeType = feeType;
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