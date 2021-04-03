package dataStruct.tree;

/**
 * 二叉树
 */
public class TwoTree {
    public boolean isBalanced(TreeNode root) {
        if (root == null) {
            return true;
        }
        boolean left = isBalanced(root.left);
        boolean right = isBalanced(root.right);
        int leftHeight = treeHeight(root.left);
        int rightHeight = treeHeight(root.right);
        return left && right && (Math.abs(leftHeight - rightHeight) < 2);
    }

    public int treeHeight(TreeNode node) {
        if (node == null) {
            return 0;
        }
        int leftHeight = treeHeight(node.left);
        int rightHeight = treeHeight(node.right);
        return (leftHeight > rightHeight ? leftHeight : rightHeight) + 1;
    }

    public TreeNode sortedListToBST(ListNode head) {
        if (head == null) {
            return null;
        }
        if (head.next == null) {
            return new TreeNode(head.val);
        }
        ListNode pre = null;
        ListNode fast = head.next;
        ListNode slow = head;
        while(fast!=null) {
            pre = slow;
            slow = slow.next;
            fast = fast.next;
            if (fast!=null) {
                fast = fast.next;
            }
        }
        TreeNode node = new TreeNode(slow.val);
        pre.next = null;
        node.left = sortedListToBST(head);
        node.right = sortedListToBST(slow.next);
        return node;
    }

    class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }
}
