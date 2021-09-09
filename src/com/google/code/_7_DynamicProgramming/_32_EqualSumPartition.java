package com.google.code._7_DynamicProgramming;

public class _32_EqualSumPartition {
	public static boolean equalSumPartitionExists(int arr[], int n) {
		int sum = 0;
		for(int i = 0; i < n; i++) {
			sum = sum + arr[i];
		}
		if(sum % 2 != 0) {
			return false;
		}
		return _31_SubSetSum.subSetSumExists(arr, n, sum/2);
	}
}
