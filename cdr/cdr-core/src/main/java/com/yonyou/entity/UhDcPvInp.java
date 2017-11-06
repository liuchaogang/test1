package com.yonyou.entity;
/******************************************************************
** 类    名：UhDcPvInpEntity
** 描    述：
** 创 建 者：bianj
** 创建时间：2017-07-03 18:32:42
******************************************************************/

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

/**
 * (UH_DC_PV_INP)
 * 
 * @author bianj
 * @version 1.0.0 2017-07-03
 */
@Entity
@Table(name = "UH_DC_PV_INP")
public class UhDcPvInp implements java.io.Serializable {
    /** 版本号 */
    private static final long serialVersionUID = -1137315262255411742L;
    
    /**  */
    @Id
    @Column(name = "PK_INPV")
    @GenericGenerator(name = "system-uuid", strategy = "uuid")
    @GeneratedValue(generator = "system-uuid")
    private String pkInpv;
    
    /**  */
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
    
    /**  */
    @Column(name = "PVCODE")
    private String pvcode;
    
    /**  */
    @Column(name = "TIMES_IP")
    private Integer timesIp;
    
    /**  */
    @Column(name = "DATE_DI_NT")
    private String dateDiNt;
    
    /**  */
    @Column(name = "FLAG_SURG")
    private Integer flagSurg;
    
    /**  */
    @Column(name = "SRV_NURSE")
    private String srvNurse;
    
    /**  */
    @Column(name = "DT_LEVEL_DISE")
    private String dtLevelDise;
    
    /**  */
    @Column(name = "DT_LEVEL_NUTR")
    private String dtLevelNutr;
    
    /**  */
    @Column(name = "DT_OUTCOMES")
    private String dtOutcomes;
    
    /**  */
    @Column(name = "NAME_OUTCOMES")
    private String nameOutcomes;
    
    /**  */
    @Column(name = "FLAG_NEWBORN")
    private Integer flagNewborn;
    
    /**  */
    @Column(name = "NEWBORN")
    private Integer newborn;
    
    /**  */
    @Column(name = "BIRTH_WEIGHT")
    private Integer birthWeight;
    
    /**  */
    @Column(name = "APGRA_MARK")
    private Integer apgraMark;
    
    /**  */
    @Column(name = "FLAG_DOC_COMMIT")
    private Integer flagDocCommit;
    
    /**  */
    @Column(name = "DATE_EMR_COMMIT")
    private String dateEmrCommit;
    
    /**  */
    @Column(name = "EU_EMR_STATUS")
    private String euEmrStatus;
    
    /**  */
    @Column(name = "FLAG_QA")
    private Integer flagQa;
    
    /**  */
    @Column(name = "FLAG_NUR_QA")
    private Integer flagNurQa;
    
    /**  */
    @Column(name = "PV_IP_REFMODE")
    private String pvIpRefmode;
    
    /**  */
    @Column(name = "PV_IP_REFMODE_NAME")
    private String pvIpRefmodeName;
    
    /**  */
    @Column(name = "PV_IP_DISCHMODE")
    private String pvIpDischmode;
    
    /**  */
    @Column(name = "PV_IP_DISCHMODE_NAME")
    private String pvIpDischmodeName;
    
    /**  */
    @Column(name = "CODE_CHIEF_PSN")
    private String codeChiefPsn;
    
    /**  */
    @Column(name = "NAME_CHIEF_PSN")
    private String nameChiefPsn;
    
    /**  */
    @Column(name = "CODE_BED_PSN")
    private String codeBedPsn;
    
    /**  */
    @Column(name = "NAME_BED_PSN")
    private String nameBedPsn;
    
    /**  */
    @Column(name = "DEPT_PHY_ADM")
    private String deptPhyAdm;
    
    /**  */
    @Column(name = "DEPT_PHY_ADM_NAME")
    private String deptPhyAdmName;
    
    /**  */
    @Column(name = "CODE_MGROUP_ADM")
    private String codeMgroupAdm;
    
    /**  */
    @Column(name = "NAME_MGROUP_ADM")
    private String nameMgroupAdm;
    
    /**  */
    @Column(name = "DEPT_NURSE_ADM")
    private String deptNurseAdm;
    
    /**  */
    @Column(name = "DEPT_NURSE_ADM_NAME")
    private String deptNurseAdmName;
    
