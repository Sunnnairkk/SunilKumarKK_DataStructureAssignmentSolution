package com.greatlearning.ques1;

import java.util.Scanner;

public class DriverSkyScraper {

	public static void main(String[] args) {

		//SkyScraper Class Declaration;
		SkyScraper skyscraper = new SkyScraper();
		Scanner keyboardInput = new Scanner(System.in);

		System.out.println("Enter the total number of floors in the building");
		
		//User input - Number of Total Floors
		int numberOfFloors = keyboardInput.nextInt();
		int floorSizeEntered = 0;

		//Collect the Floor Sizes on delivery day basis
		for (int i=0; i<numberOfFloors; i++) {
			int entrydays = i+1;  //Day1 to Number of days
			
			System.out.println("enter the floor size given on day " + entrydays );
			
			//Trapping zero and -ve floor Sizes
			do {
				floorSizeEntered = keyboardInput.nextInt();
			} while (floorSizeEntered <= 0);

			//Add the Floor Sizes and Delivery Days to Stacks
			skyscraper.addToStack(entrydays, floorSizeEntered);
		}
		
		//Process the Floor Construction Days and Display
		skyscraper.floorAssembly();
		
		keyboardInput.close();
	}

}
