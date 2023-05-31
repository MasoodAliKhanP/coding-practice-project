package com.google.code._3_Strings;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class _7_Leet_Anagram {
	public static void main(String[] args) {
		System.out.println("Is anagram: " + isAnagram("rat", "art"));
		System.out.println("Is anagram 2: " + isAnagram2("anagram", "nagaram"));
		System.out.println("Is anagram 3: " + isAnagram3("anagram", "nagaram"));
	}
	
	private static boolean isAnagram(String s, String t) {
		char[] sChars = s.toCharArray();
		char[] tChars = t.toCharArray();
		Arrays.sort(sChars); Arrays.sort(tChars);
		return Arrays.equals(sChars, tChars);
	}
	
	private static boolean isAnagram2(String s, String t) {
		if(s.length() != t.length())
			return false;
		
		Map<Character, Integer> charMap = new HashMap<>();
		for(Character c : s.toCharArray()) {
			charMap.put(c, charMap.getOrDefault(c, 0) + 1);
		}
//		System.out.println("char map: " + charMap);
		for(Character c : t.toCharArray()) {
			charMap.put(c, charMap.getOrDefault(c, 0)-1);
			if(charMap.get(c) < 0) {
				return false;
			}
		}
		return true;
	}
	
	private static boolean isAnagram3(String s,  String t) {
		if(s.length() != t.length())
			return false;
		
		int[] charCount = new int[26];
		for(int i = 0; i < s.length(); i++) {
			charCount[s.charAt(i) - 'a']++;
			charCount[t.charAt(i) - 'a']--;
		}
		
		for(int i = 0; i < 26; i++) {
			if(charCount[i] != 0)
				return false;
		}
		
		return true;
	}
}













