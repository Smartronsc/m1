/*
 * =============================================================================
 *
 *   Copyright (c) 2015, 2020, RichardBradleySmith.com All Rights Reserved
 *
 * =============================================================================
 */
package com.androidcommand.app;

import org.springframework.stereotype.Controller;

import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class CompaniesController {

	@RequestMapping(value="/companies", method=RequestMethod.GET)
	public ModelAndView handleRequest(@ModelAttribute(value="Companies") Companies company_company) {
		System.out.println("In CompaniesController");
		Companies company = new Companies();
		company.setCompany("Tear Drop");
        ModelAndView mav = new ModelAndView();
        mav.addObject(company);
		System.out.println("Company is " + company.getCompany());
        mav.setViewName("companies");
        return mav;

	}
}