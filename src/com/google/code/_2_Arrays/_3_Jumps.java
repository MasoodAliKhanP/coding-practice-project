package com.google.code._2_Arrays;

import java.util.Arrays;
import java.util.List;

//isEndOfArrayReachable
public class _3_Jumps {
	public static void main(String args[]) {
		Integer[] arr = { 1, 1, 3, 4, 1, 0, 1, 1, 0 };
//		Integer[] arr = { 3, 2};

		List<Integer> steps = Arrays.asList(arr);
		System.out.println("isEndOfArrayReachable: " + isEndOfArrayReachable(steps));
//		System.out.println(dpSteps(arr));
		System.out.println("canJump: " + canJump(arr));
	}

	// Looks like sliding window - I will follow this 
	// same as jumps in leetcode
	// starting from back - checking if the last position is reachable, 
	// and slide the last to the index from where it is reachable
	public static boolean canJump(Integer[] nums) {
		int lastPos = nums.length - 1;
		for (int i = nums.length - 1; i >= 0; i--) {
			System.out.println(i+nums[i] + ":" + lastPos);
			if (i + nums[i] >= lastPos) {
				lastPos = i;
			}
		}
		return lastPos == 0;
	}

	private static boolean isEndOfArrayReachable(List<Integer> steps) {
		Integer maxStepsCanBeTaken = Integer.MIN_VALUE;
		Integer n = steps.size();

		for (int i = 0; i < n; i++) {
			int step = steps.get(i);

			if (step == 0 && maxStepsCanBeTaken == 0) {
				return false;
			}
			if (step >= n - i - 1) {
//				System.out.println("step: " + step + " remlen:" + (n - i - 1));
				return true;
			}

			maxStepsCanBeTaken = Math.max(maxStepsCanBeTaken, step);
			maxStepsCanBeTaken--;
		}

		return false;
	}

	// Method 2: dp O(n^2)
	public static boolean dpSteps(Integer[] arr) {
		boolean[] dp = new boolean[arr.length];
		dp[0] = true;

		/* finding result for every index */
		for (int currPos = 0; currPos < arr.length; currPos++) {
			if (dp[currPos] && arr[currPos] > 0) {
				int maxJumps = arr[currPos];
				for (int jump = 1; jump <= maxJumps; jump++) {
					if (currPos + jump < dp.length) {
						dp[currPos + jump] = true;
					}
				}
			}
		}
		for (int i = 0; i < arr.length; i++) {
//			System.out.println("Arr[" + i + "]: " + dp[i]);
		}
		return dp[arr.length - 1];
	}

}
