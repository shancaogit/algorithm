package leetcode;

public class LinkedListCycle {
	public boolean hasCycle(ListNode head) {
		if (head == null || head.next == null || head.next.next == null)
			return false;
		ListNode p1 = head;
		ListNode p2 = head.next.next;
		if (p1 == p2)
			return true;
		while (p1.next != null) {
			p1 = p1.next;
			if (p2.next == null || p2.next.next == null) {
				return false;
			}
			p2 = p2.next.next;
			if (p1 == p2)
				return true;
		}
		return false;
	}
}
