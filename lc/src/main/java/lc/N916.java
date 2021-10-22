package lc;

import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class N916 {

	public static void main(String[] args) {
		Solution s = new N916().new Solution();
	
		System.out.println(s.wordSubsets(new String[]{"amazon","apple","facebook","google","leetcode"}, new String[]{"e","o"}));
		System.out.println(s.wordSubsets(new String[]{"amazon","apple","facebook","google","leetcode"}, new String[]{"e","l"}));
		System.out.println(s.wordSubsets(new String[]{"amazon","apple","facebook","google","leetcode"}, new String[]{"e","oo"}));
		System.out.println(s.wordSubsets(new String[]{"amazon","apple","facebook","google","leetcode"}, new String[]{"eol","o"}));
		System.out.println(s.wordSubsets(new String[]{"amazon","apple","facebook","google","leetcode"}, new String[]{"ec","oc","ceo"}));
		
		System.out.println(s.wordSubsets(new String[]{"abbac","aabac","bbacb","aacac","bcabb"}, new String[]{"c","bc","aa"}));
	}

class Solution {
    public List<String> wordSubsets(String[] words1, String[] words2) {
    	Map<Character, Integer> charMap = new HashMap<>();
    	for (String word2: words2) {
    		Map<Character, Integer> subCharMap = new HashMap<>();
    		for (int i = 0; i < word2.length(); i++) {
    			char c = word2.charAt(i);
    			Integer count = subCharMap.getOrDefault(c, 0) + 1;
    			subCharMap.put(c, count);
    			if (count > charMap.getOrDefault(c, 0)) {
    				charMap.put(c, count);
    			}
    		}
    	}
    	
    	Set<String> failWords = new HashSet<>();
    	for (Map.Entry<Character, Integer> e: charMap.entrySet()) {
    		CharSequence cs = String.valueOf(e.getKey());
	    	for (String word1: words1) {
	    		if (failWords.contains(word1)) {
	    			continue;
	    		}
	    		if (e.getValue() > 1) {
	    			int l = 0;
	    			for (int i = 0; i < word1.length(); i++) {
	    				if (word1.charAt(i) == e.getKey()) {
	    					l++;
	    				}
	    			}
	    			if (l < e.getValue()) {
	    				failWords.add(word1);
		    			continue;
	    			}
	    		} else if (!word1.contains(cs)) {
	    			failWords.add(word1);
	    			continue;
	    		}
	    	}
    	}
    	return Stream.of(words1).filter(word1 -> !failWords.contains(word1)).collect(Collectors.toList());
    }
}
}

