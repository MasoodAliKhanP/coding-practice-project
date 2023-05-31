package com.google.code._3_Strings;

public class _8_Strings {
	public static void main(String[] args) {
		String[] arr1 = { "a", "bc" };
		String[] arr2 = { "ab", "c" };
//		System.out.println("equals: " + arrayStringsAreEqual(arr1, arr2));
//		System.out.println("equals: " + arrayStringsAreEqual2(arr1, arr2));
		System.out.println("almost equal: " + areAlmostEqual("acb", "cat"));
	}

	public static boolean arrayStringsAreEqual(String[] word1, String[] word2) {
		StringBuilder sb = new StringBuilder();
		for (String str : word1) {
			sb.append(str);
		}
		StringBuilder sb2 = new StringBuilder();
		for (String str : word2) {
			sb2.append(str);
		}
		System.out.println("sb: " + sb + " sb2: " + sb2);
//        return sb.compareTo(sb2)==0;
		return sb.toString().equals(sb2.toString());
	}

	public static boolean arrayStringsAreEqual2(String[] word1, String[] word2) {
		return String.join("", word1).equals(String.join("", word2));
	}

	public static boolean areAlmostEqual(String s1, String s2) {
		if(s1.length() != s2.length()) {
			return false;
		}
		if(s1.equals(s2))
			return true;
		
		int swapIndex = Integer.MAX_VALUE;

		for(int i = 0; i < s1.length(); i++) {
			if(s1.charAt(i) != s2.charAt(i)) {
				if(swapIndex == Integer.MAX_VALUE) {
					swapIndex = i;
				}else {
					String swapStr = swap(s1, swapIndex, i);
					return swapStr.equals(s2);
				}
			}
		}
		
		return false;
	}
	
	static String swap(String str, int i, int j)
    {
        char ch[] = str.toCharArray();
        char temp = ch[i];
        ch[i] = ch[j];
        ch[j] = temp;
        return new String(ch);
    }
}
