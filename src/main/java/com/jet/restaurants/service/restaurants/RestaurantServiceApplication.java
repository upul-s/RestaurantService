package com.jet.restaurants.service.restaurants;

import com.jet.restaurants.service.restaurants.domain.Status;
import com.jet.restaurants.service.restaurants.service.RestaurantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class RestaurantServiceApplication implements CommandLineRunner {

	@Autowired
	private RestaurantService restaurantService;

	public static void main(String[] args) {
		SpringApplication.run(RestaurantServiceApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		restaurantService.createRestaurant("McDonalds", "Nijverdal", "Burgerlaan 1", "", "7442 WN", "Netherlands", Status.OPEN);
		restaurantService.createRestaurant("Burger King", "London", "Kingstreet 12", "", "1001 PO", "United Kingdom", Status.OPEN);
		restaurantService.createRestaurant("Pizza Hut", "Paris", "Salami rue 4", "", "5000 PZ", "France", Status.OPEN);
		restaurantService.createRestaurant("KFC", "Bologna", "Pollostrata 4", "Buildino 4", "6898", "Italia", Status.OPEN);
		restaurantService.createRestaurant("BurgerMe", "Los Angeles", "Pickle street", "", "544667", "United States", Status.OPEN);
 	}

}
