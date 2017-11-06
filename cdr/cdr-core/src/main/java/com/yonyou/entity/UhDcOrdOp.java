package com.yonyou.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

 
@Entity
@Table(name = "UH_DC_ORD_OP", schema = "dbo", catalog = "MIP_DC_DEMO")
public class UhDcOrdOp{
   
    
    @Id
    @Column(name = "PK_OPREQ" )
    @GenericGenerator(name = "system-uuid", strategy = "uuid")
    @GeneratedValue(generator = "system-uuid")
    private String pkOpreq;
    
    /**医嘱主键*/
    @Column(name = "PK_DCORD" )
    private String pkDcord;
    
    /**所属集团*/
    @Column(name = "CODE_GROUP" )
    private String codeGroup;
    
    /**所属机构*/
    @Column(name = "CODE_ORG" )
    private String codeOrg;
    
    /**医嘱编码*/
    @Column(name = "CODE_ORD" )
    private String codeOrd;
    
    /**患者主索引*/
    @Column(name = "EMPI" )
    private String empi;
    
    /**患者编码*/
    @Column(name = "CODE_PATI" )
    private String codePati;
    
    /**患者姓名*/
    @Column(name = "PATINAME" )
    private String patiname;
    
    /**患者性别编码*/
    @Column(name = "CODE_SEX" )
    private String codeSex;
    
    /**患者性别名称*/
    @Column(name = "NAME_SEX" )
    private String nameSex;
    
    /**出生日期*/
    @Column(name = "BIRTHDAY" )
    private String birthday;
    
    /**现住址*/
    @Column(name = "ADDR_PRE" )
    private String addrPre;
    
    /**联系电话*/
    @Column(name = "TELENO_PRE" )
    private String telenoPre;
    
    /**手术申请单号*/
    @Column(name = "CODE_REQ" )
    private String codeReq;
    
    /**术前诊断编码*/
    @Column(name = "CODE_DIAG_PRE" )
    private String codeDiagPre;
    
    /**术前诊断名称*/
    @Column(name = "NAME_DIAG_PRE" )
    private String nameDiagPre;
    
    /**术前诊断描述*/
    @Column(name = "DESC_DIAG" )
    private String descDiag;
    
    /**手术级别编码 */
    @Column(name = "CODE_OPLEVEL" )
    private String codeOplevel;
    
    /**手术级别名称*/
    @Column(name = "NAME_OPLEVEL" )
    private String nameOplevel;
    
    /**拟行手术编码*/
    @Column(name = "CODE_OPER" )
    private String codeOper;
    
    /**拟行手术名称  */
    @Column(name = "NAME_OPER" )
    private String nameOper;
    
    /**拟行手术描述*/
    @Column(name = "DESC_OPER" )
    private String descOper;
    
    /**拟行麻醉方法*/
    @Column(name = "CODE_ANAE" )
    private String codeAnae;
    
    /**拟行麻醉方法名称*/
    @Column(name = "NAME_ANAE" )
    private String nameAnae;
    
    /**无菌程度编码*/
    @Column(name = "CODE_ASEPSIS" )
    private String codeAsepsis;
    
    /**无菌程度名称*/
    @Column(name = "NAME_ASEPSIS" )
    private String nameAsepsis;
    
    /**手术目标部位编码*/
    @Column(name = "CODE_BODYPART_OP" )
    private String codeBodypartOp;
    
    /**手术目标部位名称*/
    @Column(name = "NAME_BODYPART_OP" )
    private String nameBodypartOp;
    
    /**  */
    @Column(name = "DATE_OP_BEGIN" )
    private String dateOpBegin;
    
    /**  */
    @Column(name = "DATE_OP_END" )
    private String dateOpEnd;
    
    /**  */
    @Column(name = "CODE_PHY_MAIN" )
    private String codePhyMain;
    
    /**  */
    @Column(name = "NAME_PHY_MAIN" )
    private String namePhyMain;
    
    /**  */
    @Column(name = "CODE_APT" )
    private String codeApt;
    
    /**  */
    @Column(name = "NAME_APT" )
    private String nameApt;
    
