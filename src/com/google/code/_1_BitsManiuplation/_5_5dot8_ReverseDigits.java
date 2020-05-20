package com.google.code._1_BitsManiuplation;

public class _5_5dot8_ReverseDigits {
    public static void main(String args[]) {
        System.out.println(reverseDigits(-203));
    }

    private static long reverseDigits(int number) {
        long result = 0;
        long xRemaining = Math.abs(number);
        // 132 => 231, 32 => 23
        while (xRemaining != 0) {
            result = result * 10 + xRemaining % 10;
            xRemaining = xRemaining / 10;
//            System.out.println(xRemaining);
        }
        return number < 0 ? -result : result;
    }
}
