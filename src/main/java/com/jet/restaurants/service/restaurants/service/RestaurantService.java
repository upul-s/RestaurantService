package com.jet.restaurants.service.restaurants.service;

import com.jet.restaurants.service.restaurants.domain.Restaurant;
import com.jet.restaurants.service.restaurants.domain.Status;
import com.jet.restaurants.service.restaurants.repo.RestaurantRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RestaurantService {
    private RestaurantRepository restaurantRepository;

    @Autowired
    public RestaurantService(RestaurantRepository restaurantRepository) {
        this.restaurantRepository = restaurantRepository;
    }

    public Restaurant createRestaurant(String name, String city, String addressLine1, String addressLine2, String zipCode, String country, Status status) {
        Restaurant restaurant = restaurantRepository.save(Restaurant.create(name, city, addressLine1, addressLine2, zipCode, country, status));

        return restaurant;
    }

}
