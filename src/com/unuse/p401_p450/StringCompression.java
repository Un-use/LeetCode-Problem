package com.unuse.p401_p450;

/**
 * @author Unuse
 * @date 2019/12/19
 */
public class StringCompression {

	/**
	 * 2ms 38.2M
	 */
	public static int compress(char[] chars) {
		if (chars.length <= 1) {
			return chars.length;
		}
		StringBuilder sb = new StringBuilder();
		int sameCharCount = 1;
		int length = chars.length;
		for (int i = 0; i < length - 1; i++) {
			while (i < length - 1 && chars[i] == chars[i+1]) {
				sameCharCount++;
				i++;
			}
			sb.append(chars[i]);
			if (sameCharCount != 1) {
				sb.append(sameCharCount);
			}
			sameCharCount = 1;
		}
		if (chars[length - 1] != chars[length - 2]) {
			sb.append(chars[length - 1]);
		}
		for (int i = 0; i < sb.length(); i++) {
			chars[i] = sb.charAt(i);
		}
		return sb.length();
	}

	/**
	 * 1ms 38.1M
	 */
	public int compress1(char[] chars) {
		if (chars.length <= 1) {
			return chars.length;
		}
		int length = 1;
		int sameCharCount = 1;
		for (int i = 1; i < chars.length; i++) {
			if (chars[i] == chars[i-1]) {
				sameCharCount++;
			} else {
				chars[length - 1] = chars[i-1];
				if (sameCharCount >= 1000) {
					chars[length + 3] = (char) (sameCharCount % 10 + 48);
					sameCharCount /= 10;
					chars[length + 2] = (char) (sameCharCount % 10 + 48);
					sameCharCount /= 10;
					chars[length + 1] = (char) (sameCharCount % 10 + 48);
					sameCharCount /= 10;
					chars[length] = (char) (sameCharCount % 10 + 48);
					length += 4;
				} else if (sameCharCount >= 100) {
					chars[length + 2] = (char) (sameCharCount % 10 + 48);
					sameCharCount /= 10;
					chars[length + 1] = (char) (sameCharCount % 10 + 48);
					sameCharCount /= 10;
					chars[length] = (char) (sameCharCount % 10 + 48);
					length += 3;
				} else if (sameCharCount >= 10) {
					chars[length + 1] = (char) (sameCharCount % 10 + 48);
					sameCharCount /= 10;
					chars[length] = (char) (sameCharCount % 10 + 48);
					length += 2;
				} else if (sameCharCount != 1) {
					chars[length] = (char) (sameCharCount % 10 + 48);
					length += 1;
				}
				length++;
				sameCharCount = 1;
			}
		}
		chars[length - 1] = chars[chars.length-1];
		if (chars[chars.length - 1] == chars[chars.length - 2]) {
			if (sameCharCount >= 1000) {
				chars[length + 3] = (char) (sameCharCount % 10 + 48);
				sameCharCount /= 10;
				chars[length + 2] = (char) (sameCharCount % 10 + 48);
				sameCharCount /= 10;
				chars[length + 1] = (char) (sameCharCount % 10 + 48);
				sameCharCount /= 10;
				chars[length] = (char) (sameCharCount % 10 + 48);
				length += 4;
			} else if (sameCharCount >= 100) {
				chars[length + 2] = (char) (sameCharCount % 10 + 48);
				sameCharCount /= 10;
				chars[length + 1] = (char) (sameCharCount % 10 + 48);
				sameCharCount /= 10;
				chars[length] = (char) (sameCharCount % 10 + 48);
				length += 3;
			} else if (sameCharCount >= 10) {
				chars[length + 1] = (char) (sameCharCount % 10 + 48);
				sameCharCount /= 10;
				chars[length] = (char) (sameCharCount % 10 + 48);
				length += 2;
			} else if (sameCharCount != 1) {
				chars[length] = (char) (sameCharCount % 10 + 48);
				length += 1;
			}
		}
		return length;
	}

	public static void main(String[] args) {
		char[] chars = {'a','a','b','b','c','c','c','c','c','c','c','c','c','c','c','c','c','c','c','c','c','c','c','c','c','c','c','c','c','c','c','c','c','c','c','c','c','c','c','c','c','c','c','c','c','c','c','c','c','c','c','c','c','c','c','c','c','c','c','c','c','c','c','c','c','c','c','c','c','c','c','c','c','c','c','c','c','c','c','c','c','c','c','c','c','c','c','c','c','c','c','c','c','c','c','c','c','c','c','c','c','c','c','c','c','c','c','c','c','c','c','c','c','c','c','c','c','c','c','c','c','c','c','c','c','c','c','c','c','c','c','c','c','c','c','c','c','c','c','c','c','c','c','c','c','c','c','c','c','c','c','c','c','c','c','c','c','c','c','c','c','c','c','c','c','c','c','c','c','c','c','c','c','c','c','c','c','c','c','c','c','c','c','c','c','c','c','c','c','c','c','c','c','c','c','c','c','c','c','c','c','c','c','c','c','c','c','c','c','c','c','c','c','c','c','c','c','c','c','c','d','d','d','d','d','d','d','d','d','d','d','d'};
		System.out.println(chars.length);
		int length = compress(chars);
		for (int i = 0; i < length; i++) {
			System.out.print(chars[i] + " ");
		}
	}

}
