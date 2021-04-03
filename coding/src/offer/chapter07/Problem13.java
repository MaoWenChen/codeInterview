package offer.chapter07;

import offer.TreeNode;

/**
 * 找出二叉搜索树的第K大的节点
 */
public class Problem13 {
    private static int num = 0;

    public static TreeNode solution(TreeNode root, int k) {
        if (root == null || k < 1) return null;
        return findKNode(root, k);
    }

    private static TreeNode findKNode(TreeNode root, int k) {
        if (root == null) return root;
        TreeNode node = findKNode(root.left, k);
        if (node != null) {
            return node;
        }
        num++;
        if (num == k) {
            return root;
        }
        node = findKNode(root.right, k);
        return node;
    }
}
