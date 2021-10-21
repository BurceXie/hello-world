package lc;

public class N38 {

	public static void main(String[] args) {
		Solution s = new N38().new Solution();
		
		for (int i = 1; i <= 30; i++ ) {
			System.out.println(s.countAndSay(i));
		}
	}

	class Solution {
		public String countAndSay(int n) {
			if (n == 1) {
				return "1";
			}
			
			String lastLevel = countAndSay(n - 1);
			String thisLevel = "";
			char c = lastLevel.charAt(0);
			int length = 1;
			for (int i = 1; i < lastLevel.length(); i++) {
				if (lastLevel.charAt(i) != c) {
					thisLevel += (String.valueOf(length) + c);
					c = lastLevel.charAt(i);
					length = 1;
				} else {
					length++;
				}
			}
			thisLevel += (String.valueOf(length) + c);
			
			return thisLevel;
	    }
	}
}

