package com.jet.restaurants.service.restaurants.repo;

import com.jet.restaurants.service.restaurants.domain.Restaurant;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface RestaurantRepository
        extends CrudRepository<Restaurant, Integer> {

    Optional<Restaurant> findByName(String name);

}
