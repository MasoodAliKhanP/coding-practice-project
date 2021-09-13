package com.google.code._7_DynamicProgramming;

public class _37_TargetSum {
	//is problem mein ek array diya hua hai usme each element ke samne + ya - lagana hai aur sum ku add kare
	//toh ek sum aata, jo problem mein diya hua hai
	//waise kitne combinations hai
	
	//basically ye _36_CountSubSetsGivenDifference  ich hai, + - bole toh kya hai + wale number
	//ek jagah, - wale numbers ek jagah rakhe toh kya aata s1 - s2 = sum
	
	// ye problem subset sum count ke jaisa hai, bus thoda math karna hai
		// s -(tSum-s) = diff --> s = (diff+tSum)/2
		// therefore yahan sum jo hai upar wala 's' hai
	
	public static int targetSum(int arr[], int n, int sum) {
		int tSum = 0;
		for (int i = 0; i < n; i++) {
			tSum += arr[i];
		}
		if(sum > tSum) {//corner case
			return 0;
		}
		if((sum + tSum) % 2 != 0) {//another case
			return 0;
		}
		int s = (sum + tSum) / 2;

		return subsetSumCount(arr, n, s);
	}
	
//	The solution doesn't consider presence of "0"s in the array. Why the output is different ?
//
//	Because, if we have "0", then, it can have +0 and -0 and still will not effect the sum of a set. For example: Target value is = 2
//
//	1) {0,2} = {+0,2}, {-0,2}.  Ans: 2
//
//	But if we increase number of 0s,
//
//	2) {0,0,2} = {+0,+0,2}, {+0,-0,2}, {-0,+0,2},{-0,-0,2} . Ans: 4
	private static int subsetSumCount(int arr[], int n, int sum) {
		int tSum = 0;
		int zeroCount = 0;
		for (int i = 0; i < n; i++) {
			tSum += arr[i];
			zeroCount++;
		}

		int t[][] = new int[n + 1][tSum + 1];

		for (int i = 0; i < n+1; i++) {
			for (int j = 0; j < tSum+1; j++) {
				if (i == 0) {
					t[i][j] = 0;
				}
				if (j == 0) {
					t[i][j] = 1;
				}
				if (arr[i - 1] <= j) {
					t[i][j] = t[i - 1][j - arr[i - 1]] + t[i - 1][j];
				} else {
					t[i][j] = t[i - 1][j];
				}
			}
		}
		return (int) (Math.pow(2, zeroCount) * t[n][tSum]);
	}
}
