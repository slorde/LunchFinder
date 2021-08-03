package com.gabriel.lunchfinder.search;

import java.util.Comparator;

import com.gabriel.lunchfinder.model.Restaurant;

public class RestaurantComparator implements Comparator<Restaurant> {

	@Override
	public int compare(Restaurant restaurant1, Restaurant restaurant2) {
		if (!restaurant1.getDistance().equals(restaurant2.getDistance())) {
			return restaurant1.getDistance().compareTo(restaurant2.getDistance());
		}
		
		if (!restaurant1.getCustomerRating().equals(restaurant2.getCustomerRating())) {
			return restaurant2.getCustomerRating().compareTo(restaurant1.getCustomerRating());
		}
		
		if (!restaurant1.getPrice().equals(restaurant2.getPrice())) {
			return restaurant1.getPrice().compareTo(restaurant2.getPrice());
		}
		
		return restaurant1.getName().compareTo(restaurant2.getName());
	}

}
