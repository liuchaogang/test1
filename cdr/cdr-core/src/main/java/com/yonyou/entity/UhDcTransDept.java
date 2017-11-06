package com.yonyou.entity;

 
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "UH_DC_TRANS_DEPT",schema = "dbo", catalog = "MIP_DC_DEMO")
public class UhDcTransDept{
  
   
    @Id
    @Column(name = "PK_TRANS")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
    private Integer pkTrans;
    
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
    @Column(name = "CODE_PVTYPE" )
    private String codePvtype;
    
    /**  */
    @Column(name = "NAME_PVTYPE" )
    private String namePvtype;
    
    /**  */
    @Column(name = "PVCODE" )
    private String pvcode;
    
    /**  */
    @Column(name = "TRANS_TYPE" )
    private String transType;
    
    /**  */
    @Column(name = "DIAG_DESC" )
    private String diagDesc;
    
    /**  */
    @Column(name = "TRANS_PUR" )
    private String transPur;
    
    /**  */
    @Column(name = "DATE_OUT" )
    private String dateOut;
    
    /**  */
    @Column(name = "CODE_DEPT_OUT" )
    private String codeDeptOut;
    
    /**  */
    @Column(name = "NAME_DEPT_OUT" )
    private String nameDeptOut;
    
    /**  */
    @Column(name = "CODE_MGROUP_OUT" )
    private String codeMgroupOut;
    
    /**  */
    @Column(name = "NAME_MGROUP_OUT" )
    private String nameMgroupOut;
    
    /**  */
    @Column(name = "CODE_AREA_OUT" )
    private String codeAreaOut;
    
    /**  */
    @Column(name = "NAME_AREA_OUT" )
    private String nameAreaOut;
    
    /**  */
    @Column(name = "WARD_NO_OUT" )
    private String wardNoOut;
    
    /**  */
    @Column(name = "BED_NO_OUT" )
    private String bedNoOut;
    
    /**  */
    @Column(name = "DOC_CODE_OUT" )
    private String docCodeOut;
    
    /**  */
    @Column(name = "DOC_NAME_OUT" )
    private String docNameOut;
    
    /**  */
    @Column(name = "NURSE_CODE_OUT" )
    private String nurseCodeOut;
    
    /**  */
    @Column(name = "NURSE_NAME_OUT" )
    private String nurseNameOut;
    
    /**  */
    @Column(name = "DATE_IN" )
    private String dateIn;
    
    /**  */
    @Column(name = "CODE_DEPT_IN" )
    private String codeDeptIn;
    
    /**  */
    @Column(name = "NAME_DEPT_IN" )
    private String nameDeptIn;
    
    /**  */
    @Column(name = "CODE_AREA_IN" )
    private String codeAreaIn;
    
    /**  */
    @Column(name = "NAME_AREA_IN" )
    private String nameAreaIn;
    
    /**  */
    @Column(name = "WARD_NO_IN" )
    private String wardNoIn;
    
    /**  */
    @Column(name = "BED_NO_IN" )
    private String bedNoIn;
    
    /**  */
    @Column(name = "DOC_CODE_IN" )
    private String docCodeIn;
    
    /**  */
    @Column(name = "DOC_NAME_IN" )
    private String docNameIn;
    
    /**  */
    @Column(name = "NURSE_CODE_IN" )
    private String nurseCodeIn;
    
    /**  */
    @Column(name = "NURSE_NAME_IN" )
    private String nurseNameIn;
    
    /**  */
    @Column(name = "CODE_PSN_OP" )
    private String codePsnOp;
    
    /**  */
    @Column(name = "NAME_PSN_OP" )
    private String namePsnOp;
    
    /**  */
    @Column(name = "DATE_OP" )
    private String dateOp;
    
    /**  */
    @Column(name = "FLAG_CANC" )
    private Integer flagCanc;
    
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
     * 获取pkTrans
     * 
     * @return pkTrans
     */
    public Integer getPkTrans() {
        return this.pkTrans;
    }
     
