package com.gabriel.lunchfinder.data;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.gabriel.lunchfinder.model.Cuisine;
import com.gabriel.lunchfinder.model.Restaurant;

public class DataLoaded {

	public static List<Restaurant> loadRestaurants() {
		List<Restaurant> restaurants = new ArrayList<>();

		String[] lines = restaurantsFile.split("\n");
		for (String line : lines) {
			String[] split = line.split(",");
			String name = split[0];
			Integer rating = Integer.valueOf(split[1]);
			Integer distance = Integer.valueOf(split[2]);
			Integer price = Integer.valueOf(split[3]);
			Integer cuisineID = Integer.valueOf(split[4]);
			
			restaurants.add(new Restaurant(name, rating, distance, price, DataManager.findCuisines(cuisineID)));				
		}
			
		return restaurants;
	}

	public static Map<Integer, Cuisine> loadCuisine() {
		Map<Integer, Cuisine> cuisines = new HashMap<>();
		String[] lines = cousinesFile.split("\n");
		for (String line : lines) {
			String[] split = line.split(",");
			Integer id = Integer.valueOf(split[0]);
			cuisines.put(id, new Cuisine(id, split[1]));			
		}
		
		return cuisines;
	}

	private static String cousinesFile = "1,American\n" + "2,Chinese\n" + "3,Thai\n" + "4,Italian\n" + "5,French\n"
			+ "6,Japanese\n" + "7,Turkish\n" + "8,Korean\n" + "9,Vietnamese\n" + "10,Indian\n" + "11,Spanish\n"
			+ "12,Greek\n" + "13,Mexican\n" + "14,Malaysian\n" + "15,African\n" + "16,German\n" + "17,Indonesian\n"
			+ "18,Russian\n" + "19,Other";

