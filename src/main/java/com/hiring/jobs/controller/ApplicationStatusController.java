/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.hiring.jobs.controller;

import com.hiring.jobs.entitiy.TblApplicationStatus;
import com.hiring.jobs.services.ApplicationStatusService;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 *
 * @author D
 */
@Controller
@RequestMapping
public class ApplicationStatusController {
    
         @Autowired
    private ApplicationStatusService applicationStatusService;
    
    @GetMapping("/status")
    public String getApplicationStatus(Model model) {
        Iterable<TblApplicationStatus> status = applicationStatusService.getApplicationStatusActive();
        model.addAttribute("statuses", status);
        //model.mergeAttributes(map)
        TblApplicationStatus applicationStatusCrud = new TblApplicationStatus();

//        model.addAttribute("masterAdd", masterCrud);        
//        model.addAttribute("masterEdit", masterCrud);
        model.addAttribute("applicationStatusRemove", applicationStatusCrud);

        return "applicationstatus/v_page.html";
    }
    
    @GetMapping("/status/add")
    public String applicationStatusAdd(
            Model model
    ) 
    {
//        Iterable<Master> master = masterService.getMasterActive();
//        model.addAttribute("masters", master);
//        
        TblApplicationStatus applicationStatusCrud = new TblApplicationStatus();

        model.addAttribute("applicationStatusAdd", applicationStatusCrud);  
        return "applicationstatus/v_page_add.html";
    }

    //idnya dimana ?
    @GetMapping("/status/edit/{statusId}")
    public String applicationStatusEdit(
            Model model,
            @PathVariable Integer statusId
    ) 
    {
        Optional<TblApplicationStatus> status = applicationStatusService.getApplicationStatusById(statusId);
        model.addAttribute("applicationStatusEdit", status);
        return "applicationstatus/v_page_edit.html";
    }
    
    
    @PostMapping("/status/insert")
    public String applicationStatusInsert(
            @ModelAttribute("applicationStatusAdd") TblApplicationStatus status
    ) 
    {
        this.applicationStatusService.save(status);
        return "redirect:/status";
    }
    
    
    @PostMapping(value = "/status/update")
    public String applicationStatusUpdate(
            @RequestParam(value = "statusId", required = false) Integer statusId,
            @RequestParam(value = "namaStatus", required = false) String namaStatus,
            @RequestParam(value = "status", required = false) Boolean statusku
    ) {
        System.out.println("statusId" + statusId);
        System.out.println("namaStatus" + namaStatus);
        System.out.println("status" + statusku);
        
        TblApplicationStatus statuse = new TblApplicationStatus(statusId, namaStatus, statusku);
        statuse.setStatusId(statusId);
        statuse.setNamaStatus(namaStatus);
        statuse.setStatus(statusku);

        this.applicationStatusService.save(statuse);
        return "redirect:/status";
        
    }
    
    @GetMapping(value = "/status/remove/{statusId}")
    public String applicationStatusRemove(
            @PathVariable Integer statusId
    ) {
        Optional<TblApplicationStatus> statuss = applicationStatusService.getApplicationStatusById(statusId);
        Integer Id = statuss.get().getStatusId();
        String namaStatus = statuss.get().getNamaStatus();
        Boolean Status = false;
        
        TblApplicationStatus status = new TblApplicationStatus(statusId, namaStatus, Status);
        status.setStatusId(statusId);
        status.setNamaStatus(namaStatus);
        status.setStatus(Status);

        this.applicationStatusService.save(status);
        return "redirect:/status";
        
    }
    
    
}
