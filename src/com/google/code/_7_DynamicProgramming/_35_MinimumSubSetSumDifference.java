package com.google.code._7_DynamicProgramming;

public class _35_MinimumSubSetSumDifference {
	//Problem statement
	//Given a set of integers, the task is to divide it into two sets S1 and S2 such that the absolute difference between their sums is minimum. 
//	If there is a set S with n elements, then if we assume Subset1 has m elements, Subset2 
//	must have n-m elements and the value of abs(sum(Subset1) – sum(Subset2)) should be minimum.
	
	
	//ye subset sum se similar hai
	//yahan s1-s2/s2-s1 minimize karna hai, s2 jo hai totalsum - s1 ich hai therefore,difference 
	//totalSum - 2s1 minimize karna hai
	//so yahan t[][] ke last row mein jab poore elements consider kare toh column wala sum banta ya
	//ni banta malum hota, basically s1 ke values aate
	//final row pe loop karke tSum-2j ku minimize kardena, wahi value ans hai
	public static int minSubSetSumDiff(int arr[], int n) {
		int totalSum = 0;
		for(int i= 0; i < n; i++) {
			totalSum = totalSum + arr[i];
		}
		
		boolean t[][] = new boolean[n + 1][totalSum + 1];
		for (int i = 0; i < n + 1; i++) {
			for (int j = 0; j < totalSum + 1; j++) {
				if (i == 0) {
					t[i][j] = false;
				}
				if (j == 0) {
					t[i][j] = true;
				}
				if (arr[i - 1] <= j) {
					t[i][j] = t[i - 1][j - arr[i - 1]] || t[i - 1][j];
				} else {
					t[i][j] = t[i - 1][j];
				}
			}
		}
		
		int minDiff = Integer.MAX_VALUE;
		for(int j = 0; j < totalSum/2 +1; j++) {
			if(t[n][j] == true) {//n is fixed to last row here
				minDiff = Math.min(minDiff, totalSum - 2 * j);
			}
		}
		
		
		return minDiff;
	}
}
