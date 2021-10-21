package lc;

public class N4 {

	public static void main(String[] args) {
		Solution s = new N4().new Solution();

		int[] nums1 = {}, nums2 = { 2, 3 };

		System.out.println(s.findMedianSortedArrays(nums1, nums2));
	}

	class Solution {
		public double findMedianSortedArrays(int[] nums1, int[] nums2) {
			double median = 0D;
			int totalLength = nums1.length + nums2.length, medianIndex = totalLength / 2, i1 = 0, i2 = 0;

			if (totalLength == 1) {
				median = 0.0 + (nums1.length == 1 ? nums1[0] : nums2[0]);
			} else if (totalLength % 2 == 1) {
				while (true) {
					if (i1 + i2 == medianIndex) {
						median = 0.0 + (i2 == nums2.length || (i1 < nums1.length && nums1[i1] <= nums2[i2]) ? nums1[i1]
								: nums2[i2]);
						break;
					}

					if (i1 == nums1.length) {
						i2++;
					} else if (i2 == nums2.length) {
						i1++;
					} else if (nums1[i1] <= nums2[i2]) {
						i1++;
					} else {
						i2++;
					}
				}
			} else {
				while (true) {
					if (i1 + i2 == medianIndex - 1) {
						median = 0.0 + (i2 == nums2.length || (i1 < nums1.length && nums1[i1] <= nums2[i2]) ? nums1[i1]
								: nums2[i2]);
					} else if (i1 + i2 == medianIndex) {
						median = (median
								+ (i2 == nums2.length || (i1 < nums1.length && nums1[i1] <= nums2[i2]) ? nums1[i1]
										: nums2[i2]))
								/ 2;
						break;
					}

					if (i1 == nums1.length) {
						i2++;
					} else if (i2 == nums2.length) {
						i1++;
					} else if (nums1[i1] <= nums2[i2]) {
						i1++;
					} else {
						i2++;
					}
				}
			}

			return median;
		}

		public double findMedianSortedArrays2(int[] nums1, int[] nums2) {
			double median = 0D;
			int totalLength = nums1.length + nums2.length, medianIndex = totalLength / 2, i1 = 0, i2 = 0;
			boolean finish1 = nums1.length == 0, finish2 = nums2.length == 0;

			if (totalLength % 2 == 1) {
				while (!finish1 || !finish2) {
					if (i1 + i2 == medianIndex) {
						if (finish1) {
							median = 0.0 + nums2[i2];
						} else if (finish2) {
							median = 0.0 + nums1[i1];
						} else {
							median = 0.0 + (nums1[i1] <= nums2[i2] ? nums1[i1] : nums2[i2]);
						}
						break;
					}

					if (nums1[i1] <= nums2[i2]) {
						i1++;
						finish1 = (i1 == nums1.length);
					} else {
						i2++;
						finish2 = (i2 == nums2.length);
					}
				}
			} else {
				while (!finish1 || !finish2) {
					if (i1 + i2 == medianIndex - 1) {
						if (finish1) {
							median = 0.0 + nums2[i2];
						} else if (finish2) {
							median = 0.0 + nums1[i1];
						} else {
							median = 0.0 + (nums1[i1] <= nums2[i2] ? nums1[i1] : nums2[i2]);
						}
					} else if (i1 + i2 == medianIndex) {
						if (finish1) {
							median = (median + nums2[i2]) / 2;
						} else if (finish2) {
							median = (median + nums1[i1]) / 2;
						} else {
							median = (median + (nums1[i1] <= nums2[i2] ? nums1[i1] : nums2[i2])) / 2;
						}
						break;
					}

					if (nums1[i1] <= nums2[i2]) {
						i1++;
						finish1 = (i1 == nums1.length);
					} else {
						i2++;
						finish2 = (i2 == nums2.length);
					}
				}
			}

			return median;
		}
	}
}
