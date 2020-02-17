package com.androidcommand.app.web.controller;

import java.util.Arrays;
import java.util.Calendar;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import com.androidcommand.app.business.entities.Feature;
import com.androidcommand.app.business.entities.Row;
import com.androidcommand.app.business.entities.SeedStarter;
import com.androidcommand.app.business.entities.Type;
import com.androidcommand.app.business.entities.Variety;
import com.androidcommand.app.business.services.SeedStarterService;
import com.androidcommand.app.business.services.VarietyService;


@Controller
public class SeedStarterMngController {


    @Autowired
    private VarietyService varietyService;
    
    @Autowired
    private SeedStarterService seedStarterService;
    
    
    
    public SeedStarterMngController() {
        super();
    }

    
    
    @ModelAttribute("allTypes")
    public List<Type> populateTypes() {
        return Arrays.asList(Type.ALL);
    }
    
    @ModelAttribute("allFeatures")
    public List<Feature> populateFeatures() {
        return Arrays.asList(Feature.ALL);
    }
    
    @ModelAttribute("allVarieties")
    public List<Variety> populateVarieties() {
        return this.varietyService.findAll();
    }
    
    @ModelAttribute("allSeedStarters")
    public List<SeedStarter> populateSeedStarters() {
        return this.seedStarterService.findAll();
    }
    
    
    
    @RequestMapping({"/","/seedstartermng"})
    public String showSeedstarters(final SeedStarter seedStarter) {
        seedStarter.setDatePlanted(Calendar.getInstance().getTime());
        return "seedstartermng";
    }
    
    
    
    @RequestMapping(value="/seedstartermng", params={"save"})
    public String saveSeedstarter(final SeedStarter seedStarter, final BindingResult bindingResult, final ModelMap model) {
        if (bindingResult.hasErrors()) {
            return "seedstartermng";
        }
        this.seedStarterService.add(seedStarter);
        model.clear();
        return "redirect:/seedstartermng";
    }
    

    
    @RequestMapping(value="/seedstartermng", params={"addRow"})
    public String addRow(final SeedStarter seedStarter, final BindingResult bindingResult) {
        seedStarter.getRows().add(new Row());
        return "seedstartermng";
    }
    
    
    @RequestMapping(value="/seedstartermng", params={"removeRow"})
    public String removeRow(final SeedStarter seedStarter, final BindingResult bindingResult, final HttpServletRequest req) {
        final Integer rowId = Integer.valueOf(req.getParameter("removeRow"));
        seedStarter.getRows().remove(rowId.intValue());
        return "seedstartermng";
    }


}
