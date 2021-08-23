package com.google.code._7_DynamicProgramming;

//Given two strings str1 and str2 and below operations that can performed on str1. 
//Find minimum number of edits (operations) required to convert ‘str1’ into ‘str2’.  
//
//Insert
//Remove
//Replace
//All of the above operations are of equal cost. 
public class _GFG_3_EditDistance {
	public static void main(String args[]) {
		String str1 = "sunday";
		String str2 = "saturday";

		System.out.println("minEdits recurse: "
				+ minEditsRecurse(str1.toCharArray(), str2.toCharArray(), str1.length(), str2.length()));

		System.out.println(
				"minEdits dp: " + minEdits(str1.toCharArray(), str2.toCharArray(), str1.length(), str2.length()));

	}

	// Insert, remove replace
	private static int minEditsRecurse(char A[], char B[], int m, int n) {
		if (m == 0) {
			return n;
		}
		if (n == 0) {
			return m;
		}

		if (A[m - 1] == B[n - 1])
			return minEditsRecurse(A, B, m - 1, n - 1);

		return 1 + min(minEditsRecurse(A, B, m - 1, n), //Insert
				minEditsRecurse(A, B, m, n - 1), //Remove
				minEditsRecurse(A, B, m - 1, n - 1) //Replace
				);

	}

	private static int minEdits(char A[], char B[], int m, int n) {
		int[][] minEdits = new int[m + 1][n + 1];
		for (int i = 0; i <= m; i++) {
			for (int j = 0; j <= n; j++) {

				if (i == 0) {
					minEdits[i][j] = j;
				} else if (j == 0) {
					minEdits[i][j] = i;
				} else if (A[i - 1] == B[j - 1]) {
					minEdits[i][j] = minEdits[i - 1][j - 1];
				} else {
					minEdits[i][j] = 1 + min(minEdits[i - 1][j], //Insert
											minEdits[i][j - 1], //Remove
											minEdits[i - 1][j - 1]  //Replace
													);
				}
			}
		}

		return minEdits[m][n];
	}

	private static int min(int x, int y, int z) {
		return Math.min(x, Math.min(y, z));
	}
}
