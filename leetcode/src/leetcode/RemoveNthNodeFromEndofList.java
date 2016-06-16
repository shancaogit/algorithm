package leetcode;

public class RemoveNthNodeFromEndofList {
	public ListNode removeNthFromEnd(ListNode head, int n) {
		int i = 0;
		ListNode lt = head;
		ListNode rn = head;
		ListNode rpn = head;
		while (lt != null) {
			lt = lt.next;
			i++;
			if (i > n) {
				rn = rn.next;
			}
			if (i > n + 1) {
				rpn = rpn.next;
			}
		}
		if (n > i) {
			return head;
		} else if (n == i) {
			ListNode rlt = head.next;
			head.next = null;
			return rlt;
		} else {
			rpn.next = rn.next;
			return head;
		}
	}
}