    /**  */
    @Column(name = "DEPT_PHY_DISC")
    private String deptPhyDisc;
    
    /**  */
    @Column(name = "DEPT_PHY_DISC_NAME")
    private String deptPhyDiscName;
    
    /**  */
    @Column(name = "CODE_MGROUP_DISC")
    private String codeMgroupDisc;
    
    /**  */
    @Column(name = "NAME_MGROUP_DISC")
    private String nameMgroupDisc;
    
    /**  */
    @Column(name = "AREA_DISC")
    private String areaDisc;
    
    /**  */
    @Column(name = "AREA_DISC_NAME")
    private String areaDiscName;
    
    /**  */
    @Column(name = "FLAG_INHOSP")
    private Integer flagInhosp;
    
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
    
    /**  */
    @Column(name = "FLAG_DEL")
    private Integer flagDel;
    
    /**
     * 获取pkInpv
     * 
     * @return pkInpv
     */
    public String getPkInpv() {
        return this.pkInpv;
    }
     
    /**
     * 设置pkInpv
     * 
     * @param pkInpv
     *          pkInpv
     */
    public void setPkInpv(String pkInpv) {
        this.pkInpv = pkInpv;
    }
    
    /**
     * 获取pkDcpv
     * 
     * @return pkDcpv
     */
    public String getPkDcpv() {
        return this.pkDcpv;
    }
     
    /**
     * 设置pkDcpv
     * 
     * @param pkDcpv
     *          pkDcpv
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
     * 获取pvcode
     * 
     * @return pvcode
     */
    public String getPvcode() {
        return this.pvcode;
    }
     
    /**
     * 设置pvcode
     * 
     * @param pvcode
     *          pvcode
     */
    public void setPvcode(String pvcode) {
        this.pvcode = pvcode;
    }
    
    /**
     * 获取timesIp
     * 
     * @return timesIp
     */
    public Integer getTimesIp() {
        return this.timesIp;
    }
     
    /**
     * 设置timesIp
     * 
     * @param timesIp
     *          timesIp
     */
    public void setTimesIp(Integer timesIp) {
        this.timesIp = timesIp;
    }
    
    /**
     * 获取dateDiNt
     * 
     * @return dateDiNt
     */
    public String getDateDiNt() {
        return this.dateDiNt;
    }
     
    /**
     * 设置dateDiNt
     * 
     * @param dateDiNt
     *          dateDiNt
     */
    public void setDateDiNt(String dateDiNt) {
        this.dateDiNt = dateDiNt;
    }
    
    /**
     * 获取flagSurg
     * 
     * @return flagSurg
     */
    public Integer getFlagSurg() {
        return this.flagSurg;
    }
     
    /**
     * 设置flagSurg
     * 
     * @param flagSurg
     *          flagSurg
     */
    public void setFlagSurg(Integer flagSurg) {
        this.flagSurg = flagSurg;
    }
    
    /**
     * 获取srvNurse
     * 
     * @return srvNurse
     */
    public String getSrvNurse() {
        return this.srvNurse;
    }
     
    /**
     * 设置srvNurse
     * 
     * @param srvNurse
     *          srvNurse
     */
    public void setSrvNurse(String srvNurse) {
        this.srvNurse = srvNurse;
    }
    
    /**
     * 获取dtLevelDise
     * 
     * @return dtLevelDise
     */
    public String getDtLevelDise() {
        return this.dtLevelDise;
    }
     
    /**
     * 设置dtLevelDise
     * 
     * @param dtLevelDise
     *          dtLevelDise
     */
    public void setDtLevelDise(String dtLevelDise) {
        this.dtLevelDise = dtLevelDise;
    }
    
    /**
     * 获取dtLevelNutr
     * 
     * @return dtLevelNutr
     */
    public String getDtLevelNutr() {
        return this.dtLevelNutr;
    }
     
    /**
     * 设置dtLevelNutr
     * 
     * @param dtLevelNutr
     *          dtLevelNutr
     */
    public void setDtLevelNutr(String dtLevelNutr) {
        this.dtLevelNutr = dtLevelNutr;
    }
    
    /**
     * 获取dtOutcomes
     * 
     * @return dtOutcomes
     */
    public String getDtOutcomes() {
        return this.dtOutcomes;
    }
     
