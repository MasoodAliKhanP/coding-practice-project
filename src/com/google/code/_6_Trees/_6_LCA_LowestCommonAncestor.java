package com.google.code._6_Trees;

public class _6_LCA_LowestCommonAncestor {
	public static void main(String[] args) {
		TreeNode<Integer> tNode = new TreeNode<>(0, null, null);
		TreeNode<Integer> tNode1 = new TreeNode<>(1, null, null);
		TreeNode<Integer> tNode2 = new TreeNode<>(2, null, null);
		TreeNode<Integer> tNode3 = new TreeNode<>(3, null, null);
		TreeNode<Integer> tNode4 = new TreeNode<>(4, null, null);
		TreeNode<Integer> tNode5 = new TreeNode<>(5, null, null);

		// Case1: balanced
		tNode.left = tNode1;
		tNode.right = tNode2;
		tNode2.left = tNode3;
		tNode2.right = tNode4;
		tNode4.right = tNode5;
		
		System.out.println(lca(tNode, tNode1, tNode5).data);
	}
	
	private static TreeNode<Integer> lca(TreeNode<Integer> root, TreeNode<Integer> a, TreeNode<Integer> b){
		if(root == null) {
			return null;
		}
		if(root == a || root == b) {
			return root;
		}
		TreeNode<Integer> lf = lca(root.left, a, b);
		TreeNode<Integer> rt = lca(root.right, a, b);
		
		if(lf != null && rt != null)
			return root;
		
		return lf != null? lf: rt;
	}
}
