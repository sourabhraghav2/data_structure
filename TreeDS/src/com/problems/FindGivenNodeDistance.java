package com.problems;

import com.model.Node;

public class FindGivenNodeDistance{

	Node root;

	public FindGivenNodeDistance(Node node) {
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
		
		FindGivenNodeDistance md = new FindGivenNodeDistance(root);

		md.printCurrentNodeDistance(7);

	}

	private void printCurrentNodeDistance(int findDigit) {

		OutPut result=printCurrentNodeDistance(root,findDigit);
		if(result.status){
			System.out.println(result.distance);
		}else{
			System.out.println("node not found");
		}
		
	}

	private OutPut printCurrentNodeDistance(Node node,int findDigit) {
		OutPut result=new OutPut();

		if (node != null ) {
			
			if(node.data==findDigit){
				result.distance=1;
				result.status=true;
			}else{
				OutPut left=printCurrentNodeDistance(node.left,findDigit);
				OutPut right=printCurrentNodeDistance(node.right,findDigit);
				if(left.status){
					result.distance=left.distance+1;
					result.status=true;
				}else if(right.status){
					result.distance=right.distance+1;
					result.status=true;
				}
			}
			
		}
		return result;
	}
	
	private class OutPut{
		boolean status;
		int distance;
		public OutPut(){
			status=false;
			distance=0;	
		}
		
	}

}


