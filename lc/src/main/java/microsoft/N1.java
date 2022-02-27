package microsoft;

import com.google.common.base.Stopwatch;

import java.util.concurrent.*;

/**
 *
 *
 */
public class N1 {

	public static void main(String[] args) {
		Solution s = new Solution();

		Stopwatch sw = Stopwatch.createStarted();
		System.out.println(s.cutString("ayxbx"));
		System.out.println(s.cutString2("ayxbx"));
		System.out.println(s.cutString3("ayxbx"));
		System.out.println(s.cutString("xzzzy"));
		System.out.println(s.cutString2("xzzzy"));
		System.out.println(s.cutString3("xzzzy"));
		System.out.println(s.cutString("toyxmy"));
		System.out.println(s.cutString2("toyxmy"));
		System.out.println(s.cutString3("toyxmy"));
		System.out.println(s.cutString("apple"));
		System.out.println(s.cutString2("apple"));
		System.out.println(s.cutString3("apple"));
		System.out.println("sw: " + sw.elapsed(TimeUnit.MILLISECONDS));
	}

static class Solution {
	public int cutString(String s) {
		int n = s.length(), count = 0;
		int[] leftXArr = new int[n - 1], leftYArr = new int[n - 1], rightXArr = new int[n - 1], rightYArr = new int[n - 1];
		leftXArr[0] = (s.charAt(0) == 'x') ? 1 : 0;
		leftYArr[0] = (s.charAt(0) == 'y') ? 1 : 0;
		rightXArr[rightXArr.length - 1] = (s.charAt(n - 1) == 'x') ? 1 : 0;
		rightYArr[rightYArr.length - 1] = (s.charAt(n - 1) == 'y') ? 1 : 0;

		for (int cutIndex = 1; cutIndex < leftXArr.length; cutIndex++) {
			int c = s.charAt(cutIndex);
			if (c == 'x') {
				leftXArr[cutIndex] = leftXArr[cutIndex - 1] + 1;
				leftYArr[cutIndex] = leftYArr[cutIndex - 1];
			} else if (c == 'y') {
				leftYArr[cutIndex] = leftYArr[cutIndex - 1] + 1;
				leftXArr[cutIndex] = leftXArr[cutIndex - 1];
			} else {
				leftXArr[cutIndex] = leftXArr[cutIndex - 1];
				leftYArr[cutIndex] = leftYArr[cutIndex - 1];
			}
		}

		for (int cutIndex = rightXArr.length - 2; cutIndex >= 0; cutIndex--) {
			int c = s.charAt(cutIndex + 1);
			if (c == 'x') {
				rightXArr[cutIndex] = rightXArr[cutIndex + 1] + 1;
				rightYArr[cutIndex] = rightYArr[cutIndex + 1];
			} else if (c == 'y') {
				rightYArr[cutIndex] = rightYArr[cutIndex + 1] + 1;
				rightXArr[cutIndex] = rightXArr[cutIndex + 1];
			} else {
				rightXArr[cutIndex] = rightXArr[cutIndex + 1];
				rightYArr[cutIndex] = rightYArr[cutIndex + 1];
			}
		}
//		System.out.println("leftXArr  = " + Arrays.toString(leftXArr));
//		System.out.println("leftYArr  = " + Arrays.toString(leftYArr));
//		System.out.println("rightXArr = " + Arrays.toString(rightXArr));
//		System.out.println("rightYArr = " + Arrays.toString(rightYArr));

		for (int cutIndex = 0; cutIndex < n - 1; cutIndex++) {
			if (leftXArr[cutIndex] == leftYArr[cutIndex] || rightXArr[cutIndex] == rightYArr[cutIndex]) {
				count++;
			}
		}

		return count;
	}

	public int cutString2(String s) {
		int n = s.length(), xCount = 0, yCount = 0, count = 0;
		int[] leftXArr = new int[n - 1], leftYArr = new int[n - 1], rightXArr = new int[n - 1], rightYArr = new int[n - 1];

		if (s.charAt(0) == 'x') {
			leftXArr[0] = 1;
			xCount++;
		} else if (s.charAt(0) == 'y') {
			leftYArr[0] = 1;
			yCount++;
		}

		for (int cutIndex = 1; cutIndex < leftXArr.length; cutIndex++) {
			int c = s.charAt(cutIndex);
			if (c == 'x') {
				leftXArr[cutIndex] = leftXArr[cutIndex - 1] + 1;
				leftYArr[cutIndex] = leftYArr[cutIndex - 1];
				xCount++;
			} else if (c == 'y') {
				leftYArr[cutIndex] = leftYArr[cutIndex - 1] + 1;
				leftXArr[cutIndex] = leftXArr[cutIndex - 1];
				yCount++;
			} else {
				leftXArr[cutIndex] = leftXArr[cutIndex - 1];
				leftYArr[cutIndex] = leftYArr[cutIndex - 1];
			}
		}

		if (s.charAt(n - 1) == 'x') {
			xCount++;
		} else if (s.charAt(n - 1) == 'y') {
			yCount++;
		}
		for (int cutIndex = 0; cutIndex < leftXArr.length; cutIndex++) {
			rightXArr[cutIndex] = xCount - leftXArr[cutIndex];
			rightYArr[cutIndex] = yCount - leftYArr[cutIndex];
		}

//		System.out.println("leftXArr  = " + Arrays.toString(leftXArr));
//		System.out.println("leftYArr  = " + Arrays.toString(leftYArr));
//		System.out.println("rightXArr = " + Arrays.toString(rightXArr));
//		System.out.println("rightYArr = " + Arrays.toString(rightYArr));

		for (int cutIndex = 0; cutIndex < n - 1; cutIndex++) {
			if (leftXArr[cutIndex] == leftYArr[cutIndex] || rightXArr[cutIndex] == rightYArr[cutIndex]) {
				count++;
			}
		}

		return count;
	}

	public int cutString3(String s) {
		/*
		遍历字符串，用一个数组 diff[] 记录每一位切割后左侧的 x数量 xCount 和 y数量 yCount 的差值 (xCount - yCount)
		切割到 i 时，通过 diff[i - 1] 和 s[i] 可以得到 diff[i]
		右侧同理
		 */
		int n = s.length(), count = 0;
		int[] diffLeft = new int[n], diffRight = new int[n];
		diffLeft[0] = 0;
		diffRight[n - 1] = 0;

		for (int i = 1; i < n; i++) {
			int j = n - i;
			int cl = s.charAt(i - 1), cr = s.charAt(j);
//			System.out.println((char)cl + "\t" + (char)cr);
			if (cl == 'x') {
				diffLeft[i] = diffLeft[i - 1] + 1;
			} else if (cl == 'y') {
				diffLeft[i] = diffLeft[i - 1] - 1;
			} else {
				diffLeft[i] = diffLeft[i - 1];
			}

			if (cr == 'x') {
				diffRight[j - 1] = diffRight[j] + 1;
			} else if (cr == 'y') {
				diffRight[j - 1] = diffRight[j] - 1;
			} else {
				diffRight[j - 1] = diffRight[j];
			}

			if (diffLeft[i] == 0 || diffRight[j - 1] == 0) {
				count++;
			}
		}

//		System.out.println(Arrays.toString(diffLeft));
//		System.out.println(Arrays.toString(diffRight));
		return count;
	}
}
}

