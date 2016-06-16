package leetcode;

public class PalindromeLinkedList {

	public boolean isPalindrome(ListNode head) {
		if (head == null || head.next == null)
			return true;
		ListNode snode = head;
		ListNode qnode = head;
		while (qnode.next != null && qnode.next.next != null) {
			snode = snode.next;
			qnode = qnode.next.next;
		}
		// reverse second half list, start from snode exclusively
		ListNode nnode = snode.next;
		while (nnode.next != null) {
			ListNode tmp = nnode.next;
			nnode.next = tmp.next;
			tmp.next = snode;
			snode.next = tmp;
		}
		// compare
		while (snode.next != null) {
			snode = snode.next;
			if (head.val != qnode.val) {
				return false;
			}
			head = head.next;
		}
		return true;
	}
}
