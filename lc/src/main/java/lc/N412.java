package lc;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

class N412 {

	public static void main(String[] args) {
		Solution s = new N412().new Solution();

		System.out.println(s.fizzBuzz(40));

	}

	class Solution {
		public List<String> fizzBuzz(int n) {
			return IntStream.rangeClosed(1, n).mapToObj(i -> {
				if (i % 15 == 0) {
					return "FizzBuzz";
				} else if (i % 3 == 0) {
					return "Fizz";
				} else if (i % 5 == 0) {
					return "Buzz";
				} else {
					return String.valueOf(i);
				}
			}).collect(Collectors.toList());
		}
	}

}
