package io.home.surf.dao;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import io.home.surf.model.UserRole;

/**
 * @author Dimitris Anastasopoulos
 *
 */
public interface UserRoleDao extends JpaRepository<UserRole, Integer> {
  
  Optional<UserRole> findById(int id);

}
