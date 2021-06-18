/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.hiring.jobs.services;

import com.hiring.jobs.entity.TblDepartement;
import com.hiring.jobs.interfaces.DepartementInterface;
import com.hiring.jobs.repository.DepartementRepository;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author mocha
 */
@Service
public class DepartementService implements DepartementInterface{
    @Autowired
    private DepartementRepository departementRepository;

    @Override
    public void save(TblDepartement departement) {
        this.departementRepository.save(departement);   
    }

    @Override
    public Iterable<TblDepartement> getDepartementActive() {
        return departementRepository.getDepartementActive();
    }

    @Override
    public Optional<TblDepartement> getDepartementById(Integer departementId) {
       return departementRepository.findById(departementId);
    }

    

   
    
}
