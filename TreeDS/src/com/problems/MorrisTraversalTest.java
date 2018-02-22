package com.base;

public class MorrisTraversalTest {

	Node root;

	public MorrisTraversalTest(Node input) {
		root = input;
	}

	public static void main(String[] args) {

		/*
		 * Constructed binary tree is 5 / \ 3 8 / \ / \ 2 4 7 9
		 * 
		 */
		Node inputNode = new Node(5);
		inputNode.right = new Node(8);
		inputNode.right.right = new Node(9);
		inputNode.right.left = new Node(7);
		inputNode.left = new Node(3);
		inputNode.left.right = new Node(4);
		inputNode.left.left = new Node(2);

		MorrisTraversalTest mt = new MorrisTraversalTest(inputNode);
		mt.morisTraversal();

	}

	private void morisTraversal() {

		Node current = root;
		while (current != null) {

			if (current.left == null) {
				System.out.println(current.data);
				current = current.right;
			} else {
				Node checkChain = current.left;
				while (checkChain.right != null && checkChain.right != current) {
					checkChain = checkChain.right;
				}
				if (checkChain.right == current) {
					// chain found
					// break chain and move right
					System.out.println(current.data);
					checkChain.right = null;
					current = current.right;
				} else {
					// no chain
					// create chain and move left
					checkChain.right = current;
					current = current.left;

				}

			}
		}

	}

	/*
	 * Steps: 1). Assign root to current 2). inside loop for current check if
	 * current.right is null print(value) move to right(current=current.right)
	 * else check if current.left is chained with current if want to make it
	 * inorder print(value) remove chain ancestor.right=null move right
	 * current=current.right else if want to make it preorder print(value) find
	 * ancestor of current and ancestor.right<-current move left
	 * current=current.left
	 * 
	 * 
	 * 
	 */

}
