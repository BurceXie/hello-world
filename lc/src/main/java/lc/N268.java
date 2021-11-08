package lc;

import java.util.Arrays;

/**
 *268. 丢失的数字(1)
 *https://leetcode-cn.com/problems/missing-number/
 */
public class N268 {

	public static void main(String[] args) {
		Solution s = new N268().new Solution();

		System.out.println(s.missingNumber(new int[] {9,6,4,2,3,5,7,0,1}));
	}

class Solution {
	public int missingNumber(int[] nums) {
		int[] marks = new int[nums.length + 1];
		for (int i = 0 ; i < nums.length; i++) {
			marks[nums[i]] = 1;
		}
		int num = nums[0];
		for (int i = 0; i < marks.length; i++) {
			if (marks[i] == 0) {
				num = i;
				break;
			}
		}
		return num;
	}
}
}

