package leetcode;

public class SwapNodesinPairs {
	public ListNode swapPairs(ListNode head) {
		if (head == null || head.next == null)
			return head;
		ListNode rn = head.next;
		ListNode preNode = head;
		ListNode secNode = head.next;
		ListNode curr = secNode.next;
		secNode.next = preNode;
		preNode.next = curr;

		while (curr != null && curr.next != null) {
			// reverse nodes
			secNode = curr.next;
			curr.next = secNode.next;
			preNode.next = secNode;
			secNode.next = curr;
			// move pointer
			preNode = curr;
			curr = preNode.next;
		}
		return rn;
	}
}
