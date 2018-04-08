package com.redblack.base;

import com.redblack.model.Color;
import com.redblack.model.Node;

public class RedBlackTree {

	public static final Node nil = new Node(-1, null, null, null);
	private Node root = null;

	public void printTree() {
		printTree(root);
	}

	public void printTree(Node node) {
		System.out.println("\nInorder");
		inOrder(node);
		System.out.println("\nPreOrder");
		preOrder(node);
	}

	public void run() {

		/*	Expected Traversal: 
			Inorder
			3 4 5 7 12 14 15 16 17 18 
			PreOrder
			14 7 4 3 5 12 16 15 18 17 
		*/
		int[] a = { 4, 7, 12, 15, 3, 5, 14, 18, 16, 17 };
		for (int i : a) {
			System.out.print("\n-> " + i + " ");

			root = insert(root, i, null);
			fixMe(newNode);
			printTree();
			System.out.println("\n--------------------------------------------------");
		}

		printTree(root);
	}

	private void fixMe(Node node) {

		if (node.parent != nil && node.parent != null) {
			while (node.parent.color == Color.RED) {
				System.out.println("Fix needed");
				// findOut uncle
				Node uncle = null;
				if (node.parent == node.parent.parent.left) {
					// uncle is at right and father is at left side
					uncle = node.parent.parent.right;
					// check color of uncle
					if (uncle.color == Color.RED) {
						// flip the colors
						uncle.color = Color.BLACK;
						node.parent.color = Color.BLACK;
						node.parent.parent.color = Color.RED;
						//correct grand parent now
						node = node.parent.parent;
					} else {
						if (node == node.parent.right) {
							// child is at right
							node = node.parent;
							rotateLeft(node);
						}
						node.parent.color = Color.BLACK;
						node.parent.parent.color = Color.RED;
						rotateRight(node.parent.parent);
					}
				} else {
					// uncle is at left and father is at right side
					uncle = node.parent.parent.left;
					// check color of uncle
					if (uncle.color == Color.RED) {
						// flip the colors
						uncle.color = Color.BLACK;
						node.parent.color = Color.BLACK;
						node.parent.parent.color = Color.RED;
						//correct grand parent now
						node = node.parent.parent;
					} else {
						if (node == node.parent.left) {
							// child is at left
							node = node.parent;
							rotateRight(node);
						}
						node.parent.color = Color.BLACK;
						node.parent.parent.color = Color.RED;
						rotateLeft(node.parent.parent);
					}
				}
			}
			root.color = Color.BLACK;
		}
	}

	void rotateLeft(Node node) {
		if (node.parent != nil && node.parent != null) {
			if (node == node.parent.left) {
				node.parent.left = node.right;
			} else {
				node.parent.right = node.right;
			}
			node.right.parent = node.parent;
			node.parent = node.right;
			if (node.right.left != nil) {
				node.right.left.parent = node;
			}
			node.right = node.right.left;
			node.parent.left = node;
		} else {// Need to rotate root
			Node right = root.right;
			root.right = right.left;
			right.left.parent = root;
			root.parent = right;
			right.left = root;
			right.parent = nil;
			root = right;
		}
	}

	void rotateRight(Node node) {
		if (node.parent != nil && node.parent != null) {
			if (node == node.parent.left) {
				node.parent.left = node.left;
			} else {
				node.parent.right = node.left;
			}

			node.left.parent = node.parent;
			node.parent = node.left;
			if (node.left.right != nil) {
				node.left.right.parent = node;
			}
			node.left = node.left.right;
			node.parent.right = node;
		} else {// Need to rotate root
			Node left = root.left;
			root.left = root.left.right;
			left.right.parent = root;
			root.parent = left;
			left.right = root;
			left.parent = nil;
			root = left;
		}
	}

	private void preOrder(Node node) {

		if (node == nil) {
			return;
		}
		System.out.print(node.key + " ");
		preOrder(node.left);
		preOrder(node.right);
	}

	public void inOrder(Node node) {
		if (node == nil) {
			return;
		}
		inOrder(node.left);
		System.out.print(node.key + " ");
		inOrder(node.right);
	}

	Node newNode = null;

	private Node insert(Node node, int key, Node parent) {
		if (node == null) {
			newNode = new Node(key, nil, nil, parent);
			return newNode;
		}
		if ((node.left == null && node.right == null)) {
			newNode = new Node(key, nil, nil, parent);
			newNode.color = Color.RED;
			node = newNode;
		} else {
			if (key < node.key) {
				node.left = insert(node.left, key, node);
			} else {
				node.right = insert(node.right, key, node);
			}
		}

		return node;
	}

	public static void main(String[] args) {

		RedBlackTree tree = new RedBlackTree();
		tree.run();

	}
}
