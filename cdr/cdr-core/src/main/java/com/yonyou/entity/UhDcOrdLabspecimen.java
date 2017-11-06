package com.yonyou.entity;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.Date;

/**
 * @author chenpana@yonyou.com
 * @ClassName: UhDcOrdLabspecimen
 * @Description:
 * @date 2017/7/10 17:17
 */
@Entity
@Table(name = "uh_dc_ord_labspecimen", schema = "dbo", catalog = "MIP_DC_DEMO")
public class UhDcOrdLabspecimen {

    private String pkLabspecimen;
    private String pkOrdRecord;
    private String codeGroup;
    private String codeOrg;
    private String empi;
    private String codePati;
    private String codeRep;
    private String codeSamptype;
    private String nameSamptype;
    private String codeColl;
    private String nameColl;
    private String codeContype;
    private String nameContype;
    private String codeSamp;
    private String nameSamp;
    private String codeDeptColl;
    private String nameDeptColl;
    private String codePsnColl;
    private String namePsnColl;
    private String acqTime;
    private String codeCurryPsn;
    private String nameCurryPsn;
    private String dateCurry;
    private String codePsnRec;
    private String namePsnRec;
    private String dateRec;
    private String dataSource;
    private String sourcePk;
    private Date createTime;
    private Date editTime;
    private String flagDel;

    @Id
    @Column(name = "pk_labspecimen")
    @GenericGenerator(name = "system-uuid", strategy = "uuid")
    @GeneratedValue(generator = "system-uuid")
    public String getPkLabspecimen() {
        return pkLabspecimen;
    }

    public void setPkLabspecimen(String pkLabspecimen) {
        this.pkLabspecimen = pkLabspecimen;
    }

    @Basic
    @Column(name = "pk_ord_record")
    public String getPkOrdRecord() {
        return pkOrdRecord;
    }

