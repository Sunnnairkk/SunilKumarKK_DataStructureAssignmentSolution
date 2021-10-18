package com.greatlearning.ques2;

public class DriverBinaryTreeToRightSkewTree {

	public static void main(String[] args) {

		//BST Tree Nodes - hard corded as per Question 2 

		Main tree = new Main();
		tree.node = new Node(50);
		tree.node.left = new Node(30);
		tree.node.right = new Node(60);
		tree.node.left.left = new Node(10);
		tree.node.right.left = new Node(40);

		System.out.println("\nBinery Tree\n");
		System.out.println("            50");
		System.out.println("           /   \\");
		System.out.println("         30     60");
		System.out.println("        /       /");
		System.out.println("      10       40\n\n");

		System.out.println("Binary Tree initialised");
		tree.inorderBinarySearchTree(tree.node);

		//Create an Array from Binary Tree
		int arraysize = tree.calculateTreeSize(tree.node);
		tree.treeArray = new int[arraysize];
		tree.convertBinaryTreeToArray(tree.node);

		//Sort the Array in Ascending order
		tree.sortArray(tree.treeArray);
		//tree.printArray(tree.treeArray);

		//Create Right Skewed Tree from the Sorted Array
		tree.arrayToBSTRight();

		System.out.println("\n\nBinary Tree converted to Right Skewed Tree");

		//Display the final Right Skewed Tree
		tree.inorderBinarySearchTree(tree.node);
	}

}
