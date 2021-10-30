package lc;

import java.util.Objects;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class N869 {

	public static void main(String[] args) {
		Solution s = new N869().new Solution();

		for (int i = 1; i < 1000; i++) {
			if (s.reorderedPowerOf2(i)) {
				System.out.println(i);
			}
		}
	}

class Solution {
	public boolean reorderedPowerOf2(int n) {
		if (n == 1 || n == 2 || n == 4 || n == 8) {
			return true;
		}

		// 每一位数字长度范围内 2的幂数 的最小值和最大值
		int[][] powers = new int[][] { {}, { 0, 3 }, { 4, 6 }, { 7, 9 }, { 10, 13 }, { 14, 16 }, { 17, 19 },
				{ 20, 23 }, { 24, 26 }, { 27, 29 } };

		String sortedStr = Stream.of(String.valueOf(n).split("")).sorted().collect(Collectors.joining());
		int length = sortedStr.length();
		for (int power = powers[length][0]; power <= powers[length][1]; power++) {
			String sordedPowerStr = Stream.of(String.valueOf(1 << power).split("")).sorted()
					.collect(Collectors.joining());
			if (Objects.equals(sortedStr, sordedPowerStr)) {
				return true;
			}
		}

		return false;
	}
}
}
