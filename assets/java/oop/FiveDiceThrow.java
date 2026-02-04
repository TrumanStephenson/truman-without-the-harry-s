package oop;

public class FiveDiceThrow {
	
	public static void main (String[] args) {
		
		// Creating object to FiveDice.java class file
		FiveDice throw1 = new FiveDice();
		int total = throw1.randomGenerator();
		
		if (total == 5 || total == 10 || total == 15 || total == 20 || total == 25 || total == 30) {
			System.out.println("Five of a kind");
		} else if (total % 4 == 0) {
			System.out.println("Four of a kind");
		} else if (total % 3 == 0) {
			System.out.println("Three of a kind");
		} else if (total % 2 == 0) {
			System.out.println("A pair");
		}else {
			System.out.println("No matches");
		}
		
	}
	
}