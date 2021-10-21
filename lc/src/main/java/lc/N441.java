package lc;

public class N441 {

	public static void main(String[] args) {
		Solution s = new N441().new Solution();

		for (int i = 1; i < 100; i++) {
			System.out.println(i + "\t" + s.arrangeCoins(i));
		}

		int l = 1804289384;
		System.out.println(l + "\t" + s.arrangeCoins(l));
	}

	class Solution {
		public int arrangeCoins(int n) {

			int l = 1;
			for (; l <= n; l++) {
				long t = (long) l * (l + 1) / 2;
				if (t == n) {
					break;
				}
				if (t > n) {
					l -= 1;
					break;
				}
			}

			return l;
		}
	}
}
