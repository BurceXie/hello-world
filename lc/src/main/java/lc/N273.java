package lc;

public class N273 {

	private static String[] ones = { "Zero", "One", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine",
			"Ten", "Eleven", "Twelve", "Thirteen", "Fourteen", "Fifteen", "Sixteen", "Seventeen", "Eighteen",
			"Nineteen" };
	private static String[] tens = { "Twenty", "Thirty", "Forty", "Fifty", "Sixty", "Seventy", "Eighty", "Ninety" };

	public static void main(String[] args) {
		Solution s = new N273().new Solution();

		System.out.println(s.numberToWords(0));
		System.out.println(s.numberToWords(12));
		System.out.println(s.numberToWords(110));
		System.out.println(s.numberToWords(1_000));
		System.out.println(s.numberToWords(12_345));
		System.out.println(s.numberToWords(1_000_000));
		System.out.println(s.numberToWords(1_000_010));
		System.out.println(s.numberToWords(12_345_789));
		System.out.println(s.numberToWords(54_951));
	}

	class Solution {
		public String numberToWords(int num) {
			String words = "";
			if (num < 1000) {
				words = shortNumberToWords(num, "", true);
			} else if (num < 1000_000) {
				int shortNum1 = num % 1000;
				int shortNum2 = num / 1000;
				words = shortNumberToWords(shortNum2, "Thousand", false) + " "
						+ shortNumberToWords(shortNum1, "", false);
			} else if (num < 1000_000) {
				int shortNum1 = num % 1000;
				num = num / 1000;
				int shortNum2 = num % 1000;
				num = num / 1000;
				int shortNum3 = num % 1000;
				words = shortNumberToWords(shortNum3, "Million", false) + " "
						+ shortNumberToWords(shortNum2, "Thousand", false) + " "
						+ shortNumberToWords(shortNum1, "", false);
			} else {
				int shortNum1 = num % 1000;
				num = num / 1000;
				int shortNum2 = num % 1000;
				num = num / 1000;
				int shortNum3 = num % 1000;
				num = num / 1000;
				int shortNum4 = num % 1000;
				words = shortNumberToWords(shortNum4, "Billion", false) + " "
						+ shortNumberToWords(shortNum3, "Million", false) + " "
						+ shortNumberToWords(shortNum2, "Thousand", false) + " "
						+ shortNumberToWords(shortNum1, "", false);
			}

			return words.replaceAll("\\s+", " ").trim();
		}

		private String shortNumberToWords(int shortNum, String thousand, boolean showZero) {
			String words = "";
			if (shortNum == 0) {
				if (showZero) {
					words = ones[0];
				}
			} else if (shortNum < 20) {
				words = ones[shortNum] + " " + thousand;
			} else if (shortNum < 1000) {
				int n1 = shortNum % 10;
				int n12 = shortNum % 100;
				int n2 = n12 / 10;
				int n3 = shortNum / 100;
				if (n3 > 0) {
					words += " " + ones[n3] + " Hundred";
				}
				if (n12 > 0 && n12 < 20) {
					words += " " + ones[n12];
				} else {
					if (n2 > 0) {
						words += " " + tens[n2 - 2];
					}
					if (n1 > 0) {
						words += " " + ones[n1];
					}
				}
				words += " " + thousand;
			}

			return words;
		}
	}

}
