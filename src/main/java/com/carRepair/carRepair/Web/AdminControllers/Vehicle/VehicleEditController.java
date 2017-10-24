package com.carRepair.carRepair.Web.AdminControllers.Vehicle;

import com.carRepair.carRepair.Domain.Vehicle;
import com.carRepair.carRepair.Exceptions.Vehicle.VehicleNotFoundException;
import com.carRepair.carRepair.Forms.Vehicle.VehicleForm;
import com.carRepair.carRepair.Forms.Vehicle.VehicleSearchForm;
import com.carRepair.carRepair.Services.Vehicle.VehicleSearchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class VehicleEditController {

    private static final String VEHICLE_FORM = "vehicleForm";
    private static final String VEHICLE_SEARCH_FORM = "vehicleSearchForm";

    @Autowired
    private VehicleSearchService vehicleSearchService;

    @RequestMapping(value = "/admin/edit-vehicle", method = RequestMethod.GET)
    public String getEditVehicleView(Model model ,@RequestParam(name="plate",required = false)String plate){

        if(plate !=null) {
            try {
                List<Vehicle> vehicles = vehicleSearchService.getByPlate(plate); // one vehicle
                model.addAttribute("vehicles", vehicles);
            } catch (VehicleNotFoundException vehicleNotFound) { model.addAttribute("errorMessage", vehicleNotFound.getMessage()); }

            if (!model.containsAttribute(VEHICLE_FORM)) { model.addAttribute(VEHICLE_FORM, new VehicleForm()); } else { }

        } else{ model.addAttribute(VEHICLE_SEARCH_FORM, new VehicleSearchForm()); }



        return "/admin/vehicle/edit-vehicle-view";
    }



}
