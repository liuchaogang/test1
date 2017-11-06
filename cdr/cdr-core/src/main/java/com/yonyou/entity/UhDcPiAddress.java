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
 * @ClassName: UhDcPiAddress
 * @Description:
 * @date 2017/6/28 14:04
 */
@Entity
@Table(name = "uh_dc_pi_address", schema = "dbo", catalog = "MIP_DC_DEMO")
public class UhDcPiAddress {

    private int pkAddr;
    private String pkPati;
    private String codeGroup;
    private String codeOrg;
    private String codeAddrType;
    private String nameAddrType;
    private String addrProv;
    private String addrCity;
    private String addrCounty;
    private String addrCountry;
    private String addrVillage;
    private String addrHouseNum;
    private String nostructureAddr;
    private String addrZipcode;
    private String dataSource;
    private String sourcePk;
    private Date createTime;
    private Date editTime;
    private String flagDel;

    @Id
    @Column(name = "pk_addr")
    @GeneratedValue()
    public int getPkAddr() {
        return pkAddr;
    }

    public void setPkAddr(int pkAddr) {
        this.pkAddr = pkAddr;
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
    @Column(name = "code_addr_type")
    public String getCodeAddrType() {
        return codeAddrType;
    }

    public void setCodeAddrType(String codeAddrType) {
        this.codeAddrType = codeAddrType;
    }

    @Basic
    @Column(name = "name_addr_type")
    public String getNameAddrType() {
        return nameAddrType;
    }

    public void setNameAddrType(String nameAddrType) {
        this.nameAddrType = nameAddrType;
    }

    @Basic
    @Column(name = "addr_prov")
    public String getAddrProv() {
        return addrProv;
    }

    public void setAddrProv(String addrProv) {
        this.addrProv = addrProv;
    }

    @Basic
    @Column(name = "addr_city")
    public String getAddrCity() {
        return addrCity;
    }

    public void setAddrCity(String addrCity) {
        this.addrCity = addrCity;
    }

    @Basic
    @Column(name = "addr_county")
    public String getAddrCounty() {
        return addrCounty;
    }

    public void setAddrCounty(String addrCounty) {
        this.addrCounty = addrCounty;
    }

    @Basic
    @Column(name = "addr_country")
    public String getAddrCountry() {
        return addrCountry;
    }

    public void setAddrCountry(String addrCountry) {
        this.addrCountry = addrCountry;
    }

    @Basic
    @Column(name = "addr_village")
    public String getAddrVillage() {
        return addrVillage;
    }

    public void setAddrVillage(String addrVillage) {
        this.addrVillage = addrVillage;
    }

    @Basic
    @Column(name = "addr_house_num")
    public String getAddrHouseNum() {
        return addrHouseNum;
    }

    public void setAddrHouseNum(String addrHouseNum) {
        this.addrHouseNum = addrHouseNum;
    }

    @Basic
    @Column(name = "nostructure_addr")
    public String getNostructureAddr() {
        return nostructureAddr;
    }

    public void setNostructureAddr(String nostructureAddr) {
        this.nostructureAddr = nostructureAddr;
    }

    @Basic
    @Column(name = "addr_zipcode")
    public String getAddrZipcode() {
        return addrZipcode;
    }

    public void setAddrZipcode(String addrZipcode) {
        this.addrZipcode = addrZipcode;
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

        UhDcPiAddress piAddress = (UhDcPiAddress) o;

        if (pkAddr != piAddress.pkAddr) return false;
        if (pkPati != null ? !pkPati.equals(piAddress.pkPati) : piAddress.pkPati != null) return false;
        if (codeGroup != null ? !codeGroup.equals(piAddress.codeGroup) : piAddress.codeGroup != null) return false;
        if (codeOrg != null ? !codeOrg.equals(piAddress.codeOrg) : piAddress.codeOrg != null) return false;
        if (codeAddrType != null ? !codeAddrType.equals(piAddress.codeAddrType) : piAddress.codeAddrType != null)
            return false;
        if (nameAddrType != null ? !nameAddrType.equals(piAddress.nameAddrType) : piAddress.nameAddrType != null)
            return false;
        if (addrProv != null ? !addrProv.equals(piAddress.addrProv) : piAddress.addrProv != null) return false;
        if (addrCity != null ? !addrCity.equals(piAddress.addrCity) : piAddress.addrCity != null) return false;
        if (addrCounty != null ? !addrCounty.equals(piAddress.addrCounty) : piAddress.addrCounty != null) return false;
        if (addrCountry != null ? !addrCountry.equals(piAddress.addrCountry) : piAddress.addrCountry != null)
            return false;
        if (addrVillage != null ? !addrVillage.equals(piAddress.addrVillage) : piAddress.addrVillage != null)
            return false;
        if (addrHouseNum != null ? !addrHouseNum.equals(piAddress.addrHouseNum) : piAddress.addrHouseNum != null)
            return false;
        if (nostructureAddr != null ? !nostructureAddr.equals(piAddress.nostructureAddr) : piAddress.nostructureAddr != null)
            return false;
        if (addrZipcode != null ? !addrZipcode.equals(piAddress.addrZipcode) : piAddress.addrZipcode != null)
            return false;
        if (dataSource != null ? !dataSource.equals(piAddress.dataSource) : piAddress.dataSource != null) return false;
        if (sourcePk != null ? !sourcePk.equals(piAddress.sourcePk) : piAddress.sourcePk != null) return false;
        if (createTime != null ? !createTime.equals(piAddress.createTime) : piAddress.createTime != null) return false;
        if (editTime != null ? !editTime.equals(piAddress.editTime) : piAddress.editTime != null) return false;
        if (flagDel != null ? !flagDel.equals(piAddress.flagDel) : piAddress.flagDel != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = pkAddr;
        result = 31 * result + (pkPati != null ? pkPati.hashCode() : 0);
        result = 31 * result + (codeGroup != null ? codeGroup.hashCode() : 0);
        result = 31 * result + (codeOrg != null ? codeOrg.hashCode() : 0);
        result = 31 * result + (codeAddrType != null ? codeAddrType.hashCode() : 0);
        result = 31 * result + (nameAddrType != null ? nameAddrType.hashCode() : 0);
        result = 31 * result + (addrProv != null ? addrProv.hashCode() : 0);
        result = 31 * result + (addrCity != null ? addrCity.hashCode() : 0);
        result = 31 * result + (addrCounty != null ? addrCounty.hashCode() : 0);
        result = 31 * result + (addrCountry != null ? addrCountry.hashCode() : 0);
        result = 31 * result + (addrVillage != null ? addrVillage.hashCode() : 0);
        result = 31 * result + (addrHouseNum != null ? addrHouseNum.hashCode() : 0);
        result = 31 * result + (nostructureAddr != null ? nostructureAddr.hashCode() : 0);
        result = 31 * result + (addrZipcode != null ? addrZipcode.hashCode() : 0);
        result = 31 * result + (dataSource != null ? dataSource.hashCode() : 0);
        result = 31 * result + (sourcePk != null ? sourcePk.hashCode() : 0);
        result = 31 * result + (createTime != null ? createTime.hashCode() : 0);
        result = 31 * result + (editTime != null ? editTime.hashCode() : 0);
        result = 31 * result + (flagDel != null ? flagDel.hashCode() : 0);
        return result;
    }
}
