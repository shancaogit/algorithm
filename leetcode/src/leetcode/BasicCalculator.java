package leetcode;

import java.util.Stack;

public class BasicCalculator {
	public int calculate(String s) {
		s = s.replace(" ", "");
		s = s.replace("	", "");
		byte[] expr = s.getBytes();
		Stack<String> stack = new Stack<String>();

		int i = 0;
		int numStartIdx = 0;
		while (i < expr.length) {
			switch (expr[i]) {
			case '(':
				stack.push("(");
				i++;
				numStartIdx = i;
				break;
			case ')':
				// items in stack: [******(n]
				String val = stack.pop();
				stack.pop();
				calc(stack, val);
				i++;
				numStartIdx = i;
				break;
			case '+':
				stack.push("+");
				i++;
				numStartIdx = i;
				break;
			case '-':
				stack.push("-");
				i++;
				numStartIdx = i;
				break;
			default:
				while (i < expr.length && expr[i] >= 48 && expr[i] <= 57) {
					i++;
				}
				calc(stack, s.substring(numStartIdx, i));
			}

		}
		int result = Integer.parseInt(stack.pop());
		// stack.clear(); // [((((((n], not necessary in Java
		return result;
	}

	public void calc(Stack<String> stack, String currentNum) {
		if (stack.isEmpty() || stack.peek().equals("(")) {
			stack.push(currentNum);
		} else {
			String operator = stack.pop();
			String preNum = stack.pop();
			if (operator.equals("+")) {
				stack.push(String.valueOf(Integer.parseInt(preNum) + Integer.parseInt(currentNum)));
			} else {
				stack.push(String.valueOf(Integer.parseInt(preNum) - Integer.parseInt(currentNum)));
			}
		}
	}
}
