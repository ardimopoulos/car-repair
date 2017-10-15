package com.carRepair.carRepair.Security;

import com.carRepair.carRepair.Domain.User;
import com.carRepair.carRepair.Exceptions.InvalidCredentialsException;
import com.carRepair.carRepair.Services.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.stereotype.Component;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

@Component
public class LoginAuthenticationProvider implements AuthenticationProvider {

    @Autowired
    private AccountService accountService;

    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
        String username = authentication.getName().trim();
        System.out.println( "Username : " + username );
        String password = (String) authentication.getCredentials().toString().trim();
        System.out.println("Pass : " +password);

        Set<GrantedAuthority> grantedAuthorities = new HashSet<>();

        try {
            User user = accountService.login(username, password);

            if(user==null){ System.out.println("user = null "); }
            else if ( user.getUserType() ){ grantedAuthorities.add(new SimpleGrantedAuthority("ADMIN"));}
            else{ grantedAuthorities.add(new SimpleGrantedAuthority("USER"));}

        }catch (Exception e){throw new InvalidCredentialsException("User can not be found!");}

        return new UsernamePasswordAuthenticationToken(username, password,grantedAuthorities);
    }

    @Override
    public boolean supports(Class<?> authentication) {
        return authentication.equals(UsernamePasswordAuthenticationToken.class);
    }
}