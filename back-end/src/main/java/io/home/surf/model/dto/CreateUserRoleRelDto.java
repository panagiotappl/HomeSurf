package io.home.surf.model.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * @author Dimitris Anastasopoulos
 *
 */
public class CreateUserRoleRelDto {
  
  @JsonProperty("roleId")
  private int userRoleId;

  public CreateUserRoleRelDto() {
  }

  public int getUserRoleId() {
    return userRoleId;
  }

  public void setUserRoleId(int userRoleId) {
    this.userRoleId = userRoleId;
  }

}
