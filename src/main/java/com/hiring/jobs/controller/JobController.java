/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.hiring.jobs.controller;

import com.hiring.jobs.entity.TblJob;
import com.hiring.jobs.services.JobService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

/**
 *
 * @author mocha
 */
@Controller
public class JobController {
    
    @Autowired
    private JobService jobService;

    // display list of job
    @GetMapping("/job")
    public String viewHomePage(Model model) {
        model.addAttribute("listJob", jobService.getAllJob());
        return "/job/jobpage";
    }

    //cek pada model.addAttribute
    @GetMapping("/showNewJobForm")
    public String showNewJobForm(Model model) {
        // create model attribute to bind form data
        TblJob job = new TblJob();
        model.addAttribute("job", job);
        return "/job/new_job";
    }

    //cek ini kalo salah
    @PostMapping("/saveJob")
    public String saveJob(@ModelAttribute("job") TblJob job) {
        // save job to database
        jobService.saveJob(job);
        return "/redirect:/job";
    }

    @GetMapping("/showJobForUpdate/{jobId}")
    public String showJobForUpdate(@PathVariable(value = "jobId") Integer jobId, Model model) {

        // get job from the service
        TblJob job = jobService.getJobById(jobId);

        // set job as a model attribute to pre-populate the form
        model.addAttribute("jobs", job);
        return "/job/update_job";
    }

    @GetMapping("/deleteJob/{jobId}")
    public String deleteJob(@PathVariable(value = "jobId") Integer jobId) {

        // call delete employee method 
        this.jobService.deleteJobById(jobId);
        return "redirect:/job";
    }
}
