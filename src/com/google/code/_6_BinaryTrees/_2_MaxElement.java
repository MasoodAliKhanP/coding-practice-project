package com.google.code._6_BinaryTrees;

public class _2_MaxElement {
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
		tNode1.right = tNode4;
		
		System.out.println(maxElement(tNode));
//		System.out.println(height(tNode));
	}
	
	public static int maxElement(TreeNode<Integer> node) {
		if(node == null) {
			return Integer.MIN_VALUE;
		}
		int data = node.data;
		int lData = maxElement(node.left);
		int rData = maxElement(node.right);
		
		return Math.max(data, Math.max(lData, rData));
	}
	
	
}
