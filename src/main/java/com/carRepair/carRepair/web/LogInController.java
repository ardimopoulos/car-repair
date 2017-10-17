package com.carRepair.carRepair.web;

import com.carRepair.carRepair.Forms.LoginForm;
import com.carRepair.carRepair.Services.AccountServiceImpl;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Collection;

@Controller
public class LogInController {

    private static final String LOGIN_FORM = "loginForm";
    private final static org.slf4j.Logger LOG = LoggerFactory.getLogger(AccountServiceImpl.class);

//    @RequestMapping(value="/" ,  method = RequestMethod.GET)
//    public String home(){
//        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
//        if(auth.isAuthenticated()){
//            if(auth.getAuthorities().equals("ADMIN")){return "redirect:/admin"; }
//            else{return "redirect:/member";}
//        }else{return "redirect:/login"; }
//    }

//    @RequestMapping(value="/login" ,  method = RequestMethod.GET)
//    public String login(Model model){
//
//        model.addAttribute(LOGIN_FORM, new LoginForm());
//        return "login";
//    }

    @RequestMapping(value = {"/login" , "/"}, method = RequestMethod.GET)
    public String getLoginView(Model model, @RequestParam(name = "error", required = false) String error) {
        String view = "/login";
        String userType =userAuthority();
        if(userType.equals("ADMIN") || userType.equals("MEMBER")){ view = "redirect:/"+userType.toLowerCase(); }

        if (error != null) {
            LOG.error("User not found!");
            model.addAttribute("errorMessage", "User not found! Please try again");
        }

        if(!model.containsAttribute(LOGIN_FORM)){ model.addAttribute(LOGIN_FORM, new LoginForm()); }
        return view;
    }





    private String userAuthority(){

        Authentication auth = SecurityContextHolder.getContext().getAuthentication();

        Collection<? extends GrantedAuthority> grant = auth.getAuthorities();

        String userType = "";

        for (GrantedAuthority g: grant) {

            if(g.getAuthority().equals("ADMIN")){

                userType = "ADMIN";

            }else if(g.getAuthority().equals("MEMBER")){

                userType = "MEMBER";

            }

        }

        return userType;
    }





}
