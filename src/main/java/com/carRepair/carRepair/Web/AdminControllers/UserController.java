package com.carRepair.carRepair.Web.AdminControllers;

import com.carRepair.carRepair.Converters.MemberConverter;
import com.carRepair.carRepair.Converters.UserConverter;
import com.carRepair.carRepair.Domain.Member;
import com.carRepair.carRepair.Domain.User;
import com.carRepair.carRepair.Forms.EditUserForm;
import com.carRepair.carRepair.Forms.UserForm;
import com.carRepair.carRepair.Repositories.MemberRepository;
import com.carRepair.carRepair.Services.MemberService;
import com.carRepair.carRepair.Services.UserService;
import com.carRepair.carRepair.Utilities.AppUtilities;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;
import javax.websocket.server.PathParam;

@Controller

public class UserController {

    private static final String USER_FORM = "userForm";
    private static final String EDIT_USER_FORM = "editUserForm";
    private static final String BASE_URL = "/admin";

    @Autowired
    private MemberService memberService;

    @RequestMapping(value = "/admin/create-user", method = RequestMethod.GET)
    String getCreateUserView(Model model){

        if(!model.containsAttribute(USER_FORM)){
            model.addAttribute(USER_FORM, new UserForm());
        }

        return "/admin/user/create-user";
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

        Member member = MemberConverter.buildMemberObjecr(userForm);

        try {

            member =memberService.insertMember(member);

            // Redirect if checkbox in form is checked
            if(userForm.getAddVehicle()){
                redirectAttributes.addFlashAttribute("memberVat", member.getVat());
                redirectAttributes.addFlashAttribute("errormessage", "Add vehicle for user wih VAT: " + member.getVat());
                return "redirect:/admin/add-vehicle";
            }


            String message = "New user is created: " + member.getFirstname() + " " + member.getLastname() + " with VAT: " + member.getVat();
            redirectAttributes.addFlashAttribute("message", message);
            redirectAttributes.addFlashAttribute("userId", member.getUserId());

        }catch (Exception e){
            redirectAttributes.addFlashAttribute("message", "There is already an account with same VAT or email.");
            redirectAttributes.addFlashAttribute(USER_FORM, userForm);
            redirectAttributes.addFlashAttribute(role, "selected");
            redirectAttributes.addFlashAttribute("checked",  addVehicle);
        }

        return "redirect:/admin/create-user";
    }

    //TODO  New class edit form

    @RequestMapping(value = "/admin/edit-user", method = RequestMethod.GET)
    public String getEditUserView(Model model, @RequestParam(name = "v", required = false) String vat,
                                  RedirectAttributes redirectAttributes){

        if(vat != null){
            try {
                Member member = memberService.getMemberByVat(vat);
                EditUserForm editUserForm = new EditUserForm(member);

                String role = (member.getUserType()) ? "admin" : "simple";
                model.addAttribute("editUserForm", editUserForm);
                model.addAttribute(role,"selected");
            } catch (Exception e) {
                redirectAttributes.addFlashAttribute("errormessage","There is no user with VAT: "+vat);
                return "redirect:/admin/edit-user";
            }
        }
        return "/admin/user/edit-user";
    }

    @RequestMapping(value = "/admin/edit-user", method = RequestMethod.POST)
    public String editUser(Model model, @Valid @ModelAttribute("editUserForm") EditUserForm editUserForm, BindingResult bindingResult,
                           RedirectAttributes redirectAttributes){

        String role = (editUserForm.getUserType()) ? "admin" : "simple";

        if(bindingResult.hasErrors()) {

            redirectAttributes.addFlashAttribute("org.springframework.validation.BindingResult.userForm", bindingResult);
            redirectAttributes.addFlashAttribute(USER_FORM, editUserForm);
            redirectAttributes.addFlashAttribute(role, "selected");

            return "redirect:/admin/edit-user";
        }

        String pattern = "^[a-zA-Z0-9@#$%^&]*$";

        try {

            Member member = memberService.getMemberById(editUserForm.getUserId());

            String memberPass = member.getPassword();
            String formPass = editUserForm.getPassword();
            String formNewPass = editUserForm.getNewPassword();
            String hashFormNewPass = "";

            if(!formPass.equals("")) {
                boolean checkPass = AppUtilities.checkPassword(formPass,memberPass);
                if ( checkPass && formNewPass.length() >= 8 && formNewPass.matches(pattern)){
                    hashFormNewPass = AppUtilities.hashPassword(formNewPass);
                    editUserForm.setPassword(hashFormNewPass);
                } else {
                    redirectAttributes.addFlashAttribute("passwordMessage", "Invalid inputs");
                    return "redirect:/admin/edit-user?v=" + member.getVat();
                }
            }

            if(formPass.equals("") && !formNewPass.equals("")) {
                redirectAttributes.addFlashAttribute("passwordMessage", "Invalid inputs");
                return "redirect:/admin/edit-user?v=" + member.getVat();
            }

            String pass = (hashFormNewPass.equals("")) ? memberPass : hashFormNewPass;

            editUserForm.setPassword(pass);

            Member editMember = MemberConverter.buildEditMemberObjecr(editUserForm);

            member = memberService.insertMember(editMember);

            String message = "User ";
            redirectAttributes.addFlashAttribute("message", message);

        }catch (Exception e){
            redirectAttributes.addFlashAttribute("errormessage", "Edit user failed");
            return "redirect:/admin/edit-user";
        }

        return "redirect:/admin/edit-user";
    }
}
