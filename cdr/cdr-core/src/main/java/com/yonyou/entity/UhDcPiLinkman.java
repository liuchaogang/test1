package com.yonyou.entity;

import java.util.Date;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @author chenpana@yonyou.com
 * @ClassName: UhDcPiLinkman
 * @Description:
 * @date 2017/6/28 14:04
 */
@Entity
@Table(name = "uh_dc_pi_linkman", schema = "dbo", catalog = "MIP_DC_DEMO")
public class UhDcPiLinkman {

    private int pkLinkman;
    private String pkPati;
    private String codeGroup;
    private String codeOrg;
    private String codeContRelat;
    private String nameContRelat;
    private String contactName;
    private String contactTel;
    private String contactAddr;
    private String dataSource;
    private String sourcePk;
    private Date createTime;
    private Date editTime;
    private String flagDel;

    @Id
    @Column(name = "pk_linkman")
    @GeneratedValue()
    public int getPkLinkman() {
        return pkLinkman;
    }

    public void setPkLinkman(int pkLinkman) {
        this.pkLinkman = pkLinkman;
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
    @Column(name = "code_cont_relat")
    public String getCodeContRelat() {
        return codeContRelat;
    }

    public void setCodeContRelat(String codeContRelat) {
        this.codeContRelat = codeContRelat;
    }

    @Basic
    @Column(name = "name_cont_relat")
    public String getNameContRelat() {
        return nameContRelat;
    }

    public void setNameContRelat(String nameContRelat) {
        this.nameContRelat = nameContRelat;
    }

    @Basic
    @Column(name = "contact_name")
    public String getContactName() {
        return contactName;
    }

    public void setContactName(String contactName) {
        this.contactName = contactName;
    }

    @Basic
    @Column(name = "contact_tel")
    public String getContactTel() {
        return contactTel;
    }

    public void setContactTel(String contactTel) {
        this.contactTel = contactTel;
    }

    @Basic
    @Column(name = "contact_addr")
    public String getContactAddr() {
        return contactAddr;
    }

    public void setContactAddr(String contactAddr) {
        this.contactAddr = contactAddr;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        UhDcPiLinkman piLinkman = (UhDcPiLinkman) o;

        if (pkLinkman != piLinkman.pkLinkman) return false;
        if (pkPati != null ? !pkPati.equals(piLinkman.pkPati) : piLinkman.pkPati != null) return false;
        if (codeGroup != null ? !codeGroup.equals(piLinkman.codeGroup) : piLinkman.codeGroup != null) return false;
        if (codeOrg != null ? !codeOrg.equals(piLinkman.codeOrg) : piLinkman.codeOrg != null) return false;
        if (codeContRelat != null ? !codeContRelat.equals(piLinkman.codeContRelat) : piLinkman.codeContRelat != null)
            return false;
        if (nameContRelat != null ? !nameContRelat.equals(piLinkman.nameContRelat) : piLinkman.nameContRelat != null)
            return false;
        if (contactName != null ? !contactName.equals(piLinkman.contactName) : piLinkman.contactName != null)
            return false;
        if (contactTel != null ? !contactTel.equals(piLinkman.contactTel) : piLinkman.contactTel != null) return false;
        if (contactAddr != null ? !contactAddr.equals(piLinkman.contactAddr) : piLinkman.contactAddr != null)
            return false;
        if (dataSource != null ? !dataSource.equals(piLinkman.dataSource) : piLinkman.dataSource != null) return false;
        if (sourcePk != null ? !sourcePk.equals(piLinkman.sourcePk) : piLinkman.sourcePk != null) return false;
        if (createTime != null ? !createTime.equals(piLinkman.createTime) : piLinkman.createTime != null) return false;
        if (editTime != null ? !editTime.equals(piLinkman.editTime) : piLinkman.editTime != null) return false;
        if (flagDel != null ? !flagDel.equals(piLinkman.flagDel) : piLinkman.flagDel != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = pkLinkman;
        result = 31 * result + (pkPati != null ? pkPati.hashCode() : 0);
        result = 31 * result + (codeGroup != null ? codeGroup.hashCode() : 0);
        result = 31 * result + (codeOrg != null ? codeOrg.hashCode() : 0);
        result = 31 * result + (codeContRelat != null ? codeContRelat.hashCode() : 0);
        result = 31 * result + (nameContRelat != null ? nameContRelat.hashCode() : 0);
        result = 31 * result + (contactName != null ? contactName.hashCode() : 0);
        result = 31 * result + (contactTel != null ? contactTel.hashCode() : 0);
        result = 31 * result + (contactAddr != null ? contactAddr.hashCode() : 0);
        result = 31 * result + (dataSource != null ? dataSource.hashCode() : 0);
        result = 31 * result + (sourcePk != null ? sourcePk.hashCode() : 0);
        result = 31 * result + (createTime != null ? createTime.hashCode() : 0);
        result = 31 * result + (editTime != null ? editTime.hashCode() : 0);
        result = 31 * result + (flagDel != null ? flagDel.hashCode() : 0);
        return result;
    }
}
