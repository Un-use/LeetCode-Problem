package com.unuse.p1251_p1300;

/**
 * p1286 优化时间复杂度（1.减少逻辑运算 2.减少对象生成）
 * @author Unuse
 * @date 2020/2/12
 */
public class P1286_CombinationIterator {
	private char[] characters;
	private int[] charIndexes;

	public P1286_CombinationIterator(String characters, int combinationLength) {
		this.characters = characters.toCharArray();
		this.charIndexes = new int[combinationLength];
		for (int i = 0; i < combinationLength; i++) {
			this.charIndexes[i] = i;
		}
	}

	// 8ms 39M
	public String next() {
		StringBuilder sb = new StringBuilder();
		for (int index : charIndexes) {
			sb.append(characters[index]);
		}

		int charIndexLength = charIndexes.length;
		int characterIndexLength = characters.length - 1;
		int count = 0;
		int charIndex = charIndexLength - 1;
		for (int i = charIndexLength - 1; i >= 0; i--) {
			if (charIndexes[i] != characterIndexLength - count++) {
				charIndex = i;
				break;
			}
		}
		charIndexes[charIndex]++;
		count = 1;
		for (int i = charIndex + 1; i < charIndexLength; i++) {
			charIndexes[i] = charIndexes[charIndex] + count++;
		}

		return sb.toString();
	}

	public boolean hasNext() {
		return charIndexes[charIndexes.length - 1] <= characters.length - 1 || charIndexes[0] < characters.length - charIndexes.length;
	}


	public static void main(String[] args) {
		P1286_CombinationIterator iterator = new P1286_CombinationIterator("abc", 1);
		System.out.println(iterator.next());
		System.out.println(iterator.hasNext());
		System.out.println(iterator.hasNext());
		System.out.println(iterator.hasNext());
		System.out.println(iterator.next());
		System.out.println(iterator.hasNext());
		System.out.println(iterator.hasNext());
		System.out.println(iterator.next());
		System.out.println(iterator.hasNext());
		System.out.println(iterator.hasNext());
	}
}
