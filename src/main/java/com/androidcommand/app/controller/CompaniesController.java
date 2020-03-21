/*
 * =============================================================================
 *
 *   Copyright (c) 2015, 2020, RichardBradleySmith.com All Rights Reserved
 *
 * =============================================================================
 */
package com.androidcommand.app.controller;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.androidcommand.app.model.CompaniesDAO;

@Component
@Controller
@Configuration
public class CompaniesController {

    @GetMapping("/addCompany")
    public String sendForm(@ModelAttribute("company") CompaniesDAO company) {
        return "addCompany";
    }

    @PostMapping("/showCompany")
    public String processForm(@ModelAttribute("company") CompaniesDAO company, BindingResult result) {
		System.out.println("In CompanyController.java Binding Result is " + result.getModel().values().toString() );    	
        if (result.hasErrors()) {
            return "appointments/new";
        }
        return "showCompany";
    }

	/*	@GetMapping("/companies")
	public ModelAndView handleRequest(@ModelAttribute("companies") CompaniesDAO company_company ) {
		CompaniesDAO company = new CompaniesDAO();
		company.setCompany("Tear Drop");
		company.setUserid("Penny Lane");
        ModelAndView mav = new ModelAndView();
        mav.addObject("company",company.getCompany());
        mav.addObject("userid",company.getUserid());
        mav.addObject("website",company.getWebsite());
		System.out.println("In CompanyController.java Company is " + company.getCompany());
        mav.setViewName("companies");
        return mav; 
	}
	
	@PostMapping("/companies")
	public String companiesSubmit(@ModelAttribute Companies Post_object) {
//		public String companiesSubmit(@ModelAttribute Companies Post_object, @RequestParam(value="website", required=true) String website) {
//		System.out.println("In CompanyController.java Post_objectis " + Post_object.getClass().toString());
	    System.out.println("In CompanyController.java website is ");
	    return "result";
	} */
	
    @Bean
    public String myotherCompaniesbean() {
    	System.out.println("In Companies.java for myotherCompaniesBean ");
        return "/companies";

    }
	
	
	
	
	
	
}
