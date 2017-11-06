package com.yonyou.entity;
/******************************************************************
** 类    名：UhDcOrdPisRecordEntity
** 描    述：
** 创 建 者：bianj
** 创建时间：2017-07-09 15:14:20
******************************************************************/

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

/**
 * (UH_DC_ORD_PIS_RECORD)
 * 
 * @author bianj
 * @version 1.0.0 2017-07-09
 */
@Entity
@Table(name = "UH_DC_ORD_PIS_RECORD")
public class UhDcOrdPisRecord implements java.io.Serializable {
    /** 版本号 */
    private static final long serialVersionUID = -6152488366199832824L;
    
    /**  */
    @Id
    @Column(name = "PK_REP_PIS" )
    @GenericGenerator(name = "system-uuid", strategy = "uuid")
    @GeneratedValue(generator = "system-uuid")
    private String pkRepPis;
    
    /**  */
    @Column(name = "PK_ORD_RECORD" )
    private String pkOrdRecord;
    
    /**  */
    @Column(name = "CODE_GROUP" )
    private String codeGroup;
    
    /**  */
    @Column(name = "CODE_ORG" )
    private String codeOrg;
    
    /**  */
    @Column(name = "CODE_REP" )
    private String codeRep;
    
    /**  */
    @Column(name = "CODE_RESULT_TYPE" )
    private String codeResultType;
    
    /**  */
    @Column(name = "NAME_RESULT_TYPE" )
    private String nameResultType;
    
    /**  */
    @Column(name = "RESULT_OBJ" )
    private String resultObj;
    
    /**  */
    @Column(name = "LIGHT_RESULT" )
    private String lightResult;
    
    /**  */
    @Column(name = "CODE_DIAG" )
    private String codeDiag;
    
    /**  */
    @Column(name = "NAME_DIAG" )
    private String nameDiag;
    
    /**  */
    @Column(name = "EU_RESULT" )
    private String euResult;
    
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
     * 获取pkRepPis
     * 
     * @return pkRepPis
     */
    public String getPkRepPis() {
        return this.pkRepPis;
    }
     
    /**
     * 设置pkRepPis
     * 
     * @param pkRepPis
     *          pkRepPis
     */
    public void setPkRepPis(String pkRepPis) {
        this.pkRepPis = pkRepPis;
    }
    
    /**
     * 获取pkOrdRecord
     * 
     * @return pkOrdRecord
     */
    public String getPkOrdRecord() {
        return this.pkOrdRecord;
    }
     
    /**
     * 设置pkOrdRecord
     * 
     * @param pkOrdRecord
     *          pkOrdRecord
     */
    public void setPkOrdRecord(String pkOrdRecord) {
        this.pkOrdRecord = pkOrdRecord;
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
     * 获取codeRep
     * 
     * @return codeRep
     */
    public String getCodeRep() {
        return this.codeRep;
    }
     
    /**
     * 设置codeRep
     * 
     * @param codeRep
     *          codeRep
     */
    public void setCodeRep(String codeRep) {
        this.codeRep = codeRep;
    }
    
    /**
     * 获取codeResultType
     * 
     * @return codeResultType
     */
    public String getCodeResultType() {
        return this.codeResultType;
    }
     
    /**
     * 设置codeResultType
     * 
     * @param codeResultType
     *          codeResultType
     */
    public void setCodeResultType(String codeResultType) {
        this.codeResultType = codeResultType;
    }
    
    /**
     * 获取nameResultType
     * 
     * @return nameResultType
     */
    public String getNameResultType() {
        return this.nameResultType;
    }
     
    /**
     * 设置nameResultType
     * 
     * @param nameResultType
     *          nameResultType
     */
    public void setNameResultType(String nameResultType) {
        this.nameResultType = nameResultType;
    }
    
    /**
     * 获取resultObj
     * 
     * @return resultObj
     */
    public String getResultObj() {
        return this.resultObj;
    }
     
    /**
     * 设置resultObj
     * 
     * @param resultObj
     *          resultObj
     */
    public void setResultObj(String resultObj) {
        this.resultObj = resultObj;
    }
    
    /**
     * 获取lightResult
     * 
     * @return lightResult
     */
    public String getLightResult() {
        return this.lightResult;
    }
     
    /**
     * 设置lightResult
     * 
     * @param lightResult
     *          lightResult
     */
    public void setLightResult(String lightResult) {
        this.lightResult = lightResult;
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
     * 获取euResult
     * 
     * @return euResult
     */
    public String getEuResult() {
        return this.euResult;
    }
     
    /**
     * 设置euResult
     * 
     * @param euResult
     *          euResult
     */
    public void setEuResult(String euResult) {
        this.euResult = euResult;
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