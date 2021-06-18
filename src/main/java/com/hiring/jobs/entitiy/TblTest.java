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
@Table(name = "tbl_test")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TblTest.findAll", query = "SELECT t FROM TblTest t"),
    @NamedQuery(name = "TblTest.findByTestId", query = "SELECT t FROM TblTest t WHERE t.testId = :testId"),
    @NamedQuery(name = "TblTest.findByTestLink", query = "SELECT t FROM TblTest t WHERE t.testLink = :testLink"),
    @NamedQuery(name = "TblTest.findByTestJadwal", query = "SELECT t FROM TblTest t WHERE t.testJadwal = :testJadwal")})
public class TblTest implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "test_id")
    private Integer testId;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "test_link")
    private String testLink;
    @Basic(optional = false)
    @NotNull
    @Column(name = "test_jadwal")
    @Temporal(TemporalType.DATE)
    private Date testJadwal;
    @JoinColumn(name = "candidate_id", referencedColumnName = "user_id")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private TblUser candidateId;

    public TblTest() {
    }

    public TblTest(Integer testId) {
        this.testId = testId;
    }

    public TblTest(Integer testId, String testLink, Date testJadwal) {
        this.testId = testId;
        this.testLink = testLink;
        this.testJadwal = testJadwal;
    }

    public Integer getTestId() {
        return testId;
    }

    public void setTestId(Integer testId) {
        this.testId = testId;
    }

    public String getTestLink() {
        return testLink;
    }

    public void setTestLink(String testLink) {
        this.testLink = testLink;
    }

    public Date getTestJadwal() {
        return testJadwal;
    }

    public void setTestJadwal(Date testJadwal) {
        this.testJadwal = testJadwal;
    }

    public TblUser getCandidateId() {
        return candidateId;
    }

    public void setCandidateId(TblUser candidateId) {
        this.candidateId = candidateId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (testId != null ? testId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TblTest)) {
            return false;
        }
        TblTest other = (TblTest) object;
        if ((this.testId == null && other.testId != null) || (this.testId != null && !this.testId.equals(other.testId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.hiring.jobs.entitiy.TblTest[ testId=" + testId + " ]";
    }
    
}
