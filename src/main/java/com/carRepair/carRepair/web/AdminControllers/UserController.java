package com.carRepair.carRepair.web.AdminControllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller

public class UserController {

    @RequestMapping(value = {"user/home", "/user"}, method = RequestMethod.GET)
    public String getUserView(){
        return "user/home";
    }
}
