package lc;

import java.util.*;

/**
 * 407. 接雨水 II(3)
 * https://leetcode-cn.com/problems/trapping-rain-water-ii/
 */
public class N407 {

	public static void main(String[] args) {
		Solution s = new N407().new Solution();

		System.out.println(s.trapRainWaterGf(new int[][] {{1, 4, 3, 1, 3, 2}, {3, 2, 1, 3, 2, 4}, {3, 3, 3, 1, 3, 2}}));
		System.out.println(s.trapRainWaterGf(new int[][] {{3, 3, 3, 3, 3}, {3, 2, 2, 2, 3}, {3, 2, 1, 2, 3}, {3, 2, 2, 2, 3}, {3, 3, 3, 3, 3}}));
	}

	class Solution {
		// TODO
		public int trapRainWater(int[][] heightMap) {
			// 行或列小于3都不能接到雨水
			int m = heightMap.length, n = heightMap[0].length;
			if (heightMap.length < 3) {
				return 0;
			} else if (heightMap[0].length < 3) {
				return 0;
			}

			// 找出最高点的高度和最低点的高度
			int highest = 0, lowest = 0;
			for (int[] row: heightMap) {
				for (int h: row) {
					if (h > highest) {
						highest = h;
					} else if (h < lowest) {
						lowest = h;
					}
				}
			}

			// 从最高点往下找,每一层判断是否可以接雨水,如果可以直接统计这些点的雨水量,并加入忽略(将高度设成-1)
			int water = 0;
			for (int h = highest; h >= lowest; h--) {
				water += computeWater(heightMap, h);
			}

			return water;
		}

		public int computeWater(int[][] heightMap, int h) {
			int water = 0;


			return water;
		}

		public int trapRainWaterGf(int[][] heightMap) {
			int m = heightMap.length;
			int n = heightMap[0].length;
			int[] dirs = {-1, 0, 1, 0, -1};
			int maxHeight = 0;

			for (int i = 0; i < m; ++i) {
				for (int j = 0; j < n; ++j) {
					maxHeight = Math.max(maxHeight, heightMap[i][j]);
				}
			}
			int[][] water = new int[m][n];
			for (int i = 0; i < m; ++i) {
				for (int j = 0; j < n; ++j){
					water[i][j] = maxHeight;
				}
			}
			Queue<int[]> qu = new LinkedList<>();
			for (int i = 0; i < m; ++i) {
				for (int j = 0; j < n; ++j) {
					if (i == 0 || i == m - 1 || j == 0 || j == n - 1) {
						if (water[i][j] > heightMap[i][j]) {
							water[i][j] = heightMap[i][j];
							qu.offer(new int[]{i, j});
						}
					}
				}
			}
			while (!qu.isEmpty()) {
				int[] curr = qu.poll();
				int x = curr[0];
				int y = curr[1];
				for (int i = 0; i < 4; ++i) {
					int nx = x + dirs[i], ny = y + dirs[i + 1];
					if (nx < 0 || nx >= m || ny < 0 || ny >= n) {
						continue;
					}
					if (water[x][y] < water[nx][ny] && water[nx][ny] > heightMap[nx][ny]) {
						water[nx][ny] = Math.max(water[x][y], heightMap[nx][ny]);
						qu.offer(new int[]{nx, ny});
					}
				}
			}

			int res = 0;
			for (int i = 0; i < m; ++i) {
				for (int j = 0; j < n; ++j) {
					res += water[i][j] - heightMap[i][j];
				}
			}
			return res;
		}
	}
}

