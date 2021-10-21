package lc;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Stream;

public class N282 {

	public static void main(String[] args) {
		Solution s = new N282().new Solution();
		
		System.out.println(s.addOperators("123", 6));
		System.out.println(s.addOperators("232", 8));
		System.out.println(s.addOperators("105", 5));
		System.out.println(s.addOperators("00", 0));
		System.out.println(s.addOperators("999999999", 80));
	}

	class Solution {
	    public List<String> addOperators(String num, int target) {
	    	List<String> list = new ArrayList<String>();
	    	Map<String, Long> map = new HashMap<>();
	    	
	    	for (int i = 0; i < num.length(); i++) {
	    		if (i == 0) {
	    			String exp = num.substring(0, 1);
	    			map.put(exp, Long.parseLong(exp));
	    		} else {
	    			Map<String, Long> tempMap = new HashMap<>();
	    			for (Map.Entry<String, Long> e: map.entrySet()) {
	    				String preExp = e.getKey();
	    				String nextChar = num.substring(i, i + 1);
	    				
	    				String newExp1 = preExp + "*" + nextChar;
	    				Long newVal1 = compute(newExp1);
	    				if (newVal1 != null) {
	    					tempMap.put(newExp1, newVal1);
	    				}
	    				
	    				String newExp2 = preExp + nextChar;
	    				Long newVal2 = compute(newExp2);
	    				if (newVal2 != null) {
	    					tempMap.put(newExp2, newVal2);
	    				}
	    				
	    				String newExp3 = preExp + "+" + nextChar;
	    				Long newVal3 = map.get(preExp) + Long.parseLong(nextChar);
	    				tempMap.put(newExp3, newVal3);
	    				
	    				String newExp4 = preExp + "-" + nextChar;
	    				Long newVal4 = map.get(preExp) - Long.parseLong(nextChar);
	    				tempMap.put(newExp4, newVal4);
	    			}
	    			map.clear();
	    			map.putAll(tempMap);
	    		}
	    	}
	    	
	    	for (Map.Entry<String, Long> e: map.entrySet()) {
	    		if (e.getValue().intValue() == target) {
	    			list.add(e.getKey());
	    		}
	    	}
	    	return list;
	    }
	    
	    public Long compute(String exp) {
	    	Long result = 0L;
	    	String[] numArr = exp.split("[+-]"), opArr = exp.split("[0-9\\*]+");
	    	
	    	for (int i = 0; i < numArr.length; i++) {
	    		long val = 0L;
	    		if (numArr[i].indexOf('*') > -1) {
	    			String[] innerArr = numArr[i].split("\\*");
	    			if (Stream.of(innerArr).anyMatch(inner -> inner.matches("0[0-9]+"))) {
	    				return null;
	    			}
	    			val = multiply(numArr[i]);
	    		} else {
	    			if (numArr[i].matches("0[0-9]+")) {
	    				return null;
	    			}
	    			val = Long.parseLong(numArr[i]);
	    		}
	    		if (i == 0) {
	    			result = val;
	    		} else if ("+".equals(opArr[i])) {
	    			result += val;
	    		} else {
	    			result -= val;
	    		}
	    	}
	    	
	    	return result;
	    }
	    
		public long multiply(String exp) {
			return Stream.of(exp.split("\\*")).map(Long::parseLong).reduce((a, b) -> a * b).orElse(0L);
		}
	}
}

