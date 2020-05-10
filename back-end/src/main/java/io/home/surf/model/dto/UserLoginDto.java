package io.home.surf.model.dto;

/**
 * @author Dimitris Anastasopoulos
 *
 */
public class UserLoginDto {
  
  private String emailOrUsername;
  
  private String password;

  public UserLoginDto() {
  }

  public String getEmailOrUsername() {
    return emailOrUsername;
  }

  public void setEmailOrUsername(String emailOrUsername) {
    this.emailOrUsername = emailOrUsername;
  }

  public String getPassword() {
    return password;
  }

  public void setPassword(String password) {
    this.password = password;
  }

}
