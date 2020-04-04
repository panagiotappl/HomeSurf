package io.home.surf.dao;

import org.springframework.data.repository.PagingAndSortingRepository;

import io.home.surf.model.UserRole;

/**
 * @author Dimitris Anastasopoulos
 *
 */
public interface UserRoleDao extends PagingAndSortingRepository<UserRole, Integer> {

}
