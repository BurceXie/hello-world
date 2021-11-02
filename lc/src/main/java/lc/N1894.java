package lc;

import java.util.Arrays;

/**
 * 1894. 找到需要补充粉笔的学生编号(2)
 * https://leetcode-cn.com/problems/find-the-student-that-will-replace-the-chalk/
 */
public class N1894 {

	public static void main(String[] args) {
		Solution s = new N1894().new Solution();

		System.out.println(s);
	}

class Solution {
	public int chalkReplacer(int[] chalk, int k) {
		int i = 0;
		if (chalk.length == 1) {
			return i;
		}

		int sum = 0;
		for (int c: chalk) {
			sum += c;
			if (sum > k) {
				break;
			}
		}
		if (k >= sum) {
			k = k % sum;
		}

		while (k >= 0) {
			if (k < chalk[i]) {
				break;
			} else {
				k -= chalk[i];
				i = (i + 1) % chalk.length;
			}
		}
		return i;
	}
}
}

