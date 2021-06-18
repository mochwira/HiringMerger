/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.hiring.jobs.controller;

import com.hiring.jobs.services.BiodataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;


/**
 *
 * @author MELLA
 */
@Controller
@RequestMapping
public class BiodataController {
    @Autowired
    private BiodataService biodataService;
    
    @GetMapping("/biodata")
    public String getBiodata(Model model) {
        Iterable<TblBiodata> biodatas = biodataService.getAll();
        model.addAttribute("biodata", biodatas);

        TblBiodata bioadataCrud = new TblBiodata();

//        model.addAttribute("masterAdd", masterCrud);        
//        model.addAttribute("masterEdit", masterCrud);
        model.addAttribute("biodata", bioadataCrud);

        return "biodata/biodata.html";
    }
    @GetMapping("/biodata/add")
    public String biodataAdd(Model model) 
    {
//        Iterable<Master> master = masterService.getMasterActive();
//        model.addAttribute("masters", master);
//        
        TblBiodata biodataCrud = new TblBiodata();

        model.addAttribute("departementAdd", biodataCrud);  
        return "biodata/biodata_add.html";
    }
    
    @PostMapping("/biodata/insert")
    public String biodataInsert(
            @ModelAttribute("biodataAdd") TblBiodata biodata
    ) 
    {
        this.biodataService.save(biodata);
        return "redirect:/biodata";
    }
    
    
    
}
