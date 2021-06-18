/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.hiring.jobs.repository;

import com.hiring.jobs.entitiy.TblRole;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author D
 */
@Repository
public interface RoleRepository extends CrudRepository<TblRole, Integer> {

  @Query(value = "SELECT * FROM tbl_role WHERE tbl_role.status_role = 0", nativeQuery = true)
  public Iterable<TblRole> getRoleActive();
}
