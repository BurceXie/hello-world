package lc;

/**
 * 3. 无重复字符的最长子串(2)
 * https://leetcode-cn.com/problems/longest-substring-without-repeating-characters
 */
public class N3 {

	public static void main(String[] args) {
		Solution s = new N3().new Solution();

		String str = "abcabcbb";

		System.out.println(s.findLengthOfLongestSubstring(str));
		System.out.println(s.findLengthOfLongestSubstring2(str));
	}

	class Solution {
		public int findLengthOfLongestSubstring(String s) {
			int length = 0, start = 0, end = 1;

			if (s == null || s.length() == 0) {
				return length;
			}

			length = 1;
			for (; start < s.length() && end < s.length(); end++) {
				String c = s.substring(end, end + 1);
				if (s.substring(start, end).contains(c)) {
					if (end - start > length) {
						length = end - start;
					}
					start = s.indexOf(c, start) + 1;
				}
			}

			if (end - start > length) {
				length = end - start;
			}

			return length;
		}

		public int findLengthOfLongestSubstring2(String s) {
			int length = 0, start = 0, end = 1;

			if (s == null || s.length() == 0) {
				return length;
			}

			length = 1;
			for (; start < s.length() && end < s.length(); end++) {
				char c = s.charAt(end);
				int index = s.indexOf(c, start);
				if (index >= start && index < end) {
					if (end - start > length) {
						length = end - start;
					}
					start = index + 1;
				}
			}

			if (end - start > length) {
				length = end - start;
			}

			return length;
		}
	}
}
