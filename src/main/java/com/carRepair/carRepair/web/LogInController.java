package com.carRepair.carRepair.web;

import com.carRepair.carRepair.Forms.LoginForm;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class LogInController {

    private static final String LOGIN_FORM = "loginForm";

    @RequestMapping(value="/" ,  method = RequestMethod.GET)
    public String index(Model model){

        model.addAttribute(LOGIN_FORM, new LoginForm());
        return "login";
    }


}
