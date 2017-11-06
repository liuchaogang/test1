package com.yonyou.entity;
/******************************************************************
** 类    名：UhDcOrdMediEntity
** 描    述：
** 创 建 者：bianj
** 创建时间：2017-07-08 15:17:26
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
 * (UH_DC_ORD_MEDI)
 * 
 * @author bianj
 * @version 1.0.0 2017-07-08
 */
@Entity
@Table(name = "UH_DC_ORD_MEDI", schema = "dbo", catalog = "MIP_DC_DEMO")
public class UhDcOrdMedi implements java.io.Serializable {
    /** 版本号 */
    private static final long serialVersionUID = 2829346436551198846L;
    
    /**  */
    @Id
    @GenericGenerator(name = "system-uuid", strategy = "uuid")
    @GeneratedValue(generator = "system-uuid")
    @Column(name = "PK_ORD_MEDI")
    private String pkOrdMedi;
    
    /**  */
    @Column(name = "PK_DCORD")
    private String pkDcord;
    
    /**  */
    @Column(name = "CODE_GROUP")
    private String codeGroup;
    
    /**  */
    @Column(name = "CODE_ORG")
    private String codeOrg;
    
    /** 医嘱表唯一标识 */
    @Column(name = "CODE_ORD")
    private String codeOrd;
    
    /** DICT_YLFL */
    @Column(name = "CODE_MEDI_TYPE")
    private String codeMediType;
    
    /**  */
    @Column(name = "NAME_MEDI_TYPE")
    private String nameMediType;
    
    /** DICT_YPJX */
    @Column(name = "CODE_FORM")
    private String codeForm;
    
    /**  */
    @Column(name = "NAME_FORM")
    private String nameForm;
    
    /** DICT_YYTJ */
    @Column(name = "CODE_MEDI_WAY")
    private String codeMediWay;
    
    /**  */
    @Column(name = "NAME_MEDI_WAY")
    private String nameMediWay;
    
    /**  */
    @Column(name = "DOSAGE")
    private String dosage;
    
    /**  */
    @Column(name = "DOSAGE_UNITS")
    private String dosageUnits;
    
    /**  */
    @Column(name = "DURATION")
    private Integer duration;
    
    /**  */
    @Column(name = "DURATION_UNITS")
    private String durationUnits;
    
    /** 0是，1否 */
    @Column(name = "DRUGTEST")
    private String drugtest;
    
    /** 0是，1否 */
    @Column(name = "IS_ANTIBIOTIC")
    private Integer isAntibiotic;
    
    /**  */
    @Column(name = "CODE_ANTI_REASON")
    private String codeAntiReason;
    
    /**  */
    @Column(name = "NAME_ANTI_REASON")
    private String nameAntiReason;
    
    /**  */
    @Column(name = "CHINESE_NUM")
    private Integer chineseNum;
    
    /**  */
    @Column(name = "SPEC_SRV")
    private String specSrv;
    
    /**  */
    @Column(name = "PACK_UNIT")
    private String packUnit;
    
    /**  */
    @Column(name = "NUM_TOTAL")
    private String numTotal;
    
    /** D	处方
   DS	停处方
   Y	处方（中成药）
   Z	处方（中草药） */
    @Column(name = "CODE_ORDMEDI_TYPE")
    private String codeOrdmediType;
    
    /**  */
    @Column(name = "NAME_ORDMEDI_TYPE")
    private String nameOrdmediType;
    
    /** D 普通处方
   Z 中草药处方
    */
    @Column(name = "CODE_PRES_TYPE")
    private String codePresType;
    
    /**  */
    @Column(name = "NAME_PRES_TYPE")
    private String namePresType;
    
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
    
    /**  */
    @Column(name = "BASE_MEDI_CODE")
    private String baseMediCode;
    
    /**  */
    @Column(name = "BASE_MEDI_NAME")
    private String baseMediName;
    
    /**  */
    @Column(name = "IS_AUXI_MEDI")
    private String isAuxiMedi;
    
    /**  */
    @Column(name = "DRUGTESTDO")
    private String drugtestdo;
    
    /**  */
    @Column(name = "CODE_LEVEL_ANTI")
    private String codeLevelAnti;
    
    /**  */
    @Column(name = "NAME_LEVEL_ANTI")
    private String nameLevelAnti;
    
    /**  */
    @Column(name = "CODE_DRUG_TYPE")
    private String codeDrugType;
    
    /**  */
    @Column(name = "NAME_DRUG_TYPE")
    private String nameDrugType;
    
    /**  */
    @Column(name = "DOSAGE_USE")
    private String dosageUse;
    
    /**  */
    @Column(name = "USE_UNIT")
    private String useUnit;
    
    /**  */
    @Column(name = "DOSAGE_TAKE")
    private String dosageTake;
    
