/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.hiring.jobs.repository;

import com.hiring.jobs.entitiy.TblDepartement;
import java.util.Optional;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author mocha
 */
@Repository
public interface DepartementRepository extends CrudRepository<TblDepartement, Integer>{
    @Query(value = "SELECT * FROM tbl_departement WHERE tbl_departement.status_departement = 1", nativeQuery = true)
  Iterable <TblDepartement> getDepartementActive();

//    public void save(TblDepartement departement);
//
//    public Optional<TblDepartement> findById(Integer departementId);

 
}
