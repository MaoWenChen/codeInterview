package offer.chapter03;

/**
 * 复杂链表的复制
 */
public class Problem08 {
    public static class ComplexListNode {
        int value;
        ComplexListNode next;
        ComplexListNode sibling;
    }

    public static ComplexListNode solution(ComplexListNode head) {
        // 如果链表为空就直接返回空
        if (head == null) {
            return null;
        }

        // 先复制结点
        cloneNodes(head);
        // 再链接sibling字段
        connectNodes(head);
        // 将整个链表拆分，返回复制链表的头结点
        return reconnectNodes(head);
    }

    public static void cloneNodes(ComplexListNode head) {

        while (head != null) {

            ComplexListNode tmp = new ComplexListNode();

            tmp.value = head.value;

            tmp.next = head.next;
            head.next = tmp;

            head = tmp.next;
        }
    }


    public static void connectNodes(ComplexListNode head) {
        while (head != null) {
            if (head.sibling != null) {

                head.next.sibling = head.sibling.next;
            }

            head = head.next.next;
        }
    }


    public static ComplexListNode reconnectNodes(ComplexListNode head) {

        if (head == null) {
            return null;
        }


        ComplexListNode newHead = head.next;

        ComplexListNode pointer = newHead;

        head.next = newHead.next;

        head = head.next;

        while (head != null) {

            pointer.next = head.next;
            pointer = pointer.next;

            head.next = pointer.next;
            head = pointer.next;
        }


        return newHead;
    }
}
