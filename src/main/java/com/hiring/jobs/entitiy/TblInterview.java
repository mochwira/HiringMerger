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
@Table(name = "tbl_interview")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TblInterview.findAll", query = "SELECT t FROM TblInterview t"),
    @NamedQuery(name = "TblInterview.findByInterviewId", query = "SELECT t FROM TblInterview t WHERE t.interviewId = :interviewId"),
    @NamedQuery(name = "TblInterview.findByInterviewLink", query = "SELECT t FROM TblInterview t WHERE t.interviewLink = :interviewLink"),
    @NamedQuery(name = "TblInterview.findByInterviewJadwal", query = "SELECT t FROM TblInterview t WHERE t.interviewJadwal = :interviewJadwal")})
public class TblInterview implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "interview_id")
    private Integer interviewId;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "interview_link")
    private String interviewLink;
    @Basic(optional = false)
    @NotNull
    @Column(name = "interview_jadwal")
    @Temporal(TemporalType.DATE)
    private Date interviewJadwal;
    @JoinColumn(name = "candidate_id", referencedColumnName = "user_id")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private TblUser candidateId;
    @JoinColumn(name = "interviewer_d", referencedColumnName = "user_id")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private TblUser interviewerD;

    public TblInterview() {
    }

    public TblInterview(Integer interviewId) {
        this.interviewId = interviewId;
    }

    public TblInterview(Integer interviewId, String interviewLink, Date interviewJadwal) {
        this.interviewId = interviewId;
        this.interviewLink = interviewLink;
        this.interviewJadwal = interviewJadwal;
    }

    public Integer getInterviewId() {
        return interviewId;
    }

    public void setInterviewId(Integer interviewId) {
        this.interviewId = interviewId;
    }

    public String getInterviewLink() {
        return interviewLink;
    }

    public void setInterviewLink(String interviewLink) {
        this.interviewLink = interviewLink;
    }

    public Date getInterviewJadwal() {
        return interviewJadwal;
    }

    public void setInterviewJadwal(Date interviewJadwal) {
        this.interviewJadwal = interviewJadwal;
    }

    public TblUser getCandidateId() {
        return candidateId;
    }

    public void setCandidateId(TblUser candidateId) {
        this.candidateId = candidateId;
    }

    public TblUser getInterviewerD() {
        return interviewerD;
    }

    public void setInterviewerD(TblUser interviewerD) {
        this.interviewerD = interviewerD;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (interviewId != null ? interviewId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TblInterview)) {
            return false;
        }
        TblInterview other = (TblInterview) object;
        if ((this.interviewId == null && other.interviewId != null) || (this.interviewId != null && !this.interviewId.equals(other.interviewId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.hiring.jobs.entitiy.TblInterview[ interviewId=" + interviewId + " ]";
    }
    
}
