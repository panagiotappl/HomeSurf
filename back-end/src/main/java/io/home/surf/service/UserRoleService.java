package io.home.surf.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import io.home.surf.dao.UserRoleDao;
import io.home.surf.model.UserRole;

/**
 * @author Dimitris Anastasopoulos
 *
 */
@Service
@Transactional(readOnly = true)
public class UserRoleService {

  @Autowired
  private UserRoleDao userRoleDao;

  public List<UserRole> findAll() {
    return userRoleDao.findAll();
  }

}
