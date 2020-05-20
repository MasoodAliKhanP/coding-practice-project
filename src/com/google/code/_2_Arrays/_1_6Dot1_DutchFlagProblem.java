package com.google.code._2_Arrays;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class _1_6Dot1_DutchFlagProblem {
//    public static enum Color {
//        RED, WHITE, BLUE
//    };

    public static void main(String[] args) {
        Integer[] intArray = { 2, 1, 2, 1, 1, 3, 2 };
        List<Integer> integerList = Arrays.asList(intArray);
        dutchFlagPartition(0, integerList);
        printIntegersList(integerList);

        intArray = new Integer[] { 3, 2, 1, 2, 1, 1, 3 };
        integerList = Arrays.asList(intArray);
        dutchFlagPartition(1, integerList);
        printIntegersList(integerList);
    }

    public static void dutchFlagPartition(int pivotlndex, List<Integer> A) {
        int pivot = A.get(pivotlndex);
        int smaller = 0;
        int equal = 0;
        int larger = A.size();
        // Keep iterating as long as there is an unclassified element.
        while (equal < larger) {
            // A . get (equal) is the incoming unclassified element.
            if (A.get(equal) < pivot) {
                Collections.swap(A, smaller++, equal++);
            } else if (A.get(equal) == pivot) {
                ++equal;
            } else { // A . get (equal) > pivot.
                Collections.swap(A, equal, --larger);
            }
        }
    }

    private static void printIntegersList(List<Integer> A) {
        for (Integer x : A) {
            System.out.print(x + " ");
        }
        System.out.println();
    }
}
