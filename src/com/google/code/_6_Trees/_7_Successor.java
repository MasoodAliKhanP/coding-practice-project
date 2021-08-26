package com.google.code._6_Trees;

import java.util.ArrayList;
import java.util.List;

public class _7_Successor {
	public static void main(String[] args) {
		TreeNode<Integer> tNode = new TreeNode<>(20, null, null);
		TreeNode<Integer> tNode1 = new TreeNode<>(8, null, null);
		TreeNode<Integer> tNode2 = new TreeNode<>(22, null, null);
		TreeNode<Integer> tNode3 = new TreeNode<>(4, null, null);
		TreeNode<Integer> tNode4 = new TreeNode<>(12, null, null);
		TreeNode<Integer> tNode5 = new TreeNode<>(10, null, null);
		TreeNode<Integer> tNode6 = new TreeNode<>(14, null, null);


		tNode.left = tNode1;
		tNode.right = tNode2;
		tNode1.left = tNode3;
		tNode1.right = tNode4;
		tNode4.left = tNode5;
		tNode4.right = tNode6;
		
//		InSuccessor(tNode, tNode1);
//		System.out.println();
		
		method2(tNode, tNode6);
	}
	
	//Time complexity is O(n) and space is no extra space apart form stack calls
		static boolean isFound = false;
		public static void method2(TreeNode<Integer> node, TreeNode<Integer> searchNode) {
			if(node != null) {
				method2(node.left, searchNode);
				if(node == searchNode) {
					isFound = true;
					return;
				}
				if(isFound) {
					System.out.println("successor: "  + node + "data: " + node.data);
					isFound = false;
				}
				method2(node.right, searchNode);
			}
		}
		
		
		//Probably not the best way
	public static void InSuccessor(TreeNode<Integer> node, TreeNode<Integer> searchNode) {
		List<TreeNode<Integer>> list = new ArrayList<>();
		SuccessorUtil(node, list);
		
		
		TreeNode<Integer> successor = null;
		for(int i = 0; i <= list.size() -2; i++) {
			if(searchNode == list.get(i)) {
				successor = list.get(i+1);
			}
		}
		if(successor != null)
			System.out.println("successor: " + successor + "data: " + successor.data);
		else
			System.out.println("There is no successor");
	}
	
	public static void SuccessorUtil(TreeNode<Integer> node, List<TreeNode<Integer>> list){
		if(node != null) {
			SuccessorUtil(node.left, list);
			list.add(node);
			SuccessorUtil(node.right, list);
		}
	}
	
	
	
}
