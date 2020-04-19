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

import com.androidcommand.app.model.CompaniesDAO;

@Component
@Controller
@Configuration
public class CompaniesController {

    @GetMapping("/addCompany")
    public String
    sendForm(@ModelAttribute("company") CompaniesDAO company, BindingResult result, Model model){
	 	System.out.println("Entry0010 CompanyController.java before showing /addCompany ");
	 	List<String> company_functionlist = Arrays.asList("Find", "Add", "Update", "Delete");
	 	company.setFunctionlist(company_functionlist);
    	ArrayList<String> functions = company.getFunctions();
	 	System.out.println("Entry0020 CompanyController.java for /addCompany " + company.getFunctions() );
	 	company.selectCompany();
//      ModelAndView mav = new ModelAndView();
        model.addAttribute("functions",functions);
//      mav.setViewName("addCompany");
//    	company.initCassandra();

    	
//    	Set<Entry<String, Object>> companyMap = company.myCompaniesbean().getModel().entrySet();
//    	System.out.println("Entry0020 CompanyController.java " + companyMap.isEmpty());
//		Iterator<Entry<String, Object>> companyMapit = companyMap.iterator();
//		System.out.println("Entry0030 CompanyController.java ");
//		while (companyMapit.hasNext()) {
//			System.out.println("Entry0060 CompanyController.java ");
//		 	Map.Entry<String, Object> companyMapme= (Map.Entry<String, Object>)companyMapit.next();
//		 	String companyKey = companyMapme.getKey();
//		 	Object company_name = companyMapme.getValue(); 
//		 	System.out.println("In CompanyController.java Company is " + companyKey + ": " + company_name);
//		}
      return "addCompany";
//    return mav;
    }

    @PostMapping("/showCompany")
    public String processForm(@ModelAttribute("company") CompaniesDAO company, String company_name, String company_function) {
    	System.out.println("Entry0020 CompanyController.java for /showCOmpany " + company.getCompany() ); 
    	System.out.println("Entry0030 CompanyController.java for /showCompany " + company.getFunctions() ); 
        company.setCompany("Brad");
//    public String processForm(@ModelAttribute("company") CompaniesDAO company, BindingResult result) {
//		System.out.println("Entry0020 CompanyController.java Binding Result is " + result.getModel().values().toString() );    	
        return "showCompany";
    }

	/*	@GetMapping("/companies")
	public ModelAndView handleRequest(@ModelAttribute("companies") CompaniesDAO company_name ) {
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
