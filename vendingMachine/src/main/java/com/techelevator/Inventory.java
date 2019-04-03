package com.techelevator;

public class Inventory {

	private int a;
	private int b;
	private int c;
	private int d;

	public void productTypesPurchased(String keyItem) {
		if (keyItem.contains("A")) {
			a = a + 1;
		} else if (keyItem.contains("B")) {
			b = b + 1;
		} else if (keyItem.contains("C")) {
			c = c + 1;
		} else if (keyItem.contains("D")) {
			d = d + 1;
		}
	}

	public void eatIteatIt() {
		if (a > 0) {
			System.out.println("Crunch Crunch, Yum!");
		}

		if (b > 0) {
			System.out.println("Munch Munch, Yum!");
		}

		if (c > 0) {
			System.out.println("Glug Glug, Yum!");
		}

		if (d > 0) {
			System.out.println("Chew Chew, Yum!");
		}

	}

}
