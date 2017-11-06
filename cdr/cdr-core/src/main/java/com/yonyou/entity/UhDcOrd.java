package com.yonyou.entity;
/******************************************************************
** 类    名：UhDcOrdEntity
** 描    述：
** 创 建 者：bianj
** 创建时间：2017-07-04 10:43:56
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
 * (UH_DC_ORD)
 * 
 * @author bianj
 * @version 1.0.0 2017-07-04
 */
@Entity
@Table(name = "UH_DC_ORD", schema = "dbo", catalog = "MIP_DC_DEMO")
public class UhDcOrd implements java.io.Serializable {
    /** 版本号 */
    private static final long serialVersionUID = -7193094386182295038L;
    
    /**  */
    @Id
    @Column(name = "PK_DCORD")
    @GenericGenerator(name = "system-uuid", strategy = "uuid")
    @GeneratedValue(generator = "system-uuid")
    private String pkDcord;
    
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
    
    /**  */
    @Column(name = "CODE_DEPT")
    private String codeDept;
    
    /**  */
    @Column(name = "NAME_DEPT")
    private String nameDept;
    
    /**  */
    @Column(name = "CODE_AREA")
    private String codeArea;
    
    /**  */
    @Column(name = "NAME_AREA")
    private String nameArea;
    
    /**  */
    @Column(name = "BED")
    private String bed;
    
    /** 业务系统唯一标识 */
    @Column(name = "CODE_ORD")
    private String codeOrd;
    
    /** 门诊处方组号（含西药，中草药） */
    @Column(name = "CODE_PRES")
    private String codePres;
    
    /** 住院中草药和静脉注射组号 */
    @Column(name = "SETNO")
    private String setno;
    
    /** 0是，1否，主要用于一组的医嘱 */
    @Column(name = "MAINFLAG")
    private String mainflag;
    
    /** 对于有父医嘱号的，存放在这个字段。是否去掉？ */
    @Column(name = "PARENT_CODE")
    private String parentCode;
    
    /**  */
    @Column(name = "CODE_SRVTYPE")
    private String codeSrvtype;
    
    /** 1.长期医嘱；2.临时医嘱；9.其他 */
    @Column(name = "NAME_SRVTYPE")
    private String nameSrvtype;
    
    /** DICT_YZXMLX */
    @Column(name = "CODE_ORDITEM_TYPE")
    private String codeOrditemType;
    
    /**  */
    @Column(name = "NAME_ORDITEM_TYPE")
    private String nameOrditemType;
    
    /**  */
    @Column(name = "CODE_ORDITEM")
    private String codeOrditem;
    
    /**  */
    @Column(name = "NAME_ORDITEM")
    private String nameOrditem;
    
    /**  */
    @Column(name = "REORDS")
    private Integer reords;
    
    /**  */
    @Column(name = "DESC_ORD")
    private String descOrd;
    
    /** DICT_YZPC */
    @Column(name = "CODE_FREQ")
    private String codeFreq;
    
    /**  */
    @Column(name = "NAME_FREQ")
    private String nameFreq;
    
    /** DICT_YZYF */
    @Column(name = "CODE_USAGE")
    private String codeUsage;
    
    /**  */
    @Column(name = "NAME_USAGE")
    private String nameUsage;
    
    /**  */
    @Column(name = "NOTE_USAGE")
    private String noteUsage;
    
    /**  */
    @Column(name = "CODE_USAGE_REQ")
    private String codeUsageReq;
    
    /**  */
    @Column(name = "NAME_USAGE_REQ")
    private String nameUsageReq;
    
    /**  */
    @Column(name = "DAYNUM_ORD")
    private Integer daynumOrd;
    
    /**  */
    @Column(name = "DRIP_SPEED")
    private BigDecimal dripSpeed;
    
    /**  */
    @Column(name = "AMOUNT_SRV")
    private BigDecimal amountSrv;
    
    /**  */
    @Column(name = "AMOUNT_SELF")
    private BigDecimal amountSelf;
    
    /** 0是，1否 */
    @Column(name = "IS_SPARE_ORD")
    private Integer isSpareOrd;
    
    /**  */
    @Column(name = "DESC_SPARE_ORD")
    private String descSpareOrd;
    
