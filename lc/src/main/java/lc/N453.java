package lc;

public class N453 {

    public static void main(String[] args) {
    	Solution s = new N453().new Solution();
		
    	System.out.println(s.minMoves(new int[] {-100, 0, 100}));
    	System.out.println(s.minMoves(new int[] {1, 2, 3}));
    	System.out.println(s.minMoves(new int[] {1, 6, 2}));
    	System.out.println(s.minMoves(new int[] {2, -11, 6}));
    	System.out.println(s.minMoves(new int[] {1, 100000000, 10}));
	}
    
    class Solution {
    	public int minMoves(int[] nums) {
    		if (nums.length == 1) {
    			return 0;
    		}
    		int min = nums[0], sum = 0;
    		for (int num : nums) {
    			if (num < min) {
    				min = num;
    			}
    		}
    		for (int num : nums) {
    			sum += num - min;
    		}
    		return sum;
        }
    }
}
