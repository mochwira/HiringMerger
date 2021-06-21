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
@Table(name = "tbl_application_status")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TblApplicationStatus.findAll", query = "SELECT t FROM TblApplicationStatus t"),
    @NamedQuery(name = "TblApplicationStatus.findByStatusId", query = "SELECT t FROM TblApplicationStatus t WHERE t.statusId = :statusId"),
    @NamedQuery(name = "TblApplicationStatus.findByNamaStatus", query = "SELECT t FROM TblApplicationStatus t WHERE t.namaStatus = :namaStatus"),
    @NamedQuery(name = "TblApplicationStatus.findByStatus", query = "SELECT t FROM TblApplicationStatus t WHERE t.status = :status")})
public class TblApplicationStatus implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "status_id")
    private Integer statusId;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "nama_status")
    private String namaStatus;
    @Basic(optional = false)
    @NotNull
    @Column(name = "status")
    private boolean status;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "statusId", fetch = FetchType.LAZY)
    private List<TblApplication> tblApplicationList;

    public TblApplicationStatus() {
    }

    public TblApplicationStatus(Integer statusId) {
        this.statusId = statusId;
    }

    public TblApplicationStatus(Integer statusId, String namaStatus, boolean status) {
        this.statusId = statusId;
        this.namaStatus = namaStatus;
        this.status = status;
    }

    public TblApplicationStatus(Integer statusId, String namaStatus, TblApplicationStatus status) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public Integer getStatusId() {
        return statusId;
    }

    public void setStatusId(Integer statusId) {
        this.statusId = statusId;
    }

    public String getNamaStatus() {
        return namaStatus;
    }

    public void setNamaStatus(String namaStatus) {
        this.namaStatus = namaStatus;
    }

    public boolean getStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
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
        hash += (statusId != null ? statusId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TblApplicationStatus)) {
            return false;
        }
        TblApplicationStatus other = (TblApplicationStatus) object;
        if ((this.statusId == null && other.statusId != null) || (this.statusId != null && !this.statusId.equals(other.statusId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.hiring.jobs.entitiy.TblApplicationStatus[ statusId=" + statusId + " ]";
    }

    public void setStatus(TblApplicationStatus status) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
