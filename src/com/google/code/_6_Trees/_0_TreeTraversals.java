package com.google.code._6_Trees;

public class _0_TreeTraversals {
	public static void main(String[] args) {

	}

	public static void inorderTraversal(TreeNode<Integer> root) {
		if (root != null) {
			inorderTraversal(root.left);
			System.out.println(root.data);
			inorderTraversal(root.right);
		}
	}

	public static void ioTraverse(TreeNode<Integer> root) {
		if (root != null) {
			ioTraverse(root.left);
			System.out.println(root.data);
			ioTraverse(root.right);
		}
	}
}
