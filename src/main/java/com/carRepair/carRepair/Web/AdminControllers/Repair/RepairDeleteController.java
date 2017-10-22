package com.carRepair.carRepair.Web.AdminControllers.Repair;

import com.carRepair.carRepair.Domain.User;
import com.carRepair.carRepair.Exceptions.UserNotFoundException;
import com.carRepair.carRepair.Services.RepairDeleteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

public class RepairDeleteController {

    @Autowired
    private RepairDeleteService repairDeleteService;

    @RequestMapping(value = "/admin/delete-repair", method = RequestMethod.POST)
    String deleteRepair(Model model , @RequestParam("hidden_email" )Long hidden_serviceId ){

            repairDeleteService.deleteRepair(hidden_serviceId);

        return "redirect:/admin/search-repair";
    }

}
