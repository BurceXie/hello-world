package lc;

public class N66 {

	public static void main(String[] args) {
		Solution s = new N66().new Solution();
		
		System.out.println(s.plusOne(new int[] {1,2,3}));
		System.out.println(s.plusOne(new int[] {9,9,9}));
		System.out.println(s.plusOne(new int[] {0}));
	}

class Solution {
    public int[] plusOne(int[] digits) {
    	if (digits[0] == 0) {
    		return new int[] {1};
    	}
    	
    	boolean allNine = true;
    	for (int digit: digits) {
    		if (digit != 9) {
    			allNine = false;
    			break;
    		}
    	}
    	if (allNine) {
    		int[] result = new int[digits.length + 1];
    		result[0] = 1;
    		return result;
    	}
    	
    	for (int carry = 1, i = digits.length - 1; i >= 0; i--) {
    		if (digits[i] == 9 && carry == 1) {
    			digits[i] = 0;
    			carry = 1;
    		} else {
    			digits[i]++;
    			break;
    		}
    	}
    	return digits;
    }
}
}

