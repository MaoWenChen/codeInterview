package offer.chapter03;

import offer.TreeNode;

/**
 * 二叉树的镜像
 */
public class Problem01 {
    public static void solution(TreeNode root) {
        if (root != null) {
            TreeNode tmp = root.left;
            root.left = root.right;
            root.right = tmp;
            solution(root.left);
            solution(root.right);
        }
    }
}

