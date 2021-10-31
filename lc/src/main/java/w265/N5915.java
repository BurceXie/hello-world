package w265;

import java.util.*;
import java.util.stream.*;

import lc.base.ListNode;

import static java.util.stream.Collectors.*;

/**
 * 5915. 找出临界点之间的最小和最大距离(2)
 * https://leetcode-cn.com/contest/weekly-contest-265/problems/find-the-minimum-and-maximum-number-of-nodes-between-critical-points/
 * @author Terry
 *
 */
public class N5915 {

	public static void main(String[] args) {
		Solution s = new N5915().new Solution();
		
	}

class Solution {
    public int[] nodesBetweenCriticalPoints(ListNode head) {
    	List<Integer> pointList = new ArrayList<Integer>();
    	
    	ListNode node = head;
    	int index = 0, lastVal = head.val;
    	while (node.next != null) {
    		int thisVal = node.val;
    		if (node == head) {
    			node = node.next;
    		} else if (node.next == null) {
    			break;
    		} else {
    			int nextVal = node.next.val;
    			if (lastVal < thisVal && thisVal > nextVal) {
    				pointList.add(index);
    			} else if (lastVal > thisVal && thisVal < nextVal) {
    				pointList.add(index);
    			}
    			node = node.next;
    			lastVal = thisVal;
    		}
			index++;
    	}
    	
		if (pointList.size() < 2) {
			return new int[] { -1, -1 };
		}
    	
    	List<Integer> sortedList = pointList.stream().sorted().collect(Collectors.toList());
    	int[] distances = new int[] {index, sortedList.get(sortedList.size() - 1) - sortedList.get(0)};
    	for (int i = 1; i < sortedList.size(); i++) {
    		int distance = sortedList.get(i) - sortedList.get(i - 1);
    		if (distance < distances[0]) {
    			distances[0] = distance;
    		}
    	}
    	return distances;
    }
}
}

