package com.gabriel.lunchfinder.data;

import java.util.List;
import java.util.Map;

import com.gabriel.lunchfinder.model.Cuisine;
import com.gabriel.lunchfinder.model.Restaurant;

public class DataManager {

	private static List<Restaurant> restaurants;
	private static Map<Integer, Cuisine> cuisines;

	public static Cuisine findCuisines(Integer id) {
		if (cuisines == null) {
			cuisines = DataFile.loadCuisine();
		}

		return cuisines.get(id);
	}

	public static List<Restaurant> getRestaurants() {
		if (restaurants == null) {
			restaurants = DataFile.loadRestaurants();
		}

		return restaurants;
	}
}
