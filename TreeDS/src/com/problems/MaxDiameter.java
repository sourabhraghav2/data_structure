package com.problems;

import com.base.Node;

public class MaxDiameter {

	Node root;
	String padding =" ";
	/* Method to calculate the diameter and return it to main */
	int diameter(Node root,String padding) {
		/* base case if tree is empty */
		if (root == null)
			return 0;

		/* get the height of left and right sub trees */
		int lheight = height(root.left);
		int rheight = height(root.right);

		/* get the diameter of left and right subtrees */
		int ldiameter = diameter(root.left,padding+padding);
		System.out.println(padding+"left diameter for " + root.data + " -> " + ldiameter);
		int rdiameter = diameter(root.right,padding+padding);
		System.out.println(padding+"right diameter for " + root.data + " -> " + rdiameter);
		

		/*
		 * Return max of following three 1) Diameter of left subtree 2) Diameter
		 * of right subtree 3) Height of left subtree + height of right subtree
		 * + 1
		 */
		return lheight + rheight + 1;

	}

	/* A wrapper over diameter(Node root) */
	int diameter() {
		return diameter(root,padding);
	}

	/*
	 * The function Compute the "height" of a tree. Height is the number f nodes
	 * along the longest path from the root node down to the farthest leaf node.
	 */
	static int height(Node node) {
		/* base case tree is empty */
		if (node == null)
			return 0;

		/*
		 * If tree is not empty then height = 1 + max of left height and right
		 * heights
		 */
		return (1 + Math.max(height(node.left), height(node.right)));
	}

	public static void main(String[] args) {
		
		/*
		 * 							1
		 * 						/		\
		 * 					2				3
		 * 				 /	   \
		 * 			  4			  5
		 *         /               \
		 *        8                  3  

		 *         
		 * */						
		
		
		
		

		MaxDiameter tree = new MaxDiameter();
		tree.root = new Node(1);
		tree.root.left = new Node(2);
		tree.root.right = new Node(3);

		tree.root.left.left = new Node(4);
		tree.root.left.right = new Node(5);
		tree.root.left.right.right = new Node(3);
		
		tree.root.left.left.left = new Node(8);
		

		System.out.println("The diameter of given binary tree is : " + tree.diameter());
		
		
		
		
		
	}

}
