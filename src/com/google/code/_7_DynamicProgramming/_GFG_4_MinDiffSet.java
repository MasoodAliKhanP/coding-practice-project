package com.google.code._7_DynamicProgramming;

public class _GFG_4_MinDiffSet {
    public static void main(String args[]) {
        int[] A = { 3, 1, 4, 2, 2, 1, 100 };
        int sumTotal = 0;
        for (int i = 0; i < A.length; i++)
            sumTotal += A[i];
        System.out.println(minSetDiff(A, 5, 0, sumTotal));
    }

    private static int minSetDiff(int A[], int n, int sumCalc, int sumTotal) {
        if (n == 0)
            return Math.abs(sumTotal - sumCalc - sumCalc);

        else {
            return Math.min(
                    minSetDiff(A, n - 1, sumCalc + A[n - 1], sumTotal),
                    minSetDiff(A, n - 1, sumCalc, sumTotal)
                    );
        }
    }
}
