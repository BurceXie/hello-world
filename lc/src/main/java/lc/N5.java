package lc;

import com.google.common.base.Stopwatch;

import java.util.*;
import java.util.concurrent.*;

/**
 *
 *
 */
public class N5 {

	public static void main(String[] args) {
		Solution s = new Solution();

		Stopwatch sw = Stopwatch.createStarted();
		System.out.println(s);
		System.out.println("sw: " + sw.elapsed(TimeUnit.MILLISECONDS));
	}

static class Solution {
	public String longestPalindrome(String s) {
		char[] chars = s.toCharArray();
		int n = chars.length;
		if (n == 1) {
			return s;
		} else if (n == 2) {
			if (chars[0] == chars[1]) {
				return s;
			} else {
				return s.substring(0, 1);
			}
		}

		// temp2 记录 len - 2 的结果，temp1 记录 len - 1 的结果
		// temp[0] 开始下标，temp[1] 结束下标，temp[2] 回文串长度
		List<int[]> temp2 = new LinkedList<>(), temp1 = new LinkedList<>();
		for (int i = 0; i < n; i++) {
			temp2.add(new int[]{i, i + 1, 1});
		}
		int longest = 1, beginIndex = 0, endIndex = 1;
		String result = s.substring(0, 1);
		for (int i = 0; i < n - 1; i++) {
			int[] a = new int[] {i, i + 2, 2};
			if (chars[i] == chars[i + 1]) {
				temp1.add(a);
				if (a[2] > longest) {
					longest = 2;
					beginIndex = a[0];
					endIndex = a[1];
				}
			}
		}

		for (int len = 3; len <= n; len++) {
			List<int[]> temp = new LinkedList<>();
			for (int[] a: temp2) {
				if (a[0] == 0 || a[1] == n) {
					continue;
				}
				int[] b = new int[]{a[0] - 1, a[1] + 1, a[2] + 2};
				if (chars[b[0]] == chars[b[1] - 1]) {
					temp.add(b);
					if (b[2] > longest) {
						longest = b[2];
						beginIndex = b[0];
						endIndex = b[1];
					}
				}
			}
			temp2 = temp1;
			temp1 = temp;
		}

		return s.substring(beginIndex, endIndex);
	}
}
}
