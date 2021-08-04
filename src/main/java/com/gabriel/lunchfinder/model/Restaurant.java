package com.gabriel.lunchfinder.model;

public class Restaurant {
	private String name;
	private Integer customerRating;
	private Integer distance;
	private Integer price;
	private Cuisine cuisine;
	
	public Restaurant(String name, Integer customerRating, Integer distance, Integer price, Cuisine cuisine) {
		this.name = name;
		this.customerRating = customerRating;
		this.distance = distance;
		this.price = price;
		this.cuisine = cuisine;
	}
	
	@Override
	public String toString() {
		return String.format("%s - rate: %d - distance: %d - price: %d - %s", this.name, this.customerRating, this.distance, this.price, this.cuisine.getName());
	}

	public String getName() {
		return this.name;
	}
	
	public Integer getCustomerRating() {
		return this.customerRating;
	}
	
	public Integer getDistance() {
		return this.distance;
	}
	
	public Integer getPrice() {
		return this.price;
	}
	
	public Cuisine getCuisine() {
		return this.cuisine;
	}
}
