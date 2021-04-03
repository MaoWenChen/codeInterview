package leetCode.test;

import leetCode.dataStruct.ListNode;

public class Leet61 {
    public ListNode rotateRight(ListNode head, int k) {
        if (head == null || head.next == null) {
            return head;
        }
        int i = 0;
        ListNode tail = head;
        int len = 1;
        while (tail.next != null) {
            tail = tail.next;
            len++;
        }
        k = len - k % len;
        while (i < k) {
            ListNode node = head.next;
            tail.next = head;
            tail = head;
            head.next = null;
            head = node;
            i++;
        }
        return head;
    }

}
