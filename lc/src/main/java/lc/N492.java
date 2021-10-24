package lc;

public class N492 {

	public static void main(String[] args) {
		Solution s = new N492().new Solution();
		
		int[] lAndw = s.constructRectangle(4);
		System.out.println("[" + lAndw[0] + "," + lAndw[1] + "]");
		
		lAndw = s.constructRectangle(234);
		System.out.println("[" + lAndw[0] + "," + lAndw[1] + "]");
		
		lAndw = s.constructRectangle(524);
		System.out.println("[" + lAndw[0] + "," + lAndw[1] + "]");
		
		lAndw = s.constructRectangle(431434);
		System.out.println("[" + lAndw[0] + "," + lAndw[1] + "]");
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
