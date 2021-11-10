package lc;

import com.google.common.base.Stopwatch;

import java.util.concurrent.TimeUnit;

/**
 *495. 提莫攻击(1)
 *https://leetcode-cn.com/problems/teemo-attacking/
 */
public class N495 {

	public static void main(String[] args) {
		Solution s = new N495().new Solution();

		Stopwatch sw = Stopwatch.createStarted();
		System.out.println(s.findPoisonedDuration(new int[]{1,4}, 2));
		System.out.println("sw: " + sw.elapsed(TimeUnit.MICROSECONDS));
		System.out.println(s.findPoisonedDuration(new int[]{1,2}, 2));
		System.out.println("sw: " + sw.elapsed(TimeUnit.MICROSECONDS));
	}

class Solution {
	public int findPoisonedDuration(int[] timeSeries, int duration) {
		int sum = duration;
		for (int i = timeSeries.length - 2; i >= 0; i--) {
			sum += Math.min(timeSeries[i + 1] - timeSeries[i], duration);
		}
		return sum;
	}
}
}

