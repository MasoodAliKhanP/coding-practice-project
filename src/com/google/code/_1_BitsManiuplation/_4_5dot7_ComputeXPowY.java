package com.google.code._1_BitsManiuplation;

public class _4_5dot7_ComputeXPowY {
    public static void main(String args[]) {
        System.out.println(power(2, -2));
        System.out.println(power(3, 3));
        System.out.println(power(2.5, 2));

        System.out.println(pow2(2, -2));
        System.out.println(pow2(3, 3));
        System.out.println(pow2(2.5, 2));
    }

    // O(logn) - as we are shifting pow
    public static double power(double x, int y) {
        double result = 1.0;
        long pow = y;
        if (y < 0) {
            x = 1 / x;
            pow = -pow;
        }
        System.out.println("x: " + x + " || pow: " + pow);
        while (pow != 0) {
            if ((pow & 1) != 0) {
                result = result * x;
            }
            x = x * x;
            pow = pow >>> 1;
        }
        return result;
    }

    // O(n) as we are decrementing y.
    public static double pow2(double x, int y) {
        double result = 1.0;

        if (y < 0) {
            y = -y;
            x = 1 / x;
        }
        while (y != 0) {
            result *= x;
            y--;
        }
        return result;
    }
}
