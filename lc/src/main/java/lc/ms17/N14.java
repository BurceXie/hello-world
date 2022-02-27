package lc.ms17;

import java.util.Arrays;
import java.util.PriorityQueue;

/**
 * 面试题17.14.最小 K 个数(2)
 * https://leetcode-cn.com/problems/smallest-k-lcci/
 */
public class N14 {

	public static void main(String[] args) {
		Solution s = new Solution();

		System.out.println(Arrays.toString(s.smallestK(new int[] { 1, 2, 3, 4 }, 2)));
	}

	static class Solution {
		public int[] smallestK(int[] arr, int k) {
			PriorityQueue<Integer> pq = new PriorityQueue<>();
			for (int num : arr) {
				pq.add(num);
			}

			int[] result = new int[k];
			for (int i = 0; i < k; i++) {
				result[i] = pq.poll();
			}
			return result;
		}
	}
}
