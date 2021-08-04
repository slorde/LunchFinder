package com.gabriel.lunchfinder.repository;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.gabriel.lunchfinder.data.DataManager;
import com.gabriel.lunchfinder.model.Restaurant;

@Repository
public class RestaurantRepository {
	
	public List<Restaurant> findAll(){
		return DataManager.getRestaurants();
	}
}
