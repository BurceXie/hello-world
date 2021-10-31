package lc;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * 352. 将数据流变为多个不相交区间(3)
 * https://leetcode-cn.com/problems/data-stream-as-disjoint-intervals/
 * @author Terry
 *
 */
public class N352 {

	public static void main(String[] args) {
		SummaryRanges s = new N352().new SummaryRanges();
		
		s.addNum(1);
		s.getIntervals();
		s.addNum(3);
		s.getIntervals();
		s.addNum(7);
		s.getIntervals();
		s.addNum(2);
		s.getIntervals();
		s.addNum(6);
		s.getIntervals();
	}

class SummaryRanges {
	Map<Integer, Integer> start2EndMap, end2StartMap;
	int[][] intervals;
	boolean generate = false;
	
    public SummaryRanges() {
    	start2EndMap = new HashMap<>();
    	end2StartMap = new HashMap<>();
    }
    
    public void addNum(int val) {
    	for (Map.Entry<Integer, Integer> e: start2EndMap.entrySet()) {
    		if (e.getKey() <= val && e.getValue() >= val) {
    			return;
    		}
    	}
    	
    	if (start2EndMap.containsKey(val + 1) && end2StartMap.containsKey(val - 1)) {
    		int start = end2StartMap.get(val - 1), end = start2EndMap.get(val + 1);
    		start2EndMap.remove(val + 1);
    		end2StartMap.remove(val - 1);
    		start2EndMap.put(start, end);
    		end2StartMap.put(end, start);
    	} else if (start2EndMap.containsKey(val + 1)) {
    		int end = start2EndMap.get(val + 1);
    		start2EndMap.remove(val + 1);
    		start2EndMap.put(val, end);
    		end2StartMap.put(end, val);
    	} else if (end2StartMap.containsKey(val - 1)) {
    		int start = end2StartMap.get(val - 1);
    		end2StartMap.remove(val - 1);
    		end2StartMap.put(val, start);
    		start2EndMap.put(start, val);
    	} else {
    		start2EndMap.put(val, val);
    		end2StartMap.put(val, val);
    	}
    	generate = true;
    }
    
    public int[][] getIntervals() {
    	if (generate) {
    		intervals = new int[start2EndMap.size()][];
    		int i = 0;
    		List<Integer> list = start2EndMap.keySet().stream().sorted().collect(Collectors.toList());
    		for (Integer k: list) {
    			intervals[i] = new int[2];
    			intervals[i][0] = k;
    			intervals[i][1] = start2EndMap.get(k);
    			i++;
    		}
			generate = false;
    	}
    	return intervals;
    }
}
}

