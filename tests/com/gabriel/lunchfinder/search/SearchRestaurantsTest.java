package com.gabriel.lunchfinder.search;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import org.junit.jupiter.api.Test;

import com.gabriel.lunchfinder.model.Restaurant;

class SearchRestaurantsTest {

	@Test
	void notExist() {
		List<Restaurant> search = new SearchRestaurants().search("not exist", 1, 10, 50, "");

		assertTrue(search.isEmpty(), "Restaurant list should be empty for not existing parameters");
	}

	@Test
	void shouldExist() {
		List<Restaurant> search = new SearchRestaurants().search("Delicious", 1, 3, 50, "Greek");

		assertFalse(search.isEmpty(), "Restaurant list should not be empty");
	}

	@Test
	void shouldSearchARestaurantWithAllParameters() {
		List<Restaurant> search = new SearchRestaurants().search("Delicious", 1, 3, 50, "Greek");
		assertEquals(1, search.size(), "Number of restaurants found");
		assertEquals(search.get(0).toString(), "Deliciousish - rate: 1 - distance: 3 - price: 50 - Greek");
	}

	@Test
	void shouldReturnOnlyFiveResults() {
		List<Restaurant> search = new SearchRestaurants().search("Delicious", 1, 10, 50, "");
		assertEquals(5, search.size(), "Number of restaurants searched");
		assertEquals(search.get(0).toString(), "Deliciousgenix - rate: 4 - distance: 1 - price: 10 - Spanish");
		assertEquals(search.get(1).toString(), "Deliciouszilla - rate: 4 - distance: 1 - price: 15 - Chinese");
		assertEquals(search.get(2).toString(), "Havana Delicious - rate: 3 - distance: 1 - price: 35 - Korean");
		assertEquals(search.get(3).toString(), "Bang Delicious - rate: 5 - distance: 2 - price: 15 - Russian");
		assertEquals(search.get(4).toString(), "Crisp Delicious - rate: 5 - distance: 2 - price: 45 - Russian");
	}

	@Test
	void shouldFilterThreeRestaurant() {
		List<Restaurant> search = new SearchRestaurants().search("Table", 5, 10, 50, "");

		List<String> expectedResult = Arrays.asList("Grove Table - rate: 5 - distance: 2 - price: 10 - Mexican",
				"Tableadora - rate: 5 - distance: 2 - price: 25 - Korean",
				"Tableoont - rate: 5 - distance: 10 - price: 20 - Greek");
		
		assertRestaurantsData(search, expectedResult);
	}

	@Test
	void shouldFilterDistance1() {
		List<Restaurant> search = new SearchRestaurants().search("", 1, 1, 50, "");

		List<String> expectedResult = Arrays.asList("Deliciousgenix - rate: 4 - distance: 1 - price: 10 - Spanish",
				"Deliciouszilla - rate: 4 - distance: 1 - price: 15 - Chinese",
				"Fodder Table - rate: 4 - distance: 1 - price: 20 - Korean",
				"Dished Grill - rate: 3 - distance: 1 - price: 10 - Korean",
				"Sizzle Yummy - rate: 3 - distance: 1 - price: 15 - Russian");

		assertRestaurantsData(search, expectedResult);
	}

	@Test
	void shouldFilterPrice10() {
		List<Restaurant> search = new SearchRestaurants().search("", 1, 10, 10, "");

		List<String> expectedResult = Arrays.asList("Deliciousgenix - rate: 4 - distance: 1 - price: 10 - Spanish",
				"Dished Grill - rate: 3 - distance: 1 - price: 10 - Korean",
				"Kitchenster - rate: 2 - distance: 1 - price: 10 - American",
				"Chow Table - rate: 1 - distance: 1 - price: 10 - Chinese",
				"Grove Table - rate: 5 - distance: 2 - price: 10 - Mexican");
		assertRestaurantsData(search, expectedResult);
	}

	@Test
	void shouldFilterPartialCuisineName() {
		List<Restaurant> search = new SearchRestaurants().search("", 1, 10, 50, "VIET");

		List<String> expectedResult = Arrays.asList("Relish Palace - rate: 2 - distance: 3 - price: 40 - Vietnamese",
				"Fodder Tasty - rate: 4 - distance: 4 - price: 30 - Vietnamese",
				"Hungry Grill - rate: 3 - distance: 4 - price: 50 - Vietnamese",
				"Me Grill - rate: 5 - distance: 5 - price: 25 - Vietnamese",
				"Munchies Kitchen - rate: 5 - distance: 5 - price: 45 - Vietnamese");

		assertRestaurantsData(search, expectedResult);
	}

	private void assertRestaurantsData(List<Restaurant> restaurants, List<String> expectedResult) {
		List<String> restaurantStringList = restaurants.stream().map(restaurant -> restaurant.toString())
				.collect(Collectors.toList());
		assertEquals(restaurantStringList, expectedResult);
	}
}
