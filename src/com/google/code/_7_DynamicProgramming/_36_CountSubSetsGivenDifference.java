package com.google.code._7_DynamicProgramming;

public class _36_CountSubSetsGivenDifference {
	//problem - given a num diff, give the count of s1-s2=diff
	
	// ye problem subset sum count ke jaisa hai, bus thoda math karna hai
	// s -(tSum-s) = diff --> s = (diff+tSum)/2
	// therefore yahan sum jo hai upar wala 's' hai
	public static int countSubsetsWithGivenDifference(int arr[], int n, int diff) {
		int tSum = 0;
		for (int i = 0; i < n; i++) {
			tSum += arr[i];
		}
		int s = (diff + tSum) / 2;

		return subsetSumCount(arr, n, s);
	}

	private static int subsetSumCount(int arr[], int n, int sum) {
		int tSum = 0;
		for (int i = 0; i < n; i++) {
			tSum += arr[i];
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
		return t[n][tSum];
	}
}
