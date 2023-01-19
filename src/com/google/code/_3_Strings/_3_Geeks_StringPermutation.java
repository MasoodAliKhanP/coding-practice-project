package com.google.code._3_Strings;

//#Paysafe
public class _3_Geeks_StringPermutation {
	public static void main(String[] args) {
		stringPermuation("abc", "");
	}
	
	public static void stringPermuation(String s, String ans) {
		if(s.length() ==0)
			System.out.println(ans);
		for(int i=0; i < s.length(); i++) {
			char c = s.charAt(i);
			String restStr = s.substring(0, i) + s.substring(i+1);
			stringPermuation(restStr, ans+c);
		}
	}
}
