package io.home.surf.dao;

import org.springframework.data.repository.PagingAndSortingRepository;

import io.home.surf.model.Listing;

/**
 * @author Dimitris Anastasopoulos
 *
 */
public interface ListingDao extends PagingAndSortingRepository<Listing, Integer> {

}