    /**
     * 设置dtOutcomes
     * 
     * @param dtOutcomes
     *          dtOutcomes
     */
    public void setDtOutcomes(String dtOutcomes) {
        this.dtOutcomes = dtOutcomes;
    }
    
    /**
     * 获取nameOutcomes
     * 
     * @return nameOutcomes
     */
    public String getNameOutcomes() {
        return this.nameOutcomes;
    }
     
    /**
     * 设置nameOutcomes
     * 
     * @param nameOutcomes
     *          nameOutcomes
     */
    public void setNameOutcomes(String nameOutcomes) {
        this.nameOutcomes = nameOutcomes;
    }
    
    /**
     * 获取flagNewborn
     * 
     * @return flagNewborn
     */
    public Integer getFlagNewborn() {
        return this.flagNewborn;
    }
     
    /**
     * 设置flagNewborn
     * 
     * @param flagNewborn
     *          flagNewborn
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
     * 获取birthWeight
     * 
     * @return birthWeight
     */
    public Integer getBirthWeight() {
        return this.birthWeight;
    }
     
    /**
     * 设置birthWeight
     * 
     * @param birthWeight
     *          birthWeight
     */
    public void setBirthWeight(Integer birthWeight) {
        this.birthWeight = birthWeight;
    }
    
    /**
     * 获取apgraMark
     * 
     * @return apgraMark
     */
    public Integer getApgraMark() {
        return this.apgraMark;
    }
     
    /**
     * 设置apgraMark
     * 
     * @param apgraMark
     *          apgraMark
     */
    public void setApgraMark(Integer apgraMark) {
        this.apgraMark = apgraMark;
    }
    
    /**
     * 获取flagDocCommit
     * 
     * @return flagDocCommit
     */
    public Integer getFlagDocCommit() {
        return this.flagDocCommit;
    }
     
    /**
     * 设置flagDocCommit
     * 
     * @param flagDocCommit
     *          flagDocCommit
     */
    public void setFlagDocCommit(Integer flagDocCommit) {
        this.flagDocCommit = flagDocCommit;
    }
    
    /**
     * 获取dateEmrCommit
     * 
     * @return dateEmrCommit
     */
    public String getDateEmrCommit() {
        return this.dateEmrCommit;
    }
     
    /**
     * 设置dateEmrCommit
     * 
     * @param dateEmrCommit
     *          dateEmrCommit
     */
    public void setDateEmrCommit(String dateEmrCommit) {
        this.dateEmrCommit = dateEmrCommit;
    }
    
    /**
     * 获取euEmrStatus
     * 
     * @return euEmrStatus
     */
    public String getEuEmrStatus() {
        return this.euEmrStatus;
    }
     
    /**
     * 设置euEmrStatus
     * 
     * @param euEmrStatus
     *          euEmrStatus
     */
    public void setEuEmrStatus(String euEmrStatus) {
        this.euEmrStatus = euEmrStatus;
    }
    
    /**
     * 获取flagQa
     * 
     * @return flagQa
     */
    public Integer getFlagQa() {
        return this.flagQa;
    }
     
    /**
     * 设置flagQa
     * 
     * @param flagQa
     *          flagQa
     */
    public void setFlagQa(Integer flagQa) {
        this.flagQa = flagQa;
    }
    
    /**
     * 获取flagNurQa
     * 
     * @return flagNurQa
     */
    public Integer getFlagNurQa() {
        return this.flagNurQa;
    }
     
    /**
     * 设置flagNurQa
     * 
     * @param flagNurQa
     *          flagNurQa
     */
    public void setFlagNurQa(Integer flagNurQa) {
        this.flagNurQa = flagNurQa;
    }
    
    /**
     * 获取pvIpRefmode
     * 
     * @return pvIpRefmode
     */
    public String getPvIpRefmode() {
        return this.pvIpRefmode;
    }
     
    /**
     * 设置pvIpRefmode
     * 
     * @param pvIpRefmode
     *          pvIpRefmode
     */
    public void setPvIpRefmode(String pvIpRefmode) {
        this.pvIpRefmode = pvIpRefmode;
    }
    
    /**
     * 获取pvIpRefmodeName
     * 
     * @return pvIpRefmodeName
     */
    public String getPvIpRefmodeName() {
        return this.pvIpRefmodeName;
    }
     
