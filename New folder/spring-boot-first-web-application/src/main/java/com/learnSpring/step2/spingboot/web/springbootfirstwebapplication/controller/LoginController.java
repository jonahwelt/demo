package com.learnSpring.step2.spingboot.web.springbootfirstwebapplication.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.learnSpring.step2.spingboot.web.service.LoginService;
@Controller
@SessionAttributes("name")
public class LoginController {
    
    @Autowired
    
    LoginService service;

    @RequestMapping(value="/login", method=RequestMethod.GET)
    public String showLoginPage(ModelMap model){
        // model.put("name", name);
        return "login";
    }
    @RequestMapping(value="/login", method=RequestMethod.POST)
    public String showWelcomePage(ModelMap model, @RequestParam String name, @RequestParam String password){
        boolean isValid = (service.validateUser(name, password));
        if(!isValid){
            model.put("errorMessage", "Invalid Credentials");
        return "login";
        }
        model.put("name", name);
        model.put("password", password);
        return "welcome";
    }
}
