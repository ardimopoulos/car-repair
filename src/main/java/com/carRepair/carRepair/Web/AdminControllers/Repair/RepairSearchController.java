package com.carRepair.carRepair.Web.AdminControllers.Repair;

import com.carRepair.carRepair.Forms.Repair.RepairSearchForm;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class RepairSearchController {

    private static final String REPAIR_SEARCH_FORM = "repairSearchForm";

    @RequestMapping(value = "/admin/search-repair", method = RequestMethod.GET)
    public String searchRepair(Model model){

        if(!model.containsAttribute(REPAIR_SEARCH_FORM)){
            model.addAttribute(REPAIR_SEARCH_FORM, new RepairSearchForm());
        }

        return "/admin/repairs/search-repair-view";
    }

}
