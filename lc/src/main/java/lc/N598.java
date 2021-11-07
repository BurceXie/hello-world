package lc;

/**
 *598. 范围求和 II(1)
 *https://leetcode-cn.com/problems/range-addition-ii/
 */
public class N598 {

	public static void main(String[] args) {
		Solution s = new N598().new Solution();

		System.out.println(s);
	}

class Solution {
	public int maxCount(int m, int n, int[][] ops) {
		for (int[] op: ops) {
			if (op[0] < m) {
				m = op[0];
			}
			if (op[1] < n) {
				n = op[1];
			}
		}
		return m * n;
	}
}
}

