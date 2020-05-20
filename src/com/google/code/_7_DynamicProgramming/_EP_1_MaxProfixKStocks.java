package com.google.code._7_DynamicProgramming;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class MaxProfit {
    Double maxProfit;
    int minIndex;
    int maxIndex;
}

public class _EP_1_MaxProfixKStocks {
    public static void main(String[] args) {
        List<Double> A;
        Double[] ADouble = { 35.0, 10.0, 50.0, 20.0, 10.0, 70.0, 80.0, 40.0 };
        A = Arrays.asList(ADouble);
        System.out.println(maxKPairsProfits(A, 2));
//        maxProfitStock(A, 2);

        int k = 3;
        int price[] = { 12, 14, 17, 10, 14, 13, 12, 15 };
        int n = price.length;
        System.out.println(maxProfit(price, n, k));

        A = Arrays.asList(10.0, 22.0, 5.0, 75.0, 65.0, 80.0);
//        System.out.println(maxKPairsProfits(A, 2));

        A = Arrays.asList(12.0, 14.0, 17.0, 10.0, 14.0, 13.0, 12.0, 15.0);
//        System.out.println(maxKPairsProfits(A, 3));

        A = Arrays.asList(10.0, 40.0, 90.0, 100.0);
//        System.out.println(maxKPairsProfits(A, 2));
    }

    public static double maxKPairsProfits(List<Double> A, int k) {
        List<Double> kSum = new ArrayList<>();
        for (int i = 0; i < k * 2; ++i) {
            kSum.add(Double.NEGATIVE_INFINITY);
        }
        for (int i = 0; i < A.size(); ++i) {
            List<Double> preKSum = new ArrayList<>(kSum);

            for (int j = 0, sign = -1; j < kSum.size() && j <= i; ++j, sign *= -1) {
                double diff = sign * A.get(i) + (j == 0 ? 0 : preKSum.get(j - 1));
                kSum.set(j, Math.max(diff, preKSum.get(j)));
            }
        }
        // Returns the last selling profits as the answer.
        return kSum.get(kSum.size() - 1);
    }

    // Function to find out maximum profit by
    // buying & selling/ a share atmost k times
    // given stock price of n days
    static int maxProfit(int price[], int n, int k) {

        // table to store results of subproblems
        // profit[t][i] stores maximum profit
        // using atmost t transactions up to day
        // i (including day i)
        int profit[][] = new int[k + 1][n + 1];

        // For day 0, you can't earn money
        // irrespective of how many times you trade
        for (int i = 0; i <= k; i++)
            profit[i][0] = 0;

        // profit is 0 if we don't do any
        // transation (i.e. k =0)
        for (int j = 0; j <= n; j++)
            profit[0][j] = 0;

        // fill the table in bottom-up fashion
        for (int i = 1; i <= k; i++) {
            int prevDiff = Integer.MIN_VALUE;
            for (int j = 1; j < n; j++) {
                prevDiff = Math.max(prevDiff, profit[i - 1][j - 1] - price[j - 1]);
                profit[i][j] = Math.max(profit[i][j - 1], price[j] + prevDiff);
            }
        }

        return profit[k][n - 1];
    }

    // This code is contributed by Sam007
    public static double maxProfitStock(List<Double> A, int k) {
        List<Double> sumList = new ArrayList<>();
        for (int i = 0; i < k; i++) {
            Double maxProfit = Double.MIN_VALUE;
            Double min = Double.MAX_VALUE;

            for (int j = 0; j < A.size(); j++) {
                min = Math.min(A.get(j), min);
                maxProfit = Math.max(maxProfit, A.get(j) - min);
            }
            sumList.add(maxProfit);
        }
        return 0;
    }
}
