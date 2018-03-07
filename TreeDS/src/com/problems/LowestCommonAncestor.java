package com.problems;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

import com.model.Node;

public class LowestCommonAncestor {

	Node root = null;
	Stack<Node> stack = new Stack<Node>();

	public static void main(String[] args) {

		LowestCommonAncestor id = new LowestCommonAncestor();
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
		
		int result=id.findLCA(10,80);
		System.out.println(result);
		
	}

	private int findLCA(int i, int j) {
		System.out.println("--");
		int result=0;
		List<Node> path1=new ArrayList<>();
		List<Node> path2=new ArrayList<>();
		if(findLCAFor(root,i,path1) &&findLCAFor(root,j,path2)){
			result=findCoexistingNode(path1,path2);	
		}else{
			System.out.println("Not found ");
		}
		
		return result;
		
	}

	
	private int  findCoexistingNode(List<Node> path1, List<Node> path2) {
		int size=path1.size()<path2.size()?path1.size():path2.size();
		Node matchingNode=null;
		for(int i=0;i<size;++i){
			if(path1.get(i).data==path2.get(i).data){
				matchingNode=path1.get(i);	
			}
			
		}
		return matchingNode.data;
		
		
		
	}

	private void printTheList(List<Node> path) {
		
		for(Node node:path){
			System.out.println(node.data);
		}
	
	}

	private boolean findLCAFor(Node node, int searchData, List<Node> path) {

		if (node != null) {

			path.add(node);
			if (node.data == searchData) {
				return true;
			}
			if (node.left != null && findLCAFor(node.left, searchData, path)) {
				return true;
			}
			if (node.right != null && findLCAFor(node.right, searchData, path)) {
				return true;
			}
			path.remove(path.size() - 1);
			return false;
		}

		return false;

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
