package offer.chapter07;

import offer.ListNode;

/**
 * 删除排序链表中重复的节点
 */
public class Problem07 {

    public static ListNode solution(ListNode root) {
        if (root == null) return root;
        ListNode node = root;
        while (node != null && node.next != null) {
            if (node.val == node.next.val) {
                ListNode dup = node.next;
                node.next = node.next.next;
                dup.next = null;//help GC
            } else {
                node = node.next;
            }
        }
        return root;
    }



}
