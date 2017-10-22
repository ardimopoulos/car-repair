package com.carRepair.carRepair.Web.AdminControllers.Vehicle;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class VehicleEditController {

    @RequestMapping(value = "/admin/edit-vehicle", method = RequestMethod.GET)
    public String getEditVehicleView(){

        return "/admin/vehicle/edit-vehicle-view";
    }

}
