package leetcode;

public class ReverseLinkedList {
	public ListNode reverseList(ListNode head) {
		if (head == null || head.next == null)
			return head;

		ListNode node1 = head.next;
		head.next = null;
		ListNode node2 = node1.next;
		node1.next = head;

		ListNode tmp = null;

		while (node2 != null) {
			tmp = node2.next;
			node2.next = node1;
			node1 = node2;
			node2 = tmp;
		}

		return node1;
	}
}
