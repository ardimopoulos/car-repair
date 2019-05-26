package com.car_repair_shop.car_repair.converters;

import com.car_repair_shop.car_repair.domain.Member;
import com.car_repair_shop.car_repair.forms.user.EditUserForm;
import com.car_repair_shop.car_repair.forms.user.UserForm;

import static com.car_repair_shop.car_repair.utilities.AppUtilities.hashPassword;

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
