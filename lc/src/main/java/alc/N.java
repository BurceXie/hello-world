package alc;

import com.google.common.base.Stopwatch;

import java.util.concurrent.*;

/**
 *
 *
 */
public class N {

	public static void main(String[] args) {
		Solution s = new N().new Solution();

		Stopwatch sw = Stopwatch.createStarted();
		System.out.println(s);
		System.out.println("sw: " + sw.elapsed(TimeUnit.MILLISECONDS));
	}

class Solution {
}
}

