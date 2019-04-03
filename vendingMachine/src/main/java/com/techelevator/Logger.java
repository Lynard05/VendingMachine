package com.techelevator;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Logger {

	
	
	
	public void activityStamp(String transactionDetails)  {
		DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
		Date date = new Date();
	
		File transactions = new File("Log.txt");
		PrintWriter log;
		try {
			log = new PrintWriter(new FileWriter(transactions, true));
			log.print("\n" + dateFormat.format(date)+ " " + transactionDetails);
			log.flush();
		} catch (IOException e) {
			System.out.print("Please enter a valid filename");
		}
		
	}
		
}
