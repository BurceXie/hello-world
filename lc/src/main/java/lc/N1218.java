package lc;

import java.util.*;

/**
 * 1218. 最长定差子序列(2)
 * https://leetcode-cn.com/problems/longest-arithmetic-subsequence-of-given-difference/
 */
public class N1218 {

	public static void main(String[] args) {
		Solution s = new N1218().new Solution();

		System.out.println(s.longestSubsequence2(new int[]{1,2,3,4}, 1));
		System.out.println(s.longestSubsequence2(new int[]{1,5,7,8,5,3,4,2,1}, -2));
		System.out.println(s.longestSubsequence2(new int[]{7,-2,8,10,6,18,9,-8,-5,18,13,-6,-17,-1,-6,-9,9,9}, 1));
	}

class Solution {
	public int longestSubsequence(int[] arr, int difference) {
		Map<Integer, int[]> map = new HashMap<>();
		int max = 1;
		for (int num : arr) {
			int key = num - difference;
			if (map.containsKey(key)) {
				int[] a = map.get(key);
				if (key == a[0]) {
					a[0] = num;
					a[1]++;
					map.put(num, a);
					if (a[1] > max) {
						max = a[1];
					}
				}
			} else {
				int[] a = new int[] {num , 1};
				map.put(num, a);
			}
		}
		return max;
	}
	public int longestSubsequence2(int[] arr, int difference) {
		Map<Integer, Integer> map = new HashMap<>();
		int max = 1;
		for (int num : arr) {
			if (map.containsKey(num)) {
				Integer count = map.get(num) + 1;
				map.put(num + difference, count);
				if (count > max) {
					max = count;
				}
			} else {
				map.put(num + difference, 1);
			}
		}
		return max;
	}
}
}

