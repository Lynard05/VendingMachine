package com.techelevator;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class VendingMachineCLITest {

	
	

	private Money target;
	
	@Before
	public void setup() {
		target = new Money();
	}
	
	
	@Test
	public void get_current_balance(){
		double result =	target.getBalance();
			
			Assert.assertEquals("0.0", result);
		}
	
	
}
