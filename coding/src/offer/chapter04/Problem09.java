package offer.chapter04;

import offer.ListNode;

/**
 * 查找两个链表的第一个公共节点
 */
public class Problem09 {

    public static ListNode solution1(ListNode l1, ListNode l2) {

        int l1Len = 0;
        int l2Len = 0;
        ListNode l1Cur = l1;
        ListNode l2Cur = l2;
        while (l1Cur != null) {
            l1Len++;
        }
        while (l2 != null) {
            l2Len++;
        }
        l1Cur = l1;
        l2Cur = l2;
        while (l1Len > l2Len) {
            l1Cur = l1Cur.next;
            l1Len--;
        }
        while (l2Len > l1Len) {
            l2Cur = l2Cur.next;
            l2Len--;
        }

        while (l1Cur != null && l2Cur != null && l1Cur != l2Cur) {
            l1Cur = l1Cur.next;
            l2Cur = l2Cur.next;
        }
        return l1Cur;
    }
}
