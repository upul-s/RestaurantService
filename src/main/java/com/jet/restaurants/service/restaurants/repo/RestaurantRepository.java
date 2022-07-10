package com.jet.restaurants.service.restaurants.repo;

import com.jet.restaurants.service.restaurants.domain.Restaurant;
import com.jet.restaurants.service.restaurants.domain.Status;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;


@Repository
public interface RestaurantRepository
        extends CrudRepository<Restaurant, Integer> {

    Optional<Restaurant> findByName(String name);

    @Modifying
    @Query("Update Restaurant rs set  rs.status=?1  where rs.name= ?2")
    int updateRestaurantStatus(Status status, String name);

}
