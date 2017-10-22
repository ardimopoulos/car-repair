package com.carRepair.carRepair.Web.AdminControllers;

import com.carRepair.carRepair.Converters.UserConverter;
import com.carRepair.carRepair.Converters.VehicleConverter;
import com.carRepair.carRepair.Domain.Member;
import com.carRepair.carRepair.Domain.User;
import com.carRepair.carRepair.Domain.Vehicle;
import com.carRepair.carRepair.Forms.UserForm;
import com.carRepair.carRepair.Forms.VehicleForm;
import com.carRepair.carRepair.Services.MemberService;
import com.carRepair.carRepair.Services.UserService;
import com.carRepair.carRepair.Services.VehicleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.method.P;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;

@Controller
public class VehicleController {

    private static final String VEHICLE_FORM = "vehicleForm";

    @Autowired
    private VehicleService vehicleService;

    @Autowired
    private MemberService memberService;

    @RequestMapping(value = "admin/add-vehicle", method = RequestMethod.GET)
    public String getCreateVehicleView(Model model, RedirectAttributes redirectAttributes){

        if(!model.containsAttribute(VEHICLE_FORM)){
            model.addAttribute(VEHICLE_FORM, new VehicleForm());
        }
        return "/admin/vehicle/add-vehicle";
    }

    @RequestMapping(value = "/admin/add-vehicle", method = RequestMethod.POST)
    public String createVehicle(Model model, @Valid @ModelAttribute(name = VEHICLE_FORM) VehicleForm vehicleForm,
                             BindingResult bindingResult, RedirectAttributes redirectAttributes){

        if(bindingResult.hasErrors()) {
            redirectAttributes.addFlashAttribute("org.springframework.validation.BindingResult.vehicleForm", bindingResult);
            redirectAttributes.addFlashAttribute(VEHICLE_FORM, vehicleForm);
            //redirectAttributes.addFlashAttribute("message", "Please fill the fields again");
            //redirectAttributes.addFlashAttribute("errorMessage", "Create vehicle failed!");

            return "redirect:/admin/add-vehicle";
        }

        String memberVat = vehicleForm.getVat();
        Vehicle vehicle = VehicleConverter.buildVehicleObjecr(vehicleForm);

        try {
            Member member = memberService.getMemberByVat(memberVat);
            vehicle.setMember(member);
            vehicle = vehicleService.insertVehicle(vehicle);
        } catch (Exception e) {
            String message = "Add vehicle failed: There is not user with VAT: " + memberVat +
                            " or vehicle with plate " +vehicle.getPlate()+" already exists";
            redirectAttributes.addFlashAttribute("errormessage", message);
            return "redirect:/admin/add-vehicle";
        }

        String message = "Vehicle with plate: " + vehicle.getPlate().toUpperCase() + " is created for user with VAT: " + memberVat;
        redirectAttributes.addFlashAttribute("message", message);

        return "redirect:/admin/add-vehicle";
    }

}
