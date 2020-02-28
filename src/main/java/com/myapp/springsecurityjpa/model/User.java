package com.myapp.springsecurityjpa.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table (name = "user")
public class User {
  
  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  int id;
  @Column(name="user_name")
  String userName;
  String password;
  boolean active;
  String roles;
  
  public int getId() {
    return id;
  }
  
  public void setId(int id) {
    this.id = id;
  }
  
  public String getUserName() {
    return userName;
  }
  
  public void setUserName(String userName) {
    this.userName = userName;
  }
  
  public String getPassword() {
    return password;
  }
  
  public void setPassword(String password) {
    this.password = password;
  }
  
  public boolean isActive() {
    return active;
  }
  
  public void setActive(boolean active) {
    this.active = active;
  }
  
  public String getRoles() {
    return roles;
  }
  
  public void setRoles(String roles) {
    this.roles = roles;
  }
}
