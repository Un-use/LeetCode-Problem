package com.unuse.p1_p50;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author Unuse
 * @date 2019-08-19
 */
public class P8_StringToInteger {


	public static void main(String[] args) {
		String str = "+1";
		System.out.println(myAtoi(str));
	}

	public static int myAtoi(String str) {
		int result = 0;
		str = str.trim();
		if (str.length() == 0) {
			return result;
		}

		StringBuilder sb = new StringBuilder();
		boolean isNegate = false;
		int i = 0;
		char c = str.charAt(0);
		if (c == '-') {
			i = 1;
			isNegate = true;
		}
		if (c == '+') {
			i = 1;
		}
		for (; i < str.length(); i++) {
			c = str.charAt(i);
			if (c >= '0' && c <= '9') {
				if (sb.length() == 0 && c == '0') {
					continue;
				}
				sb.append(c);
			} else {
				break;
			}
		}
		if (sb.length() != 0) {
			if (sb.length() > 10) {
				if (isNegate) {
					result = Integer.MIN_VALUE;
				} else {
					result = Integer.MAX_VALUE;
				}
			} else {
				long val = Long.parseLong(sb.toString());
				if (val > Integer.MAX_VALUE) {
					if (isNegate) {
						result = Integer.MIN_VALUE;
					} else {
						result = Integer.MAX_VALUE;
					}
				} else {
					result = (int) val;
					if (isNegate) {
						result = -result;
					}
				}
			}
		}
		return result;
	}
}
