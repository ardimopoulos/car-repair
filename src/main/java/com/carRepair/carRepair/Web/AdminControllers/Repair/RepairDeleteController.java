package com.carRepair.carRepair.Web.AdminControllers.Repair;

import com.carRepair.carRepair.Services.Repair.RepairService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class RepairDeleteController {

    @Autowired
    private RepairService repairService;

    @RequestMapping(value = "/admin/delete-repair", method = RequestMethod.POST)
    String deleteRepair(Model model , RedirectAttributes redirectAttributes ,@RequestParam("hidden_serviceId" )Long hidden_serviceId ){

        repairService.deleteRepair(hidden_serviceId);

        redirectAttributes.addFlashAttribute("errorMessage" , "The repair deleted successfully");
        return "redirect:/admin/search-repair";
    }

}
