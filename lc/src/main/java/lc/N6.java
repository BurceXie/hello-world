package lc;

import java.util.stream.Collectors;
import java.util.stream.Stream;

public class N6 {

	public static void main(String[] args) {
		Solution s = new N6().new Solution();

		System.out.println(s.convert("PAYPALISHIRING", 1));
		System.out.println(s.convert("PAYPALISHIRING", 2));
		System.out.println(s.convert("PAYPALISHIRING", 3));
		System.out.println(s.convert("PAYPALISHIRING", 4));
	}

	class Solution {
	    public String convert(String s, int numRows) {
	    	if (numRows == 1) {
	    		return s;
	    	}
	    	
	    	String[] ss = new String[numRows];
	    	for (int i = 0; i < numRows; i++) {
	    		ss[i] = "";
	    	}
	    	
	    	boolean down = true;
	    	for (int i = 0, l = 0; i < s.length(); i++) {
	    		if (down) {
    				ss[l++] += s.charAt(i);
    				if (l == numRows) {
    					if (numRows > 2) {
    						down = false;
    						l = numRows - 2;
    					} else {
    						l = 0;
    					}
    				}
	    		} else {
	    			ss[l--] += s.charAt(i);
	    			if (l == 0) {
	    				down = true;
	    			}
	    		}
	    	}
	    	
	    	return Stream.of(ss).collect(Collectors.joining());
	    }
	}
}

