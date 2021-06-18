/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.hiring.jobs.services;

import com.hiring.jobs.entity.TblRole;
import com.hiring.jobs.interfaces.RoleInterface;
import com.hiring.jobs.repository.RoleRepository;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author D
 */
@Service
public class RoleService implements RoleInterface{
    
     @Autowired
    private RoleRepository roleRepo;

    @Override
    public void save(TblRole role) {
        this.roleRepo.save(role);
    }

    @Override
    public Iterable<TblRole> getRoleActive() {
        return roleRepo.getRoleActive();
    }

    @Override
    public Optional<TblRole> getRoleById(Integer roleId) {
        return roleRepo.findById(roleId);
    }
    
     
}
