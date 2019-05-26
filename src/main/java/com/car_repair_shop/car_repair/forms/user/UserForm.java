package com.car_repair_shop.car_repair.forms.user;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import static com.car_repair_shop.car_repair.properties.ValidationPatterns.*;

@NoArgsConstructor
@Getter
@Setter
public class UserForm {

    @NotNull(message = "{create-user.vat.null}")
    @Pattern(regexp = VAT_PATTERN, message = "{create-user.vat.invalid}")
    private String vat;

    @NotNull(message = "{create-user.firstname.null}")
    @Pattern(regexp = NAME_PATTERN, message = "{create-user.firstname.invalid}")
    private String firstname;

    @NotNull(message = "{create-user.lastname.null}")
    @Pattern(regexp = NAME_PATTERN, message = "{create-user.lastname.invalid}")
    private String lastname;

    @NotNull(message = "{create-user.address.null}")
    @Pattern(regexp = ADDRESS_PATTERN, message = "{create-user.address.invalid}")
    private String address;

    @NotNull(message = "{create-user.email.null}")
    @Pattern(regexp = EMAIL_PATTERN, message = "{create-user.email.invalid}")
    private String email;

    @NotNull(message = "{create-user.password.null}")
    @Pattern(regexp = PASSWORD_PATTERN, message = "{create-user.password.invalid}")
    @Size(min = PASSWORD_MINIMUM_SIZE, message = "Password length must be 8 characters or/and numbers at least.")
    private String password;

    private boolean userType;

    private boolean addVehicle;
}
