package com.carRepair.carRepair.web.AdminControllers;

import com.carRepair.carRepair.Domain.User;
import com.carRepair.carRepair.Services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@Controller
public class MemberController {

    //marks this us something that needs dependency
    //
    @Autowired
    private UserService userService;

    @RequestMapping(value="/member" ,  method = RequestMethod.GET)
    public String index(){

//        List<User> users = userService.allUsers();
//
//        for(int i=0; i < users.size(); i++){
//
//            System.out.println("User"+i+" : "+users.get(i).getUserId() + users.get(i).getPassword() );
//
//        }
        return "Owner/home";
    }

/*    @RequestMapping(value="/search-user/{id}" ,  method = RequestMethod.GET)
    public String searchUser(@PathVariable("id") long id){
        User user = userService.searchUser(id);
        return "user";
    }

    @RequestMapping(value="/new-user" ,  method = RequestMethod.GET)
    public String adduser(){
        userService.insertUser(new User("p12133","xrhstos",true) );
        return "user";
    }

    @RequestMapping(value="/update-user/{id}" ,  method = RequestMethod.GET)
    public String updateuser(@PathVariable("id") long id){
       User user =  new User("email","admin123",true);
       user.setUserId(id);
       userService.updateUser(id ,user);
       return "user";
    }

    @RequestMapping(value="/delete-user/{id}" ,  method = RequestMethod.GET)
    public String deleteuser(@PathVariable("id") long id){
        userService.deleteUser(id);
        return "user";
    }*/


}
