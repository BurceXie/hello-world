package lc;

import java.util.PriorityQueue;

public class N1337 {

	public static void main(String[] args) {
		Solution s = new N1337().new Solution();
		
	}

class Solution {
    public int[] kWeakestRows(int[][] mat, int k) {
    	PriorityQueue<Integer> pq = new PriorityQueue<Integer>();
    	int row = mat.length, column = mat[0].length;
    	boolean findZero = false;
    	for (int i = 0; i < row; i++) {
    		findZero = false;
    		for (int j = 0; j < column; j++) {
    			if (mat[i][j] == 0) {
    				pq.add(10000 + j * 100 + i);
    				findZero = true;
    				break;
    			}
    		}
    		if (!findZero) {
    			pq.add(20000 + i);
    		}
    	}
    	
    	int[] rows = new int[k];
    	for (int i = 0; i < rows.length; i++) {
    		rows[i] = pq.poll() % 100;
    	}
    	return rows;
    }
}
}

