package com.google.code._3_Strings;

import java.util.HashMap;
import java.util.Map;

public class _2_Leet_NonRepeatingSubString {
	public static void main(String[] args) {
		lengthOfLongestSubstring();
	}
	
	
	// when the char  is found, we move the start, index + 1 steps of the found char.
	// maxLen is max of maxLen and index - start (of processing) + 1 (for including current char).
	public static void lengthOfLongestSubstring() {
		String s = "abcbyz";
		Map<Character, Integer> map = new HashMap<Character, Integer>();

		int maxLength = 0;
		int start = 0;
		for (int i = 0; i < s.length(); i++) {
			char c = s.charAt(i);
            if (map.containsKey(c)) {
                if (map.get(c) >= start) //imp: tets case dvdffdab
                    start = map.get(c) + 1;
            }
            maxLength = Math.max(maxLength, i-start+1);
            map.put(c, i);
		}

		
		System.out.println("Max lentgh: " + maxLength);
	}
}
