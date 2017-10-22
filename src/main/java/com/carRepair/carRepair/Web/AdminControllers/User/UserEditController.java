package com.carRepair.carRepair.Web.AdminControllers.User;

import com.carRepair.carRepair.Converters.MemberConverter;
import com.carRepair.carRepair.Domain.Member;
import com.carRepair.carRepair.Forms.User.EditUserForm;
import com.carRepair.carRepair.Services.Member.MemberService;
import com.carRepair.carRepair.Utilities.AppUtilities;
import org.slf4j.LoggerFactory;
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

@Controller
public class UserEditController {

    private final static org.slf4j.Logger logger = LoggerFactory.getLogger(UserEditController.class);

    private static final String EDIT_USER_FORM = "editUserForm";

    @Autowired
    private MemberService memberService;

    //TODO  bug edit

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
        return "/admin/user/edit-user-view";
    }

    @RequestMapping(value = "/admin/edit-user", method = RequestMethod.POST)
    public String editUser(Model model, @Valid @ModelAttribute("editUserForm") EditUserForm editUserForm, BindingResult bindingResult,
                           RedirectAttributes redirectAttributes){

        String role = (editUserForm.getUserType()) ? "admin" : "simple";

        if(bindingResult.hasErrors()) {

            redirectAttributes.addFlashAttribute("org.springframework.validation.BindingResult.userForm", bindingResult);
            redirectAttributes.addFlashAttribute(EDIT_USER_FORM, editUserForm);
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


