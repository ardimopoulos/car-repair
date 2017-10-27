package com.carRepair.carRepair.Web;

import com.carRepair.carRepair.Forms.LoginForm;
import com.carRepair.carRepair.Utilities.AppUtilities;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class LoginController {

    private static final String LOGIN_FORM = "loginForm";
    @RequestMapping(value = {"/login" , "/"}, method = RequestMethod.GET)
    public String getLoginView(Model model, @RequestParam(name = "error", required = false) String error) {
        String role = AppUtilities.userAuthority();
        String view ="";
        if(role.equals("ADMIN")){
            view = "redirect:/admin/";
        }else if(role.equals("MEMBER")){
            view = "redirect:/member/";
        }else{
            view = "/login";
        }

        if (error != null) {
            model.addAttribute("errorMessage", "User not found! Please try again");
        }
        if(!model.containsAttribute(LOGIN_FORM)){ model.addAttribute(LOGIN_FORM, new LoginForm()); }
        return view;
    }
}
