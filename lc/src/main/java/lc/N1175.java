package lc;

import java.math.BigDecimal;

/**
 * 1175. 质数排列(1)
 * https://leetcode-cn.com/problems/prime-arrangements/
 */
public class N1175 {

	public static void main(String[] args) {
		Solution s = new N1175().new Solution();

		System.out.println(s.numPrimeArrangements(45));
	}

class Solution {
	public int numPrimeArrangements(int n) {
		int primeNum = 0, otherNum = 1;
		for (int i = 2; i <= n; i++) {
			boolean isPrime = true;
			for (int j = 2; j < i; j++) {
				if (i % j == 0) {
					isPrime = false;
					break;
				} else if (j * j > i) {
					break;
				}
			}
			if (isPrime) {
				primeNum++;
			} else {
				otherNum++;
			}
		}

		BigDecimal d = BigDecimal.valueOf(1L);
		for (int i = 2; i <= primeNum; i++) {
			d = d.multiply(BigDecimal.valueOf(i));
		}
		for (int i = 2; i <= otherNum; i++) {
			d = d.multiply(BigDecimal.valueOf(i));
		}
		return (d. remainder(BigDecimal.valueOf(1_000_000_007))).intValue();
	}
	public int numPrimeArrangements2(int n) {
		int primeNum = 0, otherNum = 1;
		for (int i = 2; i <= n; i++) {
			boolean isPrime = true;
			for (int j = 2; j < i; j++) {
				if (i % j == 0) {
					isPrime = false;
					break;
				} else if (j * j > i) {
					break;
				}
			}
			if (isPrime) {
				primeNum++;
			} else {
				otherNum++;
			}
		}

		long num = 1L, modNum = 1_000_000_007L;
		for (int i = 2; i <= primeNum; i++) {
			num = num * i % modNum;
		}
		for (int i = 2; i <= otherNum; i++) {
			num = num * i % modNum;
		}
		return (int) num;
	}
}
}

