/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.hiring.jobs.services;

import com.hiring.jobs.entitiy.TblApplicationStatus;
import com.hiring.jobs.interfaces.ApplicationStatusInterface;
import com.hiring.jobs.repository.ApplicationStatusRepository;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author D
 */
@Service
public class ApplicationStatusService implements ApplicationStatusInterface {

     @Autowired
    private ApplicationStatusRepository appStatusRepo;
    
    @Override
    public void save(TblApplicationStatus status) {
        this.appStatusRepo.save(status);
    }

    @Override
    public Optional<TblApplicationStatus> getApplicationStatusById(Integer statusId) {
        return appStatusRepo.findById(statusId);
    }

    @Override
    public Iterable<TblApplicationStatus> getApplicationStatusActive() {
      return appStatusRepo.getApplicationStatusActive(); 
    }

}
