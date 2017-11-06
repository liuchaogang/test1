package com.yonyou.entity;

/******************************************************************
** 类    名：UhAppLoopEventEntity
** 描    述：
** 创 建 者：bianj
** 创建时间：2017-07-03 11:26:30
******************************************************************/

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * (UH_APP_LOOP_EVENT)
 * 
 * @author bianj
 * @version 1.0.0 2017-07-03
 */
@Entity
@Table(name = "UH_APP_LOOP_EVENT", schema = "dbo", catalog = "MIP_DC_DEMO")
public class UhAppLoopEvent implements java.io.Serializable {
    /** 版本号 */
    private static final long serialVersionUID = 5868769515032832378L;
    
    /**  */
    @Id
    @Column(name = "PK_EVENT")
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private String pkEvent;
    
    /**  */
    @Column(name = "CODE_EVENT_TYPE")
    private String codeEventType;
    
    /**  */
    @Column(name = "NAME_EVENT_TYPE")
    private String nameEventType;
    
    /**  */
    @Column(name = "CODE_EVENT")
    private String codeEvent;
    
    /** 串联起一组相关事件的号，可以是医嘱执行号，申请单号等等。 */
    @Column(name = "CODE_EVENT_GROUP")
    private String codeEventGroup;
    
    /**  */
    @Column(name = "CODE_PATI")
    private String codePati;
    
    /** 门诊号/ */
    @Column(name = "PVCODE")
    private String pvcode;
    
    /**  */
    @Column(name = "PATINAME")
    private String patiname;
    
    /** DICT_XB */
    @Column(name = "CODE_SEX")
    private String codeSex;
    
    /**  */
    @Column(name = "NAME_SEX")
    private String nameSex;
    
    /**  */
    @Column(name = "BIRTHDAY")
    private String birthday;
    
    /** 医嘱表唯一标识 */
    @Column(name = "CODE_ORD")
    private String codeOrd;
    
    /**  */
    @Column(name = "APPOINT_NO")
    private String appointNo;
    
    /**  */
    @Column(name = "EMPI", length = 50)
    private String empi;
    
    /** 检查检验等闭环 */
    @Column(name = "CODE_RIS")
    private String codeRis;
    
    /** 检查检验等闭环 */
    @Column(name = "CODE_REQ")
    private String codeReq;
    
    /** 药品条码号、检验条码号等 */
    @Column(name = "BAR_NO")
    private String barNo;
    
    /**  */
    @Column(name = "ORD_EXE_ID")
    private String ordExeId;
    
    /**  */
    @Column(name = "CODE_OTH_NO")
    private String codeOthNo;
    
    /**  */
    @Column(name = "NAME_OTH_NO")
    private String nameOthNo;
    
    /**  */
    @Column(name = "OTH_NO")
    private String othNo;
    
    /** 事件执行时间 */
    @Column(name = "TIME_ACTUAL")
    private String timeActual;
    
    /**  */
    @Column(name = "CREAT_TIME")
    private Date creatTime;
    
    /**  */
    @Column(name = "IP_DEVICE")
    private String ipDevice;
    
    /**  */
    @Column(name = "CODE_ROLE")
    private String codeRole;
    
    /**  */
    @Column(name = "NAME_ROLE")
    private String nameRole;
    
    /** 配药部分 */
    @Column(name = "CODE_PHARM")
    private String codePharm;
    
    /**  */
    @Column(name = "NAME_PHARM")
    private String namePharm;
    
    /**  */
    @Column(name = "CODE_ROLE_OTH")
    private String codeRoleOth;
    
    /**  */
    @Column(name = "NAME_ROLE_OTH")
    private String nameRoleOth;
    
    /**  */
    @Column(name = "CODE_OTH_PSN")
    private String codeOthPsn;
    
    /**  */
    @Column(name = "NAME_OTH_PSN")
    private String nameOthPsn;
    
    /**  */
    @Column(name = "DEPT_PHY_CODE")
    private String deptPhyCode;
    
    /**  */
    @Column(name = "DEPT_PHY_NAME")
    private String deptPhyName;
    
    /**  */
    @Column(name = "REAMRK_EVENT")
    private String reamrkEvent;
    
    /**  */
    @Column(name = "EVENT_SOURCE")
    private String eventSource;
    
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
     * 获取pkEvent
     * 
     * @return pkEvent
     */
    public String getPkEvent() {
        return this.pkEvent;
    }
     
    /**
     * 设置pkEvent
     * 
     * @param pkEvent
     *          pkEvent
     */
    public void setPkEvent(String pkEvent) {
        this.pkEvent = pkEvent;
    }
    
    /**
     * 获取codeEventType
     * 
     * @return codeEventType
     */
    public String getCodeEventType() {
        return this.codeEventType;
    }
     
    /**
     * 设置codeEventType
     * 
     * @param codeEventType
     *          codeEventType
     */
    public void setCodeEventType(String codeEventType) {
        this.codeEventType = codeEventType;
    }
    
    /**
     * 获取nameEventType
     * 
     * @return nameEventType
     */
    public String getNameEventType() {
        return this.nameEventType;
    }
     
