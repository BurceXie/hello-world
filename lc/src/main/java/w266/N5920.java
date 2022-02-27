package w266;

import com.google.common.base.Stopwatch;

import java.util.concurrent.*;

/**
 *5920. 分配给商店的最多商品的最小值(2)
 *https://leetcode-cn.com/contest/weekly-contest-266/problems/minimized-maximum-of-products-distributed-to-any-store/
 */
public class N5920 {

	public static void main(String[] args) {
		Solution s = new N5920().new Solution();

		Stopwatch sw = Stopwatch.createStarted();
		System.out.println(s.minimizedMaximum(15, new int[]{16, 24, 18, 26, 18, 28, 11, 8, 22, 26, 21, 23}));
		System.out.println("sw: " + sw.elapsed(TimeUnit.MICROSECONDS));
	}

class Solution {
	public int minimizedMaximum(int n, int[] quantities) {
		int left = 1, right = 100000;
		while (left < right) {
			int mid = (left + right) / 2;
			int count = 0;
			for (int quantity : quantities) {
				count += (quantity + mid - 1) / mid;
			}
			if (count > n) {
				left = mid + 1;
			} else {
				right = mid;
			}
			System.out.println(count + "\t" + left + "\t" + right);
		}
		return left;
	}
}
}

