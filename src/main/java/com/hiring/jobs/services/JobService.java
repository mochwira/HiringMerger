/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.hiring.jobs.services;


import com.hiring.jobs.entity.TblJob;
import com.hiring.jobs.interfaces.JobInterfaces;
import com.hiring.jobs.repository.JobRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author mocha
 */
@Service
public class JobService implements JobInterfaces{

    @Autowired
    private JobRepository jobRepo;
    
    @Override
    public List<TblJob> getAllJob() {
        return jobRepo.findAll(); 
    }

    @Override
    public void saveJob(TblJob job) {
        this.jobRepo.save(job);
    }

    @Override
    public TblJob getJobById(Integer jobId) {
        Optional < TblJob > optional = jobRepo.findById(jobId);
        TblJob job = null;
        if (optional.isPresent()) {
            job = optional.get();
        } else {
            throw new RuntimeException(" Job not found for id :: " + jobId);
        }
        return job;
    }

    @Override
    public void deleteJobById(Integer jobId) {
       this.jobRepo.deleteById(jobId);
    }
   
}
