package com.carRepair.carRepair.Web.AdminControllers.Vehicle;

import com.carRepair.carRepair.Converters.VehicleConverter;
import com.carRepair.carRepair.Domain.Member;
import com.carRepair.carRepair.Domain.Vehicle;
import com.carRepair.carRepair.Forms.Vehicle.VehicleForm;
import com.carRepair.carRepair.Services.Member.MemberService;
import com.carRepair.carRepair.Services.Vehicle.VehicleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;

@Controller
public class VehicleCreateController {

    private static final String VEHICLE_FORM = "vehicleForm";

    @Autowired
    private VehicleService vehicleService;

    @Autowired
    private MemberService memberService;

    @RequestMapping(value = "admin/create-vehicle", method = RequestMethod.GET)
    public String getCreateVehicleView(Model model, RedirectAttributes redirectAttributes){

        if(!model.containsAttribute(VEHICLE_FORM)){
            model.addAttribute(VEHICLE_FORM, new VehicleForm());
        }
        return "/admin/vehicle/create-vehicle-view";
    }

    @RequestMapping(value = "/admin/create-vehicle", method = RequestMethod.POST)
    public String createVehicle(Model model, @Valid @ModelAttribute(name = VEHICLE_FORM) VehicleForm vehicleForm,
                             BindingResult bindingResult, RedirectAttributes redirectAttributes){

        if(bindingResult.hasErrors()) {
            redirectAttributes.addFlashAttribute("org.springframework.validation.BindingResult.vehicleForm", bindingResult);
            redirectAttributes.addFlashAttribute(VEHICLE_FORM, vehicleForm);
            return "redirect:/admin/create-vehicle";
        }

        String memberVat = vehicleForm.getVat();
        Vehicle vehicle = null;

        try {
            vehicle = VehicleConverter.buildVehicleObjecr(vehicleForm);
            Member member = memberService.getMemberByVat(memberVat);
            vehicle.setMember(member);
            vehicle = vehicleService.insertVehicle(vehicle);
        } catch (Exception e) {
            String message = "There is not user with VAT: "+memberVat+
                             " or vehicle with plate " +vehicle.getPlate()+" already exists";
            redirectAttributes.addFlashAttribute("errorMessage", message);
            redirectAttributes.addFlashAttribute(VEHICLE_FORM, vehicleForm);
            return "redirect:/admin/create-vehicle";
        }

        String message = "Vehicle with plate: " + vehicle.getPlate().toUpperCase() +
                         " is created for user with VAT: " + memberVat;
        redirectAttributes.addFlashAttribute("message", message);

        return "redirect:/admin/create-vehicle";
    }

}
