/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.hiring.jobs.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author MELLA
 */
@Controller
@RequestMapping
public class TestController {
    
    @RequestMapping("/login")
	public ModelAndView login() {
		return new ModelAndView("login");
	}

	@RequestMapping("/userDashboard")
	public ModelAndView userDashboard() {
		return new ModelAndView("userdashboard");
	}

	@RequestMapping("/adminDashboard")
	public ModelAndView adminDashboard() {
		return new ModelAndView("admindashboard");
	}
}
