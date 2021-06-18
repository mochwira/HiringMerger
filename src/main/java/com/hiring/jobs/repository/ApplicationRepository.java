/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.hiring.jobs.repository;

import org.springframework.data.jpa.repository.Query;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author MELLA
 */
@Repository
public interface ApplicationRepository extends CrudRepository<TblApplication, Integer>{
    @Query(value = "SELECT * FROM Tbl_Application where application_id = :id", nativeQuery = true)
    public Iterable <TblApplication> getApplicationsById();
}
