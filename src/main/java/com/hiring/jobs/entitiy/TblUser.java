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
@Table(name = "tbl_user")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TblUser.findAll", query = "SELECT t FROM TblUser t"),
    @NamedQuery(name = "TblUser.findByUserId", query = "SELECT t FROM TblUser t WHERE t.userId = :userId"),
    @NamedQuery(name = "TblUser.findByPasswordUser", query = "SELECT t FROM TblUser t WHERE t.passwordUser = :passwordUser"),
    @NamedQuery(name = "TblUser.findByEmailUser", query = "SELECT t FROM TblUser t WHERE t.emailUser = :emailUser")})
public class TblUser implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "user_id")
    private Integer userId;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "password_user")
    private String passwordUser;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "email_user")
    private String emailUser;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "hrdId", fetch = FetchType.LAZY)
    private List<TblJob> tblJobList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "candidateId", fetch = FetchType.LAZY)
    private List<TblTest> tblTestList;
    @JoinColumn(name = "role_id", referencedColumnName = "role_id")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private TblRole roleId;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "candidateId", fetch = FetchType.LAZY)
    private List<TblApplication> tblApplicationList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "userId", fetch = FetchType.LAZY)
    private List<TblBiodata> tblBiodataList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "candidateId", fetch = FetchType.LAZY)
    private List<TblInterview> tblInterviewList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "interviewerD", fetch = FetchType.LAZY)
    private List<TblInterview> tblInterviewList1;

    public TblUser() {
    }

    public TblUser(Integer userId) {
        this.userId = userId;
    }

    public TblUser(Integer userId, String passwordUser, String emailUser) {
        this.userId = userId;
        this.passwordUser = passwordUser;
        this.emailUser = emailUser;
    }

    public TblUser(Integer userId, Object roleId, String passwordUser, String emailUser) {
        this.userId = userId;
        this.roleId = (TblRole) this.roleId;
        this.passwordUser = passwordUser;
        this.emailUser = emailUser;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getPasswordUser() {
        return passwordUser;
    }

    public void setPasswordUser(String passwordUser) {
        this.passwordUser = passwordUser;
    }

    public String getEmailUser() {
        return emailUser;
    }

    public void setEmailUser(String emailUser) {
        this.emailUser = emailUser;
    }

    @XmlTransient
    public List<TblJob> getTblJobList() {
        return tblJobList;
    }

    public void setTblJobList(List<TblJob> tblJobList) {
        this.tblJobList = tblJobList;
    }

    @XmlTransient
    public List<TblTest> getTblTestList() {
        return tblTestList;
    }

    public void setTblTestList(List<TblTest> tblTestList) {
        this.tblTestList = tblTestList;
    }

    public TblRole getRoleId() {
        return roleId;
    }

    public void setRoleId(TblRole roleId) {
        this.roleId = roleId;
    }

    @XmlTransient
    public List<TblApplication> getTblApplicationList() {
        return tblApplicationList;
    }

    public void setTblApplicationList(List<TblApplication> tblApplicationList) {
        this.tblApplicationList = tblApplicationList;
    }

    @XmlTransient
    public List<TblBiodata> getTblBiodataList() {
        return tblBiodataList;
    }

    public void setTblBiodataList(List<TblBiodata> tblBiodataList) {
        this.tblBiodataList = tblBiodataList;
    }

    @XmlTransient
    public List<TblInterview> getTblInterviewList() {
        return tblInterviewList;
    }

    public void setTblInterviewList(List<TblInterview> tblInterviewList) {
        this.tblInterviewList = tblInterviewList;
    }

    @XmlTransient
    public List<TblInterview> getTblInterviewList1() {
        return tblInterviewList1;
    }

    public void setTblInterviewList1(List<TblInterview> tblInterviewList1) {
        this.tblInterviewList1 = tblInterviewList1;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (userId != null ? userId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TblUser)) {
            return false;
        }
        TblUser other = (TblUser) object;
        if ((this.userId == null && other.userId != null) || (this.userId != null && !this.userId.equals(other.userId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.hiring.jobs.entitiy.TblUser[ userId=" + userId + " ]";
    }
    
}
