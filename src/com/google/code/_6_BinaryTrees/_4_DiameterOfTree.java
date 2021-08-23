package com.google.code._6_BinaryTrees;

public class _4_DiameterOfTree {
	static int diameter = 0;
	public static void main(String[] args) {
		TreeNode<Integer> tNode = new TreeNode<>(10, null, null);
		TreeNode<Integer> tNode1 = new TreeNode<>(20, null, null);
		TreeNode<Integer> tNode2 = new TreeNode<>(70, null, null);
		TreeNode<Integer> tNode3 = new TreeNode<>(40, null, null);
		TreeNode<Integer> tNode4 = new TreeNode<>(50, null, null);

		// Case1: balanced
		tNode.left = tNode1;
		tNode.right = tNode2;
		tNode1.left = tNode3;
		tNode2.right = tNode4;

		
		
		System.out.println("Diameter: " + diameter(tNode));
	}

	//Similar to max sum path from leet code
	private static int depth(TreeNode<Integer> node) {
		if(node == null) {
			return 0;
		}
		int leftHt = diameter(node.left);
		int rtht = diameter(node.right);
		diameter = Math.max(leftHt+rtht+1, diameter);
		return Math.max(leftHt, rtht) + 1;
	}
	
	
	private static int diameter(TreeNode<Integer> node) {
		depth(node);
		return diameter;
	}
}
