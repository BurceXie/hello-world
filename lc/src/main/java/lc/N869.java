package lc;

import java.util.Comparator;
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
		// 每一位数字长度范围内 2的幂数 的最小值和最大值
		int[][] powers = new int[][] {{}, {0,3}, {4,6}, {7,9}, {10,13}, {14,16}, {17,19}, {20, 23}, {24, 26}, {27, 29}};

			String descStr = Stream.of(String.valueOf(n).split("")).sorted(Comparator.reverseOrder())
					.collect(Collectors.joining());
			for (int power = powers[descStr.length()][0]; power <= powers[descStr.length()][1]; power++) {
				String curStr = String.valueOf(1 << power);
				String curDescStr = Stream.of(curStr.split("")).sorted(Comparator.reverseOrder())
						.collect(Collectors.joining());
				if (Objects.equals(descStr, curDescStr)) {
					return true;
				}
			}

		return false;
	}
}
}

