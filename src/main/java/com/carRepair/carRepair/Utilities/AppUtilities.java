package com.carRepair.carRepair.Utilities;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;

import java.util.Collection;

public class AppUtilities {

    public static String userAuthority(){

        Authentication auth = SecurityContextHolder.getContext().getAuthentication();

        Collection<? extends GrantedAuthority> grant = auth.getAuthorities();

        String userType = "";

        for (GrantedAuthority g: grant) {

            if(g.getAuthority().equals("ADMIN")){

                userType = "ADMIN";

            }else if(g.getAuthority().equals("MEMBER")){

                userType = "MEMBER";

            }

        }

        return userType;
    }
}
