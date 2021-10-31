package lc;

/**
 * 661. 图片平滑器(1)
 * https://leetcode-cn.com/problems/image-smoother/
 * @author Terry
 *
 */
public class N661 {

	public static void main(String[] args) {
		Solution s = new N661().new Solution();
		
		System.out.println(s.imageSmoother(new int[][] {{100,200,100},{200,50,200},{100,200,100}}));
	}

class Solution {
    public int[][] imageSmoother(int[][] img) {
    	int row = img.length, column = img[0].length;
    	int[][] boundImgs = new int[row + 2][column + 2];
    	for (int i = 0; i < row + 2; i++) {
    		for (int j = 0; j < column + 2; j++) {
    			if (i == 0 || j == 0 || i == row + 1 || j == column + 1) {
    				boundImgs[i][j] = -1;
    			} else {
    				boundImgs[i][j] = img[i - 1][j - 1];
    			}
    		}
    	}
    	
    	int[][] newImgs = new int[row][column];
    	for (int i = 1; i <= row; i++) {
			for (int j = 1; j <= column; j++) {
				int c = 1, sum = boundImgs[i][j];
				if (boundImgs[i - 1][j - 1] >= 0) {
					sum += boundImgs[i - 1][j - 1];
					c++;
				}
				if (boundImgs[i - 1][j] >= 0) {
					sum += boundImgs[i - 1][j];
					c++;
				}
				if (boundImgs[i - 1][j + 1] >= 0) {
					sum += boundImgs[i - 1][j + 1];
					c++;
				}
				if (boundImgs[i][j - 1] >= 0) {
					sum += boundImgs[i][j - 1];
					c++;
				}
				if (boundImgs[i][j + 1] >= 0) {
					sum += boundImgs[i][j + 1];
					c++;
				}
				if (boundImgs[i + 1][j - 1] >= 0) {
					sum += boundImgs[i + 1][j - 1];
					c++;
				}
				if (boundImgs[i + 1][j] >= 0) {
					sum += boundImgs[i + 1][j];
					c++;
				}
				if (boundImgs[i + 1][j + 1] >= 0) {
					sum += boundImgs[i + 1][j + 1];
					c++;
				}
				newImgs[i - 1][j - 1] = sum / c;
			}
    	}
    	
    	return newImgs;
    }
}
}

