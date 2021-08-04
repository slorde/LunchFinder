package com.gabriel.lunchfinder.utils;

public class SearchUtils {

	public static boolean containsString(String input, String search) {
		if (search == null) {
			return true;
		}
		
		return input.toUpperCase().contains(search.toUpperCase());
	}
	
	public static boolean valueGreaterOrEquals(Integer input, Integer search) {
		return input >= search;
	}
	
	public static boolean valueLesserOrEquals(Integer input, Integer search) {
		return input <= search;
	}
}
