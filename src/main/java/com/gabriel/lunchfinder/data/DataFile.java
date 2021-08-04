package com.gabriel.lunchfinder.data;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.RandomAccessFile;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.util.ResourceUtils;

import com.gabriel.lunchfinder.model.Cuisine;
import com.gabriel.lunchfinder.model.Restaurant;

public class DataFile {
		
	public static List<Restaurant> loadRestaurants() {
		List<Restaurant> restaurants = new ArrayList<>();

		try {
			File restaurantFile = restaurantFile();
			RandomAccessFile file = new RandomAccessFile(restaurantFile , "r");
			
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
	
	private static File cuisineFile() throws FileNotFoundException {
		return ResourceUtils.getFile("classpath:cuisines.csv");
	}
	
	private static File restaurantFile() throws FileNotFoundException {
		return ResourceUtils.getFile("classpath:restaurants.csv");
	}

	public static Map<Integer, Cuisine> loadCuisine() {
		Map<Integer, Cuisine> cuisines = new HashMap<>();
		try {
			File cuisineFile = cuisineFile();
			RandomAccessFile file = new RandomAccessFile(cuisineFile, "r");
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
