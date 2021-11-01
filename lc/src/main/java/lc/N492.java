package lc;

import java.util.Arrays;

public class N492 {

	public static void main(String[] args) {
		Solution s = new N492().new Solution();
		
		System.out.println(Arrays.toString(s.constructRectangle(4)));
		System.out.println(Arrays.toString(s.constructRectangle(234)));
		System.out.println(Arrays.toString(s.constructRectangle(524)));
		System.out.println(Arrays.toString(s.constructRectangle(431434)));
	}

class Solution {
    public int[] constructRectangle(int area) {
    	int l = area, w = 1;
    	for (int _w = w; _w <= area; _w++) {
    		int _l = area / _w;
    		if (_w > _l) {
    			break;
    		}
    		if (_l * _w == area) {
    			l = _l;
    			w = _w;
    		}
    	}
    	return new int[] {l, w};
    }
}
}
