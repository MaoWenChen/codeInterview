package offer.chapter03;

import offer.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * 找出二叉树中和为某一值的路径
 */
public class Problem07 {

    public static List<TreeNode> solution(TreeNode root, int sum) {
        LinkedList<TreeNode> path = new LinkedList<>();
        if (root == null) return path;
        sumPath(root, path, sum);
        return path;
    }

    private static boolean sumPath(TreeNode root, LinkedList<TreeNode> path, int sum) {
        if (sum == 0) return true;
        else if (root == null || sum < 0) return false;

        path.addLast(root);
        if (sumPath(root.left, path, sum - root.val) || sumPath(root.right, path, sum - root.val)) {
            return true;
        }
        path.removeLast();
        return false;
    }
}