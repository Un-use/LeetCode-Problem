package com.unuse.p501_o550;

/**
 * 斐波那契数列
 *
 * @author Unuse
 * @date 2020/3/6
 */
public class P509_FibonacciSeq {

	/**
	 * O(n)
	 */
	public static int fSeq1(int n) {
		if (n < 2) {
			return n;
		}
		int f = 0;
		int f1 = 1;
		int f2 = 0;
		for (int i = 2; i <= n; i++) {
			f = f1 + f2;
			f2 = f1;
			f1 = f;
		}
		return f;
	}


	/**
	 * 矩阵乘法 O(log(n))
	 * | f(n) | = |1 1|^n-1 * |f(1)|
	 * |f(n-1)|   |1 0|	      |f(2)|
	 */
	public static int fSeq2(int n) {
		if (n < 2) {
			return n;
		}
		int[][] a = {{1, 1}, {1, 0}};
		return fastMultiply(a, n - 1)[0][0];
	}

	public static int[][] fastMultiply(int[][] x, int n) {
		if (n == 0) {
			return new int[][]{{1, 0}, {0, 1}};
		}
		int[][] r = fastMultiply(x, n >> 1);
		r = matrixMultiply(r, r);
		if ((n & 1) == 1) {
			r = matrixMultiply(r, x);
		}
		return r;
	}

	public static int[][] matrixMultiply(int[][] x, int[][] y) {
		return new int[][] {
				{
					x[0][0] * y[0][0] + x[0][1] * y[1][0],
					x[0][0] * y[0][1] + x[0][1] * y[1][1]
				},
				{
					x[1][0] * y[0][0] + x[1][1] * y[1][0],
					x[1][0] * y[0][1] + x[1][1] * y[1][1]
				}
		};
	}



	public static void main(String[] args) {
		long start = System.currentTimeMillis();
		System.out.println(fSeq1(15));
		long end = System.currentTimeMillis();
		System.out.println(end - start);

		start = System.currentTimeMillis();
		System.out.println(fSeq2(15));
		end = System.currentTimeMillis();
		System.out.println(end - start);
	}



}
