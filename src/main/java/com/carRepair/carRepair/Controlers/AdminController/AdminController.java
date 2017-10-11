package com.carRepair.carRepair.Controlers.AdminController;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class AdminController {

    @RequestMapping("/Admin")
    public String home(){


        return "Admin/home";
    }

}
