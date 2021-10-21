package lc;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class N1436 {

	public static void main(String[] args) {
		Solution s = new N1436().new Solution();

		List<List<String>> paths = new ArrayList<>();

		System.out.println(s.destCity(paths));
	}

	class Solution {
		public String destCity(List<List<String>> paths) {
			Set<String> oriList = new HashSet<>();
			List<String> destList = new ArrayList<>();
			for (List<String> path : paths) {
				oriList.add(path.get(0));
				destList.add(path.get(1));
			}
			destList.removeAll(oriList);
			return destList.get(0);
		}
	}

}
