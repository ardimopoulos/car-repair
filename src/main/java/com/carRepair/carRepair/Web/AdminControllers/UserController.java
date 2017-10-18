package com.carRepair.carRepair.Web.AdminControllers;

import com.carRepair.carRepair.Forms.UserForm;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller

public class UserController {

    @RequestMapping(name = "/admin/edit-user", method = RequestMethod.GET)
    public String getEditUserView(Model model, UserForm userForm){
        userForm.setFirstname("Akis");
        userForm.setLastname("Dimopoulos");
        model.addAttribute("userForm", userForm);
        return "/admin/user/edit-user";
    }
}
