package com.unuse.p1_p50;

import java.util.*;

/**
 * 栈的压入、弹出序列
 *
 * @author Unuse
 * @date 2020/2/27
 */
public class P31_ValidateStackSequences {

	// 2ms 40.3MB
	public static boolean validateStackSequences(int[] pushed, int[] popped) {
		LinkedList<Integer> list = new LinkedList<>();
		int[] arrived = new int[1000];
		for (int push : pushed) {
			arrived[push] = 1;
		}
		int length = pushed.length;
		int curPushIndex = 0;
		for (int pop : popped) {
			if (arrived[pop] == 1) {
				for ( ; curPushIndex < length; curPushIndex++) {
					arrived[pushed[curPushIndex]] = 0;
					if (pushed[curPushIndex] == pop) {
						curPushIndex++;
						break;
					}
					list.push(pushed[curPushIndex]);
				}
			} else {
				if (list.pop() != pop) {
					return false;
				}
			}
		}

		return true;
	}

	// 4ms 40.3MB
	public static boolean validateStackSequences1(int[] pushed, int[] popped) {
		Stack<Integer> stack = new Stack<>();
		Map<Integer, Integer> pushedMap = new HashMap<>(popped.length);
		for (int push : pushed) {
			pushedMap.put(push, push);
		}
		int curPushIndex = 0;
		for (int pop : popped) {
			if (null != pushedMap.get(pop)) {
				for ( ; curPushIndex < pushed.length; curPushIndex++) {
					pushedMap.put(pushed[curPushIndex], null);
					if (pushed[curPushIndex] == pop) {
						curPushIndex++;
						break;
					}
					stack.push(pushed[curPushIndex]);
				}
			} else {
				if (stack.pop() != pop) {
					return false;
				}
			}
		}

		return true;
	}

	public static void main(String[] args) {
		int[] pushed = {1,2,3,4,5};
		int[] popped = {4,3,5,1,2};
		System.out.println(validateStackSequences(pushed, popped));
	}
}
