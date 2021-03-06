package com.google.code._1_BitsManiuplation;

public class _2_ComputeParity {

    public static void main(String args[]) {
        int x = 4;
        System.out.println(x ^= x);
        System.out.println("Xor parity: " + parityViaXor(1024));
    }

    // Sol 1
    public static short parity(long x) {
        short result = 0;
        while (x != 0) {
            result ^= (x & 1);
            x >>>= 1;
        }
        return result;
    }

    // Sol 2, you can set lowest set bit to 0 in each iteration via x&(x-1) and keep
    // checking if x is still non zero

    public static short parityViaSettingLowestBitToZero(long x) {
        short result = 0;
        while (x != 0) {
            x = x & (x - 1);
            result ^= 1;
        }
        return result;
    }

    // Sol 3
    public static short parityViaXor(long x) {
        x ^= x >>> 32;
        x ^= x >>> 16;
        x ^= x >>> 8;
        x ^= x >>> 4;
        x ^= x >>> 2;
        x ^= x >>> 1;
        return (short) (x & 0x1);
    }
}
