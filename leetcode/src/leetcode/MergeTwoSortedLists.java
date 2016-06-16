package leetcode;

public class MergeTwoSortedLists {
	public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
		if (l1 == null)
			return l2;
		if (l2 == null)
			return l1;
		ListNode lt = null;
		if (l1.val < l2.val) {
			lt = l1;
			l1 = l1.next;
		} else {
			lt = l2;
			l2 = l2.next;
		}
		ListNode next = lt;
		while (l1 != null && l2 != null) {
			if (l1.val < l2.val) {
				next.next = l1;
				l1 = l1.next;
			} else {
				next.next = l2;
				l2 = l2.next;
			}
			next = next.next;
		}
		while (l1 != null) {
			next.next = l1;
			next = next.next;
			l1 = l1.next;
		}
		while (l2 != null) {
			next.next = l2;
			next = next.next;
			l2 = l2.next;
		}
		return lt;
	}
}
