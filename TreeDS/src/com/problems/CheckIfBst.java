package com.problems;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

import com.model.Node;

public class CheckIfBst {


	public static void main(String[] args) {

		Node root = new Node(6);
		root.right= new Node(8);
		root.left= new Node(3);
		root.left.left= new Node(2);
		root.left.right= new Node(4);
		root.left.right.right= new Node(5);
		root.left.left.left= new Node(1);
		
		/*
		 * 							6
		 * 						/		\
		 * 					3				8
		 * 				 /	   \
		 * 			  2			  4
		 *         /               \
		 *        1                  5  

		 * 
		 * 
		 */

		CheckIfBst lt = new CheckIfBst();
		lt.checkIfBst(root);
	}

	private void checkIfBst(Node root) {

		boolean result=checkIfBst(root,Integer.MIN_VALUE,Integer.MAX_VALUE);
		System.out.println(result);
	}

	private boolean checkIfBst(Node node, int min, int max) {
		
		if(node!=null && node.data>=min && node .data<=max){
			boolean left=true,right=true;
			if(node.left!=null){
				left=checkIfBst(node.left,min,node.data-1);
			}
			if(node.right!=null){
				right=checkIfBst(node.right,node.data+1,max);
			}
			if(left&& right){
				return true;
			}else{
				return false;
			}
				
			
		}
		
		return false;
	}

	
}
