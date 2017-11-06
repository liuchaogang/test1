package com.yonyou.entity;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

/**
 * @author chenpana@yonyou.com
 * @ClassName: UhDcOrdLisRecord
 * @Description:
 * @date 2017/7/10 17:17
 */
@Entity
@Table(name = "uh_dc_ord_lis_record", schema = "dbo", catalog = "MIP_DC_DEMO")
public class UhDcOrdLisRecord {

    private String pkRepLis;
    private String pkOrdRecord;
    private String codeGroup;
    private String codeOrg;
    private String codeRep;
    private String codeTypeLis;
    private String nameTypeLis;
    private String codeMethodLis;
    private String nameMethodLis;
    private String dateLab;
    private String codeDiag;
    private String nameDiag;
    private String diagDate;
    private String resultRep;
    private String codeResult;
    private String nameResult;
    private String noteRep;
    private String dataSource;
    private String sourcePk;
    private Date createTime;
    private Date editTime;
    private String flagDel;

/*    @OneToMany(targetEntity = UhDcOrdLisitem.class,cascade = CascadeType.ALL)
    @JoinColumn(name = "pk_rep_lis")
    private List<UhDcOrdLisitem> uhDcOrdLisitem;*/

    @Id
    @Column(name = "pk_rep_lis")
    @GenericGenerator(name = "system-uuid", strategy = "uuid")
    @GeneratedValue(generator = "system-uuid")
    public String getPkRepLis() {
        return pkRepLis;
    }

