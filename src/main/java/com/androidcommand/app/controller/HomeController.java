package com.androidcommand.app.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/home")
public class HomeController 
{
	@ModelAttribute
    public void addAttributes(Model model) {
        model.addAttribute("msg", "In HomeController");
    }
	
    public HomeController() { }
    
    @RequestMapping(method=RequestMethod.GET)          // only accepts Get requests
    public ModelAndView myHomebean() {
    	System.out.println("In Home.java for MyHomeBean ");
	    ModelAndView mav = new ModelAndView();
	    mav.setViewName("home.html");
	    System.out.println("In Home.java for ModelandView " + mav.getViewName());
	    return mav;
    }
}