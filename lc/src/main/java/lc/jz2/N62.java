package lc.jz2;

public class N62 {

	public static void main(String[] args) {
		Solution s = new N62().new Solution();

		int[] arr = { 1, 2, 3, 4, 2 };
		System.out.println(s.peakIndexInMountainArray(arr));
	}

	class Solution {
		public int peakIndexInMountainArray(int[] arr) {
			int start = 0, end = arr.length - 1, peak = 0;
			for (int middle = (end + start) / 2; middle > start || middle < end;) {
				if (arr[middle] > arr[middle - 1] && arr[middle] > arr[middle + 1]) {
					peak = middle;
					break;
				} else if (arr[middle] < arr[middle - 1]) {
					end = middle;
					middle = (end + start) / 2;
				} else if (arr[middle] < arr[middle + 1]) {
					start = middle;
					middle = (end + start) / 2;
				}
			}
			return peak;
		}
	}

}