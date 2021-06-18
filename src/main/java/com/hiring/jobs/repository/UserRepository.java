/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.hiring.jobs.repository;

import java.util.Optional;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

/**
 *
 * @author MELLA
 */
@Repository
public interface UserRepository extends CrudRepository<TblUser, Integer> {
   @Query(value = "SELECT * FROM tbl_user u join tbl_role r ON u.role_id=r.role_id WHERE emailUser = :emailUser", nativeQuery = true)
   public Optional<TblUser> findByEmailUser(@Param(value = "emailUser") String emailUser);
 
}
