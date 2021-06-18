/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.hiring.jobs.entitiy;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
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
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author MELLA
 */
@Entity
@Table(name = "tbl_job")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TblJob.findAll", query = "SELECT t FROM TblJob t"),
    @NamedQuery(name = "TblJob.findByJobId", query = "SELECT t FROM TblJob t WHERE t.jobId = :jobId"),
    @NamedQuery(name = "TblJob.findByJobNama", query = "SELECT t FROM TblJob t WHERE t.jobNama = :jobNama"),
    @NamedQuery(name = "TblJob.findByJobKriteria", query = "SELECT t FROM TblJob t WHERE t.jobKriteria = :jobKriteria"),
    @NamedQuery(name = "TblJob.findByJobDeskripsi", query = "SELECT t FROM TblJob t WHERE t.jobDeskripsi = :jobDeskripsi")})
public class TblJob implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "job_id")
    private Integer jobId;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "job_nama")
    private String jobNama;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "job_kriteria")
    private String jobKriteria;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "job_deskripsi")
    private String jobDeskripsi;
    @JoinColumn(name = "departement_id", referencedColumnName = "departement_id")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private TblDepartement departementId;
    @JoinColumn(name = "hrd_id", referencedColumnName = "user_id")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private TblUser hrdId;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "jobId", fetch = FetchType.LAZY)
    private List<TblApplication> tblApplicationList;

    public TblJob() {
    }

    public TblJob(Integer jobId) {
        this.jobId = jobId;
    }

    public TblJob(Integer jobId, String jobNama, String jobKriteria, String jobDeskripsi) {
        this.jobId = jobId;
        this.jobNama = jobNama;
        this.jobKriteria = jobKriteria;
        this.jobDeskripsi = jobDeskripsi;
    }

    public Integer getJobId() {
        return jobId;
    }

    public void setJobId(Integer jobId) {
        this.jobId = jobId;
    }

    public String getJobNama() {
        return jobNama;
    }

    public void setJobNama(String jobNama) {
        this.jobNama = jobNama;
    }

    public String getJobKriteria() {
        return jobKriteria;
    }

    public void setJobKriteria(String jobKriteria) {
        this.jobKriteria = jobKriteria;
    }

    public String getJobDeskripsi() {
        return jobDeskripsi;
    }

    public void setJobDeskripsi(String jobDeskripsi) {
        this.jobDeskripsi = jobDeskripsi;
    }

    public TblDepartement getDepartementId() {
        return departementId;
    }

    public void setDepartementId(TblDepartement departementId) {
        this.departementId = departementId;
    }

    public TblUser getHrdId() {
        return hrdId;
    }

    public void setHrdId(TblUser hrdId) {
        this.hrdId = hrdId;
    }

    @XmlTransient
    public List<TblApplication> getTblApplicationList() {
        return tblApplicationList;
    }

    public void setTblApplicationList(List<TblApplication> tblApplicationList) {
        this.tblApplicationList = tblApplicationList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (jobId != null ? jobId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TblJob)) {
            return false;
        }
        TblJob other = (TblJob) object;
        if ((this.jobId == null && other.jobId != null) || (this.jobId != null && !this.jobId.equals(other.jobId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.hiring.jobs.entitiy.TblJob[ jobId=" + jobId + " ]";
    }
    
}
