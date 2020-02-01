package com.androidcommand.app;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@ControllerAdvice
public class CompaniesController {
 
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
    }

}