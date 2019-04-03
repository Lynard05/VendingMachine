package com.techelevator;

import java.util.Scanner;

public class VendingMachineCLI {

	public static void main(String[] args)  {
		ItemReader newReader = new ItemReader();
		newReader.stockMachine();
		Money money = new Money();
		Logger logger = new Logger();
		Inventory inventory = new Inventory();
		
		while(true) {
		Scanner menuOption = new Scanner(System.in);
		System.out.println("\n\nPlease Choose an Option");
		System.out.println("1) Display Available Items");
		System.out.println("2) Purchase");
		System.out.println("3) Load Money");
		System.out.println("4) Finish Transaction");
		try {
		int selection = menuOption.nextInt();
		
		if (selection == 1) {

			newReader.currentInventory();

		} else if (selection == 2) {
			if (money.getBalance() == 0) {
				System.out.println("You need to deposit money before making a purchase");
				System.out.print("Please enter your deposit amount:");
				Scanner initialDeposit = new Scanner(System.in);
				double userDeposit = initialDeposit.nextDouble();
				money.deposit(userDeposit);
				logger.activityStamp("Deposit: $" + userDeposit + " $" + money.getBalance());
				System.out.print("Your current balance is" + " " + money.getBalance());
				newReader.currentInventory();

			
			} else if (money.getBalance() > 0) {
				newReader.currentInventory();
				}
				System.out.print("\n\n" + "Please make a selection:");
				
				try {
				Scanner keySelection = new Scanner(System.in);
				String keyItem = keySelection.next().toUpperCase();
				
				String tester = newReader.vendingMap.get(keyItem).get(0).toString();
				String[] test = tester.split(" ");
				double itemCost = Double.valueOf(test[test.length -1]);
				inventory.productTypesPurchased(keyItem);
				money.purchase(itemCost);
				//Will remove item need to stop item from being removed if balance hasn't changed.
				newReader.vendingMap.get(keyItem).remove(1);
				logger.activityStamp("Purchase: " + tester + " $" + money.getBalance());

				System.out.println("Your remaining balance is " + money.getBalance());
				} catch (Exception keySelection) {
					System.out.println("\n You entered an invalid option. Please try your purchase again");
					
				}
		} else if (selection == 3) {
			System.out.print("Please enter your deposit amount:");
			try {
			Scanner initialDeposit = new Scanner(System.in);
			double userDeposit = initialDeposit.nextDouble();
			money.deposit(userDeposit);
			logger.activityStamp("Deposit: $" + userDeposit + " $" + money.getBalance());
			} catch (Exception userDeposit) {
				System.out.println("\nPlease try your deposit again with a valid dollar amount");
			}
			System.out.print("Your current balance is" + " " + money.getBalance());
			
			
			
		} else if (selection == 4) {
			System.out.println("Your change due is " + money.getBalance());
			money.giveChange();
			inventory.eatIteatIt();
			
			break;
		}
		} catch (Exception IOmismatch) {
			System.out.println("\nPlease enter a valid option");
		}
		
		}
	}
}
