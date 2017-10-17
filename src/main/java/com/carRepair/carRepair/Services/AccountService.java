package com.carRepair.carRepair.Services;

import com.carRepair.carRepair.Domain.User;
import org.springframework.security.core.AuthenticationException;


public interface AccountService {

    User login(String username, String password) throws AuthenticationException;

    void logout(String username) throws Exception;

}
