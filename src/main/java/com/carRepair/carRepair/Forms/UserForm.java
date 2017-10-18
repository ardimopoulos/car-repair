package com.carRepair.carRepair.Forms;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

public class UserForm {
    private static final String VAT_PATTERN = "^[0-9]{9}$";
    private static final String NAME_PATTERN = "^[a-zA-Z]+$";
    private static final String ADDRESS_PATTERN = "^[a-zA-Z0-9\\s]+$";
    private static final String EMAIL_PATTERN = "^[a-zA-Z0-9_%#+.-]+@[A-Za-z0-9.-]+.[a-zA-Z]+$";
    private static final String PASSWORD_PATTERN = "^[a-zA-Z0-9]+$";
    private static final int PASSWORD_MINIMUM_SIZE = 8;

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

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getEmail() {
        return email;
    }

    public String getVat() {
        return vat;
    }

    public void setVat(String vat) {
        this.vat = vat;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public boolean getUserType() {
        return userType;
    }

    public void setUserType(boolean type) {
        userType = type;
    }
}
