package com.carRepair.carRepair.Services;

import com.carRepair.carRepair.Domain.User;
import com.carRepair.carRepair.Exceptions.InvalidCredentialsException;
import com.carRepair.carRepair.Repositories.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.AuthenticationException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class AccountServiceImpl implements AccountService{

    @Autowired
    private AccountRepository accountRepository;

    @Override
    public void login(String email, String password) throws AuthenticationException {
        User user;
        try {
            user = accountRepository.findByEmailAndPassword(email, password);
            System.out.println("asdfasdfasdfasdfasdfasdfasdfasdfasdfasdfasdf" + user.getUserType());
        } catch (Exception e) {
            throw new InvalidCredentialsException("User not found!");
        }
        System.err.println("Eksw apo to try");
        //return (boolean)user.getUserType();
    }

    @Override
    public void logout(String username) throws Exception{


    }

}
