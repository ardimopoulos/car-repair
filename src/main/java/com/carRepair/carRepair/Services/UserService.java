package com.carRepair.carRepair.Services;

import com.carRepair.carRepair.Domain.User;
import com.carRepair.carRepair.Exceptions.UserNotFoundException;

public interface UserService {

     User insertUser(User user) throws Exception;

     User findUser(long id) throws Exception;

     public User getUserByEmail(String email) throws UserNotFoundException;
}
