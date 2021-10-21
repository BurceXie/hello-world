package lc;

import java.math.BigInteger;
import java.util.Objects;

public class N166 {

	public static void main(String[] args) {
		Solution s = new N166().new Solution();

		System.out.println(s.fractionToDecimal(1, 2));
//		BigInteger bi1 = BigInteger.valueOf(10L);
//		System.out.println(bi1.gcd(BigInteger.valueOf(15L)));
//		System.out.println(Math.floorMod(10, 15));
//		System.out.println(Math.floorMod(8, 12));
	}
    
    class Solution {
    	
    	// TODO
    	public String fractionToDecimal(int numerator, int denominator) {
    		if (numerator == 0) {
    			return "0";
    		}
    		if (Objects.equals(numerator, denominator)) {
    			return "1";
    		}
    		
    		BigInteger gcd = BigInteger.valueOf(numerator).gcd(BigInteger.valueOf(denominator));
    		numerator /= gcd.intValue();
    		denominator /= gcd.intValue();
    		
    		int d = denominator;
    		while (d % 2 == 0) {
    			d = d / 2;
    		}
    		while (d % 5 == 0) {
    			d = d / 5;
    		}
    		boolean isLoop = (d != 1);
    		
    		// < 1
    		if (numerator < denominator) {
    			

    		}

    		// > 1
    		int mod = numerator % denominator;
    		if (mod == 0) {
    			return String.valueOf(numerator / denominator);
    		}
    		
    		return "";
    	}
    }

}
