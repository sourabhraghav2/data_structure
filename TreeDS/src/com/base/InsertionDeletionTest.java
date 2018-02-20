package com.base;

public class InsertionDeletionTest {
	Node root = null;

	public static void main(String[] args) {

		InsertionDeletionTest id = new InsertionDeletionTest();
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
		id.deleteRec(20);
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
		if (node == null)
			return null;
		if (node.data < data) {
			node.right = delete(node.right, data);
		} else if (node.data > data) {
			node.left = delete(node.left, data);
		} else {
			if (node.left == null) {

			}
		}
		return null;
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
		root = deleteRec(root, data);
	}

	private Node deleteRec(Node node, int data) {

		if (node != null) {
			// not null check
			if (node.data < data) {
				node.right = deleteRec(node.right, data);
			} else if (node.data > data) {
				node.left = deleteRec(node.left, data);
			} else {
				// if equal

				if (node.left == null) {
					// if left is null then replace with right(single child)
					return node.right;
				} else if (node.right == null) {
					// if right is null then replace with left (single child)
					return node.left;
				} else {
					// double child
					int replaceData = findAncestor(node.left);
					node.left = deleteRec(node.left, replaceData);
				}
			}
		}
		return node;

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
