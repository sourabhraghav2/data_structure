package com.problems;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

import com.base.Node;

public class LevelTraversal {

	Node root;

	Queue<Node> queue = new LinkedList<>();

	public LevelTraversal(Node root) {
		this.root = root;
	}

	public static void main(String[] args) {

		Node root = new Node(1);
		root.left = new Node(2);
		root.right = new Node(3);
		root.left.left = new Node(4);
		root.left.right = new Node(5);
		root.left.right.right = new Node(3);
		root.left.left.left = new Node(8);
		root.left.left.right = new Node(9);
		/*
		 * 							1
		 * 						/		\
		 * 					2				3
		 * 				 /	   \
		 * 			  4			  5
		 *         /               \
		 *        8                  3  

		 *         
		 * */						
		
		LevelTraversal lt = new LevelTraversal(root);
		lt.levelTraversaL();
	}

	private void levelTraversaL() {

		levelTraversaL(root);

	}

	private void levelTraversaL(Node node) {

		queue.add(node);
		queue.add(null);
		while (!queue.isEmpty()) {

			Node current = queue.peek();
			if (current != null) {
				queue.remove();
				System.out.println(current.data);
				if(current.left!=null) queue.add(current.left);
				if(current.right!=null) queue.add(current.right);

			}else{
				queue.remove();
				System.out.println("*");
				if(queue.peek()!=null){
					queue.add(null);
				}
				
			}
		}

	}

}
