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
@Table(name = "tbl_role")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TblRole.findAll", query = "SELECT t FROM TblRole t"),
    @NamedQuery(name = "TblRole.findByRoleId", query = "SELECT t FROM TblRole t WHERE t.roleId = :roleId"),
    @NamedQuery(name = "TblRole.findByNamaRole", query = "SELECT t FROM TblRole t WHERE t.namaRole = :namaRole"),
    @NamedQuery(name = "TblRole.findByStatusRole", query = "SELECT t FROM TblRole t WHERE t.statusRole = :statusRole")})
public class TblRole implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "role_id")
    private Integer roleId;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "nama_role")
    private String namaRole;
    @Basic(optional = false)
    @NotNull
    @Column(name = "status_role")
    private boolean statusRole;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "roleId", fetch = FetchType.LAZY)
    private List<TblUser> tblUserList;

    public TblRole() {
    }

    public TblRole(Integer roleId) {
        this.roleId = roleId;
    }

    public TblRole(Integer roleId, String namaRole, boolean statusRole) {
        this.roleId = roleId;
        this.namaRole = namaRole;
        this.statusRole = statusRole;
    }

    public Integer getRoleId() {
        return roleId;
    }

    public void setRoleId(Integer roleId) {
        this.roleId = roleId;
    }

    public String getNamaRole() {
        return namaRole;
    }

    public void setNamaRole(String namaRole) {
        this.namaRole = namaRole;
    }

    public boolean getStatusRole() {
        return statusRole;
    }

    public void setStatusRole(boolean statusRole) {
        this.statusRole = statusRole;
    }

    @XmlTransient
    public List<TblUser> getTblUserList() {
        return tblUserList;
    }

    public void setTblUserList(List<TblUser> tblUserList) {
        this.tblUserList = tblUserList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (roleId != null ? roleId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TblRole)) {
            return false;
        }
        TblRole other = (TblRole) object;
        if ((this.roleId == null && other.roleId != null) || (this.roleId != null && !this.roleId.equals(other.roleId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.hiring.jobs.entitiy.TblRole[ roleId=" + roleId + " ]";
    }
    
}
