package com.jet.restaurants.service.restaurants.service;

import com.jet.restaurants.service.restaurants.domain.Restaurant;
import com.jet.restaurants.service.restaurants.domain.Status;
import com.jet.restaurants.service.restaurants.repo.RestaurantRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.NoSuchElementException;

@Slf4j
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
    @Transactional
    public void updateRestaurantStatus(String status, String name) {
        verifyRestaurant(name);
        restaurantRepository.updateRestaurantStatus(Status.decode(status), name);
        log.info("Updating the restaurant status");

    }
    private Restaurant verifyRestaurant(String name) throws NoSuchElementException {
        return restaurantRepository.findByName(name).orElseThrow(() ->
                new NoSuchElementException("Restaurant not found with name:" + name));
    }


}
