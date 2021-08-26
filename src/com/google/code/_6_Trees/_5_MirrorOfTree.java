package com.google.code._6_Trees;

public class _5_MirrorOfTree {
	public static void main(String[] args) {
		TreeNode<Integer> tNode = new TreeNode<>(10, null, null);
		TreeNode<Integer> tNode1 = new TreeNode<>(20, null, null);
		TreeNode<Integer> tNode2 = new TreeNode<>(70, null, null);
		TreeNode<Integer> tNode3 = new TreeNode<>(40, null, null);
		TreeNode<Integer> tNode4 = new TreeNode<>(50, null, null);

		tNode.left = tNode1;
		tNode.right = tNode2;
		tNode1.left = tNode3;
		tNode2.right = tNode4;

		
		
		System.out.println("Is Mirror: " + isMirror(tNode, tNode));//Although structure is same, elements are different
		System.out.println("Is Idnetical: " + isIdentical(tNode, tNode));
	}
	
	
	private static boolean isMirror(TreeNode<Integer> node1, TreeNode<Integer> node2) {
		if(node1 == null && node2 == null) {
			return true;
		}
		if(node1 == null || node2 == null) {
			return false;
		}
		if(node1.data != node2.data) {
			return false;
		}
		return isMirror(node1.left, node2.right) && isMirror(node2.right, node1.left);
	}
	
	
	
	private static boolean isIdentical(TreeNode<Integer> node1, TreeNode<Integer> node2) {
		if(node1 == null && node2 == null) {
			return true;
		}
		if(node1 == null || node2 == null) {
			return false;
		}
		if(node1.data != node2.data) {
			return false;
		}
		return isIdentical(node1.left, node2.left) && isIdentical(node1.right, node2.right);
	}
}
