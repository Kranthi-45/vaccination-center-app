package com.example.demo.controller;

import com.example.demo.dao.citizensDao;
import com.example.demo.entity.citizens;
import com.example.demo.entity.vaccinationCenter;

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
public class citizensController {

    private final citizensDao citizensDao;

    @Autowired
    public citizensController(citizensDao citizensDao) {
        this.citizensDao = citizensDao;
    }

    
    @GetMapping("/citizens")
    public ModelAndView citizensHomePage() {
        ModelAndView mv = new ModelAndView();
        Long id = (long) 3;
        citizens citizenList = citizensDao.read(id).orElse(null);
        System.out.println(citizenList.getVaccinationCenter().getName());
        System.out.println("citizens " + citizensDao.read());
        mv.addObject("citizensList", citizensDao.read());
        mv.addObject("citizens", new citizens());
        mv.setViewName("citizens");
        return mv;
    }
    
    @GetMapping("/addCitizens")
    public ModelAndView addaddCitizens() {
        ModelAndView mv = new ModelAndView();
        mv.addObject("addCitizen", new citizens());
        mv.setViewName("addCitizens");
        return mv;
    }
    
    @GetMapping("/selectCitizen")
    public ModelAndView select(@RequestParam("cid") Long id) {
        ModelAndView mv = new ModelAndView();
        mv.addObject("addCitizen", citizensDao.read(id).orElse(null));
        mv.setViewName("addCitizens");
        return mv;
    }
    
    @GetMapping("/viewCitizen")
    public ModelAndView view(@RequestParam("cid") Long id) {
        ModelAndView mv = new ModelAndView();
        mv.addObject("viewCitizen", citizensDao.read(id).orElse(null));
        mv.setViewName("viewCitizen");
        return mv;
    }
    
    @GetMapping("/deleteCitizen")
    public ModelAndView delete(@RequestParam("cid") Long id) {
        ModelAndView mv = new ModelAndView();
        citizensDao.delete(id);
        System.out.println("citizens " + citizensDao.read());
        mv.addObject("citizensList", citizensDao.read());
        mv.addObject("citizens", new citizens());
        mv.setViewName("citizens");
        return mv;                                                                                                            	
	}
    
    @PostMapping("/addNewCitizen")
    public ModelAndView processForm(@ModelAttribute("addCitizen") citizens citizens, 
    								@RequestParam(value = "add", required = false) String add,
                                    @RequestParam(value = "modify", required = false) String modify,
                                    @RequestParam(value = "delete", required = false) String delete) {

        if (add != null) {
            // Process add operation
        	citizensDao.create(citizens);
            // ...
        } else if (modify != null) {
            // Process modify operation
        	System.out.println("modify citizen center");
        	System.out.println(citizens);
        	citizensDao.update(citizens);
            // ...
        } else if (delete != null) {
            // Process delete operation
            Long id = citizens.getId(); // Get the 'id' from the branch object
            // Use the "id" parameter to delete the branch with the specified ID
            citizensDao.delete(id);
            // ...
        }
        return citizensHomePage();
    }
}
