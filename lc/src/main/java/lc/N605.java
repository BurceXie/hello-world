package lc;

public class N605 {

	public static void main(String[] args) {
		Solution s = new N605().new Solution();

		System.out.println(s.canPlaceFlowers(new int[] { 1, 0, 0, 0, 1 }, 1));
		System.out.println(s.canPlaceFlowers(new int[] { 1, 0, 0, 0, 1 }, 2));
	}

	class Solution {
		public boolean canPlaceFlowers(int[] flowerbed, int n) {
			if (n == 0) {
				return true;
			} else if (flowerbed.length < n * 2 - 1) {
				return false;
			} else if (flowerbed.length == n * 2 - 1) {
				for (int i = 0; i < flowerbed.length; i++) {
					if (flowerbed[i] == 1) {
						return false;
					}
				}
				return true;
			}
			
			int placeNum = 0;
			for (int i = 0; i < flowerbed.length - 1; i++) {
				if (i == flowerbed.length - 2) {
					if (flowerbed[i] == 0 && flowerbed[i + 1] == 0) {
						flowerbed[i + 1] = 1;
						placeNum++;
					}
				} else if (i == 0) { 
					if (flowerbed[i] == 0 && flowerbed[i + 1] == 0) {
						flowerbed[i] = 1;
						placeNum++;
					}
				} else if (flowerbed[i] == 0 && flowerbed[i + 1] == 0 && flowerbed[i + 2] == 0) {
					flowerbed[i + 1] = 1;
					placeNum++;
				}
				if (placeNum >= n) {
					return true;
				}
			}
			return false;
		}
	}
}
