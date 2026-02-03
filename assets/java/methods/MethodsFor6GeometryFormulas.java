package methods;

public class MethodsFor6GeometryFormulas{
	
	/*
	 *	Write method definitions for the 6 geometry formulas that are in Module 3. 
	 *	Write comments that label the parts of the method, such as the method header, 
	 *	method body, the return type, the method name and the parameters. 
	 *	In the main method, make call each method twice with different values, 
	 *	and print the return values of the methods.  
	 */
	
	/*
	 * THE MAIN METHOD
	 * public - Access specifier
	 * void - return type
	 * main - method name
	 * () - default input, or call
	 * 
	 * 
	 * 	This will display all the information and provide the variables
	 * 	to solve in the other methods.
	 * 
	 */
	public static void main(String[] args){
		
		// TRIANGLE VARIABLES
		double perimeterTri = perimeterOfTriangle(34, 75, 62);
		double areaTri = areaOfTriangle(34, 75, 62);
		double heightTri = heightOfTriangle(34, 75, 62);
		// Displaying results for Triangle
		System.out.println("Triangle" + "\nPerimeter: " + perimeterTri + "\nArea: " + areaTri + "\nHeight: " + heightTri);
		
		
		// SQAURE VARIABLE
		int perimeterSquare = perimeterOfSquare(33);
		int areaSquare = areaOfSquare(33);
		int volSquare = volumeOfCube(33);
		// Displaying results for Square
		System.out.println("\nSquare" + "\nPerimeter: " + perimeterSquare + "\nareaSquare: " + areaSquare);
		System.out.println("Volume of a cube: " + volSquare);
		
		
		// CYLINDER VARIABLE
		double volCyl = volumeOfCylinder(10.4, 2.1);
		// Displaying results
		System.out.println("\nVolume of Cylinder: " + volCyl);
	}
	
	
	
	/*
	 * THE TRIANGLE EQUATIONS METHOD'S
	 * NEED MULTIPLE SO MAIN METHOD CAN ACTUALLY DISPLAY THEM
	 * public - Access specifier
	 * double - return type
	 * perimeterOfTriangle | areaOfTriangle | heightOfTriangle - method name
	 * (int triSide1, int triSide2, int triSide3) - 3 sides, because... triangle...
	 */
	public static double perimeterOfTriangle(int triSide1, int triSide2, int triSide3) {
		return triSide1 + triSide2 + triSide3;
	}
	
	public static double areaOfTriangle(int triSide1, int triSide2, int triSide3) {
		double perimeter = perimeterOfTriangle(triSide1, triSide2, triSide3);
		double heron = perimeter / 2;
		return Math.sqrt(heron * (heron - triSide1) * ( heron - triSide2 ) * ( heron - triSide3 ));
	}
	
	public static double heightOfTriangle(int triSide1, int triSide2, int triSide3) {
		double area = areaOfTriangle(triSide1, triSide2, triSide3);
		return (2 * area) / triSide1;
	}
	
	
	
	/*
	 * THE SQUARE'S EQUATION'S METHOD'S CONGLOMERATE
	 * NEEDS MULTIPLE SO MAIN METHOD CAN ACTUALLY DISPLAY RESULTS
	 * public - Access specifier
	 * int - return type
	 * perimeterOfSquare | areaOfSquare - method name
	 * (int side) - one side, because it's a square, they are perfectly square. 
	 * 				If it had two sides it would be a rectangle
	 */
	public static int perimeterOfSquare(int side) {
		return side + side + side + side;
	}
	
	public static int areaOfSquare(int side) {
		return side * side;
	}
	
	public static int volumeOfCube(int side) {
		return side * side * side;
	}
	
	
	/*
	 * THE CYLINDER'S METHOD
	 * public - Access specifier
	 * double - return type, what datatype it can return with.
	 * volumeOfCylinder - method name
	 * (double height, double radius) - needed to find volume of a cylinder
	 */
	public static double volumeOfCylinder(double height, double radius) {
		return (3.14 * height * radius);
	}
	
	
}