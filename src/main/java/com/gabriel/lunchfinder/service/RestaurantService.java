package com.gabriel.lunchfinder.service;

import static com.gabriel.lunchfinder.utils.SearchUtils.containsString;
import static com.gabriel.lunchfinder.utils.SearchUtils.valueGreaterOrEquals;
import static com.gabriel.lunchfinder.utils.SearchUtils.valueLesserOrEquals;
import static java.lang.Math.min;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gabriel.lunchfinder.comparator.RestaurantComparator;
import com.gabriel.lunchfinder.data.DataManager;
import com.gabriel.lunchfinder.model.Restaurant;
import com.gabriel.lunchfinder.repository.RestaurantRepository;


@Service
public class RestaurantService {
	
	@Autowired
	private RestaurantRepository repository;
	
	public List<Restaurant> find(String name, Integer rating, Integer distance, Integer price, String cuisineName) {
		validateParameters(rating, distance, price);
		
		List<Restaurant> filteredRestaurants = repository.findAll().stream()
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
