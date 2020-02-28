package com.myapp.springsecurityjpa;

import com.myapp.springsecurityjpa.repo.UserRepository;
import com.myapp.springsecurityjpa.service.MyUserDetailsService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.security.core.userdetails.UserDetailsService;

@SpringBootApplication
@EnableJpaRepositories (basePackageClasses = UserRepository.class)
public class SpringSecurityJpaApplication {
  
  public static void main(String[] args) {
    SpringApplication.run(SpringSecurityJpaApplication.class, args);
  }
  
  @Bean
  public UserDetailsService getUserDetails(){
    return new MyUserDetailsService(); // Implementation class
  }
}
