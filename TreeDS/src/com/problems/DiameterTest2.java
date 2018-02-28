package com.problems;

import com.model.Node;

public class DiameterTest2 {

	Node root;

	public DiameterTest2(Node node) {
		root = node;
	}

	public static void main(String[] args) {

		Node root = new Node(1);
		root.left = new Node(2);
		root.right = new Node(3);
		root.left.left = new Node(4);
		root.left.right = new Node(5);
		root.left.right.right = new Node(3);
		root.left.left.left = new Node(8);
		root.left.left.right = new Node(9);
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
		DiameterTest2 md = new DiameterTest2(root);
		
		md.findMaxDiameter();

	}

	private void findMaxDiameter() {

		int maxDia = findMaxDiameter(root);
		System.out.println("Max dia: " + maxDia);
	}

	private int findMaxDiameter(Node node) {
		int result=0;
		if (node != null) {
			int lHeight=findHeight(node.left);
			int rHeight=findHeight(node.right);
			
			int maxInChild=Math.max(findMaxDiameter(node.right), findMaxDiameter(node.left));
			result=Math.max(maxInChild, lHeight+rHeight+1);
		}
		return result;
	}

	private int findHeight(Node node) {
		int result=0;
		if(node!=null){
			int rHeight=findHeight(node.right);
			int lHeight=findHeight(node.left);
			return Math.max(rHeight, lHeight)+1;
		}
		return result;
	}

}
