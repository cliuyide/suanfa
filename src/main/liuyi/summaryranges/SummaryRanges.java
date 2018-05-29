package main.liuyi.summaryranges;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * https://leetcode-cn.com/problems/summary-ranges/description/
 */
public class SummaryRanges {
	public static void main(String[] args) {
		new SummaryRanges().summaryRanges(new int[] { 0, 1, 2, 4, 5, 7 });
	}

	public List<String> summaryRanges(int[] nums) {
		List<String> result = new ArrayList<>();
		if (nums.length == 0) {
			return result;
		}
		Stack<Integer> stack = new Stack<>();
		for (int i = 0; i < nums.length; i++) {
			if (stack.isEmpty() || nums[i] == stack.peek() + 1) {
				stack.push(nums[i]);
				continue;
			}
			if (stack.size() == 1) {
				result.add(new String(stack.pop() + ""));
			} else {
				result.add(new String(stack.firstElement() + "->" + stack.pop()));
			}
			stack.clear();
			stack.add(nums[i]);
		}
		if (stack.size() == 1) {
			result.add(new String(stack.pop() + ""));
		} else {
			result.add(new String(stack.firstElement() + "->" + stack.pop()));
		}
		return result;
	}
}
