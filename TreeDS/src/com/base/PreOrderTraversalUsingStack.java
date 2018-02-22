package com.base;

import java.util.Stack;

import com.model.Node;

public class PreOrderTraversalUsingStack {

	Node root = null;
	Stack<Node> stack = new Stack<Node>();

	public static void main(String[] args) {

		PreOrderTraversalUsingStack id = new PreOrderTraversalUsingStack();
		id.insertData(50);
		id.insertData(80);
		id.insertData(70);
		id.insertData(90);
		id.insertData(30);
		id.insertData(40);
		id.insertData(20);
		id.insertData(10);
		System.out.println("before");

		id.preOrderTraversal();
	}

	private void preOrderTraversal() {

		preOrderTraversal(root);
		System.out.println("\n");
		iterativePreorder(root);
	}

	void iterativePreorder(Node node) {

		// Base Case
		if (node == null) {
			return;
		}

		// Create an empty stack and push root to it
		Stack<Node> nodeStack = new Stack<Node>();
		nodeStack.push(root);

		/*
		 * Pop all items one by one. Do following for every popped item a) print
		 * it b) push its right child c) push its left child Note that right
		 * child is pushed first so that left is processed first
		 */
		while (nodeStack.empty() == false) {
			
			// Pop the top item from stack and print it
			Node mynode = nodeStack.peek();
			System.out.print(mynode.data + " ");
			nodeStack.pop();

			// Push right and left children of the popped node to stack
			if (mynode.right != null) {
				nodeStack.push(mynode.right);
			}
			if (mynode.left != null) {
				nodeStack.push(mynode.left);
			}
		}
	}

	private void preOrderTraversal(Node node) {

		if (node != null) {
			stack.push(node);
			while (!stack.isEmpty()) {
				Node current = stack.peek();
				System.out.println(current.data);
				stack.pop();
				if (current.right != null) {
					stack.push(current.right);
				}
				if (current.left != null) {
					stack.push(current.left);
				}  

			}

		}

	}

	public void insertData(int data) {
		root = insert(root, data);
	}

	private Node insert(Node node, int data) {

		if (node != null) {
			if (data > node.data) {
				node.right = insert(node.right, data);
			} else {
				node.left = insert(node.left, data);
			}
			return node;
		} else {
			return new Node(data);
		}
	}

}
