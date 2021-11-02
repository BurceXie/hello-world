package lc;

/**
 * 389. 找不同(1)
 * https://leetcode-cn.com/problems/find-the-difference/
 */
public class N389 {

	public static void main(String[] args) {
		Solution s = new N389().new Solution();

		System.out.println(s);
	}

class Solution {
	public char findTheDifference(String s, String t) {
		int[] charCounts = new int[26];
		for (int i = 0; i < s.length(); i++) {
			charCounts[s.charAt(i) - 'a']++;
		}
		char c = t.charAt(0);
		for (int i = 0; i < t.length(); i++) {
			c = t.charAt(i);
			if (charCounts[c - 'a'] == 0) {
				return c;
			} else {
				charCounts[c - 'a']--;
			}
		}
		return c;
	}
}
}

