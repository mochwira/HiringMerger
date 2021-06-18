/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.hiring.jobs.controller;

import com.hiring.jobs.entitiy.TblRole;
import com.hiring.jobs.services.RoleService;
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
public class RoleController {
    
   @Autowired
    private RoleService roleService;
    
    @GetMapping("/role")
    public String getRoleStatus(Model model) {
        Iterable<TblRole> role = roleService.getRoleActive();
        model.addAttribute("roles", role);

        TblRole roleCrud = new TblRole();

//        model.addAttribute("masterAdd", masterCrud);        
//        model.addAttribute("masterEdit", masterCrud);
        model.addAttribute("roleRemove", roleCrud);

        return "role/v_page.html";
    }
    
    @GetMapping("/role/add")
    public String roleAdd(
            Model model
    ) 
    {
//        Iterable<Master> master = masterService.getMasterActive();
//        model.addAttribute("masters", master);
//        
        TblRole roleCrud = new TblRole();

        model.addAttribute("roleAdd", roleCrud);  
        return "role/v_page_add.html";
    }

    //idnya dimana ?
    @GetMapping("/role/edit/{roleId}")
    public String roleEdit(
            Model model,
            @PathVariable Integer roleId
    ) 
    {
        Optional<TblRole> role = roleService.getRoleById(roleId);
        model.addAttribute("roleEdit", role);
        return "role/v_page_edit.html";
    }
    
    
    @PostMapping("/role/insert")
    public String roleInsert(
            @ModelAttribute("roleAdd") TblRole role
    ) 
    {
        this.roleService.save(role);
        return "redirect:/role";
    }
    
    @PostMapping(value = "/role/update")
    public String roleUpdate(
            @RequestParam(value = "roleId", required = false) Integer roleId,
            @RequestParam(value = "namaRole", required = false) String namaRole,
            @RequestParam(value = "statusRole", required = false) Boolean statusRole
    ) {
        TblRole role = new TblRole(roleId, namaRole, statusRole);
        role.setRoleId(roleId);
        role.setNamaRole(namaRole);
        role.setStatusRole(statusRole);

        this.roleService.save(role);
        return "redirect:/role";
        
    }
    
    @GetMapping(value = "/role/remove/{roleId}")
    public String roleRemove(
            @PathVariable Integer roleId
    ) {
        Optional<TblRole> roles = roleService.getRoleById(roleId);
        Integer Id = roles.get().getRoleId();
        String namaRole = roles.get().getNamaRole();
        Boolean statusRole = true;
        
        TblRole role = new TblRole(roleId, namaRole, statusRole);
        role.setRoleId(roleId);
        role.setNamaRole(namaRole);
        role.setStatusRole(statusRole);

        this.roleService.save(role);
        return "redirect:/role";
        
    }
    
}