    /**
     * 设置pvIpRefmodeName
     * 
     * @param pvIpRefmodeName
     *          pvIpRefmodeName
     */
    public void setPvIpRefmodeName(String pvIpRefmodeName) {
        this.pvIpRefmodeName = pvIpRefmodeName;
    }
    
    /**
     * 获取pvIpDischmode
     * 
     * @return pvIpDischmode
     */
    public String getPvIpDischmode() {
        return this.pvIpDischmode;
    }
     
    /**
     * 设置pvIpDischmode
     * 
     * @param pvIpDischmode
     *          pvIpDischmode
     */
    public void setPvIpDischmode(String pvIpDischmode) {
        this.pvIpDischmode = pvIpDischmode;
    }
    
    /**
     * 获取pvIpDischmodeName
     * 
     * @return pvIpDischmodeName
     */
    public String getPvIpDischmodeName() {
        return this.pvIpDischmodeName;
    }
     
    /**
     * 设置pvIpDischmodeName
     * 
     * @param pvIpDischmodeName
     *          pvIpDischmodeName
     */
    public void setPvIpDischmodeName(String pvIpDischmodeName) {
        this.pvIpDischmodeName = pvIpDischmodeName;
    }
    
    /**
     * 获取codeChiefPsn
     * 
     * @return codeChiefPsn
     */
    public String getCodeChiefPsn() {
        return this.codeChiefPsn;
    }
     
    /**
     * 设置codeChiefPsn
     * 
     * @param codeChiefPsn
     *          codeChiefPsn
     */
    public void setCodeChiefPsn(String codeChiefPsn) {
        this.codeChiefPsn = codeChiefPsn;
    }
    
    /**
     * 获取nameChiefPsn
     * 
     * @return nameChiefPsn
     */
    public String getNameChiefPsn() {
        return this.nameChiefPsn;
    }
     
    /**
     * 设置nameChiefPsn
     * 
     * @param nameChiefPsn
     *          nameChiefPsn
     */
    public void setNameChiefPsn(String nameChiefPsn) {
        this.nameChiefPsn = nameChiefPsn;
    }
    
    /**
     * 获取codeBedPsn
     * 
     * @return codeBedPsn
     */
    public String getCodeBedPsn() {
        return this.codeBedPsn;
    }
     
    /**
     * 设置codeBedPsn
     * 
     * @param codeBedPsn
     *          codeBedPsn
     */
    public void setCodeBedPsn(String codeBedPsn) {
        this.codeBedPsn = codeBedPsn;
    }
    
    /**
     * 获取nameBedPsn
     * 
     * @return nameBedPsn
     */
    public String getNameBedPsn() {
        return this.nameBedPsn;
    }
     
    /**
     * 设置nameBedPsn
     * 
     * @param nameBedPsn
     *          nameBedPsn
     */
    public void setNameBedPsn(String nameBedPsn) {
        this.nameBedPsn = nameBedPsn;
    }
    
    /**
     * 获取deptPhyAdm
     * 
     * @return deptPhyAdm
     */
    public String getDeptPhyAdm() {
        return this.deptPhyAdm;
    }
     
    /**
     * 设置deptPhyAdm
     * 
     * @param deptPhyAdm
     *          deptPhyAdm
     */
    public void setDeptPhyAdm(String deptPhyAdm) {
        this.deptPhyAdm = deptPhyAdm;
    }
    
    /**
     * 获取deptPhyAdmName
     * 
     * @return deptPhyAdmName
     */
    public String getDeptPhyAdmName() {
        return this.deptPhyAdmName;
    }
     
    /**
     * 设置deptPhyAdmName
     * 
     * @param deptPhyAdmName
     *          deptPhyAdmName
     */
    public void setDeptPhyAdmName(String deptPhyAdmName) {
        this.deptPhyAdmName = deptPhyAdmName;
    }
    
    /**
     * 获取codeMgroupAdm
     * 
     * @return codeMgroupAdm
     */
    public String getCodeMgroupAdm() {
        return this.codeMgroupAdm;
    }
     
    /**
     * 设置codeMgroupAdm
     * 
     * @param codeMgroupAdm
     *          codeMgroupAdm
     */
    public void setCodeMgroupAdm(String codeMgroupAdm) {
        this.codeMgroupAdm = codeMgroupAdm;
    }
    
