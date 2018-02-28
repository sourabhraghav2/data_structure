package com.problems;

import com.model.Node;

public class DiameterOptimal{

	Node root;

	public DiameterOptimal(Node node) {
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
		
		DiameterOptimal md = new DiameterOptimal(root);

		md.findMaxDiameter();

	}

	private void findMaxDiameter() {

		Output diaAndHeight = findMaxDiameter(root);
		System.out.println("Max dia: " + diaAndHeight.diameter);
	}

	private Output findMaxDiameter(Node node) {
		Output result = new Output();

		if (node != null) {

			Output rightOutput=findMaxDiameter(node.right);
			Output leftOutput=findMaxDiameter(node.left);
			int maxInChild = Math.max(leftOutput.diameter,rightOutput .diameter);
			result.diameter = Math.max(maxInChild, rightOutput.maxHeight + leftOutput.maxHeight+ 1);
			
			if(rightOutput.maxHeight>leftOutput.maxHeight){
				result.maxHeight=	rightOutput.maxHeight+1;
			}else{
				result.maxHeight=	leftOutput.maxHeight+1;
			}
			
		}
		return result;
	}

}

class Output {
	public Output() {
		diameter = 0;
		maxHeight = 0;
	}

	int diameter;
	int maxHeight;
}
