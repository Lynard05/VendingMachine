package com.techelevator;



public class Items {

	private double price;
	private String name;

	public Items(double price, String name) {
		this.name = name;
		this.price = price;
	}

	public double getPrice() {
		return price;
	}

	public String getName() {
		return name;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return name + " " + price;
	}
	
	
	
}
