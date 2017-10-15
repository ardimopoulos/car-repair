package com.carRepair.carRepair;

import com.carRepair.carRepair.Security.LoginAuthenticationProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

@Configuration
@EnableWebSecurity
public class SpringSecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    private LoginAuthenticationProvider loginAuthenticationProvider;

    @Override
    protected void configure(HttpSecurity http) throws Exception {
              http
              .csrf().requireCsrfProtectionMatcher(new AntPathRequestMatcher("**/login"))
                .and()
                 //POST method for login
                .formLogin().usernameParameter("username").passwordParameter("password")
                .loginPage("/login").defaultSuccessUrl("/admin")
              .and()
              .logout().logoutRequestMatcher(new AntPathRequestMatcher("/logout")).logoutSuccessUrl("/login")
               .and()
                  .authorizeRequests()
                //.antMatchers("/login").permitAll()
                .antMatchers("/admin/**").hasAuthority("ADMIN")
                .antMatchers("/user/**").hasAuthority("USER");
              // .anyRequest().authenticated();
//                .and()

//
//                .logout().permitAll();
//                //For CSS handling
            //http.authorizeRequests().antMatchers("/resources/static/css/**").permitAll().anyRequest().permitAll();

//                .and()
//                .exceptionHandling().accessDeniedHandler(accessDeniedHandler);
    }

    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
        auth.authenticationProvider(loginAuthenticationProvider);
    }



}
