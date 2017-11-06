package com.yonyou.entity;
 
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

/**
 * 
 * @author liuchaogang@yonyou.com
 * @ClassName:UhDcOrdPacsRecord.java
 * @Description: 
 * @date 2017年8月31日 下午10:14:09
 */
@Entity
@Table(name = "UH_DC_ORD_PACS_RECORD",schema = "dbo", catalog = "MIP_DC_DEMO")
public class UhDcOrdPacsRecord implements java.io.Serializable {
    
    private static final long serialVersionUID = -5666493431812038694L;
    
    
   
    @Id
    @Column(name = "PK_PACS")
    @GenericGenerator(name = "system-uuid", strategy = "uuid")
    @GeneratedValue(generator = "system-uuid")
    private String pkPacs;
    
    
    @Column(name = "PK_ORD_RECORD")
    private String pkOrdRecord;
    
    
    @Column(name = "CODE_GROUP")
    private String codeGroup;
    
    
    @Column(name = "CODE_ORG")
    private String codeOrg;
    
    /** 业务唯一索引 */
    @Column(name = "CODE_REP")
    private String codeRep;
    
    
    @Column(name = "CODE_DIAG")
    private String codeDiag;
    
    
    @Column(name = "NAME_DIAG")
    private String nameDiag;
    
    
    @Column(name = "RESULT_OBJ")
    private String resultObj;
    
    
    @Column(name = "RESULT_SUBJ")
    private String resultSubj;
    
    /** 0阴性 1阳性 */
    @Column(name = "CODE_RESULT_TYPE")
    private String codeResultType;
    
    
    @Column(name = "NAME_RESULT_TYPE")
    private String nameResultType;
    
    
    @Column(name = "EU_RESULT")
    private String euResult;
    
    
    @Column(name = "ADDR_IMG")
    private String addrImg;
    
    
    @Column(name = "NOTE")
    private String note;
    
    
    @Column(name = "DATA_SOURCE")
    private String dataSource;
    
    
    @Column(name = "SOURCE_PK")
    private String sourcePk;
    
    
    @Column(name = "CREATE_TIME")
    private Date createTime;
    
    
    @Column(name = "EDIT_TIME")
    private Date editTime;
    
    /** 0正常，1Nosql迁移，2业务删除 */
    @Column(name = "FLAG_DEL")
    private Integer flagDel;
    
    /**
     * 获取pkPacs
     * 
     * @return pkPacs
     */
    public String getPkPacs() {
        return this.pkPacs;
    }
     
    /**
     * 设置pkPacs
     * 
     * @param pkPacs
     *          pkPacs
     */
    public void setPkPacs(String pkPacs) {
        this.pkPacs = pkPacs;
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
     * 获取业务唯一索引
     * 
     * @return 业务唯一索引
     */
    public String getCodeRep() {
        return this.codeRep;
    }
     
    /**
     * 设置业务唯一索引
     * 
     * @param codeRep
     *          业务唯一索引
     */
    public void setCodeRep(String codeRep) {
        this.codeRep = codeRep;
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
     * 获取resultSubj
     * 
     * @return resultSubj
     */
    public String getResultSubj() {
        return this.resultSubj;
    }
     
    /**
     * 设置resultSubj
     * 
     * @param resultSubj
     *          resultSubj
     */
    public void setResultSubj(String resultSubj) {
        this.resultSubj = resultSubj;
    }
    
    /**
     * 获取0阴性 1阳性
     * 
     * @return 0阴性 1阳性
     */
    public String getCodeResultType() {
        return this.codeResultType;
    }
     
    /**
     * 设置0阴性 1阳性
     * 
     * @param codeResultType
     *          0阴性 1阳性
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
     * 获取addrImg
     * 
     * @return addrImg
     */
    public String getAddrImg() {
        return this.addrImg;
    }
     
    /**
     * 设置addrImg
     * 
     * @param addrImg
     *          addrImg
     */
    public void setAddrImg(String addrImg) {
        this.addrImg = addrImg;
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