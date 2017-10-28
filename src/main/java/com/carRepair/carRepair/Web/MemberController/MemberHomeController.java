package com.carRepair.carRepair.Web.MemberController;

import com.carRepair.carRepair.Domain.Repair;
import com.carRepair.carRepair.Exceptions.RepairNotFoundException;
import com.carRepair.carRepair.Services.Repair.RepairService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@Controller
public class MemberHomeController {

    @Autowired
    private RepairService repairService;

    @RequestMapping(value = {"/member/home", "/member"}, method = RequestMethod.GET)
    String getMemberView(Model model){

        Authentication auth = SecurityContextHolder.getContext().getAuthentication();

        List<Repair> repairs = null;
        try {
            repairs = repairService.getMemberRepairs( auth.getName());
            model.addAttribute("repairs" , repairs);
        } catch (RepairNotFoundException e) {
            model.addAttribute("message", "Repairs not exist for member");
        }


        return "owner/home";
    }

}
