package io.home.surf.model.dto;

import java.util.List;
import java.util.UUID;

/**
 * @author Dimitris Anastasopoulos
 *
 */
public class UserLoginResponse {

  private UUID id;

  private String username;

  private String token;

  private List<UserRoleResponse> roles;

  public UserLoginResponse() {
  }

  public UUID getId() {
    return id;
  }

  public void setId(UUID id) {
    this.id = id;
  }

  public String getUsername() {
    return username;
  }

  public void setUsername(String username) {
    this.username = username;
  }

  public String getToken() {
    return token;
  }

  public void setToken(String token) {
    this.token = token;
  }

  public List<UserRoleResponse> getRoles() {
    return roles;
  }

  public void setRoles(List<UserRoleResponse> roles) {
    this.roles = roles;
  }

}
