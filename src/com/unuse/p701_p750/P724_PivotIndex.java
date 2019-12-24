package com.unuse.p701_p750;

/**
 * @author Unuse
 * @date 2019/12/24
 */
public class P724_PivotIndex {

	public static int pivotIndex(int[] nums) {
		if (nums.length == 0) {
			return -1;
		}
		int length = nums.length;
		int[] sums = new int[length+2];
		sums[1] = nums[0];
		for (int i = 2; i <= length; i++) {
			sums[i] = sums[i-1] + nums[i - 1];
		}
		sums[length+1] = sums[length];
		for (int i = 1; i <= length; i++) {
			if (sums[i-1] == sums[length+1] - sums[i]) {
				return i - 1;
			}
		}
		return -1;
	}


	public static void main(String[] args) {
		int[] arr = {1};
		System.out.println(pivotIndex(arr));
	}

}
