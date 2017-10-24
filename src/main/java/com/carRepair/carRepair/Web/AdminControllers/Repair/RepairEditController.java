package com.carRepair.carRepair.Web.AdminControllers.Repair;

import com.carRepair.carRepair.Forms.Repair.RepairForm;
import com.carRepair.carRepair.Forms.User.SearchForm;
import com.carRepair.carRepair.Forms.Vehicle.VehicleForm;
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
public class RepairEditController {

    private static final String REPAIR_FORM = "repairForm";

    @RequestMapping(value = "/admin/edit-repair", method = RequestMethod.GET)
    String editRepair(Model model, @RequestParam(name = "id", required = false) String id){

        //TODO check id and show form, messages


        if(!model.containsAttribute(REPAIR_FORM)) {
            model.addAttribute(REPAIR_FORM, new RepairForm());
        }
        return "/admin/repairs/edit-repair-view";
    }

    @RequestMapping(value = "/admin/edit-repair" ,  method = RequestMethod.POST)
    public String editRepair(@Valid @ModelAttribute(name = REPAIR_FORM) RepairForm repairForm, BindingResult bindingResult,
                             RedirectAttributes redirectAttributes){

        if(bindingResult.hasErrors()) {

            String type = (repairForm.getType().equals("true")) ? "long" : "short";
            String status = "";
            if(repairForm.getStatus().equals("0")){
                status = "pending";
            }else if(repairForm.getStatus().equals("1")){
                status = "inProgress";
            }else{
                status = "completed";
            }

            redirectAttributes.addFlashAttribute("org.springframework.validation.BindingResult.repairForm", bindingResult);
            redirectAttributes.addFlashAttribute(REPAIR_FORM, repairForm);
            redirectAttributes.addFlashAttribute( type, "selected");
            redirectAttributes.addFlashAttribute( "errorMessage",  "ERROR MESSAGE");

            return "redirect:/admin/edit-repair";
        }


        //TODO Edit service Fuunctionality


        return "redirect:/admin/edit-repair";
    }

}
