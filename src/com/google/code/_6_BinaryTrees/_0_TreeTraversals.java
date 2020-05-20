package com.google.code._6_BinaryTrees;

class TreeNode<T> {
    public T data;
    public TreeNode<T> left, right;

    TreeNode(T data, TreeNode<T> left, TreeNode<T> right) {
        this.data = data;
        this.left = left;
        this.right = right;
    }
}

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
}
