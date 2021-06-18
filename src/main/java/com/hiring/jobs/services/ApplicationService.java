/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.hiring.jobs.services;

import com.hiring.jobs.entitiy.TblApplication;
import com.hiring.jobs.interfaces.ApplicationInterface;
import com.hiring.jobs.repository.ApplicationRepository;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author MELLA
 */
@Service
public class ApplicationService implements ApplicationInterface{
    @Autowired
    private ApplicationRepository applicationRepository;
    

    @Override
    public void save(TblApplication application) {
        applicationRepository.save(application);
    }

    @Override
    public Iterable<TblApplication> getAll() {
       return applicationRepository.findAll();
    }

    @Override
    public Optional<TblApplication> getApplicationById(Integer applicationId) {
       return applicationRepository.findById(applicationId);
    }
    
}
