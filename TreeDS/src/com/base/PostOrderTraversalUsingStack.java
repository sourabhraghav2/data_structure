package com.base;

import java.util.Stack;

import com.model.Node;

public class PostOrderTraversalUsingStack {

	Node root = null;
	Stack<Node> stack = new Stack<Node>();

	public static void main(String[] args) {

		PostOrderTraversalUsingStack id = new PostOrderTraversalUsingStack();
		id.insertData(50);
		id.insertData(80);
		id.insertData(70);
		id.insertData(90);
		id.insertData(30);
		id.insertData(40);
		id.insertData(20);
		id.insertData(10);
		System.out.println("before");

		id.postOrderTraversal();
	}

	private void postOrderTraversal() {

		postOrderTraversal(root);
	}

	private void postOrderTraversal(Node node) {

		if (node != null) {
			stack.push(node);
			Node prev = null;
			while (!stack.isEmpty()) {
				Node current = stack.peek();
				if (current.right == prev) {
					prev = stack.pop();
					System.out.println(prev.data);
				} else if (current.left == prev) {
					if (current.right != null) {
						stack.push(current.right);
					} else {
						prev = stack.pop();
						System.out.println(prev.data);
					}
				} else {
					if (current.left != null) {
						stack.push(current.left);
					} else {
						prev = stack.pop();
						System.out.println(prev.data);
					}
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
