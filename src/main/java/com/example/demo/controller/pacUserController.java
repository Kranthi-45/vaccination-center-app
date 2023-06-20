package com.example.demo.controller;

import com.example.demo.dao.pacUserDao;
import com.example.demo.entity.pacUser;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class pacUserController {

    private final pacUserDao pacUserDao;

    @Autowired
    public pacUserController(pacUserDao pacUserDao) {
        this.pacUserDao = pacUserDao;
    }
    
    @GetMapping("/login")
    public ModelAndView showLoginForm() {
        ModelAndView mv = new ModelAndView();
        mv.addObject("users", pacUserDao.read());
        mv.addObject("user", new pacUser());
        mv.setViewName("login");
        return mv;
    }
    
    @PostMapping("/login")
    public ModelAndView login(@ModelAttribute("user") pacUser user, HttpSession session) {
        ModelAndView mv = new ModelAndView();

        // Check if the user exists in the database
        pacUser existingUser = pacUserDao.fetchUserByNameAndPassword(user.getName(), user.getPassword());
        System.out.println("login existing " + existingUser);
        if (existingUser != null) {
            // User authentication successful
            mv.setViewName("vaccinationcenter");
            mv.addObject("message", "Login successful!");
            mv.addObject("user", existingUser);
            session.setAttribute("user", existingUser);
        } else {
            // User authentication failed
            mv.setViewName("login");
//            mv.setViewName("vaccinationcenter");
            mv.addObject("error", "Invalid username or password!");
//            return showLoginForm();
        }
        return mv;
    }

    @GetMapping("/registration")
    public ModelAndView showRegistrationForm() {
        ModelAndView mv = new ModelAndView();
        mv.addObject("users", pacUserDao.read());
        mv.addObject("user", new pacUser());
        mv.setViewName("registration");
        return mv;
    }

    @PostMapping("/registration")
    public ModelAndView register(@ModelAttribute("user") pacUser user) {
        ModelAndView mv = new ModelAndView();

        // Check if the username is already taken
        pacUser existingUser = pacUserDao.read(user.getName());
        if (existingUser != null) {
            // Username is already taken
            mv.setViewName("registration");
            mv.addObject("error", "Username already exists!");
        } else {
            // Register the user
            pacUser createdUser = pacUserDao.create(user);
            mv.setViewName("success");
            mv.addObject("message", "Registration successful!");
            mv.addObject("user", createdUser);
        }
        return showRegistrationForm();
    }
}
