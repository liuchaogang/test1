package com.yonyou.entity;
/******************************************************************
** 类    名：UhDcOrdRecordEntity
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
 * (UH_DC_ORD_RECORD)
 * 
 * @author bianj
 * @version 1.0.0 2017-07-09
 */
@Entity
@Table(name = "UH_DC_ORD_RECORD")
public class UhDcOrdRecord implements java.io.Serializable {
    /** 版本号 */
    private static final long serialVersionUID = -385604281546209751L;
    
    /**  */
    @Id
    @Column(name = "PK_ORD_RECORD" )
    @GenericGenerator(name = "system-uuid", strategy = "uuid")
    @GeneratedValue(generator = "system-uuid")
    private String pkOrdRecord;
    
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
    @Column(name = "PK_DCPV" )
    private String pkDcpv;
    
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
    @Column(name = "AGE" )
    private String age;
    
    /**  */
    @Column(name = "ADDR_PRE" )
    private String addrPre;
    
    /**  */
    @Column(name = "TELENO_PRE" )
    private String telenoPre;
    
    /**  */
    @Column(name = "CODE_DEPT" )
    private String codeDept;
    
    /**  */
    @Column(name = "NAME_DEPT" )
    private String nameDept;
    
    /**  */
    @Column(name = "CODE_AREA" )
    private String codeArea;
    
    /**  */
    @Column(name = "NAME_AREA" )
    private String nameArea;
    
    /**  */
    @Column(name = "BED" )
    private String bed;
    
    /**  */
    @Column(name = "PK_DCORDRISREQ" )
    private String pkDcordrisreq;
    
    /**  */
    @Column(name = "CODE_REQ" )
    private String codeReq;
    
    /**  */
    @Column(name = "CODE_REP" )
    private String codeRep;
    
    /**  */
    @Column(name = "CODE_REP_TYPE" )
    private String codeRepType;
    
    /**  */
    @Column(name = "NAME_REP_TYPE" )
    private String nameRepType;
    
    /**  */
    @Column(name = "CODE_STATE" )
    private String codeState;
    
    /**  */
    @Column(name = "NAME_STATE" )
    private String nameState;
    
    /**  */
    @Column(name = "CODE_EU_TYPE" )
    private String codeEuType;
    
    /**  */
    @Column(name = "NAME_EU_TYPE" )
    private String nameEuType;
    
    /**  */
    @Column(name = "CODE_EU_ITEM" )
    private String codeEuItem;
    
    /**  */
    @Column(name = "NAME_EU_ITEM" )
    private String nameEuItem;
    
    /**  */
    @Column(name = "CODE_PART" )
    private String codePart;
    
    /**  */
    @Column(name = "NAME_PART" )
    private String namePart;
    
    /**  */
    @Column(name = "CODE_EU_ORG" )
    private String codeEuOrg;
    
    /**  */
    @Column(name = "NAME_EU_ORG" )
    private String nameEuOrg;
    
    /**  */
    @Column(name = "CODE_EU_DEP" )
    private String codeEuDep;
    
    /**  */
    @Column(name = "NAME_EU_DEP" )
    private String nameEuDep;
    
    /**  */
    @Column(name = "CODE_EU_PSN_PIS" )
    private String codeEuPsnPis;
    
    /**  */
    @Column(name = "NAME_EU_PSN_PIS" )
    private String nameEuPsnPis;
    
    /**  */
    @Column(name = "DATE_RIS" )
    private String dateRis;
    
    /**  */
    @Column(name = "CODE_PSN_REP" )
    private String codePsnRep;
    
    /**  */
    @Column(name = "NAME_PSN_REP" )
    private String namePsnRep;
    
    /**  */
    @Column(name = "DATE_REP" )
    private String dateRep;
    
    /**  */
    @Column(name = "CODE_PSN_CHECK" )
    private String codePsnCheck;
    
    /**  */
    @Column(name = "NAME_PSN_CHECK" )
    private String namePsnCheck;
    
    /**  */
    @Column(name = "DATE_CHECK" )
    private String dateCheck;
    
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
     * 获取age
     * 
     * @return age
     */
    public String getAge() {
        return this.age;
    }
     
