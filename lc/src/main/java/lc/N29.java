package lc;

public class N29 {

	public static void main(String[] args) {
		Solution s = new N29().new Solution();

		System.out.println(s.divide(Integer.MIN_VALUE, 2));
		System.out.println(s.divide(-200, 4));
		System.out.println(s.divide(Integer.MIN_VALUE, -1));
		System.out.println(s.divide(-10, -4));
	}

	class Solution {
		public int divide(int dividend, int divisor) {

			if (dividend == 0) {
				return 0;
			}
			if (Integer.MIN_VALUE == dividend && (divisor == 1 || divisor == -1)) {
				return divisor == 1 ? Integer.MIN_VALUE : Integer.MAX_VALUE;
			}

			if (dividend > 0 && divisor > 0) {
				if (dividend - divisor < 0) {
					return 0;
				}
				if (dividend == divisor) {
					return 1;
				}
				int c = 0;
				while (dividend >= divisor) {
					dividend -= divisor;
					c++;
				}
				return c;
			} else if (dividend > 0) {
				if (dividend + divisor < 0) {
					return 0;
				}
				if (dividend + divisor == 0) {
					return -1;
				}
				int c = 0;
				while (dividend + divisor >= 0) {
					dividend += divisor;
					c--;
				}
				return c;
			} else if (divisor > 0) {
				if (dividend + divisor > 0) {
					return 0;
				}
				if (dividend + divisor == 0) {
					return -1;
				}
				int c = 0;
				while (dividend + divisor <= 0) {
					dividend += divisor;
					c--;
				}
				return c;
			} else {
				if (dividend - divisor > 0) {
					return 0;
				}
				if (dividend == divisor) {
					return 1;
				}
				int c = 0;
				while (dividend - divisor <= 0) {
					dividend -= divisor;
					c++;
				}
				return c;
			}
		}
	}

}
