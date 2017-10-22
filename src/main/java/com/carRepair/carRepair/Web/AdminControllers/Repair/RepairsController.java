package com.carRepair.carRepair.Web.AdminControllers.Repair;

import com.carRepair.carRepair.Forms.Repair.RepairForm;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class RepairsController {

    private static final String REPAIR_FORM = "repairForm";

    @RequestMapping(value = "/admin/create-repair" ,  method = RequestMethod.GET)
    public String getCreateServiceView(Model model, RepairForm repairForm){

        model.addAttribute(REPAIR_FORM, new RepairForm());
        return "/admin/repairs/create-repair-view";
    }

    @RequestMapping(value = "/admin/create-repair" ,  method = RequestMethod.POST)
    public String createService(){

        return "redirect:/admin/create-repair";
    }



}
