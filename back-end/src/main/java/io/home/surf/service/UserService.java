package io.home.surf.service;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import io.home.surf.dao.UserAccountDao;
import io.home.surf.dao.UserRoleDao;
import io.home.surf.model.UserAccount;
import io.home.surf.model.UserRole;
import io.home.surf.model.UserRoleRel;

/**
 * @author Dimitris Anastasopoulos
 *
 */
@Service
@Transactional(readOnly = true)
public class UserService {

  @Autowired
  private UserAccountDao userAccountDao;

  @Autowired
  private UserRoleDao userRoleDao;

  public Optional<UserAccount> findById(UUID id) {
    return userAccountDao.findById(id);
  }

  public boolean usernameExists(String username) {
    return userAccountDao.existsByUsername(username);
  }

  public boolean emailExists(String email) {
    return userAccountDao.existsByEmail(email);
  }

  @Transactional
  public UserAccount save(UserAccount userToBeSaved) {
    Set<UserRoleRel> relations = new HashSet<>();
    relations.addAll(userToBeSaved.getUserRoles());
    userToBeSaved.getUserRoles().clear();
    UserAccount savedUserAccount = userAccountDao.save(userToBeSaved);
    for (UserRoleRel relation : relations) {
      Optional<UserRole> role = userRoleDao.findById(relation.getUserRole().getId());
      if (role.isPresent()) {
        savedUserAccount.addRole(role.get());
      }
    }
    return savedUserAccount;
  }

}
