package com.problems;

import com.model.Node;

public class ConstructTreeFromPreorder {
	public static int index = 0;

	

	public void displayTree(Node root) {
		if (root != null) {
			displayTree(root.left);
			System.out.print(" " + root.data);
			displayTree(root.right);
		}
	}

	public static void main(String args[]) {
		ConstructTreeFromPreorder p = new ConstructTreeFromPreorder();
		int[] preOrder = { 20, 10, 5, 1, 7, 15, 30, 25, 35, 32, 40 };
		Node root=p.constructTreeFromPreOrder(preOrder,preOrder[index],Integer.MIN_VALUE,Integer.MAX_VALUE);
		System.out.println("Inorder Traversal of Constructed Tree : ");
		p.displayTree(root);
		
		
	}

	
	private Node constructTreeFromPreOrder(int[] preOrder,int data, int min, int max) {
		Node root=null;
		if(index<preOrder.length && min<data && data<max){
			root=new Node(data);
			index++;
			if(index<preOrder.length){
				root.left=constructTreeFromPreOrder(preOrder, preOrder[index], min, data);
				root.right=constructTreeFromPreOrder(preOrder, preOrder[index], data, max);
			}
		}
		return root;
	}
	
}
