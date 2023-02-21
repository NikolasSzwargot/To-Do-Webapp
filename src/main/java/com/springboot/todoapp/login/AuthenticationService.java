package com.springboot.todoapp.login;

import org.springframework.stereotype.Service;

@Service
public class AuthenticationService {
    public boolean authenticate(String username, String password){
        boolean validUsername = username.equalsIgnoreCase("admin");
        boolean validPassword = password.equalsIgnoreCase("admin");
        return validUsername && validPassword;
    }
}
