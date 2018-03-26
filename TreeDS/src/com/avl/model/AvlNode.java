package com.avl.model;

public class AvlNode {
	public int data;
	public int height;
	public AvlNode left, right;

	public AvlNode(int d) {
		data = d;
		height = 1;
	}
}
