package com.google.code._2_Arrays;

import java.util.Comparator;
import java.util.PriorityQueue;

class MinHead implements Comparator<Integer>{
	@Override
	public int compare(Integer o1, Integer o2) {
		// TODO Auto-generated method stub
		return o1-o2;
	}
}
public class _5_kth_largest {
	public static void main(String[] args) {
		int[] arr = {1, 2, 3, 4, 5};
		System.out.println(findKthLargest(arr, 2));
	}

//	O(Nlogk), space O(k)
	public static int findKthLargest(int[] nums, int k) {
		// init heap 'the smallest element first'
//		PriorityQueue<Integer> heap = new PriorityQueue<Integer>(new MinHead());

		PriorityQueue<Integer> heap = new PriorityQueue<Integer>((n1, n2) -> n1 - n2);

		// keep k largest elements in the heap
		for (int n : nums) {
			heap.add(n);
			if (heap.size() > k)
				heap.poll();
		}

		// output
		return heap.poll();
	}
	
//	 Method2: Build a heap and poll k times
//	 Method3: using Quickselect	
}
