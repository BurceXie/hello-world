package lc;

import lc.base.ListNode;

/**
 * 2. 两数相加(2)
 * https://leetcode-cn.com/problems/add-two-numbers
 * *
 */
public class N2 {

	public static void main(String[] args) {
		Solution s = new N2().new Solution();

		ListNode l1 = new ListNode(3);
		l1.next = new ListNode(2);
		l1.next.next = new ListNode(6);

		ListNode l2 = new ListNode(5);
		l2.next = new ListNode(9);

		ListNode l = s.addTwoNumbers(l1, l2);
		System.out.println(l.val);
		while (l.next != null) {
			l = l.next;
			System.out.println(l.val);
		}

		l1 = new ListNode(3);
		l1.next = new ListNode(2);
		l1.next.next = new ListNode(6);

		l2 = new ListNode(5);
		l2.next = new ListNode(9);

		l = s.addTwoNumbers2(l1, l2);
		System.out.println(l.val);
		while (l.next != null) {
			l = l.next;
			System.out.println(l.val);
		}
	}

	class Solution {
		public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
			return addTwoNumbers(l1, l2, 0);
		}

		public ListNode addTwoNumbers(ListNode l1, ListNode l2, int carry) {
			if (l1 == null && l2 == null) {
				return carry > 0 ? new ListNode(carry) : null;
			} else if (l1 == null) {
				int sum = l2.val + carry;
				ListNode l = new ListNode(sum % 10, addTwoNumbers(null, l2.next, sum / 10));
				return l;
			} else if (l2 == null) {
				int sum = l1.val + carry;
				ListNode l = new ListNode(sum % 10, addTwoNumbers(l1.next, null, sum / 10));
				return l;
			} else {
				int sum = l1.val + l2.val + carry;
				ListNode l = new ListNode(sum % 10, addTwoNumbers(l1.next, l2.next, sum / 10));
				return l;
			}
		}

		public ListNode addTwoNumbers2(ListNode l1, ListNode l2) {
			ListNode l = l1;
			int sum = 0, carry = 0;
			while (true) {
				sum = l1.val + l2.val + carry;
				l1.val = sum % 10;
				carry = 0;
				if (sum >= 10) {
					if (l1.next == null) {
						l1.next = new ListNode(1);
					} else {
						carry = 1;
						if (l2.next == null) {
							l2.next = new ListNode(0);
						}
					}
				}

				if (carry == 0) {
					if (l2.next == null) {
						break;
					} else if (l1.next == null) {
						l1.next = l2.next;
						break;
					}
				}

				l1 = l1.next;
				l2 = l2.next;
			}
			return l;
		}
	}
}
