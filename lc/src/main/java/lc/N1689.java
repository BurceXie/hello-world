package lc;

/**
 * 1689. 十-二进制数的最少数目(2)
 * https://leetcode-cn.com/problems/partitioning-into-minimum-number-of-deci-binary-numbers/
 */
public class N1689 {

	public static void main(String[] args) {
		Solution s = new N1689().new Solution();

		System.out.println(s);
	}

class Solution {
	public int minPartitions(String n) {
		char max = '0';
		for (int i = 0; i < n.length(); i++) {
			char c = n.charAt(i);
			if (c > max) {
				max = c;
			}
			if (max == '9') {
				break;
			}
		}
		return max - '0';
	}
}
}