    /**  */
    @Column(name = "DATE_COMFIRM" )
    private String dateComfirm;
    
    /**  */
    @Column(name = "CODE_ROOM" )
    private String codeRoom;
    
    /**  */
    @Column(name = "NAME_ROOM" )
    private String nameRoom;
    
    /**  */
    @Column(name = "TICKETNO" )
    private Integer ticketno;
    
    /**  */
    @Column(name = "EST_BEGIN_TIME" )
    private String estBeginTime;
    
    /**  */
    @Column(name = "FLAG_URGENT" )
    private Integer flagUrgent;
    
    /**  */
    @Column(name = "HBSAG" )
    private Integer hbsag;
    
    /**  */
    @Column(name = "HEPATITIS" )
    private Integer hepatitis;
    
    /**  */
    @Column(name = "HEPATITIS_C" )
    private Integer hepatitisC;
    
    /**  */
    @Column(name = "SYPHILIS" )
    private Integer syphilis;
   
    /**  */
    @Column(name = "AIDS")
    private Integer aids;
    
    /**  */
    @Column(name = "OP_BODY_CODE" )
    private String opBodyCode;
    
    /**  */
    @Column(name = "OP_BODY_NAME" )
    private String opBodyName;
    
    /**  */
    @Column(name = "OP_REQIRE_CODE" )
    private String opReqireCode;
    
    /**  */
    @Column(name = "OP_REQIRE_NAME" )
    private String opReqireName;
    
    /**  */
    @Column(name = "OP_MDR" )
    private String opMdr;
    
    /**  */
    @Column(name = "INCISION_NAME" )
    private String incisionName;
    
    /**  */
    @Column(name = "CODE_PSN_REQ" )
    private String codePsnReq;
    
    /**  */
    @Column(name = "NAME_PSN_REQ" )
    private String namePsnReq;
    
    /**  */
    @Column(name = "DATE_REQ" )
    private String dateReq;
    
    /**  */
    @Column(name = "NOTE" )
    private String note;
    
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
     * 获取pkOpreq
     * 
     * @return pkOpreq
     */
    public String getPkOpreq() {
        return this.pkOpreq;
    }
     
