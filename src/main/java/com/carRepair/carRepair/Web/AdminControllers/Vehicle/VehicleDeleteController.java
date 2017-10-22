package com.carRepair.carRepair.Web.AdminControllers.Vehicle;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class VehicleDeleteController {

    @RequestMapping(value = "/admin/delete-vehicle", method = RequestMethod.POST)
    String deleteVehicle(Model model , @RequestParam("hidden_vehicleId" )Long hidden_vehicleId){



        return "redirect:/admin/search-vehicle";
    }

}
