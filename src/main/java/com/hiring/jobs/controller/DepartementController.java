/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.hiring.jobs.controller;

import com.hiring.jobs.entity.TblDepartement;
import com.hiring.jobs.services.DepartementService;
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
 * @author mocha
 */
@Controller
@RequestMapping
public class DepartementController {
   
    @Autowired
    private DepartementService departementService;
    
    @GetMapping("/departement")
    public String getDepartementStatus(Model model) {
        Iterable<TblDepartement> departement = departementService.getDepartementActive();
        model.addAttribute("departements", departement);

        TblDepartement departementCrud = new TblDepartement();

//        model.addAttribute("masterAdd", masterCrud);        
//        model.addAttribute("masterEdit", masterCrud);
        model.addAttribute("departementRemove", departementCrud);

        return "departement/v_page.html";
    }
    
    @GetMapping("/departement/add")
    public String departementAdd(
            Model model
    ) 
    {
//        Iterable<Master> master = masterService.getMasterActive();
//        model.addAttribute("masters", master);
//        
        TblDepartement departementCrud = new TblDepartement();

        model.addAttribute("departementAdd", departementCrud);  
        return "departement/v_page_add.html";
    }

    //idnya dimana ?
    @GetMapping("/departement/edit/{departementId}")
    public String departementEdit(
            Model model,
            @PathVariable Integer departementId
    ) 
    {
        Optional<TblDepartement> departement = departementService.getDepartementById(departementId);
        model.addAttribute("departementEdit", departement);
        return "departement/v_page_edit.html";
    }
    
    
    @PostMapping("/departement/insert")
    public String departementInsert(
            @ModelAttribute("departementAdd") TblDepartement departement
    ) 
    {
        this.departementService.save(departement);
        return "redirect:/departement";
    }
    
    @PostMapping(value = "/departement/update")
    public String departementUpdate(
            @RequestParam(value = "departementId", required = false) Integer departementId,
            @RequestParam(value = "namaDepartement", required = false) String namaDepartement,
            @RequestParam(value = "statusDepartement", required = false) Boolean statusDepartement
    ) {
        TblDepartement departement = new TblDepartement(departementId, namaDepartement, statusDepartement);
        departement.setDepartementId(departementId);
        departement.setNamaDepartement(namaDepartement);
        departement.setStatusDepartement(statusDepartement);

        this.departementService.save(departement);
        return "redirect:/departement";
        
    }
    
    @GetMapping(value = "/departement/remove/{departementId}")
    public String departementRemove(
            @PathVariable Integer departementId
    ) {
        Optional<TblDepartement> departements = departementService.getDepartementById(departementId);
        Integer Id = departements.get().getDepartementId();
        String namaDepartement = departements.get().getNamaDepartement();
        Boolean statusDepartement = false;
        
        TblDepartement departement = new TblDepartement(departementId, namaDepartement, statusDepartement);
        departement.setDepartementId(departementId);
        departement.setNamaDepartement(namaDepartement);
        departement.setStatusDepartement(statusDepartement);

        this.departementService.save(departement);
        return "redirect:/departement";
        
    }
}
