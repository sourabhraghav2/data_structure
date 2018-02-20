package com.problems;

import com.base.Node;

public class MaxDiameterTest {

	Node root;

	public MaxDiameterTest(Node node) {
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
		MaxDiameterTest md = new MaxDiameterTest(root);
		md.findMaxDiameter();

	}

	private void findMaxDiameter() {

		int maxDia = findMaxDiameter(root);
		System.out.println("Max dia: " + maxDia);
	}

	private int findMaxDiameter(Node node) {
		int result = 0;
		if (node != null) {

			int lheight = findHeight(node);
			int rheight = findHeight(node);
			int rootDia = lheight + rheight + 1;

			int leftDia = findMaxDiameter(node.left);
			int rightDia = findMaxDiameter(node.right);
			int childDia = Math.max(leftDia, rightDia);
			result = Math.max(childDia, rootDia);

		}
		return result;
	}

	public int findHeight(Node node) {
		int result = 0;
		if (node != null) {

			int max = Math.max(findHeight(node.right), findHeight(node.left));
			result = max + 1;
		}
		return result;
	}
}
