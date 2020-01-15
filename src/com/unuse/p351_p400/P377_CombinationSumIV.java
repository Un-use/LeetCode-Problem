package com.unuse.p351_p400;

/**
 * @author Unuse
 * @date 2020/1/15
 */
public class P377_CombinationSumIV {

	// 暴力深搜 超时
	public static int combinationSum4(int[] nums, int target) {
		return combinationSum4(nums, 0, target);
	}

	private static int combinationSum4(int[] nums, int sum, int target) {
		int count = 0;
		int tempSum;
		for (int num : nums) {
			tempSum = sum + num;
			if (tempSum == target) {
				count++;
			} else if (tempSum < target) {
				count += combinationSum4(nums, tempSum, target);
			}
		}
		return count;
	}


	public static void main(String[] args) {
		int[] nums = {1, 2, 3};
		System.out.println(combinationSum4(nums, 4));
	}
}
