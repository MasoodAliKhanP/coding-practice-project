package com.google.code._7_DynamicProgramming;

import java.util.Arrays;
import java.util.List;

public class _0_MaximumSubArray {
    public static void main(String args[]) {
        Integer[] arr = { -2, -30, 4, -1, -2, 1, 5, -3 };
//        Integer[] arr = { -2, -30, -4, -1, -2};

        List<Integer> A = Arrays.asList(arr);

        System.out.println("findMaxSubarray: "+findMaxSubarray(A)+"\n");

        System.out.println("findMaximumSubarray: "+findMaximumSubarray(A)+"\n");
        
        System.out.println("maxSubArraySum: "+maxSubArraySum(arr)+"\n");
    }

    // EOP - Calculates the non-circular solution. - good one
    private static int findMaxSubarray(List<Integer> A) {
        int maximumSumSoFar = 0;
        int maximumSum = A.get(0);
        for (Integer a : A) {
            maximumSumSoFar = Math.max(a, a + maximumSumSoFar);
            maximumSum = Math.max(maximumSum, maximumSumSoFar);
//            System.out.println("maxtill: " + maximumSumTill + " max: " + maximumSum);
        }
        return maximumSum;
    }

    // EOP DP INTRO - Not following
    public static int findMaximumSubarray(List<Integer> A) {

        int minSum = Integer.MAX_VALUE;
        int maxSum = Integer.MIN_VALUE;
        int sum = 0;
        for (Integer a : A) {
            sum += a;
            minSum = Math.min(minSum, sum);
            maxSum = Math.max(maxSum, sum - minSum);
//            System.out.println("sum: " + sum + " minSum: " + minSum + " maxsum: " + maxSum);
        }
//        System.out.println("_________________");
        return maxSum;
    }

    // Geeks
    public static int maxSubArraySum(Integer a[]) {
        int max_so_far = a[0];
        int curr_max = a[0];

        for (int i = 1; i < a.length; i++) {
            curr_max = Math.max(a[i], curr_max + a[i]);
            max_so_far = Math.max(max_so_far, curr_max);
        }
        return max_so_far;
    }

    // Geeks
    static int maxSubArraySum2(Integer a[]) {
        int max_so_far = 0;
        int max_ending_here = 0;
        for (int i = 0; i < a.length; i++) {
            max_ending_here = max_ending_here + a[i];
            if (max_ending_here < 0)
                max_ending_here = 0;
            else if (max_so_far < max_ending_here)
                max_so_far = max_ending_here;
        }
        return max_so_far;
    }

}
