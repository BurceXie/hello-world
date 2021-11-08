package lc;

/**
 *299. 猜数字游戏(2)
 *https://leetcode-cn.com/problems/bulls-and-cows/
 */
public class N299 {

	public static void main(String[] args) {
		Solution s = new N299().new Solution();

		System.out.println(s);
	}

class Solution {
	public String getHint(String secret, String guess) {
		if (secret.equals(guess)) {
			return secret.length() + "A0B";
		}

		int countA = 0, countB = 0;
		int[] secretNumberCount = new int[10], guessNumberCount = new int[10];
		for (int i = 0; i < secret.length(); i++) {
			int s = secret.charAt(i) - '0';
			int g = guess.charAt(i) - '0';
			if (s == g) {
				countA++;
			} else {
				secretNumberCount[s]++;
				guessNumberCount[g]++;
			}
		}
		for (int i = 0; i < 10; i++) {
			countB += Math.min(secretNumberCount[i], guessNumberCount[i]);
		}

		return countA + "A" + countB + "B";
	}
}
}

