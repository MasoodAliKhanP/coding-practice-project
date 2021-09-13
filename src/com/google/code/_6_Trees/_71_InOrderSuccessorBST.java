package com.google.code._6_Trees;

public class _71_InOrderSuccessorBST {
	 public  TreeNode<Integer> inorderSuccessor(TreeNode<Integer> root, TreeNode<Integer> p) {
	       if(root == null)
	           return null;
	        TreeNode<Integer> successor = null;
	        while(root != null){
	            if(p.data < root.data){
	                successor = root;
	                root = root.left;
	            }else{
	                root = root.right;
	            }
	        }
	        return successor;
	    }	
}
