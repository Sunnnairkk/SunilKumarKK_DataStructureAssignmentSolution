
package com.greatlearning.ques1;

import java.util.*;

public class SkyScraper {

	//Stacks are used to store the Floor Sizes and Delivery Days
	//And Linked List is used to Construction Floor based on given Conditions
	
	Stack <Integer> floorSizes = new Stack<>();
	Stack <Integer> deliveryDays = new Stack<>();
	
	LinkedList <String> assembleFloors = new LinkedList<>();
	LinkedList <Integer> assembleDays = new LinkedList<>();

	void addToStack(int day, int size) {
		//Add the Elements to Stack
		floorSizes.push(size);
		deliveryDays.push(day);
	}

	void printStack() {
		System.out.println(floorSizes);
		System.out.println(deliveryDays);
	}

	void sortStack() {
		//Sorting the Stack in Descending Order using temporary Stack to distinguish the Construction Floors on Available Days
		
		Stack <Integer> sortedFloors = new Stack<>();
		Stack <Integer> sortedDays = new Stack<>();
		
		while(!floorSizes.isEmpty()) {
			int tempFloor = floorSizes.pop();
			int tempDay = deliveryDays.pop();
			
			while(!sortedFloors.isEmpty() && sortedFloors.peek() > tempFloor) {
				floorSizes.push(sortedFloors.pop());
				deliveryDays.push(sortedDays.pop());
			}
			
			sortedFloors.push(tempFloor);
			sortedDays.push(tempDay);
		}
		
		//replacing the Stacks with sorted temporary Stacks
		floorSizes = sortedFloors;
		deliveryDays = sortedDays;
	}

	void addToLinkList(int day, String floors) {
		//Adding to Linklist based on the Floor Sizes Available on Days
		
		if(!assembleDays.isEmpty() && assembleDays.peekLast() == day) {
			assembleDays.pollLast();
			assembleFloors.pollLast();
		}
		assembleFloors.add(floors);
		assembleDays.add(day);
	}

	void floorAssembly() {
		//Processing the Floor Sizes' availability on Specific Days
		
		sortStack();  //Sorting the Stack in Descending Order
		
		String floors="";
		int delday = 0;		//Delivery Days in Stack
		int floorInDay = 0;	//Maximum Floor Sizes Available on the Day
		int floorSize = 0;

		while (!floorSizes.isEmpty()) {
			//Remove the Peek Elements from Stack
			floorSize = floorSizes.pop();
			delday = deliveryDays.pop();
			
			if (floorInDay == 0 || delday > floorInDay) {
				floors = "";
				floorInDay = delday;
			}
			
			floors += floorSize + " ";  //Combining the Floor Sizes available on the day
			
			//Add to LinkList the Combined Floor Sizes and available day
			addToLinkList(floorInDay, floors);
		}
		//Display the Processed Floor Construction Day wise using Link list
		printFloorConstruction();
	}

	void printFloorConstruction() {
		int day = 1;

		System.out.println("\nThe order of construction is as follows : ");

		while (!assembleDays.isEmpty()) {
			System.out.println("\nDay : " + day);
			if (assembleDays.peekFirst() == day) {
				System.out.println(assembleFloors.pollFirst());
				assembleDays.removeFirst();
			}
			day++;
		}
	}

}
