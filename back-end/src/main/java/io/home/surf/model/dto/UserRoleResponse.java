package io.home.surf.model.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * @author Dimitris Anastasopoulos
 *
 */
public class UserRoleResponse {

  @JsonProperty("id")
  private int userRoleId;

  @JsonProperty("type")
  private String userRoleType;

  public UserRoleResponse() {
  }

  public int getUserRoleId() {
    return userRoleId;
  }

  public void setUserRoleId(int userRoleId) {
    this.userRoleId = userRoleId;
  }

  public String getUserRoleType() {
    return userRoleType;
  }

  public void setUserRoleType(String userRoleType) {
    this.userRoleType = userRoleType;
  }

}
