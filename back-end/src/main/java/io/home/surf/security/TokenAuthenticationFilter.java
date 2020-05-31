package io.home.surf.security;

import java.io.IOException;
import java.util.Optional;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

/**
 * @author Dimitris Anastasopoulos
 *
 */
@Component
public class TokenAuthenticationFilter extends OncePerRequestFilter {

  @Autowired
  private UserTokenService tokenService;

  @Autowired
  private CustomUserDetailsService userDetailsService;

  @Override
  protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response,
      FilterChain filterChain) throws ServletException, IOException {
    Optional<String> header = Optional.ofNullable(request.getHeader("Authorization"));
    try {
      if (header.isPresent() && header.get().startsWith("Bearer ")) {
        String token = header.get().substring(7);
        Optional<String> username = tokenService.extractUsername(token);

        if (username.isPresent()) {
          UserDetails userDetails = userDetailsService.loadUserByUsername(username.get());
          if (!tokenService.isExpired(token)) {
            UsernamePasswordAuthenticationToken upat = new UsernamePasswordAuthenticationToken(
                userDetails, null, userDetails.getAuthorities());
            upat.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
            SecurityContextHolder.getContext().setAuthentication(upat);
          }
        }
      }
      filterChain.doFilter(request, response);
    } catch (Exception e) {
      response.setStatus(HttpStatus.INTERNAL_SERVER_ERROR.value());
      response.getWriter().write(e.getMessage());
    }
  }

}
