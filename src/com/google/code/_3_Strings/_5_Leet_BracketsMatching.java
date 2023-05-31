package com.google.code._3_Strings;

import java.util.Stack;

public class _5_Leet_BracketsMatching {
	public static void main(String[] args) {
		System.out.println("isvalid: " + isValid("()[]{}"));
		System.out.println("isvalid: " + isValid("([{}])"));

		System.out.println("isvalid: " + isValid("()[{}]"));

		System.out.println("isvalid: " + isValid("([}}])"));

	}

	public static boolean isValid(String s) {
		if (s.length() % 2 != 0 || s.length() == 0) {
			return false;
		}
		Stack<Character> stack = new Stack<Character>();
		for (int i = 0; i < s.length(); i++) {
			char x = s.charAt(i);

			if (x == '(' || x == '[' || x == '{') {
				stack.push(s.charAt(i));
				continue;
			}
			if (stack.isEmpty())
                return false;
			char peekChar = stack.peek();
			switch (x) {
				case ')':
					if('(' != peekChar) return false;
					break;
				case '}':
					if('{' != peekChar) return false;
					break;
				case ']':
					if('[' != peekChar) return false;
					break;
			}
			stack.pop();
		}
		if (stack.size() == 0) {
			return true;
		}
		return false;
	}
}
