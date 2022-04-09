package com.google.code._3_Strings;

public class _1_7Dot1_StringToInteger {
    public static void main(String args[]) {
        String str = "" + 3;
        StringBuilder sb = new StringBuilder();
        sb.append('x');
        System.out.println(sb);

        String s = "123333";
        System.out.println(stringtoInt(s));
    }

    private static int stringtoInt(String s) {
        int digit;
        int result = 0;
        //Need to handle integer over flow 2^31 = 2 billion
        if(s.length() > 9) {
        	
        }
        
        //or below comments of handling other ways
        if (s.charAt(0) == '-') {
            s = s.substring(1);
        }
        for (int i = 0; i < s.length(); i++) {
            digit = s.charAt(i) - '0';
            result = result * 10 + digit;
            //take result as long and check it with Integer.MAX_VALUE / 10
            // to check for last num check with Integer.MAX_VALUE % 10;
        }
        return s.charAt(0) == '-' ? -result : result;
    }
}
