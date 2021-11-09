package bw64;

import com.google.common.base.Stopwatch;

import java.util.concurrent.*;

/**
 * 5901. 棋盘上有效移动组合的数目
 * https://leetcode-cn.com/contest/biweekly-contest-64/problems/number-of-valid-move-combinations-on-chessboard/
 */
public class N5901 {

	public static void main(String[] args) {
		Solution s = new N5901().new Solution();

		Stopwatch sw = Stopwatch.createStarted();
		System.out.println(s);
		System.out.println("sw: " + sw.elapsed(TimeUnit.MILLISECONDS));
	}

class Solution {
		// TODO
    public int countCombinations(String[] pieces, int[][] positions) {

    	return 0;
    }
}
}