    /**
     * 设置nameEventType
     * 
     * @param nameEventType
     *          nameEventType
     */
    public void setNameEventType(String nameEventType) {
        this.nameEventType = nameEventType;
    }
    
    /**
     * 获取codeEvent
     * 
     * @return codeEvent
     */
    public String getCodeEvent() {
        return this.codeEvent;
    }
     
    /**
     * 设置codeEvent
     * 
     * @param codeEvent
     *          codeEvent
     */
    public void setCodeEvent(String codeEvent) {
        this.codeEvent = codeEvent;
    }
    
    /**
     * 获取串联起一组相关事件的号，可以是医嘱执行号，申请单号等等。
     * 
     * @return 串联起一组相关事件的号
     */
    public String getCodeEventGroup() {
        return this.codeEventGroup;
    }
     
    /**
     * 设置串联起一组相关事件的号，可以是医嘱执行号，申请单号等等。
     * 
     * @param codeEventGroup
     *          串联起一组相关事件的号，可以是医嘱执行号，申请单号等等。
     */
    public void setCodeEventGroup(String codeEventGroup) {
        this.codeEventGroup = codeEventGroup;
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
     * 获取门诊号/
     * 
     * @return 门诊号/
     */
    public String getPvcode() {
        return this.pvcode;
    }
     
    /**
     * 设置门诊号/
     * 
     * @param pvcode
     *          门诊号/
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
     * 获取DICT_XB
     * 
     * @return DICT_XB
     */
    public String getCodeSex() {
        return this.codeSex;
    }
     
    /**
     * 设置DICT_XB
     * 
     * @param codeSex
     *          DICT_XB
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
     * 获取appointNo
     * 
     * @return appointNo
     */
    public String getAppointNo() {
        return this.appointNo;
    }
     
    /**
     * 设置appointNo
     * 
     * @param appointNo
     *          appointNo
     */
    public void setAppointNo(String appointNo) {
        this.appointNo = appointNo;
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
     * 获取检查检验等闭环
     * 
     * @return 检查检验等闭环
     */
    public String getCodeRis() {
        return this.codeRis;
    }
     
    /**
     * 设置检查检验等闭环
     * 
     * @param codeRis
     *          检查检验等闭环
     */
    public void setCodeRis(String codeRis) {
        this.codeRis = codeRis;
    }
    
    /**
     * 获取检查检验等闭环
     * 
     * @return 检查检验等闭环
     */
    public String getCodeReq() {
        return this.codeReq;
    }
     
    /**
     * 设置检查检验等闭环
     * 
     * @param codeReq
     *          检查检验等闭环
     */
    public void setCodeReq(String codeReq) {
        this.codeReq = codeReq;
    }
    
    /**
     * 获取药品条码号、检验条码号等
     * 
     * @return 药品条码号、检验条码号等
     */
    public String getBarNo() {
        return this.barNo;
    }
     
    /**
     * 设置药品条码号、检验条码号等
     * 
     * @param barNo
     *          药品条码号、检验条码号等
     */
    public void setBarNo(String barNo) {
        this.barNo = barNo;
    }
    
    /**
     * 获取ordExeId
     * 
     * @return ordExeId
     */
    public String getOrdExeId() {
        return this.ordExeId;
    }
     
    /**
     * 设置ordExeId
     * 
     * @param ordExeId
     *          ordExeId
     */
    public void setOrdExeId(String ordExeId) {
        this.ordExeId = ordExeId;
    }
    
    /**
     * 获取codeOthNo
     * 
     * @return codeOthNo
     */
    public String getCodeOthNo() {
        return this.codeOthNo;
    }
     
    /**
     * 设置codeOthNo
     * 
     * @param codeOthNo
     *          codeOthNo
     */
    public void setCodeOthNo(String codeOthNo) {
        this.codeOthNo = codeOthNo;
    }
    
    /**
     * 获取nameOthNo
     * 
     * @return nameOthNo
     */
    public String getNameOthNo() {
        return this.nameOthNo;
    }
     
    /**
     * 设置nameOthNo
     * 
     * @param nameOthNo
     *          nameOthNo
     */
    public void setNameOthNo(String nameOthNo) {
        this.nameOthNo = nameOthNo;
    }
    
    /**
     * 获取othNo
     * 
     * @return othNo
     */
    public String getOthNo() {
        return this.othNo;
    }
     
    /**
     * 设置othNo
     * 
     * @param othNo
     *          othNo
     */
    public void setOthNo(String othNo) {
        this.othNo = othNo;
    }
    
    /**
     * 获取事件执行时间
     * 
     * @return 事件执行时间
     */
    public String getTimeActual() {
        return this.timeActual;
    }
     
    /**
     * 设置事件执行时间
     * 
     * @param timeActual
     *          事件执行时间
     */
    public void setTimeActual(String timeActual) {
        this.timeActual = timeActual;
    }
    
    /**
     * 获取creatTime
     * 
     * @return creatTime
     */
    public Date getCreatTime() {
        return this.creatTime;
    }
     
    /**
     * 设置creatTime
     * 
     * @param creatTime
     *          creatTime
     */
    public void setCreatTime(Date creatTime) {
        this.creatTime = creatTime;
    }
    
    /**
     * 获取ipDevice
     * 
     * @return ipDevice
     */
    public String getIpDevice() {
        return this.ipDevice;
    }
     
    /**
     * 设置ipDevice
     * 
     * @param ipDevice
     *          ipDevice
     */
    public void setIpDevice(String ipDevice) {
        this.ipDevice = ipDevice;
    }
    
    /**
     * 获取codeRole
     * 
     * @return codeRole
     */
    public String getCodeRole() {
        return this.codeRole;
    }
     
    /**
     * 设置codeRole
     * 
     * @param codeRole
     *          codeRole
     */
    public void setCodeRole(String codeRole) {
        this.codeRole = codeRole;
    }
    
    /**
     * 获取nameRole
     * 
     * @return nameRole
     */
    public String getNameRole() {
        return this.nameRole;
    }
     
    /**
     * 设置nameRole
     * 
     * @param nameRole
     *          nameRole
     */
    public void setNameRole(String nameRole) {
        this.nameRole = nameRole;
    }
    
    /**
     * 获取配药部分
     * 
     * @return 配药部分
     */
    public String getCodePharm() {
        return this.codePharm;
    }
     
    /**
     * 设置配药部分
     * 
     * @param codePharm
     *          配药部分
     */
    public void setCodePharm(String codePharm) {
        this.codePharm = codePharm;
    }
    
    /**
     * 获取namePharm
     * 
     * @return namePharm
     */
    public String getNamePharm() {
        return this.namePharm;
    }
     
    /**
     * 设置namePharm
     * 
     * @param namePharm
     *          namePharm
     */
    public void setNamePharm(String namePharm) {
        this.namePharm = namePharm;
    }
    
    /**
     * 获取codeRoleOth
     * 
     * @return codeRoleOth
     */
    public String getCodeRoleOth() {
        return this.codeRoleOth;
    }
     
    /**
     * 设置codeRoleOth
     * 
     * @param codeRoleOth
     *          codeRoleOth
     */
    public void setCodeRoleOth(String codeRoleOth) {
        this.codeRoleOth = codeRoleOth;
    }
    
    /**
     * 获取nameRoleOth
     * 
     * @return nameRoleOth
     */
    public String getNameRoleOth() {
        return this.nameRoleOth;
    }
     
    /**
     * 设置nameRoleOth
     * 
     * @param nameRoleOth
     *          nameRoleOth
     */
    public void setNameRoleOth(String nameRoleOth) {
        this.nameRoleOth = nameRoleOth;
    }
    
    /**
     * 获取codeOthPsn
     * 
     * @return codeOthPsn
     */
    public String getCodeOthPsn() {
        return this.codeOthPsn;
    }
     
    /**
     * 设置codeOthPsn
     * 
     * @param codeOthPsn
     *          codeOthPsn
     */
    public void setCodeOthPsn(String codeOthPsn) {
        this.codeOthPsn = codeOthPsn;
    }
    
    /**
     * 获取nameOthPsn
     * 
     * @return nameOthPsn
     */
    public String getNameOthPsn() {
        return this.nameOthPsn;
    }
     
    /**
     * 设置nameOthPsn
     * 
     * @param nameOthPsn
     *          nameOthPsn
     */
    public void setNameOthPsn(String nameOthPsn) {
        this.nameOthPsn = nameOthPsn;
    }
    
    /**
     * 获取deptPhyCode
     * 
     * @return deptPhyCode
     */
    public String getDeptPhyCode() {
        return this.deptPhyCode;
    }
     
    /**
     * 设置deptPhyCode
     * 
     * @param deptPhyCode
     *          deptPhyCode
     */
    public void setDeptPhyCode(String deptPhyCode) {
        this.deptPhyCode = deptPhyCode;
    }
    
    /**
     * 获取deptPhyName
     * 
     * @return deptPhyName
     */
    public String getDeptPhyName() {
        return this.deptPhyName;
    }
     
    /**
     * 设置deptPhyName
     * 
     * @param deptPhyName
     *          deptPhyName
     */
    public void setDeptPhyName(String deptPhyName) {
        this.deptPhyName = deptPhyName;
    }
    
    /**
     * 获取reamrkEvent
     * 
     * @return reamrkEvent
     */
    public String getReamrkEvent() {
        return this.reamrkEvent;
    }
     
    /**
     * 设置reamrkEvent
     * 
     * @param reamrkEvent
     *          reamrkEvent
     */
    public void setReamrkEvent(String reamrkEvent) {
        this.reamrkEvent = reamrkEvent;
    }
    
    /**
     * 获取eventSource
     * 
     * @return eventSource
     */
    public String getEventSource() {
        return this.eventSource;
    }
     
    /**
     * 设置eventSource
     * 
     * @param eventSource
     *          eventSource
     */
    public void setEventSource(String eventSource) {
        this.eventSource = eventSource;
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