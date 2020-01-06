package com.unuse.p1201_p1250;

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
		int[] tempArr = new int[4];
		for (int i = 0; i < 4 ; i++) {
			if (arr[i] > singleCount) {
				arr[i] -= singleCount;
			} else {
				arr[i] = 0;
			}
			minLength += arr[i];
			tempArr[i] = arr[i];
		}
		if (minLength == 0) {
			return 0;
		}

		int result = s.length();
		int left = 0, right = 0;
		boolean needBreak = false;
		while (right < s.length()) {
			if (arr[0] == 0) {
				tempArr[0] = 0;
			}
			if (arr[1] == 0) {
				tempArr[1] = 0;
			}
			if (arr[2] == 0) {
				tempArr[2] = 0;
			}
			if (arr[3] == 0) {
				tempArr[3] = 0;
			}
			while (tempArr[0] > 0 || tempArr[1] > 0 || tempArr[2] > 0 || tempArr[3] > 0) {
				if (right == s.length()) {
					needBreak = true;
					break;
				}
				switch (s.charAt(right++)) {
					case 'Q':
						tempArr[0]--;
						break;
					case 'W':
						tempArr[1]--;
						break;
					case 'E':
						tempArr[2]--;
						break;
					case 'R':
						tempArr[3]--;
						break;
					default:
				}
			}
			if (needBreak) {
				break;
			}

			if (right - left < result) {
				result = right - left;
			}

			int index;
			while (true) {
				c = s.charAt(left++);
				if ('Q' == c) {
					index = 0;
				} else if ('W' == c) {
					index = 1;
				} else if ('E' == c) {
					index = 2;
				} else {
					index = 3;
				}
				if (arr[index] > 0 && ++tempArr[index] > 0) {
					break;
				}
			}

			if (right - left + 1 < result) {
				result = right - left + 1;
			}
		}

		return result;
	}

	public static void main(String[] args) {
		System.out.println(balancedString("QQQQ"));
	}

}
