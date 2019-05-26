package com.car_repair_shop.car_repair.utilities;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.bcrypt.BCrypt;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Collection;
import java.util.Date;

public class AppUtilities {

    public static String userAuthority(){
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        Collection<? extends GrantedAuthority> grant = auth.getAuthorities();
        String userType = "MEMBER";

        for (GrantedAuthority g: grant) {
            if (g.getAuthority().equals("ADMIN")) {
                userType = "ADMIN";
            }
        }

        return userType;
    }

    public static String hashPassword(String password){
        return BCrypt.hashpw(password, BCrypt.gensalt());
    }

    public static boolean checkPassword(String password, String hashPassword){
        return BCrypt.checkpw(password, hashPassword);
    }

    public static String editPassword(String memberPass, String  formPass, String formNewPass){
        String newHashPass = "";
        String pattern = "^[a-zA-Z0-9@#$%^&]*$";

        if (formPass.equals("") && formNewPass.equals("")) {
            newHashPass = memberPass;

        } else if (!formPass.equals("") && !formNewPass.equals("")) {
            boolean checkPass = checkPassword(formPass, memberPass);

            if (checkPass && formNewPass.length() >= 8 && formNewPass.matches(pattern)) {
                newHashPass = hashPassword(formNewPass);
            }
        }

        return newHashPass;
    }

    public static Date getYear(Date date) throws ParseException {
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy");
        return formatter.parse(date.toString().substring(0,4));
    }
}
