package lc;

import java.util.HashMap;
import java.util.Map;
import java.util.stream.IntStream;

public class N1 {

    public static void main(String[] args) {
    	Solution s = new N1().new Solution();
		
		int[] nums = {3,2,4};
    	int target = 6;
    	
    	IntStream.of(s.findTwoSum(nums, target)).sorted().forEach(System.out::println);
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