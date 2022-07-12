package com.jet.restaurants.service.restaurants.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.jet.restaurants.service.restaurants.service.RestaurantService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

import java.util.Map;

@Slf4j
@Component
public class KafkaConsumerController {
	@Autowired
	private RestaurantService restaurantService;

	/**
	 *
	 * @param message
	 * @throws JsonProcessingException
	 * Here I have just log.info for tracking purpose, but it is better to maintain audit-trace table to track the
	 * request flow
	 */
	@KafkaListener(topics = "${jet.restaurant.consumer.kafka.topic}", groupId ="${jet.restaurant.consumer.kafka.groupid}" )
	public void restaurantStatusConsumer(String message) throws JsonProcessingException {

		log.info(String.format("Received restaurant data : %s", message ));

		// Add message values to a map because we have only 2 fields
		ObjectMapper mapper = new ObjectMapper();
		Map<String, String> map = mapper.readValue(message, Map.class);

		//update restaurant status by passing the restaurant name and the status
		restaurantService.updateRestaurantStatus(map.get("status"),map.get("name"));

		log.info(String.format("Updated the restaurant status : %s", message ));


	}
}
