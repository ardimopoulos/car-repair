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
public class UserController {

    //marks this us something that needs dependency
    //
    @Autowired
    private UserService userService;

    @RequestMapping(value="/user" ,  method = RequestMethod.GET)
    public String index(){

        List<User> users = userService.printSome();

        for(int i=0; i < users.size(); i++){

            System.out.println("User"+i+" : "+users.get(i).getUserId() + users.get(i).getPassword() );

        }
        return "user";
    }

    @RequestMapping(value="/user/{id}" ,  method = RequestMethod.GET)
    public String index1(@PathVariable("id") long id){
        User user = userService.printSome1(id);

        System.out.println("User : " + user.getEmail() + user.getPassword());

        return "user";
    }

//    @RequestMapping(value="/adduser" ,  method = RequestMethod.GET)
//    public String adduser(){
//        User user = userService.addUser(new User("p12133","xrhstos","bazdek@ad.com"));
//        return "user";
//    }
//
//    @RequestMapping(value="/updateuser/{id}" ,  method = RequestMethod.GET)
//    public String updateuser(@PathVariable("id") long id){
//       User user =  new User("p1314","pass","email@gmail.com");
//       user.setId(id);
//       userService.updateUser(id ,user);
//       return "user";
//    }

    @RequestMapping(value="/deleteuser/{id}" ,  method = RequestMethod.GET)
    public String deleteuser(@PathVariable("id") long id){
        userService.deleteUser(id);
        return "user";
    }


}