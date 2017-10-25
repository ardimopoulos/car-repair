package com.carRepair.carRepair.Web.AdminControllers.Vehicle;

import com.carRepair.carRepair.Converters.VehicleConverter;
import com.carRepair.carRepair.Domain.Member;
import com.carRepair.carRepair.Domain.Vehicle;
import com.carRepair.carRepair.Exceptions.UserNotFoundException;
import com.carRepair.carRepair.Exceptions.Vehicle.VehicleNotFoundException;
import com.carRepair.carRepair.Forms.Vehicle.VehicleForm;
import com.carRepair.carRepair.Services.Member.MemberService;
import com.carRepair.carRepair.Services.Repair.RepairService;
import com.carRepair.carRepair.Services.Vehicle.VehicleService;
import org.springframework.beans.factory.annotation.Autowired;
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
public class VehicleEditController {

    private static final String VEHICLE_FORM = "vehicleForm";

    @Autowired
    private VehicleService vehicleService;

    @Autowired
    private MemberService memberService;

    @RequestMapping(value = "/admin/edit-vehicle", method = RequestMethod.GET)
    public String getEditVehicleView(Model model, @RequestParam(name = "p", required = false) String p){

        if(p != null){

            try {
                Vehicle vehicle = vehicleService.findByPlate(p);
                VehicleForm vehicleForm = VehicleConverter.buildVehicleFormObject(vehicle);
                model.addAttribute(VEHICLE_FORM, vehicleForm);
            } catch (VehicleNotFoundException e) {
                model.addAttribute("errorMessage", "Vehicle with plate "+ p + " not found");
            }

        }
        return "/admin/vehicle/edit-vehicle-view";
    }

    @RequestMapping(value = "/admin/edit-vehicle", method = RequestMethod.POST)
    public String editVehicleView(@Valid @ModelAttribute(name = VEHICLE_FORM) VehicleForm vehicleForm, BindingResult bindingResult,
                                  RedirectAttributes redirectAttributes){

        if(vehicleForm.getVehicleId().equals("")){
            redirectAttributes.addFlashAttribute("errormessage", "Something went wrong");
            return "redirect:/admin/edit-repair";
        }

        if(bindingResult.hasErrors()){
            redirectAttributes.addFlashAttribute("org.springframework.validation.BindingResult.vehicleForm", bindingResult);
            redirectAttributes.addFlashAttribute(VEHICLE_FORM, vehicleForm);
            return "redirect:/admin/edit-vehicle";
        }

        try {
            Vehicle vehicle = VehicleConverter.buildVehicleObjecr(vehicleForm);
            vehicle.setVehicleId(Long.valueOf(vehicleForm.getVehicleId()));
            Member member = memberService.getMemberByVat(vehicleForm.getVat());
            vehicle.setMember(member);
            vehicleService.insertVehicle(vehicle);
        }catch(UserNotFoundException e){
            redirectAttributes.addFlashAttribute("errorMessage", e.getMessage());
        }catch (Exception e) {
            redirectAttributes.addFlashAttribute("errorMessage", "Something went wrong");
        }

        return "redirect:/admin/edit-vehicle";
    }
}