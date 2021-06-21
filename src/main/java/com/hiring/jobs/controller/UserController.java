/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.hiring.jobs.controller;

import com.hiring.jobs.entitiy.TblRole;
import com.hiring.jobs.entitiy.TblUser;
import com.hiring.jobs.services.UserService;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

/**
 *
 * @author MELLA
 */
@Controller
@RequestMapping
public class UserController {
    
    private Integer roleIdPublic;
    private Integer userIdPublic;
    
    @Autowired
    private UserService userService;
    
    @GetMapping("/login")
    public String index() {
//  model.addAttribute("index", "index");
        return "login.html";
    }

//    @RequestMapping(value = "/login")
//    public String Login(Map<String,Object> model){
//        TblUser user = new TblUser();
//        model.put("userId", user);
//        model.put("", "login");
//        
//        
//        return "v_page_login";
//    }
    @RequestMapping(value = "/auth", method = RequestMethod.POST)
    public String log(
            @RequestParam(value = "emailUser", required = false) String emailUser,
            @RequestParam(value = "passwordUser", required = false) String passwordUser
             ) {
      
               
        Optional<TblUser> getUser = userService.findByEmailUser(emailUser);
//        String email = getUser.get().getEmailUser();
        String password = getUser.get().getPasswordUser();
//        Integer roleId = getUser.get().getRoleId().getRoleId();
        String namaRole = getUser.get().getRoleId().getNamaRole();

        if (passwordUser.equals(password)) {
            if(namaRole.equalsIgnoreCase("admin")){
                return "redirect:/role/v_page.html";
            } else if(namaRole.equalsIgnoreCase("hrd")) {
                return "redirect:/job/jobpage";
            } else
                return "redirect:/biodata/biodata_add.html";
            
        } else {
            System.out.println("password salah");
        }
        return "redirect:/login.html";
        
    }   
    
       
        
      
        
         
//        if(user == null)
//            return "redirect:login";
//        else
//            return "redirect:/";
//        Iterable<TblUser> users = userService.getAll();
        
//        for (TblUser other : users){
        
//            if (emailUser.equals() && other.equals(TblUser.passwordUser)){
////              emailUser.setLoggedIn(true);
////              UserRepository.save(emailUser);
//                return  "biodata/v_page.html";
////                
////            }
//        }
//        return "v_page_login";


    @GetMapping("/logout")
    public String Logout()
    {
      userIdPublic = 0;
      roleIdPublic = 0;
      return "redirect:/";
    }
    
    
    
    @GetMapping("/user")
    public String getUser(Model model) {
        Iterable<TblUser> users = userService.getAll();
        model.addAttribute("user", users);

        TblUser userCrud = new TblUser();
        model.addAttribute("user", userCrud);

        return ("/user/v.page.html");
    }

    @GetMapping("/user/add")
    public String userAdd(Model model) {
        TblUser userCrud = new TblUser();
        
        
        model.addAttribute("userAdd", userCrud);
        return "user/v_page_add.html";
    }
    
    @GetMapping("/user/edit")
    public String userEdit(Model model,
            @PathVariable Integer userId)
    {
        Optional<TblUser> user = userService.getUserById(userId);
        model.addAttribute("userEdit", user);
        
        return "user/v_page_edit.html";
    }       
    
    @PostMapping("/user/insert")
     public String userInsert(
            @ModelAttribute("userAdd") TblUser user
    ) 
    {
        this.userService.save(user);
        return "redirect:/user";
    }
     
    @PostMapping("/user/update")
    public String userUpdate(
            @RequestParam(value = "userId", required = false) Integer userId,
            @RequestParam(value = "roleId", required = false) Integer roleId,
            @RequestParam(value = "passwordUser", required = false) String passwordUser,
            @RequestParam(value = "emailUser", required = false) String emailUser
            
    )
    {
//ini error knp?
//        int roleId = Integer.parseInt(roleId); 

        Object roleIdObject = new TblRole (roleId);
//        int idProductCategoryInt = Integer.parseInt(idProductCategory);
//        Object idProductCategoryObject = new ProductCategory(idProductCategoryInt);

//Baru sampai sini

        TblUser user = new TblUser (userId, roleId, passwordUser, emailUser);
        user.setUserId(userId);        
        user.setPasswordUser(passwordUser);
        user.setEmailUser(emailUser);
        user.setRoleId((TblRole) roleIdObject); //ini kok gini?
        
        this.userService.save(user);
        return "redirect/user";
    }
    

}