    /** 0 开立；1 签署；2 核对；3 执行；4 医生停止；5 停止核对；6 作废
   就诊流程使用模式：
   住院流程：医嘱存盘 开立，医嘱签署 签署，医嘱护士审核 核对，医疗执行 执行，医生停止 */
    @Column(name = "CODE_ORD_STATUS")
    private String codeOrdStatus;
    
    /**  */
    @Column(name = "NAME_ORD_STATUS")
    private String nameOrdStatus;
    
    /**  */
    @Column(name = "DATE_ORDER_EFFE")
    private String dateOrderEffe;
    
    /**  */
    @Column(name = "DATE_CREATE")
    private String dateCreate;
    
    /**  */
    @Column(name = "DATE_BEGIN")
    private String dateBegin;
    
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
    
    /** 0是，1否 */
    @Column(name = "FLAG_CHK")
    private Integer flagChk;
    
    /**  */
    @Column(name = "DATE_CHK")
    private String dateChk;
    
    /**  */
    @Column(name = "CODE_PSN_CHK")
    private String codePsnChk;
    
    /**  */
    @Column(name = "NAME_PSN_CHK")
    private String namePsnChk;
    
    /** 0未执行 1已执行 3已取消 */
    @Column(name = "FLAG_EXEC")
    private Integer flagExec;
    
    /**  */
    @Column(name = "DATE_EX_PLAN")
    private String dateExPlan;
    
    /**  */
    @Column(name = "DATE_EX")
    private String dateEx;
    
    /**  */
    @Column(name = "CODE_PSN_EX")
    private String codePsnEx;
    
    /**  */
    @Column(name = "NAME_PSN_EX")
    private String namePsnEx;
    
    /**  */
    @Column(name = "CODE_DEPT_EXEC")
    private String codeDeptExec;
    
    /**  */
    @Column(name = "NAME_DEPT_EXEC")
    private String nameDeptExec;
    
    /** 0是，1否 */
    @Column(name = "FLAG_STOP_PHY")
    private Integer flagStopPhy;
    
    /**  */
    @Column(name = "DATE_END")
    private String dateEnd;
    
    /**  */
    @Column(name = "CODE_PSN_END")
    private String codePsnEnd;
    
    /**  */
    @Column(name = "NAME_PSN_END")
    private String namePsnEnd;
    
    /** 0是，1否 */
    @Column(name = "FLAG_STOP_CHK")
    private Integer flagStopChk;
    
    /**  */
    @Column(name = "CODE_PSN_STOP_CHK")
    private String codePsnStopChk;
    
    /**  */
    @Column(name = "NAME_PSN_STOP_CHK")
    private String namePsnStopChk;
    
    /**  */
    @Column(name = "FREQUENCY")
    private String frequency;
    
    /** 0是，1否 */
    @Column(name = "FLAG_BB")
    private Integer flagBb;
    
    /** 0是，1否 */
    @Column(name = "FLAG_PD_DISC")
    private Integer flagPdDisc;
    
    /** 0 正常，1 取消 */
    @Column(name = "FLAG_CANCEL")
    private Integer flagCancel;
    
    /**  */
    @Column(name = "BAK_CANCEL")
    private String bakCancel;
    
    /**  */
    @Column(name = "CODE_CANCELPESC")
    private String codeCancelpesc;
    
    /**  */
    @Column(name = "NAME_CANCELPESC")
    private String nameCancelpesc;
    
    /**  */
    @Column(name = "DATE_CANCEL")
    private Date dateCancel;
    
    /**  */
    @Column(name = "SORT_EXEC")
    private Integer sortExec;
    
    /**  */
    @Column(name = "NOTE_ORD")
    private String noteOrd;
    
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
    @Column(name = "KIND_FLAG")
    private Integer kindFlag;
    
    /**  */
    @Column(name = "FLAG_HP")
    private Integer flagHp;
    
    /**  */
    @Column(name = "ORD_ENTRUST")
    private String ordEntrust;
    
    /**  */
    @Column(name = "FLAG_HP_LIMIT")
    private Integer flagHpLimit;
    
    /**  */
    @Column(name = "FLAG_URGENT")
    private Integer flagUrgent;
    
