package lc;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * 179. 最大数(2)
 * https://leetcode-cn.com/problems/largest-number/
 * @author Terry
 *
 */
public class N179 {

	public static void main(String[] args) {
		Solution s = new N179().new Solution();

		System.out.println(s.largestNumber(new int[] { 10, 2 }));
		System.out.println(s.largestNumber(new int[] { 3, 30, 34, 5, 9 }));
		System.out.println(s.largestNumber(new int[] { 432, 43243 }));
		System.out.println(s.largestNumber(new int[] { 0, 0, 0 }));
	}
    
class Solution {
    public String largestNumber(int[] nums) {
    	List<String> numberStrs = new ArrayList<>();
    	boolean allZero = true;
    	for (int num : nums) {
    		if (num != 0) {
    			allZero = false;
    		}
    		numberStrs.add(String.valueOf(num));
    	}
    	if (allZero) {
    		return "0";
    	}
    	return numberStrs.stream().sorted((s1, s2) -> {
    		return (s2 + s1).compareTo(s1 + s2);
    	}).collect(Collectors.joining());
    }
}

}
