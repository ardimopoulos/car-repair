package com.carRepair.carRepair.Web.AdminControllers;

import com.carRepair.carRepair.Domain.Repair;
import com.carRepair.carRepair.Forms.UserForm;
import com.carRepair.carRepair.Services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@Controller
public class EditController {

    private static final String USER_FORM = "userForm";

    @Autowired
    private UserService userService;

    @RequestMapping(value = "/admin/edit-user/{vat}", method = RequestMethod.GET)
    public String getEditUserView(Model model , @PathVariable String vat){
        model.addAttribute("userForm", new UserForm() );
        return "/admin/user/edit-user";
    }

    @RequestMapping(value = "/admin/edit-user", method = RequestMethod.GET)
    String getAdminView(Model model){

        return "admin/home";
    }

}
