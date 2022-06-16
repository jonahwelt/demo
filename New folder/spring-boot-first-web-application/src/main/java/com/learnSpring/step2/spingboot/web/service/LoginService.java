package com.learnSpring.step2.spingboot.web.service;

import org.springframework.stereotype.Component;

@Component
public class LoginService {
    
    public boolean validateUser(String userId,String password){
        return userId.equalsIgnoreCase("jonah") && 
        password.equalsIgnoreCase("welt");
    }
}
