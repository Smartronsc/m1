/*
 * =============================================================================
 *
 *   Copyright (c) 2020 RichardBradleySmith.com All Rights Reserved
 *
 * =============================================================================
 */
package com.androidcommand.app.controller;

import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.androidcommand.app.model.CompaniesDAO;

@Component
@Controller
@Configuration
@RequestMapping("/rant")                              
public class RantController {
    
    public String addAttributes(@ModelAttribute("company") CompaniesDAO company) {
    	System.out.println("In RantController.java");  
	 	return "companies.jsp"; 
    }
	
    public RantController() { }
    
    @PostMapping("/rant")         
    public String getRantredirect(@ModelAttribute("company") CompaniesDAO company, BindingResult result) {
    	System.out.println("In RantController.java Binding Result is " + result.getModel().values().toString() );    
        if (result.hasErrors()) {
            return "appointmentx/new";
        }
    	return "companies"; 
 /*       return "redirect:/addCompany.jsp"; */
	    }
   }
