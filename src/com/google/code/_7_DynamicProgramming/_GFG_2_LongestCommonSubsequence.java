	package com.google.code._7_DynamicProgramming;

public class _GFG_2_LongestCommonSubsequence {

    public static void main(String args[]) {
        String str1 = "cat";
        char[] strChar1 = str1.toCharArray();
        String str2 = "at";
        char[] strChar2 = str2.toCharArray();
        System.out.println(lcsRecursive(strChar1, strChar2, strChar1.length, strChar2.length));

        System.out.println(lcsDp(strChar1, strChar2, strChar1.length, strChar2.length));
    }

    private static int lcsRecursive(char[] str1, char[] str2, int m, int n) {
        if (m == 0 || n == 0)
            return 0;

        if (str1[m - 1] == str2[n - 1]) {
            return 1 + lcsRecursive(str1, str2, m - 1, n - 1);
        } else {
            return Math.max(lcsRecursive(str1, str2, m - 1, n), lcsRecursive(str1, str2, m, n - 1));
        }
    }

    private static int lcsDp(char[] str1, char[] str2, int m, int n) {
        int lcsMatrix[][] = new int[m + 1][n + 1];
        for (int i = 0; i <= m; i++) {
            for (int j = 0; j <= n; j++) {
                if (i == 0 || j == 0) {
                    lcsMatrix[i][j] = 0;
                } else if (str1[i - 1] == str2[j - 1]) {
                    lcsMatrix[i][j] = lcsMatrix[i - 1][j - 1] + 1;
                } else {
                    lcsMatrix[i][j] = Math.max(lcsMatrix[i - 1][j], lcsMatrix[i][j - 1]);
                }
            }
        }
        return lcsMatrix[m][n];
    }
}
