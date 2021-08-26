package com.google.code._6_Trees;

public class _9_RootToLeaf {
	public static void main(String[] args) {
		TreeNode<Integer> tNode = new TreeNode<>(1, null, null);
		TreeNode<Integer> tNode1 = new TreeNode<>(10, null, null);
		TreeNode<Integer> tNode2 = new TreeNode<>(20, null, null);
		TreeNode<Integer> tNode3 = new TreeNode<>(30, null, null);
		TreeNode<Integer> tNode4 = new TreeNode<>(40, null, null);
		TreeNode<Integer> tNode5 = new TreeNode<>(50, null, null);
		
		tNode.left = tNode1;
		tNode.right = tNode2;
		tNode1.left = tNode3;
		tNode1.right = tNode4;
		tNode2.left = tNode5;
		
		System.out.println("Max sum path: " + maxSumPath(tNode));
		System.out.println("Has sum path: " + hasPathSum(tNode, 51));

	}
	
	public static int maxSumPath(TreeNode<Integer> node) {
		if(node == null) {
			return 0;
		}
		int lSum = maxSumPath(node.left);
		int rSum = maxSumPath(node.right);
		
		
		return Math.max(lSum, rSum) + node.data; 
	}
	
	public static boolean hasPathSum(TreeNode<Integer> node, int sum) {
		if(node == null) {
			return false;
		}
		if(node.left == null && node.right == null && node.data - sum == 0) {
			return true;
		}
		return hasPathSum(node.left, sum - node.data) || hasPathSum(node.right, sum - node.data);
	}
	
}
