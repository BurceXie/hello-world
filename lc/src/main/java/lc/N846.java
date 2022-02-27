package lc;

import com.google.common.base.Stopwatch;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

/**
 * 846. 一手顺子(2)
 * https://leetcode-cn.com/problems/hand-of-straights/
 */
public class N846 {

	public static void main(String[] args) {
		Solution s = new N846().new Solution();

		Stopwatch sw = Stopwatch.createStarted();
		System.out.println(s.isNStraightHand(new int[]{1,2,3,6,2,3,4,7,8}, 3));
		System.out.println("sw: " + sw.elapsed(TimeUnit.MILLISECONDS));
	}

class Solution {
	public boolean isNStraightHand(int[] hand, int groupSize) {
		int n = hand.length;
		if (n % groupSize != 0) {
			return false;
		}
		Arrays.sort(hand);
		Map<Integer, Integer> cnt = new HashMap<>();
		for (int x : hand) {
			cnt.put(x, cnt.getOrDefault(x, 0) + 1);
		}
		for (int x : hand) {
			if (!cnt.containsKey(x)) {
				continue;
			}
			for (int j = 0; j < groupSize; j++) {
				int num = x + j;
				if (!cnt.containsKey(num)) {
					return false;
				}
				cnt.put(num, cnt.get(num) - 1);
				if (cnt.get(num) == 0) {
					cnt.remove(num);
				}
			}
		}
		return true;
	}
}
}

