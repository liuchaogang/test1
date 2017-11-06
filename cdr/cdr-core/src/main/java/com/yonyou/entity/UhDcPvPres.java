package com.yonyou.entity;
/******************************************************************
** 类    名：UhDcPvPresEntity
** 描    述：
** 创 建 者：bianj
** 创建时间：2017-07-08 10:51:00
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
 * (UH_DC_PV_PRES)
 * 
 * @author bianj
 * @version 1.0.0 2017-07-08
 */
@Entity
@Table(name = "UH_DC_PV_PRES", schema = "dbo", catalog = "MIP_DC_DEMO")
public class UhDcPvPres implements java.io.Serializable {
    /** 版本号 */
    private static final long serialVersionUID = 3837041978187210165L;
    
    /**  */
    @Id
    @Column(name = "PK_PRES")
    @GenericGenerator(name = "system-uuid", strategy = "uuid")
    @GeneratedValue(generator = "system-uuid")
    private String pkPres;
    
    /** 外键 */
    @Column(name = "PK_DCPV")
    private String pkDcpv;
    
    /**  */
    @Column(name = "CODE_GROUP")
    private String codeGroup;
    
    /**  */
    @Column(name = "CODE_ORG")
    private String codeOrg;
    
    /**  */
    @Column(name = "EMPI")
    private String empi;
    
    /** 患者编码（病历号） */
    @Column(name = "CODE_PATI")
    private String codePati;
    
    /** DICT_JZLX */
    @Column(name = "CODE_PVTYPE")
    private String codePvtype;
    
    /**  */
    @Column(name = "NAME_PVTYPE")
    private String namePvtype;
    
    /** 门诊号/住院号 */
    @Column(name = "PVCODE")
    private String pvcode;
    
    /**  */
    @Column(name = "PATINAME")
    private String patiname;
    
    /**  */
    @Column(name = "CODE_SEX")
    private String codeSex;
    
    /**  */
    @Column(name = "NAME_SEX")
    private String nameSex;
    
    /**  */
    @Column(name = "BIRTHDAY")
    private String birthday;
    
    /**  */
    @Column(name = "ADDR_PRE")
    private String addrPre;
    
    /**  */
    @Column(name = "TELENO_PRE")
    private String telenoPre;
    
    /** D 普通处方
   Y  处方（中成药）
   Z 中草药处方
    */
    @Column(name = "CODE_PRES_TYPE")
    private String codePresType;
    
    /**  */
    @Column(name = "NAME_PRES_TYPE")
    private String namePresType;
    
    /** D	处方
   DS	停处方
   Y	处方（中成药）
   Z	处方（中草药） */
    @Column(name = "CODE_ORDMEDI_TYPE")
    private String codeOrdmediType;
    
    /**  */
    @Column(name = "NAME_ORDMEDI_TYPE")
    private String nameOrdmediType;
    
    /**  */
    @Column(name = "FEE")
    private BigDecimal fee;
    
    /**  */
    @Column(name = "CODE_DIAG")
    private String codeDiag;
    
    /**  */
    @Column(name = "NAME_DIAG")
    private String nameDiag;
    
    /** 门诊处方组号（含西药，中草药） */
    @Column(name = "CODE_PRES")
    private String codePres;
    
    /** 中药贴数 */
    @Column(name = "CHINESE_NUM")
    private Integer chineseNum;
    
    /** 中药味数 */
    @Column(name = "CHINESE_NUMT")
    private Integer chineseNumt;
    
    /**  */
    @Column(name = "DATE_CREATE")
    private String dateCreate;
    
    /**  */
    @Column(name = "CODE_PSN_PHY")
    private String codePsnPhy;
    
    /**  */
    @Column(name = "NAME_PSN_PHY")
    private String namePsnPhy;
    
    /**  */
    @Column(name = "CODE_DETP_PHY")
    private String codeDetpPhy;
    
    /**  */
    @Column(name = "NAME_DEPT_PHY")
    private String nameDeptPhy;
    
    /**  */
    @Column(name = "CODE_PSN_CONF")
    private String codePsnConf;
    
    /**  */
    @Column(name = "NAME_PSN_CONF")
    private String namePsnConf;
    
    /**  */
    @Column(name = "CODE_PSN_AUDIT")
    private String codePsnAudit;
    
    /**  */
    @Column(name = "NAME_PSN_AUDIT")
    private String namePsnAudit;
    
    /**  */
    @Column(name = "CODE_PSN_SEND")
    private String codePsnSend;
    
    /**  */
    @Column(name = "NAME_PSN_SEND")
    private String namePsnSend;
    
