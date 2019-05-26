package com.car_repair_shop.car_repair.handlers;

import com.car_repair_shop.car_repair.utilities.AppUtilities;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Component
public class SuccessLoginHandler implements AuthenticationSuccessHandler {


    @Override
    public void onAuthenticationSuccess(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Authentication authentication) throws IOException {
        String role = AppUtilities.userAuthority();

        if (role.equals("ADMIN")) {
                httpServletResponse.sendRedirect("/admin");

        } else if (role.equals("MEMBER")) {
            httpServletResponse.sendRedirect("/member");
        }
    }
}