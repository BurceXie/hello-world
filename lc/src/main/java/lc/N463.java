package lc;

import alc.MockUtil;
import com.google.common.base.Stopwatch;

import java.util.*;
import java.util.concurrent.*;

/**
 *
 *
 */
public class N463 {

	public static void main(String[] args) {
		Solution s = new Solution();

		Stopwatch sw = Stopwatch.createStarted();
		System.out.println(s.islandPerimeter(MockUtil.genIntMatrix("[[1, 1, 0], [1, 1, 1]]")));
		System.out.println(s.islandPerimeter(MockUtil.genIntMatrix("[[0,1,0,0], [1,1,1,0], [0,1,0,0], [1,1,0,0]]")));
		System.out.println(s.islandPerimeter(MockUtil.genIntMatrix("[[1,0]]")));
		System.out.println("sw: " + sw.elapsed(TimeUnit.MILLISECONDS));
	}

static class Solution {
	public int islandPerimeter(int[][] grid) {
		int perimeter = 0;
		int[] firstP = findFirst(grid);
		if (firstP[0] == -1 && firstP[1] == -1) {
			return perimeter;
		}

		Queue<int[]> queue = new LinkedList<>();
		queue.offer(firstP);
		grid[firstP[0]][firstP[1]] = 2;

		while (!queue.isEmpty()) {
			int[] p = queue.poll();
			perimeter += 4;
			grid[p[0]][p[1]] = 3;
			System.out.println(Arrays.toString(p) + " " + perimeter);

			if (p[0] - 1 >= 0) {
				int v = grid[p[0] - 1][p[1]];
				if (v == 3) {
					perimeter -= 2;
				} else if (v == 1) {
					int[] up = new int[]{p[0] - 1, p[1]};
					queue.offer(up);
					grid[p[0] - 1][p[1]] = 2;
				}
			}
			if (p[0] + 1 < grid.length) {
				int v = grid[p[0] + 1][p[1]];
				if (v == 3) {
					perimeter -= 2;
				} else if (v == 1) {
					int[] down = new int[]{p[0] + 1, p[1]};
					queue.offer(down);
					grid[p[0] + 1][p[1]] = 2;
				}
			}
			if (p[1] - 1 >= 0) {
				int v = grid[p[0]][p[1] - 1];
				if (v == 3) {
					perimeter -= 2;
				} else if (v == 1) {
					int[] left = new int[]{p[0], p[1] - 1};
					queue.offer(left);
					grid[p[0]][p[1] - 1] = 2;
				}
			}
			if (p[1] + 1 < grid[0].length) {
				int v = grid[p[0]][p[1] + 1];
				if (v == 3) {
					perimeter -= 2;
				} else if (v == 1) {
					int[] right = new int[]{p[0], p[1] + 1};
					queue.offer(right);
					grid[p[0]][p[1] + 1] = 2;
				}
			}
			System.out.println(Arrays.toString(p) + " " + perimeter);
			System.out.println(queue.size());
		}

		return perimeter;
	}

	private int[] findFirst(int[][] grid) {
		int[] first = new int[]{-1, -1};
		for (int i = 0; i < grid.length; i++) {
			for (int j = 0; j < grid[i].length; j++) {
				if (grid[i][j] == 1) {
					first[0]= i;
					first[1]= j;
					return first;
				}
			}
		}
		return first;
	}
}
}

