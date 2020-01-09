package com.unuse.p1_p50;

import java.util.List;

/**
 * @author Unuse
 * @date 2020/1/9
 */

public class P43_MultiplyStrings {

	// 5ms 37.2M
	public static String multiply(String num1, String num2) {
		if ("0".equals(num1) || "0".equals(num2)) {
			return "0";
		}

		int[] idxArr = new int[num1.length() + num2.length() + 1];
		int idx;
		for (int i = num1.length() - 1; i >= 0; i--) {
			idx = num1.length() - i - 1;
			for (int j = num2.length() - 1; j >= 0; j--) {
				idxArr[idx++] += (num2.charAt(j) - '0') * (num1.charAt(i) - '0');
			}
		}

		int num;
		for (int i = 0; i < idxArr.length; i++) {
			idx = 0;
			num = idxArr[i];
			idxArr[i] = 0;
			while (num > 0) {
				idxArr[i + idx] += num % 10;
				num /= 10;
				idx++;
			}
		}

		boolean addZero = false;
		StringBuilder result = new StringBuilder(num1.length() + num2.length());
		for (int i = idxArr.length - 1; i >= 0; i--) {
			if (addZero) {
				result.append(idxArr[i]);
			} else {
				if (idxArr[i] != 0) {
					result.append(idxArr[i]);
					addZero = true;
				}
			}
		}
		return result.toString();
	}

	public static void main(String[] args) {
		System.out.println(multiply("0", "0"));
	}


	// 8ms 36.7M
	public String multiply1(String num1, String num2) {
		if ("0".equals(num1) || "0".equals(num2)) {
			return "0";
		}
		int[] idxArr = new int[num1.length() + num2.length()];
		int idx;
		int mul;
		for (int i = num1.length() - 1; i >= 0; i--) {
			idx = num1.length() - i - 1;
			for (int j = num2.length() - 1; j >= 0; j--) {
				mul = (num2.charAt(j) - '0') * (num1.charAt(i) - '0');
				if (mul >= 10) {
					idxArr[idx] += mul % 10;
					idxArr[++idx] += mul / 10;
				} else {
					idxArr[idx++] += mul % 10;
				}
			}
		}

		StringBuilder result = new StringBuilder(num1.length() + num2.length());
		int num;
		for (int i = 0; i < idxArr.length; i++) {
			num = idxArr[i];
			result.append(num % 10);
			idxArr[i] = 0;
			idx = 0;
			while (num != 0) {
				idxArr[idx + i] += num % 10;
				num /= 10;
				idx++;
			}
		}
		result.reverse();
		for (idx = 0; idx < result.length(); idx++) {
			if (result.charAt(idx) != '0') {
				break;
			}
		}
		return result.substring(idx, result.length());
	}

}
