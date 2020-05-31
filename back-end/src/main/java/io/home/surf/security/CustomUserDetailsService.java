package io.home.surf.security;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import io.home.surf.dao.UserAccountDao;
import io.home.surf.model.UserAccount;

/**
 * @author Dimitris Anastasopoulos
 *
 */
@Service
public class CustomUserDetailsService implements UserDetailsService {

  @Autowired
  private UserAccountDao userAccountDao;

  @Override
  public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
    Optional<UserAccount> user = userAccountDao.findByUsername(username);
    if (user.isPresent()) {
      List<GrantedAuthority> authorities = user.get().getUserRoles().stream()
          .map(r -> new SimpleGrantedAuthority(r.getUserRole().getType()))
          .collect(Collectors.toList());
      return new User(username, user.get().getPassword(), authorities);
    }
    throw new UsernameNotFoundException("No user with username " + username + " found");
  }

}
