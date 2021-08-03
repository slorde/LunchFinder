package com.gabriel.lunchfinder.search;

import static com.gabriel.lunchfinder.search.SearchUtils.containsString;
import static com.gabriel.lunchfinder.search.SearchUtils.valueGreaterOrEquals;
import static com.gabriel.lunchfinder.search.SearchUtils.valueLesserOrEquals;
import static java.lang.Math.min;

import java.util.List;
import java.util.stream.Collectors;

import com.gabriel.lunchfinder.data.DataManager;
import com.gabriel.lunchfinder.model.Restaurant;

public class SearchRestaurants {

	public List<Restaurant> search(String name, Integer rating, Integer distance, Integer price, String cuisineName) {
		validateParameters(rating, distance, price);
		
		List<Restaurant> filteredRestaurants = DataManager.getRestaurants().stream()
				.filter(restaurant -> containsString(restaurant.getName(), name)
						&& valueGreaterOrEquals(restaurant.getCustomerRating(), rating)
						&& valueLesserOrEquals(restaurant.getDistance(), distance)
						&& valueLesserOrEquals(restaurant.getPrice(), price)
						&& containsString(restaurant.getCuisine().getName(), cuisineName))
				.collect(Collectors.toList());

		filteredRestaurants.sort(new RestaurantComparator());

		return filteredRestaurants.subList(0, min(filteredRestaurants.size(), 5));
	}
	
	private void validateParameters(Integer rate, Integer distance, Integer price) {
		if (rate > 5 || rate < 1) {
			throw new RuntimeException("Customer Rating should be between 1 and 5");
		}
		
		if (distance > 10 || distance < 1) {
			throw new RuntimeException("Distance should be between 1 mile and 10 miles");
		}
		
		if (price > 50 || price < 10) {
			throw new RuntimeException("Price should be between $10 and $50");
		}
	}
}