    /**
     * 获取nameMgroupAdm
     * 
     * @return nameMgroupAdm
     */
    public String getNameMgroupAdm() {
        return this.nameMgroupAdm;
    }
     
    /**
     * 设置nameMgroupAdm
     * 
     * @param nameMgroupAdm
     *          nameMgroupAdm
     */
    public void setNameMgroupAdm(String nameMgroupAdm) {
        this.nameMgroupAdm = nameMgroupAdm;
    }
    
    /**
     * 获取deptNurseAdm
     * 
     * @return deptNurseAdm
     */
    public String getDeptNurseAdm() {
        return this.deptNurseAdm;
    }
     
    /**
     * 设置deptNurseAdm
     * 
     * @param deptNurseAdm
     *          deptNurseAdm
     */
    public void setDeptNurseAdm(String deptNurseAdm) {
        this.deptNurseAdm = deptNurseAdm;
    }
    
    /**
     * 获取deptNurseAdmName
     * 
     * @return deptNurseAdmName
     */
    public String getDeptNurseAdmName() {
        return this.deptNurseAdmName;
    }
     
    /**
     * 设置deptNurseAdmName
     * 
     * @param deptNurseAdmName
     *          deptNurseAdmName
     */
    public void setDeptNurseAdmName(String deptNurseAdmName) {
        this.deptNurseAdmName = deptNurseAdmName;
    }
    
    /**
     * 获取deptPhyDisc
     * 
     * @return deptPhyDisc
     */
    public String getDeptPhyDisc() {
        return this.deptPhyDisc;
    }
     
    /**
     * 设置deptPhyDisc
     * 
     * @param deptPhyDisc
     *          deptPhyDisc
     */
    public void setDeptPhyDisc(String deptPhyDisc) {
        this.deptPhyDisc = deptPhyDisc;
    }
    
    /**
     * 获取deptPhyDiscName
     * 
     * @return deptPhyDiscName
     */
    public String getDeptPhyDiscName() {
        return this.deptPhyDiscName;
    }
     
    /**
     * 设置deptPhyDiscName
     * 
     * @param deptPhyDiscName
     *          deptPhyDiscName
     */
    public void setDeptPhyDiscName(String deptPhyDiscName) {
        this.deptPhyDiscName = deptPhyDiscName;
    }
    
    /**
     * 获取codeMgroupDisc
     * 
     * @return codeMgroupDisc
     */
    public String getCodeMgroupDisc() {
        return this.codeMgroupDisc;
    }
     
    /**
     * 设置codeMgroupDisc
     * 
     * @param codeMgroupDisc
     *          codeMgroupDisc
     */
    public void setCodeMgroupDisc(String codeMgroupDisc) {
        this.codeMgroupDisc = codeMgroupDisc;
    }
    
    /**
     * 获取nameMgroupDisc
     * 
     * @return nameMgroupDisc
     */
    public String getNameMgroupDisc() {
        return this.nameMgroupDisc;
    }
     
    /**
     * 设置nameMgroupDisc
     * 
     * @param nameMgroupDisc
     *          nameMgroupDisc
     */
    public void setNameMgroupDisc(String nameMgroupDisc) {
        this.nameMgroupDisc = nameMgroupDisc;
    }
    
    /**
     * 获取areaDisc
     * 
     * @return areaDisc
     */
    public String getAreaDisc() {
        return this.areaDisc;
    }
     
    /**
     * 设置areaDisc
     * 
     * @param areaDisc
     *          areaDisc
     */
    public void setAreaDisc(String areaDisc) {
        this.areaDisc = areaDisc;
    }
    
    /**
     * 获取areaDiscName
     * 
     * @return areaDiscName
     */
    public String getAreaDiscName() {
        return this.areaDiscName;
    }
     
    /**
     * 设置areaDiscName
     * 
     * @param areaDiscName
     *          areaDiscName
     */
    public void setAreaDiscName(String areaDiscName) {
        this.areaDiscName = areaDiscName;
    }
    
    /**
     * 获取flagInhosp
     * 
     * @return flagInhosp
     */
    public Integer getFlagInhosp() {
        return this.flagInhosp;
    }
     
    /**
     * 设置flagInhosp
     * 
     * @param flagInhosp
     *          flagInhosp
     */
    public void setFlagInhosp(Integer flagInhosp) {
        this.flagInhosp = flagInhosp;
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