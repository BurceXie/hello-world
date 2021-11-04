package lc;

import java.util.Objects;

/**
 * 125. 验证回文串(1)
 * https://leetcode-cn.com/problems/valid-palindrome/
 */
public class N125 {

	public static void main(String[] args) {
		Solution s = new N125().new Solution();

		System.out.println(s.isPalindrome("A man, a plan, a canal: Panama"));
		System.out.println(s.isPalindrome("A man, a plan, a anal: Panama"));
		System.out.println(s.isPalindrome("A man, a plan, a Ccanal: Panama"));
		System.out.println(s.isPalindrome("race a car"));
		System.out.println(s.isPalindrome("v"));
		System.out.println(s.isPalindrome("ab_a"));
	}

class Solution {
	public boolean isPalindrome(String s) {
		int length = s.length();
		for (int i = 0, j = length - 1; i < j;) {
			char l = s.charAt(i), r = s.charAt(j);
			if (l < '0' || l > 'z' || (l > '9' && l < 'A') || (l > 'Z' && l < 'a')) {
				i++;
				continue;
			}
			if (r < '0' || r > 'z' || (r > '9' && r < 'A') || (r > 'Z' && r < 'a')) {
				j--;
				continue;
			}
			if (l >= 'a') {
				l -= 32;
			}
			if (r >= 'a') {
				r -= 32;
			}
			if (l != r) {
				return false;
			} else {
				i++;
				j--;
			}
		}

		return true;
	}

	public boolean isPalindrome2(String s) {
		s = s.toLowerCase().replaceAll("[^0-9^a-z]", "");

		int length = s.length();
		if (length % 2 == 0) {
			String s1 = s.substring(0, length / 2);
			String s2 = new StringBuilder(s.substring(length / 2)).reverse().toString();
			return Objects.equals(s1, s2);
		} else {
			String s1 = s.substring(0, length / 2);
			String s2 = new StringBuilder(s.substring(length / 2 + 1)).reverse().toString();
			return Objects.equals(s1, s2);
		}
	}
}
}

