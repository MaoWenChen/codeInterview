package offer.chapter03;

import offer.TreeNode;

/**
 * 二叉搜索树转换成双向链表
 */
public class Problem09 {

    static TreeNode lastNode;

    public static TreeNode solution(TreeNode root) {
        if (root == null) return null;
        convertToList(root);
        while (root.left != null) root = root.left;
        return root;
    }

    private static void convertToList(TreeNode root) {
        if (root != null) {
            if (root.left != null) {
                convertToList(root.left);
            }
            root.left = lastNode;
            if (lastNode != null) lastNode.right = root;
            lastNode = root;
            if (root.right != null) {
                convertToList(root.right);
            }
        }
    }
}
