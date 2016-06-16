package leetcode;

public class RemoveDuplicatesFromSortedList {
	public ListNode deleteDuplicates(ListNode head) {
		if (head == null || head.next == null)
			return head;
		ListNode rn = head;
		ListNode node = head;
		int val = node.val;
		while (node != null) {
			ListNode nextNode = node.next;
			while (nextNode != null && val == nextNode.val) {
				nextNode = nextNode.next;
			}
			node.next = nextNode;
			node = nextNode;
			if (node != null) {
				val = node.val;
			}
		}
		return rn;
	}
}
