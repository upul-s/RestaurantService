package com.jet.restaurants.service.restaurants.controller;

import com.jet.restaurants.service.restaurants.service.RestaurantService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class KafkaConsumerController {
	@Autowired
	private RestaurantService restaurantService;

	@KafkaListener(topics = "restaurants-status", groupId = "group_id")
	public void restaurntStatusConsume(){
		log.info("Recieving restaurant data to topic");
		log.info("===============");



	}
}
