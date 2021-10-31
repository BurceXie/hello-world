package lc;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * 1370. 上升下降字符串(1)
 * https://leetcode-cn.com/problems/increasing-decreasing-string/
 * @author Terry
 *
 */
public class N1370 {

	public static void main(String[] args) {
		Solution s = new N1370().new Solution();
		
		System.out.println(s.sortString2("aaaabbbbcccc"));
		System.out.println(s.sortString2("rat"));
		System.out.println(s.sortString2("leetcode"));
		System.out.println(s.sortString2("ggggggg"));
		System.out.println(s.sortString2("spo"));
	}

class Solution {
    public String sortString(String s) {
    	List<Character> currList = new ArrayList<>();
    	StringBuffer result = new StringBuffer(), left = new StringBuffer(s);
    	boolean minFirst = true;
    	while (left.length() != 0) {
    		String leftStr = left.toString();
    		left.delete(0, left.length());
    		for (int i = 0; i < leftStr.length(); i++) {
    			char c = leftStr.charAt(i);
    			if (!currList.contains(c)) {
    				currList.add(c);
    			} else {
    				left.append(c);
    			}
    		}
    		if (minFirst) {
    			result.append(currList.stream().sorted().map(String::valueOf).collect(Collectors.joining()));
    		} else {
    			result.append(currList.stream().sorted(Comparator.reverseOrder()).map(String::valueOf).collect(Collectors.joining()));
    		}
    		currList.clear();
    		minFirst = !minFirst;
    	}
    	return result.toString();
    }
    
    public String sortString2(String s) {
    	int[][] charCounts = new int[26][2];
    	for (int i = 0; i < charCounts.length; i++) {
    		charCounts[i] = new int[] {i + 'a', 0};
    	}
    	
    	for (int i = 0; i < s.length(); i++) {
    		charCounts[s.charAt(i) - 'a'][1]++;
    	}
    	
    	List<int[]> list = Stream.of(charCounts).filter(arr -> arr[1] > 0).collect(Collectors.toList());
    	boolean minFirst = true, isEmpty = list.isEmpty();
    	StringBuffer result = new StringBuffer();
    	while (!isEmpty) {
    		isEmpty = true;
    		if (minFirst) {
    			for (int i = 0; i < list.size(); i++) {
    				if (list.get(i)[1] > 0) {
    					result.append((char)list.get(i)[0]);
    					list.get(i)[1]--;
    					isEmpty = false;
    				}
    			}
    		} else {
    			for (int i = list.size() - 1; i >= 0; i--) {
    				if (list.get(i)[1] > 0) {
    					result.append((char)list.get(i)[0]);
    					list.get(i)[1]--;
    					isEmpty = false;
    				}
    			}
    		}
    		minFirst = !minFirst;
    	}
    	return result.toString();
    }
}
}