    public void setPkRepLis(String pkRepLis) {
        this.pkRepLis = pkRepLis;
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
    @Column(name = "code_rep")
    public String getCodeRep() {
        return codeRep;
    }

    public void setCodeRep(String codeRep) {
        this.codeRep = codeRep;
    }

    @Basic
    @Column(name = "code_type_lis")
    public String getCodeTypeLis() {
        return codeTypeLis;
    }

    public void setCodeTypeLis(String codeTypeLis) {
        this.codeTypeLis = codeTypeLis;
    }

    @Basic
    @Column(name = "name_type_lis")
    public String getNameTypeLis() {
        return nameTypeLis;
    }

    public void setNameTypeLis(String nameTypeLis) {
        this.nameTypeLis = nameTypeLis;
    }

    @Basic
    @Column(name = "code_method_lis")
    public String getCodeMethodLis() {
        return codeMethodLis;
    }

    public void setCodeMethodLis(String codeMethodLis) {
        this.codeMethodLis = codeMethodLis;
    }

    @Basic
    @Column(name = "name_method_lis")
    public String getNameMethodLis() {
        return nameMethodLis;
    }

    public void setNameMethodLis(String nameMethodLis) {
        this.nameMethodLis = nameMethodLis;
    }

    @Basic
    @Column(name = "date_lab")
    public String getDateLab() {
        return dateLab;
    }

    public void setDateLab(String dateLab) {
        this.dateLab = dateLab;
    }

    @Basic
    @Column(name = "code_diag")
    public String getCodeDiag() {
        return codeDiag;
    }

    public void setCodeDiag(String codeDiag) {
        this.codeDiag = codeDiag;
    }

    @Basic
    @Column(name = "name_diag")
    public String getNameDiag() {
        return nameDiag;
    }

    public void setNameDiag(String nameDiag) {
        this.nameDiag = nameDiag;
    }

    @Basic
    @Column(name = "diag_date")
    public String getDiagDate() {
        return diagDate;
    }

    public void setDiagDate(String diagDate) {
        this.diagDate = diagDate;
    }

    @Basic
    @Column(name = "result_rep")
    public String getResultRep() {
        return resultRep;
    }

    public void setResultRep(String resultRep) {
        this.resultRep = resultRep;
    }

    @Basic
    @Column(name = "code_result")
    public String getCodeResult() {
        return codeResult;
    }

    public void setCodeResult(String codeResult) {
        this.codeResult = codeResult;
    }

    @Basic
    @Column(name = "name_result")
    public String getNameResult() {
        return nameResult;
    }

    public void setNameResult(String nameResult) {
        this.nameResult = nameResult;
    }

    @Basic
    @Column(name = "note_rep")
    public String getNoteRep() {
        return noteRep;
    }

    public void setNoteRep(String noteRep) {
        this.noteRep = noteRep;
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

        UhDcOrdLisRecord that = (UhDcOrdLisRecord) o;

        if (pkRepLis != null ? !pkRepLis.equals(that.pkRepLis) : that.pkRepLis != null) return false;
        if (pkOrdRecord != null ? !pkOrdRecord.equals(that.pkOrdRecord) : that.pkOrdRecord != null) return false;
        if (codeGroup != null ? !codeGroup.equals(that.codeGroup) : that.codeGroup != null) return false;
        if (codeOrg != null ? !codeOrg.equals(that.codeOrg) : that.codeOrg != null) return false;
        if (codeRep != null ? !codeRep.equals(that.codeRep) : that.codeRep != null) return false;
        if (codeTypeLis != null ? !codeTypeLis.equals(that.codeTypeLis) : that.codeTypeLis != null) return false;
        if (nameTypeLis != null ? !nameTypeLis.equals(that.nameTypeLis) : that.nameTypeLis != null) return false;
        if (codeMethodLis != null ? !codeMethodLis.equals(that.codeMethodLis) : that.codeMethodLis != null)
            return false;
        if (nameMethodLis != null ? !nameMethodLis.equals(that.nameMethodLis) : that.nameMethodLis != null)
            return false;
        if (dateLab != null ? !dateLab.equals(that.dateLab) : that.dateLab != null) return false;
        if (codeDiag != null ? !codeDiag.equals(that.codeDiag) : that.codeDiag != null) return false;
        if (nameDiag != null ? !nameDiag.equals(that.nameDiag) : that.nameDiag != null) return false;
        if (diagDate != null ? !diagDate.equals(that.diagDate) : that.diagDate != null) return false;
        if (resultRep != null ? !resultRep.equals(that.resultRep) : that.resultRep != null) return false;
        if (codeResult != null ? !codeResult.equals(that.codeResult) : that.codeResult != null) return false;
        if (nameResult != null ? !nameResult.equals(that.nameResult) : that.nameResult != null) return false;
        if (noteRep != null ? !noteRep.equals(that.noteRep) : that.noteRep != null) return false;
        if (dataSource != null ? !dataSource.equals(that.dataSource) : that.dataSource != null) return false;
        if (sourcePk != null ? !sourcePk.equals(that.sourcePk) : that.sourcePk != null) return false;
        if (createTime != null ? !createTime.equals(that.createTime) : that.createTime != null) return false;
        if (editTime != null ? !editTime.equals(that.editTime) : that.editTime != null) return false;
        if (flagDel != null ? !flagDel.equals(that.flagDel) : that.flagDel != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = pkRepLis != null ? pkRepLis.hashCode() : 0;
        result = 31 * result + (pkOrdRecord != null ? pkOrdRecord.hashCode() : 0);
        result = 31 * result + (codeGroup != null ? codeGroup.hashCode() : 0);
        result = 31 * result + (codeOrg != null ? codeOrg.hashCode() : 0);
        result = 31 * result + (codeRep != null ? codeRep.hashCode() : 0);
        result = 31 * result + (codeTypeLis != null ? codeTypeLis.hashCode() : 0);
        result = 31 * result + (nameTypeLis != null ? nameTypeLis.hashCode() : 0);
        result = 31 * result + (codeMethodLis != null ? codeMethodLis.hashCode() : 0);
        result = 31 * result + (nameMethodLis != null ? nameMethodLis.hashCode() : 0);
        result = 31 * result + (dateLab != null ? dateLab.hashCode() : 0);
        result = 31 * result + (codeDiag != null ? codeDiag.hashCode() : 0);
        result = 31 * result + (nameDiag != null ? nameDiag.hashCode() : 0);
        result = 31 * result + (diagDate != null ? diagDate.hashCode() : 0);
        result = 31 * result + (resultRep != null ? resultRep.hashCode() : 0);
        result = 31 * result + (codeResult != null ? codeResult.hashCode() : 0);
        result = 31 * result + (nameResult != null ? nameResult.hashCode() : 0);
        result = 31 * result + (noteRep != null ? noteRep.hashCode() : 0);
        result = 31 * result + (dataSource != null ? dataSource.hashCode() : 0);
        result = 31 * result + (sourcePk != null ? sourcePk.hashCode() : 0);
        result = 31 * result + (createTime != null ? createTime.hashCode() : 0);
        result = 31 * result + (editTime != null ? editTime.hashCode() : 0);
        result = 31 * result + (flagDel != null ? flagDel.hashCode() : 0);
        return result;
    }
}
