package lc;

import java.util.*;

/**
 * 407. 接雨水 II(3)
 * https://leetcode-cn.com/problems/trapping-rain-water-ii/
 */
public class N407 {

	public static void main(String[] args) {
		Solution s = new Solution();

		System.out.println(s.trapRainWater(new int[][] {{1, 4, 3, 1, 3, 2}, {3, 2, 1, 3, 2, 4}, {3, 3, 3, 1, 3, 2}}));
		System.out.println(s.trapRainWater(new int[][] {{3, 3, 3, 3, 3}, {3, 2, 2, 2, 3}, {3, 2, 1, 2, 3}, {3, 2, 2, 2, 3}, {3, 3, 3, 3, 3}}));
	}

static class Solution {
	public int trapRainWater(int[][] heightMap) {
		// 行或列小于3都不能接到雨水
		int m = heightMap.length, n = heightMap[0].length;
		if (heightMap.length < 3) {
			return 0;
		} else if (heightMap[0].length < 3) {
			return 0;
		}

		int sum = 0;
		boolean[][] dealed = new boolean[m][n];
		PriorityQueue<WaterBuilding> queue = new PriorityQueue<>();
		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				if (i > 0 && i < m - 1 && j > 0 && j < n - 1) {
					continue;
				}
				WaterBuilding wb = new WaterBuilding(i, j, heightMap[i][j], heightMap[i][j]);
				queue.add(wb);
				dealed[i][j] = true;
			}
		}

		while (!queue.isEmpty()) {
			WaterBuilding wb = queue.poll();

			if (isLegal(wb.x - 1, wb.y, m, n) && !dealed[wb.x - 1][wb.y]) {
				WaterBuilding wbUp = new WaterBuilding(wb.x - 1, wb.y, heightMap[wb.x - 1][wb.y], heightMap[wb.x - 1][wb.y]);
				if (wb.w > wbUp.h) {
					wbUp.w = wb.w;
					sum += (wbUp.w - wbUp.h);
				}
				dealed[wbUp.x][wbUp.y] = true;
				queue.add(wbUp);
			}
			if (isLegal(wb.x + 1, wb.y, m, n) && !dealed[wb.x + 1][wb.y]) {
				WaterBuilding wbDown = new WaterBuilding(wb.x + 1, wb.y, heightMap[wb.x + 1][wb.y], heightMap[wb.x + 1][wb.y]);
				if (wb.w > wbDown.h) {
					wbDown.w = wb.w;
					sum += (wbDown.w - wbDown.h);
				}
				dealed[wbDown.x][wbDown.y] = true;
				queue.add(wbDown);
			}
			if (isLegal(wb.x, wb.y - 1, m, n) && !dealed[wb.x][wb.y - 1]) {
				WaterBuilding wbLeft = new WaterBuilding(wb.x, wb.y - 1, heightMap[wb.x][wb.y - 1], heightMap[wb.x][wb.y - 1]);
				if (wb.w > wbLeft.h) {
					wbLeft.w = wb.w;
					sum += (wbLeft.w - wbLeft.h);
				}
				dealed[wbLeft.x][wbLeft.y] = true;
				queue.add(wbLeft);
			}
			if (isLegal(wb.x, wb.y + 1, m, n) && !dealed[wb.x][wb.y + 1]) {
				WaterBuilding wbRight = new WaterBuilding(wb.x, wb.y + 1, heightMap[wb.x][wb.y + 1], heightMap[wb.x][wb.y + 1]);
				if (wb.w > wbRight.h) {
					wbRight.w = wb.w;
					sum += (wbRight.w - wbRight.h);
				}
				dealed[wbRight.x][wbRight.y] = true;
				queue.add(wbRight);
			}
		}

		return sum;
	}

	private boolean isLegal(int x, int y, int m, int n) {
		return !(x < 0 || y < 0 || x >= m || y >= n);
	}

	class WaterBuilding implements Comparable<WaterBuilding> {
		public int x;
		public int y;
		public int h;
		public int w;

		public WaterBuilding(int x, int y, int h, int w) {
			this.x = x;
			this.y = y;
			this.h = h;
			this.w = w;
		}

		@Override
		public int compareTo(WaterBuilding o) {
			return w - o.w;
		}
	}
}
}

