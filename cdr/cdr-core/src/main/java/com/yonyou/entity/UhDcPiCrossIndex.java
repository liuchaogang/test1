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
 * @ClassName: UhDcPiCrossIndex
 * @Description:
 * @date 2017/6/28 14:04
 */
@Entity
@Table(name = "uh_dc_pi_cross_index", schema = "dbo", catalog = "MIP_DC_DEMO")
public class UhDcPiCrossIndex {

    private int pkIndex;
    private String empi;
    private String patiCode;
    private String localTypeCode;
    private String healthCardNo;
    private String oupatientNo;
    private String inpatientNo;
    private String insuranceNo;
    private Date createTime;
    private String flagDel;
    private Date editTime;
    private String codeGroup;
    private String codeOrg;

    @Id
    @Column(name = "pk_index")
    @GeneratedValue()
    public int getPkIndex() {
        return pkIndex;
    }

    public void setPkIndex(int pkIndex) {
        this.pkIndex = pkIndex;
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
    @Column(name = "pati_code")
    public String getPatiCode() {
        return patiCode;
    }

    public void setPatiCode(String patiCode) {
        this.patiCode = patiCode;
    }

    @Basic
    @Column(name = "local_type_code")
    public String getLocalTypeCode() {
        return localTypeCode;
    }

    public void setLocalTypeCode(String localTypeCode) {
        this.localTypeCode = localTypeCode;
    }

    @Basic
    @Column(name = "health_card_no")
    public String getHealthCardNo() {
        return healthCardNo;
    }

    public void setHealthCardNo(String healthCardNo) {
        this.healthCardNo = healthCardNo;
    }

    @Basic
    @Column(name = "oupatient_no")
    public String getOupatientNo() {
        return oupatientNo;
    }

    public void setOupatientNo(String oupatientNo) {
        this.oupatientNo = oupatientNo;
    }

    @Basic
    @Column(name = "inpatient_no")
    public String getInpatientNo() {
        return inpatientNo;
    }

    public void setInpatientNo(String inpatientNo) {
        this.inpatientNo = inpatientNo;
    }

    @Basic
    @Column(name = "insurance_no")
    public String getInsuranceNo() {
        return insuranceNo;
    }

    public void setInsuranceNo(String insuranceNo) {
        this.insuranceNo = insuranceNo;
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
    @Column(name = "edit_time")
    public Date getEditTime() {
        return editTime;
    }

    public void setEditTime(Date editTime) {
        this.editTime = editTime;
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


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        UhDcPiCrossIndex that = (UhDcPiCrossIndex) o;

        if (pkIndex != that.pkIndex) return false;
        if (empi != null ? !empi.equals(that.empi) : that.empi != null) return false;
        if (patiCode != null ? !patiCode.equals(that.patiCode) : that.patiCode != null) return false;
        if (localTypeCode != null ? !localTypeCode.equals(that.localTypeCode) : that.localTypeCode != null)
            return false;
        if (healthCardNo != null ? !healthCardNo.equals(that.healthCardNo) : that.healthCardNo != null) return false;
        if (oupatientNo != null ? !oupatientNo.equals(that.oupatientNo) : that.oupatientNo != null) return false;
        if (inpatientNo != null ? !inpatientNo.equals(that.inpatientNo) : that.inpatientNo != null) return false;
        if (insuranceNo != null ? !insuranceNo.equals(that.insuranceNo) : that.insuranceNo != null) return false;
        if (createTime != null ? !createTime.equals(that.createTime) : that.createTime != null) return false;
        if (flagDel != null ? !flagDel.equals(that.flagDel) : that.flagDel != null) return false;
        if (editTime != null ? !editTime.equals(that.editTime) : that.editTime != null) return false;
        if (codeGroup != null ? !codeGroup.equals(that.codeGroup) : that.codeGroup != null) return false;
        if (codeOrg != null ? !codeOrg.equals(that.codeOrg) : that.codeOrg != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = pkIndex;
        result = 31 * result + (empi != null ? empi.hashCode() : 0);
        result = 31 * result + (patiCode != null ? patiCode.hashCode() : 0);
        result = 31 * result + (localTypeCode != null ? localTypeCode.hashCode() : 0);
        result = 31 * result + (healthCardNo != null ? healthCardNo.hashCode() : 0);
        result = 31 * result + (oupatientNo != null ? oupatientNo.hashCode() : 0);
        result = 31 * result + (inpatientNo != null ? inpatientNo.hashCode() : 0);
        result = 31 * result + (insuranceNo != null ? insuranceNo.hashCode() : 0);
        result = 31 * result + (createTime != null ? createTime.hashCode() : 0);
        result = 31 * result + (flagDel != null ? flagDel.hashCode() : 0);
        result = 31 * result + (editTime != null ? editTime.hashCode() : 0);
        result = 31 * result + (codeGroup != null ? codeGroup.hashCode() : 0);
        result = 31 * result + (codeOrg != null ? codeOrg.hashCode() : 0);
        return result;
    }
}
