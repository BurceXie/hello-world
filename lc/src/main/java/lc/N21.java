package lc;

import lc.base.ListNode;

/**
 * 21. 合并两个有序链表(1)
 * https://leetcode-cn.com/problems/merge-two-sorted-lists/
 */
public class N21 {

	public static void main(String[] args) {
		Solution s = new N21().new Solution();

		System.out.println(s);
	}

class Solution {
	public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
		if (l1 == null) {
			return l2;
		} else if (l2 == null) {
			return l1;
		}

		ListNode l, n, n1 = l1, n2 = l2;
		if (l2.val < l1.val) {
			l = l2;
			n = l;
			n2 = l2.next;
		} else {
			l = l1;
			n = l;
			n1 = n1.next;
		}

		while (n1 != null || n2 != null) {
			if (n1 == null) {
				n.next = n2;
				break;
			} else if (n2 == null) {
				n.next = n1;
				break;
			} else if (n2.val < n1.val) {
				n.next = n2;
				n2 = n2.next;
			} else {
				n.next = n1;
				n1 = n1.next;
			}
			n = n.next;
		}

		return l;
	}
}
}

