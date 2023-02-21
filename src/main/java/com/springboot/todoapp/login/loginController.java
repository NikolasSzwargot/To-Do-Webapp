package com.springboot.todoapp.login;

import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.slf4j.Logger;
import org.springframework.web.bind.annotation.SessionAttributes;

@Controller
@SessionAttributes("name")
public class loginController {

    private AuthenticationService authenticationLoginService;

    public loginController(AuthenticationService authenticationLoginService) {
        this.authenticationLoginService = authenticationLoginService;
    }

    @RequestMapping(value = "login", method = RequestMethod.GET)
    public String getLoginView(){
        return "login";
    }

    //name = admin
    //password = admin
    @RequestMapping(value = "login", method = RequestMethod.POST)
    public String goToWelcomePage(@RequestParam String name, @RequestParam String password, ModelMap model){
        model.put("name", name);
        model.put("password", password);
        if (authenticationLoginService.authenticate(name, password))
            return "welcome";
        else {
            model.put("error", "Invalid Credentials. Please try again");
            return "login";
        }
    }
}
