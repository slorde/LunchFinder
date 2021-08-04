package com.gabriel.lunchfinder.model;

public class Cuisine {
	
	private Integer id;
	private String name;

	public Cuisine(Integer id,String name) {
		this.name = name;
		this.id = id;
	}

	public String getName() {
		return this.name;
	}
	
	public Integer getId() {
		return this.id;
	}
}
