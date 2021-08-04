package com.gabriel.lunchfinder.dto;

import com.gabriel.lunchfinder.model.Restaurant;

public class RestaurantDTO {
	
	private String name;
	private Integer rating;
	private Integer distance;
	private Integer price;
	private String cuisine;
	
	public RestaurantDTO(Restaurant restaurant) {
		this.name = restaurant.getName();
		this.rating =restaurant.getCustomerRating();
		this.distance = restaurant.getDistance();
		this.price = restaurant.getPrice();
		this.cuisine = restaurant.getCuisine().getName();
	}
	
	public String getName() {
		return name;
	}
	
	public Integer getRating() {
		return rating;
	}
	
	public Integer getDistance() {
		return distance;
	}
	
	public Integer getPrice() {
		return price;
	}

	public String getCuisine() {
		return cuisine;
	}
}
