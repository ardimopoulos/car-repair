package com.carRepair.carRepair.Services;

import com.carRepair.carRepair.Domain.User;
import com.carRepair.carRepair.Repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

//When the application boot up it make an instance (singleton ) of all the @Service classes
@Service
public class UserService {

    //When spring making an instance of the userService class it inject a userRepository instance
    @Autowired
    private UserRepository userRepository;

    public List<User> printSome(){
        List<User> users = userRepository.findAll();
        return users;
    }

    public User printSome1(long id){
        User user = userRepository.findOne(id);
        return user;
    }

    public User addUser(User user){
        userRepository.save(user);
        return user;
    }

    public User updateUser(Long id , User user){
        userRepository.save(user);
        return user;
    }

    public void deleteUser(long id){
        userRepository.delete(id);
    }

}
