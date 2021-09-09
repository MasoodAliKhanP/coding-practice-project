package com.google.code._7_DynamicProgramming;

import java.util.Arrays;

public class _3_Knapsack01 {
	public int knapsack01(int w[], int v[], int W, int n) {
		if (W == 0 || n == 0)
			return 0;
		if (w[n - 1] <= W)
			return Math.max(knapsack01(w, v, W - w[n - 1], n - 1)+v[n-1], knapsack01(w, v, W, n - 1));
		else
			return knapsack01(w, v, W, n - 1);
	}

	// Memoization n,W
	static int t[][] = new int[101][101];

	public int knapsack01Memoization(int w[], int v[], int W, int n) {
		if (W == 0 || n == 0) {
			return 0;
		}
		if (t[n][W] != -1) {
			return t[n][W];
		}
		if (w[n - 1] <= W) {
			return t[n][W] = Math.max(knapsack01Memoization(w, v, W - w[n - 1], n - 1) + v[n-1],
					knapsack01Memoization(w, v, W, n - 1));
		} else {
			return t[n][W] = knapsack01Memoization(w, v, W, n - 1);
		}
	}

	public int knapsack01BottomUp(int wt[], int v[], int W, int n) {
		int t[][] = new int[n + 1][W + 1]; // n,W
		for (int i = 0; i < n + 1; i++) {
			Arrays.fill(t[i], -1);
		}
		for (int i = 0; i < n + 1; i++) {
			for (int j = 0; j < W + 1; j++) {
				if (i == 0 || j == 0) {
					t[i][j] = 0;
				}
				if (wt[i - 1] <= j) {
					t[i][j] = Math.max(t[i - 1][j - wt[i - 1]] + v[i - 1], t[i - 1][j]);
				} else {
					t[i][j] = t[i - 1][j];
				}
			}
		}
		return t[n][W];
	}
}
