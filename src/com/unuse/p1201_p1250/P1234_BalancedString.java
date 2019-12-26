package com.unuse.p1201_p1250;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Unuse
 * @date 2019/12/25
 */
public class P1234_BalancedString {

	public static int balancedString(String s) {
		int[] arr = new int[4];
		char c;
		for (int i = 0; i < s.length(); i++) {
			c = s.charAt(i);
			switch (c) {
				case 'Q':
					arr[0]++;
					break;
				case 'W':
					arr[1]++;
					break;
				case 'E':
					arr[2]++;
					break;
				case 'R':
					arr[3]++;
					break;
				default:
			}
		}
		int singleCount = s.length() / 4;
		int minLength = 0;
		for (int i : arr) {
			if (arr[i] > singleCount) {
				arr[i] -= singleCount;
				minLength += arr[i];
			} else {
				arr[i] = 0;
			}
		}


	}

	public static void main(String[] args) {
		System.out.println(balancedString("WWEQERQWQWWRWWERQWEQ"));
	}

}
