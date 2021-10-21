package lc;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class N703 {

	public static void main(String[] args) {
		int[] nums = { 4, 5, 8, 2 };
		KthLargest k = new KthLargest(3, nums);
		System.out.println(k.add(3));
		System.out.println(k.add(5));
		System.out.println(k.add(10));
		System.out.println(k.add(9));
		System.out.println(k.add(4));
	}
}

class KthLargest {

	int index = 0;
	List<Integer> list = new ArrayList<>();

	public KthLargest(int k, int[] nums) {
		this.index = k - 1;
		
		if (nums.length > 1) {
			Arrays.sort(nums);
		}
		
		if (nums.length > 0) {
			for (int i = 0; i < nums.length && i < k; i++) {
				list.add(nums[nums.length - i - 1]);
			}
		}
	}

	public int add(int val) {
		System.out.println(list);
		if (list.isEmpty() || val > list.get(0)) {
			list.add(0, val);
		} else {
			for (int i = 0; i < list.size(); i++) {
				if (val >= list.get(i)) {
					list.add(i, val);
					break;
				} else if (i == list.size() - 1) {
					list.add(val);
				}
			}
		}
		
		return list.get(index);
	}
}

/**
 * Your KthLargest object will be instantiated and called as such:
 * KthLargest obj = new KthLargest(k, nums);
 * int param_1 = obj.add(val);
 */
