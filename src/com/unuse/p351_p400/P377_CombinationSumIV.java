package com.unuse.p351_p400;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * @author Unuse
 * @date 2020/1/15
 */
public class P377_CombinationSumIV {

	// 动态规划 2ms
	public static int combinationSum4(int[] nums, int target) {
		int[] dp = new int[target + 1];
		dp[0] = 1;
		int sum = 0;
		while (sum <= target) {
			for (int num : nums) {
				if (sum - num >= 0) {
					dp[sum] += dp[sum - num];
				}
			}
			sum++;
		}

		return dp[target];
	}

	// 动态规划 8ms
	public static int combinationSum4_DP(int[] nums, int target) {
		if (nums.length == 0) {
			return 0;
		}
		List<Integer> numList = new ArrayList<>(nums.length);
		for (int num : nums) {
			numList.add(num);
		}
		Collections.sort(numList);
		int[] dp = new int[target + 1];
		int sum = 0;
		for (int num : numList) {
			if (target < num) {
				break;
			}
			dp[num] = 1;
		}
		while (sum <= target) {
			for (int num : numList) {
				if (sum - num < 0) {
					break;
				}
				dp[sum] += dp[sum - num];
			}
			sum++;
		}

		return dp[target];
	}

	// 暴力深搜 超时
	public static int combinationSum4_DeepSearch(int[] nums, int target) {
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
		int[] nums = {154,34,208,358,427,52,328,493,304,346,118,325,7,226,169,178,499,460,349,430,259,172,400,43,451,82,409,313,175,91,289,40,205,391,343,214,307,28,418,199,241,310,238,268,244,319,1,457,124,265,496,490,130,49,181,148,316,448,397,88,337,424,136,160,229,25,100,112,46,76,166,211,94,247,142,334,322,271,352,70,367,232,58,379,133,361,394,292,4,115,286,13,64,472,16,364,196,466,433,22,415,193,445,421,301,220,31,250,340,277,145,184,382,262,202,121,373,190,388,475,478,223,163,454,370,481,109,19,73,10,376,217,487,283,151,187,439,295,67,355,385,106,463,139,37,298,253,61,442,127,103,403,97,274,484,469,412,280,235,256,406,436,157,79,85,55};
		System.out.println(combinationSum4(nums, 50));
	}
}
