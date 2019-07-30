package com.unuse.p451_p500;

/**
 * 汉明距离
 *
 * @author Unuse
 * @date 2019-07-30
 */
public class P461_HammingDistance {

	public static void main(String[] args) {
		System.out.println(hammingDistance(10, 4));
	}

	public static int hammingDistance(int x, int y) {
		int distance = 0;
		while (x != 0 || y != 0) {
			int bitX = x % 2;
			int bitY = y % 2;
			if (bitX != bitY) {
				distance++;
			}
			x /= 2;
			y /= 2;
		}
		return distance;
	}


}
