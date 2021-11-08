package w266;

import java.util.ArrayList;

/**
 *5921. 最大化一张图中的路径价值(3)
 *https://leetcode-cn.com/contest/weekly-contest-266/problems/maximum-path-quality-of-a-graph/
 */
public class N5921 {

	public static void main(String[] args) {
		Solution s = new N5921().new Solution();

		System.out.println(s);
	}

class Solution {
		// TODO
	public int maximalPathQuality(int[] values, int[][] edges, int maxTime) {
		return 0;
	}

	public int maximalPathQuality2(int[] values, int[][] edges, int maxTime) {
		ArrayList<int[]>[] list = new ArrayList[values.length];
		for (int i = 0; i < values.length; i++) {
			list[i] = new ArrayList<>();
		}
		for (int[] edge : edges) {
			list[edge[0]].add(new int[] { edge[1], edge[2] });
			list[edge[1]].add(new int[] { edge[0], edge[2] });
		}
		return maximalPathQuality(0, maxTime, new int[values.length], values, list);
	}

	private int maximalPathQuality(int node, int time, int[] map, int[] values, ArrayList<int[]>[] list) {
		if (time < 0) {
			return Integer.MIN_VALUE;
		}
		int max = node > 0 ? Integer.MIN_VALUE : map[0] > 0 ? 0 : values[node];
		map[node]++;
		for (int[] next : list[node]) {
			max = Math.max(max, (map[node] > 1 ? 0 : values[node])
					+ maximalPathQuality(next[0], time - next[1], map, values, list));
		}
		map[node]--;
		return max;
	}
}
}

