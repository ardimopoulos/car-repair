package com.carRepair.carRepair.Converters;

import com.carRepair.carRepair.Domain.Member;
import com.carRepair.carRepair.Domain.User;
import com.carRepair.carRepair.Forms.UserForm;

public class UserConverter {

    public static User buildUserObjecr(UserForm userForm){
        String email = userForm.getEmail();
        String password = userForm.getPassword();
        String firstName = userForm.getFirstname();
        String lastName = userForm.getLastname();
        String address = userForm.getAddress();
        String vat = userForm.getVat();
        boolean userType = userForm.getUserType();

        //Upcasting
        User user = new Member(email, password, userType, firstName, lastName, address, vat);

        return user;
    }
}
