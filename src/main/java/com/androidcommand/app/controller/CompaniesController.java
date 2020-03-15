/*
 * =============================================================================
 *
 *   Copyright (c) 2015, 2020, RichardBradleySmith.com All Rights Reserved
 *
 * =============================================================================
 */
package com.androidcommand.app.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import com.androidcommand.app.Companies;
import com.androidcommand.app.model.CompaniesDAO;

@Controller
public class CompaniesController {
	@GetMapping("/companies")
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
	
	@PostMapping(value="/m1/companies")
	public String companiesSubmit(@ModelAttribute Companies Post_object) {
//		public String companiesSubmit(@ModelAttribute Companies Post_object, @RequestParam(value="website", required=true) String website) {
//		System.out.println("In CompanyController.java Post_objectis " + Post_object.getClass().toString());
	    System.out.println("In CompanyController.java website is ");
	    return "result";
	}
}
