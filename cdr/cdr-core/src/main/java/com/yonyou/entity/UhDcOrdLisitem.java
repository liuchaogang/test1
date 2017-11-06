package com.yonyou.entity;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.Date;

/**
 * @author chenpana@yonyou.com
 * @ClassName: UhDcOrdLisitem
 * @Description:
 * @date 2017/7/10 17:17
 */
@Entity
@Table(name = "uh_dc_ord_lisitem", schema = "dbo", catalog = "MIP_DC_DEMO")
public class UhDcOrdLisitem {

    private String pkOrdlab;
    private String pkRepLis;
    private String codeGroup;
    private String codeOrg;
    private String codeRep;
    private String specimenid;
    private String uniqSerialNo;
    private String codeIndexLis;
    private String nameIndexLis;
    private String valueLis;
    private String codeQuantiUnit;
    private String nameQuantiUnit;
    private String limitHigh;
    private String limitLow;
    private String descRrs;
    private String valueFlag;
    private String valueFlagName;
    private String codeInstrument;
    private String dataSource;
    private String sourcePk;
    private Date createTime;
    private Date editTime;
    private String flagDel;

    @Id
    @Column(name = "PK_ORDLAB")
    @GenericGenerator(name = "system-uuid", strategy = "uuid")
    @GeneratedValue(generator = "system-uuid")
    public String getPkOrdlab() {
        return pkOrdlab;
    }

    public void setPkOrdlab(String pkOrdlab) {
        this.pkOrdlab = pkOrdlab;
    }

    @Basic
    @Column(name = "pk_rep_lis")
    public String getPkRepLis() {
        return pkRepLis;
    }

