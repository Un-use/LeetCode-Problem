package com.unuse;

/**
 * @author Unuse
 * @date 2019/12/20
 */
public class Sort {


	public static void quickSort(int[] arr, int low, int height) {
		if (low >= height) {
			return;
		}
		int left = low;
		int right = height;
		int val = arr[left];
		while (left < right) {
			while (left < right && val <= arr[right]) {
				right--;
			}
			arr[left] = arr[right];
			while (left < right && val >= arr[left]) {
				left++;
			}
			arr[right] = arr[left];
		}
		arr[left] = val;
		quickSort(arr, low, left - 1);
		quickSort(arr, left + 1, height);
	}

	public static void mergeSort(int[] arr, int low, int height) {

	}

	public static void main(String[] args) {
		int[] arr = {234, 34, 2, 44, 53, 22, 12, 53, 883, 129};
		quickSort(arr, 0, arr.length - 1);
		for (int i : arr) {
			System.out.print(i + " ");
		}
	}

}
