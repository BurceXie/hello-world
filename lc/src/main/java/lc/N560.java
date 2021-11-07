package lc;

import java.util.Arrays;

/**
 *560. 和为 K 的子数组(2)
 *https://leetcode-cn.com/problems/subarray-sum-equals-k/
 */
public class N560 {

	public static void main(String[] args) {
		Solution s = new N560().new Solution();

		long start = System.nanoTime();
		System.out.println(s.subarraySum(new int[] {1,1,1}, 2));
		System.out.println(s.subarraySum(new int[] {1,2,3}, 3));
		System.out.println(s.subarraySum(new int[] {1, -1, 0}, 0));
		System.out.println(System.nanoTime() - start);
	}

class Solution {
	public int subarraySum(int[] nums, int k) {
		int sum = 0;
		for (int num: nums) {
			if (num == k) {
				sum++;
			}
		}
		System.out.println("0\t" + Arrays.toString(nums) + "\t" + sum);

		int[] sumArr = Arrays.copyOf(nums, nums.length);
		for (int i = 1; i < nums.length; i++) {
			int temp = sumArr[i - 1];
			for (int j = i; j < nums.length; j++) {
				int value = nums[j] + temp;
				temp = sumArr[j];
				sumArr[j] = value;
				if (sumArr[j] == k) {
					sum++;
				}
			}
			System.out.println(i + "\t" + Arrays.toString(sumArr) + "\t" + sum);
		}
		return sum;
	}
}
}

