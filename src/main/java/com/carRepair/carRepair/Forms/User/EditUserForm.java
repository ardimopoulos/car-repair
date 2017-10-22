package com.carRepair.carRepair.Forms.User;

import com.carRepair.carRepair.Domain.Member;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

public class EditUserForm {

    private static final String VAT_PATTERN = "^[0-9]{9}$";
    private static final String NAME_PATTERN = "^[a-zA-Z]+$";
    private static final String ADDRESS_PATTERN = "^[a-zA-Z0-9\\s]+$";
    private static final String EMAIL_PATTERN = "^[a-zA-Z0-9_%#+.-]+@[A-Za-z0-9.-]+.[a-zA-Z]+$";
    private static final String PASSWORD_PATTERN = "^[a-zA-Z0-9]*$";
    private static final int PASSWORD_MINIMUM_SIZE = 8;

    @NotNull
    private long userId;

    @NotNull(message = "{edit-user.vat.null}")
    @Pattern(regexp = VAT_PATTERN, message = "{edit-user.vat.invalid}")
    private String vat;

    @NotNull(message = "error")
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

    public EditUserForm(){}

    public EditUserForm(Member member) {
        this.userId = member.getUserId();
        this.vat = member.getVat();
        this.firstname = member.getFirstname();
        this.lastname = member.getLastname();
        this.address = member.getAddress();
        this.email = member.getEmail();
        this.password = member.getPassword();
        this.userType = member.getUserType();
    }

    public long getUserId() {
        return userId;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }

    public String getVat() {
        return vat;
    }

    public void setVat(String vat) {
        this.vat = vat;
    }

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

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getEmail() {
        return email;
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

    public String getNewPassword() {
        return newPassword;
    }

    public void setNewPassword(String newPassword) {
        this.newPassword = newPassword;
    }

    public boolean getUserType() {
        return userType;
    }

    public void setUserType(boolean userType) {
        this.userType = userType;
    }
}
