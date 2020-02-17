/*
 * =============================================================================
 *
 *   Copyright (c) 2015, 2020, RichardBradleySmith.com All Rights Reserved
 *   
 */
package com.androidcommand.app;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class EmployeeController {
 
    private Map<Long, Employee> employeeMap = new HashMap<>();

    @ModelAttribute
    public void addAttributes(Model model) {
        model.addAttribute("msg", "In EmployeeController");
    }
    
    @RequestMapping(value = "/employee", method = RequestMethod.POST)
    public String submit(
      @ModelAttribute("employee") Employee employee,
      BindingResult result, ModelMap model) {
        if (result.hasErrors()) {
            return "error";
        }
        model.addAttribute("address", employee.getAddress());
        model.addAttribute("name", employee.getName());
        model.addAttribute("id", employee.getId());
 
        employeeMap.put(employee.getId(), employee);
 
        return "employeeView";
    }

}