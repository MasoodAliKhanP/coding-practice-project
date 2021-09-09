package com.google.code._7_DynamicProgramming;

public class _31_SubSetSum {
//	Given a set of non-negative integers, and a value sum, determine 
//	if there is a subset of the given set with sum equal to given sum. 
	
	//Agar ek hi array hai toh usku knapsack ke weight ke array jaisa treat karna hai
	//yahan knapsack ke value array ko ignore karna hai
	//agar column zero hai matlab sum 0 hai kya? empty set ka sum 0 hai toh woh coloum pura true hai
	//agra row  zero hai matlab, 0 elements se sum 1, 2 , 3 bansakta kya? not possible so false se initiaze karna
	//knapsack mein maximize karna rehta, yahan, sum aata ya ni aata dekhna so value array ko ignore karke 
	// || condition lagana
	public static boolean subSetSumExists(int arr[], int n, int Sum) {
		boolean t[][] = new boolean[n + 1][Sum + 1];
		for (int i = 0; i < n + 1; i++) {
			for (int j = 0; j < Sum + 1; j++) {
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
		return t[n][Sum];
	}
}
