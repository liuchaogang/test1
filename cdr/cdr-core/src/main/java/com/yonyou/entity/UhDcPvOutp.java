package com.yonyou.entity;

import java.util.Date;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

/**
 * @author chenpana@yonyou.com
 * @ClassName: UhDcPvOutp
 * @Description:
 * @date 2017/7/3 9:23
 */
@Entity
@Table(name = "uh_dc_pv_outp", schema = "dbo", catalog = "MIP_DC_DEMO")
public class UhDcPvOutp {

    private String pkOutpv;
    private String pkDcpv;
    private String codeGroup;
    private String codeOrg;
    private String codePati;
    private String codePvtype;
    private String namePvtype;
    private String pvcode;
    private String interid;
    private String dtSrvtype;
    private String nameSrvtype;
    private String schSrv;
    private String schRes;
    private String codePsn;
    private String namePsn;
    private String dateValidBegin;
    private String dateValidEnd;
    private Integer ticketno;
    //private String pkCg;
    private String flagSt;
    //private String pkSt;
    private String flagFirst;
    private String dataSource;
    private String sourcePk;
    private Date createTime;
    private Date editTime;
    private String flagDel;
    private String codeRegWay;
    private String nameRegWay;
    private String codePsnReg;
    private String namePsnReg;

    @Id
    @Column(name = "pk_outpv")
    @GenericGenerator(name = "system-uuid", strategy = "uuid")
    @GeneratedValue(generator = "system-uuid")
    public String getPkOutpv() {
        return pkOutpv;
    }

    public void setPkOutpv(String pkOutpv) {
        this.pkOutpv = pkOutpv;
    }

    @Basic
    @Column(name = "pk_dcpv")
    public String getPkDcpv() {
        return pkDcpv;
    }

    public void setPkDcpv(String pkDcpv) {
        this.pkDcpv = pkDcpv;
    }

    @Basic
    @Column(name = "code_group")
    public String getCodeGroup() {
        return codeGroup;
    }

    public void setCodeGroup(String codeGroup) {
        this.codeGroup = codeGroup;
    }

    @Basic
    @Column(name = "code_org")
    public String getCodeOrg() {
        return codeOrg;
    }

    public void setCodeOrg(String codeOrg) {
        this.codeOrg = codeOrg;
    }

    @Basic
    @Column(name = "code_pati")
    public String getCodePati() {
        return codePati;
    }

    public void setCodePati(String codePati) {
        this.codePati = codePati;
    }

    @Basic
    @Column(name = "code_pvtype")
    public String getCodePvtype() {
        return codePvtype;
    }

    public void setCodePvtype(String codePvtype) {
        this.codePvtype = codePvtype;
    }

    @Basic
    @Column(name = "name_pvtype")
    public String getNamePvtype() {
        return namePvtype;
    }

    public void setNamePvtype(String namePvtype) {
        this.namePvtype = namePvtype;
    }

    @Basic
    @Column(name = "pvcode")
    public String getPvcode() {
        return pvcode;
    }

    public void setPvcode(String pvcode) {
        this.pvcode = pvcode;
    }

    @Basic
    @Column(name = "interid")
    public String getInterid() {
        return interid;
    }

    public void setInterid(String interid) {
        this.interid = interid;
    }

    @Basic
    @Column(name = "dt_srvtype")
    public String getDtSrvtype() {
        return dtSrvtype;
    }

    public void setDtSrvtype(String dtSrvtype) {
        this.dtSrvtype = dtSrvtype;
    }

    @Basic
    @Column(name = "sch_srv")
    public String getSchSrv() {
        return schSrv;
    }

    public void setSchSrv(String schSrv) {
        this.schSrv = schSrv;
    }

    @Basic
    @Column(name = "sch_res")
    public String getSchRes() {
        return schRes;
    }

    public void setSchRes(String schRes) {
        this.schRes = schRes;
    }

