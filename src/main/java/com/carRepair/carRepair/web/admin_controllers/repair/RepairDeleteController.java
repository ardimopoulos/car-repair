package com.carRepair.carRepair.web.admin_controllers.repair;

import com.carRepair.carRepair.services.repair.RepairService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class RepairDeleteController {

    @Autowired
    private RepairService repairService;

    @RequestMapping(value = "/admin/delete-repair", method = RequestMethod.POST)
    String deleteRepair(RedirectAttributes redirectAttributes ,@RequestParam("hidden_serviceId" )Long hidden_serviceId ){

        repairService.deleteRepair(hidden_serviceId);

        redirectAttributes.addFlashAttribute("errorMessage" , "The repair deleted successfully");
        return "redirect:/admin/search-repair";
    }

}
