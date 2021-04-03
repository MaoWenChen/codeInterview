package offer.chapter07;

/**
 * 二叉树的中序遍历的下一个节点
 */
public class Problem08 {
    public static BinaryTreeNode solution(BinaryTreeNode node) {
        if (node == null) return node;
        BinaryTreeNode next = null;
        if (node.right != null) {
            next = node.right;
            while (next.left != null) {
                next = next.left;
            }
        } else if (node.parent != null) {
            while (node.parent != null && node.parent.right == node) {
                node = node.parent;
            }
            if (node.parent != null)
                next = node.parent;
        }
        return next;
    }

    private static class BinaryTreeNode {
        private int val;
        private BinaryTreeNode left;
        private BinaryTreeNode right;
        private BinaryTreeNode parent;
    }
}
