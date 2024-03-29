package com.google.code._7_DynamicProgramming;

import java.util.Arrays;

public class _GFG_1_LongestIncreasingSubsequence {
    public static void main(String[] args) {
        int[] A = { 1, 1, 1, 2, 3, 2, 5, 3, 6, 3 };
        // lis is 1, 2, 3, 5, 6
//        List<Integer> myList = Arrays.asList(1, 2, 3);
        System.out.println("len: " + A.length);

        System.out.println(lis(A));
    }

//    Input  : arr[] = {3, 10, 2, 1, 20}
//    Output : Length of LIS = 3
//    The longest increasing subsequence is 3, 10, 20
    private static int lis(int A[]) {
        int[] lis = new int[A.length];
        Arrays.fill(lis, 1);
        for (int i = 1; i < A.length; i++) {
            for (int j = 0; j < i; j++) {
                if (A[i] > A[j] && lis[i] <= lis[j]) {
                    lis[i] = lis[i] + 1;
                }
            }
        }
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < lis.length; i++) {
            max = Math.max(max, lis[i]);
        }
        return max;
    }
}
