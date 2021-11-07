package w266;

import java.util.Comparator;
import java.util.stream.Stream;

/**
 *5918. 统计字符串中的元音子字符串(1)
 *https://leetcode-cn.com/contest/weekly-contest-266/problems/count-vowel-substrings-of-a-string/
 */
public class N5918 {

	public static void main(String[] args) {
		Solution s = new N5918().new Solution();

		System.out.println(s.countVowelSubstrings("aeiou"));
		System.out.println(s.countVowelSubstrings("unicornarihan"));
		System.out.println(s.countVowelSubstrings("cuaieuouac"));
		System.out.println(s.countVowelSubstrings("bbaeixoubb"));
		System.out.println(s.countVowelSubstrings("duuebuaeeeeeeuaoeiueaoui"));
	}

class Solution {
	public int countVowelSubstrings(String word) {
		if (word.length() < 5) {
			return 0;
		}

		int first = Stream.of('a', 'e', 'i', 'o', 'u').map(c -> word.indexOf(c)).sorted().findFirst().orElse(-1);
		int last = Stream.of('a', 'e', 'i', 'o', 'u').map(c -> word.lastIndexOf(c)).sorted(Comparator.reverseOrder()).findFirst().orElse(-1);
		if (first == -1 || last < first + 4) {
			return 0;
		}

		int count = 0;
		for (int i = first; i <= last - 4; i++) {
			for (int j = i + 5; j <= last + 1; j++) {
				String substr = word.substring(i, j);
				if (Stream.of('a', 'e', 'i', 'o', 'u').filter(c -> substr.indexOf(c) < 0).findAny().isPresent()) {
					continue;
				}
				if ("".equals(substr.replaceAll("[aeiou]+", ""))) {
					count++;
				}
			}
		}

		return count;
	}
}
}

