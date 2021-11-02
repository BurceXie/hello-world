package w265;

import java.util.*;
import java.util.stream.*;

import static java.util.stream.Collectors.*;

/**
 * 5916. 转化数字的最小运算数(2)
 * https://leetcode-cn.com/contest/weekly-contest-265/problems/minimum-operations-to-convert-number/
 */
public class N5916 {

	public static void main(String[] args) {
		Solution s = new N5916().new Solution();
		
	}

class Solution {
	// TODO
    public int minimumOperations(int[] nums, int start, int goal) {
    	// goal 如果不在 0-1000 范围， 转回 0 - 1000
    	List<Integer> goalList = new ArrayList<Integer>();
    	List<Integer> numList = new ArrayList<>();
    	for (int num: nums) {
    		numList.add(num);
    	}
    	int operCount = 0;
    	if (goal < 0 || goal > 1000) {
    		for (int num: nums) {
    			int goal1 = goal + num, goal2 = goal - num, goal3 = goal ^ num;
    			if (goal1 >= 0 && goal1 <= 1000) {
    				goalList.add(goal1);
    			}
    			if (goal2 >= 0 && goal2 <= 1000) {
    				goalList.add(goal2);
    			}
    			if (goal3 >= 0 && goal3 <= 1000) {
    				goalList.add(goal3);
    			}
    		}
    		if (!goalList.isEmpty()) {
    			operCount = 1;
    		} else {
    			return -1;
    		}
    	} else {
    		goalList.add(goal);
    	}
    	
    	for (Integer g : goalList) {
    		int g1 = g + start, g2 = g - start, g3 = g ^ start;
    		if (numList.contains(g1) || numList.contains(g2) || numList.contains(g3)) {
    			operCount++;
    			return operCount;
    		}
    	}
    	return operCount;
    }
}
}

