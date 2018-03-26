package com.avl.base;

import com.avl.model.AvlNode;

public class AvlTree {

	AvlNode node;

	public static void main(String[] args) {
		AvlTree tree = new AvlTree();
		
		 tree.insertNode( 10);
		 tree.insertNode( 20);
	     tree.insertNode( 30);
	     tree.insertNode( 40);
	     tree.insertNode( 50);
	     tree.insertNode( 25);
	 
	        /* The constructed AVL Tree would be
	             30
	            /  \
	          20   40
	         /  \     \
	        10  25    50
	        */
	     System.out.println("Preorder traversal of constructed tree is : ");
	     tree.preOrder(tree.node);

	}

	private void insertNode(int key) {
		node=insertNode(node,key);
	}
	void preOrder(AvlNode AvlNode) {
        if (AvlNode != null) {
            System.out.print(AvlNode.data + " ");
            preOrder(AvlNode.left);
            preOrder(AvlNode.right);
        }
    }
	
	
	private AvlNode insertNode(AvlNode node,int key) {
		if(node==null){
			return new AvlNode(key);
		}else if(node.data<key){
			node.right=insertNode(node.right,key);
		}else if(node.data>key){
			node.left=insertNode(node.left,key);
		}else{
			return node;
		}
		
		node.height=getHeight(node.right)<getHeight(node.left)?getHeight(node.left)+1:getHeight(node.right)+1;
		
		int balanceFactor=getHeight(node.left)-getHeight(node.right);
		if(balanceFactor>1 && key<node.left.data){
			node=rightRotation(node);
		} else if(balanceFactor>1 && key>node.left.data){
			node.left=leftRotation(node.left);
			node=rightRotation(node);
		} else if(balanceFactor<-1 && key<node.right.data){
			node.right=rightRotation(node.right);
			node=leftRotation(node);
		} else if(balanceFactor<-1 && key>node.right.data){
			node=leftRotation(node);
		}
				
		return node;

	}

	private AvlNode leftRotation(AvlNode x) {

		AvlNode y=x.right;
		AvlNode z=y.left;
		
		y.left=x;
		x.right=z;
		
		x.height=getHeight(x.right)<getHeight(x.left)?getHeight(x.left)+1:getHeight(x.right)+1;
		y.height=getHeight(y.right)<getHeight(y.left)?getHeight(y.left)+1:getHeight(y.right)+1;
		
		return y;
		
	}

	private AvlNode rightRotation(AvlNode x) {
		
		AvlNode y=x.left;
		AvlNode z=y.right;
		
		y.right=x;
		x.left=z;
		
		x.height=getHeight(x.right)<getHeight(x.left)?getHeight(x.left)+1:getHeight(x.right)+1;
		y.height=getHeight(y.right)<getHeight(y.left)?getHeight(y.left)+1:getHeight(y.right)+1;

		return y;
	}

	private int getHeight(AvlNode node) {
		if(node!=null){
			return node.height;
		}
		return 0;
	}
}
