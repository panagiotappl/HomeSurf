package io.home.surf.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * HomeSurf application security settings.
 * 
 * @author Dimitris Anastasopoulos
 *
 */
@Component
@ConfigurationProperties("securitysettings")
public class SecuritySettings {

  private String secret;

  private int tokenLifeTimeHours;

  public String getSecret() {
    return secret;
  }

  public void setSecret(String secret) {
    this.secret = secret;
  }

  public int getTokenLifeTimeHours() {
    return tokenLifeTimeHours;
  }

  public void setTokenLifeTimeHours(int tokenLifeTimeHours) {
    this.tokenLifeTimeHours = tokenLifeTimeHours;
  }

}
