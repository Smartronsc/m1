/*
 * =============================================================================
 *
 *   Copyright (c) 2015, 2020, RichardBradleySmith.com All Rights Reserved
 *
 * =============================================================================
 */
package com.androidcommand.app.controller;

import java.util.ArrayList;

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
	    model.addAttribute("functions", functions);
	    company.setCompany("company");
        return "addCompany";
    }

    @PostMapping("/showCompany")
    public String processForm(@ModelAttribute("company") CompaniesDAO company, @ModelAttribute("companyTable") ArrayList<String> companyTable, Model model) {
 
//    	CompaniesDAO company = new CompaniesDAO();
    	System.out.println("Entry0020 CompanyController.java for /showCOmpany in code");
    	System.out.println("Entry0021 CompanyController.java for /showCOmpany " + company.getCompany());
    	System.out.println("Entry0022 CompanyController.java for /showCOmpany ");
//      ArrayList<String> companyTable = company.selectCompany(company.getCompany());
    	companyTable = company.selectCompany(company.getCompany());
    	model.addAttribute("companyTable", companyTable);	
        return "showCompany";
    }

    @Bean
    public String myotherCompaniesbean() {
    	System.out.println("In Companies.java for myotherCompaniesBean ");
        return "/companies";

    }
	
	
	
	
	
	
}