    /**
     * 设置pkTrans
     * 
     * @param pkTrans
     *          pkTrans
     */
    public void setPkTrans(Integer pkTrans) {
        this.pkTrans = pkTrans;
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
     * 获取transType
     * 
     * @return transType
     */
    public String getTransType() {
        return this.transType;
    }
     
    /**
     * 设置transType
     * 
     * @param transType
     *          transType
     */
    public void setTransType(String transType) {
        this.transType = transType;
    }
    
    /**
     * 获取diagDesc
     * 
     * @return diagDesc
     */
    public String getDiagDesc() {
        return this.diagDesc;
    }
     
    /**
     * 设置diagDesc
     * 
     * @param diagDesc
     *          diagDesc
     */
    public void setDiagDesc(String diagDesc) {
        this.diagDesc = diagDesc;
    }
    
    /**
     * 获取transPur
     * 
     * @return transPur
     */
    public String getTransPur() {
        return this.transPur;
    }
     
    /**
     * 设置transPur
     * 
     * @param transPur
     *          transPur
     */
    public void setTransPur(String transPur) {
        this.transPur = transPur;
    }
    
    /**
     * 获取dateOut
     * 
     * @return dateOut
     */
    public String getDateOut() {
        return this.dateOut;
    }
     
    /**
     * 设置dateOut
     * 
     * @param dateOut
     *          dateOut
     */
    public void setDateOut(String dateOut) {
        this.dateOut = dateOut;
    }
    
    /**
     * 获取codeDeptOut
     * 
     * @return codeDeptOut
     */
    public String getCodeDeptOut() {
        return this.codeDeptOut;
    }
     
    /**
     * 设置codeDeptOut
     * 
     * @param codeDeptOut
     *          codeDeptOut
     */
    public void setCodeDeptOut(String codeDeptOut) {
        this.codeDeptOut = codeDeptOut;
    }
    
    /**
     * 获取nameDeptOut
     * 
     * @return nameDeptOut
     */
    public String getNameDeptOut() {
        return this.nameDeptOut;
    }
     
    /**
     * 设置nameDeptOut
     * 
     * @param nameDeptOut
     *          nameDeptOut
     */
    public void setNameDeptOut(String nameDeptOut) {
        this.nameDeptOut = nameDeptOut;
    }
    
    /**
     * 获取codeMgroupOut
     * 
     * @return codeMgroupOut
     */
    public String getCodeMgroupOut() {
        return this.codeMgroupOut;
    }
     
    /**
     * 设置codeMgroupOut
     * 
     * @param codeMgroupOut
     *          codeMgroupOut
     */
    public void setCodeMgroupOut(String codeMgroupOut) {
        this.codeMgroupOut = codeMgroupOut;
    }
    
    /**
     * 获取nameMgroupOut
     * 
     * @return nameMgroupOut
     */
    public String getNameMgroupOut() {
        return this.nameMgroupOut;
    }
     
    /**
     * 设置nameMgroupOut
     * 
     * @param nameMgroupOut
     *          nameMgroupOut
     */
    public void setNameMgroupOut(String nameMgroupOut) {
        this.nameMgroupOut = nameMgroupOut;
    }
    
    /**
     * 获取codeAreaOut
     * 
     * @return codeAreaOut
     */
    public String getCodeAreaOut() {
        return this.codeAreaOut;
    }
     
    /**
     * 设置codeAreaOut
     * 
     * @param codeAreaOut
     *          codeAreaOut
     */
    public void setCodeAreaOut(String codeAreaOut) {
        this.codeAreaOut = codeAreaOut;
    }
    
    /**
     * 获取nameAreaOut
     * 
     * @return nameAreaOut
     */
    public String getNameAreaOut() {
        return this.nameAreaOut;
    }
     
    /**
     * 设置nameAreaOut
     * 
     * @param nameAreaOut
     *          nameAreaOut
     */
    public void setNameAreaOut(String nameAreaOut) {
        this.nameAreaOut = nameAreaOut;
    }
    
    /**
     * 获取wardNoOut
     * 
     * @return wardNoOut
     */
    public String getWardNoOut() {
        return this.wardNoOut;
    }
     
    /**
     * 设置wardNoOut
     * 
     * @param wardNoOut
     *          wardNoOut
     */
    public void setWardNoOut(String wardNoOut) {
        this.wardNoOut = wardNoOut;
    }
    
    /**
     * 获取bedNoOut
     * 
     * @return bedNoOut
     */
    public String getBedNoOut() {
        return this.bedNoOut;
    }
     
    /**
     * 设置bedNoOut
     * 
     * @param bedNoOut
     *          bedNoOut
     */
    public void setBedNoOut(String bedNoOut) {
        this.bedNoOut = bedNoOut;
    }
    
    /**
     * 获取docCodeOut
     * 
     * @return docCodeOut
     */
    public String getDocCodeOut() {
        return this.docCodeOut;
    }
     
    /**
     * 设置docCodeOut
     * 
     * @param docCodeOut
     *          docCodeOut
     */
    public void setDocCodeOut(String docCodeOut) {
        this.docCodeOut = docCodeOut;
    }
    
    /**
     * 获取docNameOut
     * 
     * @return docNameOut
     */
    public String getDocNameOut() {
        return this.docNameOut;
    }
     
    /**
     * 设置docNameOut
     * 
     * @param docNameOut
     *          docNameOut
     */
    public void setDocNameOut(String docNameOut) {
        this.docNameOut = docNameOut;
    }
    
    /**
     * 获取nurseCodeOut
     * 
     * @return nurseCodeOut
     */
    public String getNurseCodeOut() {
        return this.nurseCodeOut;
    }
     
    /**
     * 设置nurseCodeOut
     * 
     * @param nurseCodeOut
     *          nurseCodeOut
     */
    public void setNurseCodeOut(String nurseCodeOut) {
        this.nurseCodeOut = nurseCodeOut;
    }
    
    /**
     * 获取nurseNameOut
     * 
     * @return nurseNameOut
     */
    public String getNurseNameOut() {
        return this.nurseNameOut;
    }
     
    /**
     * 设置nurseNameOut
     * 
     * @param nurseNameOut
     *          nurseNameOut
     */
    public void setNurseNameOut(String nurseNameOut) {
        this.nurseNameOut = nurseNameOut;
    }
    
    /**
     * 获取dateIn
     * 
     * @return dateIn
     */
    public String getDateIn() {
        return this.dateIn;
    }
     
    /**
     * 设置dateIn
     * 
     * @param dateIn
     *          dateIn
     */
    public void setDateIn(String dateIn) {
        this.dateIn = dateIn;
    }
    
    /**
     * 获取codeDeptIn
     * 
     * @return codeDeptIn
     */
    public String getCodeDeptIn() {
        return this.codeDeptIn;
    }
     
    /**
     * 设置codeDeptIn
     * 
     * @param codeDeptIn
     *          codeDeptIn
     */
    public void setCodeDeptIn(String codeDeptIn) {
        this.codeDeptIn = codeDeptIn;
    }
    
    /**
     * 获取nameDeptIn
     * 
     * @return nameDeptIn
     */
    public String getNameDeptIn() {
        return this.nameDeptIn;
    }
     
    /**
     * 设置nameDeptIn
     * 
     * @param nameDeptIn
     *          nameDeptIn
     */
    public void setNameDeptIn(String nameDeptIn) {
        this.nameDeptIn = nameDeptIn;
    }
    
    /**
     * 获取codeAreaIn
     * 
     * @return codeAreaIn
     */
    public String getCodeAreaIn() {
        return this.codeAreaIn;
    }
     
    /**
     * 设置codeAreaIn
     * 
     * @param codeAreaIn
     *          codeAreaIn
     */
    public void setCodeAreaIn(String codeAreaIn) {
        this.codeAreaIn = codeAreaIn;
    }
    
    /**
     * 获取nameAreaIn
     * 
     * @return nameAreaIn
     */
    public String getNameAreaIn() {
        return this.nameAreaIn;
    }
     
    /**
     * 设置nameAreaIn
     * 
     * @param nameAreaIn
     *          nameAreaIn
     */
    public void setNameAreaIn(String nameAreaIn) {
        this.nameAreaIn = nameAreaIn;
    }
    
    /**
     * 获取wardNoIn
     * 
     * @return wardNoIn
     */
    public String getWardNoIn() {
        return this.wardNoIn;
    }
     
    /**
     * 设置wardNoIn
     * 
     * @param wardNoIn
     *          wardNoIn
     */
    public void setWardNoIn(String wardNoIn) {
        this.wardNoIn = wardNoIn;
    }
    
    /**
     * 获取bedNoIn
     * 
     * @return bedNoIn
     */
    public String getBedNoIn() {
        return this.bedNoIn;
    }
     
    /**
     * 设置bedNoIn
     * 
     * @param bedNoIn
     *          bedNoIn
     */
    public void setBedNoIn(String bedNoIn) {
        this.bedNoIn = bedNoIn;
    }
    
    /**
     * 获取docCodeIn
     * 
     * @return docCodeIn
     */
    public String getDocCodeIn() {
        return this.docCodeIn;
    }
     
    /**
     * 设置docCodeIn
     * 
     * @param docCodeIn
     *          docCodeIn
     */
    public void setDocCodeIn(String docCodeIn) {
        this.docCodeIn = docCodeIn;
    }
    
    /**
     * 获取docNameIn
     * 
     * @return docNameIn
     */
    public String getDocNameIn() {
        return this.docNameIn;
    }
     
    /**
     * 设置docNameIn
     * 
     * @param docNameIn
     *          docNameIn
     */
    public void setDocNameIn(String docNameIn) {
        this.docNameIn = docNameIn;
    }
    
    /**
     * 获取nurseCodeIn
     * 
     * @return nurseCodeIn
     */
    public String getNurseCodeIn() {
        return this.nurseCodeIn;
    }
     
    /**
     * 设置nurseCodeIn
     * 
     * @param nurseCodeIn
     *          nurseCodeIn
     */
    public void setNurseCodeIn(String nurseCodeIn) {
        this.nurseCodeIn = nurseCodeIn;
    }
    
    /**
     * 获取nurseNameIn
     * 
     * @return nurseNameIn
     */
    public String getNurseNameIn() {
        return this.nurseNameIn;
    }
     
    /**
     * 设置nurseNameIn
     * 
     * @param nurseNameIn
     *          nurseNameIn
     */
    public void setNurseNameIn(String nurseNameIn) {
        this.nurseNameIn = nurseNameIn;
    }
    
    /**
     * 获取codePsnOp
     * 
     * @return codePsnOp
     */
    public String getCodePsnOp() {
        return this.codePsnOp;
    }
     
    /**
     * 设置codePsnOp
     * 
     * @param codePsnOp
     *          codePsnOp
     */
    public void setCodePsnOp(String codePsnOp) {
        this.codePsnOp = codePsnOp;
    }
    
    /**
     * 获取namePsnOp
     * 
     * @return namePsnOp
     */
    public String getNamePsnOp() {
        return this.namePsnOp;
    }
     
    /**
     * 设置namePsnOp
     * 
     * @param namePsnOp
     *          namePsnOp
     */
    public void setNamePsnOp(String namePsnOp) {
        this.namePsnOp = namePsnOp;
    }
    
    /**
     * 获取dateOp
     * 
     * @return dateOp
     */
    public String getDateOp() {
        return this.dateOp;
    }
     
    /**
     * 设置dateOp
     * 
     * @param dateOp
     *          dateOp
     */
    public void setDateOp(String dateOp) {
        this.dateOp = dateOp;
    }
    
    /**
     * 获取flagCanc
     * 
     * @return flagCanc
     */
    public Integer getFlagCanc() {
        return this.flagCanc;
    }
     
    /**
     * 设置flagCanc
     * 
     * @param flagCanc
     *          flagCanc
     */
    public void setFlagCanc(Integer flagCanc) {
        this.flagCanc = flagCanc;
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