package lc.jz2;

import lc.base.ListNode;

public class N22 {

	public static void main(String[] args) {
		Solution s = new N22().new Solution();
		
	}

class Solution {
    public ListNode getKthFromEnd(ListNode head, int k) {
    	ListNode newHead = head, node = head;
    	for (int i = 0; i < k - 1; i++) {
    		node = node.next;
    		if (node == null) {
    			return newHead;
    		}
    	}
    	while (node.next != null) {
    		newHead = newHead.next;
    		node = node.next;
    	}
		return newHead;
    }
}
}

