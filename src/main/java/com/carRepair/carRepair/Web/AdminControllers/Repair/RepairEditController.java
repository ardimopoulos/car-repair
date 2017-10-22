package com.carRepair.carRepair.Web.AdminControllers.Repair;

import com.carRepair.carRepair.Forms.User.SearchForm;
import com.carRepair.carRepair.Forms.Vehicle.VehicleForm;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

public class RepairEditController {
    private static final String SEARCH_FORM = "searchForm";
    @RequestMapping(value = "/admin/edit-repair", method = RequestMethod.GET)
    String editRepair(Model model){

        if(!model.containsAttribute(SEARCH_FORM)){
            model.addAttribute(SEARCH_FORM, new SearchForm());
        }
        return "/admin/repairs/edit-repair-view";
    }

    @RequestMapping(value = "/admin/edit-repair" ,  method = RequestMethod.POST)
    public String editRepair(){

        return "redirect:/admin/edit-repair";
    }

}
