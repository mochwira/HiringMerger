/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.hiring.jobs.interfaces;

import com.hiring.jobs.entitiy.TblApplicationStatus;
import java.util.Optional;

/**
 *
 * @author D
 */
public interface ApplicationStatusInterface  {
    void save(TblApplicationStatus status);
    Iterable<TblApplicationStatus> getApplicationStatusActive();
    public Optional<TblApplicationStatus> getApplicationStatusById(Integer statusId);
//    public String getMaxFaqQuestion();
}
