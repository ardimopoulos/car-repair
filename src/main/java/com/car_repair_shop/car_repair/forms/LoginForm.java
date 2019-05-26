package com.car_repair_shop.car_repair.forms;

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
public class LoginForm {

    @Pattern(regexp = USERNAME_PATTERN, message = "{login.username.invalid}")
    private String username;

    @NotNull(message = "{login.password.null}")
    @Pattern(regexp = PASSWORD_PATTERN, message = "{login.password.invalid}")
    @Size(min = PASSWORD_MINIMUM_SIZE, message = "{login.password.size}")
    private String password;
}

