package io.home.surf.dao;

import java.util.UUID;

import org.springframework.data.repository.PagingAndSortingRepository;

import io.home.surf.model.UserAccount;

/**
 * @author Dimitris Anastasopoulos
 *
 */
public interface UserAccountDao extends PagingAndSortingRepository<UserAccount, UUID> {

}
