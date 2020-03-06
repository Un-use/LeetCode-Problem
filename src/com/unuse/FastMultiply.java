package com.unuse;

/**
 * 快速幂方法
 *
 * x^n = (x^(n/2))^2 当n为偶数
 * x^n = x * (x^((n-1)/2))^2 当n为奇数
 * 例如：
 * x^13 = ((x^2 * x)^2)^2 * x
 * x 1101 = (((x^1)^2 * x^1)^2 * x^0)^2 * x^1
 * @author Unuse
 * @date 2020/3/6
 */
public class FastMultiply {

	public static int fastMultiply(int x, int n) {
		if (n == 0) {
			return 1;
		}
		if (n == 1) {
			return x;
		}
		int y = fastMultiply(x, n >> 1);
		y = y * y;
		if ((n & 1) == 1) {
			y = y * x;
		}
		return y;
	}

	public static void main(String[] args) {
		long start = System.currentTimeMillis();
		System.out.println(fastMultiply(2, 30));
		long end = System.currentTimeMillis();
		System.out.println(end - start);

		start = System.currentTimeMillis();
		System.out.println(Math.pow(2f, 30f));
		end = System.currentTimeMillis();
		System.out.println(end - start);
	}

}