    /**
     * 设置pkOpreq
     * 
     * @param pkOpreq
     *          pkOpreq
     */
    public void setPkOpreq(String pkOpreq) {
        this.pkOpreq = pkOpreq;
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
     * 获取codeDiagPre
     * 
     * @return codeDiagPre
     */
    public String getCodeDiagPre() {
        return this.codeDiagPre;
    }
     
    /**
     * 设置codeDiagPre
     * 
     * @param codeDiagPre
     *          codeDiagPre
     */
    public void setCodeDiagPre(String codeDiagPre) {
        this.codeDiagPre = codeDiagPre;
    }
    
    /**
     * 获取nameDiagPre
     * 
     * @return nameDiagPre
     */
    public String getNameDiagPre() {
        return this.nameDiagPre;
    }
     
    /**
     * 设置nameDiagPre
     * 
     * @param nameDiagPre
     *          nameDiagPre
     */
    public void setNameDiagPre(String nameDiagPre) {
        this.nameDiagPre = nameDiagPre;
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
     * 获取codeOplevel
     * 
     * @return codeOplevel
     */
    public String getCodeOplevel() {
        return this.codeOplevel;
    }
     
    /**
     * 设置codeOplevel
     * 
     * @param codeOplevel
     *          codeOplevel
     */
    public void setCodeOplevel(String codeOplevel) {
        this.codeOplevel = codeOplevel;
    }
    
    /**
     * 获取nameOplevel
     * 
     * @return nameOplevel
     */
    public String getNameOplevel() {
        return this.nameOplevel;
    }
     
    /**
     * 设置nameOplevel
     * 
     * @param nameOplevel
     *          nameOplevel
     */
    public void setNameOplevel(String nameOplevel) {
        this.nameOplevel = nameOplevel;
    }
    
    /**
     * 获取codeOper
     * 
     * @return codeOper
     */
    public String getCodeOper() {
        return this.codeOper;
    }
     
    /**
     * 设置codeOper
     * 
     * @param codeOper
     *          codeOper
     */
    public void setCodeOper(String codeOper) {
        this.codeOper = codeOper;
    }
    
    /**
     * 获取nameOper
     * 
     * @return nameOper
     */
    public String getNameOper() {
        return this.nameOper;
    }
     
    /**
     * 设置nameOper
     * 
     * @param nameOper
     *          nameOper
     */
    public void setNameOper(String nameOper) {
        this.nameOper = nameOper;
    }
    
    /**
     * 获取descOper
     * 
     * @return descOper
     */
    public String getDescOper() {
        return this.descOper;
    }
     
    /**
     * 设置descOper
     * 
     * @param descOper
     *          descOper
     */
    public void setDescOper(String descOper) {
        this.descOper = descOper;
    }
    
    /**
     * 获取codeAnae
     * 
     * @return codeAnae
     */
    public String getCodeAnae() {
        return this.codeAnae;
    }
     
    /**
     * 设置codeAnae
     * 
     * @param codeAnae
     *          codeAnae
     */
    public void setCodeAnae(String codeAnae) {
        this.codeAnae = codeAnae;
    }
    
    /**
     * 获取nameAnae
     * 
     * @return nameAnae
     */
    public String getNameAnae() {
        return this.nameAnae;
    }
     
    /**
     * 设置nameAnae
     * 
     * @param nameAnae
     *          nameAnae
     */
    public void setNameAnae(String nameAnae) {
        this.nameAnae = nameAnae;
    }
    
    /**
     * 获取codeAsepsis
     * 
     * @return codeAsepsis
     */
    public String getCodeAsepsis() {
        return this.codeAsepsis;
    }
     
    /**
     * 设置codeAsepsis
     * 
     * @param codeAsepsis
     *          codeAsepsis
     */
    public void setCodeAsepsis(String codeAsepsis) {
        this.codeAsepsis = codeAsepsis;
    }
    
    /**
     * 获取nameAsepsis
     * 
     * @return nameAsepsis
     */
    public String getNameAsepsis() {
        return this.nameAsepsis;
    }
     
    /**
     * 设置nameAsepsis
     * 
     * @param nameAsepsis
     *          nameAsepsis
     */
    public void setNameAsepsis(String nameAsepsis) {
        this.nameAsepsis = nameAsepsis;
    }
    
    /**
     * 获取codeBodypartOp
     * 
     * @return codeBodypartOp
     */
    public String getCodeBodypartOp() {
        return this.codeBodypartOp;
    }
     
    /**
     * 设置codeBodypartOp
     * 
     * @param codeBodypartOp
     *          codeBodypartOp
     */
    public void setCodeBodypartOp(String codeBodypartOp) {
        this.codeBodypartOp = codeBodypartOp;
    }
    
    /**
     * 获取nameBodypartOp
     * 
     * @return nameBodypartOp
     */
    public String getNameBodypartOp() {
        return this.nameBodypartOp;
    }
     
    /**
     * 设置nameBodypartOp
     * 
     * @param nameBodypartOp
     *          nameBodypartOp
     */
    public void setNameBodypartOp(String nameBodypartOp) {
        this.nameBodypartOp = nameBodypartOp;
    }
    
    /**
     * 获取dateOpBegin
     * 
     * @return dateOpBegin
     */
    public String getDateOpBegin() {
        return this.dateOpBegin;
    }
     
    /**
     * 设置dateOpBegin
     * 
     * @param dateOpBegin
     *          dateOpBegin
     */
    public void setDateOpBegin(String dateOpBegin) {
        this.dateOpBegin = dateOpBegin;
    }
    
    /**
     * 获取dateOpEnd
     * 
     * @return dateOpEnd
     */
    public String getDateOpEnd() {
        return this.dateOpEnd;
    }
     
    /**
     * 设置dateOpEnd
     * 
     * @param dateOpEnd
     *          dateOpEnd
     */
    public void setDateOpEnd(String dateOpEnd) {
        this.dateOpEnd = dateOpEnd;
    }
    
    /**
     * 获取codePhyMain
     * 
     * @return codePhyMain
     */
    public String getCodePhyMain() {
        return this.codePhyMain;
    }
     
    /**
     * 设置codePhyMain
     * 
     * @param codePhyMain
     *          codePhyMain
     */
    public void setCodePhyMain(String codePhyMain) {
        this.codePhyMain = codePhyMain;
    }
    
    /**
     * 获取namePhyMain
     * 
     * @return namePhyMain
     */
    public String getNamePhyMain() {
        return this.namePhyMain;
    }
     
    /**
     * 设置namePhyMain
     * 
     * @param namePhyMain
     *          namePhyMain
     */
    public void setNamePhyMain(String namePhyMain) {
        this.namePhyMain = namePhyMain;
    }
    
    /**
     * 获取codeApt
     * 
     * @return codeApt
     */
    public String getCodeApt() {
        return this.codeApt;
    }
     
    /**
     * 设置codeApt
     * 
     * @param codeApt
     *          codeApt
     */
    public void setCodeApt(String codeApt) {
        this.codeApt = codeApt;
    }
    
    /**
     * 获取nameApt
     * 
     * @return nameApt
     */
    public String getNameApt() {
        return this.nameApt;
    }
     
    /**
     * 设置nameApt
     * 
     * @param nameApt
     *          nameApt
     */
    public void setNameApt(String nameApt) {
        this.nameApt = nameApt;
    }
    
    /**
     * 获取dateComfirm
     * 
     * @return dateComfirm
     */
    public String getDateComfirm() {
        return this.dateComfirm;
    }
     
    /**
     * 设置dateComfirm
     * 
     * @param dateComfirm
     *          dateComfirm
     */
    public void setDateComfirm(String dateComfirm) {
        this.dateComfirm = dateComfirm;
    }
    
    /**
     * 获取codeRoom
     * 
     * @return codeRoom
     */
    public String getCodeRoom() {
        return this.codeRoom;
    }
     
    /**
     * 设置codeRoom
     * 
     * @param codeRoom
     *          codeRoom
     */
    public void setCodeRoom(String codeRoom) {
        this.codeRoom = codeRoom;
    }
    
    /**
     * 获取nameRoom
     * 
     * @return nameRoom
     */
    public String getNameRoom() {
        return this.nameRoom;
    }
     
    /**
     * 设置nameRoom
     * 
     * @param nameRoom
     *          nameRoom
     */
    public void setNameRoom(String nameRoom) {
        this.nameRoom = nameRoom;
    }
    
    /**
     * 获取ticketno
     * 
     * @return ticketno
     */
    public Integer getTicketno() {
        return this.ticketno;
    }
     
    /**
     * 设置ticketno
     * 
     * @param ticketno
     *          ticketno
     */
    public void setTicketno(Integer ticketno) {
        this.ticketno = ticketno;
    }
    
    /**
     * 获取estBeginTime
     * 
     * @return estBeginTime
     */
    public String getEstBeginTime() {
        return this.estBeginTime;
    }
     
    /**
     * 设置estBeginTime
     * 
     * @param estBeginTime
     *          estBeginTime
     */
    public void setEstBeginTime(String estBeginTime) {
        this.estBeginTime = estBeginTime;
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
     * 获取hbsag
     * 
     * @return hbsag
     */
    public Integer getHbsag() {
        return this.hbsag;
    }
     
    /**
     * 设置hbsag
     * 
     * @param hbsag
     *          hbsag
     */
    public void setHbsag(Integer hbsag) {
        this.hbsag = hbsag;
    }
    
    /**
     * 获取hepatitis
     * 
     * @return hepatitis
     */
    public Integer getHepatitis() {
        return this.hepatitis;
    }
     
    /**
     * 设置hepatitis
     * 
     * @param hepatitis
     *          hepatitis
     */
    public void setHepatitis(Integer hepatitis) {
        this.hepatitis = hepatitis;
    }
    
    /**
     * 获取hepatitisC
     * 
     * @return hepatitisC
     */
    public Integer getHepatitisC() {
        return this.hepatitisC;
    }
     
    /**
     * 设置hepatitisC
     * 
     * @param hepatitisC
     *          hepatitisC
     */
    public void setHepatitisC(Integer hepatitisC) {
        this.hepatitisC = hepatitisC;
    }
    
    /**
     * 获取syphilis
     * 
     * @return syphilis
     */
    public Integer getSyphilis() {
        return this.syphilis;
    }
     
    /**
     * 设置syphilis
     * 
     * @param syphilis
     *          syphilis
     */
    public void setSyphilis(Integer syphilis) {
        this.syphilis = syphilis;
    }
    
    /**
     * 获取aids
     * 
     * @return aids
     */
    public Integer getAids() {
        return this.aids;
    }
     
    /**
     * 设置aids
     * 
     * @param aids
     *          aids
     */
    public void setAids(Integer aids) {
        this.aids = aids;
    }
    
    /**
     * 获取opBodyCode
     * 
     * @return opBodyCode
     */
    public String getOpBodyCode() {
        return this.opBodyCode;
    }
     
    /**
     * 设置opBodyCode
     * 
     * @param opBodyCode
     *          opBodyCode
     */
    public void setOpBodyCode(String opBodyCode) {
        this.opBodyCode = opBodyCode;
    }
    
    /**
     * 获取opBodyName
     * 
     * @return opBodyName
     */
    public String getOpBodyName() {
        return this.opBodyName;
    }
     
    /**
     * 设置opBodyName
     * 
     * @param opBodyName
     *          opBodyName
     */
    public void setOpBodyName(String opBodyName) {
        this.opBodyName = opBodyName;
    }
    
    /**
     * 获取opReqireCode
     * 
     * @return opReqireCode
     */
    public String getOpReqireCode() {
        return this.opReqireCode;
    }
     
    /**
     * 设置opReqireCode
     * 
     * @param opReqireCode
     *          opReqireCode
     */
    public void setOpReqireCode(String opReqireCode) {
        this.opReqireCode = opReqireCode;
    }
    
    /**
     * 获取opReqireName
     * 
     * @return opReqireName
     */
    public String getOpReqireName() {
        return this.opReqireName;
    }
     
    /**
     * 设置opReqireName
     * 
     * @param opReqireName
     *          opReqireName
     */
    public void setOpReqireName(String opReqireName) {
        this.opReqireName = opReqireName;
    }
    
    /**
     * 获取opMdr
     * 
     * @return opMdr
     */
    public String getOpMdr() {
        return this.opMdr;
    }
     
    /**
     * 设置opMdr
     * 
     * @param opMdr
     *          opMdr
     */
    public void setOpMdr(String opMdr) {
        this.opMdr = opMdr;
    }
    
    /**
     * 获取incisionName
     * 
     * @return incisionName
     */
    public String getIncisionName() {
        return this.incisionName;
    }
     
    /**
     * 设置incisionName
     * 
     * @param incisionName
     *          incisionName
     */
    public void setIncisionName(String incisionName) {
        this.incisionName = incisionName;
    }
    
    /**
     * 获取codePsnReq
     * 
     * @return codePsnReq
     */
    public String getCodePsnReq() {
        return this.codePsnReq;
    }
     
    /**
     * 设置codePsnReq
     * 
     * @param codePsnReq
     *          codePsnReq
     */
    public void setCodePsnReq(String codePsnReq) {
        this.codePsnReq = codePsnReq;
    }
    
    /**
     * 获取namePsnReq
     * 
     * @return namePsnReq
     */
    public String getNamePsnReq() {
        return this.namePsnReq;
    }
     
    /**
     * 设置namePsnReq
     * 
     * @param namePsnReq
     *          namePsnReq
     */
    public void setNamePsnReq(String namePsnReq) {
        this.namePsnReq = namePsnReq;
    }
    
    /**
     * 获取dateReq
     * 
     * @return dateReq
     */
    public String getDateReq() {
        return this.dateReq;
    }
     
    /**
     * 设置dateReq
     * 
     * @param dateReq
     *          dateReq
     */
    public void setDateReq(String dateReq) {
        this.dateReq = dateReq;
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