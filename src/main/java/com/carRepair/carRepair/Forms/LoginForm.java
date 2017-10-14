package com.carRepair.carRepair.Forms;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

public class LoginForm {

    private static final String USERNAME_PATTERN = "^[a-zA-Z0-9]*$";

    private static final String PASSWORD_PATTERN = "^[a-zA-Z0-9@#$%^&]*$";

    private static final int PASSWORD_MINSIZE = 6;

    @Pattern(regexp = USERNAME_PATTERN, message = "{login.username.invalid}")
    private String username;

    @NotNull(message = "{login.password.null}")
    @Pattern(regexp = PASSWORD_PATTERN, message = "{login.password.invalid}")
    @Size(min = PASSWORD_MINSIZE, message = "{login.password.size}")
    private String password;


    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

}

