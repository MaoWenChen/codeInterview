package offer.chapter07;

import offer.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 从上到下按层打印二叉树
 */
public class Problem10 {

    public static void solution(TreeNode root) {
        if (root == null) return;
        Queue<TreeNode> q = new LinkedList<>();
        int index = 0;//当前层打印的节点
        int levelCount = 0;//当前层的节点数
        TreeNode cur = null;
        q.add(root);
        levelCount++;
        while (!q.isEmpty()) {
            cur = q.poll();
            index++;
            System.out.printf("%-5d", cur.val);
            if (cur.left != null) {
                q.add(cur.left);
            }
            if (cur.right != null) {
                q.add(cur.right);
            }
            if (index == levelCount) {
                System.out.println();
                index = 0;
                levelCount = q.size();
            }
        }
    }
}
