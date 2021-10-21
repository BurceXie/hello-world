package lc;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class N56 {

	public static void main(String[] args) {
		Solution s = new N56().new Solution();

    	int[][] intervals = new int[][] {{1,3},{2,6},{8,10},{15,18}};
//		int[][] intervals = new int[][] { { 1, 4 }, { 5, 6 } };
//		int[][] intervals = new int[][] { { 1, 4 }, { 2, 3 } };
//		int[][] intervals = new int[][] { { 2, 4 }, { 1, 7 } };
//    	int[][] intervals = new int[][] {{1,1}};

		for (int[] interval : intervals) {
			System.out.println(Arrays.toString(interval));
		}
		System.out.println();

		int[][] outInterval = s.merge(intervals);
		for (int[] interval : outInterval) {
			System.out.println(Arrays.toString(interval));
		}
	}

	class Solution {
		public int[][] merge2(int[][] intervals) {
			List<int[]> list = new ArrayList<>();
			for (int i = 0; i < intervals.length; i++) {
				boolean canJoin = false;
				for (int j = i + 1; j < intervals.length; j++) {
					if (intervals[i][0] >= intervals[j][0] && intervals[i][0] <= intervals[j][1]
							|| intervals[i][1] >= intervals[j][0] && intervals[i][1] <= intervals[j][1]
							|| intervals[i][0] <= intervals[j][0] && intervals[i][1] >= intervals[j][1]
							|| intervals[i][0] >= intervals[j][0] && intervals[i][1] <= intervals[j][1]) {
						intervals[j][0] = Math.min(intervals[i][0], intervals[j][0]);
						intervals[j][1] = Math.max(intervals[i][1], intervals[j][1]);
						canJoin = true;
					}
				}

				if (!canJoin) {
					list.add(intervals[i]);
				}
			}

			return list.toArray(new int[list.size()][]);
		}
		
		public int[][] merge(int[][] intervals) {
			List<int[]> list = new ArrayList<>();
			for (int i = 0; i < intervals.length; i++) {
				boolean canJoin = false;
				for (int j = i + 1; j < intervals.length; j++) {
					if (intervals[i][1] < intervals[j][0] || intervals[i][0] > intervals[j][1]) {
						continue;
					}
					
					if (intervals[i][0] <= intervals[j][0]) {
						if (intervals[i][1] >= intervals[j][1]) {
							intervals[j][1] = intervals[i][1];
						}
						intervals[j][0] = intervals[i][0];
					} else if (intervals[i][1] >= intervals[j][1]) {
						if (intervals[i][0] <= intervals[j][0]) {
							intervals[j][0] = intervals[i][0];
						}
						intervals[j][1] = intervals[i][1];
					}
					canJoin = true;
				}

				if (!canJoin) {
					list.add(intervals[i]);
				}
			}

			return list.toArray(new int[list.size()][]);
		}
	}
}
