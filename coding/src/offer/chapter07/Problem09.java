package offer.chapter07;

import offer.TreeNode;

/**
 * 判断二叉树是否对称
 */
public class Problem09 {

    public static boolean solution(TreeNode root) {
        if (root == null) return true;
        return isSymmetrical(root, root);

    }

    private static boolean isSymmetrical(TreeNode left, TreeNode right) {
        if (left == null && right == null) {
            return true;
        }

        if (left == null || right == null) {
            return false;
        }
        if (left.val != right.val)
            return false;
        return isSymmetrical(left.left, right.right) && isSymmetrical(left.right, right.left);
    }
}
