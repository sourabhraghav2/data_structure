package com.problems;

import java.util.LinkedList;
import java.util.Queue;

import com.model.Node;

public class DiagonalPrint{

	Node root;

	public DiagonalPrint(Node node) {
		root = node;
	}

	public static void main(String[] args) {
		/*
		 * 							1
		 * 						/		\
		 * 					2				7
		 * 				 /	   \
		 * 			  4			  5
		 *         /   \            \
		 *        8     9             3  

		 * 
		 * 
		 */

		Node root = new Node(1);
		root.left = new Node(2);
		root.right = new Node(7);
		root.left.left = new Node(4);
		root.left.right = new Node(5);
		root.left.right.right = new Node(3);
		root.left.left.left = new Node(8);
		root.left.left.right = new Node(9);
		
		DiagonalPrint md = new DiagonalPrint(root);

		md.printDiagonal();

	}

	private void printDiagonal() {

		printDiagonal(root);
		
		
	}

	private void printDiagonal(Node node) {
		

		Queue<Node> queue=new LinkedList<Node>();
		if (node != null ) {
			queue.add(node);
			Node current=null;
			while(!queue.isEmpty() ||current!=null){
				
				if(current!=null){
					System.out.println(current.data);
					if(current.left!=null){
						queue.add(current.left);
					} 
					current=current.right; 
					
				}else{
					current=queue.remove();
				}
				
			}
			
		}
		return ;
	}
	
	
}


