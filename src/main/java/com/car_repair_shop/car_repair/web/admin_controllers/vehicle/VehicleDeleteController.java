package com.car_repair_shop.car_repair.web.admin_controllers.vehicle;

import com.car_repair_shop.car_repair.services.vehicle.VehicleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import static com.car_repair_shop.car_repair.properties.Constants.ERROR_MESSAGE;

@Controller
public class VehicleDeleteController {

    @Autowired
    private VehicleService vehicleService;

    @RequestMapping(value = "/admin/delete-vehicle", method = RequestMethod.POST)
    String deleteVehicle(RedirectAttributes redirectAttributes , @RequestParam("hidden_vehicleId" )Long hidden_vehicleId) {
        vehicleService.deleteVehicle(hidden_vehicleId);
        redirectAttributes.addFlashAttribute(ERROR_MESSAGE , "The vehicle successful delete!");

        return "redirect:/admin/search-vehicle";
    }

}
