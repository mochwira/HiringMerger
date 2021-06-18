/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.hiring.jobs.services;


import com.hiring.jobs.entitiy.TblUser;
import com.hiring.jobs.interfaces.UserInterface;
import com.hiring.jobs.repository.UserRepository;

import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author MELLA
 */
@Service
public class UserService implements UserInterface{
    @Autowired
    private UserRepository userRepository;
    
    @Override
    public void save(TblUser user) {
       userRepository.save(user);
    }

    @Override
    public Iterable<TblUser> getAll() {
        return userRepository.findAll();
    }

//    @Override
//    public List<TblUser> findUserByEmailUser(String emailUser) {
//        
//        return userRepository.findByEmailUser(emailUser);
//        //return Optional.ofNullable(emailUser);
//    }
    
    @Override
    public Optional<TblUser> getUserById(Integer userId) {
        return userRepository.findById(userId);
    }

    @Override
    public Optional<TblUser> findByEmailUser(String emailUser) {
       return userRepository.findByEmailUser(emailUser);
    }

    
}
