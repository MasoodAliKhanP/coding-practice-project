package com.google.code._2_Searching;

/* Magic number : A[i] == i, array is sorted */
public class _1_MagicNumber {
    public static void main(String args[]) {
        int[] arrDist = { 1, 9, 12, 14, 15, 19 };
        System.out.println("Distinct Magic Number: " + magicNumberDistinctArray(arrDist, 0, arrDist.length - 1));

        int[] arr = { 2, 3, 4, 12, 1, 5, 4 };
        int magicNumberND = magicNumberNonDistinctArray(arr, 0, arr.length - 1);
        System.out.println("Non distinct Magic Index: " + magicNumberND);
    }

    private static int magicNumberDistinctArray(int[] arr, int start, int end) {
        if (start < 0 || start > end || end > arr.length)
            return -1;

        int midIndex = (start + (end - start) / 2);

        if (arr[midIndex] == midIndex)
            return midIndex;
        else if (arr[midIndex] > midIndex) {
            return magicNumberDistinctArray(arr, start, midIndex - 1);
        } else {
            return magicNumberDistinctArray(arr, midIndex + 1, end);
        }
    }

    private static int magicNumberNonDistinctArray(int[] arr, int start, int end) {
        if (start < 0 || start > end || end > arr.length) {
            return -1;
        }
        int midIndex = start + (end - start) / 2;
        int midValue = arr[midIndex];

        if (midValue == midIndex)
            return midIndex;

        /* left search */
        int leftIndex = Math.min(midIndex - 1, midValue);
        int left = magicNumberNonDistinctArray(arr, start, leftIndex);
        if (left >= 0)
            return left;

        /* right search */
        int rightIndex = Math.max(midIndex + 1, midValue);
        return magicNumberDistinctArray(arr, rightIndex, end);
    }
}
