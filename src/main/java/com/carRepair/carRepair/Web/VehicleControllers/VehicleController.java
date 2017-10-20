package com.carRepair.carRepair.Web.VehicleControllers;

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

    @RequestMapping(value = "admin/create-vehicle", method = RequestMethod.GET)
    public String getCreateVehicleView(Model model, VehicleForm vehicleForm, @RequestParam(value = "id", required = false) Long id, RedirectAttributes r) throws Exception {

        if(id != null){
            model.addAttribute("message","Create new vehicle");
            model.addAttribute("userId",id);


        }
        if(!model.containsAttribute(VEHICLE_FORM)){
            model.addAttribute(VEHICLE_FORM, new VehicleForm());
        }
        return "/admin/vehicle/create-vehicle";
    }

    @RequestMapping(value = "/admin/create-vehicle", method = RequestMethod.POST)
    public String createVehicle(Model model, @Valid @ModelAttribute(name = VEHICLE_FORM) VehicleForm vehicleForm,
                             BindingResult bindingResult, RedirectAttributes redirectAttributes){
        //String userId = vehicleForm.getUserId();
        if(bindingResult.hasErrors()) {
            redirectAttributes.addFlashAttribute("org.springframework.validation.BindingResult.vehicleForm", bindingResult);
            redirectAttributes.addFlashAttribute(VEHICLE_FORM, vehicleForm);
            redirectAttributes.addFlashAttribute("message", "Please fill the fields again");
            redirectAttributes.addFlashAttribute("errorMessage", "Create vehicle failed!");

            return "redirect:/admin/create-vehicle";
        }

        //long id = Long.valueOf(userId);

        Vehicle vehicle = VehicleConverter.buildVehicleObjecr(vehicleForm);
        try {

            vehicleService.insertVehicle(vehicle);

        } catch (Exception e) {
            e.printStackTrace();
        }


        /*User user = UserConverter.buildUserObjecr(userForm);
        Member member;*/
      /*  try {
           /* user = userService.insertUser(user);
            member = (Member) user; */ // Downcasting

            // If user is a simple user (false), redirect a message and user id to create vehicle page
           /* if(!user.getUserType()){
                String message = "Add vehicle for user: " + member.getFirstname() + " " + member.getLastname() + " - " + member.getVat();
                redirectAttributes.addFlashAttribute("message", message);
                redirectAttributes.addFlashAttribute("userId", user.getUserId());
                return "redirect:/admin/create-vehicle";
            }*/
/*
            String message = "New user is created: " + member.getFirstname() + " " + member.getLastname() + " - " + member.getVat();
            redirectAttributes.addFlashAttribute("message", message);
            redirectAttributes.addFlashAttribute("userId", member.getUserId());

        }catch (Exception e){
            redirectAttributes.addFlashAttribute("message", "There is already an account with same VAT or email.");
            redirectAttributes.addFlashAttribute(USER_FORM, userForm);
        }*/

        return "redirect:/admin/create-vehicle";
    }

}
