package leetCode.test;

public class Leet83 {
	public ListNode deleteDuplicates(ListNode head) {
		ListNode root = new ListNode(0);
		ListNode cur = head;
		ListNode last = root;
		while (cur != null && cur.next != null) {
			if (cur.val != cur.next.val) {
				last.next = cur;
				last = last.next;
			}
			cur = cur.next;
		}
		if (cur!=null) {
			last.next = cur;
		}
		return root.next;
	}

}
