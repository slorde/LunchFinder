package com.gabriel.lunchfinder.controller;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.gabriel.lunchfinder.dto.RestaurantDTO;
import com.gabriel.lunchfinder.model.Restaurant;
import com.gabriel.lunchfinder.service.RestaurantService;

@RestController()
@RequestMapping("restaurants")
public class RestaurantController {

	@Autowired
	private RestaurantService service;

	@GetMapping
	public ResponseEntity<List<RestaurantDTO>> findRestaurants(@RequestParam(required = false) String name,
			@RequestParam(required = false) Integer distance, @RequestParam(required = false) Integer price,
			@RequestParam(required = false) Integer rating, @RequestParam(required = false) String cuisineName) {
	
		List<Restaurant> restaurants = service.find(name, rating, distance, price, cuisineName);
		List<RestaurantDTO> dto = restaurants.stream().map(r -> new RestaurantDTO(r)).collect(Collectors.toList());
		return ResponseEntity.ok(dto);
	}
}
