package offer.chapter02;

import offer.ListNode;

import java.util.Stack;

/**
 * 寻找链表中倒是第k个节点
 */
public class Problem05 {

    public static ListNode solution1(ListNode root, int k) {
        if (root == null || k < 1) return null;
        Stack<ListNode> stack = new Stack<>();
        while (root != null) {
            stack.push(root);
            root = root.next;
        }
        for (int i = 1; i < k; i++) {
            if (stack.isEmpty()) return null;
            stack.pop();
        }
        return stack.isEmpty() ? null : stack.pop();
    }

    public static ListNode soluton2(ListNode root, int k) {
        if (root == null || k < 1) return null;
        ListNode faster = root;
        ListNode lower = root;
        for (int i = 1; i <= k; i++) {
            if (faster == null) return null;
            faster = faster.next;
        }
        while (faster != null) {
            lower = lower.next;
            faster = faster.next;
        }
        return lower;
    }

}
