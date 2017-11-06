package com.yonyou.entity;
/******************************************************************
** 类    名：UhDcPvDiagEntity
** 描    述：
** 创 建 者：bianj
** 创建时间：2017-07-05 18:29:19
******************************************************************/

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

/**
 * (UH_DC_PV_DIAG)
 * 
 * @author bianj
 * @version 1.0.0 2017-07-05
 */
@Entity
@Table(name = "UH_DC_PV_DIAG")
public class UhDcPvDiag implements java.io.Serializable {
    /** 版本号 */
    private static final long serialVersionUID = -3323861800797435164L;
    
    /**  */
    @Id
    @GenericGenerator(name = "system-uuid", strategy = "uuid")
    @GeneratedValue(generator = "system-uuid")
    @Column(name = "PK_DCPVDIAG" )
    private String pkDcpvdiag;
    
    /**  */
    @Column(name = "PK_DCPV" )
    private String pkDcpv;
    
    /**  */
    @Column(name = "CODE_GROUP" )
    private String codeGroup;
    
    /**  */
    @Column(name = "CODE_ORG" )
    private String codeOrg;
    
    /**  */
    @Column(name = "EMPI" )
    private String empi;
    
    /**  */
    @Column(name = "CODE_DIAGPHASE" )
    private String codeDiagphase;
    
    /**  */
    @Column(name = "NAME_DIAGPHASE" )
    private String nameDiagphase;
    
    /**  */
    @Column(name = "CODE_DIAGTYPE" )
    private String codeDiagtype;
    
    /**  */
    @Column(name = "NAME_DIAGTYPE" )
    private String nameDiagtype;
    
    /**  */
    @Column(name = "CODE_DIAGSYS" )
    private String codeDiagsys;
    
    /**  */
    @Column(name = "NAME_DIAGSYS" )
    private String nameDiagsys;
    
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
    @Column(name = "DATE_DIAG" )
    private String dateDiag;
    
    /**  */
    @Column(name = "CODE_DEPT_DIAG" )
    private String codeDeptDiag;
    
    /**  */
    @Column(name = "NAME_DEPT_DIAG" )
    private String nameDeptDiag;
    
    /**  */
    @Column(name = "CODE_PSN_DIAG" )
    private String codePsnDiag;
    
    /**  */
    @Column(name = "NAME_PSN_DIAG" )
    private String namePsnDiag;
    
    /**  */
    @Column(name = "CODE_CURE" )
    private String codeCure;
    
    /**  */
    @Column(name = "NAME_CURE" )
    private String nameCure;
    
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
    
    /**  */
    @Column(name = "CODE_PATI" )
    private String codePati;
    
    /**  */
    @Column(name = "CODE_PVTYPE" )
    private String codePvtype;
    
    /**  */
    @Column(name = "NAME_PVTYPE" )
    private String namePvtype;
    
    /**  */
    @Column(name = "PVCODE" )
    private String pvcode;
    
    /**  */
    @Column(name = "FLAG_MAIN" )
    private String flagMain;
    
    /**  */
    @Column(name = "FLAG_UNCERTAINTY" )
    private String flagUncertainty;
    
    /**
     * 获取pkDcpvdiag
     * 
     * @return pkDcpvdiag
     */
    public String getPkDcpvdiag() {
        return this.pkDcpvdiag;
    }
     
