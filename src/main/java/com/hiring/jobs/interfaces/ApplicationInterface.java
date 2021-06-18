/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.hiring.jobs.interfaces;

import java.util.Optional;

/**
 *
 * @author MELLA
 */
public interface ApplicationInterface {
    void save(TblApplication application);
    Iterable<TblApplication> getAll();
    public Optional<TblApplication> getApplicationById(Integer applicationId);
}