    /**  */
    @Column(name = "CODE_DEPT_SEND")
    private String codeDeptSend;
    
    /**  */
    @Column(name = "NAME_DEPT_SEND")
    private String nameDeptSend;
    
    /**  */
    @Column(name = "CODE_DEPT_MED")
    private String codeDeptMed;
    
    /**  */
    @Column(name = "NAME_DEPT_MED")
    private String nameDeptMed;
    
    /** 0是，1否 */
    @Column(name = "FLAG_NEWBORN")
    private Integer flagNewborn;
    
    /**  */
    @Column(name = "NEWBORN")
    private Integer newborn;
    
    /**  */
    @Column(name = "NOTE")
    private String note;
    
    /**  */
    @Column(name = "DATA_SOURCE")
    private String dataSource;
    
    /**  */
    @Column(name = "SOURCE_PK")
    private String sourcePk;
    
    /**  */
    @Column(name = "CREATE_TIME")
    private Date createTime;
    
    /**  */
    @Column(name = "EDIT_TIME")
    private Date editTime;
    
    /** 0正常，1Nosql迁移，2业务删除 */
    @Column(name = "FLAG_DEL")
    private Integer flagDel;
    
    /**
     * 获取pkPres
     * 
     * @return pkPres
     */
    public String getPkPres() {
        return this.pkPres;
    }
     
    /**
     * 设置pkPres
     * 
     * @param pkPres
     *          pkPres
     */
    public void setPkPres(String pkPres) {
        this.pkPres = pkPres;
    }
    
    /**
     * 获取外键
     * 
     * @return 外键
     */
    public String getPkDcpv() {
        return this.pkDcpv;
    }
     
