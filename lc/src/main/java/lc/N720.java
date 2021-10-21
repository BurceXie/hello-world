package lc;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class N720 {

	public static void main(String[] args) {
		Solution s = new N720().new Solution();

		System.out.println(s.longestWord(new String[] { "w", "wo", "wor", "worl", "world" }));
		System.out.println(s.longestWord(new String[] { "a", "banana", "app", "appl", "ap", "apply", "apple" }));
	}

	class Solution {
		public String longestWord(String[] words) {
			List<String> list = new ArrayList<>();
			List<String> sortedList = Stream.of(words).sorted((s1, s2) -> s1.length() - s2.length())
					.collect(Collectors.toList());

			int maxLength = 1;
			for (String word : sortedList) {
				int length = word.length();
				if (length == 1) {
					list.add(word);
				} else {
					String prevWord = word.substring(0, length - 1);
					if (list.contains(prevWord)) {
						list.add(word);
						if (length > maxLength) {
							maxLength = length;
						}
					}
				}
			}

			int findLenght = maxLength;
			return list.stream().sorted().filter(s -> s.length() == findLenght).findFirst().orElse("");
		}
	}

}
