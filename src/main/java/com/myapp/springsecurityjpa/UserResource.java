package com.myapp.springsecurityjpa;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserResource {
  Logger logger = LoggerFactory.getLogger(UserResource.class);
  
  @GetMapping ("/")
  private String home() {
    return "<h1>Welcome!</h1>";
  }
  
  @GetMapping ("/user")
  private String user() {
    logger.trace("-->UserResource:user");
    return "<h1>Welcome User!</h1>";
  }
  
  @GetMapping ("/admin")
  private String admin() {
    logger.trace("-->UserResource:admin");
    return "<h1>Welcome Admin!</h1>";
  }
}
