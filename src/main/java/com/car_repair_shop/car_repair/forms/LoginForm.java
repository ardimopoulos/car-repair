package com.car_repair_shop.car_repair.forms;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

@NoArgsConstructor
@Getter
@Setter
public class LoginForm {

    private static final String USERNAME_PATTERN = "^[a-zA-Z0-9]*$";
    private static final String PASSWORD_PATTERN = "^[a-zA-Z0-9@#$%^&]*$";
    private static final int PASSWORD_MIN_SIZE = 6;

    @Pattern(regexp = USERNAME_PATTERN, message = "{login.username.invalid}")
    private String username;

    @NotNull(message = "{login.password.null}")
    @Pattern(regexp = PASSWORD_PATTERN, message = "{login.password.invalid}")
    @Size(min = PASSWORD_MIN_SIZE, message = "{login.password.size}")
    private String password;
}

