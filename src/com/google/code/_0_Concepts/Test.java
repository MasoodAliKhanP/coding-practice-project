package com.google.code._0_Concepts;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.TreeMap;
import java.util.concurrent.CopyOnWriteArrayList;

class Test {

	// Driver code
	public static void main(String[] args) {
		int[] arr = { 1, 2, 3 };

		// Auxillary space to store each path
		ArrayList<Integer> path = new ArrayList<>();
//		printSubsequences(arr, 0, path);
//		treeTraversal();
		failSafeIteratorTest();
		CopyOnWriteArrayList c;
	}

//Recursive function to print all
//possible subsequences for given array
	public static void printSubsequences(int[] arr, int index, ArrayList<Integer> path) {

		// Print the subsequence when reach
		// the leaf of recursion tree
		if (index == arr.length) {
			// Condition to avoid printing
			// empty subsequence
			if (path.size() > 0)
				System.out.println(path);
		} else {
			// Subsequence without including
			// the element at current index
			printSubsequences(arr, index + 1, path);

			path.add(arr[index]);

			// Subsequence including the element
			// at current index
			printSubsequences(arr, index + 1, path);

			// Backtrack to remove the recently
			// inserted element
			path.remove(path.size() - 1);
		}
		return;
	}

	public static void treeTraversal() {
		TreeMap<Integer, String> tree_map = new TreeMap<Integer, String>();

// Mapping string values to int keys
// using put() method
		tree_map.put(10, "Geeks");
		tree_map.put(20, "4");
		tree_map.put(15, "Geeks");
		tree_map.put(12, "Welcomes");

// Printing the elements of TreeMap
		System.out.println("TreeMap: " + tree_map);
	}
	
	private static void failSafeIteratorTest() {
		// Create a CopyOnWriteArrayList
        CopyOnWriteArrayList<String> list = new CopyOnWriteArrayList<>();

        // Add elements to the list
        list.add("Apple");
        list.add("Banana");
        list.add("Orange");

        // Create an iterator
        Iterator<String> iterator = list.iterator();

//        while (iterator.hasNext()) {
//            String element = iterator.next();
//            System.out.println(element);
//
//            // Modify the list during iteration
//            if (element.equals("Banana")) {
//                list.add("Mango");
//            }
//        }
        //this works same as above
        for(String element: list) {
        	System.out.println(element);
        	if (element.equals("Banana")) {
                list.add("Mango");
            }
        }
        System.out.println("after list: " + list);
	}

}

