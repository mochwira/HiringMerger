/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.hiring.jobs.repository;


import com.hiring.jobs.entitiy.TblJob;
import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.stereotype.Repository;

/**
 *
 * @author mocha
 */
@Repository
public interface JobRepository extends JpaRepository<TblJob, Integer>{

    //public void getDepartementById(Integer departementId);
   
  
}
