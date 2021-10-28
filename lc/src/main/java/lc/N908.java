package lc;

import java.util.*;
import java.util.stream.*;
import static java.util.stream.Collectors.*;

/**
 * 908. 最小差值 I(1)
 * https://leetcode-cn.com/problems/smallest-range-i/
 * @author Terry
 *
 */
public class N908 {

	public static void main(String[] args) {
		Solution s = new N908().new Solution();
		
	}

class Solution {
    public int smallestRangeI(int[] nums, int k) {
		int min = nums[0], max = nums[0];
		for (int num : nums) {
			if (num < min) {
				min = num;
			} else if (num > max) {
				max = num;
			}
		}
		int range = max - k - min - k;
		return range > 0 ? range : 0;
    }
}
}

