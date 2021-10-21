package lc;

public class N7 {

	public static void main(String[] args) {
		Solution s = new N7().new Solution();

    	System.out.println("0 " + s.reverse2(0));
    	System.out.println("123 " + s.reverse2(123));
    	System.out.println("-123 " + s.reverse2(-123));
    	System.out.println(Integer.MAX_VALUE + " " + s.reverse2(Integer.MAX_VALUE));
    	System.out.println(Integer.MIN_VALUE + " " + s.reverse2(Integer.MIN_VALUE));
    	System.out.println("1534236469 " + s.reverse2(1534236469));
    	System.out.println("-2147483412 " + s.reverse2(-2147483412));
    	System.out.println("1463847412 " + s.reverse2(1463847412));
    }
    
    class Solution {
    	public int reverse(int x) {
    		if (x == 0) {
    			return 0;
    		}

    		if (x > 0) {
    			String max = String.valueOf(Integer.MAX_VALUE);
    			String r = new StringBuffer(String.valueOf(x)).reverse().toString();
    			return (r.length() < 10 || r.compareTo(max) <= 0) ? Integer.parseInt(r) : 0;
    		} else {
    			String min = String.valueOf(Integer.MIN_VALUE).substring(1);
    			String r = new StringBuffer(String.valueOf(x).substring(1)).reverse().toString();
    			return (r.length() < 10 || r.compareTo(min) <= 0) ? Integer.parseInt("-" + r) : 0;
    		}
    	}
    	
    	public int reverse2(int x) {
    		if (x == 0) {
    			return 0;
    		}
    		
    		char[] maxIntChars = String.valueOf(Integer.MAX_VALUE).toCharArray();
    		char[] minIntChars = String.valueOf(Integer.MIN_VALUE).toCharArray();

    		if (x > 0) {
    			String s = String.valueOf(x);
    			int n = 0;
    			if (s.length() == maxIntChars.length) {
    				boolean needCheck = true;
    				for (int i = s.length() - 1, j = 0; i >= 0; i--, j++) {
    					if (needCheck && s.charAt(i) > maxIntChars[j]) {
    						return 0;
    					} else if (s.charAt(i) < maxIntChars[j]) {
    						needCheck = false;
    					}
    					n = n * 10 + (s.charAt(i) - 48);
    				}
    			} else {
    				for (int i = s.length() - 1; i >= 0; i--) {
    					n = n * 10 + (s.charAt(i) - 48);
    				}
    			}
    			return n;
    		} else {
    			String s = String.valueOf(x);
    			int n = 0;
    			if (s.length() == minIntChars.length) {
    				boolean needCheck = true;
    				for (int i = s.length() - 1, j = 1; i > 0; i--, j++) {
    					if (needCheck && s.charAt(i) > minIntChars[j]) {
    						return 0;
    					} else if (s.charAt(i) < minIntChars[j]) {
    						needCheck = false;
    					}
    					n = -1 * (Math.abs(n) * 10 + (s.charAt(i) - 48));
    				}
    			} else {
    				for (int i = s.length() - 1; i > 0; i--) {
    					n = -1 * (Math.abs(n) * 10 + (s.charAt(i) - 48));
    				}
    			}
    			return n;
    		}
    	}
    }
}
