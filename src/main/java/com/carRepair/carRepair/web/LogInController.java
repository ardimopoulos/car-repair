package com.carRepair.carRepair.web;

import com.carRepair.carRepair.Forms.LoginForm;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class LogInController {

    private static final String LOGIN_FORM = "loginForm";

    @RequestMapping(value="/" ,  method = RequestMethod.GET)
    public String home(){
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        if(auth.isAuthenticated()){
            if(auth.getAuthorities().equals("ADMIN")){return "redirect:/admin"; }
            else{return "redirect:/member";}
        }else{return "redirect:/login"; }
    }

    @RequestMapping(value="/login" ,  method = RequestMethod.GET)
    public String login(Model model){

        model.addAttribute(LOGIN_FORM, new LoginForm());
        return "login";
    }


}
