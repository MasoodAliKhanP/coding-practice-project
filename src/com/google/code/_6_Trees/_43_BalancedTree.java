package com.google.code._6_Trees;

public class _43_BalancedTree {
	public static void main(String[] args) {
		TreeNode<Integer> tNode = new TreeNode<>(1, null, null);
		TreeNode<Integer> tNode1 = new TreeNode<>(10, null, null);
		TreeNode<Integer> tNode2 = new TreeNode<>(20, null, null);
		TreeNode<Integer> tNode3 = new TreeNode<>(30, null, null);
		TreeNode<Integer> tNode4 = new TreeNode<>(40, null, null);
		TreeNode<Integer> tNode5 = new TreeNode<>(50, null, null);

		// Case1: balanced
		tNode.left = tNode1;
		tNode.right = tNode2;
		tNode2.left = tNode3;
		tNode2.right = tNode4;
		
		// Case2: not balanced
//		tNode.left = tNode1;
//		tNode1.left = tNode2;
//		tNode2.left = tNode3;
//		tNode.right = tNode4;
//		tNode4.left = tNode5;

		System.out.println("isBalanced: " + isBalancedTree(tNode));
	}

	static boolean isBalanced = true;
	
	public static int depth2(TreeNode<Integer>root) {
		if (root == null || !isBalanced) {
			return 0;
		}
		int lHt = depth2(root.left);
		int rHt = depth2(root.right);

		if(Math.abs(lHt - rHt) > 1){
            isBalanced = false;
        }

		return Math.max(lHt, rHt) + 1;
	}
	
	
	public static boolean isBalancedTree(TreeNode<Integer> node) {
		depth2(node);
		return isBalanced;
	}
}
