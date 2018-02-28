package com.base;

import com.model.Node;

public class InsertionDeletion {
	Node root = null;

	public static void main(String[] args) {

		InsertionDeletion id = new InsertionDeletion();
		id.insertData(50);
		id.insertData(80);
		id.insertData(70);
		id.insertData(90);
		id.insertData(30);
		id.insertData(40);
		id.insertData(20);
		id.insertData(10);
		System.out.println("before");
		id.inorderTraverse();
		id.deleteRec(30);
		System.out.println("after");
		id.inorderTraverse();
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

	public void deleteData(int data) {
		root = delete(root, data);

	}


	
	private Node delete(Node node, int data) {

		if (node != null) {
			if (node.data > data) {
				node.left = delete(node.left, data);
			} else if (node.data < data) {
				node.right = delete(node.right, data);
			} else {
				if (node.right == null) {
					return node.left;
				} else if (node.left == null) {
					return node.right;
				} else {
					int ancestor = findAncestor(node.left);
					
					node.left=delete(node.left, ancestor);
					node.data=ancestor;
				}
			}

		}
		return node;

	}

	int minValue(Node root) {
		int minv = root.data;
		while (root.left != null) {
			minv = root.left.data;
			root = root.left;
		}
		return minv;
	}

	public void deleteRec(int data) {
		root = delete(root, data);
	}

	

	private int findAncestor(Node node) {
		while (node.right != null) {
			node = node.right;
		}
		return node.data;
	}

	public void inorderTraverse() {
		inorder(root);
	}

	private void inorder(Node node) {

		if (node != null) {
			inorder(node.left);
			System.out.println(node.data);
			inorder(node.right);
		}

	}

}
