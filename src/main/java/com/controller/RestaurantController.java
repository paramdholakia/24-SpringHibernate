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
		System.out.println("Entering registerRestaurant() - Rendering 'RegisterRestaurant' view.");

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
		System.out.println("Entering listRestaurants() - Fetching list of restaurants.");

		List<RestaurantEntity> restaurants = restaurantRepository.findAll();

		model.addAttribute("restaurants", restaurants);

		System.out.println("Number of restaurants retrieved: " + restaurants.size());

		System.out.println("Exiting listRestaurants() - Rendering 'ListRestaurants' view.");
		return "ListRestaurants";
	}

	@GetMapping("/deleteRestaurant")
	public String deleteRestaurant(int id, Model model) {
		System.out.println("Entering deleteRestaurant() - Deleting restaurant with ID: " + id);

		restaurantRepository.deleteById(id);

		System.out.println("Restaurant with ID " + id + " deleted successfully.");

		System.out.println("Exiting deleteRestaurant() - Redirecting to '/listRestaurants'.");
		return "redirect:/listRestaurants";
	}

	@GetMapping("/editRestaurant")
	public String editRestaurant(int id, Model model) {
		System.out.println("Entering editRestaurant() - Editing restaurant with ID: " + id);

		RestaurantEntity restaurant = restaurantRepository.findById(id).orElse(null);

		if (restaurant != null) {
			System.out.println("Restaurant found: " + restaurant.getRestaurantName());
		} else {
			System.out.println("Restaurant with ID " + id + " not found.");
		}

		model.addAttribute("restaurant", restaurant);

		System.out.println("Exiting editRestaurant() - Rendering 'EditRestaurant' view.");
		return "EditRestaurant";
	}

	@PostMapping("/updateRestaurant")
	public String updateRestaurant(RestaurantEntity restaurantEntity) {
		System.out.println("Entering updateRestaurant() - Updating restaurant data.");

		System.out.println("Updated Restaurant Details:");
		System.out.println("  Name     : " + restaurantEntity.getRestaurantName());
		System.out.println("  Address  : " + restaurantEntity.getRestaurantAddress());
		System.out.println("  Category : " + restaurantEntity.getRestaurantCategory());

		restaurantRepository.save(restaurantEntity);

		System.out.println("Restaurant updated successfully.");

		System.out.println("Exiting updateRestaurant() - Redirecting to '/listRestaurants'.");
		return "redirect:/listRestaurants";
	}
}
