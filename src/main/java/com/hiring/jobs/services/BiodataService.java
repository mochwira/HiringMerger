/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.hiring.jobs.services;

import com.hiring.jobs.interfaces.BiodataInterface;
import com.hiring.jobs.repository.BiodataRepository;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author MELLA
 */
@Service
public class BiodataService implements BiodataInterface{
    
    @Autowired
    private BiodataRepository biodataRepository;

    @Override
    public void save(TblBiodata biodata) {
    biodataRepository.save(biodata);
    }

    @Override
    public Iterable<TblBiodata> getAll() {
    return biodataRepository.findAll();
    }

    @Override
    public Optional<TblBiodata> getBiodataById(Integer biodataId) {
    return biodataRepository.findById(biodataId);
    }
    
    
    
}
