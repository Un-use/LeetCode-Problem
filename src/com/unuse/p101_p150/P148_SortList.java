package com.unuse.p101_p150;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @author Unuse
 * @date 2019/12/19
 */
public class P148_SortList {

	static class ListNode {
	   	int val;
	   	ListNode next;
	    ListNode(int x) { val = x; }
	}

	public static ListNode sortList(ListNode head) {
		List<Integer> list = new ArrayList<>(128);
		ListNode temp = head;
		while (temp != null) {
			list.add(temp.val);
			temp = temp.next;
		}
		ListNode[] arr = new ListNode[list.size()];
		quickSort(list.toArray(arr), 0, list.size());
		temp = head;
		int i = 0;
		while (temp != null) {
			temp.val = arr[i++].val;
			temp = temp.next;
		}
		return head;
	}

	public static void quickSort(ListNode[] arr, int left, int right) {
		ListNode curNode = arr[left];
		int nLeft = left + 1;
		int nRight = right;
		boolean isLeft = true;
		ListNode temp;
		while (nLeft <= nRight) {
			if (isLeft && arr[nLeft].val < curNode.val) {
				temp = arr[nLeft];
				arr[nLeft] = curNode;
				curNode = temp;
				isLeft = false;
				nLeft++;
			}
			if (!isLeft && arr[nRight].val < curNode.val) {
				temp = arr[nRight];
				arr[nRight] = curNode;
				curNode = temp;
				isLeft = true;
				nRight--;
			}
		};
		quickSort(arr, left, nLeft);
		quickSort(arr, nLeft + 1, right);
	}

	public static void main(String[] args) {
		ListNode head = new ListNode(-1);
		head.next = new ListNode(5);
		head.next.next = new ListNode(3);
		head.next.next.next = new ListNode(4);
		head.next.next.next.next = new ListNode(0);
		head = sortList(head);
		while (head != null) {
			System.out.print(head.val + " ");
			head = head.next;
		}
	}


}
