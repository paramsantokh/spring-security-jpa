package com.myapp.springsecurityjpa.service;

import com.myapp.springsecurityjpa.repo.UserRepository;
import com.myapp.springsecurityjpa.model.MyUserDetails;
import com.myapp.springsecurityjpa.model.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class MyUserDetailsService implements UserDetailsService {
  Logger logger = LoggerFactory.getLogger(MyUserDetails.class);
  
  @Autowired
  UserRepository repository;
  
  @Override
  public UserDetails loadUserByUsername(String name) throws UsernameNotFoundException {
    logger.trace("--> SecurityConfiguration:configure");
    
    Optional<User> user = repository.findByUserName(name);
    
    user.orElseThrow(() -> new UsernameNotFoundException("Not Found: " + name));
    
    return user.map(MyUserDetails::new).get();
  }
}
