package com.google.code._6_BinaryTrees;

public class _6_Depth {
	public static void main(String[] args) {
		TreeNode<Integer> tNode = new TreeNode<>(10, null, null);
		TreeNode<Integer> tNode1 = new TreeNode<>(20, null, null);
		TreeNode<Integer> tNode2 = new TreeNode<>(70, null, null);
		TreeNode<Integer> tNode3 = new TreeNode<>(40, null, null);
		TreeNode<Integer> tNode4 = new TreeNode<>(50, null, null);
		TreeNode<Integer> tNode5 = new TreeNode<>(60, null, null);
		
		tNode.left = tNode1;
		tNode.right = tNode2;
		tNode1.left = tNode3;
		tNode1.right = tNode4;
		tNode2.left = tNode5;
		
		System.out.println(maxDepth(tNode));
		System.out.println(minDepth(tNode));
	}
	
	public static int maxDepth(TreeNode<Integer> node) {
		if(node == null) {
			return 0;
		}
		int lHeight = maxDepth(node.left);
		int rHeight = maxDepth(node.right);
		return Math.max(lHeight, rHeight) + 1; //Or you can write a one liner
	}
	
	
	
	//Tricky
	public static int minDepth(TreeNode<Integer> node) {
		if(node == null) {
			return 0;
		}
		if(node.left == null)
			return minDepth(node.right) + 1;
		if(node.right == null)
			return maxDepth(node.left) + 1;
		
		return Math.min( minDepth(node.left), minDepth(node.right)) + 1; 
	}
}
