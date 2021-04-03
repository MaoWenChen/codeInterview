package offer.chapter07;

import offer.ListNode;

/**
 * 链表中环的入口点
 */
public class Problem06 {

    public static ListNode solution(ListNode root) {
        if (root == null) return root;
        ListNode faster = root;
        ListNode slower = root;
        while (faster != null && faster.next != null) {
            slower = slower.next;
            faster = faster.next.next;
            if (slower == faster) {
                break;
            }
        }
        if (slower != faster) {
            return null;
        }
        faster = root;
        while (faster != slower) {
            faster = faster.next;
            slower = slower.next;
        }
        return faster;

    }
}
