package com.techelevator;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class ItemReader {

	Map<String, List<Items>> vendingMap;
	String[] documentArray;
	double price;

	public void readCSVFile() {
		String document = "";
		String[] documentArray;
		File f = new File("vendingmachine.csv");

		try (Scanner s = new Scanner(f)) {
			while (s.hasNextLine()) {
				document += s.nextLine() + "\n";
			}
		} catch (FileNotFoundException e) {
			System.out.println("Was unable to locate file with name \"vendingmachine.csv\".");

		}

		documentArray = document.split("\n");
		this.documentArray = documentArray;
	}

	public void createMap() {
		Map<String, List<Items>> vendingMap = new LinkedHashMap<>();

		for (String element : documentArray) {

			// Splits each line into an array of length 3 with the first element
			// representing the button (i.e. A1), second element (name of the product), and
			// third element (the price of the item).
			String[] elementArray = element.split("\\|");
			String tempKey = elementArray[0];
			List<Items> tempList = new ArrayList<>();
			price = Double.valueOf(elementArray[2]);

			// If the item's button starts with A, create a chip object
			if (elementArray[0].startsWith("A")) {

				Chips chip = new Chips(price, elementArray[1]);
				for (int i = 0; i < 5; i++) {
					tempList.add(chip);

				}
				vendingMap.put(tempKey, tempList);

				// If the item's button starts with B, create a candy object
			} else if (elementArray[0].startsWith("B")) {

				Candy candy = new Candy(price, elementArray[1]);
				for (int i = 0; i < 5; i++) {
					tempList.add(candy);
				}
				vendingMap.put(tempKey, tempList);

				// If the item's button starts with C, create a drink object
			} else if (elementArray[0].startsWith("C")) {

				Drink drink = new Drink(price, elementArray[1]);
				for (int i = 0; i < 5; i++) {
					tempList.add(drink);
				}
				vendingMap.put(tempKey, tempList);

				// If the item's button starts with D, create a gum object
			} else if (elementArray[0].startsWith("D")) {

				Gum gum = new Gum(price, elementArray[1]);
				for (int i = 0; i < 5; i++) {
					tempList.add(gum);
				}
				vendingMap.put(tempKey, tempList);
			}
		}
		this.vendingMap = vendingMap;
	}

	public void currentInventory() {
		for (Map.Entry<String, List<Items>> entry : vendingMap.entrySet()) {
			String key = entry.getKey();
			List<Items> value = entry.getValue();
			System.out.println(key + value);
		}

	}

//Retrieves the map generated after reading the csv file and the actual creation of the map.
	public Map<String, List<Items>> stockMachine() {
		readCSVFile();
		createMap();
		return vendingMap;
	}
}