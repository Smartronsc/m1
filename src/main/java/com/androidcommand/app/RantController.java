/*
 * =============================================================================
 *
 *   Copyright (c) 2020 RichardBradleySmith.com All Rights Reserved
 *
 * =============================================================================
 */
package com.androidcommand.app;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/rant")                               // only accepts things starting with /rant
public class RantController {
    
	@ModelAttribute
    public void addAttributes(Model model) {
        model.addAttribute("msg", "In RantController");
    }
	
    public RantController() { }
    
    @RequestMapping(method=RequestMethod.GET)          // only accepts Get requests
    public String post(Model model) {
		System.out.println("In RantController" + model.toString() );
        return "redirect:/companies.jsp";
	    }
   }