    /**
     * 设置age
     * 
     * @param age
     *          age
     */
    public void setAge(String age) {
        this.age = age;
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
     * 获取codeDept
     * 
     * @return codeDept
     */
    public String getCodeDept() {
        return this.codeDept;
    }
     
    /**
     * 设置codeDept
     * 
     * @param codeDept
     *          codeDept
     */
    public void setCodeDept(String codeDept) {
        this.codeDept = codeDept;
    }
    
    /**
     * 获取nameDept
     * 
     * @return nameDept
     */
    public String getNameDept() {
        return this.nameDept;
    }
     
    /**
     * 设置nameDept
     * 
     * @param nameDept
     *          nameDept
     */
    public void setNameDept(String nameDept) {
        this.nameDept = nameDept;
    }
    
    /**
     * 获取codeArea
     * 
     * @return codeArea
     */
    public String getCodeArea() {
        return this.codeArea;
    }
     
    /**
     * 设置codeArea
     * 
     * @param codeArea
     *          codeArea
     */
    public void setCodeArea(String codeArea) {
        this.codeArea = codeArea;
    }
    
    /**
     * 获取nameArea
     * 
     * @return nameArea
     */
    public String getNameArea() {
        return this.nameArea;
    }
     
    /**
     * 设置nameArea
     * 
     * @param nameArea
     *          nameArea
     */
    public void setNameArea(String nameArea) {
        this.nameArea = nameArea;
    }
    
    /**
     * 获取bed
     * 
     * @return bed
     */
    public String getBed() {
        return this.bed;
    }
     
    /**
     * 设置bed
     * 
     * @param bed
     *          bed
     */
    public void setBed(String bed) {
        this.bed = bed;
    }
    
    /**
     * 获取pkDcordrisreq
     * 
     * @return pkDcordrisreq
     */
    public String getPkDcordrisreq() {
        return this.pkDcordrisreq;
    }
     
    /**
     * 设置pkDcordrisreq
     * 
     * @param pkDcordrisreq
     *          pkDcordrisreq
     */
    public void setPkDcordrisreq(String pkDcordrisreq) {
        this.pkDcordrisreq = pkDcordrisreq;
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
     * 获取codeRepType
     * 
     * @return codeRepType
     */
    public String getCodeRepType() {
        return this.codeRepType;
    }
     
    /**
     * 设置codeRepType
     * 
     * @param codeRepType
     *          codeRepType
     */
    public void setCodeRepType(String codeRepType) {
        this.codeRepType = codeRepType;
    }
    
    /**
     * 获取nameRepType
     * 
     * @return nameRepType
     */
    public String getNameRepType() {
        return this.nameRepType;
    }
     
    /**
     * 设置nameRepType
     * 
     * @param nameRepType
     *          nameRepType
     */
    public void setNameRepType(String nameRepType) {
        this.nameRepType = nameRepType;
    }
    
    /**
     * 获取codeState
     * 
     * @return codeState
     */
    public String getCodeState() {
        return this.codeState;
    }
     
    /**
     * 设置codeState
     * 
     * @param codeState
     *          codeState
     */
    public void setCodeState(String codeState) {
        this.codeState = codeState;
    }
    
    /**
     * 获取nameState
     * 
     * @return nameState
     */
    public String getNameState() {
        return this.nameState;
    }
     
    /**
     * 设置nameState
     * 
     * @param nameState
     *          nameState
     */
    public void setNameState(String nameState) {
        this.nameState = nameState;
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
     * 获取codeEuItem
     * 
     * @return codeEuItem
     */
    public String getCodeEuItem() {
        return this.codeEuItem;
    }
     
    /**
     * 设置codeEuItem
     * 
     * @param codeEuItem
     *          codeEuItem
     */
    public void setCodeEuItem(String codeEuItem) {
        this.codeEuItem = codeEuItem;
    }
    
    /**
     * 获取nameEuItem
     * 
     * @return nameEuItem
     */
    public String getNameEuItem() {
        return this.nameEuItem;
    }
     
    /**
     * 设置nameEuItem
     * 
     * @param nameEuItem
     *          nameEuItem
     */
    public void setNameEuItem(String nameEuItem) {
        this.nameEuItem = nameEuItem;
    }
    
    /**
     * 获取codePart
     * 
     * @return codePart
     */
    public String getCodePart() {
        return this.codePart;
    }
     
    /**
     * 设置codePart
     * 
     * @param codePart
     *          codePart
     */
    public void setCodePart(String codePart) {
        this.codePart = codePart;
    }
    
    /**
     * 获取namePart
     * 
     * @return namePart
     */
    public String getNamePart() {
        return this.namePart;
    }
     
    /**
     * 设置namePart
     * 
     * @param namePart
     *          namePart
     */
    public void setNamePart(String namePart) {
        this.namePart = namePart;
    }
    
    /**
     * 获取codeEuOrg
     * 
     * @return codeEuOrg
     */
    public String getCodeEuOrg() {
        return this.codeEuOrg;
    }
     
    /**
     * 设置codeEuOrg
     * 
     * @param codeEuOrg
     *          codeEuOrg
     */
    public void setCodeEuOrg(String codeEuOrg) {
        this.codeEuOrg = codeEuOrg;
    }
    
    /**
     * 获取nameEuOrg
     * 
     * @return nameEuOrg
     */
    public String getNameEuOrg() {
        return this.nameEuOrg;
    }
     
    /**
     * 设置nameEuOrg
     * 
     * @param nameEuOrg
     *          nameEuOrg
     */
    public void setNameEuOrg(String nameEuOrg) {
        this.nameEuOrg = nameEuOrg;
    }
    
    /**
     * 获取codeEuDep
     * 
     * @return codeEuDep
     */
    public String getCodeEuDep() {
        return this.codeEuDep;
    }
     
    /**
     * 设置codeEuDep
     * 
     * @param codeEuDep
     *          codeEuDep
     */
    public void setCodeEuDep(String codeEuDep) {
        this.codeEuDep = codeEuDep;
    }
    
    /**
     * 获取nameEuDep
     * 
     * @return nameEuDep
     */
    public String getNameEuDep() {
        return this.nameEuDep;
    }
     
    /**
     * 设置nameEuDep
     * 
     * @param nameEuDep
     *          nameEuDep
     */
    public void setNameEuDep(String nameEuDep) {
        this.nameEuDep = nameEuDep;
    }
    
    /**
     * 获取codeEuPsnPis
     * 
     * @return codeEuPsnPis
     */
    public String getCodeEuPsnPis() {
        return this.codeEuPsnPis;
    }
     
    /**
     * 设置codeEuPsnPis
     * 
     * @param codeEuPsnPis
     *          codeEuPsnPis
     */
    public void setCodeEuPsnPis(String codeEuPsnPis) {
        this.codeEuPsnPis = codeEuPsnPis;
    }
    
    /**
     * 获取nameEuPsnPis
     * 
     * @return nameEuPsnPis
     */
    public String getNameEuPsnPis() {
        return this.nameEuPsnPis;
    }
     
    /**
     * 设置nameEuPsnPis
     * 
     * @param nameEuPsnPis
     *          nameEuPsnPis
     */
    public void setNameEuPsnPis(String nameEuPsnPis) {
        this.nameEuPsnPis = nameEuPsnPis;
    }
    
    /**
     * 获取dateRis
     * 
     * @return dateRis
     */
    public String getDateRis() {
        return this.dateRis;
    }
     
    /**
     * 设置dateRis
     * 
     * @param dateRis
     *          dateRis
     */
    public void setDateRis(String dateRis) {
        this.dateRis = dateRis;
    }
    
    /**
     * 获取codePsnRep
     * 
     * @return codePsnRep
     */
    public String getCodePsnRep() {
        return this.codePsnRep;
    }
     
    /**
     * 设置codePsnRep
     * 
     * @param codePsnRep
     *          codePsnRep
     */
    public void setCodePsnRep(String codePsnRep) {
        this.codePsnRep = codePsnRep;
    }
    
    /**
     * 获取namePsnRep
     * 
     * @return namePsnRep
     */
    public String getNamePsnRep() {
        return this.namePsnRep;
    }
     
    /**
     * 设置namePsnRep
     * 
     * @param namePsnRep
     *          namePsnRep
     */
    public void setNamePsnRep(String namePsnRep) {
        this.namePsnRep = namePsnRep;
    }
    
    /**
     * 获取dateRep
     * 
     * @return dateRep
     */
    public String getDateRep() {
        return this.dateRep;
    }
     
    /**
     * 设置dateRep
     * 
     * @param dateRep
     *          dateRep
     */
    public void setDateRep(String dateRep) {
        this.dateRep = dateRep;
    }
    
    /**
     * 获取codePsnCheck
     * 
     * @return codePsnCheck
     */
    public String getCodePsnCheck() {
        return this.codePsnCheck;
    }
     
    /**
     * 设置codePsnCheck
     * 
     * @param codePsnCheck
     *          codePsnCheck
     */
    public void setCodePsnCheck(String codePsnCheck) {
        this.codePsnCheck = codePsnCheck;
    }
    
    /**
     * 获取namePsnCheck
     * 
     * @return namePsnCheck
     */
    public String getNamePsnCheck() {
        return this.namePsnCheck;
    }
     
    /**
     * 设置namePsnCheck
     * 
     * @param namePsnCheck
     *          namePsnCheck
     */
    public void setNamePsnCheck(String namePsnCheck) {
        this.namePsnCheck = namePsnCheck;
    }
    
    /**
     * 获取dateCheck
     * 
     * @return dateCheck
     */
    public String getDateCheck() {
        return this.dateCheck;
    }
     
    /**
     * 设置dateCheck
     * 
     * @param dateCheck
     *          dateCheck
     */
    public void setDateCheck(String dateCheck) {
        this.dateCheck = dateCheck;
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