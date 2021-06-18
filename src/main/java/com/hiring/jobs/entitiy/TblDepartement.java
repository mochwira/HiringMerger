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
@Table(name = "tbl_departement")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TblDepartement.findAll", query = "SELECT t FROM TblDepartement t"),
    @NamedQuery(name = "TblDepartement.findByDepartementId", query = "SELECT t FROM TblDepartement t WHERE t.departementId = :departementId"),
    @NamedQuery(name = "TblDepartement.findByNamaDepartement", query = "SELECT t FROM TblDepartement t WHERE t.namaDepartement = :namaDepartement"),
    @NamedQuery(name = "TblDepartement.findByStatusDepartement", query = "SELECT t FROM TblDepartement t WHERE t.statusDepartement = :statusDepartement")})
public class TblDepartement implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "departement_id")
    private Integer departementId;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "nama_departement")
    private String namaDepartement;
    @Basic(optional = false)
    @NotNull
    @Column(name = "status_departement")
    private boolean statusDepartement;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "departementId", fetch = FetchType.LAZY)
    private List<TblJob> tblJobList;

    public TblDepartement() {
    }

    public TblDepartement(Integer departementId) {
        this.departementId = departementId;
    }

    public TblDepartement(Integer departementId, String namaDepartement, boolean statusDepartement) {
        this.departementId = departementId;
        this.namaDepartement = namaDepartement;
        this.statusDepartement = statusDepartement;
    }

    public Integer getDepartementId() {
        return departementId;
    }

    public void setDepartementId(Integer departementId) {
        this.departementId = departementId;
    }

    public String getNamaDepartement() {
        return namaDepartement;
    }

    public void setNamaDepartement(String namaDepartement) {
        this.namaDepartement = namaDepartement;
    }

    public boolean getStatusDepartement() {
        return statusDepartement;
    }

    public void setStatusDepartement(boolean statusDepartement) {
        this.statusDepartement = statusDepartement;
    }

    @XmlTransient
    public List<TblJob> getTblJobList() {
        return tblJobList;
    }

    public void setTblJobList(List<TblJob> tblJobList) {
        this.tblJobList = tblJobList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (departementId != null ? departementId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TblDepartement)) {
            return false;
        }
        TblDepartement other = (TblDepartement) object;
        if ((this.departementId == null && other.departementId != null) || (this.departementId != null && !this.departementId.equals(other.departementId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.hiring.jobs.entitiy.TblDepartement[ departementId=" + departementId + " ]";
    }
    
}
