package lc;

import com.google.common.base.Stopwatch;

import java.util.*;
import java.util.concurrent.*;

/**
 * 838. 推多米诺(2)
 * https://leetcode-cn.com/problems/push-dominoes/submissions/
 */
public class N838 {

	public static void main(String[] args) {
		Solution s = new Solution();

		Stopwatch sw = Stopwatch.createStarted();
		System.out.println(s.pushDominoes(".L.R...LR..L.."));
		System.out.println("sw: " + sw.elapsed(TimeUnit.MILLISECONDS));
	}

static class Solution {
	public String pushDominoes(String dominoes) {
		int n = dominoes.length();
		char[] arr = dominoes.toCharArray();
		while (true) {
			boolean finish = true;

			char[] tempArr = Arrays.copyOf(arr, n);
			for (int i = 0; i < n; i++) {
				char c = tempArr[i];
				if (c == '.') {
					if (i - 1 >= 0 && i + 1 < n) {
						char l = tempArr[i - 1], r = tempArr[i + 1];
						if (l == 'R' && r != 'L') {
							arr[i] = 'R';
							finish = false;
						} else if (r == 'L' && l != 'R') {
							arr[i] = 'L';
							finish = false;
						}
					} else if (i - 1 >= 0 && tempArr[i - 1] == 'R'){
						arr[i] = 'R';
						finish = false;
					} else if (i + 1 < n && tempArr[i + 1] == 'L') {
						arr[i] = 'L';
						finish = false;
					}
				}
			}
			System.out.println(Arrays.toString(arr));
			if (finish) {
				break;
			}
		}
		return new String(arr);
	}
}
}
