/*
 * =============================================================================
 *
 *   Copyright (c) 2015, 2020, RichardBradleySmith.com All Rights Reserved
 *
 * =============================================================================
 */
package com.androidcommand.app.controller;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.androidcommand.app.business.services.FunctionList;
import com.androidcommand.app.model.CompaniesDAO;

@Component
@Controller
@Configuration
public class CompaniesController {

    @GetMapping("/addCompany")
    public String
    sendForm(@ModelAttribute("company") CompaniesDAO company, BindingResult result, Model model){
	 	System.out.println("Entry0010 CompanyController.java before showing /addCompany ");
	 	ArrayList<String> company_functions = FunctionList.getInstance(company);
	 	company.setFunctions(company_functions);
	 	ArrayList<String>functions = company.getFunctions();
//	 	System.out.println("Entry0015 CompanyController.java new functions" + functions);
//	 	model.addAttribute(company.getFunctions());
//	 	company.getFunctions();
	 	company.selectCompany();
	    model.addAttribute("functions", functions);
        return "addCompany";
    }

    @PostMapping("/showCompany")
    public String processForm(@ModelAttribute("company") CompaniesDAO company, Model model) {
//  public String processForm(@ModelAttribute("company") CompaniesDAO company, String company_name, String company_function) {
    	System.out.println("Entry0020 CompanyController.java for /showCOmpany " + company.getCompany()); 
        return "showCompany";
    }

    @Bean
    public String myotherCompaniesbean() {
    	System.out.println("In Companies.java for myotherCompaniesBean ");
        return "/companies";

    }
	
	
	
	
	
	
}
