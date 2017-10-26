package com.carRepair.carRepair.Utilities;

import com.carRepair.carRepair.Domain.Member;
import com.carRepair.carRepair.Forms.User.EditUserForm;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.bcrypt.BCrypt;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Collection;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

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

    public static String hashPassword(String password){
        String salt = BCrypt.gensalt();
        String hashPassword = BCrypt.hashpw(password, salt);
        return hashPassword;
    }

    public static boolean checkPassword(String password, String hashPassword){
        return BCrypt.checkpw(password, hashPassword);
    }

    public static String editPassword(String memberPass, String  formPass, String formNewPass){

        String newHashPass = "";
        String pattern = "^[a-zA-Z0-9@#$%^&]*$";
        if(formPass.equals("") && formNewPass.equals("")){
            newHashPass = memberPass;
        }else if(!formPass.equals("") && !formNewPass.equals("")) {
            boolean checkPass = AppUtilities.checkPassword(formPass, memberPass);
            if (checkPass && formNewPass.length() >= 8 && formNewPass.matches(pattern)) {
                newHashPass = AppUtilities.hashPassword(formNewPass);
            }
        }
        return newHashPass;
    }

    public static Date getYear(Date date) throws ParseException {
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy");
        String year = date.toString().substring(0,4);
        return formatter.parse(year);
    }
}
