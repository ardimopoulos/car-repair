package com.carRepair.carRepair;

import com.carRepair.carRepair.Handlers.SuccessLoginHandler;
import com.carRepair.carRepair.Security.LoginAuthenticationProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

@Configuration
@EnableWebSecurity
public class SpringSecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    private LoginAuthenticationProvider loginAuthenticationProvider;

    @Autowired
    private SuccessLoginHandler successLoginHandler;

    @Override
    protected void configure(HttpSecurity http) throws Exception {
            http.csrf().disable()
            //POST method for login
            .formLogin()
                    .successHandler(successLoginHandler)
                    .loginPage("/login")
                    .usernameParameter("username")
                    .passwordParameter("password")
            .and()
            .logout()
                .logoutSuccessUrl("/login")
            .and()
                .authorizeRequests()
                .antMatchers("/login").anonymous()
                .antMatchers("/admin/**").hasAuthority("ADMIN")
                .antMatchers("/member/**").hasAuthority("MEMBER");

            //For CSS handling
            http.authorizeRequests().antMatchers("resources/static/css/**").permitAll();

    }


    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
        auth.authenticationProvider(loginAuthenticationProvider);
    }



}
