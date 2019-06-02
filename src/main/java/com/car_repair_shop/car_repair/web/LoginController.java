package com.car_repair_shop.car_repair.web;

import com.car_repair_shop.car_repair.forms.LoginForm;
import com.car_repair_shop.car_repair.utilities.AppUtilities;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import static com.car_repair_shop.car_repair.properties.Constants.*;

@Controller
public class LoginController {

    private static final String LOGIN_FORM = "loginForm";

    @RequestMapping(value = {"/login" , "/"}, method = RequestMethod.GET)
    public String getLoginView(Model model, @RequestParam(name = "error", required = false) String error) {
        String role = AppUtilities.userAuthority();
        String view;

        if (role.equals(ADMIN)) {
            view = "redirect:/admin/";

        } else if (role.equals(MEMBER)) {
            view = "redirect:/member/";

        } else {
            view = "/login";
        }

        if (error != null) {
            model.addAttribute(ERROR_MESSAGE, "user not found! Please try again");
        }

        if (!model.containsAttribute(LOGIN_FORM)) {
            model.addAttribute(LOGIN_FORM, new LoginForm());
        }

        return view;
    }
}
