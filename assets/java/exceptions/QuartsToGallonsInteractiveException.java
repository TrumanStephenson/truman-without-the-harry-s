package exceptions;

import javax.swing.JOptionPane;

public class QuartsToGallonsInteractiveException {
	
    public static void main(String[] args) {
    	
        int quartsResult = 0;
        boolean validInput = false;

        while (!validInput) {
            try {
                // Creating dialog box
                String quartsInput = JOptionPane.showInputDialog("How many quarts (Whole Numbers Only)");
                quartsResult = Integer.parseInt(quartsInput);
                // Set to true if input is valid to exit the loop
                validInput = true; 
            } catch (NumberFormatException e) {
                // Catching exception for non-numeric input
                JOptionPane.showMessageDialog(null, "Please enter a valid number");
            }
        }

        final int QUARTS_IN_GALLONS = 4;

        // Displaying user input
        System.out.println("Quarts: " + quartsResult);

        // Calculating gallons and remaining quarts
        int quotientGallons = quartsResult / QUARTS_IN_GALLONS;
        int remainderQuarts = quartsResult % QUARTS_IN_GALLONS;

        // Displaying results
        System.out.println("How many gallons used? " + quotientGallons +
                "\nHow many quarts left over? " + remainderQuarts);
    }
}