package com.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.entity.RestaurantEntity;
import com.repository.RestaurantRepository;

@Controller
public class RestaurantController {

	@Autowired
	RestaurantRepository restaurantRepository;

	@GetMapping("newrestaurant")
	public String registerRestaurant() {
		// Log the entry into the registerRestaurant method
		System.out.println("Entering registerRestaurant() - Rendering 'RegisterRestaurant' view.");

		// Return the view name for the restaurant registration page
		return "RegisterRestaurant";
	}

	@PostMapping("saveRestaurant")
	public String saveRestaurant(@Validated RestaurantEntity restaurantEntity, BindingResult bindingResult,
			Model model) {
		System.out.println("Entering saveRestaurant() - Saving restaurant data.");

		if (bindingResult.hasErrors()) {
			System.out.println("Whoops! Validation errors occurred.");
			model.addAttribute("restaurantEntity", restaurantEntity);
			model.addAttribute("bindingResult", bindingResult);
			return "RegisterRestaurant";
		}

		restaurantRepository.save(restaurantEntity);
		System.out.println("Restaurant saved successfully.");
		return "redirect:/listRestaurants";
	}

	@GetMapping("/listRestaurants")
	public String listRestaurants(Model model) {
		// Log the entry into the listRestaurants method
		System.out.println("Entering listRestaurants() - Fetching list of restaurants.");

		// Retrieve all restaurants from the database
		List<RestaurantEntity> restaurants = restaurantRepository.findAll();

		// Add the list of restaurants to the model
		model.addAttribute("restaurants", restaurants);

		// Log the number of restaurants retrieved
		System.out.println("Number of restaurants retrieved: " + restaurants.size());

		// Log the exit from the listRestaurants method
		System.out.println("Exiting listRestaurants() - Rendering 'ListRestaurants' view.");
		return "ListRestaurants";
	}

	@GetMapping("/deleteRestaurant")
	public String deleteRestaurant(int id, Model model) {
		// Log the entry into the deleteRestaurant method
		System.out.println("Entering deleteRestaurant() - Deleting restaurant with ID: " + id);

		// Delete the restaurant by its ID
		restaurantRepository.deleteById(id);

		// Log the successful deletion
		System.out.println("Restaurant with ID " + id + " deleted successfully.");

		// Log the exit from the deleteRestaurant method
		System.out.println("Exiting deleteRestaurant() - Redirecting to '/listRestaurants'.");
		return "redirect:/listRestaurants";
	}

	@GetMapping("/editRestaurant")
	public String editRestaurant(int id, Model model) {
		// Log the entry into the editRestaurant method
		System.out.println("Entering editRestaurant() - Editing restaurant with ID: " + id);

		// Find the restaurant by its ID
		RestaurantEntity restaurant = restaurantRepository.findById(id).orElse(null);

		// Log whether the restaurant was found or not
		if (restaurant != null) {
			System.out.println("Restaurant found: " + restaurant.getRestaurantName());
		} else {
			System.out.println("Restaurant with ID " + id + " not found.");
		}

		// Add the restaurant to the model
		model.addAttribute("restaurant", restaurant);

		// Log the exit from the editRestaurant method
		System.out.println("Exiting editRestaurant() - Rendering 'EditRestaurant' view.");
		return "EditRestaurant";
	}

	@PostMapping("/updateRestaurant")
	public String updateRestaurant(RestaurantEntity restaurantEntity) {
		// Log the entry into the updateRestaurant method
		System.out.println("Entering updateRestaurant() - Updating restaurant data.");

		// Log detailed restaurant entity information before updating
		System.out.println("Updated Restaurant Details:");
		System.out.println("  Name     : " + restaurantEntity.getRestaurantName());
		System.out.println("  Address  : " + restaurantEntity.getRestaurantAddress());
		System.out.println("  Category : " + restaurantEntity.getRestaurantCategory());

		// Update the restaurant entity in the database
		restaurantRepository.save(restaurantEntity);

		// Log the successful update operation
		System.out.println("Restaurant updated successfully.");

		// Log the exit from the updateRestaurant method
		System.out.println("Exiting updateRestaurant() - Redirecting to '/listRestaurants'.");
		return "redirect:/listRestaurants";
	}
}
