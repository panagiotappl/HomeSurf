package io.home.surf.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.web.cors.CorsConfigurationSource;

/**
 * @author Dimitris Anastasopoulos
 *
 */
@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class SecurityConfigurer extends WebSecurityConfigurerAdapter {

  private static final String LOGIN = "/auth/users/login";

  private static final String REGISTER = "/auth/users/register";

  private static final String USERNAME_EXISTS = "/users/username-exists/**";

  private static final String EMAIL_EXISTS = "/users/email-exists/**";

  private static final String USER_ROLES = "/user-roles";

  @Autowired
  private CustomUserDetailsService userDetailsService;

  @Autowired
  private BCryptPasswordEncoder passwordEncoder;
  
  @Autowired
  @Qualifier("corsConfig")
  private CorsConfigurationSource corsConfig;

  @Autowired
  private CustomAuthEntryPoint authEntryPoint;

  @Autowired
  private TokenAuthenticationFilter authenticationFilter;

  @Override
  protected void configure(AuthenticationManagerBuilder auth) throws Exception {
    auth.userDetailsService(userDetailsService).passwordEncoder(passwordEncoder);
  }

  @Override
  protected void configure(HttpSecurity http) throws Exception {
    http.csrf().disable().cors().configurationSource(corsConfig).and().exceptionHandling()
        .authenticationEntryPoint(authEntryPoint).and().sessionManagement()
        .sessionCreationPolicy(SessionCreationPolicy.STATELESS).and().authorizeRequests()
        .antMatchers(LOGIN, REGISTER, USERNAME_EXISTS, EMAIL_EXISTS, USER_ROLES).permitAll()
        .anyRequest().authenticated().and()
        .addFilterBefore(authenticationFilter, UsernamePasswordAuthenticationFilter.class)
        .httpBasic();
  }

  @Override
  @Bean
  public AuthenticationManager authenticationManagerBean() throws Exception {
    return super.authenticationManagerBean();
  }

}
