package com.google.code._2_Arrays;

import java.util.ArrayList;
import java.util.List;

public class _2_6Dot2_MaxStockProfit {
    public static void main(String args[]) {
        List<Integer> stockPrices = new ArrayList<>();
        stockPrices.add(38);
        stockPrices.add(2);
        stockPrices.add(4);
        stockPrices.add(1);
        stockPrices.add(20);
        stockPrices.add(28);
        stockPrices.add(2);
        System.out.println(getMaxProfit(stockPrices));

        //
        List<Double> doubleStockPrices = new ArrayList<>();
        doubleStockPrices.add(38.0);
        doubleStockPrices.add(2.0);
        doubleStockPrices.add(4.0);
        doubleStockPrices.add(1.0);
        doubleStockPrices.add(20.0);
        doubleStockPrices.add(28.0);
        doubleStockPrices.add(2.0);
        System.out.println(computeMaxProfit(doubleStockPrices));

    }

    private static double computeMaxProfit(List<Double> prices) {
        double minPrice = Double.MAX_VALUE;
        double maxProfit = 0.0;
        for (Double price : prices) {
            minPrice = Math.min(minPrice, price);
            maxProfit = Math.max(maxProfit, price - minPrice);
        }
        return maxProfit;
    }

    private static int getMaxProfit(List<Integer> stockPrices) {
        if (stockPrices == null || stockPrices.isEmpty()) {
            return 0;
        }
        if (stockPrices.size() == 1) {
            return stockPrices.get(0);
        }

        int minStockPrice = stockPrices.get(0);
        int maxProfit = 0;

        for (int i = 1; i < stockPrices.size(); i++) {
            if (stockPrices.get(i) < minStockPrice) {
                minStockPrice = stockPrices.get(i);
            }

            else if ((stockPrices.get(i) - minStockPrice) > maxProfit) {
                maxProfit = stockPrices.get(i) - minStockPrice;
            }
        }
        return maxProfit;
    }

}
