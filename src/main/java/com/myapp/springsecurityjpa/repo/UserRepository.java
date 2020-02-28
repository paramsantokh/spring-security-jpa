package com.myapp.springsecurityjpa.repo;

import com.myapp.springsecurityjpa.model.MyUserDetails;
import com.myapp.springsecurityjpa.model.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Integer> {
   Logger logger = LoggerFactory.getLogger(MyUserDetails.class);
   
   Optional<User> findByUserName(String userName);
  
}
