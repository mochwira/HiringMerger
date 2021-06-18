/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.hiring.jobs.controller;

import com.hiring.jobs.entity.TblApplicationStatus;
import com.hiring.jobs.entity.TblJob;
import com.hiring.jobs.services.ApplicationService;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 *
 * @author MELLA
 */
@Controller
@RequestMapping
public class ApplicationController {

    @Autowired
    private ApplicationService applicationService;

    @GetMapping("/application")
    public String getApplication(Model model) {
        Iterable<TblApplication> applications = applicationService.getAll();
        model.addAttribute("application", applications);

        TblApplication applicationCrud = new TblApplication();
        model.addAttribute("application", applicationCrud);

        return ("application/v_page.html");
    }

    @GetMapping("/application/edit/{statusId}")
    public String applicationEdit(
            Model model,
            @PathVariable Integer applicationId
    ) {
        Optional<TblApplication> application = applicationService.getApplicationById(applicationId);
        model.addAttribute("applicationEdit", application);
        return "applications/v_page_edit.html";
    }

    @PostMapping("/application/update")
    public String updateApplication(
            @RequestParam(value = "applicationId", required = false) Integer applicationId,
            @RequestParam(value = "candidateId", required = false) Integer candidateId,
            @RequestParam(value = "statusId", required = false) Integer statusId,
            @RequestParam(value = "jobId", required = false) Integer jobId
    ) {
        Optional<TblApplication> applications = applicationService.getApplicationById(applicationId);
        Integer id = applications.get().getApplicationId();
        Integer candidate = applications.get().getCandidateId().getUserId();
        Integer status = applications.get().getStatusId().getStatusId();
        Integer job = applications.get().getJobId().getJobId();
        
        Object candidateIdObject = new TblUser(candidate);
        Object statusIdObject = new TblApplicationStatus(status);
        Object jobIdObject = new TblJob(job);
        

//        TblApplication application = new TblApplication(id, candidateIdObject, status, job);
//        application.setApplicationId(applicationId);
//        application.setCandidateId(candidateIdObject);
//        application.setStatusId(statusIdObject);
//        application.setJobId(jobIdObject);

//        this.applicationService.save(application);

        return "redirect:/application";

    }
}
