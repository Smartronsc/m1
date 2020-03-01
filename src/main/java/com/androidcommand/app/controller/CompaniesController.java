/*
 * =============================================================================
 *
 *   Copyright (c) 2015, 2020, RichardBradleySmith.com All Rights Reserved
 *
 * =============================================================================
 */
package com.androidcommand.app.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.androidcommand.app.Companies;

@Controller
public class CompaniesController {

	@RequestMapping(value="/companies", method=RequestMethod.GET)
	public ModelAndView handleRequest(@ModelAttribute(value="Companies") Companies company_company) {
		System.out.println("In CompaniesController");
		Companies Company = new Companies();
		Company.setCompany("Tear Drop");
		Company.setUserid("Penny Lane");
        ModelAndView mav = new ModelAndView();
        mav.addObject("string",Company.getCompany());
        mav.addObject("userid",Company.getUserid());
		System.out.println("In CompanyController.java Company is " + Company.getCompany());
        mav.setViewName("companies");
        System.out.println("In CompanyController.java mav model is " + mav.getModel().keySet().toString() );
        return mav; 
	}
}
