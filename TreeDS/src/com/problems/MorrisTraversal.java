package com.base;

public class MorrisTraversal {

	Node root;

	public MorrisTraversal(Node input) {
		root = input;
	}

	public static void main(String[] args) {
		
		
		/* Constructed binary tree is
		        5
		     /     \
		   3         8
		 /   \     /   \
		2     4   7     9
   
 */
		Node inputNode = new Node(5);
		inputNode.right = new Node(8);
		inputNode.right.right = new Node(9);
		inputNode.right.left = new Node(7);
		inputNode.left = new Node(3);
		inputNode.left.right = new Node(4);
		inputNode.left.left = new Node(2);

		MorrisTraversal mt = new MorrisTraversal(inputNode);
		mt.morisTraversal();


	}
	
	
/*Steps:
 * 1). Assign root to current
 * 2). inside loop for current
 * 		check if current.right is null
 * 			print(value)
 * 			move to right(current=current.right)
 * 		else
 * 			check if current.left is chained with current
 * 				if want to make it inorder  print(value) 
 * 				remove chain  	ancestor.right=null 
 * 				move right   current=current.right
 * 			else
 * 				if want to make it preorder  print(value)
 * 				find ancestor of current and ancestor.right<-current
 * 				move left current=current.left
 * 				
 * 
 * 
 * */
	
	private void morisTraversal() {
		Node current = root;
		while (current != null) {
			//first move toward left untill find any null 
			if (current.left == null) {
				//got null now print value and start moving toward right
				System.out.print(current.data);
				current = current.right;
			} else {
				//find ancestor or chain
				Node findAncestor = current.left;
				while (findAncestor.right != null && findAncestor.right != current) {
					findAncestor = findAncestor.right;
				}
				
				if(findAncestor.right==current){
					//if chain then break chain and move right
//					System.out.print(current.data);
					findAncestor.right=null;
					current=current.right;
				}else{
					//if no chain then connect to ancestor and move left
					System.out.print(current.data);
					findAncestor.right=current;
					current=current.left;
				}

			}

		}

	}
}
