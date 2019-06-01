package com.car_repair_shop.car_repair.web.admin_controllers.vehicle;

import com.car_repair_shop.car_repair.domain.Vehicle;
import com.car_repair_shop.car_repair.exceptions.VehicleNotFoundException;
import com.car_repair_shop.car_repair.forms.vehicle.VehicleSearchForm;
import com.car_repair_shop.car_repair.services.vehicle.VehicleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;
import java.util.List;

import static com.car_repair_shop.car_repair.properties.Constants.ERROR_MESSAGE;

@Controller
public class VehicleSearchController {

    private static final String VEHICLE_SEARCH_FORM = "vehicleSearchForm";

    @Autowired
    private VehicleService vehicleService;

    @RequestMapping(value = "/admin/search-vehicle", method = RequestMethod.GET)
    public String searchRepair(Model model){

        if(!model.containsAttribute(VEHICLE_SEARCH_FORM)){
            model.addAttribute(VEHICLE_SEARCH_FORM, new VehicleSearchForm());
        }

        return "/admin/vehicle/search-vehicle-view";
    }

    @RequestMapping(value = "/admin/search-vehicle", method = RequestMethod.POST)
    public String searchRepair(@Valid @ModelAttribute(VEHICLE_SEARCH_FORM)
                                           VehicleSearchForm vehicleSearchForm,
                               RedirectAttributes redirectAttributes,
                               @RequestParam("button") String button){

        if (button.equals("Search Vat")) {
            try {
                List<Vehicle> vehicles = vehicleService.getVehiclesByMemberVat(vehicleSearchForm.getVat());
                redirectAttributes.addFlashAttribute("vehicles", vehicles);

            } catch (VehicleNotFoundException vehicleNotFound) {
                redirectAttributes.addFlashAttribute(ERROR_MESSAGE, vehicleNotFound.getMessage());
            }

        }

        if (button.equals("Search Plate")) {
            try{
                List<Vehicle> vehicles = vehicleService.getVehiclesByMemberPlate(vehicleSearchForm.getPlate());
                redirectAttributes.addFlashAttribute("vehicles" , vehicles);

            } catch (VehicleNotFoundException vehicleNotFound) {
                redirectAttributes.addFlashAttribute(ERROR_MESSAGE, vehicleNotFound.getMessage());
            }
        }

        return "redirect:/admin/search-vehicle";
    }

}
