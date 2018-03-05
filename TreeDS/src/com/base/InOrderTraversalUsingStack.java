package com.base;

import java.util.Stack;

import com.model.Node;

public class InOrderTraversalUsingStack {

	Node root = null;
	Stack<Node> stack = new Stack<Node>();

	public static void main(String[] args) {

		InOrderTraversalUsingStack id = new InOrderTraversalUsingStack();
		id.insertData(50);
		id.insertData(80);
		id.insertData(70);
		id.insertData(90);
		id.insertData(30);
		id.insertData(40);
		id.insertData(20);
		id.insertData(10);
		System.out.println("before");

		id.inOrderTraversal();
		/*						50
		 *					/		 \
		 *				30				80
		 *			/		\		/		\
		 *		20			40	  70		90
		 *	  /
		 *  10
		 * */
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
