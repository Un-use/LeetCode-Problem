package com.unuse.p301_p350;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

/**
 * 给定一个非空的整数数组，返回其中出现频率前 k 高的元素。
 * 输入: nums = [1,1,1,2,2,3], k = 2
 * 输出: [1,2]
 */
public class P347_TopKFrequentElements {

	public static int[] topKFrequent(int[] nums, int k) {
		HashMap<Integer, Integer> map = new HashMap<>();
		int count;
		for (int num : nums) {
			count = map.computeIfAbsent(num, v -> 0);
			map.put(num, count + 1);
		}
		TreeMap<Integer, Integer> treeMap = new TreeMap<>();
		for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
			treeMap.put(entry.getValue(), entry.getKey());
		}
		int[] result = new int[k];
		int i = 0;
		for (int num : treeMap.keySet()) {
			result[i++] = num;
			if (i + 1 > k) {
				break;
			}
		}
		return result;
	}

	public static void main(String[] args) {
		int[] nums = {1};
		int[] result = topKFrequent(nums, 1);
		for (int num : result) {
			System.out.print(num + " ");
		}
	}

}
