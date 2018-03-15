package com.problems;

import com.model.Node;

public class ConstructTreeFromInAndPre {


    Node root;
    static int preIndex = 0;
 
    Node buildTree(char in[], char pre[], int inStrt, int inEnd,String padding) 
    {
    	printThis(in,inStrt,inEnd,padding);
    	printThis(pre,inStrt,inEnd,padding);
        if (inStrt > inEnd) 
            return null;
  
 
        Node tNode = new Node(pre[preIndex++]);
  
        if (inStrt == inEnd)
            return tNode;
  
        int inIndex = search(in, inStrt, inEnd, tNode.data);
  
        tNode.left = buildTree(in, pre, inStrt, inIndex - 1,padding+"\t");
        tNode.right = buildTree(in, pre, inIndex + 1, inEnd,padding+"\t");
  
        return tNode;
    }
  
    private void printThis(char[] in, int inStrt, int inEnd, String padding) {
		System.out.print(padding);
    	for(int i=inStrt;i<=inEnd;++i){
			System.out.print(in[i]);
		}
    	System.out.println();
		
	}

	int search(char arr[], int strt, int end, int value) 
    {
        int i;
        for (i = strt; i <= end; i++) 
        {
            if (arr[i] == value)
                return i;
        }
        return i;
    }
  

    void printInorder(Node node) 
    {
        if (node == null)
            return;

        printInorder(node.left);
        System.out.print((char)node.data + " ");
        printInorder(node.right);
    }
  
    public static void main(String args[]) 
    {
    	ConstructTreeFromInAndPre tree = new ConstructTreeFromInAndPre();
        char in[] = new char[]{'D', 'B', 'E', 'A', 'F', 'C'};
        char pre[] = new char[]{'A', 'B', 'D', 'E', 'C', 'F'};
        int len = in.length;
        Node root = tree.buildTree(in, pre, 0, len - 1," ");
        System.out.println("Inorder traversal of constructed tree is : ");
        tree.printInorder(root);
    }
}