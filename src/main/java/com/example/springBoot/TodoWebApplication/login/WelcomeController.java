package com.example.springBoot.TodoWebApplication.login;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
// import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.annotation.RequestMethod;


@Controller
@SessionAttributes("username")
public class WelcomeController {
    // Model:- whenever you pass anything from your controller to your jsp, we use model
    // in controller when we anything display on the view, we put it into a model
    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String goToWelcomePage(/*@RequestParam String name, ModelMap model*/    ModelMap model) {
        model.put("username", getLoggedinUsername());
        return "Welcome";
    }

    private String getLoggedinUsername(){
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        return authentication.getName();
    }
}

