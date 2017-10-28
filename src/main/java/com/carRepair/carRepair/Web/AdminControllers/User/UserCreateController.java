package com.carRepair.carRepair.Web.AdminControllers.User;

import com.carRepair.carRepair.Converters.MemberConverter;
import com.carRepair.carRepair.Domain.Member;
import com.carRepair.carRepair.Exceptions.UserExistException;
import com.carRepair.carRepair.Forms.User.UserForm;
import com.carRepair.carRepair.Services.Member.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import javax.validation.Valid;

@Controller
public class UserCreateController {

    private static final String USER_FORM = "userForm";

    @Autowired
    private MemberService memberService;

    @RequestMapping(value = "/admin/create-user", method = RequestMethod.GET)
    String getCreateUserView(Model model){
        if(!model.containsAttribute(USER_FORM)){
            model.addAttribute(USER_FORM, new UserForm());
        }
        return "/admin/user/create-user-view";
    }

    @RequestMapping(value = "/admin/create-user", method = RequestMethod.POST)
    public String createUser(Model model, @Valid @ModelAttribute(name = USER_FORM) UserForm userForm,
                             BindingResult bindingResult, RedirectAttributes redirectAttributes){

        String role = (userForm.getUserType()) ? "admin" : "simple";
        String addVehicle = (userForm.getAddVehicle()) ? "checked" : "";

        if(bindingResult.hasErrors()) {
            redirectAttributes.addFlashAttribute("org.springframework.validation.BindingResult.userForm", bindingResult);
            redirectAttributes.addFlashAttribute(USER_FORM, userForm);
            redirectAttributes.addFlashAttribute(role, "selected");
            redirectAttributes.addFlashAttribute("checked",  addVehicle);
            return "redirect:/admin/create-user";
        }

        try {
            Member member = MemberConverter.buildMemberObjecr(userForm);
            member = memberService.insertMember(member);

            // Redirect if checkbox in form is checked
            if(userForm.getAddVehicle()){
                redirectAttributes.addFlashAttribute("memberVat", member.getVat());
                redirectAttributes.addFlashAttribute("message", "Add vehicle for user with VAT: " + member.getVat());
                return "redirect:/admin/create-vehicle";
            }

            String message = "New user is created: " + member.getFirstname() + " " + member.getLastname() +
                             " with VAT: " + member.getVat();
            redirectAttributes.addFlashAttribute("message", message);
            redirectAttributes.addFlashAttribute("userId", member.getUserId());
        }catch (UserExistException e){
            redirectAttributes.addFlashAttribute("errorMessage", e.getMessage());
            redirectAttributes.addFlashAttribute(USER_FORM, userForm);
            redirectAttributes.addFlashAttribute(role, "selected");
            redirectAttributes.addFlashAttribute("checked",  addVehicle);
        }
        return "redirect:/admin/create-user";
    }
}
