package offer.chapter03;

import offer.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 从上往下打印二叉树
 */
public class Problem05 {

    public static void solution(TreeNode root) {
        if (root == null) return;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()) {
            TreeNode node = queue.remove();
            System.out.println(node.val + " ");
            if (node.left != null) queue.add(node.left);
            if (node.right != null) queue.add(node.right);
        }
    }
}
