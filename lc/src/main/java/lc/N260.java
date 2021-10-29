package lc;

import java.util.*;
import java.util.stream.*;
import static java.util.stream.Collectors.*;

/**
 * 260. 只出现一次的数字 III(2)
 * https://leetcode-cn.com/problems/single-number-iii/
 * @author Terry
 *
 */
public class N260 {

	public static void main(String[] args) {
		Solution s = new N260().new Solution();
		
	}

class Solution {
    public int[] singleNumber(int[] nums) {
    	List<Integer> list = new ArrayList<Integer>();
    	for (int num: nums) {
    		if (list.contains(num)) {
    			list.remove(Integer.valueOf(num));
    		} else {
    			list.add(num);
    		}
    	}
    	return new int[] {list.get(0), list.get(1)};
    }
}
}

