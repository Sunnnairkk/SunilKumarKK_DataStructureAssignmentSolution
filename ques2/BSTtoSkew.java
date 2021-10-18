package com.greatlearning.ques2;

import java.util.Arrays;

class Node {
	//Declare a Node
	int key;
	Node left, right;

	public Node() {
		left = right = null;
	}

	public Node (int data) {
		key = data;
		left = right = null;
	}
}

class Main {
	Node node;
	int[] treeArray;
	int index = 0;

	//Constructor
	Main () {
		node = null;
	}

	int calculateTreeSize(Node node) {
		//Calculate the Size of the Binary Tree
		int size = 0;

		if (node == null) {
			return 0;
		}
		else {
			size = calculateTreeSize(node.left) + calculateTreeSize(node.right) + 1;
		}
		//System.out.println("Size" + size);
		return size;
	}

	void sortArray(int[] arr) {
		Arrays.sort(treeArray);
	}

	void inorderBinarySearchTree(Node node) {
		//traverse from Left Node, Root, Right Node
		if (node == null) {
			return;
		}
		else {
			//traverse left
			inorderBinarySearchTree(node.left);
			//display root node
			System.out.print(node.key + "  ");
			//traverse right node
			inorderBinarySearchTree(node.right);
		}
	}

	void printArray(int[] arr) {
		//print the array created from Binary Tree
		for(int i=0; i< arr.length; i++) {
			System.out.print(arr[i] + "  ");
		}
		System.out.println("\n\n");
	}

	void convertBinaryTreeToArray(Node node) {
		//Convert Binary Tree to Array
		if (node == null) {
			return;
		}
		else {
			//Traverse Left of Tree
			if (node.left != null) {
				convertBinaryTreeToArray(node.left);
			}

			//Root Node	
			treeArray[index] = node.key;
			index++;

			//Traverse Right of Tree
			if(node.right != null) {
				convertBinaryTreeToArray(node.right);
			}
		}
	}

	void arrayToBSTRight() {
		//Array elements sending create the Right Skewed Tree
		node=null;
		for (int i=0; i<treeArray.length; i++) {
			node = createRightSkewed(node, treeArray[i]);
		}
	}

	Node newNode(int data) {
		//Create new node
		Node temp = new Node();
		temp.key = data;
		temp.left = null;
		temp.right = null;

		return temp;
	}

	Node createRightSkewed(Node node, int val) {
		//Create Right Skewed Tree Nodes
		if (node == null) {
			return(new Node(val));
		}

		//no left node for a right skewed tree
		node.left = null;
		node.right = createRightSkewed(node.right, val);

		return node;
	}
}

