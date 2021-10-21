package lc;

public class N476 {

	public static void main(String[] args) {
		Solution s = new N476().new Solution();

		for (int i = 1; i <= 100; i++) {
			System.out.println(s.findComplement(i));
			System.out.println(s.findComplement2(i));
			System.out.println();
		}
		
		System.out.println(s.findComplement(Integer.MAX_VALUE));
		System.out.println(s.findComplement2(Integer.MAX_VALUE));
	}

	class Solution {
		public int findComplement(int num) {
			String binary = Integer.toBinaryString(num);
			if (!binary.contains("0")) {
				return 0;
			}
			String complementBinary = "";
			boolean findZero = false;
			for (int i = 0; i < binary.length(); i++) {
				if (binary.charAt(i) == '0') {
					findZero = true;
					complementBinary += '1';
				} else if (findZero) {
					complementBinary += '0';
				}
			}
			return Integer.valueOf(complementBinary, 2);
		}
		
		public int findComplement2(int num) {
			String binary = Integer.toBinaryString(num);
			if (!binary.contains("0")) {
				return 0;
			}
			
			int pow = (int)(Math.pow(2, binary.length()) - 1);
			return pow ^ num;
		}
	}
}
