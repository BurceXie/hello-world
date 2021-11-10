package lc;

import com.google.common.base.Stopwatch;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 *488. 祖玛游戏(3)
 *https://leetcode-cn.com/problems/zuma-game/
 */
public class N488 {

	public static void main(String[] args) {
		Solution s = new N488().new Solution();

		Stopwatch sw = Stopwatch.createStarted();
		System.out.println(s.findMinStep("WRRBBW", "RB"));
		System.out.println("sw: " + sw.elapsed(TimeUnit.MILLISECONDS));
		System.out.println(s.findMinStep("WWRRBBWW", "WRBRW"));
		System.out.println("sw: " + sw.elapsed(TimeUnit.MILLISECONDS));
		System.out.println(s.findMinStep("G", "GGGGG"));
		System.out.println("sw: " + sw.elapsed(TimeUnit.MILLISECONDS));
		System.out.println(s.findMinStep("RBYYBBRRB", "YRBGB"));
		System.out.println("sw: " + sw.elapsed(TimeUnit.MILLISECONDS));
	}

class Solution {
		// TODO
	public int findMinStep(String board, String hand) {
		List<Character> balls = new ArrayList<>();
		for (Character b: hand.toCharArray()) {
			if (board.indexOf(b) >= 0) {
				balls.add(b);
			}
		}

		List<Character> list = new LinkedList<>();
		for (Character c: board.toCharArray()) {
			list.add(c);
		}

		int stepCount = 0;
		for (Character c: hand.toCharArray()) {
			int index = list.indexOf(c);
			if (index >= 0) {
				list.add(index, c);
				removeBall(list, index);
				stepCount++;
			}
			if (list.isEmpty()) {
				break;
			}
		}
		return list.isEmpty() ? stepCount : -1;
	}

	public void removeBall(List<Character> list, int index) {
		Character c = list.get(index);
		int count = 1;
		for (int i = index - 1; i >= 0; i--) {
			if (c != list.get(i)) {
				break;
			} else {
				index = i;
			}
		}
		for (int i = index + 1; i < list.size(); i++) {
			if (c != list.get(i)) {
				break;
			} else {
				count++;
			}
		}
		if (count >= 3) {
			for (int i = 0; i < count; i++) {
				list.remove(index);
			}
			if (!list.isEmpty()) {
				if (index > list.size()) {
					removeBall(list, list.size() - 1);
				} else {
					removeBall(list, index);
				}
			}
		}
	}
}
}

