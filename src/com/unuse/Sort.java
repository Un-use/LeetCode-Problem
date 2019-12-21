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
		if (low == height) {
			return;
		}

		int mid = low + ((height - low) >> 1);
		mergeSort(arr, low, mid);
		mergeSort(arr, mid + 1, height);
		merge(arr, low, mid, height);
	}

	private static void merge(int[] arr, int low, int mid, int height) {
		int[] temp = new int[height - low + 1];
		int i = low, j = mid + 1;
		int n = mid, m = height;
		int k = 0;
		while (i <= n && j <= m) {
			if (arr[i] < arr[j]) {
				temp[k++] = arr[i++];
			} else {
				temp[k++] = arr[j++];
			}
		}
		while (i <= n) {
			temp[k++] = arr[i++];
		}
		while (j <= m) {
			temp[k++] = arr[j++];
		}
		for (i = 0; i < temp.length; i++) {
			arr[low + i] = temp[i];
		}
	}

	public static void mergeSortFor(int[] arr, int low, int height) {
		int cut = 1;
		while (cut < arr.length) {
			cut *= 2;
			for (int i = 0; i < arr.length; i += cut) {
				int min = Math.min(i + cut, arr.length);
				merge(arr, i, (i + min - 1) / 2, min - 1);
			}
		}
	}

	public static void main(String[] args) {
		int[] arr = {234, 34, 2, 44, 53, 22, 12, 53, 883, 129};
		mergeSortFor(arr, 0, arr.length - 1);
		for (int i : arr) {
			System.out.print(i + " ");
		}
	}

}
