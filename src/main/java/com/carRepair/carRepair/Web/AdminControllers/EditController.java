package com.carRepair.carRepair.Web.AdminControllers;

import com.carRepair.carRepair.Domain.Member;
import com.carRepair.carRepair.Exceptions.UserNotFoundException;
import com.carRepair.carRepair.Forms.UpdateForm;
import com.carRepair.carRepair.Services.MemberService;
import com.carRepair.carRepair.Services.UserService;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class EditController {
    private final static org.slf4j.Logger logger = LoggerFactory.getLogger(EditController.class);
    private static final String UPDATE_FORM = "updateForm";

    @Autowired
    private UserService userService;

    @Autowired
    private MemberService memberService;

    @RequestMapping(value = "/admin/edit-user/{vat}", method = RequestMethod.GET)
    public String getEditUserView(Model model , @PathVariable String vat){
        model.addAttribute(UPDATE_FORM, new UpdateForm() );
        try {
            Member member = memberService.getMemberByVat(vat);
            model.addAttribute("member", member );

        }catch(UserNotFoundException userNotFound) {  model.addAttribute("errorMessage", "Can t find user!" );}
        return "/admin/user/update-user";
    }

    @RequestMapping(value = "/admin/update-user", method = RequestMethod.POST)
    String getEditUserViewPost(Model model , RedirectAttributes redirectAttributes,
                                            BindingResult bindingResult,
                                            @ModelAttribute(UPDATE_FORM) UpdateForm updateForm){
        if (bindingResult.hasErrors()) {
            //have some error handling here, perhaps add extra error messages to the model
            //for now we're going to return a view ( register) but normally we would redirect to the
            //get method after adding the binding result and the form to the redirect attributes.
            logger.error(String.format("%s Validation Errors present: ", bindingResult.getErrorCount()));
            return "register";
        }
        //System.out.println(updateForm.getPassword());
       // redirectAttributes.addFlashAttribute("user" , user)
        return "redirect:/admin/edit-user/"+updateForm.getVat();
    }

}
