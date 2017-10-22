package com.carRepair.carRepair.Web.AdminControllers.Vehicle;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

public class VehicleEditController {

    @RequestMapping(value = "/admin/edit-vehicle", method = RequestMethod.GET)
    String editRepair(Model model){

        return "/admin/vehicle/edit-vehicle-view";
    }

}
