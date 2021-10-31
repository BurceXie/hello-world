package lc;

import java.util.*;
import java.util.stream.*;

import static java.util.stream.Collectors.*;

/**
 * 575. 分糖果(1)
 * https://leetcode-cn.com/problems/distribute-candies/
 * @author Terry
 *
 */
public class N575 {

	public static void main(String[] args) {
		Solution s = new N575().new Solution();
		
	}

class Solution {
    public int distributeCandies(int[] candyType) {
    	Map<Integer, Integer> map = new HashMap<Integer, Integer>();
    	for (int c: candyType) {
    		map.put(c, map.getOrDefault(c, 0) + 1);
    	}

    	int count = candyType.length / 2;
    	return map.size() >= count ? count : map.size();
    }
}
}

