package lc;

import lc.base.ListNode;

public class N237 {

	public static void main(String[] args) {

	}

class Solution {
	public void deleteNode(ListNode node) {
		node.val = node.next.val;
		node.next = node.next.next;
	}
}
}

