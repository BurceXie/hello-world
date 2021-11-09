package lc;

import com.google.common.base.Stopwatch;

import java.util.*;
import java.util.concurrent.*;

/**
 * 1. 两数之和(1)
 * https://leetcode-cn.com/problems/two-sum
 *
 */
public class N1 {

    public static void main(String[] args) {
    	Solution s = new N1().new Solution();

	    Stopwatch sw = Stopwatch.createStarted();
	    System.out.println(Arrays.toString(s.findTwoSum(new int[] {3,2,4}, 6)));
	    System.out.println("sw: " + sw.elapsed(TimeUnit.MILLISECONDS));
	}
    
    class Solution {
    	public int[] findTwoSum(int[] nums, int target) {
        	Map<Integer, Integer> map = new HashMap<>();
        	for (int i = 0; i < nums.length; i++) {
        		map.put(target - nums[i], i);
        	}
        	
    		for (int j = 0; j < nums.length; j++) {
    			Integer i = map.get(nums[j]);
    			if (i != null && i != j) {
    				return new int[] {i, j};
    			}
    		}
        	return new int[2];
        }
    }
}
