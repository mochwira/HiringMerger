/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.hiring.jobs.repository;

import java.util.List;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author MELLA
 */
@Repository
public interface BiodataRepository extends CrudRepository<TblBiodata, Integer> {
    
    
  @Query(value = "SELECT * FROM tbl_biodata b join tbl_role r ON b.role_id = r.role_id WHERE id_role = :id ", nativeQuery = true)
  List <TblBiodata> getBiodataById(@Param(value="id") String id);
  

}
