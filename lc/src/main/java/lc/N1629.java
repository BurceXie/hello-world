package lc;

public class N1629 {

	public static void main(String[] args) {
		Solution s = new N1629().new Solution();
		
		System.out.println(s.slowestKey(new int[] {9,29,49,50}, "cbcd"));
		System.out.println(s.slowestKey(new int[] {12,23,36,46,62}, "spuda"));
	}

class Solution {
    public char slowestKey(int[] releaseTimes, String keysPressed) {
    	int max = releaseTimes[0];
    	char charOfMaxTime = keysPressed.charAt(0);
    	for (int i = 1; i < keysPressed.length(); i++) {
    		char c = keysPressed.charAt(i);
    		int time = releaseTimes[i] - releaseTimes[i - 1];
    		if (time > max) {
    			max = time;
    			charOfMaxTime = c;
    		} else if (time == max && c > charOfMaxTime) {
    			charOfMaxTime = c;
    		}
    	}
    	return charOfMaxTime;
    }
}
}

