package com.car_repair_shop.car_repair.web.admin_controllers.vehicle;

import com.car_repair_shop.car_repair.converters.VehicleConverter;
import com.car_repair_shop.car_repair.domain.Member;
import com.car_repair_shop.car_repair.domain.Vehicle;
import com.car_repair_shop.car_repair.exceptions.VehicleNotFoundException;
import com.car_repair_shop.car_repair.forms.vehicle.VehicleForm;
import com.car_repair_shop.car_repair.services.member.MemberService;
import com.car_repair_shop.car_repair.services.vehicle.VehicleService;
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
    public String getEditVehicleView(Model model, @RequestParam(name = "p", required = false) String p) {
        if (p != null) {
            try {
                Vehicle vehicle = vehicleService.getByPlate(p);
                VehicleForm vehicleForm = VehicleConverter.buildVehicleFormObject(vehicle);
                model.addAttribute(VEHICLE_FORM, vehicleForm);

            } catch (VehicleNotFoundException e) {
                model.addAttribute("errorMessage", "vehicle with plate "+ p + " not found");
            }
        }

        return "/admin/vehicle/edit-vehicle-view";
    }

    @RequestMapping(value = "/admin/edit-vehicle", method = RequestMethod.POST)
    public String editVehicleView(@Valid @ModelAttribute(name = VEHICLE_FORM) VehicleForm vehicleForm, BindingResult bindingResult,
                                  RedirectAttributes redirectAttributes) {

        if (vehicleForm.getVehicleId().equals("")) {
            redirectAttributes.addFlashAttribute("errorMessage", "Something went wrong");
            return "redirect:/admin/edit-repair";
        }

        if (bindingResult.hasErrors()) {
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
           redirectAttributes.addFlashAttribute("message", "Successful update!");

        } catch (Exception e) {
            redirectAttributes.addFlashAttribute("errorMessage", e.getMessage());
            redirectAttributes.addFlashAttribute(VEHICLE_FORM, vehicleForm);
        }

        return "redirect:/admin/edit-vehicle";
    }
}