package com.google.code._0_Concepts;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.google.code._6_Trees.TreeNode;

public class TestClass {
	public static void main(String[] args) {
		
	}
	
    public List<TreeNode> findDuplicateSubtrees(TreeNode root) {
        //the idea is to create unique string of subtree at each node and keep inserting into map
        Map<String, List<TreeNode>> map = new HashMap<>();
        
        createUniqueString(root, map);
        
        List<TreeNode> dupNodes = new ArrayList<>();
        for(Map.Entry<String, List<TreeNode>> entry : map.entrySet()){
            if(entry.getValue().size() > 1){
            	dupNodes.add(  entry.getValue().get(0)  );
            }
        }
        return dupNodes;
    }
    
    public String createUniqueString(TreeNode root, Map<String, List<TreeNode>> map){
        if(root == null) return ""; //or #
        
        String leftTree = createUniqueString(root.left, map);
        String rightTree = createUniqueString(root.right, map);
        
        String uniqueTree = "(" + leftTree + root.data + rightTree + ")";
        
        if(map.get(uniqueTree) == null){
            map.put(uniqueTree, new ArrayList<>());
        }
        map.get(uniqueTree).add(root);
        
        return uniqueTree;
    }
}
