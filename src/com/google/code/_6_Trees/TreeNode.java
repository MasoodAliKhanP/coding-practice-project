package com.google.code._6_Trees;

public class TreeNode<T> {
	public T data;
	public TreeNode<T> left, right;

	TreeNode(T data, TreeNode<T> left, TreeNode<T> right) {
		this.data = data;
		this.left = left;
		this.right = right;
	}
}
