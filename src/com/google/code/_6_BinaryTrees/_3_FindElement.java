package com.google.code._6_BinaryTrees;

public class _3_FindElement {
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

		System.out.println(eleExistInBST(tNode, 50));
	}
	
	
	public static boolean eleExistInBST(TreeNode<Integer> node, Integer x) {
		if(node == null) {
			return false;
		}
		if(node.data == x) {
			return true;
		}
		
		return eleExistInBST(node.left, x) || eleExistInBST(node.right, x);
	}
}
