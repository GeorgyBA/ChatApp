package com.sda.config;

import com.sda.service.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.csrf.CookieCsrfTokenRepository;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

import java.util.concurrent.TimeUnit;

import static com.google.common.base.Predicates.and;


@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
    @Autowired
    UserService userService;

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
       auth.userDetailsService(userService);
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http



                .csrf().disable()
                .authorizeRequests()
                .antMatchers( "/login")
                .anonymous()
                .and().authorizeRequests().antMatchers("/**").authenticated()
                .and()
                .formLogin()
                .loginProcessingUrl("/perform_login")
                .defaultSuccessUrl("/",true)
                .failureUrl("/login.html?error=true")
                //.failureHandler(authenticationFailureHandler())
                .and()
                .logout()
                .logoutUrl("/perform_logout")
                .invalidateHttpSession(true).clearAuthentication(true)
                .deleteCookies("JSESSIONID","remember-me")
                .logoutSuccessUrl("/login");
                //.logoutSuccessHandler(logoutSuccessHandler())


                //.and()
                //.rememberMe().tokenValiditySeconds((int)TimeUnit.DAYS.toSeconds(30));






    }


}




