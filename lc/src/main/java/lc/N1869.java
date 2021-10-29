package lc;

import java.util.*;
import java.util.stream.*;
import static java.util.stream.Collectors.*;

/**
 * 1869. 哪种连续子字符串更长(1)
 * https://leetcode-cn.com/problems/longer-contiguous-segments-of-ones-than-zeros/
 * @author Terry
 *
 */
public class N1869 {

	public static void main(String[] args) {
		Solution s = new N1869().new Solution();
		
		System.out.println(s.checkZeroOnes("1101"));
	}

class Solution {
    public boolean checkZeroOnes(String s) {
    	if (s.indexOf('0') == -1) {
    		return true;
    	} else if (s.indexOf('1') == -1) {
    		return false;
    	}
    	
    	char baseChar = s.charAt(0);
    	int[] lengths = new int[] {0, 0};
    	int[][] arrs = new int[][] {{0, 0}, {0, 0}};
    	arrs[baseChar - '0'][1] = 1;
    	lengths[baseChar - '0'] = 1;
    	for (int i = 1; i < s.length(); i++) {
    		char c = s.charAt(i);
    		if (i == s.length() - 1 && c == baseChar) {
    			if (s.length() - arrs[baseChar - '0'][0] > lengths[baseChar - '0']) {
    				lengths[baseChar - '0'] = s.length() - arrs[baseChar - '0'][0];
    			}
    		} else if (c != baseChar) {
    			if (i - arrs[baseChar - '0'][0] > lengths[baseChar - '0']) {
    				lengths[baseChar - '0'] = i - arrs[baseChar - '0'][0];
    			}
    			arrs[baseChar - '0'][1] = i;
    			arrs[c - '0'][0] = i;
    			baseChar = c;
    			if (i == s.length() - 1 && lengths[c - '0'] < 1) {
    				lengths[c - '0'] = 1;
    			}
    		}
    	}
    	
    	return lengths[1] > lengths[0];
    }
}
}

