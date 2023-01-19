package com.google.code._0_Concepts;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.google.code._6_Trees.TreeNode;

public class TestClass {
	public static void main(String[] args) {
//		printBytes("What is going on my account");
//		printBytes("CDATA[What is going on my account]");
//		printBytes("<MSG ><![CDATA[What is going on my account]]></MSG>");
		
		
		commaSeparator();
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
    
    
    private static void printBytes(String string) {
    	// Check encoded sizes
    	try {
    		final byte[] utf8Bytes = string.getBytes("UTF-8");
        	System.out.println(utf8Bytes.length); // prints "11"

        	final byte[] utf16Bytes= string.getBytes("UTF-16");
        	System.out.println(utf16Bytes.length); // prints "24"

        	final byte[] utf32Bytes = string.getBytes("UTF-32");
        	System.out.println(utf32Bytes.length); // prints "44"
    	}
    	catch (Exception e) {
			e.printStackTrace();
		}
    }
    
    private static void commaSeparator() {
    	 String number = "1000500000.574";
    	    Double numParsed = Double.parseDouble(number);
    	    String numString = String.format("%,.2f", numParsed);
    	    System.out.println(numString);
    }
}
