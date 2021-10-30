package lc;

import java.util.*;
import java.util.stream.*;
import static java.util.stream.Collectors.*;

/**
 * 27. 移除元素(1)
 * https://leetcode-cn.com/problems/remove-element/
 * @author Administrator
 *
 */
public class N27 {

	public static void main(String[] args) {
		Solution s = new N27().new Solution();
		
		System.out.println(s.removeElement(new int[] {3,2,2,3}, 3));
	}

class Solution {
    public int removeElement(int[] nums, int val) {
    	int i = 0;
    	for (int j = nums.length - 1; i < nums.length; i++) {
    		if (nums[i] == val) {
    			while (j >= i) {
    				if (nums[j] != val) {
    					nums[i] = nums[j];
    					j--;
    					break;
    				}
					j--;
    			}
    		}
    		if (i > j) {
    			break;
    		}
    	}
    	return i;
    }
}
}

