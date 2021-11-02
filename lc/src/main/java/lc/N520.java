package lc;

/**
 * 520. 检测大写字母(1)
 * https://leetcode-cn.com/problems/detect-capital/
 */
public class N520 {

	public static void main(String[] args) {
		Solution s = new N520().new Solution();

		System.out.println(s);
	}

class Solution {
	public boolean detectCapitalUse(String word) {
		if (word.length() <= 1) {
			return true;
		}

		char f = word.charAt(0), c = word.charAt(1);
		boolean isFirstUpper = (f >= 'A' && f <= 'Z'), isUpper = (c >= 'A' && c <='Z');
		if (!isFirstUpper && isUpper) {
			return false;
		}
		boolean ok = true;
		for (int i = 1; i< word.length(); i++) {
			c = word.charAt(i);
			if (isUpper && (c >= 'a' && c <= 'z')) {
				ok = false;
				break;
			} else if (!isUpper && (c >= 'A' && c <= 'Z')) {
				ok = false;
				break;
			}
		}
		return ok;
	}
}
}