    public void setPkRepLis(String pkRepLis) {
        this.pkRepLis = pkRepLis;
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
    @Column(name = "code_rep")
    public String getCodeRep() {
        return codeRep;
    }

    public void setCodeRep(String codeRep) {
        this.codeRep = codeRep;
    }

    @Basic
    @Column(name = "specimenid")
    public String getSpecimenid() {
        return specimenid;
    }

    public void setSpecimenid(String specimenid) {
        this.specimenid = specimenid;
    }

    @Basic
    @Column(name = "uniq_serial_no")
    public String getUniqSerialNo() {
        return uniqSerialNo;
    }

    public void setUniqSerialNo(String uniqSerialNo) {
        this.uniqSerialNo = uniqSerialNo;
    }

    @Basic
    @Column(name = "code_index_lis")
    public String getCodeIndexLis() {
        return codeIndexLis;
    }

    public void setCodeIndexLis(String codeIndexLis) {
        this.codeIndexLis = codeIndexLis;
    }

    @Basic
    @Column(name = "name_index_lis")
    public String getNameIndexLis() {
        return nameIndexLis;
    }

    public void setNameIndexLis(String nameIndexLis) {
        this.nameIndexLis = nameIndexLis;
    }

    @Basic
    @Column(name = "value_lis")
    public String getValueLis() {
        return valueLis;
    }

    public void setValueLis(String valueLis) {
        this.valueLis = valueLis;
    }

    @Basic
    @Column(name = "code_quanti_unit")
    public String getCodeQuantiUnit() {
        return codeQuantiUnit;
    }

    public void setCodeQuantiUnit(String codeQuantiUnit) {
        this.codeQuantiUnit = codeQuantiUnit;
    }

    @Basic
    @Column(name = "name_quanti_unit")
    public String getNameQuantiUnit() {
        return nameQuantiUnit;
    }

    public void setNameQuantiUnit(String nameQuantiUnit) {
        this.nameQuantiUnit = nameQuantiUnit;
    }

    @Basic
    @Column(name = "limit_high")
    public String getLimitHigh() {
        return limitHigh;
    }

    public void setLimitHigh(String limitHigh) {
        this.limitHigh = limitHigh;
    }

    @Basic
    @Column(name = "limit_low")
    public String getLimitLow() {
        return limitLow;
    }

    public void setLimitLow(String limitLow) {
        this.limitLow = limitLow;
    }

    @Basic
    @Column(name = "desc_rrs")
    public String getDescRrs() {
        return descRrs;
    }

    public void setDescRrs(String descRrs) {
        this.descRrs = descRrs;
    }

    @Basic
    @Column(name = "value_flag")
    public String getValueFlag() {
        return valueFlag;
    }

    public void setValueFlag(String valueFlag) {
        this.valueFlag = valueFlag;
    }

    @Basic
    @Column(name = "value_flag_name")
    public String getValueFlagName() {
        return valueFlagName;
    }

    public void setValueFlagName(String valueFlagName) {
        this.valueFlagName = valueFlagName;
    }

    @Basic
    @Column(name = "code_instrument")
    public String getCodeInstrument() {
        return codeInstrument;
    }

    public void setCodeInstrument(String codeInstrument) {
        this.codeInstrument = codeInstrument;
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

        UhDcOrdLisitem that = (UhDcOrdLisitem) o;

        if (pkOrdlab != null ? !pkOrdlab.equals(that.pkOrdlab) : that.pkOrdlab != null) return false;
        if (pkRepLis != null ? !pkRepLis.equals(that.pkRepLis) : that.pkRepLis != null) return false;
        if (codeGroup != null ? !codeGroup.equals(that.codeGroup) : that.codeGroup != null) return false;
        if (codeOrg != null ? !codeOrg.equals(that.codeOrg) : that.codeOrg != null) return false;
        if (codeRep != null ? !codeRep.equals(that.codeRep) : that.codeRep != null) return false;
        if (specimenid != null ? !specimenid.equals(that.specimenid) : that.specimenid != null) return false;
        if (uniqSerialNo != null ? !uniqSerialNo.equals(that.uniqSerialNo) : that.uniqSerialNo != null) return false;
        if (codeIndexLis != null ? !codeIndexLis.equals(that.codeIndexLis) : that.codeIndexLis != null) return false;
        if (nameIndexLis != null ? !nameIndexLis.equals(that.nameIndexLis) : that.nameIndexLis != null) return false;
        if (valueLis != null ? !valueLis.equals(that.valueLis) : that.valueLis != null) return false;
        if (codeQuantiUnit != null ? !codeQuantiUnit.equals(that.codeQuantiUnit) : that.codeQuantiUnit != null)
            return false;
        if (nameQuantiUnit != null ? !nameQuantiUnit.equals(that.nameQuantiUnit) : that.nameQuantiUnit != null)
            return false;
        if (limitHigh != null ? !limitHigh.equals(that.limitHigh) : that.limitHigh != null) return false;
        if (limitLow != null ? !limitLow.equals(that.limitLow) : that.limitLow != null) return false;
        if (descRrs != null ? !descRrs.equals(that.descRrs) : that.descRrs != null) return false;
        if (valueFlag != null ? !valueFlag.equals(that.valueFlag) : that.valueFlag != null) return false;
        if (valueFlagName != null ? !valueFlagName.equals(that.valueFlagName) : that.valueFlagName != null)
            return false;
        if (codeInstrument != null ? !codeInstrument.equals(that.codeInstrument) : that.codeInstrument != null)
            return false;
        if (dataSource != null ? !dataSource.equals(that.dataSource) : that.dataSource != null) return false;
        if (sourcePk != null ? !sourcePk.equals(that.sourcePk) : that.sourcePk != null) return false;
        if (createTime != null ? !createTime.equals(that.createTime) : that.createTime != null) return false;
        if (editTime != null ? !editTime.equals(that.editTime) : that.editTime != null) return false;
        if (flagDel != null ? !flagDel.equals(that.flagDel) : that.flagDel != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = pkOrdlab != null ? pkOrdlab.hashCode() : 0;
        result = 31 * result + (pkRepLis != null ? pkRepLis.hashCode() : 0);
        result = 31 * result + (codeGroup != null ? codeGroup.hashCode() : 0);
        result = 31 * result + (codeOrg != null ? codeOrg.hashCode() : 0);
        result = 31 * result + (codeRep != null ? codeRep.hashCode() : 0);
        result = 31 * result + (specimenid != null ? specimenid.hashCode() : 0);
        result = 31 * result + (uniqSerialNo != null ? uniqSerialNo.hashCode() : 0);
        result = 31 * result + (codeIndexLis != null ? codeIndexLis.hashCode() : 0);
        result = 31 * result + (nameIndexLis != null ? nameIndexLis.hashCode() : 0);
        result = 31 * result + (valueLis != null ? valueLis.hashCode() : 0);
        result = 31 * result + (codeQuantiUnit != null ? codeQuantiUnit.hashCode() : 0);
        result = 31 * result + (nameQuantiUnit != null ? nameQuantiUnit.hashCode() : 0);
        result = 31 * result + (limitHigh != null ? limitHigh.hashCode() : 0);
        result = 31 * result + (limitLow != null ? limitLow.hashCode() : 0);
        result = 31 * result + (descRrs != null ? descRrs.hashCode() : 0);
        result = 31 * result + (valueFlag != null ? valueFlag.hashCode() : 0);
        result = 31 * result + (valueFlagName != null ? valueFlagName.hashCode() : 0);
        result = 31 * result + (codeInstrument != null ? codeInstrument.hashCode() : 0);
        result = 31 * result + (dataSource != null ? dataSource.hashCode() : 0);
        result = 31 * result + (sourcePk != null ? sourcePk.hashCode() : 0);
        result = 31 * result + (createTime != null ? createTime.hashCode() : 0);
        result = 31 * result + (editTime != null ? editTime.hashCode() : 0);
        result = 31 * result + (flagDel != null ? flagDel.hashCode() : 0);
        return result;
    }
}
