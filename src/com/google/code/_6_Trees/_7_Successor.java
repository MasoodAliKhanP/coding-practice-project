package com.google.code._6_Trees;

import java.util.ArrayList;
import java.util.List;

public class _7_Successor {
	public static void main(String[] args) {
		TreeNode<Integer> tNode = new TreeNode<>(20, null, null);
		TreeNode<Integer> tNode1 = new TreeNode<>(8, null, null);
		TreeNode<Integer> tNode2 = new TreeNode<>(22, null, null);
		TreeNode<Integer> tNode3 = new TreeNode<>(4, null, null);
		TreeNode<Integer> tNode4 = new TreeNode<>(12, null, null);
		TreeNode<Integer> tNode5 = new TreeNode<>(10, null, null);
		TreeNode<Integer> tNode6 = new TreeNode<>(14, null, null);


		tNode.left = tNode1;
		tNode.right = tNode2;
		tNode1.left = tNode3;
		tNode1.right = tNode4;
		tNode4.left = tNode5;
		tNode4.right = tNode6;
		
//		InSuccessor(tNode, tNode1);
//		System.out.println();
		
		inorderSuccessor(tNode, tNode6);
		System.out.println("Successor: " + successor.data);
		
		
		System.out.println("Successor: " + inorderSuccessor2(tNode, tNode6).data);
	}
	
	
	//Solution 1 for Binary Tree or Binary Search Tree
	// Take O(n) time and O(n) space
	static TreeNode<Integer> successor = null;
    
    private static void InSuccessor(TreeNode<Integer> node, TreeNode<Integer> searchNode) {
		List<TreeNode<Integer>> list = new ArrayList<>();
		SuccessorUtil(node, list);
		
		
		for(int i = 0; i <= list.size() -2; i++) {
			if(searchNode == list.get(i)) {
				successor = list.get(i+1);
			}
		}
	}
	
	private static  void SuccessorUtil(TreeNode<Integer> node, List<TreeNode<Integer>> list){
		if(node != null) {
			SuccessorUtil(node.left, list);
			list.add(node);
			SuccessorUtil(node.right, list);
		}
	}
	
	//For Binary Tree not (BST), Take O(n) time and O(n) space, not a good solution
    public static TreeNode<Integer> inorderSuccessor(TreeNode<Integer> root, TreeNode<Integer> p) {
        InSuccessor(root, p);
        return successor;
    }	
	
    
    
	//Solution 2
    //Take O(n) time 
    //If p.right is not null move to left of p.right
    //Else do inorder and track previous 
    public static TreeNode<Integer> inorderSuccessor2(TreeNode<Integer> root, TreeNode<Integer> p) {
        if(p.right != null) {
        	TreeNode<Integer> temp = p.right;
        	while(temp.left != null) {
        		temp = temp.left;
        	}
        	successor = temp;
        	return successor;
        }else {
        	inOrderUtil(root, p);
        	return successor;
        }
    }	
    
    private static TreeNode<Integer> prev = null;
    private static void inOrderUtil(TreeNode<Integer> root, TreeNode<Integer> p) {
    	if(root == null)
    		return ;
    	
    	inOrderUtil(root.left, p);
    	if(prev == p && successor == null) {
    		successor = root;
    		return;
    	}
    	prev = root;
    	inOrderUtil(root.right, p);
    }
    
    //Solution 3 for BST O(n) when tree is skewed, and O(log n) in case of Balanced BST
    public static TreeNode<Integer> inorderSuccessorBST(TreeNode<Integer> root, TreeNode<Integer> p) {
        
    	
    	return null;
    }	
    
    
	
}