    /**  */
    @Column(name = "CODE_PSN_REC")
    private String codePsnRec;
    
    /**  */
    @Column(name = "NAME_PSN_REC")
    private String namePsnRec;
    
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
     * 获取业务系统唯一标识
     * 
     * @return 业务系统唯一标识
     */
    public String getCodeOrd() {
        return this.codeOrd;
    }
     
    /**
     * 设置业务系统唯一标识
     * 
     * @param codeOrd
     *          业务系统唯一标识
     */
    public void setCodeOrd(String codeOrd) {
        this.codeOrd = codeOrd;
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
     * 获取住院中草药和静脉注射组号
     * 
     * @return 住院中草药和静脉注射组号
     */
    public String getSetno() {
        return this.setno;
    }
     
    /**
     * 设置住院中草药和静脉注射组号
     * 
     * @param setno
     *          住院中草药和静脉注射组号
     */
    public void setSetno(String setno) {
        this.setno = setno;
    }
    
    /**
     * 获取0是，1否，主要用于一组的医嘱
     * 
     * @return 0是
     */
    public String getMainflag() {
        return this.mainflag;
    }
     
    /**
     * 设置0是，1否，主要用于一组的医嘱
     * 
     * @param mainflag
     *          0是，1否，主要用于一组的医嘱
     */
    public void setMainflag(String mainflag) {
        this.mainflag = mainflag;
    }
    
    /**
     * 获取对于有父医嘱号的，存放在这个字段。是否去掉？
     * 
     * @return 对于有父医嘱号的
     */
    public String getParentCode() {
        return this.parentCode;
    }
     
    /**
     * 设置对于有父医嘱号的，存放在这个字段。是否去掉？
     * 
     * @param parentCode
     *          对于有父医嘱号的，存放在这个字段。是否去掉？
     */
    public void setParentCode(String parentCode) {
        this.parentCode = parentCode;
    }
    
    /**
     * 获取codeSrvtype
     * 
     * @return codeSrvtype
     */
    public String getCodeSrvtype() {
        return this.codeSrvtype;
    }
     
    /**
     * 设置codeSrvtype
     * 
     * @param codeSrvtype
     *          codeSrvtype
     */
    public void setCodeSrvtype(String codeSrvtype) {
        this.codeSrvtype = codeSrvtype;
    }
    
    /**
     * 获取1.长期医嘱；2.临时医嘱；9.其他
     * 
     * @return 1.长期医嘱；2.临时医嘱；9.其他
     */
    public String getNameSrvtype() {
        return this.nameSrvtype;
    }
     
    /**
     * 设置1.长期医嘱；2.临时医嘱；9.其他
     * 
     * @param nameSrvtype
     *          1.长期医嘱；2.临时医嘱；9.其他
     */
    public void setNameSrvtype(String nameSrvtype) {
        this.nameSrvtype = nameSrvtype;
    }
    
    /**
     * 获取DICT_YZXMLX
     * 
     * @return DICT_YZXMLX
     */
    public String getCodeOrditemType() {
        return this.codeOrditemType;
    }
     
    /**
     * 设置DICT_YZXMLX
     * 
     * @param codeOrditemType
     *          DICT_YZXMLX
     */
    public void setCodeOrditemType(String codeOrditemType) {
        this.codeOrditemType = codeOrditemType;
    }
    
    /**
     * 获取nameOrditemType
     * 
     * @return nameOrditemType
     */
    public String getNameOrditemType() {
        return this.nameOrditemType;
    }
     
    /**
     * 设置nameOrditemType
     * 
     * @param nameOrditemType
     *          nameOrditemType
     */
    public void setNameOrditemType(String nameOrditemType) {
        this.nameOrditemType = nameOrditemType;
    }
    
    /**
     * 获取codeOrditem
     * 
     * @return codeOrditem
     */
    public String getCodeOrditem() {
        return this.codeOrditem;
    }
     
    /**
     * 设置codeOrditem
     * 
     * @param codeOrditem
     *          codeOrditem
     */
    public void setCodeOrditem(String codeOrditem) {
        this.codeOrditem = codeOrditem;
    }
    
    /**
     * 获取nameOrditem
     * 
     * @return nameOrditem
     */
    public String getNameOrditem() {
        return this.nameOrditem;
    }
     
    /**
     * 设置nameOrditem
     * 
     * @param nameOrditem
     *          nameOrditem
     */
    public void setNameOrditem(String nameOrditem) {
        this.nameOrditem = nameOrditem;
    }
    
    /**
     * 获取reords
     * 
     * @return reords
     */
    public Integer getReords() {
        return this.reords;
    }
     
    /**
     * 设置reords
     * 
     * @param reords
     *          reords
     */
    public void setReords(Integer reords) {
        this.reords = reords;
    }
    
    /**
     * 获取descOrd
     * 
     * @return descOrd
     */
    public String getDescOrd() {
        return this.descOrd;
    }
     
    /**
     * 设置descOrd
     * 
     * @param descOrd
     *          descOrd
     */
    public void setDescOrd(String descOrd) {
        this.descOrd = descOrd;
    }
    
    /**
     * 获取DICT_YZPC
     * 
     * @return DICT_YZPC
     */
    public String getCodeFreq() {
        return this.codeFreq;
    }
     
    /**
     * 设置DICT_YZPC
     * 
     * @param codeFreq
     *          DICT_YZPC
     */
    public void setCodeFreq(String codeFreq) {
        this.codeFreq = codeFreq;
    }
    
    /**
     * 获取nameFreq
     * 
     * @return nameFreq
     */
    public String getNameFreq() {
        return this.nameFreq;
    }
     
    /**
     * 设置nameFreq
     * 
     * @param nameFreq
     *          nameFreq
     */
    public void setNameFreq(String nameFreq) {
        this.nameFreq = nameFreq;
    }
    
    /**
     * 获取DICT_YZYF
     * 
     * @return DICT_YZYF
     */
    public String getCodeUsage() {
        return this.codeUsage;
    }
     
    /**
     * 设置DICT_YZYF
     * 
     * @param codeUsage
     *          DICT_YZYF
     */
    public void setCodeUsage(String codeUsage) {
        this.codeUsage = codeUsage;
    }
    
    /**
     * 获取nameUsage
     * 
     * @return nameUsage
     */
    public String getNameUsage() {
        return this.nameUsage;
    }
     
    /**
     * 设置nameUsage
     * 
     * @param nameUsage
     *          nameUsage
     */
    public void setNameUsage(String nameUsage) {
        this.nameUsage = nameUsage;
    }
    
    /**
     * 获取noteUsage
     * 
     * @return noteUsage
     */
    public String getNoteUsage() {
        return this.noteUsage;
    }
     
    /**
     * 设置noteUsage
     * 
     * @param noteUsage
     *          noteUsage
     */
    public void setNoteUsage(String noteUsage) {
        this.noteUsage = noteUsage;
    }
    
    /**
     * 获取codeUsageReq
     * 
     * @return codeUsageReq
     */
    public String getCodeUsageReq() {
        return this.codeUsageReq;
    }
     
    /**
     * 设置codeUsageReq
     * 
     * @param codeUsageReq
     *          codeUsageReq
     */
    public void setCodeUsageReq(String codeUsageReq) {
        this.codeUsageReq = codeUsageReq;
    }
    
    /**
     * 获取nameUsageReq
     * 
     * @return nameUsageReq
     */
    public String getNameUsageReq() {
        return this.nameUsageReq;
    }
     
    /**
     * 设置nameUsageReq
     * 
     * @param nameUsageReq
     *          nameUsageReq
     */
    public void setNameUsageReq(String nameUsageReq) {
        this.nameUsageReq = nameUsageReq;
    }
    
    /**
     * 获取daynumOrd
     * 
     * @return daynumOrd
     */
    public Integer getDaynumOrd() {
        return this.daynumOrd;
    }
     
    /**
     * 设置daynumOrd
     * 
     * @param daynumOrd
     *          daynumOrd
     */
    public void setDaynumOrd(Integer daynumOrd) {
        this.daynumOrd = daynumOrd;
    }
    
    /**
     * 获取dripSpeed
     * 
     * @return dripSpeed
     */
    public BigDecimal getDripSpeed() {
        return this.dripSpeed;
    }
     
    /**
     * 设置dripSpeed
     * 
     * @param dripSpeed
     *          dripSpeed
     */
    public void setDripSpeed(BigDecimal dripSpeed) {
        this.dripSpeed = dripSpeed;
    }
    
    /**
     * 获取amountSrv
     * 
     * @return amountSrv
     */
    public BigDecimal getAmountSrv() {
        return this.amountSrv;
    }
     
    /**
     * 设置amountSrv
     * 
     * @param amountSrv
     *          amountSrv
     */
    public void setAmountSrv(BigDecimal amountSrv) {
        this.amountSrv = amountSrv;
    }
    
    /**
     * 获取amountSelf
     * 
     * @return amountSelf
     */
    public BigDecimal getAmountSelf() {
        return this.amountSelf;
    }
     
    /**
     * 设置amountSelf
     * 
     * @param amountSelf
     *          amountSelf
     */
    public void setAmountSelf(BigDecimal amountSelf) {
        this.amountSelf = amountSelf;
    }
    
    /**
     * 获取0是，1否
     * 
     * @return 0是
     */
    public Integer getIsSpareOrd() {
        return this.isSpareOrd;
    }
     
    /**
     * 设置0是，1否
     * 
     * @param isSpareOrd
     *          0是，1否
     */
    public void setIsSpareOrd(Integer isSpareOrd) {
        this.isSpareOrd = isSpareOrd;
    }
    
    /**
     * 获取descSpareOrd
     * 
     * @return descSpareOrd
     */
    public String getDescSpareOrd() {
        return this.descSpareOrd;
    }
     
    /**
     * 设置descSpareOrd
     * 
     * @param descSpareOrd
     *          descSpareOrd
     */
    public void setDescSpareOrd(String descSpareOrd) {
        this.descSpareOrd = descSpareOrd;
    }
    
    /**
     * 获取0 开立；1 签署；2 核对；3 执行；4 医生停止；5 停止核对；6 作废
   就诊流程使用模式：
   住院流程：医嘱存盘 开立，医嘱签署 签署，医嘱护士审核 核对，医疗执行 执行，医生停止
     * 
     * @return 0 开立；1 签署；2 核对；3 执行；4 医生停止；5 停止核对；6 作废
   就诊流程使用模式：
   住院流程：医嘱存盘 开立
     */
    public String getCodeOrdStatus() {
        return this.codeOrdStatus;
    }
     
    /**
     * 设置0 开立；1 签署；2 核对；3 执行；4 医生停止；5 停止核对；6 作废
   就诊流程使用模式：
   住院流程：医嘱存盘 开立，医嘱签署 签署，医嘱护士审核 核对，医疗执行 执行，医生停止
     * 
     * @param codeOrdStatus
     *          0 开立；1 签署；2 核对；3 执行；4 医生停止；5 停止核对；6 作废
   就诊流程使用模式：
   住院流程：医嘱存盘 开立，医嘱签署 签署，医嘱护士审核 核对，医疗执行 执行，医生停止
     */
    public void setCodeOrdStatus(String codeOrdStatus) {
        this.codeOrdStatus = codeOrdStatus;
    }
    
    /**
     * 获取nameOrdStatus
     * 
     * @return nameOrdStatus
     */
    public String getNameOrdStatus() {
        return this.nameOrdStatus;
    }
     
    /**
     * 设置nameOrdStatus
     * 
     * @param nameOrdStatus
     *          nameOrdStatus
     */
    public void setNameOrdStatus(String nameOrdStatus) {
        this.nameOrdStatus = nameOrdStatus;
    }
    
    /**
     * 获取dateOrderEffe
     * 
     * @return dateOrderEffe
     */
    public String getDateOrderEffe() {
        return this.dateOrderEffe;
    }
     
    /**
     * 设置dateOrderEffe
     * 
     * @param dateOrderEffe
     *          dateOrderEffe
     */
    public void setDateOrderEffe(String dateOrderEffe) {
        this.dateOrderEffe = dateOrderEffe;
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
     * 获取dateBegin
     * 
     * @return dateBegin
     */
    public String getDateBegin() {
        return this.dateBegin;
    }
     
    /**
     * 设置dateBegin
     * 
     * @param dateBegin
     *          dateBegin
     */
    public void setDateBegin(String dateBegin) {
        this.dateBegin = dateBegin;
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
     * 获取0是，1否
     * 
     * @return 0是
     */
    public Integer getFlagChk() {
        return this.flagChk;
    }
     
    /**
     * 设置0是，1否
     * 
     * @param flagChk
     *          0是，1否
     */
    public void setFlagChk(Integer flagChk) {
        this.flagChk = flagChk;
    }
    
    /**
     * 获取dateChk
     * 
     * @return dateChk
     */
    public String getDateChk() {
        return this.dateChk;
    }
     
    /**
     * 设置dateChk
     * 
     * @param dateChk
     *          dateChk
     */
    public void setDateChk(String dateChk) {
        this.dateChk = dateChk;
    }
    
    /**
     * 获取codePsnChk
     * 
     * @return codePsnChk
     */
    public String getCodePsnChk() {
        return this.codePsnChk;
    }
     
    /**
     * 设置codePsnChk
     * 
     * @param codePsnChk
     *          codePsnChk
     */
    public void setCodePsnChk(String codePsnChk) {
        this.codePsnChk = codePsnChk;
    }
    
    /**
     * 获取namePsnChk
     * 
     * @return namePsnChk
     */
    public String getNamePsnChk() {
        return this.namePsnChk;
    }
     
    /**
     * 设置namePsnChk
     * 
     * @param namePsnChk
     *          namePsnChk
     */
    public void setNamePsnChk(String namePsnChk) {
        this.namePsnChk = namePsnChk;
    }
    
    /**
     * 获取0未执行 1已执行 3已取消
     * 
     * @return 0未执行 1已执行 3已取消
     */
    public Integer getFlagExec() {
        return this.flagExec;
    }
     
    /**
     * 设置0未执行 1已执行 3已取消
     * 
     * @param flagExec
     *          0未执行 1已执行 3已取消
     */
    public void setFlagExec(Integer flagExec) {
        this.flagExec = flagExec;
    }
    
    /**
     * 获取dateExPlan
     * 
     * @return dateExPlan
     */
    public String getDateExPlan() {
        return this.dateExPlan;
    }
     
    /**
     * 设置dateExPlan
     * 
     * @param dateExPlan
     *          dateExPlan
     */
    public void setDateExPlan(String dateExPlan) {
        this.dateExPlan = dateExPlan;
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
     * 获取codeDeptExec
     * 
     * @return codeDeptExec
     */
    public String getCodeDeptExec() {
        return this.codeDeptExec;
    }
     
    /**
     * 设置codeDeptExec
     * 
     * @param codeDeptExec
     *          codeDeptExec
     */
    public void setCodeDeptExec(String codeDeptExec) {
        this.codeDeptExec = codeDeptExec;
    }
    
    /**
     * 获取nameDeptExec
     * 
     * @return nameDeptExec
     */
    public String getNameDeptExec() {
        return this.nameDeptExec;
    }
     
    /**
     * 设置nameDeptExec
     * 
     * @param nameDeptExec
     *          nameDeptExec
     */
    public void setNameDeptExec(String nameDeptExec) {
        this.nameDeptExec = nameDeptExec;
    }
    
    /**
     * 获取0是，1否
     * 
     * @return 0是
     */
    public Integer getFlagStopPhy() {
        return this.flagStopPhy;
    }
     
    /**
     * 设置0是，1否
     * 
     * @param flagStopPhy
     *          0是，1否
     */
    public void setFlagStopPhy(Integer flagStopPhy) {
        this.flagStopPhy = flagStopPhy;
    }
    
    /**
     * 获取dateEnd
     * 
     * @return dateEnd
     */
    public String getDateEnd() {
        return this.dateEnd;
    }
     
    /**
     * 设置dateEnd
     * 
     * @param dateEnd
     *          dateEnd
     */
    public void setDateEnd(String dateEnd) {
        this.dateEnd = dateEnd;
    }
    
    /**
     * 获取codePsnEnd
     * 
     * @return codePsnEnd
     */
    public String getCodePsnEnd() {
        return this.codePsnEnd;
    }
     
    /**
     * 设置codePsnEnd
     * 
     * @param codePsnEnd
     *          codePsnEnd
     */
    public void setCodePsnEnd(String codePsnEnd) {
        this.codePsnEnd = codePsnEnd;
    }
    
    /**
     * 获取namePsnEnd
     * 
     * @return namePsnEnd
     */
    public String getNamePsnEnd() {
        return this.namePsnEnd;
    }
     
    /**
     * 设置namePsnEnd
     * 
     * @param namePsnEnd
     *          namePsnEnd
     */
    public void setNamePsnEnd(String namePsnEnd) {
        this.namePsnEnd = namePsnEnd;
    }
    
    /**
     * 获取0是，1否
     * 
     * @return 0是
     */
    public Integer getFlagStopChk() {
        return this.flagStopChk;
    }
     
    /**
     * 设置0是，1否
     * 
     * @param flagStopChk
     *          0是，1否
     */
    public void setFlagStopChk(Integer flagStopChk) {
        this.flagStopChk = flagStopChk;
    }
    
    /**
     * 获取codePsnStopChk
     * 
     * @return codePsnStopChk
     */
    public String getCodePsnStopChk() {
        return this.codePsnStopChk;
    }
     
    /**
     * 设置codePsnStopChk
     * 
     * @param codePsnStopChk
     *          codePsnStopChk
     */
    public void setCodePsnStopChk(String codePsnStopChk) {
        this.codePsnStopChk = codePsnStopChk;
    }
    
    /**
     * 获取namePsnStopChk
     * 
     * @return namePsnStopChk
     */
    public String getNamePsnStopChk() {
        return this.namePsnStopChk;
    }
     
    /**
     * 设置namePsnStopChk
     * 
     * @param namePsnStopChk
     *          namePsnStopChk
     */
    public void setNamePsnStopChk(String namePsnStopChk) {
        this.namePsnStopChk = namePsnStopChk;
    }
    
    /**
     * 获取frequency
     * 
     * @return frequency
     */
    public String getFrequency() {
        return this.frequency;
    }
     
    /**
     * 设置frequency
     * 
     * @param frequency
     *          frequency
     */
    public void setFrequency(String frequency) {
        this.frequency = frequency;
    }
    
    /**
     * 获取0是，1否
     * 
     * @return 0是
     */
    public Integer getFlagBb() {
        return this.flagBb;
    }
     
    /**
     * 设置0是，1否
     * 
     * @param flagBb
     *          0是，1否
     */
    public void setFlagBb(Integer flagBb) {
        this.flagBb = flagBb;
    }
    
    /**
     * 获取0是，1否
     * 
     * @return 0是
     */
    public Integer getFlagPdDisc() {
        return this.flagPdDisc;
    }
     
    /**
     * 设置0是，1否
     * 
     * @param flagPdDisc
     *          0是，1否
     */
    public void setFlagPdDisc(Integer flagPdDisc) {
        this.flagPdDisc = flagPdDisc;
    }
    
    /**
     * 获取0 正常，1 取消
     * 
     * @return 0 正常
     */
    public Integer getFlagCancel() {
        return this.flagCancel;
    }
     
    /**
     * 设置0 正常，1 取消
     * 
     * @param flagCancel
     *          0 正常，1 取消
     */
    public void setFlagCancel(Integer flagCancel) {
        this.flagCancel = flagCancel;
    }
    
    /**
     * 获取bakCancel
     * 
     * @return bakCancel
     */
    public String getBakCancel() {
        return this.bakCancel;
    }
     
    /**
     * 设置bakCancel
     * 
     * @param bakCancel
     *          bakCancel
     */
    public void setBakCancel(String bakCancel) {
        this.bakCancel = bakCancel;
    }
    
    /**
     * 获取codeCancelpesc
     * 
     * @return codeCancelpesc
     */
    public String getCodeCancelpesc() {
        return this.codeCancelpesc;
    }
     
    /**
     * 设置codeCancelpesc
     * 
     * @param codeCancelpesc
     *          codeCancelpesc
     */
    public void setCodeCancelpesc(String codeCancelpesc) {
        this.codeCancelpesc = codeCancelpesc;
    }
    
    /**
     * 获取nameCancelpesc
     * 
     * @return nameCancelpesc
     */
    public String getNameCancelpesc() {
        return this.nameCancelpesc;
    }
     
    /**
     * 设置nameCancelpesc
     * 
     * @param nameCancelpesc
     *          nameCancelpesc
     */
    public void setNameCancelpesc(String nameCancelpesc) {
        this.nameCancelpesc = nameCancelpesc;
    }
    
    /**
     * 获取dateCancel
     * 
     * @return dateCancel
     */
    public Date getDateCancel() {
        return this.dateCancel;
    }
     
    /**
     * 设置dateCancel
     * 
     * @param dateCancel
     *          dateCancel
     */
    public void setDateCancel(Date dateCancel) {
        this.dateCancel = dateCancel;
    }
    
    /**
     * 获取sortExec
     * 
     * @return sortExec
     */
    public Integer getSortExec() {
        return this.sortExec;
    }
     
    /**
     * 设置sortExec
     * 
     * @param sortExec
     *          sortExec
     */
    public void setSortExec(Integer sortExec) {
        this.sortExec = sortExec;
    }
    
    /**
     * 获取noteOrd
     * 
     * @return noteOrd
     */
    public String getNoteOrd() {
        return this.noteOrd;
    }
     
    /**
     * 设置noteOrd
     * 
     * @param noteOrd
     *          noteOrd
     */
    public void setNoteOrd(String noteOrd) {
        this.noteOrd = noteOrd;
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
     * 获取kindFlag
     * 
     * @return kindFlag
     */
    public Integer getKindFlag() {
        return this.kindFlag;
    }
     
    /**
     * 设置kindFlag
     * 
     * @param kindFlag
     *          kindFlag
     */
    public void setKindFlag(Integer kindFlag) {
        this.kindFlag = kindFlag;
    }
    
    /**
     * 获取flagHp
     * 
     * @return flagHp
     */
    public Integer getFlagHp() {
        return this.flagHp;
    }
     
    /**
     * 设置flagHp
     * 
     * @param flagHp
     *          flagHp
     */
    public void setFlagHp(Integer flagHp) {
        this.flagHp = flagHp;
    }
    
    /**
     * 获取ordEntrust
     * 
     * @return ordEntrust
     */
    public String getOrdEntrust() {
        return this.ordEntrust;
    }
     
    /**
     * 设置ordEntrust
     * 
     * @param ordEntrust
     *          ordEntrust
     */
    public void setOrdEntrust(String ordEntrust) {
        this.ordEntrust = ordEntrust;
    }
    
    /**
     * 获取flagHpLimit
     * 
     * @return flagHpLimit
     */
    public Integer getFlagHpLimit() {
        return this.flagHpLimit;
    }
     
    /**
     * 设置flagHpLimit
     * 
     * @param flagHpLimit
     *          flagHpLimit
     */
    public void setFlagHpLimit(Integer flagHpLimit) {
        this.flagHpLimit = flagHpLimit;
    }
    
    /**
     * 获取flagUrgent
     * 
     * @return flagUrgent
     */
    public Integer getFlagUrgent() {
        return this.flagUrgent;
    }
     
    /**
     * 设置flagUrgent
     * 
     * @param flagUrgent
     *          flagUrgent
     */
    public void setFlagUrgent(Integer flagUrgent) {
        this.flagUrgent = flagUrgent;
    }
    
    /**
     * 获取codePsnRec
     * 
     * @return codePsnRec
     */
    public String getCodePsnRec() {
        return this.codePsnRec;
    }
     
    /**
     * 设置codePsnRec
     * 
     * @param codePsnRec
     *          codePsnRec
     */
    public void setCodePsnRec(String codePsnRec) {
        this.codePsnRec = codePsnRec;
    }
    
    /**
     * 获取namePsnRec
     * 
     * @return namePsnRec
     */
    public String getNamePsnRec() {
        return this.namePsnRec;
    }
     
    /**
     * 设置namePsnRec
     * 
     * @param namePsnRec
     *          namePsnRec
     */
    public void setNamePsnRec(String namePsnRec) {
        this.namePsnRec = namePsnRec;
    }
}