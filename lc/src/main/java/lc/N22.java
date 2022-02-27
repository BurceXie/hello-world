package lc;

import java.util.*;

/**
 * 22. 括号生成(2)
 * https://leetcode-cn.com/problems/generate-parentheses/
 */
public class N22 {

	public static void main(String[] args) {
		Solution s = new Solution();

		for (int i = 1; i <= 8; i++) {
			List<String> l = s.generateParenthesis(i);
			System.out.println(l.size());
			System.out.println(l);
		}
	}

	static class Solution {
		public List<String> generateParenthesis(int n) {
			List<String> list = new ArrayList<>();
			list.add("(");
			doRight(list, n, 1, 0);

			return list;
		}

		private List<String> doRight(List<String> leftList, int n, int lCount, int rCount) {
			if (rCount == n) {
				return leftList;
			}
			if (lCount == n) {
				String rightStr = "))))))))".substring(rCount, n);

				for (int i = 0; i < leftList.size(); i++) {
					leftList.set(i, leftList.get(i) + rightStr);
				}

				return leftList;
			}

			List<String> leftList1 = new ArrayList<>(), leftList2 = new ArrayList<>();
			for (String leftStr : leftList) {
				leftList1.add(leftStr + "(");
				leftList2.add(leftStr + ")");
			}

			leftList.clear();
			leftList.addAll(doRight(leftList1, n, lCount + 1, rCount));
			if (rCount < lCount) {
				leftList.addAll(doRight(leftList2, n, lCount, rCount + 1));
			}

			return leftList;
		}
	}
}
