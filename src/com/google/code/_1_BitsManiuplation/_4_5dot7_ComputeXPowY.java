package com.google.code._1_BitsManiuplation;

public class _4_5dot7_ComputeXPowY {
    public static void main(String args[]) {
        System.out.println(power(2, -2));
        System.out.println(power(3, 3));
        System.out.println("power: " + power(2.5, 7));

        System.out.println(pow2(2, -2));
        System.out.println(pow2(3, 3));
        System.out.println(pow2(2.5, 2));
        
        System.out.println(pow2rec(3, 3));
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
//            if ((pow & 1) != 0) {
//                result = result * x;
//            }
            if(pow%2==1) {
            	result *= x;
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
    
//    O(n), O(n)
    private static double pow2rec(double x, double y) {
    	if(y==0) {
    		return 1;
    	}
    	return x * pow2rec(x, y-1);
    }
    
//    O(log n), O(log n)
    private static int power(int x, int y)
    {
        int temp;
        if (y == 0)
            return 1;
        temp = power(x, y / 2);
        if (y % 2 == 0)
            return temp * temp;
        else
            return x * temp * temp;
    }
}
