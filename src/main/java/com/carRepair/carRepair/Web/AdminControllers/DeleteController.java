package com.carRepair.carRepair.Web.AdminControllers;

import com.carRepair.carRepair.Forms.UserForm;
import com.carRepair.carRepair.Repositories.UserRepository;
import com.carRepair.carRepair.Services.DeleteService;
import com.carRepair.carRepair.Services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class DeleteController {

    @Autowired
    private DeleteService deleteService;

    @Autowired
    private UserService userService;

    @RequestMapping(value = "/admin/delete-user", method = RequestMethod.POST)
    String deleteUser(Model model){

        //User user = userService.findByEmail(email);

        //deleteService.deleteUser(user);
        return "redirect:/admin/search-user";
    }

}
