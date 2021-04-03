package leetCode.test;

import leetCode.dataStruct.ListNode;

public class Leet82 {

	public ListNode deleteDuplicates(ListNode head) {
		if (head==null||head.next ==null) {
			return head;
		}
		ListNode root = new ListNode(-1);
		ListNode cur = head;
		ListNode last = root;
		int pre = Integer.MAX_VALUE;
		while (cur != null && cur.next != null) {
			if (cur.val != cur.next.val&&cur.val!=pre) {
				last.next = cur;
				last = last.next;
				
			}
			pre = cur.val;
			cur = cur.next;
		}
		last.next = cur!=null&&cur.val!=pre?cur:null;
		return root.next;
	}

}
