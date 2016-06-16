package leetcode;

import java.util.Stack;

/**
 * push(x) -- Push element x onto stack. <br>
 * pop() -- Removes the element on top of the stack. <br>
 * top() -- Get the top element. <br>
 * getMin() -- Retrieve the minimum element in the stack.
 */

public class MinStack {
	Stack<Integer> stack = null;
	Stack<Integer> min = null;

	public MinStack() {
		stack = new Stack<Integer>();
		min = new Stack<Integer>();
	}

	public void push(int x) {
		stack.push(x);
		if (min.isEmpty()) {
			min.push(x);
		} else {
			if (min.peek() >= x) {
				min.push(x);
			}
		}
	}

	public void pop() {
		int x = stack.pop();
		if (min.peek() == x) {
			min.pop();
		}
	}

	public int top() {
		return stack.peek();
	}

	public int getMin() {
		return min.peek();
	}
}
