package com.google.code._6_Trees;

public class _41_MaxSumPath {
	static int maxSumPath = 0;
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

		
		
		System.out.println("maxSumPath: " + maxSumPath(tNode));
	}

	//Similar to max sum path from leet code
	private static int depth(TreeNode<Integer> node) {
		if(node == null) {
			return 0;
		}
		int leftHt = Math.max(depth(node.left),0);
		int rtht = Math.max(depth(node.right), 0);
		maxSumPath = Math.max(leftHt+rtht+node.data, maxSumPath);
		return Math.max(leftHt, rtht) + node.data;
	}
	
	
	private static int maxSumPath(TreeNode<Integer> node) {
		depth(node);
		return maxSumPath;
	}
}
