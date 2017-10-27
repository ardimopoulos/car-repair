package com.carRepair.carRepair.Handlers;

import com.carRepair.carRepair.Utilities.AppUtilities;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Collection;

@Component
public class SuccessLoginHandler implements AuthenticationSuccessHandler {


    @Override
    public void onAuthenticationSuccess(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Authentication authentication) throws IOException, ServletException {
        String role = AppUtilities.userAuthority();
            if (role.equals("ADMIN")) {
                httpServletResponse.sendRedirect("/admin");
            } else if (role.equals("MEMBER")) {
                httpServletResponse.sendRedirect("/member");
            }
    }
}