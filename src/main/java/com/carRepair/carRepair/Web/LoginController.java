package com.carRepair.carRepair.Web;

import com.carRepair.carRepair.Domain.Member;
import com.carRepair.carRepair.Domain.User;
import com.carRepair.carRepair.Forms.LoginForm;
import com.carRepair.carRepair.Repositories.UserRepository;
import com.carRepair.carRepair.Services.AccountServiceImpl;
import com.carRepair.carRepair.Utilities.AppUtilities;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

@Controller
@SessionAttributes("username")
public class LoginController {

    private static final String LOGIN_FORM = "loginForm";
    private final static org.slf4j.Logger LOG = LoggerFactory.getLogger(AccountServiceImpl.class);

    @Autowired
    private UserRepository repo;

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

/*
        Member m = new Member();

        m.setFirstname("first");
        m.setLastname("last");
        m.setAddress("address");
        m.setVat("123456789");
        m.setEmail("email");
        m.setPassword("12345");
        m.setUserType(false);

        User u = new User();
        u.setEmail(m.getEmail());
        u.setPassword(m.getPassword());
        u.setUserType(m.getUserType());*/
       // u.setMember(m);
        /*Member member = new Member();
        member.setAddress("address");
        member.setLastname("last");
        member.setFirstname("first");tty88yy8u8yhyuiyuyyuuiyyt
        member.set

        User user= new User();
        user.setUserType(false);
        user.setPassword("123456");
        user.setEmail("email");
        user.setMember();*/

       // repo.save(u);


        return view;
    }
}
