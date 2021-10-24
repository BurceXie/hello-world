package lc.lcp;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LCP40 {

	public static void main(String[] args) {
		Solution s = new LCP40().new Solution();
		
		System.out.println(s.maxmiumScore(new int[] {4,8,3}, 2));
		System.out.println(s.maxmiumScore(new int[] {1,2,8,9}, 3));
		System.out.println(s.maxmiumScore(new int[] {1,3,3}, 1));
		System.out.println(s.maxmiumScore(new int[] {1,3,4,5}, 4));
	}

class Solution {
	public int maxmiumScore(int[] cards, int cnt) {
		int score = 0;
		Arrays.sort(cards);
		List<Integer> oddList = new ArrayList<>(), evenList = new ArrayList<>();
		for (int i = cards.length - 1; i >= 0; i--) {
			if (cards[i] % 2 == 0) {
				if (cnt % 2 == 1 && score == 0) {
					score += cards[i];
					cnt--;
				} else if (evenList.size() < cnt) {
					evenList.add(cards[i]);
				}
			} else if (oddList.size() < cnt) {
				oddList.add(cards[i]);
			}
		}
		for (int i = 0, j = 0; i + j < cnt;) {
			boolean oddEnd = i >= oddList.size() - 1;
			boolean evenEnd = j >= evenList.size() - 1;
			if (oddEnd && evenEnd) {
				if (i + j != cnt) {
					score = 0;
				}
				break;
			} else if (oddEnd) {
				score += evenList.get(j) + evenList.get(j + 1);
				j += 2;
			} else if (evenEnd) {
				score += oddList.get(i) + oddList.get(i + 1);
				i += 2;
			} else {
				int oddTwoScore = oddList.get(i) + oddList.get(i + 1);
				int evenTwoScore = evenList.get(j) + evenList.get(j + 1);
				if (oddTwoScore > evenTwoScore) {
					score += oddTwoScore;
					i += 2;
				} else {
					score += evenTwoScore;
					j += 2;
				}
			}
		}
		return score;
	}
}
}

