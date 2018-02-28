package com.problems;

import com.model.Node;

public class MaxHeight {

	Node root;

	public MaxHeight(Node node) {
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
		MaxHeight md = new MaxHeight(root);
		md.findMaxHeight();
		
	}

	private void findMaxHeight() {

		int maxDia = findMaxHeight(root);
		System.out.println("Max dia: " + maxDia);
	}

	private int findMaxHeight(Node node) {
		int result = 0;
		if (node != null) {

			int rightHeight = findMaxHeight(node.right);
			int leftHeight = findMaxHeight(node.left);

			if (leftHeight > rightHeight) {
				return leftHeight + 1;
			} else {
				return rightHeight + 1;
			}
		}
		return result;
	}

}
