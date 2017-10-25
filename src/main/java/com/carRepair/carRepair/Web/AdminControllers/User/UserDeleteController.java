package com.carRepair.carRepair.Web.AdminControllers.User;

import com.carRepair.carRepair.Domain.User;
import com.carRepair.carRepair.Exceptions.UserNotFoundException;
import com.carRepair.carRepair.Services.DeleteService;
import com.carRepair.carRepair.Services.Member.MemberService;
import com.carRepair.carRepair.Services.User.UserService;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class UserDeleteController {

    private final static org.slf4j.Logger logger = LoggerFactory.getLogger(UserDeleteController.class);

    @Autowired
    private DeleteService deleteService;

    @Autowired
    private UserService userService;

    @RequestMapping(value = "/admin/delete-user", method = RequestMethod.POST)
    String deleteUser(Model model , @RequestParam("hidden_email" )String hidden_email ){
        try {
            User user = userService.getUserByEmail(hidden_email);
            deleteService.deleteUser(user.getUserId());
        }catch(UserNotFoundException userNotFound) {
            model.addAttribute("errorMessage", "Can t find user!" );
        }catch(IllegalArgumentException e){
            model.addAttribute("errorMessage", "Something went wrong");
        }
        return "redirect:/admin/search-user";
    }
}
