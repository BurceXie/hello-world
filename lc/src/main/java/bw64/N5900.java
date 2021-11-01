package bw64;

import java.util.*;
import java.util.stream.*;
import static java.util.stream.Collectors.*;

/**
 * 5900. 蜡烛之间的盘子(2)
 * https://leetcode-cn.com/contest/biweekly-contest-64/problems/plates-between-candles/
 * https://leetcode-cn.com/problems/plates-between-candles/
 * @author Terry
 *
 */
public class N5900 {

	public static void main(String[] args) {
		Solution s = new N5900().new Solution();
		
//		System.out.println(s.platesBetweenCandles("**|**|***|", new int[][] {{2,5},{5,9}}));
		System.out.println(s.platesBetweenCandles2("***|**|*****|**||**|*", new int[][] {{1,17},{4,5},{14,17},{5,11},{15,16}}));
	}

class Solution {
    public int[] platesBetweenCandles(String s, int[][] queries) {
    	int[] plates = new int[queries.length];
    	int firstCandle = s.indexOf('|'), lastCandle = s.lastIndexOf('|'), firstPlate = s.indexOf('*'), lastPlate = s.lastIndexOf('*');
    	if (firstCandle == -1 || firstPlate == -1) {
    		return plates;
    	}
    	
    	for (int i = 0; i < queries.length; i++) {
    		if (queries[i][0] > lastCandle || queries[i][0] > lastPlate) {
    			plates[i] = 0;
    			continue;
    		}
    		if (queries[i][1] < firstCandle || queries[i][1] < firstPlate) {
    			plates[i] = 0;
    			continue;
    		}
    		int c = 0;
    		int f = queries[i][0], t = queries[i][1];
    		while (f < t) {
    			if (s.charAt(f) == '*') {
    				f++;
    			}
    			if (s.charAt(t) == '*') {
    				t--;
    			}
    			if (s.charAt(f) == '|' && s.charAt(t) == '|') {
    				break;
    			}
    		}
    		for (; f < t; f++) {
    			if (s.charAt(f) == '*') {
    				c++;
    			}
    		}
    		plates[i] = c;
    	}
		return plates;
    }
    
    public int[] platesBetweenCandles2(String s, int[][] queries) {
    	int[] plates = new int[queries.length];
    	int firstCandle = s.indexOf('|'), firstPlate = s.indexOf('*');
    	if (firstCandle == -1 || firstPlate == -1) {
    		return plates;
    	}

		int[] platesSinceFirstCandlesF = new int[s.length()], platesSinceFirstCandlesT = new int[s.length()];
    	int platesSincePrevCandle = 0, prevCandle = -1, suffCandle = platesSinceFirstCandlesT.length;
    	for (int i = 0; i < s.length(); i++) {
    		if (i == 0) {
    			if (s.charAt(i) == '|') {
    				prevCandle = 0;
    			}
    			continue;
    		}
    		if (s.charAt(i) == '|') {
				platesSinceFirstCandlesT[i] = platesSinceFirstCandlesT[i - 1] + platesSincePrevCandle;
    			prevCandle = i;
    			platesSincePrevCandle = 0;
    		} else if (prevCandle == -1) {
				platesSinceFirstCandlesT[i] = 0;
    		} else {
    			platesSincePrevCandle++;
				platesSinceFirstCandlesT[i] = platesSinceFirstCandlesT[i - 1];
    		}
    	}
    	for (int j = s.length() - 1; j >= 0; j--) {
    		if (s.charAt(j) == '|') {
				platesSinceFirstCandlesF[j] = platesSinceFirstCandlesT[j];
				suffCandle = j;
			} else if (suffCandle == platesSinceFirstCandlesT.length){
    			platesSinceFirstCandlesF[j] = platesSinceFirstCandlesT[j];
			} else {
    			platesSinceFirstCandlesF[j] = platesSinceFirstCandlesT[suffCandle];
			}
		}
    	
    	for (int i = 0; i < queries.length; i++) {
    		int from = queries[i][0], to = queries[i][1];
    		System.out.println(from + "\t" + to + "\t" + platesSinceFirstCandlesT[to] + "\t" + platesSinceFirstCandlesF[from]);
    		if (platesSinceFirstCandlesT[to] > platesSinceFirstCandlesF[from]) {
				plates[i] = platesSinceFirstCandlesT[to] - platesSinceFirstCandlesF[from];
			}
    	}
    	
		return plates;
    }
}
}