    public void setPkOrdRecord(String pkOrdRecord) {
        this.pkOrdRecord = pkOrdRecord;
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
    @Column(name = "code_rep")
    public String getCodeRep() {
        return codeRep;
    }

    public void setCodeRep(String codeRep) {
        this.codeRep = codeRep;
    }

    @Basic
    @Column(name = "code_samptype")
    public String getCodeSamptype() {
        return codeSamptype;
    }

    public void setCodeSamptype(String codeSamptype) {
        this.codeSamptype = codeSamptype;
    }

    @Basic
    @Column(name = "name_samptype")
    public String getNameSamptype() {
        return nameSamptype;
    }

    public void setNameSamptype(String nameSamptype) {
        this.nameSamptype = nameSamptype;
    }

    @Basic
    @Column(name = "code_coll")
    public String getCodeColl() {
        return codeColl;
    }

    public void setCodeColl(String codeColl) {
        this.codeColl = codeColl;
    }

    @Basic
    @Column(name = "name_coll")
    public String getNameColl() {
        return nameColl;
    }

    public void setNameColl(String nameColl) {
        this.nameColl = nameColl;
    }

    @Basic
    @Column(name = "code_contype")
    public String getCodeContype() {
        return codeContype;
    }

    public void setCodeContype(String codeContype) {
        this.codeContype = codeContype;
    }

    @Basic
    @Column(name = "name_contype")
    public String getNameContype() {
        return nameContype;
    }

    public void setNameContype(String nameContype) {
        this.nameContype = nameContype;
    }

    @Basic
    @Column(name = "code_samp")
    public String getCodeSamp() {
        return codeSamp;
    }

    public void setCodeSamp(String codeSamp) {
        this.codeSamp = codeSamp;
    }

    @Basic
    @Column(name = "name_samp")
    public String getNameSamp() {
        return nameSamp;
    }

    public void setNameSamp(String nameSamp) {
        this.nameSamp = nameSamp;
    }

    @Basic
    @Column(name = "code_dept_coll")
    public String getCodeDeptColl() {
        return codeDeptColl;
    }

    public void setCodeDeptColl(String codeDeptColl) {
        this.codeDeptColl = codeDeptColl;
    }

    @Basic
    @Column(name = "name_dept_coll")
    public String getNameDeptColl() {
        return nameDeptColl;
    }

    public void setNameDeptColl(String nameDeptColl) {
        this.nameDeptColl = nameDeptColl;
    }

    @Basic
    @Column(name = "code_psn_coll")
    public String getCodePsnColl() {
        return codePsnColl;
    }

    public void setCodePsnColl(String codePsnColl) {
        this.codePsnColl = codePsnColl;
    }

    @Basic
    @Column(name = "name_psn_coll")
    public String getNamePsnColl() {
        return namePsnColl;
    }

    public void setNamePsnColl(String namePsnColl) {
        this.namePsnColl = namePsnColl;
    }

    @Basic
    @Column(name = "acq_time")
    public String getAcqTime() {
        return acqTime;
    }

    public void setAcqTime(String acqTime) {
        this.acqTime = acqTime;
    }

    @Basic
    @Column(name = "code_curry_psn")
    public String getCodeCurryPsn() {
        return codeCurryPsn;
    }

    public void setCodeCurryPsn(String codeCurryPsn) {
        this.codeCurryPsn = codeCurryPsn;
    }

    @Basic
    @Column(name = "name_curry_psn")
    public String getNameCurryPsn() {
        return nameCurryPsn;
    }

    public void setNameCurryPsn(String nameCurryPsn) {
        this.nameCurryPsn = nameCurryPsn;
    }

    @Basic
    @Column(name = "date_curry")
    public String getDateCurry() {
        return dateCurry;
    }

    public void setDateCurry(String dateCurry) {
        this.dateCurry = dateCurry;
    }

    @Basic
    @Column(name = "code_psn_rec")
    public String getCodePsnRec() {
        return codePsnRec;
    }

    public void setCodePsnRec(String codePsnRec) {
        this.codePsnRec = codePsnRec;
    }

    @Basic
    @Column(name = "name_psn_rec")
    public String getNamePsnRec() {
        return namePsnRec;
    }

    public void setNamePsnRec(String namePsnRec) {
        this.namePsnRec = namePsnRec;
    }

    @Basic
    @Column(name = "date_rec")
    public String getDateRec() {
        return dateRec;
    }

    public void setDateRec(String dateRec) {
        this.dateRec = dateRec;
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

        UhDcOrdLabspecimen that = (UhDcOrdLabspecimen) o;

        if (pkLabspecimen != null ? !pkLabspecimen.equals(that.pkLabspecimen) : that.pkLabspecimen != null)
            return false;
        if (pkOrdRecord != null ? !pkOrdRecord.equals(that.pkOrdRecord) : that.pkOrdRecord != null) return false;
        if (codeGroup != null ? !codeGroup.equals(that.codeGroup) : that.codeGroup != null) return false;
        if (codeOrg != null ? !codeOrg.equals(that.codeOrg) : that.codeOrg != null) return false;
        if (empi != null ? !empi.equals(that.empi) : that.empi != null) return false;
        if (codePati != null ? !codePati.equals(that.codePati) : that.codePati != null) return false;
        if (codeRep != null ? !codeRep.equals(that.codeRep) : that.codeRep != null) return false;
        if (codeSamptype != null ? !codeSamptype.equals(that.codeSamptype) : that.codeSamptype != null) return false;
        if (nameSamptype != null ? !nameSamptype.equals(that.nameSamptype) : that.nameSamptype != null) return false;
        if (codeColl != null ? !codeColl.equals(that.codeColl) : that.codeColl != null) return false;
        if (nameColl != null ? !nameColl.equals(that.nameColl) : that.nameColl != null) return false;
        if (codeContype != null ? !codeContype.equals(that.codeContype) : that.codeContype != null) return false;
        if (nameContype != null ? !nameContype.equals(that.nameContype) : that.nameContype != null) return false;
        if (codeSamp != null ? !codeSamp.equals(that.codeSamp) : that.codeSamp != null) return false;
        if (nameSamp != null ? !nameSamp.equals(that.nameSamp) : that.nameSamp != null) return false;
        if (codeDeptColl != null ? !codeDeptColl.equals(that.codeDeptColl) : that.codeDeptColl != null) return false;
        if (nameDeptColl != null ? !nameDeptColl.equals(that.nameDeptColl) : that.nameDeptColl != null) return false;
        if (codePsnColl != null ? !codePsnColl.equals(that.codePsnColl) : that.codePsnColl != null) return false;
        if (namePsnColl != null ? !namePsnColl.equals(that.namePsnColl) : that.namePsnColl != null) return false;
        if (acqTime != null ? !acqTime.equals(that.acqTime) : that.acqTime != null) return false;
        if (codeCurryPsn != null ? !codeCurryPsn.equals(that.codeCurryPsn) : that.codeCurryPsn != null) return false;
        if (nameCurryPsn != null ? !nameCurryPsn.equals(that.nameCurryPsn) : that.nameCurryPsn != null) return false;
        if (dateCurry != null ? !dateCurry.equals(that.dateCurry) : that.dateCurry != null) return false;
        if (codePsnRec != null ? !codePsnRec.equals(that.codePsnRec) : that.codePsnRec != null) return false;
        if (namePsnRec != null ? !namePsnRec.equals(that.namePsnRec) : that.namePsnRec != null) return false;
        if (dateRec != null ? !dateRec.equals(that.dateRec) : that.dateRec != null) return false;
        if (dataSource != null ? !dataSource.equals(that.dataSource) : that.dataSource != null) return false;
        if (sourcePk != null ? !sourcePk.equals(that.sourcePk) : that.sourcePk != null) return false;
        if (createTime != null ? !createTime.equals(that.createTime) : that.createTime != null) return false;
        if (editTime != null ? !editTime.equals(that.editTime) : that.editTime != null) return false;
        if (flagDel != null ? !flagDel.equals(that.flagDel) : that.flagDel != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = pkLabspecimen != null ? pkLabspecimen.hashCode() : 0;
        result = 31 * result + (pkOrdRecord != null ? pkOrdRecord.hashCode() : 0);
        result = 31 * result + (codeGroup != null ? codeGroup.hashCode() : 0);
        result = 31 * result + (codeOrg != null ? codeOrg.hashCode() : 0);
        result = 31 * result + (empi != null ? empi.hashCode() : 0);
        result = 31 * result + (codePati != null ? codePati.hashCode() : 0);
        result = 31 * result + (codeRep != null ? codeRep.hashCode() : 0);
        result = 31 * result + (codeSamptype != null ? codeSamptype.hashCode() : 0);
        result = 31 * result + (nameSamptype != null ? nameSamptype.hashCode() : 0);
        result = 31 * result + (codeColl != null ? codeColl.hashCode() : 0);
        result = 31 * result + (nameColl != null ? nameColl.hashCode() : 0);
        result = 31 * result + (codeContype != null ? codeContype.hashCode() : 0);
        result = 31 * result + (nameContype != null ? nameContype.hashCode() : 0);
        result = 31 * result + (codeSamp != null ? codeSamp.hashCode() : 0);
        result = 31 * result + (nameSamp != null ? nameSamp.hashCode() : 0);
        result = 31 * result + (codeDeptColl != null ? codeDeptColl.hashCode() : 0);
        result = 31 * result + (nameDeptColl != null ? nameDeptColl.hashCode() : 0);
        result = 31 * result + (codePsnColl != null ? codePsnColl.hashCode() : 0);
        result = 31 * result + (namePsnColl != null ? namePsnColl.hashCode() : 0);
        result = 31 * result + (acqTime != null ? acqTime.hashCode() : 0);
        result = 31 * result + (codeCurryPsn != null ? codeCurryPsn.hashCode() : 0);
        result = 31 * result + (nameCurryPsn != null ? nameCurryPsn.hashCode() : 0);
        result = 31 * result + (dateCurry != null ? dateCurry.hashCode() : 0);
        result = 31 * result + (codePsnRec != null ? codePsnRec.hashCode() : 0);
        result = 31 * result + (namePsnRec != null ? namePsnRec.hashCode() : 0);
        result = 31 * result + (dateRec != null ? dateRec.hashCode() : 0);
        result = 31 * result + (dataSource != null ? dataSource.hashCode() : 0);
        result = 31 * result + (sourcePk != null ? sourcePk.hashCode() : 0);
        result = 31 * result + (createTime != null ? createTime.hashCode() : 0);
        result = 31 * result + (editTime != null ? editTime.hashCode() : 0);
        result = 31 * result + (flagDel != null ? flagDel.hashCode() : 0);
        return result;
    }
}
