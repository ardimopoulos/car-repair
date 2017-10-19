package com.carRepair.carRepair.Web.VehicleControllers;

import com.carRepair.carRepair.Domain.Vehicle;
import com.carRepair.carRepair.Forms.VehicleForm;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class VehicleController {

    private static final String VEHICLE_FORM = "vehicleForm";

    @RequestMapping(value = "admin/create-vehicle", method = RequestMethod.GET)
    public String getCreateVehicleView(RedirectAttributes r,Model model, VehicleForm vehicleForm, @RequestParam(value = "id", required = false) Long id){

        if(id != null){
            model.addAttribute("message","Create new vehicle");
            model.addAttribute("userId",id);
            //r.addFlashAttribute("userId", id);
        }
        if(!model.containsAttribute(VEHICLE_FORM)){
            model.addAttribute(VEHICLE_FORM, new VehicleForm());
        }
        return "/admin/vehicle/create-vehicle";
    }

}
