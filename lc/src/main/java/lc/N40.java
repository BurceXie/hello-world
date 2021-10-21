package lc;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class N40 {

	public static void main(String[] args) {
		Solution s = new N40().new Solution();
		
		int[] candidates = new int[] {10,1,2,7,6,1,5};
		System.out.println(s.combinationSum2(candidates, 8));
		
		candidates = new int[] {2,5,2,1,2};
		System.out.println(s.combinationSum2(candidates, 5));
	}

	class Solution {
	    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
	    	List<List<Integer>> result = new ArrayList<>();
	    	Set<String> uniqueSet = new HashSet<>();
	    	if (target == 0) {
	    		result.add(new ArrayList<>());
	    		return result;
	    	}

	    	List<Integer> newCandidates = new ArrayList<>();
	    	for (int candidate: candidates) {
	    		if (candidate <= target) {
	    			newCandidates.add(candidate);
	    		}
	    	}
	    	
	    	if (newCandidates.size() == 1) {
	    		if (newCandidates.contains(target)) {
	    			if (!uniqueSet.contains(String.valueOf(target))) {
	    				uniqueSet.add(String.valueOf(target));
		    			result.add(newCandidates);
	    			}
	    		}
	    	} else if (newCandidates.size() > 1) {
	    		for (int i = 0; i < newCandidates.size(); i++) {
	    			int[] newArr = new int[newCandidates.size() - 1];
	    			for (int j = 0, k = 0; j < newCandidates.size(); j++) {
	    				if (j != i) {
	    					newArr[k++] = newCandidates.get(j);
	    				}
	    			}
	    			
	    			int newTarget = target - newCandidates.get(i);
	    			List<List<Integer>> list = combinationSum2(newArr, newTarget);
		    		for (List<Integer> l: list) {
		    			l.add(newCandidates.get(i));
		    			l.sort(Comparator.naturalOrder());

		    			String key = l.stream().map(String::valueOf).collect(Collectors.joining(","));
		    			if (!uniqueSet.contains(key)) {
		    				uniqueSet.add(key);
		    				result.add(l);
		    			}
		    		}
	    		}
	    	}
	    	return result;
	    }
	}
}

