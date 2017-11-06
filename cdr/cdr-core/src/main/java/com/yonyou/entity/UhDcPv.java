package com.yonyou.entity;

import java.util.Date;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.NamedStoredProcedureQuery;
import javax.persistence.ParameterMode;
import javax.persistence.StoredProcedureParameter;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

/**
 * @author chenpana@yonyou.com
 * @ClassName: UhDcPv
 * @Description:
 * @date 2017/6/30 11:37
 */
@Entity
@Table(name = "uh_dc_pv", schema = "dbo", catalog = "MIP_DC_DEMO")
@NamedStoredProcedureQuery(name = "uhDC.proc_update_empiandpkpi_all", procedureName = "proc_update_empiandpkpi_all", parameters = {
        @StoredProcedureParameter(mode = ParameterMode.IN, name = "empi", type = String.class),
        @StoredProcedureParameter(mode = ParameterMode.IN, name = "pkPati", type = String.class),
        @StoredProcedureParameter(mode = ParameterMode.IN, name = "oldPkPati", type = String.class)})
public class UhDcPv {

    private String pkDcpv;
    private String codeGroup;
    private String codeOrg;
    private String pkPati;
    private String empi;
    private String codePati;
    private String pvcode;
    private String codePvtype;
    private String namePvtype;
    private String interid;
    private String patiname;
    private String codeSex;
    private String nameSex;
    private String birthday;
    private String codeMari;
    private String nameMari;
    private String pkAppt;
    private String namePsnRegi;
    private String flagCanc;
    private String dateRegi;
    private String codePsnRegi;
    private String pvReason;
    private String diagMajCode;
    private String diagMajName;
    private String codePsnTre;
    private String namePsnTre;
    private String flagSt;
    private String dateBegin;
    private String dateEnd;
    private Integer pvTimes;
    private String diagOther;
    private String codePsnPhy;
    private String namePsnPhy;
    private String codePsnNs;
    private String namePsnNs;
    private String deptPhyCode;
    private String deptPhyName;
    private String areaPhyCode;
    private String areaPhyName;
    private String room;
    private String bed;
    private String hpCode;
    private String hpName;
    private String codePsnCanc;
    private String namePsnCanc;
    private String dateCanc;
    private Date createTime;
    private String flagDel;
    private String dataSource;
    private String sourcePk;
    private Date editTime;

    @Id
    @Column(name = "pk_dcpv")
    @GenericGenerator(name = "system-uuid", strategy = "uuid")
    @GeneratedValue(generator = "system-uuid")
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
    @Column(name = "pk_pati")
    public String getPkPati() {
        return pkPati;
    }

    public void setPkPati(String pkPati) {
        this.pkPati = pkPati;
    }

    @Basic
    @Column(name = "empi")
    public String getEmpi() {
        return empi;
    }

