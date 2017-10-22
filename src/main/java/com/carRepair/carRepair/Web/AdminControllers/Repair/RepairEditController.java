package com.carRepair.carRepair.Web.AdminControllers.Repair;

import com.carRepair.carRepair.Forms.User.SearchForm;
import com.carRepair.carRepair.Forms.Vehicle.VehicleForm;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class RepairEditController {

    @RequestMapping(value = "/admin/edit-repair", method = RequestMethod.GET)
    String editRepair(Model model){


        return "/admin/repairs/edit-repair-view";
    }

    @RequestMapping(value = "/admin/edit-repair" ,  method = RequestMethod.POST)
    public String editRepair(){

        return "redirect:/admin/edit-repair";
    }

}
