package leetCode.test;

public class Leet109 {
	public TreeNode sortedListToBST(ListNode head) {
		if (head==null) {
			return null;
		}
		ListNode pre = null;
		ListNode slow = head;
		ListNode fast = head.next;
		while(fast!=null&&fast.next!=null) {
			pre = slow;
			slow = slow.next;
			fast = fast.next.next;
		}
		TreeNode root = new TreeNode(slow.val);
		if (pre!=null) {
			pre.next = null;
		}
		root.left = sortedListToBST(pre==null?pre:head);
		root.right = sortedListToBST(slow.next);
		return root;
	}

}