    /**
     * 设置pkDcpvdiag
     * 
     * @param pkDcpvdiag
     *          pkDcpvdiag
     */
    public void setPkDcpvdiag(String pkDcpvdiag) {
        this.pkDcpvdiag = pkDcpvdiag;
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
     * 获取codeDiagphase
     * 
     * @return codeDiagphase
     */
    public String getCodeDiagphase() {
        return this.codeDiagphase;
    }
     
    /**
     * 设置codeDiagphase
     * 
     * @param codeDiagphase
     *          codeDiagphase
     */
    public void setCodeDiagphase(String codeDiagphase) {
        this.codeDiagphase = codeDiagphase;
    }
    
    /**
     * 获取nameDiagphase
     * 
     * @return nameDiagphase
     */
    public String getNameDiagphase() {
        return this.nameDiagphase;
    }
     
    /**
     * 设置nameDiagphase
     * 
     * @param nameDiagphase
     *          nameDiagphase
     */
    public void setNameDiagphase(String nameDiagphase) {
        this.nameDiagphase = nameDiagphase;
    }
    
    /**
     * 获取codeDiagtype
     * 
     * @return codeDiagtype
     */
    public String getCodeDiagtype() {
        return this.codeDiagtype;
    }
     
    /**
     * 设置codeDiagtype
     * 
     * @param codeDiagtype
     *          codeDiagtype
     */
    public void setCodeDiagtype(String codeDiagtype) {
        this.codeDiagtype = codeDiagtype;
    }
    
    /**
     * 获取nameDiagtype
     * 
     * @return nameDiagtype
     */
    public String getNameDiagtype() {
        return this.nameDiagtype;
    }
     
    /**
     * 设置nameDiagtype
     * 
     * @param nameDiagtype
     *          nameDiagtype
     */
    public void setNameDiagtype(String nameDiagtype) {
        this.nameDiagtype = nameDiagtype;
    }
    
    /**
     * 获取codeDiagsys
     * 
     * @return codeDiagsys
     */
    public String getCodeDiagsys() {
        return this.codeDiagsys;
    }
     
    /**
     * 设置codeDiagsys
     * 
     * @param codeDiagsys
     *          codeDiagsys
     */
    public void setCodeDiagsys(String codeDiagsys) {
        this.codeDiagsys = codeDiagsys;
    }
    
    /**
     * 获取nameDiagsys
     * 
     * @return nameDiagsys
     */
    public String getNameDiagsys() {
        return this.nameDiagsys;
    }
     
    /**
     * 设置nameDiagsys
     * 
     * @param nameDiagsys
     *          nameDiagsys
     */
    public void setNameDiagsys(String nameDiagsys) {
        this.nameDiagsys = nameDiagsys;
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
     * 获取dateDiag
     * 
     * @return dateDiag
     */
    public String getDateDiag() {
        return this.dateDiag;
    }
     
    /**
     * 设置dateDiag
     * 
     * @param dateDiag
     *          dateDiag
     */
    public void setDateDiag(String dateDiag) {
        this.dateDiag = dateDiag;
    }
    
    /**
     * 获取codeDeptDiag
     * 
     * @return codeDeptDiag
     */
    public String getCodeDeptDiag() {
        return this.codeDeptDiag;
    }
     
    /**
     * 设置codeDeptDiag
     * 
     * @param codeDeptDiag
     *          codeDeptDiag
     */
    public void setCodeDeptDiag(String codeDeptDiag) {
        this.codeDeptDiag = codeDeptDiag;
    }
    
    /**
     * 获取nameDeptDiag
     * 
     * @return nameDeptDiag
     */
    public String getNameDeptDiag() {
        return this.nameDeptDiag;
    }
     
    /**
     * 设置nameDeptDiag
     * 
     * @param nameDeptDiag
     *          nameDeptDiag
     */
    public void setNameDeptDiag(String nameDeptDiag) {
        this.nameDeptDiag = nameDeptDiag;
    }
    
    /**
     * 获取codePsnDiag
     * 
     * @return codePsnDiag
     */
    public String getCodePsnDiag() {
        return this.codePsnDiag;
    }
     
    /**
     * 设置codePsnDiag
     * 
     * @param codePsnDiag
     *          codePsnDiag
     */
    public void setCodePsnDiag(String codePsnDiag) {
        this.codePsnDiag = codePsnDiag;
    }
    
    /**
     * 获取namePsnDiag
     * 
     * @return namePsnDiag
     */
    public String getNamePsnDiag() {
        return this.namePsnDiag;
    }
     
    /**
     * 设置namePsnDiag
     * 
     * @param namePsnDiag
     *          namePsnDiag
     */
    public void setNamePsnDiag(String namePsnDiag) {
        this.namePsnDiag = namePsnDiag;
    }
    
    /**
     * 获取codeCure
     * 
     * @return codeCure
     */
    public String getCodeCure() {
        return this.codeCure;
    }
     
    /**
     * 设置codeCure
     * 
     * @param codeCure
     *          codeCure
     */
    public void setCodeCure(String codeCure) {
        this.codeCure = codeCure;
    }
    
    /**
     * 获取nameCure
     * 
     * @return nameCure
     */
    public String getNameCure() {
        return this.nameCure;
    }
     
    /**
     * 设置nameCure
     * 
     * @param nameCure
     *          nameCure
     */
    public void setNameCure(String nameCure) {
        this.nameCure = nameCure;
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
     * 获取codePvtype
     * 
     * @return codePvtype
     */
    public String getCodePvtype() {
        return this.codePvtype;
    }
     
    /**
     * 设置codePvtype
     * 
     * @param codePvtype
     *          codePvtype
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

	public String getFlagMain() {
		return flagMain;
	}

	public void setFlagMain(String flagMain) {
		this.flagMain = flagMain;
	}

	public String getFlagUncertainty() {
		return flagUncertainty;
	}

	public void setFlagUncertainty(String flagUncertainty) {
		this.flagUncertainty = flagUncertainty;
	}
    
    
}