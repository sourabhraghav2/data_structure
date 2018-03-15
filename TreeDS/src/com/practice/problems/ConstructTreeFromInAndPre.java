package com.practice.problems;

import com.model.Node;

public class ConstructTreeFromInAndPre {


    Node root;
    static int index = 0;
  
   
    Node buildTree(char in[], char pre[], int inStrt, int inEnd){
    	int current=pre[index++];
    	Node node =new Node(current);
    	if(inStrt==inEnd){
    		return node;
    	}else if(inStrt<inEnd){
    		int location=findLocation(in,current);
    		node.left=buildTree(in,pre,inStrt,location-1);
    		node.left=buildTree(in,pre,location+1,inEnd);	
    	}
    	return node;
    }
  
     private int findLocation(char[] in,int current) {
    	 for(int i=0;i<in.length-1;i++){
    		 if(in[i]==current){
    			 return i;
    		 }
    	 }
		return 0;
	}

	void printInorder(Node node){
        if (node == null)
            return;
  
        printInorder(node.left);
  
        System.out.print(node.data + " ");
  
        printInorder(node.right);
    }
  
    public static void main(String args[]){
    	ConstructTreeFromInAndPre tree = new ConstructTreeFromInAndPre();
        char in[] = new char[]{'D', 'B', 'E', 'A', 'F', 'C'};
        char pre[] = new char[]{'A', 'B', 'D', 'E', 'C', 'F'};
        int len = in.length;
        Node root = tree.buildTree(in, pre, 0, len - 1);
  
        System.out.println("Inorder traversal of constructed tree is : ");
        tree.printInorder(root);
    }
}