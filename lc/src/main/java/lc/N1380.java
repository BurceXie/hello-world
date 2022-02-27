package lc;

import com.google.common.base.Stopwatch;

import java.util.*;
import java.util.concurrent.*;

/**
 *
 *
 */
public class N1380 {

	public static void main(String[] args) {
		Solution s = new N1380().new Solution();

		Stopwatch sw = Stopwatch.createStarted();
		System.out.println(s.luckyNumbers(new int[][]{{7,8},{1,2}}));
		System.out.println("sw: " + sw.elapsed(TimeUnit.MILLISECONDS));
	}

class Solution {
	public List<Integer> luckyNumbers (int[][] matrix) {
		List<Integer> luckyNumbers = new ArrayList<>();
		int m = matrix.length, n = matrix[0].length;
		int[][] columnMaxIndex = new int[n][2];

		for (int j = 0; j < n; j++) {
			int max = matrix[0][j];
			int index = 0;
			for (int i = 1; i < m; i++) {
				if (matrix[i][j] > max) {
					max = matrix[i][j];
					index = i;
				}
			}
			columnMaxIndex[j][0] = max;
			columnMaxIndex[j][1] = index;
		}

		for (int[] maxIndex : columnMaxIndex) {
			int index = maxIndex[1];
			Arrays.sort(matrix[index]);
			if (matrix[index][0] == maxIndex[0]) {
				luckyNumbers.add(maxIndex[0]);
			}
		}
		return luckyNumbers;
	}
}
}

