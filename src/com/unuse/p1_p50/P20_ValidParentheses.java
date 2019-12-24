package com.unuse.p1_p50;

import java.util.Stack;

/**
 * @author Unuse
 * @date 2019/12/23
 */
public class P20_ValidParentheses {


	public static boolean isValid(String s) {
		if (s.length() == 0) {
			return true;
		}
		char c;
		Stack<Integer> stack = new Stack<>();
		for (int i = 0; i < s.length(); i++) {
			c = s.charAt(i);
			switch (c) {
				case '(':
					stack.push(1);
					break;
				case '{':
					stack.push(2);
					break;
				case '[':
					stack.push(3);
					break;
				case ')':
					if (stack.isEmpty() || 1 != stack.pop()) {
						return false;
					}
					break;
				case '}':
					if (stack.isEmpty() || 2 != stack.pop()) {
						return false;
					}
					break;
				case ']':
					if (stack.isEmpty() || 3 != stack.pop()) {
						return false;
					}
					break;
				default:
			}
		}
		return stack.isEmpty();
	}

	public static void main(String[] args) {
		System.out.println(isValid("()"));
	}
}
