package lc;

/**
 * 367. 有效的完全平方数(1)
 * https://leetcode-cn.com/problems/valid-perfect-square/
 */
public class N367 {

	public static void main(String[] args) {
		Solution s = new N367().new Solution();

		System.out.println(s.isPerfectSquare2(16));
		System.out.println(s.isPerfectSquare2(14));
		System.out.println(Integer.MAX_VALUE);
	}

class Solution {
	public boolean isPerfectSquare(int num) {
		int n = (int) Math.round(Math.sqrt(num));
		return n * n == num;
	}

	public boolean isPerfectSquare2(int num) {
		int min = 1, max = 46340;
		while (min < max) {
			int middle = (min + max) / 2;
			int power2 = middle * middle;
			if (num == min * min || num == max * max || num == power2) {
				return true;
			} else if (num > power2) {
				min = middle + 1;
			} else {
				max = middle - 1;
			}
		}
		return false;
	}
}
}

