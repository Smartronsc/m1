package com.androidcommand.app;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import org.springframework.web.servlet.ModelAndView;

@Configuration
public class Home {
 
	  public Home() {}
	  
	    @Bean
	    public ModelAndView myHomebean() {
	    	System.out.println("In Home.java for MyHomeBean ");
		    ModelAndView mav = new ModelAndView();
		    mav.setViewName("home.html");
		    System.out.println("In Home.java for ModelandView " + mav.getViewName());

	        return mav;

	    }

	}