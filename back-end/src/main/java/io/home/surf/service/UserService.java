package io.home.surf.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import io.home.surf.dao.UserAccountDao;

/**
 * @author Dimitris Anastasopoulos
 *
 */
@Service
public class UserService {
  
  @Autowired
  private UserAccountDao userAccountDao;

}
