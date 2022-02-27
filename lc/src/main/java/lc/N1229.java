package lc;

import alc.MockUtil;
import com.google.common.base.Stopwatch;

import java.util.*;
import java.util.concurrent.*;

/**
 *
 *
 */
public class N1229 {

	public static void main(String[] args) {
		Solution s = new Solution();

		Stopwatch sw = Stopwatch.createStarted();
		System.out.println(s.minAvailableDuration(MockUtil.genIntMatrix("[[10,50],[60,120],[140,210]]"), MockUtil.genIntMatrix("[[0,15],[60,70]]"), 8));
		System.out.println(s.minAvailableDuration(MockUtil.genIntMatrix("[[10,50],[60,120],[140,210]]"), MockUtil.genIntMatrix("[[0,15],[60,70]]"), 12));
		System.out.println("sw: " + sw.elapsed(TimeUnit.MILLISECONDS));
	}

static class Solution {
	/*
	slots1 和 slots2 按照 开始时间 升序排序
	slots1 和 slots2 中查找两人共同的空闲开始时间
	空闲开始时间 + 会议时长 跟 空闲结束时间 比较，不符合的继续往后找
	找到符合的时间区间返回
	当某一个数组结束扔不满足，直接返回 空数组
	 */
	public List<Integer> minAvailableDuration(int[][] slots1, int[][] slots2, int duration) {
		Arrays.sort(slots1, Comparator.comparingInt(a -> a[1]));
		Arrays.sort(slots2, Comparator.comparingInt(a -> a[1]));

		List<Integer> list = new ArrayList<>();
		int i = 0, j = 0, start, end;
		while (slots1[i][1] < duration) {
			i++;
		}
		while (slots2[j][1] < duration) {
			j++;
		}
		while (i < slots1.length && j < slots2.length) {
			start = Math.max(slots1[i][0], slots2[j][0]);
			end = start + duration;
			if (end <= slots1[i][1] && end <= slots2[j][1]) {
				list.add(start);
				list.add(end);
				return list;
			}
			if (end > slots1[i][1]) {
				i++;
			}
			if (end > slots2[j][1]) {
				j++;
			}
		}

		return list;
	}
}
}
