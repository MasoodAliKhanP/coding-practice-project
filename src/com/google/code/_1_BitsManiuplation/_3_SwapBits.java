package com.google.code._1_BitsManiuplation;

public class _3_SwapBits {

    public static void main(String args[]) {
//        swapBits();
        swapBits(8, 0, 3); //1000 -> 0001
    }

    private static void swapBits() {
        long x = 5;//0101 -> 1100
        long bitMask = (1L << 3) | (1L << 0);//1000 | 0001
        System.out.println("BitMask: " + bitMask);
        x ^= bitMask;
        System.out.println("After swapping: " + x);
    }

    private static void swapBits(long x, int i, int j) {
        if (((x >> i) & 1) != ((x >> j) & 1)) {//1000 | 0010 0 
            long bitMask = (1L << i) | (1L << j); 
            // 1000| 0001 -> 1001 -> 9
            System.out.println("BitMask: " + bitMask);
            x ^= bitMask;
        }
        System.out.println("After swapping: " + x);
    }
}
