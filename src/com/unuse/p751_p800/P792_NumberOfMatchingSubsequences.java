package com.unuse.p751_p800;

import java.util.*;

/**
 * @author Unuse
 * @date 2019-08-19
 */
public class P792_NumberOfMatchingSubsequences {

	public static void main(String[] args) {
		String str = "abcde";
		String[] words = {"a", "acd", "aca", "ace"};

		System.out.println(numMatchingSubseq(str, words));
	}

	public static int numMatchingSubseq(String S, String[] words) {
		Map<Character, List<Integer>> charIndexListMap = new HashMap<>(32);
		List<Integer> charIndexList;
		for (int i = 0; i < S.length(); i++) {
			charIndexList = charIndexListMap.computeIfAbsent(S.charAt(i), v -> new ArrayList<>());
			charIndexList.add(i);
		}

		int count = 0;
		int pre;
		int cur;
		boolean small;
		boolean valid;
		for (String word : words) {
			pre = -1;
			valid = true;
			for (int i = word.length() - 1; i >= 0; i--) {
				charIndexList = charIndexListMap.get(word.charAt(i));
				if (null == charIndexList) {
					valid = false;
					break;
				}

				if (pre == -1) {
					pre = charIndexList.get(charIndexList.size() - 1);
				} else {
					small = false;
					for (int j = charIndexList.size() - 1; j >= 0; j--) {
						cur = charIndexList.get(j);
						if (cur < pre) {
							pre = cur;
							small = true;
							break;
						}
					}
					if (!small) {
						valid = false;
						break;
					}
				}
			}
			if (valid) {
				count++;
			}
		}

		return count;
	}

}
