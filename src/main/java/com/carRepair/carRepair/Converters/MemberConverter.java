package com.carRepair.carRepair.Converters;

import com.carRepair.carRepair.Domain.Member;
import com.carRepair.carRepair.Forms.EditUserForm;
import com.carRepair.carRepair.Forms.UserForm;
import com.carRepair.carRepair.Utilities.AppUtilities;

public class MemberConverter {

    public static Member buildMemberObjecr(UserForm userForm) {
        String email = userForm.getEmail();
        String password = AppUtilities.hashPassword(userForm.getPassword());
        String firstName = userForm.getFirstname();
        String lastName = userForm.getLastname();
        String address = userForm.getAddress();
        String vat = userForm.getVat();
        boolean userType = userForm.getUserType();

        Member member = new Member(email, password, userType, firstName, lastName, address, vat);

        return member;
    }

    public static Member buildEditMemberObjecr(EditUserForm editUserForm) {
        String email = editUserForm.getEmail();
        String password = editUserForm.getPassword();
        String firstName = editUserForm.getFirstname();
        String lastName = editUserForm.getLastname();
        String address = editUserForm.getAddress();
        String vat = editUserForm.getVat();
        boolean userType = editUserForm.getUserType();

        Member member = new Member(email, password, userType, firstName, lastName, address, vat);
        member.setUserId(editUserForm.getUserId());
        return member;
    }
}
