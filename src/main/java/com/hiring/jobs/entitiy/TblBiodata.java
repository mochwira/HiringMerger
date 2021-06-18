/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.hiring.jobs.entitiy;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author MELLA
 */
@Entity
@Table(name = "tbl_biodata")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TblBiodata.findAll", query = "SELECT t FROM TblBiodata t"),
    @NamedQuery(name = "TblBiodata.findByBiodataId", query = "SELECT t FROM TblBiodata t WHERE t.biodataId = :biodataId"),
    @NamedQuery(name = "TblBiodata.findByNama", query = "SELECT t FROM TblBiodata t WHERE t.nama = :nama"),
    @NamedQuery(name = "TblBiodata.findByEmail", query = "SELECT t FROM TblBiodata t WHERE t.email = :email"),
    @NamedQuery(name = "TblBiodata.findByNoHp", query = "SELECT t FROM TblBiodata t WHERE t.noHp = :noHp"),
    @NamedQuery(name = "TblBiodata.findByAlamat", query = "SELECT t FROM TblBiodata t WHERE t.alamat = :alamat"),
    @NamedQuery(name = "TblBiodata.findByJenKel", query = "SELECT t FROM TblBiodata t WHERE t.jenKel = :jenKel"),
    @NamedQuery(name = "TblBiodata.findByLinkSosmed", query = "SELECT t FROM TblBiodata t WHERE t.linkSosmed = :linkSosmed"),
    @NamedQuery(name = "TblBiodata.findByPendTerakhir", query = "SELECT t FROM TblBiodata t WHERE t.pendTerakhir = :pendTerakhir"),
    @NamedQuery(name = "TblBiodata.findByUniversitas", query = "SELECT t FROM TblBiodata t WHERE t.universitas = :universitas"),
    @NamedQuery(name = "TblBiodata.findByTahunMasuk", query = "SELECT t FROM TblBiodata t WHERE t.tahunMasuk = :tahunMasuk"),
    @NamedQuery(name = "TblBiodata.findByTahunLulus", query = "SELECT t FROM TblBiodata t WHERE t.tahunLulus = :tahunLulus"),
    @NamedQuery(name = "TblBiodata.findByIpk", query = "SELECT t FROM TblBiodata t WHERE t.ipk = :ipk"),
    @NamedQuery(name = "TblBiodata.findByTanggal", query = "SELECT t FROM TblBiodata t WHERE t.tanggal = :tanggal")})
public class TblBiodata implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "biodata_id")
    private Integer biodataId;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "nama")
    private String nama;
    // @Pattern(regexp="[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*@(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?", message="Invalid email")//if the field contains email address consider using this annotation to enforce field validation
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "email")
    private String email;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "no_hp")
    private String noHp;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "alamat")
    private String alamat;
    @Basic(optional = false)
    @NotNull
    @Column(name = "jen_kel")
    private boolean jenKel;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "link_sosmed")
    private String linkSosmed;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "pend_terakhir")
    private String pendTerakhir;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "universitas")
    private String universitas;
    @Basic(optional = false)
    @NotNull
    @Column(name = "tahun_masuk")
    @Temporal(TemporalType.DATE)
    private Date tahunMasuk;
    @Basic(optional = false)
    @NotNull
    @Column(name = "tahun_lulus")
    @Temporal(TemporalType.DATE)
    private Date tahunLulus;
    @Basic(optional = false)
    @NotNull
    @Column(name = "ipk")
    private double ipk;
    @Basic(optional = false)
    @NotNull
    @Column(name = "tanggal")
    @Temporal(TemporalType.DATE)
    private Date tanggal;
    @JoinColumn(name = "user_id", referencedColumnName = "user_id")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private TblUser userId;

    public TblBiodata() {
    }

    public TblBiodata(Integer biodataId) {
        this.biodataId = biodataId;
    }

    public TblBiodata(Integer biodataId, String nama, String email, String noHp, String alamat, boolean jenKel, String linkSosmed, String pendTerakhir, String universitas, Date tahunMasuk, Date tahunLulus, double ipk, Date tanggal) {
        this.biodataId = biodataId;
        this.nama = nama;
        this.email = email;
        this.noHp = noHp;
        this.alamat = alamat;
        this.jenKel = jenKel;
        this.linkSosmed = linkSosmed;
        this.pendTerakhir = pendTerakhir;
        this.universitas = universitas;
        this.tahunMasuk = tahunMasuk;
        this.tahunLulus = tahunLulus;
        this.ipk = ipk;
        this.tanggal = tanggal;
    }

    public Integer getBiodataId() {
        return biodataId;
    }

    public void setBiodataId(Integer biodataId) {
        this.biodataId = biodataId;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getNoHp() {
        return noHp;
    }

    public void setNoHp(String noHp) {
        this.noHp = noHp;
    }

    public String getAlamat() {
        return alamat;
    }

    public void setAlamat(String alamat) {
        this.alamat = alamat;
    }

    public boolean getJenKel() {
        return jenKel;
    }

    public void setJenKel(boolean jenKel) {
        this.jenKel = jenKel;
    }

    public String getLinkSosmed() {
        return linkSosmed;
    }

    public void setLinkSosmed(String linkSosmed) {
        this.linkSosmed = linkSosmed;
    }

    public String getPendTerakhir() {
        return pendTerakhir;
    }

    public void setPendTerakhir(String pendTerakhir) {
        this.pendTerakhir = pendTerakhir;
    }

    public String getUniversitas() {
        return universitas;
    }

    public void setUniversitas(String universitas) {
        this.universitas = universitas;
    }

    public Date getTahunMasuk() {
        return tahunMasuk;
    }

    public void setTahunMasuk(Date tahunMasuk) {
        this.tahunMasuk = tahunMasuk;
    }

    public Date getTahunLulus() {
        return tahunLulus;
    }

    public void setTahunLulus(Date tahunLulus) {
        this.tahunLulus = tahunLulus;
    }

    public double getIpk() {
        return ipk;
    }

    public void setIpk(double ipk) {
        this.ipk = ipk;
    }

    public Date getTanggal() {
        return tanggal;
    }

    public void setTanggal(Date tanggal) {
        this.tanggal = tanggal;
    }

    public TblUser getUserId() {
        return userId;
    }

    public void setUserId(TblUser userId) {
        this.userId = userId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (biodataId != null ? biodataId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TblBiodata)) {
            return false;
        }
        TblBiodata other = (TblBiodata) object;
        if ((this.biodataId == null && other.biodataId != null) || (this.biodataId != null && !this.biodataId.equals(other.biodataId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.hiring.jobs.entitiy.TblBiodata[ biodataId=" + biodataId + " ]";
    }
    
}
