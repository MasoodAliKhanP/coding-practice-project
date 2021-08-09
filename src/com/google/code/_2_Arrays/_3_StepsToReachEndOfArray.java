package com.google.code._2_Arrays;

import java.util.Arrays;
import java.util.List;

public class _3_StepsToReachEndOfArray {
    public static void main(String args[]) {
        Integer[] arr = { 1, 1, 3, 4, 1, 0, 2, 1, 0 };
        List<Integer> steps = Arrays.asList(arr);
        System.out.println(isEndOfArrayReachable(steps));
        System.out.println(solve(arr));

    }

    private static boolean isEndOfArrayReachable(List<Integer> steps) {
        Integer maxStepsCanBeTaken = Integer.MIN_VALUE;
        Integer n = steps.size();

        for (int i = 0; i < n; i++) {
            int step = steps.get(i);

            if (step == 0 && maxStepsCanBeTaken == 0) {
                return false;
            }
            if (step >= n - i - 1) {
                System.out.println("step: " + step + " remlen:" + (n - i - 1));
                return true;
            }

            maxStepsCanBeTaken = Math.max(maxStepsCanBeTaken, step);
            maxStepsCanBeTaken--;
        }

        return false;
    }

    public static boolean solve(Integer[] arr) {
        boolean[] dp = new boolean[arr.length];
        dp[0] = true;

        /* finding result for every index */
        for (int currPos = 0; currPos < arr.length; currPos++) {
            if (dp[currPos] && arr[currPos] > 0) {
                int maxJumps = arr[currPos];
                for (int jump = 1; jump <= maxJumps; jump++) {
                    if (currPos + jump < dp.length) {
                        dp[currPos + jump] = true;
                    }
                }
            }
        }
        for(int i = 0; i < arr.length; i++) {
        	System.out.println("Arr["+i+"]: " + dp[i]);
        }
        return dp[arr.length - 1];
    }

}
