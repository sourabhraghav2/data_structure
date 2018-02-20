package com.base;

public class RecursionTraversal {
	Node root;

	public RecursionTraversal(Node data) {
		root = data;
	}

	void preOrderTraverse() {
		preOrderTraverse(root);
	}

	private void preOrderTraverse(Node root) {

		if (root != null) {
			System.out.println(root.data);
			preOrderTraverse(root.left);
			preOrderTraverse(root.right);

		} else {
			return;
		}
	}

	public static void main(String[] args) {
		Node mid = new Node(5);
		mid.right = new Node(8);
		mid.right.right = new Node(9);
		mid.right.left = new Node(7);
		mid.left = new Node(3);
		mid.left.right = new Node(4);
		mid.left.left = new Node(2);
		RecursionTraversal o = new RecursionTraversal(mid);
		o.preOrderTraverse();

	}
}