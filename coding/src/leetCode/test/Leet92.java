package leetCode.test;

public class Leet92 {
	
	public static void main(String[] args) {
		Leet92 leet92 = new Leet92();
		ListNode root = new ListNode(-1);
		ListNode cur=null;
		boolean flag = true;
		int[] nums = new int[] {1,2,3,4,5};
		for(int i =0;i<nums.length;i++) {
			if (flag) {
				cur = new ListNode(nums[i]);
				root.next = cur;
				flag = !flag;
			}else {
				cur.next = new ListNode(nums[i]);
				cur= cur.next;
			}
		}
		leet92.reverseBetween(root.next, 2, 5);
	}
	
	public ListNode reverseBetween(ListNode head, int m, int n) {
		if (m==n) {
			return head;
		}
		ListNode root = new ListNode(-1);
		root.next = head;
		ListNode pre = root;
		ListNode pre1 = null;
		ListNode pre2 = null;
		int count = 1;
		while(pre2==null) {
			if (count==m) {
			pre1  = pre;	
			}else if(count == n){
				pre2 = pre;
			}
			count ++;
			pre = pre.next;
		}
		ListNode tmp = pre1.next;
		ListNode tmp1 = pre.next;
		pre1.next= resver(pre1.next, pre2.next);
		tmp.next = tmp1;
		return root.next;
	}
	
	public ListNode resver(ListNode start, ListNode end) {
		
		ListNode pre = null;
		ListNode cur = start;
		ListNode e = end.next;
		while(cur!=e) {
			ListNode tmp = cur.next;
			cur.next = pre;
			pre = cur;
			cur = tmp;
		}
		return end;
	}
}
