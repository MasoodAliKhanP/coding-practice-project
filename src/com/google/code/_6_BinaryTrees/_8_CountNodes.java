package com.google.code._6_BinaryTrees;

public class _8_CountNodes {
	public int countNodes(TreeNode<Integer> root) {
        if(root == null) return 0;
        
        return countNodes(root.left) + 1 + countNodes(root.right);
    }
}
