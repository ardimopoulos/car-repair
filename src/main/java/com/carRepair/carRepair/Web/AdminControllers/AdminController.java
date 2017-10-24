package com.carRepair.carRepair.Web.AdminControllers;


import com.carRepair.carRepair.Domain.Repair;
import com.carRepair.carRepair.Services.Repair.RepairService;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

@Controller
public class AdminController {

    private final static org.slf4j.Logger logger = LoggerFactory.getLogger(AdminController.class);

    @Autowired
    private RepairService repairService;

    @RequestMapping(value = {"/admin/home", "/admin"}, method = RequestMethod.GET)
    String getAdminView(Model model){

        List<Repair> repairs = repairService.getDailyServices();
        model.addAttribute("repairs" , repairs);

        return "/admin/home";
    }
}
