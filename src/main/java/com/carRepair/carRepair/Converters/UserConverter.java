package com.carRepair.carRepair.Converters;

import com.carRepair.carRepair.Domain.Member;
import com.carRepair.carRepair.Domain.User;
import com.carRepair.carRepair.Forms.UserForm;

public class UserConverter {

    public static User buildUserObjecr(UserForm userForm){
        Member member = new Member();
        member.setFirstname(userForm.getFirstname());
        member.setLastname(userForm.getLastname());
        member.setVat(userForm.getVat());
        member.setAddress(userForm.getAddress());

        User user = new User();
        user.setEmail(userForm.getEmail());
        user.setPassword(userForm.getPassword());
        user.setUserType(userForm.getUserType());
        user.setMember(member);

        return user;
    }
}
