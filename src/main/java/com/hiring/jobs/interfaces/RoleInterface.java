package com.hiring.jobs.interfaces;


import com.hiring.jobs.entitiy.TblRole;
import java.util.Optional;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author D
 */

//coba ubah id nya ke Role ID
public interface RoleInterface {
    void save(TblRole role);
    Iterable<TblRole> getRoleActive();
    public Optional<TblRole> getRoleById(Integer roleId);
//    public String getMaxFaqQuestion();
}
