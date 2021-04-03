package offer.chapter02;

import offer.ListNode;

/**
 * 反转链表
 */
public class Problem06 {

    public static ListNode solution1(ListNode root){

        //重新定义头节点
        ListNode reRoot = new ListNode();
        ListNode next = null;
        while(root != null){
            next = root.next;
            root.next = reRoot.next;
            reRoot.next = root;
            root = next;
        }
        return reRoot.next;
    }

    public static ListNode solution2(ListNode root){
        //定义多个指针
        ListNode pre = null;
        ListNode cur = root;
        ListNode next = null;
        while(cur != null){
            next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }
        return pre;
    }
}