    /**  */
    @Column(name = "TAKE_UNIT")
    private String takeUnit;
    
    /**  */
    @Column(name = "OPPACK")
    private BigDecimal oppack;
    
    /**  */
    @Column(name = "OPPACKUNIT")
    private String oppackunit;
    
    /**  */
    @Column(name = "DRUNIT")
    private String drunit;
    
    @Column(name = "weight")
    private BigDecimal weight;
    
    @Column(name = "unit_weight")
    private String unitWight;
    
    @Column(name = "code_make")
    private String codeMake;
    
    @Column(name = "name_make")
    private String nameMake;
    
    /**
     * 获取pkOrdMedi
     * 
     * @return pkOrdMedi
     */
    public String getPkOrdMedi() {
        return this.pkOrdMedi;
    }
     
    /**
     * 设置pkOrdMedi
     * 
     * @param pkOrdMedi
     *          pkOrdMedi
     */
    public void setPkOrdMedi(String pkOrdMedi) {
        this.pkOrdMedi = pkOrdMedi;
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
     * 获取医嘱表唯一标识
     * 
     * @return 医嘱表唯一标识
     */
    public String getCodeOrd() {
        return this.codeOrd;
    }
     
    /**
     * 设置医嘱表唯一标识
     * 
     * @param codeOrd
     *          医嘱表唯一标识
     */
    public void setCodeOrd(String codeOrd) {
        this.codeOrd = codeOrd;
    }
    
    /**
     * 获取DICT_YLFL
     * 
     * @return DICT_YLFL
     */
    public String getCodeMediType() {
        return this.codeMediType;
    }
     
    /**
     * 设置DICT_YLFL
     * 
     * @param codeMediType
     *          DICT_YLFL
     */
    public void setCodeMediType(String codeMediType) {
        this.codeMediType = codeMediType;
    }
    
    /**
     * 获取nameMediType
     * 
     * @return nameMediType
     */
    public String getNameMediType() {
        return this.nameMediType;
    }
     
    /**
     * 设置nameMediType
     * 
     * @param nameMediType
     *          nameMediType
     */
    public void setNameMediType(String nameMediType) {
        this.nameMediType = nameMediType;
    }
    
    /**
     * 获取DICT_YPJX
     * 
     * @return DICT_YPJX
     */
    public String getCodeForm() {
        return this.codeForm;
    }
     
    /**
     * 设置DICT_YPJX
     * 
     * @param codeForm
     *          DICT_YPJX
     */
    public void setCodeForm(String codeForm) {
        this.codeForm = codeForm;
    }
    
    /**
     * 获取nameForm
     * 
     * @return nameForm
     */
    public String getNameForm() {
        return this.nameForm;
    }
     
    /**
     * 设置nameForm
     * 
     * @param nameForm
     *          nameForm
     */
    public void setNameForm(String nameForm) {
        this.nameForm = nameForm;
    }
    
    /**
     * 获取DICT_YYTJ
     * 
     * @return DICT_YYTJ
     */
    public String getCodeMediWay() {
        return this.codeMediWay;
    }
     
    /**
     * 设置DICT_YYTJ
     * 
     * @param codeMediWay
     *          DICT_YYTJ
     */
    public void setCodeMediWay(String codeMediWay) {
        this.codeMediWay = codeMediWay;
    }
    
    /**
     * 获取nameMediWay
     * 
     * @return nameMediWay
     */
    public String getNameMediWay() {
        return this.nameMediWay;
    }
     
    /**
     * 设置nameMediWay
     * 
     * @param nameMediWay
     *          nameMediWay
     */
    public void setNameMediWay(String nameMediWay) {
        this.nameMediWay = nameMediWay;
    }
    
    /**
     * 获取dosage
     * 
     * @return dosage
     */
    public String getDosage() {
        return this.dosage;
    }
     
    /**
     * 设置dosage
     * 
     * @param dosage
     *          dosage
     */
    public void setDosage(String dosage) {
        this.dosage = dosage;
    }
    
    /**
     * 获取dosageUnits
     * 
     * @return dosageUnits
     */
    public String getDosageUnits() {
        return this.dosageUnits;
    }
     
    /**
     * 设置dosageUnits
     * 
     * @param dosageUnits
     *          dosageUnits
     */
    public void setDosageUnits(String dosageUnits) {
        this.dosageUnits = dosageUnits;
    }
    
    /**
     * 获取duration
     * 
     * @return duration
     */
    public Integer getDuration() {
        return this.duration;
    }
     
    /**
     * 设置duration
     * 
     * @param duration
     *          duration
     */
    public void setDuration(Integer duration) {
        this.duration = duration;
    }
    
    /**
     * 获取durationUnits
     * 
     * @return durationUnits
     */
    public String getDurationUnits() {
        return this.durationUnits;
    }
     
    /**
     * 设置durationUnits
     * 
     * @param durationUnits
     *          durationUnits
     */
    public void setDurationUnits(String durationUnits) {
        this.durationUnits = durationUnits;
    }
    
    /**
     * 获取0是，1否
     * 
     * @return 0是
     */
    public String getDrugtest() {
        return this.drugtest;
    }
     
    /**
     * 设置0是，1否
     * 
     * @param drugtest
     *          0是，1否
     */
    public void setDrugtest(String drugtest) {
        this.drugtest = drugtest;
    }
    
    /**
     * 获取0是，1否
     * 
     * @return 0是
     */
    public Integer getIsAntibiotic() {
        return this.isAntibiotic;
    }
     
    /**
     * 设置0是，1否
     * 
     * @param isAntibiotic
     *          0是，1否
     */
    public void setIsAntibiotic(Integer isAntibiotic) {
        this.isAntibiotic = isAntibiotic;
    }
    
    /**
     * 获取codeAntiReason
     * 
     * @return codeAntiReason
     */
    public String getCodeAntiReason() {
        return this.codeAntiReason;
    }
     
    /**
     * 设置codeAntiReason
     * 
     * @param codeAntiReason
     *          codeAntiReason
     */
    public void setCodeAntiReason(String codeAntiReason) {
        this.codeAntiReason = codeAntiReason;
    }
    
    /**
     * 获取nameAntiReason
     * 
     * @return nameAntiReason
     */
    public String getNameAntiReason() {
        return this.nameAntiReason;
    }
     
    /**
     * 设置nameAntiReason
     * 
     * @param nameAntiReason
     *          nameAntiReason
     */
    public void setNameAntiReason(String nameAntiReason) {
        this.nameAntiReason = nameAntiReason;
    }
    
    /**
     * 获取chineseNum
     * 
     * @return chineseNum
     */
    public Integer getChineseNum() {
        return this.chineseNum;
    }
     
    /**
     * 设置chineseNum
     * 
     * @param chineseNum
     *          chineseNum
     */
    public void setChineseNum(Integer chineseNum) {
        this.chineseNum = chineseNum;
    }
    
    /**
     * 获取specSrv
     * 
     * @return specSrv
     */
    public String getSpecSrv() {
        return this.specSrv;
    }
     
    /**
     * 设置specSrv
     * 
     * @param specSrv
     *          specSrv
     */
    public void setSpecSrv(String specSrv) {
        this.specSrv = specSrv;
    }
    
    /**
     * 获取packUnit
     * 
     * @return packUnit
     */
    public String getPackUnit() {
        return this.packUnit;
    }
     
    /**
     * 设置packUnit
     * 
     * @param packUnit
     *          packUnit
     */
    public void setPackUnit(String packUnit) {
        this.packUnit = packUnit;
    }
    
    /**
     * 获取numTotal
     * 
     * @return numTotal
     */
    public String getNumTotal() {
        return this.numTotal;
    }
     
    /**
     * 设置numTotal
     * 
     * @param numTotal
     *          numTotal
     */
    public void setNumTotal(String numTotal) {
        this.numTotal = numTotal;
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
     * 获取D 普通处方
   Z 中草药处方
   
     * 
     * @return D 普通处方
   Z 中草药处方
   
     */
    public String getCodePresType() {
        return this.codePresType;
    }
     
    /**
     * 设置D 普通处方
   Z 中草药处方
   
     * 
     * @param codePresType
     *          D 普通处方
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
    
    /**
     * 获取baseMediCode
     * 
     * @return baseMediCode
     */
    public String getBaseMediCode() {
        return this.baseMediCode;
    }
     
    /**
     * 设置baseMediCode
     * 
     * @param baseMediCode
     *          baseMediCode
     */
    public void setBaseMediCode(String baseMediCode) {
        this.baseMediCode = baseMediCode;
    }
    
    /**
     * 获取baseMediName
     * 
     * @return baseMediName
     */
    public String getBaseMediName() {
        return this.baseMediName;
    }
     
    /**
     * 设置baseMediName
     * 
     * @param baseMediName
     *          baseMediName
     */
    public void setBaseMediName(String baseMediName) {
        this.baseMediName = baseMediName;
    }
    
    /**
     * 获取isAuxiMedi
     * 
     * @return isAuxiMedi
     */
    public String getIsAuxiMedi() {
        return this.isAuxiMedi;
    }
     
    /**
     * 设置isAuxiMedi
     * 
     * @param isAuxiMedi
     *          isAuxiMedi
     */
    public void setIsAuxiMedi(String isAuxiMedi) {
        this.isAuxiMedi = isAuxiMedi;
    }
    
    /**
     * 获取drugtestdo
     * 
     * @return drugtestdo
     */
    public String getDrugtestdo() {
        return this.drugtestdo;
    }
     
    /**
     * 设置drugtestdo
     * 
     * @param drugtestdo
     *          drugtestdo
     */
    public void setDrugtestdo(String drugtestdo) {
        this.drugtestdo = drugtestdo;
    }
    
    /**
     * 获取codeLevelAnti
     * 
     * @return codeLevelAnti
     */
    public String getCodeLevelAnti() {
        return this.codeLevelAnti;
    }
     
    /**
     * 设置codeLevelAnti
     * 
     * @param codeLevelAnti
     *          codeLevelAnti
     */
    public void setCodeLevelAnti(String codeLevelAnti) {
        this.codeLevelAnti = codeLevelAnti;
    }
    
    /**
     * 获取nameLevelAnti
     * 
     * @return nameLevelAnti
     */
    public String getNameLevelAnti() {
        return this.nameLevelAnti;
    }
     
    /**
     * 设置nameLevelAnti
     * 
     * @param nameLevelAnti
     *          nameLevelAnti
     */
    public void setNameLevelAnti(String nameLevelAnti) {
        this.nameLevelAnti = nameLevelAnti;
    }
    
    /**
     * 获取codeDrugType
     * 
     * @return codeDrugType
     */
    public String getCodeDrugType() {
        return this.codeDrugType;
    }
     
    /**
     * 设置codeDrugType
     * 
     * @param codeDrugType
     *          codeDrugType
     */
    public void setCodeDrugType(String codeDrugType) {
        this.codeDrugType = codeDrugType;
    }
    
    /**
     * 获取nameDrugType
     * 
     * @return nameDrugType
     */
    public String getNameDrugType() {
        return this.nameDrugType;
    }
     
    /**
     * 设置nameDrugType
     * 
     * @param nameDrugType
     *          nameDrugType
     */
    public void setNameDrugType(String nameDrugType) {
        this.nameDrugType = nameDrugType;
    }
    
    /**
     * 获取dosageUse
     * 
     * @return dosageUse
     */
    public String getDosageUse() {
        return this.dosageUse;
    }
     
    /**
     * 设置dosageUse
     * 
     * @param dosageUse
     *          dosageUse
     */
    public void setDosageUse(String dosageUse) {
        this.dosageUse = dosageUse;
    }
    
    /**
     * 获取useUnit
     * 
     * @return useUnit
     */
    public String getUseUnit() {
        return this.useUnit;
    }
     
    /**
     * 设置useUnit
     * 
     * @param useUnit
     *          useUnit
     */
    public void setUseUnit(String useUnit) {
        this.useUnit = useUnit;
    }
    
    /**
     * 获取dosageTake
     * 
     * @return dosageTake
     */
    public String getDosageTake() {
        return this.dosageTake;
    }
     
    /**
     * 设置dosageTake
     * 
     * @param dosageTake
     *          dosageTake
     */
    public void setDosageTake(String dosageTake) {
        this.dosageTake = dosageTake;
    }
    
    /**
     * 获取takeUnit
     * 
     * @return takeUnit
     */
    public String getTakeUnit() {
        return this.takeUnit;
    }
     
    /**
     * 设置takeUnit
     * 
     * @param takeUnit
     *          takeUnit
     */
    public void setTakeUnit(String takeUnit) {
        this.takeUnit = takeUnit;
    }
    
    /**
     * 获取oppack
     * 
     * @return oppack
     */
    public BigDecimal getOppack() {
        return this.oppack;
    }
     
    /**
     * 设置oppack
     * 
     * @param oppack
     *          oppack
     */
    public void setOppack(BigDecimal oppack) {
        this.oppack = oppack;
    }
    
    /**
     * 获取oppackunit
     * 
     * @return oppackunit
     */
    public String getOppackunit() {
        return this.oppackunit;
    }
     
    /**
     * 设置oppackunit
     * 
     * @param oppackunit
     *          oppackunit
     */
    public void setOppackunit(String oppackunit) {
        this.oppackunit = oppackunit;
    }
    
    /**
     * 获取drunit
     * 
     * @return drunit
     */
    public String getDrunit() {
        return this.drunit;
    }
     
    /**
     * 设置drunit
     * 
     * @param drunit
     *          drunit
     */
    public void setDrunit(String drunit) {
        this.drunit = drunit;
    }

	public BigDecimal getWeight() {
		return weight;
	}

	public void setWeight(BigDecimal weight) {
		this.weight = weight;
	}

	public String getUnitWight() {
		return unitWight;
	}

	public void setUnitWight(String unitWight) {
		this.unitWight = unitWight;
	}

	public String getCodeMake() {
		return codeMake;
	}

	public void setCodeMake(String codeMake) {
		this.codeMake = codeMake;
	}

	public String getNameMake() {
		return nameMake;
	}

	public void setNameMake(String nameMake) {
		this.nameMake = nameMake;
	}
    
    
}