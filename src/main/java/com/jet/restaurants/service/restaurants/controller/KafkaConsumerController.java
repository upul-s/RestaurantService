package com.jet.restaurants.service.restaurants.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.jet.restaurants.service.restaurants.service.RestaurantService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

import java.util.Map;

@Slf4j
@Component
public class KafkaConsumerController {
	@Autowired
	private RestaurantService restaurantService;

	private static final String TOPIC_RES = "restaurants-status";

	@KafkaListener(topics = TOPIC_RES, groupId = "group_id")
	public void restaurntStatusConsume(String message) throws JsonProcessingException {
		log.info("Recieving restaurant data and update the restaurant status");

		// Add message values to a map because we have only 2 fields
		ObjectMapper mapper = new ObjectMapper();
		Map<String, String> map = mapper.readValue(message, Map.class);

		//update restaurant status by passing the restaurant name and the status
		restaurantService.updateRestaurantStatus(map.get("status"),map.get("name"));



	}
}
