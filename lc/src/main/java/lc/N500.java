package lc;

import java.util.*;
import java.util.stream.*;

import static java.util.stream.Collectors.*;

/**
 * 500. 键盘行
 * https://leetcode-cn.com/problems/keyboard-row/
 * @author Terry
 *
 */
public class N500 {

	public static void main(String[] args) {
		Solution s = new N500().new Solution();
		
	}

class Solution {
    public String[] findWords(String[] words) {
    	String pattern1 = ".*([qwertyuiop]+).*", pattern2 = ".*([asdfghjkl]+).*", pattern3 = ".*([zxcvbnm]+).*";
    	
    	List<String> list = Stream.of(words).filter(word -> {
    		String lowerWord = word.toLowerCase();
    		int matchLines = 0;
    		if (lowerWord.matches(pattern1)) {
    			matchLines++;
    		}
    		if (lowerWord.matches(pattern2)) {
    			matchLines++;
    		}
    		if (lowerWord.matches(pattern3)) {
    			matchLines++;
    		}
    		return matchLines <= 1;
    	}).collect(Collectors.toList());
    	return list.toArray(new String[list.size()]);
    }

    public String[] findWords2(String[] words) {
    	Set<Character> lineSet1 = new HashSet<>(), lineSet2 = new HashSet<>(), lineSet3 = new HashSet<>();
    	String line1 = "qwertyuiop", line2 = "asdfghjkl", line3 = "zxcvbnm";
    	for (int i = 0; i < line1.length(); i++) {
    		lineSet1.add(line1.charAt(i));
    	}
    	for (int i = 0; i < line2.length(); i++) {
    		lineSet2.add(line2.charAt(i));
    	}
    	for (int i = 0; i < line3.length(); i++) {
    		lineSet3.add(line3.charAt(i));
    	}
    	
    	List<String> list = Stream.of(words).filter(word -> {
    		String lowerWord = word.toLowerCase();
    		int inLine1 = 0, inLine2 = 0, inLine3 = 0;
    		for (int i = 0; i < lowerWord.length(); i++) {
    			if (inLine1 == 0 && lineSet1.contains(lowerWord.charAt(i))) {
    				inLine1 = 1;
    			}
    			if (inLine2 == 0 && lineSet2.contains(lowerWord.charAt(i))) {
    				inLine2 = 1;
    			}
    			if (inLine3 == 0 && lineSet3.contains(lowerWord.charAt(i))) {
    				inLine3 = 1;
    			}
    		}
    		return inLine1 + inLine2 + inLine3 <= 1;
    	}).collect(Collectors.toList());
    	return list.toArray(new String[list.size()]);
    }
}
}

