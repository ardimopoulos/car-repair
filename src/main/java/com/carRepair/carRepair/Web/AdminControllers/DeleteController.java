package com.carRepair.carRepair.Web.AdminControllers;

import com.carRepair.carRepair.Domain.User;
import com.carRepair.carRepair.Exceptions.UserNotFoundException;
import com.carRepair.carRepair.Forms.UserForm;
import com.carRepair.carRepair.Repositories.UserRepository;
import com.carRepair.carRepair.Services.DeleteService;
import com.carRepair.carRepair.Services.MemberService;
import com.carRepair.carRepair.Services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class DeleteController {

    @Autowired
    private DeleteService deleteService;

    @Autowired
    private UserService userService;

    @Autowired
    private MemberService memberService;

    @RequestMapping(value = "/admin/delete-user", method = RequestMethod.POST)
    String deleteUser(Model model , @RequestParam("hidden_email" )String hidden_email ){

        try {
            User user = userService.getUserByEmail(hidden_email);
            deleteService.deleteUser(user.getUserId());
        }catch(UserNotFoundException userNotFound) {  model.addAttribute("errorMessage", "Can t find user!" );}

        return "redirect:/admin/search-user";
    }

}
