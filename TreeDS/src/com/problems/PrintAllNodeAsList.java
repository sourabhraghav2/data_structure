package com.problems;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

import com.model.Node;

public class PrintAllNodeAsList {
	Node root;
	

	
	Stack<Node> stack = new Stack<Node>();

	public static void main(String[] args) {

		PrintAllNodeAsList id = new PrintAllNodeAsList();
		id.insertData(50);
		id.insertData(80);
		id.insertData(70);
		id.insertData(90);
		id.insertData(30);
		id.insertData(40);
		id.insertData(20);
		id.insertData(10);
		System.out.println("before");

//		id.inOrderTraversal();
		/*						50
		 *					/		 \
		 *				30				80
		 *			/		\		/		\
		 *		20			40	  70		90
		 *	  /
		 *  10
		 * */
		
		id.findLCA();
		
		
	}


	private void findLCA() {
		ArrayList <Node> list=new ArrayList<>(); 
		findLCA(root,list) ;
		
	}


	private void findLCA(Node node,ArrayList<Node> list) {
		if(node!=null){
			list.add(node);
			
			if(node.right ==null&& node.left==null){
				printList(list);
			}
			findLCA(node.left,list);
			findLCA(node.right,list);
			list.remove(list.size()-1);
			
		}
		
	}


	private void printList(ArrayList<Node> list) {
		System.out.println("---------------"); 
		for(Node node:list){
			System.out.print(" "+node.data);
		}
		System.out.println("\n---------------");
	}


	private void inOrderTraversal() {

		inOrderTraversal(root);
	}


	

	

	private void inOrderTraversal(Node root) {

		if(root!=null){
			while(root!=null){
				stack.push(root);
				root=root.left;
			}
			while(!stack.isEmpty()){
				Node current=stack.pop();
				System.out.println(current.data);
				if(current.right!=null){
					current=current.right;
					while(current!=null){
						stack.push(current);
						current=current.left;
					}
				}
				
			}
		}
		
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



}
