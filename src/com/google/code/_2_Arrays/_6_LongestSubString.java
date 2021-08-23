package com.google.code._2_Arrays;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeSet;

public class _6_LongestSubString {
	public static void main(String[] args) {
		System.out.println(lengthOfLongestSubstring("abcabcbb"));
	}

	public static int lengthOfLongestSubstring(String s) {

		Map<Character, Integer> map = new HashMap<Character, Integer>();

		int maxLength = 0;
		int start = 0;
		for (int i = 0; i < s.length(); i++) {
			char c = s.charAt(i);
			if (map.containsKey(c)) {
				// imp: tets case dvdffdab
				if (map.get(c) >= start)
					start = map.get(c) + 1;
//				System.out.println("Start: " + start);
			}
			maxLength = Math.max(maxLength, i - start + 1);
			map.put(c, i);
		}
		return maxLength;
	}

}
