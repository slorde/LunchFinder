package com.gabriel.lunchfinder.data;

import java.io.RandomAccessFile;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.gabriel.lunchfinder.model.Cuisine;
import com.gabriel.lunchfinder.model.Restaurant;

public class DataFile {
		
	public static List<Restaurant> loadRestaurants() {
		List<Restaurant> restaurants = new ArrayList<>();

		try {
			RandomAccessFile file = new RandomAccessFile("files/restaurants.csv", "r");
			
			try {
				String line = file.readLine();
				while(line != null) {
					String[] split = line.split(",");
					String name = split[0];
					Integer rating = Integer.valueOf(split[1]);
					Integer distance = Integer.valueOf(split[2]);
					Integer price = Integer.valueOf(split[3]);
					Integer cuisineID = Integer.valueOf(split[4]);
					
					restaurants.add(new Restaurant(name, rating, distance, price, DataManager.findCuisines(cuisineID)));
					
					line = file.readLine();
				}
			} finally {
				file.close();
			}
			
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
		return restaurants;
	}

	public static Map<Integer, Cuisine> loadCuisine() {
		Map<Integer, Cuisine> cuisines = new HashMap<>();
		try {
			RandomAccessFile file = new RandomAccessFile("files/cuisines.csv", "r");
			try {
				String line = file.readLine();
				while(line != null) {
					String[] split = line.split(",");
					Integer id = Integer.valueOf(split[0]);
					cuisines.put(id, new Cuisine(id, split[1]));
					
					line = file.readLine();
				}
			} finally {
				file.close();
			}
			
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
		
		return cuisines;
	}
}
