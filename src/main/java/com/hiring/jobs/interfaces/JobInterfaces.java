/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.hiring.jobs.interfaces;

import com.hiring.jobs.entitiy.TblDepartement;
import com.hiring.jobs.entitiy.TblJob;
import java.util.List;
import java.util.Optional;

/**
 *
 * @author mocha
 */
public interface JobInterfaces {
   List <TblJob> getAllJob();
   void saveJob(TblJob job);
   TblJob getJobById(Integer jobId);
   //TblDepartement getDepartementById(Integer departementId);
   void deleteJobById(Integer jobId);
}
