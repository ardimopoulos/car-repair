package com.car_repair_shop.car_repair.forms.user;

import com.car_repair_shop.car_repair.domain.Member;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import static com.car_repair_shop.car_repair.properties.ValidationPatterns.*;

@NoArgsConstructor
@Getter
@Setter
public class EditUserForm {

    @NotNull
    private long userId;

    @NotNull(message = "{edit-user.vat.null}")
    @Pattern(regexp = VAT_PATTERN, message = "{edit-user.vat.invalid}")
    private String vat;

    @NotNull(message = "{edit-user.firstname.null}")
    @Pattern(regexp = NAME_PATTERN, message = "{edit-user.firstname.invalid}")
    private String firstname;

    @NotNull(message = "{edit-user.lastname.null}")
    @Pattern(regexp = NAME_PATTERN, message = "{edit-user.lastname.invalid}")
    private String lastname;

    @NotNull(message = "{edit-user.address.null}")
    @Pattern(regexp = ADDRESS_PATTERN, message = "{edit-user.address.invalid}")
    private String address;

    @NotNull(message = "{edit-user.email.null}")
    @Pattern(regexp = EMAIL_PATTERN, message = "{edit-user.email.invalid}")
    private String email;

    private String password;

    private String newPassword;

    @NotNull
    private boolean userType;

    public EditUserForm(Member member) {
        this.userId = member.getUserId();
        this.vat = member.getVat();
        this.firstname = member.getFirstname();
        this.lastname = member.getLastname();
        this.address = member.getAddress();
        this.email = member.getEmail();
        this.password = member.getPassword();
        this.userType = member.isUserType();
    }
}
