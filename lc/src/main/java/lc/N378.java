package lc;

import java.util.Arrays;

/**
 *378. 有序矩阵中第 K 小的元素(2)
 *https://leetcode-cn.com/problems/kth-smallest-element-in-a-sorted-matrix/
 */
public class N378 {

	public static void main(String[] args) {
		Solution s = new N378().new Solution();

		System.out.println(s);
	}

class Solution {
	public int kthSmallest(int[][] matrix, int k) {
		int[] arr = new int[matrix.length * matrix.length];
		int l = 0;
		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix.length; j++) {
				arr[l++] = matrix[i][j];
			}
		}
		Arrays.sort(arr);
		return arr[k - 1];
	}
}
}

