package com.google.code._7_DynamicProgramming;

//Given an array arr[] of length N and an integer X,
//the task is to find the number of subsets with a sum equal to X.
public class _34_SubSetSumCount {
	//It is similar to sub set sum problem, instead of checking if sum exists we keep adding 
	// as and when the sum is found
	//So basicallhy chage or condition to plus(+)
	public static int subSetSumCount(int arr[], int n,  int sum) {
		int t[][] = new int[n+1][sum+1];
		
		for(int i = 0; i < n+1; i++) {
			for(int j = 0; j < sum + 1; j++) {
				if(i == 0) {
					t[i][j] = 0;
				}if ( j == 0 ) {
					t[i][j] = 1;
				}if(arr[i] <= j) {
					t[i][j] = t[i-1][j-arr[i-1]] + t[i-1][j];
				}else {
					t[i][j] = t[i-1][j];
				}
			}
		}
		return t[n][sum];
	}
}
