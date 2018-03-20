package com.problems;

import com.model.Node;

public class PrintNodeAtKDistance{

	Node root;

	public PrintNodeAtKDistance(Node node) {
		root = node;
	}

	public static void main(String[] args) {
		/*
		 * 							1
		 * 						/		\
		 * 					2				3
		 * 				 /	   \
		 * 			  4			  5
		 *         /   \            \
		 *        8     9             3  

		 * 
		 * 
		 */

		Node root = new Node(1);
		root.left = new Node(2);
		root.right = new Node(3);
		root.left.left = new Node(4);
		root.left.right = new Node(5);
		root.left.right.right = new Node(3);
		root.left.left.left = new Node(8);
		root.left.left.right = new Node(9);
		
		PrintNodeAtKDistance md = new PrintNodeAtKDistance(root);

		md.printAtKDistance(2);

	}

	private void printAtKDistance(int distance) {

		printAtKDistance(root,distance);
		
	}

	private void printAtKDistance(Node node,int distance) {
		

		if (node != null && distance>=0) {
			
			if(distance==0){
				System.out.println(node.data);
			}else{
				printAtKDistance(node.left,distance-1);
				printAtKDistance(node.right,distance-1);	
			}
			
		}
		return ;
	}

}

