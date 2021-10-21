package lc;

public class N704 {

	public static void main(String[] args) {
		Solution s = new N704().new Solution();

		System.out.println(s.search(new int[] { -1, 0, 3, 5, 9, 12 }, 9));
		System.out.println(s.search(new int[] { -1, 0, 3, 5, 9, 12 }, 2));
	}

class Solution {
	public int search(int[] nums, int target) {
		if (nums.length == 1) {
			return nums[0] == target ? 0 : -1;
		}

		int s = 0, e = nums.length - 1, n = (s + e) / 2;
		while (s <= e) {
			if (nums[n] == target) {
				return n;
			} else if (nums[n] > target) {
				e = n - 1;
			} else {
				s = n + 1;
			}
			if (e < 0 || s > nums.length - 1) {
				return -1;
			}
			n = (s + e) / 2;
		}
		return -1;
	}
}
}
