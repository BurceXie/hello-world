package lc;

import java.util.*;
import java.util.stream.*;
import static java.util.stream.Collectors.*;

/**
 * 26. 删除有序数组中的重复项(1)
 * https://leetcode-cn.com/problems/remove-duplicates-from-sorted-array/
 * @author Administrator
 *
 */
public class N26 {

	public static void main(String[] args) {
		Solution s = new N26().new Solution();
		
		System.out.println(s.removeDuplicates(new int[] {1,1,2}));
		System.out.println(s.removeDuplicates(new int[] {0,0,1,1,1,2,2,3,3,4}));
	}

class Solution {
    public int removeDuplicates(int[] nums) {
    	int i = 0;
    	for (int j = 1; j < nums.length; j++) {
    		if (nums[i] < nums[j]) {
				i++;
    			if (j > i) {
    				nums[i] = nums[j];
    			}
    		}
    	}
    	return i + 1;
    }
}
}

