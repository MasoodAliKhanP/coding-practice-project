package com.google.code._7_DynamicProgramming;

import java.util.Arrays;

public class _1_GL_CountWaysStairCase {
    public static void main(String args[]) {
//        System.out.println(countWaysRec(3));

        int n = 3;
        long[] A = new long[n + 1];
        Arrays.fill(A, -1);
        System.out.println(countWaysRec(n));
        System.out.println(countWays(n, A));
    }

    // Recursive
    public static int countWaysRec(int n) {
        if (n < 0)
            return 0;
        if (n == 0)
            return 1;
        return countWaysRec(n - 3) + countWaysRec(n - 2) + countWaysRec(n - 1);
    }

    // Dp
    public static long countWays(int n, long[] A) {
        if (n < 0)
            return 0;
        if (n == 0)
            return 1;
        if (A[n] != -1) {
            return A[n];
        } else {
            A[n] = countWays(n - 3, A) + countWays(n - 2, A) + countWays(n - 1, A);
            return A[n];
        }
    }
}
