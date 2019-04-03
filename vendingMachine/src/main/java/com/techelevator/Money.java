package com.techelevator;

public class Money extends VendingMachineCLI{

	private double balance;

	public double deposit(double deposit) {
		return balance = balance + deposit;
	}

	public double purchase(double itemPrice) {
		if (itemPrice < balance) {
			balance = balance - itemPrice;
			
		}
		return balance;

	}

	public double getBalance() {
		return balance;
	}

	public void giveChange() {
		int dollars = (int) balance;
		int quarters = (dollars * 4);
		int dimes = 0;
		int nickels = 0;

		double remainingChange = balance - dollars;
		

		while (remainingChange >= 0.25) {
			remainingChange = remainingChange - 0.25;
			quarters = quarters + 1;
			
		}

		while (remainingChange >= 0.10) {
			remainingChange = remainingChange - 0.10;
			dimes = dimes + 1;
		}

		while (remainingChange >= .05) {
			remainingChange = remainingChange - 0.05;
			nickels = nickels + 1;
		}

		System.out.println(quarters + " quarter(s), " + dimes + " dime(s) and " + nickels + " nickel(s)");

	}

}
