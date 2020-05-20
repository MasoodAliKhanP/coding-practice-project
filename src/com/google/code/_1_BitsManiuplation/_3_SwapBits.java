package com.google.code._1_BitsManiuplation;

public class _3_SwapBits {

    public static void main(String args[]) {
//        swapBits();
        swapBits(8, 0, 3);
    }

    private static void swapBits() {
        long x = 5;
        long bitMask = (1L << 3) | (1L << 0);
        System.out.println("BitMask: " + bitMask);
        x ^= bitMask;
        System.out.println("After swapping: " + x);
    }

    private static void swapBits(long x, int i, int j) {
        if (((x >> i) & 1) != ((x >> j) & 1)) {
            long bitMask = (1L << i) | (1L << j);
            System.out.println("BitMask: " + bitMask);
            x ^= bitMask;
        }
        System.out.println("After swapping: " + x);
    }
}
