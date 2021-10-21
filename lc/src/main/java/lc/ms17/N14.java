package lc.ms17;

import java.util.PriorityQueue;

public class N14 {

	public static void main(String[] args) {
		Solution s = new N14().new Solution();

		for (int num : s.smallestK(new int[] { 1, 2, 3, 4 }, 2)) {
			System.out.println(num);
		}
	}

	class Solution {
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
