package com.google.code._2_SlidingWindow;

public class SlidingWindow {
	public static void main(String[] args) {
//		System.out.println("min len: " + minSubArrayLen(7, new int[] { 2, 3, 1, 2, 4, 3 }));
//
		System.out.println("min len: " + minSubArrayLen(11, new int[] { 1,1,1,1,1,1,1,1}));

	}

	// Minimum Size Subarray Sum
//	Given an array of positive integers nums and a positive integer target, return the minimal
//	length of a subarray whose sum is greater than or equal to target. If there is no 
//	such subarray, return 0 instead.
	
//	Input: target = 7, nums = [2,3,1,2,4,3]
//	Output: 2
//	Explanation: The subarray [4,3] has the minimal length under the problem constraint.
	private static int minSubArrayLen(int target, int[] nums) {
		int fIdx = 0;
		int sum = 0;
		int minLen = Integer.MAX_VALUE;

		for (int i = 0; i < nums.length; i++) {
			sum += nums[i];
			if (sum >= target) {
				while (sum >= target) {
					minLen = Math.min(minLen, i - fIdx + 1);
					sum = sum - nums[fIdx];
					fIdx++;
				}
				
			}
		}
		return minLen == Integer.MAX_VALUE? 0: minLen;
	}
	

}
