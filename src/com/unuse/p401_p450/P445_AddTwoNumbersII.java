package com.unuse.p401_p450;

import java.util.ArrayList;
import java.util.List;

/**
 * 给你两个 非空 链表来代表两个非负整数。数字最高位位于链表开始位置。它们的每个节点只存储一位数字。将这两数相加会返回一个新的链表。
 *
 * 你可以假设除了数字 0 之外，这两个数字都不会以零开头。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/add-two-numbers-ii
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author Unuse
 * @date 2021/7/10
 */
public class P445_AddTwoNumbersII {


	static class ListNode {
	    int val;
	    ListNode next;
	    ListNode() {}
	    ListNode(int val) { this.val = val; }
	    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
	}

	public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
		List<Integer> num1List = getNumberList(l1);
		List<Integer> num2List = getNumberList(l2);
		int num1Index = num1List.size() - 1;
		int num2Index = num2List.size() - 1;

		List<Integer> list = new ArrayList<>(16);
		int front = 0;
		while (num1Index >= 0 || num2Index >= 0) {
			int curNum1 = 0;
			int curNum2 = 0;
			if (num1Index >= 0) {
				curNum1 = num1List.get(num1Index);
			}
			if (num2Index >= 0) {
				curNum2 = num2List.get(num2Index);
			}
			int curSum = curNum1 + curNum2 + front;
			list.add(curSum % 10);
			front = curSum / 10;
			num1Index--;
			num2Index--;
		}
		if (front > 0) {
			list.add(1);
		}
		int size = list.size();
		ListNode result = new ListNode(list.get(size - 1));
		ListNode next = result;
		for (int i = size - 2; i >= 0; i--) {
			next.next = new ListNode(list.get(i));
			next = next.next;
		}
		return result;
	}

	private List<Integer> getNumberList(ListNode l) {
		List<Integer> list = new ArrayList<>(16);
		while (l != null) {
			list.add(l.val);
			l = l.next;
		}
		return list;
	}

	public static void main(String[] args) {
		P445_AddTwoNumbersII addTwoNumbersII = new P445_AddTwoNumbersII();

		ListNode l1 = new ListNode(7);
		l1.next = new ListNode(2);
		l1.next.next = new ListNode(4);
		l1.next.next.next = new ListNode(3);

		ListNode l2 = new ListNode(0);
		l2.next = new ListNode(6);
		l2.next.next = new ListNode(4);

		System.out.println(addTwoNumbersII.addTwoNumbers(l1, l2));
	}
}
