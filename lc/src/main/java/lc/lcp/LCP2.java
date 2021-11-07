package lc.lcp;

import java.util.Arrays;

/**
 LCP 02. 分式化简(1)
 https://leetcode-cn.com/problems/deep-dark-fraction/
 */
public class LCP2 {

	public static void main(String[] args) {
		Solution s = new LCP2().new Solution();

		System.out.println(Arrays.toString(s.fraction(new int[] {3, 2, 0, 2})));
		System.out.println(Arrays.toString(s.fraction(new int[] {0, 0, 3})));
		System.out.println(Arrays.toString(s.fraction(new int[] {3, 2, 4, 2})));
		System.out.println(Arrays.toString(s.fraction(new int[] {0, 6, 5, 2, 7, 4, 3, 7, 4, 5})));
	}

class Solution {
	public int[] fraction(int[] cont) {
		int[] result = fraction(cont, cont.length, 0);
		int b = result[0], s = result[1];
		if (b < s) {
			int t = b;
			b = s;
			s = t;
		}
		if (s > 1) {
			int mod = b / s;
			if (mod == 0) {
				result[0] /= s;
				result[1] /= s;
			} else if (b % mod == 0 && s % mod == 0) {
				result[0] /= mod;
				result[1] /= mod;
			}
		}
		return result;
	}

	public int[] fraction(int[] cont, int length, int index) {
		if (index == length - 1) {
			return new int[] {cont[index], 1};
		}

		int[] nextFraction = fraction(cont, length, index + 1);
		int m = cont[index] * nextFraction[0] + nextFraction[1], n = nextFraction[0];
		return new int[] {m , n};
	}
}
}

