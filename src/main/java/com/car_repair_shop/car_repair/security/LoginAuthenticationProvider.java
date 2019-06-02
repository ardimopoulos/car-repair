package com.car_repair_shop.car_repair.security;

import com.car_repair_shop.car_repair.domain.Member;
import com.car_repair_shop.car_repair.services.member.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.stereotype.Component;

import java.util.HashSet;
import java.util.Set;

import static com.car_repair_shop.car_repair.properties.Constants.ADMIN;
import static com.car_repair_shop.car_repair.properties.Constants.MEMBER;

@Component
public class LoginAuthenticationProvider implements AuthenticationProvider {

    @Autowired
    private MemberService memberService;

    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
        String username = authentication.getName().trim();
        String password = authentication.getCredentials().toString().trim();
        Set<GrantedAuthority> grantedAuthorities = new HashSet<>();
        Member member = memberService.login(username, password);

        if (member.isUserType()) {
            grantedAuthorities.add(new SimpleGrantedAuthority(ADMIN));

        } else {
            grantedAuthorities.add(new SimpleGrantedAuthority(MEMBER));
        }

        return new UsernamePasswordAuthenticationToken(username, password,grantedAuthorities);
    }

    @Override
    public boolean supports(Class<?> authentication) {
        return authentication.equals(UsernamePasswordAuthenticationToken.class);
    }
}