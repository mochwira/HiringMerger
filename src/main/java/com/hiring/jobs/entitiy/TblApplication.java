/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.hiring.jobs.entitiy;

import java.io.Serializable;
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
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author MELLA
 */
@Entity
@Table(name = "tbl_application")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TblApplication.findAll", query = "SELECT t FROM TblApplication t"),
    @NamedQuery(name = "TblApplication.findByApplicationId", query = "SELECT t FROM TblApplication t WHERE t.applicationId = :applicationId")})
public class TblApplication implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "application_id")
    private Integer applicationId;
    @JoinColumn(name = "candidate_id", referencedColumnName = "user_id")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private TblUser candidateId;
    @JoinColumn(name = "job_id", referencedColumnName = "job_id")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private TblJob jobId;
    @JoinColumn(name = "status_id", referencedColumnName = "status_id")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private TblApplicationStatus statusId;

    public TblApplication() {
    }

    public TblApplication(Integer applicationId) {
        this.applicationId = applicationId;
    }

    public Integer getApplicationId() {
        return applicationId;
    }

    public void setApplicationId(Integer applicationId) {
        this.applicationId = applicationId;
    }

    public TblUser getCandidateId() {
        return candidateId;
    }

    public void setCandidateId(TblUser candidateId) {
        this.candidateId = candidateId;
    }

    public TblJob getJobId() {
        return jobId;
    }

    public void setJobId(TblJob jobId) {
        this.jobId = jobId;
    }

    public TblApplicationStatus getStatusId() {
        return statusId;
    }

    public void setStatusId(TblApplicationStatus statusId) {
        this.statusId = statusId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (applicationId != null ? applicationId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TblApplication)) {
            return false;
        }
        TblApplication other = (TblApplication) object;
        if ((this.applicationId == null && other.applicationId != null) || (this.applicationId != null && !this.applicationId.equals(other.applicationId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.hiring.jobs.entitiy.TblApplication[ applicationId=" + applicationId + " ]";
    }
    
}
