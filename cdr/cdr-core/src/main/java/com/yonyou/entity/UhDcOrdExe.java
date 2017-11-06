package com.yonyou.entity;
/******************************************************************
** 类    名：UhDcOrdExeEntity
** 描    述：
** 创 建 者：bianj
** 创建时间：2017-07-05 18:46:30
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
 * (UH_DC_ORD_EXE)
 * 
 * @author bianj
 * @version 1.0.0 2017-07-05
 */
@Entity
@Table(name = "UH_DC_ORD_EXE", schema = "dbo", catalog = "MIP_DC_DEMO")
public class UhDcOrdExe implements java.io.Serializable {
    /** 版本号 */
    private static final long serialVersionUID = -501194486567479741L;
    
    /**  */
    @Id
    @Column(name = "PK_DCORDEX")
    @GenericGenerator(name = "system-uuid", strategy = "uuid")
    @GeneratedValue(generator = "system-uuid")
    private String pkDcordex;
    
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
    
    /**  */
    @Column(name = "DATE_EX")
    private String dateEx;
    
    /**  */
    @Column(name = "CODE_ORG_EX")
    private String codeOrgEx;
    
    /**  */
    @Column(name = "NAME_ORG_EX")
    private String nameOrgEx;
    
    /**  */
    @Column(name = "CODE_DEPT_EX")
    private String codeDeptEx;
    
    /**  */
    @Column(name = "NAME_DEPT_EX")
    private String nameDeptEx;
    
    /**  */
    @Column(name = "CODE_PSN_EX")
    private String codePsnEx;
    
    /**  */
    @Column(name = "NAME_PSN_EX")
    private String namePsnEx;
    
    /**  */
    @Column(name = "CODE_RESULT_EX")
    private String codeResultEx;
    
    /**  */
    @Column(name = "NAME_RESULT_EX")
    private String nameResultEx;
    
    /**  */
    @Column(name = "CHARGEFLAG")
    private Integer chargeflag;
    
    /**  */
    @Column(name = "NOTE")
    private String note;
    
    /** 0 申请（护士核对后），1 收费，2 执行，9 取消 */
    @Column(name = "STATUS")
    private Integer status;
    
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
    @Column(name = "DATE_PLAN")
    private String datePlan;
    
    /**  */
    @Column(name = "NUM_EX")
    private BigDecimal numEx;
    
    /**  */
    @Column(name = "UNIT_EX")
    private String unitEx;
    
    /**
     * 获取pkDcordex
     * 
     * @return pkDcordex
     */
    public String getPkDcordex() {
        return this.pkDcordex;
    }
     
