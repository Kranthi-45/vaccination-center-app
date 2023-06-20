package com.example.demo.controller;

import com.example.demo.dao.vaccinationCenterDao;
import com.example.demo.entity.pacUser;
import com.example.demo.entity.vaccinationCenter;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class vaccinationCenterController {

    private final vaccinationCenterDao vaccinationCenterDao;

    @Autowired
    public vaccinationCenterController(vaccinationCenterDao vaccinationCenterDao) {
        this.vaccinationCenterDao = vaccinationCenterDao;
    }

    
    @GetMapping("/vaccinationcenter")
    public ModelAndView vaccinationCenterHomePage() {
        ModelAndView mv = new ModelAndView();
        System.out.println("vaccinationList " + vaccinationCenterDao.read());
        mv.addObject("vaccinationCentersList", vaccinationCenterDao.read());
        mv.addObject("vaccinationCenter", new vaccinationCenter());
        mv.setViewName("vaccinationcenter");
        return mv;
    }
    
    
    @GetMapping("/addVaccinationCenter")
    public ModelAndView addVaccinationCenter() {
        ModelAndView mv = new ModelAndView();
    	List<String> cityList = new ArrayList<>();
    	cityList.add("South Bengaluru");
    	cityList.add("North Bengaluru");
    	cityList.add("Hyderabad");
    	cityList.add("Pune");
    	cityList.add("Mumbai");
        mv.addObject("cityList", cityList);
        mv.addObject("addVaccinationCenter", new vaccinationCenter());
        mv.setViewName("addNewVaccinationCenter");
        return mv;
    }
    
    @GetMapping("/select")
    public ModelAndView select(@RequestParam("vid") Long id) {
        ModelAndView mv = new ModelAndView();
    	List<String> cityList = new ArrayList<>();
    	cityList.add("South Bengaluru");
    	cityList.add("North Bengaluru");
    	cityList.add("Hyderabad");
    	cityList.add("Pune");
    	cityList.add("Mumbai");
        mv.addObject("cityList", cityList);
        vaccinationCenter vaccinationCenter = vaccinationCenterDao.read(id).orElse(null);
        if(vaccinationCenter != null) {
//            mv.addObject("selectedCity", vaccinationCenter.getCity());
            mv.addObject("selectedCity", "Hyderabad");

        }
        mv.addObject("addVaccinationCenter", vaccinationCenter);
        mv.setViewName("addNewVaccinationCenter");
        return mv;
    }
    
    @GetMapping("/view")
    public ModelAndView view(@RequestParam("vid") Long id) {
        ModelAndView mv = new ModelAndView();
        mv.addObject("viewVaccinationCenter", vaccinationCenterDao.read(id).orElse(null));
        mv.setViewName("viewVaccinationCenter");
        return mv;
    }
    
    @GetMapping("/delete")
    public ModelAndView delete(@RequestParam("vid") Long id) {
        ModelAndView mv = new ModelAndView();
        vaccinationCenterDao.delete(id);
        mv.addObject("vaccinationCentersList", vaccinationCenterDao.read());
        mv.addObject("vaccinationCenter", new vaccinationCenter());
        mv.setViewName("vaccinationcenter");
        return mv;                                                                                                            	
	}
	
    @PostMapping("/addNewVaccinationCenter")
    public ModelAndView processForm(@ModelAttribute("addVaccinationCenter") vaccinationCenter vaccinationCenter, 
    								@RequestParam(value = "add", required = false) String add,
                                    @RequestParam(value = "modify", required = false) String modify,
                                    @RequestParam(value = "delete", required = false) String delete) {

        if (add != null) {
            // Process add operation
        	vaccinationCenterDao.create(vaccinationCenter);
            // ...
        } else if (modify != null) {
            // Process modify operation
        	System.out.println("modify vacination center");
        	System.out.println(vaccinationCenter);

        	vaccinationCenterDao.update(vaccinationCenter);
            // ...
        } else if (delete != null) {
            // Process delete operation
            Long id = vaccinationCenter.getId(); // Get the 'id' from the branch object
            // Use the "id" parameter to delete the branch with the specified ID
            vaccinationCenterDao.delete(id);
            // ...
        }

        return vaccinationCenterHomePage();
    }

}
