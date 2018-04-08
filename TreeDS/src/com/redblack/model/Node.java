package com.redblack.model;



public class Node {
    public int key = -1;
    public Color color=Color.BLACK;
    public Node left = nil, right = nil;
	public Node parent;
    public static final Node nil = new Node(-1,null,null,null); 
    Node(int key) {
        this(key,nil,nil,null);
    }
    public Node(int key,Node left,Node right,Node parent) {
        this.key = key;
        this.left=left;
        this.right=right;
        this.parent=parent;
    }
}