package offer.chapter07;

import offer.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 按层交替顺序打印二叉树
 */
public class Problem11 {

    public static void solution(TreeNode root){
        if (root == null) return;
        LinkedList<TreeNode> q = new LinkedList<>();
        int index = 0;
        int levelCount = 0;
        boolean leftToright = true;
        q.add(root);
        levelCount = q.size();
        TreeNode cur = null;
        while(!q.isEmpty()){
            if (leftToright){
                cur = q.removeFirst();
            }else {
                cur = q.removeLast();
            }
            System.out.printf("%-5d",cur.val);
            index++;
            if (leftToright){
                if (cur.left!=null)q.addLast(cur.left);
                if (cur.right!=null)q.addLast(cur.right);
            }else {
                if (cur.right!=null) q.addFirst(cur.right);
                if (cur.left!=null) q.addFirst(cur.left);
            }
            if (index == levelCount){
                index = 0;
                levelCount = q.size();
                leftToright = !leftToright;
                System.out.println();
            }

        }

    }
}
