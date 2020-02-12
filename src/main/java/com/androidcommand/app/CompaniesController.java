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
        ModelAndView mav = new ModelAndView();
        mav.setViewName("companies.jsp");
        return mav;

	}

	
	
	
	
	
	/* 
    private Map<String, Companies> companyMap = new HashMap<>();
 
    @ModelAttribute
    public void addAttributes(Model model) {
        model.addAttribute("msg", "Welcome to Ohio!");
    }
    
    @RequestMapping(value = "/companies", method = RequestMethod.POST)
    public String submit(
      @ModelAttribute("company_company") Companies company_company,
      BindingResult result, ModelMap model) {
        if (result.hasErrors()) {
            return "error";
        }
        model.addAttribute("company_websitec", company_company.getWebsite());
        model.addAttribute("company_company", company_company.getCompany());
 
        companyMap.put(company_company.getCompany(), company_company);
 
        return "companyView";
    } */

}