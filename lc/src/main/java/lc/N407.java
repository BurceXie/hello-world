package lc;

/**
 * 407. 接雨水 II(3)
 * https://leetcode-cn.com/problems/trapping-rain-water-ii/
 */
public class N407 {

	public static void main(String[] args) {
		Solution s = new N407().new Solution();

		System.out.println(s);
	}

	class Solution {
		// TODO
		public int trapRainWater(int[][] heightMap) {
			int m = heightMap.length, n = heightMap[0].length;
			if (heightMap.length < 3) {
				return 0;
			} else if (heightMap[0].length < 3) {
				return 0;
			}

			return 0;
		}
	}
}

