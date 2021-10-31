package lc;

/**
 * 165. 比较版本号(2)
 * https://leetcode-cn.com/problems/compare-version-numbers/
 * @author Terry
 *
 */
public class N165 {

	public static void main(String[] args) {
		Solution s = new N165().new Solution();
	
		System.out.println(s.compareVersion("1.01", "1.001"));
		System.out.println(s.compareVersion("1.0", "1.0.0"));
		System.out.println(s.compareVersion("0.1", "1.1"));
		System.out.println(s.compareVersion("1.0.1", "1"));
		System.out.println(s.compareVersion("7.5.2.4", "7.5.3"));
	}

	class Solution {
	    public int compareVersion(String version1, String version2) {
	    	String[] arr1 = version1.split("\\."), arr2 = version2.split("\\.");
	    	
	    	for (int i = 0; i < arr1.length || i < arr2.length; i++) {
	    		int v1 = i < arr1.length ? Integer.parseInt(arr1[i]) : 0;
	    		int v2 = i < arr2.length ? Integer.parseInt(arr2[i]) : 0;
	    		if (v1 == v2) {
	    			continue;
	    		}
	    		return v1 > v2 ? 1 : -1;
	    	}
	    	return 0;
	    }
	}
}

