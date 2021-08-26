package com.google.code._6_Trees;

// A cord is a string that is broken up and stored in a tree. 
// A cord  tree has two types of node. There is a leaf node which will 
// contain a length field and a data field. There is also an internal node
// which stores a pointer to a left child and a pointer to a right child.
// The internal node stores the  total length of its two children.
class Node{
	int len;
	boolean internal;
	public Node(int len, boolean internal) {
		super();
		this.len = len;
		this.internal = internal;
	}
}

class Internal extends Node{
	Node left;
	Node right;
	public Internal(int len, boolean internal, Node left, Node right) {
		super(len, internal);
		this.left = left;
		this.right = right;
	}
}

class Leaf extends Node{
	String data;

	public Leaf(int len, boolean internal, String data) {
		super(len, internal);
		this.data = data;
	}
	
}


public class _92_Google_CordTree {
	public static void main(String[] args) {
		Node leaf1 = new Leaf(5, false, "ABCDE");
		Node leaf2 = new Leaf(10, false, "FGHIJKLMNO");
		Node leaf3 = new Leaf(11, false, "PQRSTUVWXYZ");
		Node internalRoot2 = new Internal(21, true, leaf2, leaf3);
		Node internalRoot1 = new Internal(26, true, leaf1, internalRoot2);
	
		System.out.println("Nth char: " + nthChar(internalRoot1, 20));
	}
	
	public static Character nthChar(Node node, int n) {
		if(n > node.len) {
			return null;
		}
		
		if(!node.internal) {
			return ((Leaf)node).data.charAt(n);
		}
		
		if(n > ((Internal)node).left.len) {
			return nthChar(((Internal)node).right, n - ((Internal)node).left.len);
		}else {
			return nthChar(((Internal)node).left, n);
		}
	}
	

	
}
