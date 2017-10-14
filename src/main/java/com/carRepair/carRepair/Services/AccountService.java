package com.carRepair.carRepair.Services;

import org.springframework.security.core.AuthenticationException;


public interface AccountService {

    void login(String username, String password) throws AuthenticationException;

    void logout(String username) throws Exception;

}
