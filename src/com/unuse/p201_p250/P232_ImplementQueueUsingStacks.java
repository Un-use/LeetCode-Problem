package com.unuse.p201_p250;

import java.util.Stack;

/**
 * @author Unuse
 * @date 2019/12/23
 */
public class P232_ImplementQueueUsingStacks {


	private Stack<Integer> stack1 = new Stack<>();
	private Stack<Integer> stack2 = new Stack<>();

	public void push(int x) {
		stack1.push(x);
	}

	/** Removes the element from in front of queue and returns that element. */
	public int pop() {
		if (stack2.isEmpty()) {
			while (!stack1.isEmpty()) {
				stack2.push(stack1.pop());
			}
		}
		if (stack2.isEmpty()) {
			return -1;
		}
		return stack2.pop();
	}

	/** Get the front element. */
	public int peek() {
		if (stack2.isEmpty()) {
			while (!stack1.isEmpty()) {
				stack2.push(stack1.pop());
			}
		}
		if (stack2.isEmpty()) {
			return -1;
		}
		return stack2.peek();
	}

	/** Returns whether the queue is empty. */
	public boolean empty() {
		return stack1.isEmpty() && stack2.isEmpty();
	}
}
