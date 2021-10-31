package lc;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * 22. 括号生成(2)
 * https://leetcode-cn.com/problems/generate-parentheses/
 * @author Terry
 *
 */
public class N22 {

	public static void main(String[] args) {
		Solution s = new N22().new Solution();

		for (int i = 1; i <= 8; i++) {
			List<String> l = s.generateParenthesis2(i);
			System.out.println(l.size());
			System.out.println(l);
		}
	}

	class Solution {
		
		// TODO
		public List<String> generateParenthesis(int n) {
			Set<String> set = generateParenthesisSet(n);
			return set.stream().sorted().filter(s -> {
				int k = 0;
				for (int i = 0; i < s.length(); i++) {
					if (k < 0) {
						return false;
					} else if (s.charAt(i) == '(') {
						k++;
					} else {
						k--;
					}
				}
				return k == 0;
			}).collect(Collectors.toList());
		}

		public Set<String> generateParenthesisSet(int n) {
			Set<String> set = new HashSet<>();
			if (n == 1) {
				set.add("()");
				set.add(")(");
				return set;
			}

			Set<String> subSet = generateParenthesisSet(n - 1);
			subSet.stream().forEach(s -> {
				set.add("()" + s);
				set.add("(" + s + ")");
				set.add(s + "()");
				set.add(")" + s + "(");
			});
			return set;
		}

		ArrayList[] cache = new ArrayList[100];

		public List<String> generate(int n) {
			if (cache[n] != null) {
				return cache[n];
			}
			ArrayList<String> ans = new ArrayList<String>();
			if (n == 0) {
				ans.add("");
			} else {
				for (int c = 0; c < n; ++c) {
					for (String left : generate(c)) {
						for (String right : generate(n - 1 - c)) {
							ans.add("(" + left + ")" + right);
						}
					}
				}
			}
			cache[n] = ans;
			return ans;
		}

		public List<String> generateParenthesis2(int n) {
			return generate(n).stream().sorted().collect(Collectors.toList());
		}
	}
}