    /**
     * 设置pkDcordex
     * 
     * @param pkDcordex
     *          pkDcordex
     */
    public void setPkDcordex(String pkDcordex) {
        this.pkDcordex = pkDcordex;
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
     * 获取dateEx
     * 
     * @return dateEx
     */
    public String getDateEx() {
        return this.dateEx;
    }
     
    /**
     * 设置dateEx
     * 
     * @param dateEx
     *          dateEx
     */
    public void setDateEx(String dateEx) {
        this.dateEx = dateEx;
    }
    
    /**
     * 获取codeOrgEx
     * 
     * @return codeOrgEx
     */
    public String getCodeOrgEx() {
        return this.codeOrgEx;
    }
     
    /**
     * 设置codeOrgEx
     * 
     * @param codeOrgEx
     *          codeOrgEx
     */
    public void setCodeOrgEx(String codeOrgEx) {
        this.codeOrgEx = codeOrgEx;
    }
    
    /**
     * 获取nameOrgEx
     * 
     * @return nameOrgEx
     */
    public String getNameOrgEx() {
        return this.nameOrgEx;
    }
     
    /**
     * 设置nameOrgEx
     * 
     * @param nameOrgEx
     *          nameOrgEx
     */
    public void setNameOrgEx(String nameOrgEx) {
        this.nameOrgEx = nameOrgEx;
    }
    
    /**
     * 获取codeDeptEx
     * 
     * @return codeDeptEx
     */
    public String getCodeDeptEx() {
        return this.codeDeptEx;
    }
     
    /**
     * 设置codeDeptEx
     * 
     * @param codeDeptEx
     *          codeDeptEx
     */
    public void setCodeDeptEx(String codeDeptEx) {
        this.codeDeptEx = codeDeptEx;
    }
    
    /**
     * 获取nameDeptEx
     * 
     * @return nameDeptEx
     */
    public String getNameDeptEx() {
        return this.nameDeptEx;
    }
     
    /**
     * 设置nameDeptEx
     * 
     * @param nameDeptEx
     *          nameDeptEx
     */
    public void setNameDeptEx(String nameDeptEx) {
        this.nameDeptEx = nameDeptEx;
    }
    
    /**
     * 获取codePsnEx
     * 
     * @return codePsnEx
     */
    public String getCodePsnEx() {
        return this.codePsnEx;
    }
     
    /**
     * 设置codePsnEx
     * 
     * @param codePsnEx
     *          codePsnEx
     */
    public void setCodePsnEx(String codePsnEx) {
        this.codePsnEx = codePsnEx;
    }
    
    /**
     * 获取namePsnEx
     * 
     * @return namePsnEx
     */
    public String getNamePsnEx() {
        return this.namePsnEx;
    }
     
    /**
     * 设置namePsnEx
     * 
     * @param namePsnEx
     *          namePsnEx
     */
    public void setNamePsnEx(String namePsnEx) {
        this.namePsnEx = namePsnEx;
    }
    
    /**
     * 获取codeResultEx
     * 
     * @return codeResultEx
     */
    public String getCodeResultEx() {
        return this.codeResultEx;
    }
     
    /**
     * 设置codeResultEx
     * 
     * @param codeResultEx
     *          codeResultEx
     */
    public void setCodeResultEx(String codeResultEx) {
        this.codeResultEx = codeResultEx;
    }
    
    /**
     * 获取nameResultEx
     * 
     * @return nameResultEx
     */
    public String getNameResultEx() {
        return this.nameResultEx;
    }
     
    /**
     * 设置nameResultEx
     * 
     * @param nameResultEx
     *          nameResultEx
     */
    public void setNameResultEx(String nameResultEx) {
        this.nameResultEx = nameResultEx;
    }
    
    /**
     * 获取chargeflag
     * 
     * @return chargeflag
     */
    public Integer getChargeflag() {
        return this.chargeflag;
    }
     
    /**
     * 设置chargeflag
     * 
     * @param chargeflag
     *          chargeflag
     */
    public void setChargeflag(Integer chargeflag) {
        this.chargeflag = chargeflag;
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
     * 获取0 申请（护士核对后），1 收费，2 执行，9 取消
     * 
     * @return 0 申请（护士核对后）
     */
    public Integer getStatus() {
        return this.status;
    }
     
    /**
     * 设置0 申请（护士核对后），1 收费，2 执行，9 取消
     * 
     * @param status
     *          0 申请（护士核对后），1 收费，2 执行，9 取消
     */
    public void setStatus(Integer status) {
        this.status = status;
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
     * 获取datePlan
     * 
     * @return datePlan
     */
    public String getDatePlan() {
        return this.datePlan;
    }
     
    /**
     * 设置datePlan
     * 
     * @param datePlan
     *          datePlan
     */
    public void setDatePlan(String datePlan) {
        this.datePlan = datePlan;
    }

	public BigDecimal getNumEx() {
		return numEx;
	}

	public void setNumEx(BigDecimal numEx) {
		this.numEx = numEx;
	}

	public String getUnitEx() {
		return unitEx;
	}

	public void setUnitEx(String unitEx) {
		this.unitEx = unitEx;
	}
    
    
}