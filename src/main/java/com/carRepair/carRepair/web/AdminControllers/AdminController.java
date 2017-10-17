package com.carRepair.carRepair.web.AdminControllers;


import com.carRepair.carRepair.Model.UserForm;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;

@Controller
public class AdminController {

    private static final String USER_FORM = "userForm";
    private static final String BASE_URL = "/admin";

    @RequestMapping(value = {"/admin/home", "/admin"}, method = RequestMethod.GET)
    String getAdminView(){
        return "admin/home";
    }

    @RequestMapping(value = "/admin/create-user", method = RequestMethod.GET)
    String getCreateUserView(Model model){

        if(!model.containsAttribute(USER_FORM)){
            model.addAttribute(USER_FORM, new UserForm());
        }

        return "/admin/user/create-user";
    }

    @RequestMapping(name = "/admin/create-user", method = RequestMethod.POST)
    public String createUser(Model model, @Valid @ModelAttribute(name = USER_FORM) UserForm userForm,
                             BindingResult bindingResult, RedirectAttributes redirectAttributes){

        if(bindingResult.hasErrors()){
            redirectAttributes.addFlashAttribute("org.springframework.validation.BindingResult.userForm",bindingResult);
            redirectAttributes.addFlashAttribute(USER_FORM, userForm);
            redirectAttributes.addFlashAttribute("message", "Please fill the fields again");
            redirectAttributes.addFlashAttribute("errorMessage", "Create user failed!");
            return "redirect:/admin/create-user";
        }

        //TODO service <-new user exists
        redirectAttributes.addFlashAttribute("message", "New user :"+userForm.getFirstname());
        return "redirect:/admin/create-user";
    }

}
