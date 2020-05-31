package io.home.surf.security;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import java.util.function.Function;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import io.home.surf.config.SecuritySettings;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

/**
 * @author Dimitris Anastasopoulos
 *
 */
@Service
public class UserTokenService {

  /**
   * Hour to milliseconds conversion constant
   */
  private static final long HOUR_TO_MS = 3600000;

  @Autowired
  private SecuritySettings securitySettings;

  public String generate(Authentication authentication) {
    UserDetails principal = (UserDetails) authentication.getPrincipal();
    long currentTimeMs = System.currentTimeMillis();
    Map<String, Object> claims = new HashMap<>();
    return Jwts.builder().setClaims(claims).setSubject(principal.getUsername())
        .setIssuedAt(new Date(currentTimeMs))
        .setExpiration(
            new Date(currentTimeMs + securitySettings.getTokenLifeTimeHours() * HOUR_TO_MS))
        .signWith(SignatureAlgorithm.HS512, securitySettings.getSecret()).compact();
  }

  public Optional<String> extractUsername(String token) {
    return Optional.ofNullable(extractClaim(token, Claims::getSubject));
  }

  public boolean isExpired(String token) {
    return extractExpiration(token).before(new Date());
  }

  private Date extractExpiration(String token) {
    return extractClaim(token, Claims::getExpiration);
  }

  private <T> T extractClaim(String token, Function<Claims, T> claimsResolver) {
    final Claims claims = extractAllClaims(token);
    return claimsResolver.apply(claims);
  }

  private Claims extractAllClaims(String token) {
    return Jwts.parser().setSigningKey(securitySettings.getSecret()).parseClaimsJws(token)
        .getBody();
  }

}
