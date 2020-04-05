package io.home.surf.model.dto;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * @author Dimitris Anastasopoulos
 *
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class UserRegisterDto {

  private String username;

  private String password;

  private String email;

  private String name;

  private String surname;

  private String mobile;
  
  @JsonProperty("roles")
  private List<CreateUserRoleRelDto> userRoles = new ArrayList<>();

  public UserRegisterDto() {
  }

  public String getUsername() {
    return username;
  }

  public void setUsername(String username) {
    this.username = username;
  }

  public String getPassword() {
    return password;
  }

  public void setPassword(String password) {
    this.password = password;
  }

  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getSurname() {
    return surname;
  }

  public void setSurname(String surname) {
    this.surname = surname;
  }

  public String getMobile() {
    return mobile;
  }

  public void setMobile(String mobile) {
    this.mobile = mobile;
  }

  public List<CreateUserRoleRelDto> getUserRoles() {
    return userRoles;
  }

  public void setUserRoles(List<CreateUserRoleRelDto> userRoles) {
    this.userRoles = userRoles;
  }

}
