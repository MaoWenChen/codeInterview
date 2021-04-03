package offer.chapter02;

import offer.ListNode;

/**
 * 在O(1)时间删除链表节点
 */
public class Problem03 {

    public static ListNode solution(ListNode root, ListNode toBeDeleted) {
        if (root == null || toBeDeleted == null) {
            return null;
        }

        if (root == toBeDeleted) {
            return root.next;
        }

        if (toBeDeleted.next != null) {
            toBeDeleted.val = toBeDeleted.next.val;
            toBeDeleted.next = toBeDeleted.next.next;
        } else {
            //删除尾节点需要遍历
            ListNode preNode = root;
            while (preNode.next != toBeDeleted) {
                preNode = preNode.next;
            }
            preNode.next = toBeDeleted.next;
        }

        return root;
    }
}
