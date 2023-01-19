package com.google.code._6_Trees;

public class _42_DiameterOfTree {
	static int diameter = 0;
	public static void main(String[] args) {
		TreeNode<Integer> tNode = new TreeNode<>(1, null, null);
		TreeNode<Integer> tNode1 = new TreeNode<>(10, null, null);
		TreeNode<Integer> tNode2 = new TreeNode<>(20, null, null);
		TreeNode<Integer> tNode3 = new TreeNode<>(30, null, null);
		TreeNode<Integer> tNode4 = new TreeNode<>(40, null, null);

		tNode.left = tNode1;
		tNode.right = tNode2;
		tNode1.left = tNode3;
		tNode2.right = tNode4;

		
		
		System.out.println("Diameter: " + diameter(tNode));
	}
	//Similar to max sum path from leet code, here instead of data, replace it with 1
	private static int diameter(TreeNode<Integer> node) {
		depth(node);
		return diameter;
	}
	
	private static int depth(TreeNode<Integer> node) {
		if(node == null) {
			return 0;
		}
		int leftHt = depth(node.left);
		int rtht = depth(node.right);
		diameter = Math.max(leftHt+rtht+1, diameter);
		return Math.max(leftHt, rtht) + 1;
	}
}