    @Basic
    @Column(name = "code_psn")
    public String getCodePsn() {
        return codePsn;
    }

    public void setCodePsn(String codePsn) {
        this.codePsn = codePsn;
    }

    @Basic
    @Column(name = "name_psn")
    public String getNamePsn() {
        return namePsn;
    }

    public void setNamePsn(String namePsn) {
        this.namePsn = namePsn;
    }

    @Basic
    @Column(name = "date_valid_begin")
    public String getDateValidBegin() {
        return dateValidBegin;
    }

    public void setDateValidBegin(String dateValidBegin) {
        this.dateValidBegin = dateValidBegin;
    }

    @Basic
    @Column(name = "date_valid_end")
    public String getDateValidEnd() {
        return dateValidEnd;
    }

    public void setDateValidEnd(String dateValidEnd) {
        this.dateValidEnd = dateValidEnd;
    }

    @Basic
    @Column(name = "ticketno")
    public Integer getTicketno() {
        return ticketno;
    }

    public void setTicketno(Integer ticketno) {
        this.ticketno = ticketno;
    }

  /*  @Basic
    @Column(name = "pk_cg")
    public String getPkCg() {
        return pkCg;
    }

    public void setPkCg(String pkCg) {
        this.pkCg = pkCg;
    }
*/
    @Basic
    @Column(name = "flag_st")
    public String getFlagSt() {
        return flagSt;
    }

    public void setFlagSt(String flagSt) {
        this.flagSt = flagSt;
    }

/*    @Basic
    @Column(name = "pk_st")
    public String getPkSt() {
        return pkSt;
    }

    public void setPkSt(String pkSt) {
        this.pkSt = pkSt;
    }*/

    @Basic
    @Column(name = "flag_first")
    public String getFlagFirst() {
        return flagFirst;
    }

    public void setFlagFirst(String flagFirst) {
        this.flagFirst = flagFirst;
    }

    @Basic
    @Column(name = "data_source")
    public String getDataSource() {
        return dataSource;
    }

    public void setDataSource(String dataSource) {
        this.dataSource = dataSource;
    }

    @Basic
    @Column(name = "source_pk")
    public String getSourcePk() {
        return sourcePk;
    }

    public void setSourcePk(String sourcePk) {
        this.sourcePk = sourcePk;
    }

    @Basic
    @Column(name = "create_time")
    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    @Basic
    @Column(name = "edit_time")
    public Date getEditTime() {
        return editTime;
    }

    public void setEditTime(Date editTime) {
        this.editTime = editTime;
    }

    @Basic
    @Column(name = "flag_del")
    public String getFlagDel() {
        return flagDel;
    }

    public void setFlagDel(String flagDel) {
        this.flagDel = flagDel;
    }

    @Basic
    @Column(name = "name_srvtype")
    public String getNameSrvtype() {
        return nameSrvtype;
    }

    public void setNameSrvtype(String nameSrvtype) {
        this.nameSrvtype = nameSrvtype;
    }

    @Basic
    @Column(name = "code_reg_way")
    public String getCodeRegWay() {
        return codeRegWay;
    }

    public void setCodeRegWay(String codeRegWay) {
        this.codeRegWay = codeRegWay;
    }

    @Basic
    @Column(name = "name_reg_way")
    public String getNameRegWay() {
        return nameRegWay;
    }

    public void setNameRegWay(String nameRegWay) {
        this.nameRegWay = nameRegWay;
    }

    @Basic
    @Column(name = "code_psn_reg")
    public String getCodePsnReg() {
        return codePsnReg;
    }

    public void setCodePsnReg(String codePsnReg) {
        this.codePsnReg = codePsnReg;
    }

    @Basic
    @Column(name = "name_psn_reg")
    public String getNamePsnReg() {
        return namePsnReg;
    }

    public void setNamePsnReg(String namePsnReg) {
        this.namePsnReg = namePsnReg;
    }
}
