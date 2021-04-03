package offer.chapter01;

import offer.ListNode;

import java.util.Stack;

/**
 * 从尾到头打印链表
 */
public class Problem04 {

    /**
     * 用栈实现
     */
    public static void solution01(ListNode root) {
        Stack<ListNode> stack = new Stack<>();
        while (root != null) {
            stack.push(root);
            root = root.next;
        }
        while (!stack.isEmpty()) {
            System.out.println(stack.pop().val);
        }
    }

    /**
     * 递归实现
     */
    public static void solution02(ListNode root) {
        if (root == null) {
            return;
        }
        solution02(root.next);
        System.out.println(root.val);
    }

}
