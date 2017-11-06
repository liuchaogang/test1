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
 * @ClassName: UhDcPiCard
 * @Description:
 * @date 2017/6/28 14:04
 */
@Entity
@Table(name = "uh_dc_pi_card", schema = "dbo", catalog = "MIP_DC_DEMO")
public class UhDcPiCard {

    private int pkCard;
    private String pkPati;
    private String codeGroup;
    private String codeOrg;
    private String codeCardType;
    private String nameCardType;
    private String cardNo;
    private String useflag;
    private String dataSource;
    private String sourcePk;
    private Date createTime;
    private Date editTime;
    private String flagDel;

    @Id
    @Column(name = "pk_card")
    @GeneratedValue()
    public int getPkCard() {
        return pkCard;
    }

    public void setPkCard(int pkCard) {
        this.pkCard = pkCard;
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
    @Column(name = "code_card_type")
    public String getCodeCardType() {
        return codeCardType;
    }

    public void setCodeCardType(String codeCardType) {
        this.codeCardType = codeCardType;
    }

    @Basic
    @Column(name = "name_card_type")
    public String getNameCardType() {
        return nameCardType;
    }

    public void setNameCardType(String nameCardType) {
        this.nameCardType = nameCardType;
    }

    @Basic
    @Column(name = "card_no")
    public String getCardNo() {
        return cardNo;
    }

    public void setCardNo(String cardNo) {
        this.cardNo = cardNo;
    }

    @Basic
    @Column(name = "useflag")
    public String getUseflag() {
        return useflag;
    }

    public void setUseflag(String useflag) {
        this.useflag = useflag;
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

        UhDcPiCard that = (UhDcPiCard) o;

        if (pkCard != that.pkCard) return false;
        if (pkPati != null ? !pkPati.equals(that.pkPati) : that.pkPati != null) return false;
        if (codeGroup != null ? !codeGroup.equals(that.codeGroup) : that.codeGroup != null) return false;
        if (codeOrg != null ? !codeOrg.equals(that.codeOrg) : that.codeOrg != null) return false;
        if (codeCardType != null ? !codeCardType.equals(that.codeCardType) : that.codeCardType != null) return false;
        if (nameCardType != null ? !nameCardType.equals(that.nameCardType) : that.nameCardType != null) return false;
        if (cardNo != null ? !cardNo.equals(that.cardNo) : that.cardNo != null) return false;
        if (useflag != null ? !useflag.equals(that.useflag) : that.useflag != null) return false;
        if (dataSource != null ? !dataSource.equals(that.dataSource) : that.dataSource != null) return false;
        if (sourcePk != null ? !sourcePk.equals(that.sourcePk) : that.sourcePk != null) return false;
        if (createTime != null ? !createTime.equals(that.createTime) : that.createTime != null) return false;
        if (editTime != null ? !editTime.equals(that.editTime) : that.editTime != null) return false;
        if (flagDel != null ? !flagDel.equals(that.flagDel) : that.flagDel != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = pkCard;
        result = 31 * result + (pkPati != null ? pkPati.hashCode() : 0);
        result = 31 * result + (codeGroup != null ? codeGroup.hashCode() : 0);
        result = 31 * result + (codeOrg != null ? codeOrg.hashCode() : 0);
        result = 31 * result + (codeCardType != null ? codeCardType.hashCode() : 0);
        result = 31 * result + (nameCardType != null ? nameCardType.hashCode() : 0);
        result = 31 * result + (cardNo != null ? cardNo.hashCode() : 0);
        result = 31 * result + (useflag != null ? useflag.hashCode() : 0);
        result = 31 * result + (dataSource != null ? dataSource.hashCode() : 0);
        result = 31 * result + (sourcePk != null ? sourcePk.hashCode() : 0);
        result = 31 * result + (createTime != null ? createTime.hashCode() : 0);
        result = 31 * result + (editTime != null ? editTime.hashCode() : 0);
        result = 31 * result + (flagDel != null ? flagDel.hashCode() : 0);
        return result;
    }
}
