package com.carRepair.carRepair.Services;

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

        try {
            accountRepository.findByEmailAndPassword(email, password);
        } catch (Exception e) {
            throw new InvalidCredentialsException("User not found!");
        }
    }
    @Override
    public void logout(String username) throws Exception{


    }

}