	private static String restaurantsFile = "Deliciousgenix,4,1,10,11\n" + "Herbed Delicious,4,7,20,9\n"
			+ "Deliciousscape,3,7,50,1\n" + "Hideaway Delicious,2,5,40,12\n" + "Cuts Delicious,3,9,25,8\n"
			+ "Lord Delicious,1,7,35,18\n" + "Hilltop Delicious,3,3,45,6\n" + "Fine Delicious,4,5,45,4\n"
			+ "Deliciousish,1,3,50,12\n" + "Havana Delicious,3,1,35,8\n" + "Deliciouspad,3,10,40,13\n"
			+ "Deliciousbea,5,6,50,15\n" + "Deliciousquipo,2,2,10,19\n" + "Fed Delicious,2,9,35,4\n"
			+ "Hotspot Delicious,4,10,25,13\n" + "Gusto Delicious,5,3,50,2\n" + "Deliciouszen,2,6,30,5\n"
			+ "Deliciouszilla,4,1,15,2\n" + "Deliciousio,5,9,40,19\n" + "Local Delicious,5,4,20,12\n"
			+ "Crisp Delicious,5,2,45,18\n" + "Deliciousoryx,1,5,25,2\n" + "Bang Delicious,5,2,15,18\n"
			+ "Deliciouszoid,3,2,30,4\n" + "Hearty ChowClick,2,6,25,8\n" + "Traditional Chow,5,2,15,11\n"
			+ "Bash Chow,2,6,45,9\n" + "Minty Chow,4,8,35,5\n" + "Chowaza,3,9,20,12\n" + "Lucha Chow,3,4,25,14\n"
			+ "Hut Chow,2,2,10,3\n" + "Wish Chow,3,1,40,1\n" + "Chowish,3,8,10,19\n" + "Bazaar Chow,4,4,40,1\n"
			+ "Story Chow,2,10,30,19\n" + "Hideout Chow,2,7,10,15\n" + "Strip Chow,5,9,35,19\n"
			+ "Aroma Chow,5,10,10,18\n" + "Chowology,5,9,30,6\n" + "Chowify,4,4,45,2\n" + "Piece Chow,4,9,10,13\n"
			+ "Cave Chow,3,4,40,6\n" + "Wagon Chow,3,9,10,1\n" + "Choworyx,2,3,40,7\n" + "Whole Chow,2,7,15,4\n"
			+ "Central Chow,3,7,45,1\n" + "Ambrosial Chow,4,5,50,15\n" + "Place Chow,2,2,15,11\n"
			+ "Reservation Table,4,3,20,13\n" + "Chopped Table,1,5,40,3\n" + "Herbed Table,1,1,15,12\n"
			+ "Palate Table,1,1,15,14\n" + "Grove Table,5,2,10,13\n" + "Fodder Table,4,1,20,8\n"
			+ "Tablebes,4,2,40,13\n" + "Chow Table,1,1,10,2\n" + "Bay Table,3,7,50,18\n" + "Tablebea,1,7,25,10\n"
			+ "Fine Table,2,5,15,12\n" + "Cellar Table,4,8,25,8\n" + "Boy Table,3,9,30,13\n" + "Tableomatic,1,5,20,16\n"
			+ "Tableque,4,3,10,4\n" + "Tableio,3,3,40,1\n" + "Tableoont,5,10,20,12\n" + "Tableadora,5,2,25,8\n"
			+ "Tableooze,3,1,50,16\n" + "Garnish Table,4,9,40,4\n" + "Brew Table,2,10,15,8\n"
			+ "Hotspot Table,3,7,40,15\n" + "Fresh Table,3,2,30,1\n" + "Appetite Table,1,10,40,8\n"
			+ "Cave Tasty,5,10,15,18\n" + "Whole Tasty,1,1,30,5\n" + "Tastyio,3,10,30,14\n" + "Lane Tasty,5,5,35,2\n"
			+ "Nouveau Tasty,1,9,50,9\n" + "Relish Tasty,3,8,50,13\n" + "Tastyooze,3,6,20,11\n"
			+ "Binge Tasty,1,8,10,4\n" + "Fed Tasty,3,5,25,2\n" + "Diced Tasty,5,4,40,7\n" + "Tastylux,5,8,35,14\n"
			+ "Tastyaza,3,7,45,18\n" + "Grill Tasty,2,2,30,2\n" + "Tastyopolis,1,6,20,8\n" + "Stand Tasty,4,3,40,16\n"
			+ "Feast Tasty,2,8,20,18\n" + "Baby Tasty,3,1,20,8\n" + "Fodder Tasty,4,4,30,9\n"
			+ "Takeout Tasty,5,5,20,11\n" + "Wrap Tasty,1,10,30,4\n" + "Tastylia,3,4,50,3\n"
			+ "Havana Tasty,4,10,15,11\n" + "Crumb Tasty,2,5,25,11\n" + "Dished Tasty,1,7,25,18\n"
			+ "Chop Grill,5,8,10,17\n" + "Festive Grill,2,4,35,6\n" + "Me Grill,5,5,25,9\n" + "Lounge Grill,3,10,40,5\n"
			+ "Coastal Grill,2,7,10,17\n" + "Perfection Grill,3,3,50,7\n" + "Hungry Grill,3,4,50,9\n"
			+ "Cater Grill,4,3,50,5\n" + "Presto Grill,5,2,40,15\n" + "Crispy Grill,1,7,45,19\n"
			+ "Grilltastic,3,3,30,14\n" + "Grillsio,3,4,15,19\n" + "Tasteful Grill,5,9,10,2\n"
			+ "Yummy Grill,1,8,50,15\n" + "Crisp Grill,2,6,50,19\n" + "Grillya,2,7,40,13\n" + "Cuts Grill,1,7,30,8\n"
			+ "Grillarc,2,3,25,13\n" + "Wish Grill,1,8,30,3\n" + "Dished Grill,3,1,10,8\n" + "Divine Grill,1,9,25,7\n"
			+ "Wedge Grill,2,4,35,2\n" + "Gusto Grill,3,10,10,3\n" + "Chef Grill,5,4,35,19\n"
			+ "Grove Palace,2,4,20,1\n" + "Tasteful Palace,2,3,20,12\n" + "Perfection Palace,3,1,20,3\n"
			+ "Palaceio,4,7,45,14\n" + "Palaceado,3,6,25,4\n" + "Flavor Palace,2,2,20,14\n" + "Palaceadri,4,8,50,11\n"
			+ "Hotspot Palace,1,3,35,3\n" + "Palaceopedia,5,10,25,8\n" + "Gusto Palace,5,10,30,9\n"
			+ "Feed Palace,2,5,20,7\n" + "Smash Palace,1,9,10,1\n" + "Gnaw Palace,1,3,50,13\n"
			+ "Dished Palace,5,7,25,5\n" + "Spicy PalaceClick to check domain availability.,2,6,10,9\n"
			+ "Nouveau Palace,3,8,15,4\n" + "Relish Palace,2,3,40,9\n" + "Palaceistic,2,10,45,9\n"
			+ "Palacearo,1,4,50,4\n" + "Place Palace,5,2,40,17\n" + "Aroma Palace,2,5,40,1\n"
			+ "Fury Palace,5,3,30,17\n" + "Palacex,2,6,15,18\n" + "Palaceocity,1,7,25,15\n"
			+ "Ambrosial Yummy,3,7,50,17\n" + "Nibble Yummy,1,8,15,2\n" + "Accent Yummy,5,3,40,17\n"
			+ "Yummylia,1,1,40,5\n" + "Hotspot Yummy,1,3,45,17\n" + "Chef Yummy,4,9,10,12\n"
			+ "Acclaimed Yummy,5,8,50,8\n" + "Yummyella,2,3,40,6\n" + "Palace Yummy,4,2,50,19\n"
			+ "Sizzle Yummy,3,1,15,18\n" + "Galore Yummy,2,9,40,9\n" + "Yummyquipo,2,3,45,7\n"
			+ "Divine Yummy,1,10,25,13\n" + "Aladdin Yummy,1,4,30,15\n" + "Yummyscape,1,3,35,13\n"
			+ "Yummylance,1,9,10,6\n" + "Crisp Yummy,1,10,25,13\n" + "Cantina Yummy,5,6,20,18\n"
			+ "Cellar Yummy,2,8,50,6\n" + "Festive Yummy,2,2,25,15\n" + "Upscale Yummy,2,10,45,11\n"
			+ "Lucha Yummy,1,10,40,3\n" + "Diced Yummy,5,3,20,14\n" + "Factory Yummy,4,3,15,13\n"
			+ "Dude Kitchen,4,10,35,5\n" + "Kitchengenics,4,3,20,8\n" + "Galore Kitchen,5,10,45,11\n"
			+ "Story Kitchen,5,3,20,15\n" + "Kitchenbia,2,1,30,12\n" + "Fuel Kitchen,4,7,40,2\n"
			+ "Dished Kitchen,5,3,30,14\n" + "Kitchenish,3,2,20,6\n" + "Bang Kitchen,1,1,40,11\n"
			+ "Bit Kitchen,1,1,30,18\n" + "Kitchenlia,2,7,50,1\n" + "Kitchenster,2,1,10,1\n"
			+ "Devine Kitchen,3,9,30,16\n" + "Connoisseur Kitchen,2,6,30,19\n" + "Munchies Kitchen,5,5,45,9\n"
			+ "Fine Kitchen,2,10,20,17\n" + "Crisp Kitchen,1,3,35,2\n" + "Hut Kitchen,3,5,10,17\n"
			+ "Kitchenvio,3,1,50,12\n" + "Kitchenarc,2,5,10,15\n" + "Kitchenry,4,6,40,11\n"
			+ "Safety Kitchen,2,4,20,6\n" + "Smash Kitchen,1,2,50,7\n" + "Brew Kitchen,2,4,40,18\n"
			+ "Connoisseur Bar,2,2,25,17\n" + "Bariva,5,10,40,10\n" + "Barscape,3,4,15,4\n" + "Hot Bar,4,4,20,2\n"
			+ "Place Bar,3,5,50,13\n" + "Grill Bar,1,9,40,5\n" + "Dine Bar,5,10,35,15\n" + "Wave Bar,4,8,20,3";
}