    /**
     * 设置外键
     * 
     * @param pkDcpv
     *          外键
     */
    public void setPkDcpv(String pkDcpv) {
        this.pkDcpv = pkDcpv;
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
     * 获取患者编码（病历号）
     * 
     * @return 患者编码（病历号）
     */
    public String getCodePati() {
        return this.codePati;
    }
     
    /**
     * 设置患者编码（病历号）
     * 
     * @param codePati
     *          患者编码（病历号）
     */
    public void setCodePati(String codePati) {
        this.codePati = codePati;
    }
    
    /**
     * 获取DICT_JZLX
     * 
     * @return DICT_JZLX
     */
    public String getCodePvtype() {
        return this.codePvtype;
    }
     
    /**
     * 设置DICT_JZLX
     * 
     * @param codePvtype
     *          DICT_JZLX
     */
    public void setCodePvtype(String codePvtype) {
        this.codePvtype = codePvtype;
    }
    
    /**
     * 获取namePvtype
     * 
     * @return namePvtype
     */
    public String getNamePvtype() {
        return this.namePvtype;
    }
     
    /**
     * 设置namePvtype
     * 
     * @param namePvtype
     *          namePvtype
     */
    public void setNamePvtype(String namePvtype) {
        this.namePvtype = namePvtype;
    }
    
    /**
     * 获取门诊号/住院号
     * 
     * @return 门诊号/住院号
     */
    public String getPvcode() {
        return this.pvcode;
    }
     
    /**
     * 设置门诊号/住院号
     * 
     * @param pvcode
     *          门诊号/住院号
     */
    public void setPvcode(String pvcode) {
        this.pvcode = pvcode;
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
     * 获取D 普通处方
   Y  处方（中成药）
   Z 中草药处方
   
     * 
     * @return D 普通处方
   Y  处方（中成药）
   Z 中草药处方
   
     */
    public String getCodePresType() {
        return this.codePresType;
    }
     
    /**
     * 设置D 普通处方
   Y  处方（中成药）
   Z 中草药处方
   
     * 
     * @param codePresType
     *          D 普通处方
   Y  处方（中成药）
   Z 中草药处方
   
     */
    public void setCodePresType(String codePresType) {
        this.codePresType = codePresType;
    }
    
    /**
     * 获取namePresType
     * 
     * @return namePresType
     */
    public String getNamePresType() {
        return this.namePresType;
    }
     
    /**
     * 设置namePresType
     * 
     * @param namePresType
     *          namePresType
     */
    public void setNamePresType(String namePresType) {
        this.namePresType = namePresType;
    }
    
    /**
     * 获取D	处方
   DS	停处方
   Y	处方（中成药）
   Z	处方（中草药）
     * 
     * @return D	处方
   DS	停处方
   Y	处方（中成药）
   Z	处方（中草药）
     */
    public String getCodeOrdmediType() {
        return this.codeOrdmediType;
    }
     
    /**
     * 设置D	处方
   DS	停处方
   Y	处方（中成药）
   Z	处方（中草药）
     * 
     * @param codeOrdmediType
     *          D	处方
   DS	停处方
   Y	处方（中成药）
   Z	处方（中草药）
     */
    public void setCodeOrdmediType(String codeOrdmediType) {
        this.codeOrdmediType = codeOrdmediType;
    }
    
    /**
     * 获取nameOrdmediType
     * 
     * @return nameOrdmediType
     */
    public String getNameOrdmediType() {
        return this.nameOrdmediType;
    }
     
    /**
     * 设置nameOrdmediType
     * 
     * @param nameOrdmediType
     *          nameOrdmediType
     */
    public void setNameOrdmediType(String nameOrdmediType) {
        this.nameOrdmediType = nameOrdmediType;
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
     * 获取门诊处方组号（含西药，中草药）
     * 
     * @return 门诊处方组号（含西药
     */
    public String getCodePres() {
        return this.codePres;
    }
     
    /**
     * 设置门诊处方组号（含西药，中草药）
     * 
     * @param codePres
     *          门诊处方组号（含西药，中草药）
     */
    public void setCodePres(String codePres) {
        this.codePres = codePres;
    }
    
    /**
     * 获取中药贴数
     * 
     * @return 中药贴数
     */
    public Integer getChineseNum() {
        return this.chineseNum;
    }
     
    /**
     * 设置中药贴数
     * 
     * @param chineseNum
     *          中药贴数
     */
    public void setChineseNum(Integer chineseNum) {
        this.chineseNum = chineseNum;
    }
    
    /**
     * 获取中药味数
     * 
     * @return 中药味数
     */
    public Integer getChineseNumt() {
        return this.chineseNumt;
    }
     
    /**
     * 设置中药味数
     * 
     * @param chineseNumt
     *          中药味数
     */
    public void setChineseNumt(Integer chineseNumt) {
        this.chineseNumt = chineseNumt;
    }
    
    /**
     * 获取dateCreate
     * 
     * @return dateCreate
     */
    public String getDateCreate() {
        return this.dateCreate;
    }
     
    /**
     * 设置dateCreate
     * 
     * @param dateCreate
     *          dateCreate
     */
    public void setDateCreate(String dateCreate) {
        this.dateCreate = dateCreate;
    }
    
    /**
     * 获取codePsnPhy
     * 
     * @return codePsnPhy
     */
    public String getCodePsnPhy() {
        return this.codePsnPhy;
    }
     
    /**
     * 设置codePsnPhy
     * 
     * @param codePsnPhy
     *          codePsnPhy
     */
    public void setCodePsnPhy(String codePsnPhy) {
        this.codePsnPhy = codePsnPhy;
    }
    
    /**
     * 获取namePsnPhy
     * 
     * @return namePsnPhy
     */
    public String getNamePsnPhy() {
        return this.namePsnPhy;
    }
     
    /**
     * 设置namePsnPhy
     * 
     * @param namePsnPhy
     *          namePsnPhy
     */
    public void setNamePsnPhy(String namePsnPhy) {
        this.namePsnPhy = namePsnPhy;
    }
    
    /**
     * 获取codeDetpPhy
     * 
     * @return codeDetpPhy
     */
    public String getCodeDetpPhy() {
        return this.codeDetpPhy;
    }
     
    /**
     * 设置codeDetpPhy
     * 
     * @param codeDetpPhy
     *          codeDetpPhy
     */
    public void setCodeDetpPhy(String codeDetpPhy) {
        this.codeDetpPhy = codeDetpPhy;
    }
    
    /**
     * 获取nameDeptPhy
     * 
     * @return nameDeptPhy
     */
    public String getNameDeptPhy() {
        return this.nameDeptPhy;
    }
     
    /**
     * 设置nameDeptPhy
     * 
     * @param nameDeptPhy
     *          nameDeptPhy
     */
    public void setNameDeptPhy(String nameDeptPhy) {
        this.nameDeptPhy = nameDeptPhy;
    }
    
    /**
     * 获取codePsnConf
     * 
     * @return codePsnConf
     */
    public String getCodePsnConf() {
        return this.codePsnConf;
    }
     
    /**
     * 设置codePsnConf
     * 
     * @param codePsnConf
     *          codePsnConf
     */
    public void setCodePsnConf(String codePsnConf) {
        this.codePsnConf = codePsnConf;
    }
    
    /**
     * 获取namePsnConf
     * 
     * @return namePsnConf
     */
    public String getNamePsnConf() {
        return this.namePsnConf;
    }
     
    /**
     * 设置namePsnConf
     * 
     * @param namePsnConf
     *          namePsnConf
     */
    public void setNamePsnConf(String namePsnConf) {
        this.namePsnConf = namePsnConf;
    }
    
    /**
     * 获取codePsnAudit
     * 
     * @return codePsnAudit
     */
    public String getCodePsnAudit() {
        return this.codePsnAudit;
    }
     
    /**
     * 设置codePsnAudit
     * 
     * @param codePsnAudit
     *          codePsnAudit
     */
    public void setCodePsnAudit(String codePsnAudit) {
        this.codePsnAudit = codePsnAudit;
    }
    
    /**
     * 获取namePsnAudit
     * 
     * @return namePsnAudit
     */
    public String getNamePsnAudit() {
        return this.namePsnAudit;
    }
     
    /**
     * 设置namePsnAudit
     * 
     * @param namePsnAudit
     *          namePsnAudit
     */
    public void setNamePsnAudit(String namePsnAudit) {
        this.namePsnAudit = namePsnAudit;
    }
    
    /**
     * 获取codePsnSend
     * 
     * @return codePsnSend
     */
    public String getCodePsnSend() {
        return this.codePsnSend;
    }
     
    /**
     * 设置codePsnSend
     * 
     * @param codePsnSend
     *          codePsnSend
     */
    public void setCodePsnSend(String codePsnSend) {
        this.codePsnSend = codePsnSend;
    }
    
    /**
     * 获取namePsnSend
     * 
     * @return namePsnSend
     */
    public String getNamePsnSend() {
        return this.namePsnSend;
    }
     
    /**
     * 设置namePsnSend
     * 
     * @param namePsnSend
     *          namePsnSend
     */
    public void setNamePsnSend(String namePsnSend) {
        this.namePsnSend = namePsnSend;
    }
    
    /**
     * 获取codeDeptSend
     * 
     * @return codeDeptSend
     */
    public String getCodeDeptSend() {
        return this.codeDeptSend;
    }
     
    /**
     * 设置codeDeptSend
     * 
     * @param codeDeptSend
     *          codeDeptSend
     */
    public void setCodeDeptSend(String codeDeptSend) {
        this.codeDeptSend = codeDeptSend;
    }
    
    /**
     * 获取nameDeptSend
     * 
     * @return nameDeptSend
     */
    public String getNameDeptSend() {
        return this.nameDeptSend;
    }
     
    /**
     * 设置nameDeptSend
     * 
     * @param nameDeptSend
     *          nameDeptSend
     */
    public void setNameDeptSend(String nameDeptSend) {
        this.nameDeptSend = nameDeptSend;
    }
    
    /**
     * 获取codeDeptMed
     * 
     * @return codeDeptMed
     */
    public String getCodeDeptMed() {
        return this.codeDeptMed;
    }
     
    /**
     * 设置codeDeptMed
     * 
     * @param codeDeptMed
     *          codeDeptMed
     */
    public void setCodeDeptMed(String codeDeptMed) {
        this.codeDeptMed = codeDeptMed;
    }
    
    /**
     * 获取nameDeptMed
     * 
     * @return nameDeptMed
     */
    public String getNameDeptMed() {
        return this.nameDeptMed;
    }
     
    /**
     * 设置nameDeptMed
     * 
     * @param nameDeptMed
     *          nameDeptMed
     */
    public void setNameDeptMed(String nameDeptMed) {
        this.nameDeptMed = nameDeptMed;
    }
    
    /**
     * 获取0是，1否
     * 
     * @return 0是
     */
    public Integer getFlagNewborn() {
        return this.flagNewborn;
    }
     
    /**
     * 设置0是，1否
     * 
     * @param flagNewborn
     *          0是，1否
     */
    public void setFlagNewborn(Integer flagNewborn) {
        this.flagNewborn = flagNewborn;
    }
    
    /**
     * 获取newborn
     * 
     * @return newborn
     */
    public Integer getNewborn() {
        return this.newborn;
    }
     
    /**
     * 设置newborn
     * 
     * @param newborn
     *          newborn
     */
    public void setNewborn(Integer newborn) {
        this.newborn = newborn;
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
     * 获取0正常，1Nosql迁移，2业务删除
     * 
     * @return 0正常
     */
    public Integer getFlagDel() {
        return this.flagDel;
    }
     
    /**
     * 设置0正常，1Nosql迁移，2业务删除
     * 
     * @param flagDel
     *          0正常，1Nosql迁移，2业务删除
     */
    public void setFlagDel(Integer flagDel) {
        this.flagDel = flagDel;
    }
}