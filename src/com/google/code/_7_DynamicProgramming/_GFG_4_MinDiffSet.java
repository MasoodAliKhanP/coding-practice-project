package com.google.code._7_DynamicProgramming;


//Given a set of integers, the task is to divide it into two sets S1 and S2 
//such that the absolute difference between their sums is minimum. 
//If there is a set S with n elements, then if we assume Subset1 has m elements, 
//Subset2 must have n-m elements and the value of abs(sum(Subset1) – sum(Subset2)) should be minimum.
public class _GFG_4_MinDiffSet {
    public static void main(String args[]) {
        int[] A = { 3, 1, 4, 2, 2, 1, 100 };
        int sumTotal = 0;
        for (int i = 0; i < A.length; i++)
            sumTotal += A[i];
        System.out.println(minSetDiff(A, A.length, 0, sumTotal));
    }

    private static int minSetDiff(int A[], int n, int sumCalc, int sumTotal) {
    	// If we have reached last element. Sum of one subset is sumCalculated,
        // sum of other subset is sumTotal-sumCalculated
    	if (n == 0)
            return Math.abs((sumTotal - sumCalc) - sumCalc);

        else {
            return Math.min(
                    minSetDiff(A, n - 1, sumCalc + A[n - 1], sumTotal),
                    minSetDiff(A, n - 1, sumCalc, sumTotal)
                    );
        }
    }
}
