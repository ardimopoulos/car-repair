package com.carRepair.carRepair.converters;

import com.carRepair.carRepair.domain.Member;
import com.carRepair.carRepair.forms.user.EditUserForm;
import com.carRepair.carRepair.forms.user.UserForm;

import static com.carRepair.carRepair.Utilities.AppUtilities.hashPassword;

public class MemberConverter {

    public static Member buildMemberObjecr(UserForm userForm) {
       return new Member(
                userForm.getEmail(),
                hashPassword(userForm.getPassword()),
                userForm.isUserType(),
                userForm.getFirstname(),
                userForm.getLastname(),
                userForm.getAddress(),
                userForm.getVat()
        );
    }

    public static Member buildEditMemberObjecr(EditUserForm editUserForm) {
        Member member = new Member(
                editUserForm.getEmail(),
                editUserForm.getPassword(),
                editUserForm.isUserType(),
                editUserForm.getFirstname(),
                editUserForm.getLastname(),
                editUserForm.getAddress(),
                editUserForm.getVat()
        );
        member.setUserId(editUserForm.getUserId());

        return member;
    }
}
