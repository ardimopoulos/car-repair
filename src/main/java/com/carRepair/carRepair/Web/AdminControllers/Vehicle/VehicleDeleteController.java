package com.carRepair.carRepair.Web.AdminControllers.Vehicle;

import com.carRepair.carRepair.Domain.Vehicle;
import com.carRepair.carRepair.Services.Vehicle.VehicleDeleteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class VehicleDeleteController {

    @Autowired
    private VehicleDeleteService vehicleDeleteService;

    @RequestMapping(value = "/admin/delete-vehicle", method = RequestMethod.POST)
    String deleteVehicle(Model model ,  RedirectAttributes redirectAttributes , @RequestParam("hidden_vehicleId" )Long hidden_vehicleId){

        vehicleDeleteService.deleteVehicle(hidden_vehicleId);
        redirectAttributes.addFlashAttribute("errorMessage" , "The vehicle successful delete!");

        return "redirect:/admin/search-vehicle";
    }

}
