package oop;

/*
 * Hold an integer data field for a value (1 to 6).
 * Include a constructor that randomly assigns a value to a die object.
 * 
 * Write a program that randomly "throws" five dice and displays their values as:
 * "Five of a kind"
 * "Four of a kind"
 * "Three of a kind"
 * "A pair"
 * "No matches"
 * 
 * 
 */


public class FiveDice { 
	
	// Creating local class constants
	private static final int HIGHEST_DIE_VALUE = 6;
	private static final int LOWEST_DIE_VALUE = 1;
	
	// This is the method for which the FiveDiceThrow.java can call from
	public int randomGenerator() {
		
		// Creating local variable to establish base value of combined dice
		int total = 0;
		// Creating the equation for loop to solve for the dice throw
		// This will be called in another class file FiveDiceThrow.java
		for (int x = 0; x < 5; x++) {
			int randomValue = (int)(Math.random() * 100) % HIGHEST_DIE_VALUE + LOWEST_DIE_VALUE;
			System.out.println("Die " + (x + 1) + " rolled: " + randomValue);
			total += randomValue;
		}
		return total;
	}
	
}