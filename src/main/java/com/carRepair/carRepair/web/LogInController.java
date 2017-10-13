package com.carRepair.carRepair.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class LogInController {

    @RequestMapping(value="/" ,  method = RequestMethod.GET)
    public String index(){

        return "login";
    }


}
