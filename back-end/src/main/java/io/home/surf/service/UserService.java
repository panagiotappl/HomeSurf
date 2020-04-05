package io.home.surf.service;

import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import io.home.surf.dao.UserAccountDao;
import io.home.surf.model.UserAccount;

/**
 * @author Dimitris Anastasopoulos
 *
 */
@Service
public class UserService {

  @Autowired
  private UserAccountDao userAccountDao;

  public Optional<UserAccount> findById(UUID id) {
    return userAccountDao.findById(id);
  }
  
  public boolean usernameExists(String username) {
    return userAccountDao.existsByUsername(username);
  }
  
  public boolean emailExists(String email) {
    return userAccountDao.existsByEmail(email);
  }
  
  public UserAccount save(UserAccount userToBeSaved) {
    return userAccountDao.save(userToBeSaved);
  }

}
