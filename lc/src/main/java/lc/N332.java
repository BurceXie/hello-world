package lc;

import static org.hamcrest.CoreMatchers.instanceOf;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class N332 {

	public static void main(String[] args) {
		Solution s = new N332().new Solution();
		
		List<List<String>> tickets = new ArrayList<List<String>>();
		Stream.of(new String[][] {{"JFK","ANU"},{"JFK","TIA"},{"ANU","TIA"},{"TIA","ANU"},{"TIA","JFK"},{"ANU","JFK"},{"ANU","EZE"},{"EZE","AXA"},{"TIA","ANU"},{"AXA","TIA"}}).map(Arrays::asList).map(l -> new ArrayList<String>(l)).forEach(l -> tickets.add(l));
		System.out.println(s.findItinerary2(tickets));
		System.out.println(s.findItinerary(tickets));
		
		tickets.clear();
		Stream.of(new String[][] {{"JFK","TIA"},{"JFK","ANU"},{"ANU","JFK"},{"ANU","EZE"},{"EZE","AXA"},{"TIA","ANU"},{"AXA","TIA"}}).map(Arrays::asList).map(l -> new ArrayList<String>(l)).forEach(l -> tickets.add(l));
		System.out.println(s.findItinerary(tickets));
		System.out.println(s.findItinerary2(tickets));
		
		tickets.clear();
		Stream.of(new String[][] {{"JFK","TIA"},{"TIA","ANU"},{"TIA","JFK"},{"ANU","TIA"}}).map(Arrays::asList).map(l -> new ArrayList<String>(l)).forEach(l -> tickets.add(l));
		System.out.println(s.findItinerary(tickets));
		System.out.println(s.findItinerary2(tickets));
	}

class Solution {
    public List<String> findItinerary(List<List<String>> tickets) {
    	for (int i = 0; i < tickets.size(); i++) {
    		tickets.get(i).add(String.valueOf(i));
    	}
    	return findItinerary("JFK", tickets);
    }
    
    public List<String> findItinerary(String from, List<List<String>> tickets) {
    	if (tickets.size() == 1) {
    		List<String> ticket = tickets.get(0);
    		if (from.equals(ticket.get(0))) {
    			return new ArrayList<>(ticket.subList(0, 2));
    		} else {
    			return null;
    		}
    	}
    	
    	List<String> itinerary = null;
    	for (List<String> ticket: tickets) {
    		if (from.equals(ticket.get(0))) {
    			List<List<String>> laterTickets = tickets.stream().filter(tic -> !tic.get(2).equals(ticket.get(2))).collect(Collectors.toList());
    			List<String> laterItinerary = findItinerary(ticket.get(1), laterTickets);
    			if (laterItinerary != null && laterItinerary.size() == laterTickets.size() + 1) {
    				if (itinerary == null || laterItinerary.get(0).compareTo(itinerary.get(1)) < 0) {
        				laterItinerary.add(0, from);
    					itinerary = laterItinerary;
    				}
    			}
    		}
    	}
    	return itinerary;
    }
    

    public List<String> findItinerary2(List<List<String>> tickets) {
    	for (int i = 0; i < tickets.size(); i++) {
    		tickets.get(i).add(String.valueOf(i));
    	}
    	List<List<String>> orderedTickets = findOrderedTickets("JFK", tickets);
    	List<String> itinerary = orderedTickets.get(0).subList(0, 2);
    	for (int i = 1; i < orderedTickets.size(); i++) {
    		itinerary.add(orderedTickets.get(i).get(1));
    	}
    	return itinerary;
    }
    
    public List<List<String>> findOrderedTickets(String from, List<List<String>> tickets) {
    	if (tickets.size() == 1) {
    		if (from.equals(tickets.get(0).get(0))) {
    			return tickets;
    		} else {
    			return null;
    		}
    	}
    	
    	List<List<String>> orderedTickets = null;
    	for (List<String> ticket: tickets) {
    		if (from.equals(ticket.get(0))) {
    			List<List<String>> laterTickets = tickets.stream().filter(tic -> !tic.get(2).equals(ticket.get(2))).collect(Collectors.toList());
    			List<List<String>> orderedLaterTickets = findOrderedTickets(ticket.get(1), laterTickets);
    			if (orderedLaterTickets != null && orderedLaterTickets.size() == laterTickets.size()) {
    				if (orderedTickets == null || (ticket.get(1)).compareTo(orderedTickets.get(0).get(1)) < 0) {
    					orderedLaterTickets.add(0, ticket);
    					orderedTickets = orderedLaterTickets;
    				}
    			}
    		}
    	}
    	return orderedTickets;
    }
}
}

