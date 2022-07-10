package com.jet.restaurants.service.restaurants.service;

import com.jet.restaurants.service.restaurants.domain.Restaurant;
import com.jet.restaurants.service.restaurants.domain.Status;
import com.jet.restaurants.service.restaurants.repo.RestaurantRepository;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.slf4j.Logger;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.NoSuchElementException;
import java.util.Optional;

import static org.mockito.Mockito.*;


public class RestaurantServiceTest {
	@Mock
	RestaurantRepository restaurantRepository;

	private Restaurant restaurant;
	@InjectMocks
	RestaurantService restaurantService;

	@BeforeMethod
	public void setUp() {
		MockitoAnnotations.openMocks(this);
		restaurant = new Restaurant(Integer.valueOf(0), "name", "city", "addressLine1", "addressLine2", "zipCode", "country", Status.OPEN);
	}

	@Test
	public void testCreateRestaurantSuccess() {

		when(restaurantRepository.save(Mockito.any(Restaurant.class)))
				.thenAnswer(i -> i.getArguments()[0]);

		Restaurant result = restaurantService.createRestaurant("name", "city", "addressLine1", "addressLine2", "zipCode", "country", Status.OPEN);
		Assert.assertEquals(result.getAddressLine1(), "addressLine1");
		Assert.assertEquals(result.getCity(), "city");
		Assert.assertEquals(result.getStatus(), Status.OPEN);
	}

	@Test(expectedExceptions = NoSuchElementException.class)
	public void testUpdateRestaurantWithInvalidName() {
		when(restaurantRepository.findByName(anyString())).thenReturn(Optional.empty());
		when(restaurantRepository.updateRestaurantStatus(any(), anyString())).thenReturn(1);

		restaurantService.updateRestaurantStatus("status", "name");
	}

	@Test
	public void testUpdateRestaurantWithValidName() {
		when(restaurantRepository.findByName(anyString())).thenReturn(Optional.of(restaurant));
		when(restaurantRepository.updateRestaurantStatus(any(), anyString())).thenReturn(1);

		restaurantService.updateRestaurantStatus("status", "name");
	}


}

