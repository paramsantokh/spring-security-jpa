package com.myapp.springsecurityjpa;

import com.myapp.springsecurityjpa.model.MyUserDetails;
import com.myapp.springsecurityjpa.service.MyUserDetailsService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
@EnableWebSecurity
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {
  Logger logger = LoggerFactory.getLogger(SecurityConfiguration.class);
  
  @Autowired
  MyUserDetailsService userDetailsService;
  
  @Override
  protected void configure(AuthenticationManagerBuilder auth) throws Exception {
    logger.trace("--> SecurityConfiguration:configure");
    auth.userDetailsService(userDetailsService);
  }
  
  @Override
  protected void configure(HttpSecurity http) throws Exception {
    logger.trace("--> SecurityConfiguration:configure http");
    http.authorizeRequests()
        .antMatchers("/admin").hasRole("ADMIN")
        .antMatchers("/user").hasAnyRole("USER,ADMIN")
        .antMatchers("/").permitAll()
        .and().formLogin();
  }
  
  @Bean
  public PasswordEncoder getPasswordEncoder() {
    return NoOpPasswordEncoder.getInstance();
  }
}
