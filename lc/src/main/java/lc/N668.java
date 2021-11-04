package lc;

/**
 * 668. 乘法表中第k小的数(3)
 * https://leetcode-cn.com/problems/kth-smallest-number-in-multiplication-table/
 */
public class N668 {

	public static void main(String[] args) {
		Solution s = new N668().new Solution();

		System.out.println(s.findKthNumber(2, 3, 6));
	}

class Solution {
		// TODO
	public int findKthNumber(int m, int n, int k) {
		if (m < n) {
			int t = m;
			m = n;
			n = t;
		}

		return 0;
	}

	public int findKthNumberGf(int m, int n, int k) {
		int lo = 1, hi = m * n;
		while (lo < hi) {
			int mi = lo + (hi - lo) / 2;
			if (!enough(mi, m, n, k)) lo = mi + 1;
			else hi = mi;
		}
		return lo;
	}

	public boolean enough(int x, int m, int n, int k) {
		int count = 0;
		for (int i = 1; i <= m; i++) {
			count += Math.min(x / i, n);
		}
		return count >= k;
	}
}
}