    public void setEmpi(String empi) {
        this.empi = empi;
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
    @Column(name = "pvcode")
    public String getPvcode() {
        return pvcode;
    }

    public void setPvcode(String pvcode) {
        this.pvcode = pvcode;
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
    @Column(name = "interid")
    public String getInterid() {
        return interid;
    }

    public void setInterid(String interid) {
        this.interid = interid;
    }

    @Basic
    @Column(name = "patiname")
    public String getPatiname() {
        return patiname;
    }

    public void setPatiname(String patiname) {
        this.patiname = patiname;
    }

    @Basic
    @Column(name = "code_sex")
    public String getCodeSex() {
        return codeSex;
    }

    public void setCodeSex(String codeSex) {
        this.codeSex = codeSex;
    }

    @Basic
    @Column(name = "name_sex")
    public String getNameSex() {
        return nameSex;
    }

    public void setNameSex(String nameSex) {
        this.nameSex = nameSex;
    }

    @Basic
    @Column(name = "birthday")
    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    @Basic
    @Column(name = "code_mari")
    public String getCodeMari() {
        return codeMari;
    }

    public void setCodeMari(String codeMari) {
        this.codeMari = codeMari;
    }

    @Basic
    @Column(name = "name_mari")
    public String getNameMari() {
        return nameMari;
    }

    public void setNameMari(String nameMari) {
        this.nameMari = nameMari;
    }

    @Basic
    @Column(name = "pk_appt")
    public String getPkAppt() {
        return pkAppt;
    }

    public void setPkAppt(String pkAppt) {
        this.pkAppt = pkAppt;
    }

    @Basic
    @Column(name = "name_psn_regi")
    public String getNamePsnRegi() {
        return namePsnRegi;
    }

    public void setNamePsnRegi(String namePsnRegi) {
        this.namePsnRegi = namePsnRegi;
    }

    @Basic
    @Column(name = "flag_canc")
    public String getFlagCanc() {
        return flagCanc;
    }

    public void setFlagCanc(String flagCanc) {
        this.flagCanc = flagCanc;
    }

    @Basic
    @Column(name = "date_regi")
    public String getDateRegi() {
        return dateRegi;
    }

    public void setDateRegi(String dateRegi) {
        this.dateRegi = dateRegi;
    }

    @Basic
    @Column(name = "code_psn_regi")
    public String getCodePsnRegi() {
        return codePsnRegi;
    }

    public void setCodePsnRegi(String codePsnRegi) {
        this.codePsnRegi = codePsnRegi;
    }

    @Basic
    @Column(name = "pv_reason")
    public String getPvReason() {
        return pvReason;
    }

    public void setPvReason(String pvReason) {
        this.pvReason = pvReason;
    }

    @Basic
    @Column(name = "diag_maj_code")
    public String getDiagMajCode() {
        return diagMajCode;
    }

    public void setDiagMajCode(String diagMajCode) {
        this.diagMajCode = diagMajCode;
    }

    @Basic
    @Column(name = "diag_maj_name")
    public String getDiagMajName() {
        return diagMajName;
    }

    public void setDiagMajName(String diagMajName) {
        this.diagMajName = diagMajName;
    }

    @Basic
    @Column(name = "code_psn_tre")
    public String getCodePsnTre() {
        return codePsnTre;
    }

    public void setCodePsnTre(String codePsnTre) {
        this.codePsnTre = codePsnTre;
    }

    @Basic
    @Column(name = "name_psn_tre")
    public String getNamePsnTre() {
        return namePsnTre;
    }

    public void setNamePsnTre(String namePsnTre) {
        this.namePsnTre = namePsnTre;
    }

    @Basic
    @Column(name = "flag_st")
    public String getFlagSt() {
        return flagSt;
    }

    public void setFlagSt(String flagSt) {
        this.flagSt = flagSt;
    }

    @Basic
    @Column(name = "date_begin")
    public String getDateBegin() {
        return dateBegin;
    }

    public void setDateBegin(String dateBegin) {
        this.dateBegin = dateBegin;
    }

    @Basic
    @Column(name = "date_end")
    public String getDateEnd() {
        return dateEnd;
    }

    public void setDateEnd(String dateEnd) {
        this.dateEnd = dateEnd;
    }

    @Basic
    @Column(name = "pv_times")
    public Integer getPvTimes() {
        return pvTimes;
    }

    public void setPvTimes(Integer pvTimes) {
        this.pvTimes = pvTimes;
    }

    @Basic
    @Column(name = "diag_other")
    public String getDiagOther() {
        return diagOther;
    }

    public void setDiagOther(String diagOther) {
        this.diagOther = diagOther;
    }

    @Basic
    @Column(name = "code_psn_phy")
    public String getCodePsnPhy() {
        return codePsnPhy;
    }

    public void setCodePsnPhy(String codePsnPhy) {
        this.codePsnPhy = codePsnPhy;
    }

    @Basic
    @Column(name = "name_psn_phy")
    public String getNamePsnPhy() {
        return namePsnPhy;
    }

    public void setNamePsnPhy(String namePsnPhy) {
        this.namePsnPhy = namePsnPhy;
    }

    @Basic
    @Column(name = "code_psn_ns")
    public String getCodePsnNs() {
        return codePsnNs;
    }

    public void setCodePsnNs(String codePsnNs) {
        this.codePsnNs = codePsnNs;
    }

    @Basic
    @Column(name = "name_psn_ns")
    public String getNamePsnNs() {
        return namePsnNs;
    }

    public void setNamePsnNs(String namePsnNs) {
        this.namePsnNs = namePsnNs;
    }

    @Basic
    @Column(name = "dept_phy_code")
    public String getDeptPhyCode() {
        return deptPhyCode;
    }

    public void setDeptPhyCode(String deptPhyCode) {
        this.deptPhyCode = deptPhyCode;
    }

    @Basic
    @Column(name = "dept_phy_name")
    public String getDeptPhyName() {
        return deptPhyName;
    }

    public void setDeptPhyName(String deptPhyName) {
        this.deptPhyName = deptPhyName;
    }

    @Basic
    @Column(name = "area_phy_code")
    public String getAreaPhyCode() {
        return areaPhyCode;
    }

    public void setAreaPhyCode(String areaPhyCode) {
        this.areaPhyCode = areaPhyCode;
    }

    @Basic
    @Column(name = "area_phy_name")
    public String getAreaPhyName() {
        return areaPhyName;
    }

    public void setAreaPhyName(String areaPhyName) {
        this.areaPhyName = areaPhyName;
    }

    @Basic
    @Column(name = "room")
    public String getRoom() {
        return room;
    }

    public void setRoom(String room) {
        this.room = room;
    }

    @Basic
    @Column(name = "bed")
    public String getBed() {
        return bed;
    }

    public void setBed(String bed) {
        this.bed = bed;
    }

    @Basic
    @Column(name = "hp_code")
    public String getHpCode() {
        return hpCode;
    }

    public void setHpCode(String hpCode) {
        this.hpCode = hpCode;
    }

    @Basic
    @Column(name = "hp_name")
    public String getHpName() {
        return hpName;
    }

    public void setHpName(String hpName) {
        this.hpName = hpName;
    }

    @Basic
    @Column(name = "code_psn_canc")
    public String getCodePsnCanc() {
        return codePsnCanc;
    }

    public void setCodePsnCanc(String codePsnCanc) {
        this.codePsnCanc = codePsnCanc;
    }

    @Basic
    @Column(name = "name_psn_canc")
    public String getNamePsnCanc() {
        return namePsnCanc;
    }

    public void setNamePsnCanc(String namePsnCanc) {
        this.namePsnCanc = namePsnCanc;
    }

    @Basic
    @Column(name = "date_canc")
    public String getDateCanc() {
        return dateCanc;
    }

    public void setDateCanc(String dateCanc) {
        this.dateCanc = dateCanc;
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
    @Column(name = "flag_del")
    public String getFlagDel() {
        return flagDel;
    }

    public void setFlagDel(String flagDel) {
        this.flagDel = flagDel;
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
    @Column(name = "edit_time")
    public Date getEditTime() {
        return editTime;
    }

    public void setEditTime(Date editTime) {
        this.editTime = editTime;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        UhDcPv uhDcPv = (UhDcPv) o;

        if (pkDcpv != null ? !pkDcpv.equals(uhDcPv.pkDcpv) : uhDcPv.pkDcpv != null) return false;
        if (codeGroup != null ? !codeGroup.equals(uhDcPv.codeGroup) : uhDcPv.codeGroup != null) return false;
        if (codeOrg != null ? !codeOrg.equals(uhDcPv.codeOrg) : uhDcPv.codeOrg != null) return false;
        if (pkPati != null ? !pkPati.equals(uhDcPv.pkPati) : uhDcPv.pkPati != null) return false;
        if (empi != null ? !empi.equals(uhDcPv.empi) : uhDcPv.empi != null) return false;
        if (codePati != null ? !codePati.equals(uhDcPv.codePati) : uhDcPv.codePati != null) return false;
        if (pvcode != null ? !pvcode.equals(uhDcPv.pvcode) : uhDcPv.pvcode != null) return false;
        if (codePvtype != null ? !codePvtype.equals(uhDcPv.codePvtype) : uhDcPv.codePvtype != null) return false;
        if (namePvtype != null ? !namePvtype.equals(uhDcPv.namePvtype) : uhDcPv.namePvtype != null) return false;
        if (interid != null ? !interid.equals(uhDcPv.interid) : uhDcPv.interid != null) return false;
        if (patiname != null ? !patiname.equals(uhDcPv.patiname) : uhDcPv.patiname != null) return false;
        if (codeSex != null ? !codeSex.equals(uhDcPv.codeSex) : uhDcPv.codeSex != null) return false;
        if (nameSex != null ? !nameSex.equals(uhDcPv.nameSex) : uhDcPv.nameSex != null) return false;
        if (birthday != null ? !birthday.equals(uhDcPv.birthday) : uhDcPv.birthday != null) return false;
        if (codeMari != null ? !codeMari.equals(uhDcPv.codeMari) : uhDcPv.codeMari != null) return false;
        if (nameMari != null ? !nameMari.equals(uhDcPv.nameMari) : uhDcPv.nameMari != null) return false;
        if (pkAppt != null ? !pkAppt.equals(uhDcPv.pkAppt) : uhDcPv.pkAppt != null) return false;
        if (namePsnRegi != null ? !namePsnRegi.equals(uhDcPv.namePsnRegi) : uhDcPv.namePsnRegi != null) return false;
        if (flagCanc != null ? !flagCanc.equals(uhDcPv.flagCanc) : uhDcPv.flagCanc != null) return false;
        if (dateRegi != null ? !dateRegi.equals(uhDcPv.dateRegi) : uhDcPv.dateRegi != null) return false;
        if (codePsnRegi != null ? !codePsnRegi.equals(uhDcPv.codePsnRegi) : uhDcPv.codePsnRegi != null) return false;
        if (pvReason != null ? !pvReason.equals(uhDcPv.pvReason) : uhDcPv.pvReason != null) return false;
        if (diagMajCode != null ? !diagMajCode.equals(uhDcPv.diagMajCode) : uhDcPv.diagMajCode != null) return false;
        if (diagMajName != null ? !diagMajName.equals(uhDcPv.diagMajName) : uhDcPv.diagMajName != null) return false;
        if (codePsnTre != null ? !codePsnTre.equals(uhDcPv.codePsnTre) : uhDcPv.codePsnTre != null) return false;
        if (namePsnTre != null ? !namePsnTre.equals(uhDcPv.namePsnTre) : uhDcPv.namePsnTre != null) return false;
        if (flagSt != null ? !flagSt.equals(uhDcPv.flagSt) : uhDcPv.flagSt != null) return false;
        if (dateBegin != null ? !dateBegin.equals(uhDcPv.dateBegin) : uhDcPv.dateBegin != null) return false;
        if (dateEnd != null ? !dateEnd.equals(uhDcPv.dateEnd) : uhDcPv.dateEnd != null) return false;
        if (pvTimes != null ? !pvTimes.equals(uhDcPv.pvTimes) : uhDcPv.pvTimes != null) return false;
        if (diagOther != null ? !diagOther.equals(uhDcPv.diagOther) : uhDcPv.diagOther != null) return false;
        if (codePsnPhy != null ? !codePsnPhy.equals(uhDcPv.codePsnPhy) : uhDcPv.codePsnPhy != null) return false;
        if (namePsnPhy != null ? !namePsnPhy.equals(uhDcPv.namePsnPhy) : uhDcPv.namePsnPhy != null) return false;
        if (codePsnNs != null ? !codePsnNs.equals(uhDcPv.codePsnNs) : uhDcPv.codePsnNs != null) return false;
        if (namePsnNs != null ? !namePsnNs.equals(uhDcPv.namePsnNs) : uhDcPv.namePsnNs != null) return false;
        if (deptPhyCode != null ? !deptPhyCode.equals(uhDcPv.deptPhyCode) : uhDcPv.deptPhyCode != null) return false;
        if (deptPhyName != null ? !deptPhyName.equals(uhDcPv.deptPhyName) : uhDcPv.deptPhyName != null) return false;
        if (areaPhyCode != null ? !areaPhyCode.equals(uhDcPv.areaPhyCode) : uhDcPv.areaPhyCode != null) return false;
        if (areaPhyName != null ? !areaPhyName.equals(uhDcPv.areaPhyName) : uhDcPv.areaPhyName != null) return false;
        if (room != null ? !room.equals(uhDcPv.room) : uhDcPv.room != null) return false;
        if (bed != null ? !bed.equals(uhDcPv.bed) : uhDcPv.bed != null) return false;
        if (hpCode != null ? !hpCode.equals(uhDcPv.hpCode) : uhDcPv.hpCode != null) return false;
        if (hpName != null ? !hpName.equals(uhDcPv.hpName) : uhDcPv.hpName != null) return false;
        if (codePsnCanc != null ? !codePsnCanc.equals(uhDcPv.codePsnCanc) : uhDcPv.codePsnCanc != null) return false;
        if (namePsnCanc != null ? !namePsnCanc.equals(uhDcPv.namePsnCanc) : uhDcPv.namePsnCanc != null) return false;
        if (dateCanc != null ? !dateCanc.equals(uhDcPv.dateCanc) : uhDcPv.dateCanc != null) return false;
        if (createTime != null ? !createTime.equals(uhDcPv.createTime) : uhDcPv.createTime != null) return false;
        if (flagDel != null ? !flagDel.equals(uhDcPv.flagDel) : uhDcPv.flagDel != null) return false;
        if (dataSource != null ? !dataSource.equals(uhDcPv.dataSource) : uhDcPv.dataSource != null) return false;
        if (sourcePk != null ? !sourcePk.equals(uhDcPv.sourcePk) : uhDcPv.sourcePk != null) return false;
        if (editTime != null ? !editTime.equals(uhDcPv.editTime) : uhDcPv.editTime != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = pkDcpv != null ? pkDcpv.hashCode() : 0;
        result = 31 * result + (codeGroup != null ? codeGroup.hashCode() : 0);
        result = 31 * result + (codeOrg != null ? codeOrg.hashCode() : 0);
        result = 31 * result + (pkPati != null ? pkPati.hashCode() : 0);
        result = 31 * result + (empi != null ? empi.hashCode() : 0);
        result = 31 * result + (codePati != null ? codePati.hashCode() : 0);
        result = 31 * result + (pvcode != null ? pvcode.hashCode() : 0);
        result = 31 * result + (codePvtype != null ? codePvtype.hashCode() : 0);
        result = 31 * result + (namePvtype != null ? namePvtype.hashCode() : 0);
        result = 31 * result + (interid != null ? interid.hashCode() : 0);
        result = 31 * result + (patiname != null ? patiname.hashCode() : 0);
        result = 31 * result + (codeSex != null ? codeSex.hashCode() : 0);
        result = 31 * result + (nameSex != null ? nameSex.hashCode() : 0);
        result = 31 * result + (birthday != null ? birthday.hashCode() : 0);
        result = 31 * result + (codeMari != null ? codeMari.hashCode() : 0);
        result = 31 * result + (nameMari != null ? nameMari.hashCode() : 0);
        result = 31 * result + (pkAppt != null ? pkAppt.hashCode() : 0);
        result = 31 * result + (namePsnRegi != null ? namePsnRegi.hashCode() : 0);
        result = 31 * result + (flagCanc != null ? flagCanc.hashCode() : 0);
        result = 31 * result + (dateRegi != null ? dateRegi.hashCode() : 0);
        result = 31 * result + (codePsnRegi != null ? codePsnRegi.hashCode() : 0);
        result = 31 * result + (pvReason != null ? pvReason.hashCode() : 0);
        result = 31 * result + (diagMajCode != null ? diagMajCode.hashCode() : 0);
        result = 31 * result + (diagMajName != null ? diagMajName.hashCode() : 0);
        result = 31 * result + (codePsnTre != null ? codePsnTre.hashCode() : 0);
        result = 31 * result + (namePsnTre != null ? namePsnTre.hashCode() : 0);
        result = 31 * result + (flagSt != null ? flagSt.hashCode() : 0);
        result = 31 * result + (dateBegin != null ? dateBegin.hashCode() : 0);
        result = 31 * result + (dateEnd != null ? dateEnd.hashCode() : 0);
        result = 31 * result + (pvTimes != null ? pvTimes.hashCode() : 0);
        result = 31 * result + (diagOther != null ? diagOther.hashCode() : 0);
        result = 31 * result + (codePsnPhy != null ? codePsnPhy.hashCode() : 0);
        result = 31 * result + (namePsnPhy != null ? namePsnPhy.hashCode() : 0);
        result = 31 * result + (codePsnNs != null ? codePsnNs.hashCode() : 0);
        result = 31 * result + (namePsnNs != null ? namePsnNs.hashCode() : 0);
        result = 31 * result + (deptPhyCode != null ? deptPhyCode.hashCode() : 0);
        result = 31 * result + (deptPhyName != null ? deptPhyName.hashCode() : 0);
        result = 31 * result + (areaPhyCode != null ? areaPhyCode.hashCode() : 0);
        result = 31 * result + (areaPhyName != null ? areaPhyName.hashCode() : 0);
        result = 31 * result + (room != null ? room.hashCode() : 0);
        result = 31 * result + (bed != null ? bed.hashCode() : 0);
        result = 31 * result + (hpCode != null ? hpCode.hashCode() : 0);
        result = 31 * result + (hpName != null ? hpName.hashCode() : 0);
        result = 31 * result + (codePsnCanc != null ? codePsnCanc.hashCode() : 0);
        result = 31 * result + (namePsnCanc != null ? namePsnCanc.hashCode() : 0);
        result = 31 * result + (dateCanc != null ? dateCanc.hashCode() : 0);
        result = 31 * result + (createTime != null ? createTime.hashCode() : 0);
        result = 31 * result + (flagDel != null ? flagDel.hashCode() : 0);
        result = 31 * result + (dataSource != null ? dataSource.hashCode() : 0);
        result = 31 * result + (sourcePk != null ? sourcePk.hashCode() : 0);
        result = 31 * result + (editTime != null ? editTime.hashCode() : 0);
        return result;
    }
}
