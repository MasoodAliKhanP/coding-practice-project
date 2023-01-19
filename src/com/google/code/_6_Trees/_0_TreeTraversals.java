package com.google.code._6_Trees;

public class _0_TreeTraversals {
	public static void main(String[] args) {
		TreeNode<Integer> tNode = new TreeNode<>(1, null, null);
		TreeNode<Integer> tNode1 = new TreeNode<>(10, null, null);
		TreeNode<Integer> tNode2 = new TreeNode<>(20, null, null);
		TreeNode<Integer> tNode3 = new TreeNode<>(30, null, null);
		TreeNode<Integer> tNode4 = new TreeNode<>(40, null, null);
		TreeNode<Integer> tNode5 = new TreeNode<>(50, null, null);
		tNode.left = tNode1;
		tNode1.left = tNode2;
		tNode2.left = tNode3;
		tNode.right = tNode4;
		tNode4.left = tNode5;
		inorderTraversal(tNode);
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
