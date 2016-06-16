package leetcode;

public class IntersectionTwoLinkedList {
	public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
		if (headA == null || headB == null)
			return null;
		if (headA == headB)
			return headA;
		ListNode nodeA = headA;
		ListNode nodeB = headB;
		int lenA = 1;
		int lenB = 1;
		while (nodeA.next != null) {
			nodeA = nodeA.next;
			lenA++;
		}
		while (nodeB.next != null) {
			nodeB = nodeB.next;
			lenB++;
		}
		if (nodeA == nodeB) {
			nodeA = headA;
			nodeB = headB;
			int k = Math.min(lenA, lenB);
			if (lenA > lenB) {
				int i = 0;
				while (i < lenA - k) {
					nodeA = nodeA.next;
					i++;
				}
			} else if (lenB > lenA) {
				int i = 0;
				while (i < lenB - k) {
					nodeB = nodeB.next;
					i++;
				}
			}

			while (nodeA != nodeB) {
				nodeA = nodeA.next;
				nodeB = nodeB.next;
			}
			return nodeA;
		}
		return null;
	}
}
