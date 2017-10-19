package com.carRepair.carRepair.Web.AdminControllers;


import com.carRepair.carRepair.Converters.UserConverter;
import com.carRepair.carRepair.Domain.Member;
import com.carRepair.carRepair.Domain.Repair;
import com.carRepair.carRepair.Domain.User;
import com.carRepair.carRepair.Exceptions.UserNotFoundException;
import com.carRepair.carRepair.Forms.SearchForm;
import com.carRepair.carRepair.Forms.UserForm;
import com.carRepair.carRepair.Services.RepairService;
import com.carRepair.carRepair.Services.SearchService;
import com.carRepair.carRepair.Services.UserService;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;
import java.util.List;

@Controller
public class AdminController {

    private final static org.slf4j.Logger logger = LoggerFactory.getLogger(AdminController.class);

    @Autowired
    private RepairService repairService;

    @RequestMapping(value = {"/admin/home", "/admin"}, method = RequestMethod.GET)
    String getAdminView(Model model){

        List<Repair> repairs = repairService.getDailyServices();
        model.addAttribute("repairs" , repairs);

        return "admin/home";
    }

}
