package w265;

import java.util.*;
import java.util.stream.*;

import static java.util.stream.Collectors.*;

/**
 * 5914. 值相等的最小索引(1)
 * https://leetcode-cn.com/contest/weekly-contest-265/problems/smallest-index-with-equal-value/
 * @author Terry
 *
 */
public class N5914 {

	public static void main(String[] args) {
		Solution s = new N5914().new Solution();
		
	}

class Solution {
    public int smallestEqual(int[] nums) {
    	int i = 0;
    	for (; i < nums.length; i++) {
    		if (i % 10 == nums[i]) {
    			break;
    		}
    	}
    	
    	return i == nums.length ? -1 : i;
    }
}
}

