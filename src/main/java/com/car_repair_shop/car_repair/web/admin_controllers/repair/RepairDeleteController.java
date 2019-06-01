package com.car_repair_shop.car_repair.web.admin_controllers.repair;

import com.car_repair_shop.car_repair.services.repair.RepairService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import static com.car_repair_shop.car_repair.properties.Constants.ERROR_MESSAGE;

@Controller
public class RepairDeleteController {

    @Autowired
    private RepairService repairService;

    @RequestMapping(value = "/admin/delete-repair", method = RequestMethod.POST)
    String deleteRepair(RedirectAttributes redirectAttributes ,@RequestParam("hidden_serviceId" )Long hidden_serviceId ){

        repairService.deleteRepair(hidden_serviceId);

        redirectAttributes.addFlashAttribute(ERROR_MESSAGE , "The repair deleted successfully");
        return "redirect:/admin/search-repair";
    }

}
