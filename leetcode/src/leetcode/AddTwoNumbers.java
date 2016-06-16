package leetcode;

public class AddTwoNumbers {
	public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
		ListNode node = new ListNode(0);
		ListNode pointer = node;
		while (l1 != null && l2 != null) {
			int val = l2.val + l1.val + pointer.val;
			pointer.val = val % 10;
			if (val >= 10) {
				pointer.next = new ListNode(1);
			}

			l1 = l1.next;
			l2 = l2.next;
			if ((l1 != null || l2 != null) && pointer.next == null) {
				pointer.next = new ListNode(0);
			}
			pointer = pointer.next;
		}

		while (l1 != null) {
			int val = l1.val + pointer.val;
			pointer.val = val % 10;
			if (val >= 10) {
				pointer.next = new ListNode(1);
			}
			l1 = l1.next;
			if (l1 != null && pointer.next == null) {
				pointer.next = new ListNode(0);
			}
			pointer = pointer.next;
		}

		while (l2 != null) {
			int val = l2.val + pointer.val;
			pointer.val = val % 10;
			if (val >= 10) {
				pointer.next = new ListNode(1);
			}
			l2 = l2.next;
			if (l2 != null && pointer.next == null) {
				pointer.next = new ListNode(0);
			}
			pointer = pointer.next;

		}
		return node;
	}
}
