package com.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.entity.RestaurantEntity;
import com.repository.RestaurantRepository;

@Controller
public class RestaurantController {
	
	@Autowired
	RestaurantRepository restaurantRepository;
	
	@GetMapping("newrestaurant")
	public String registerRestaurant(){
		return "RegisterRestaurant";
	}
	
	@PostMapping("saveRestaurant")
	public String saveRestaurant(RestaurantEntity restaurantEntity) {
		
		// Save method to insert into DB
		restaurantRepository.save(restaurantEntity);
		
		return "RestaurantDetails";
	}
	
}
