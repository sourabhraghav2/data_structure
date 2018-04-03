package com.redblack.model;



public class RedBlackNode
{    
    public RedBlackNode left;
    public RedBlackNode right;
    public int element;
    public int color;

    /* Constructor */
    public RedBlackNode(int theElement)
    {
        this( theElement, null, null );
    } 
    /* Constructor */
    public RedBlackNode(int theElement, RedBlackNode lt, RedBlackNode rt)
    {
        left = lt;
        right = rt;
        element = theElement;
        color = 1;
    }    
}
