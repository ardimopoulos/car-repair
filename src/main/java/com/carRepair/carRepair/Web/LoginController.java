package com.carRepair.carRepair.Web;

import com.carRepair.carRepair.Forms.LoginForm;
import com.carRepair.carRepair.Services.AccountServiceImpl;
import com.carRepair.carRepair.Utilities.AppUtilities;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

@Controller
@SessionAttributes("username")
public class LoginController {

    private static final String LOGIN_FORM = "loginForm";
    private final static org.slf4j.Logger LOG = LoggerFactory.getLogger(AccountServiceImpl.class);

    @RequestMapping(value = {"/login" , "/"}, method = RequestMethod.GET)
    public String getLoginView(Model model, @RequestParam(name = "error", required = false) String error, HttpServletRequest request) {
        String view = "/login";
        String userType = AppUtilities.userAuthority();
        if(userType.equals("ADMIN") || userType.equals("MEMBER")){ view = "redirect:/"+userType.toLowerCase(); }

        if (error != null) {
            LOG.error("User not found!");
            model.addAttribute("errorMessage", "User not found! Please try again");
        }

        if(!model.containsAttribute(LOGIN_FORM)){ model.addAttribute(LOGIN_FORM, new LoginForm()); }



        return view;
    }
}
