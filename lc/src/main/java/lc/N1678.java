package lc;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 *1678. 设计 Goal 解析器(1)
 *https://leetcode-cn.com/problems/goal-parser-interpretation/
 */
public class N1678 {

	public static void main(String[] args) {
		Solution s = new N1678().new Solution();

		System.out.println(s);
	}

class Solution {
	public String interpret(String command) {
		if (command.contains("()")) {
			command = command.replace("()", "o");
		}
		if (command.contains("(al)")) {
			command = command.replace("(al)", "al");
		}
		return command;
	}
}
}

