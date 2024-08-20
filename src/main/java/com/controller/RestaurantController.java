// Package declaration for the class. This indicates that the class belongs to the package `com.controller`.
package com.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

// Import statements for using the `RestaurantEntity` and `RestaurantRepository` classes.
import com.entity.RestaurantEntity;
import com.repository.RestaurantRepository;

// Annotation that marks this class as a Spring MVC controller.
// This means it will handle HTTP requests and return responses.
@Controller
public class RestaurantController {

	// The `@Autowired` annotation tells Spring to inject the `RestaurantRepository`
	// dependency into this field.
	// This is done automatically by Spring's dependency injection mechanism.
	@Autowired
	RestaurantRepository restaurantRepository;

	// Method to handle HTTP GET requests to the "/newrestaurant" URL.
	// This method returns the name of the view that should be rendered.
	@GetMapping("newrestaurant")
	public String registerRestaurant() {
		// Returns the view name "RegisterRestaurant" which will be resolved by the view
		// resolver.
		return "RegisterRestaurant";
	}

	// Method to handle HTTP POST requests to the "/saveRestaurant" URL.
	// This method takes a `RestaurantEntity` object as a parameter, which is
	// automatically populated from the request body.
	@PostMapping("saveRestaurant")
	public String saveRestaurant(RestaurantEntity restaurantEntity) {

		// Calls the `save` method on the `restaurantRepository` to insert the
		// `restaurantEntity` into the database.
		restaurantRepository.save(restaurantEntity);

		return "redirect:/listRestaurants";
	}

	@GetMapping("/listRestaurants")
	public String listRestaurants(Model model) {

		System.out.println("List Restaurants called");
		// Calls the `findAll` method on the `restaurantRepository` to retrieve all
		// restaurants from the database.
		List<RestaurantEntity> restaurants = restaurantRepository.findAll();

		// Adds the list of restaurants to the model attribute with the name
		// "restaurants".
		model.addAttribute("restaurants", restaurants);

		System.out.println("List Restaurants exit");
		return "ListRestaurants";
	}

	

	@GetMapping("/deleteRestaurant")
	public String deleteRestaurant(int id, Model model) {

		System.out.println("Delete Restaurant called");

		// Calls the `deleteById` method on the `restaurantRepository` to delete a
		// specific restaurant by its ID.
		restaurantRepository.deleteById(id);
		// Adds the restaurant to the model attribute with the name "restaurant".
		System.out.println("Delete Restaurant exit");

		return "redirect:/listRestaurants";
	}
	
	
	@GetMapping("/editRestaurant")
	public String editRestaurant(int id, Model model) {

		System.out.println("Edit Restaurant called");

		// Calls the `findById` method on the `restaurantRepository` to retrieve a
		// specific restaurant by its ID.
		RestaurantEntity restaurant = restaurantRepository.findById(id).orElse(null);

		// Adds the restaurant to the model attribute with the name "restaurant".
		model.addAttribute("restaurant", restaurant);

		System.out.println("Edit Restaurant exit");

		return "EditRestaurant";
	}
	
	@PostMapping("/updateRestaurant")
	public String updateRestaurant(RestaurantEntity restaurantEntity) {

		System.out.println("Update Restaurant called");

		// Calls the `save` method on the `restaurantRepository` to update the
		// `restaurantEntity` in the database.
		restaurantRepository.save(restaurantEntity);

		System.out.println("Update Restaurant exit");

		return "redirect:/listRestaurants";
	}


}
