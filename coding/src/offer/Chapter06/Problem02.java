package offer.Chapter06;

import offer.TreeNode;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

/**
 * 树中两个节点的最低公共祖先
 */
public class Problem02 {
    //树是二叉搜索树
    public static TreeNode solution1(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null || p == null || q == null) return null;
        if (root.val > p.val && root.val > q.val) return solution1(root.left, p, q);
        if (root.val < p.val && root.val < q.val) return solution1(root.right, p, q);
        return root;
    }

    //树是普通二叉树,多叉树也类似
    public static TreeNode solution2(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null || p == null || q == null) return null;
        LinkedList<TreeNode> p1 = new LinkedList<>();
        getPath(root, p, p1);
        LinkedList<TreeNode> p2 = new LinkedList<>();
        getPath(root, q, p2);
        return getLastCommonParent(p1, p2);
    }

    private static TreeNode getLastCommonParent(LinkedList<TreeNode> p1, LinkedList<TreeNode> p2) {
        TreeNode parent = null;
        Iterator<TreeNode> p = p1.iterator();
        Iterator<TreeNode> q = p2.iterator();
        while (p.hasNext() && q.hasNext()) {
            TreeNode pNode = p.next();
            if (pNode == q.next()) {
                parent = pNode;
            }
        }
        return parent;
    }

    private static boolean getPath(TreeNode root, TreeNode p, LinkedList<TreeNode> path) {

        if (root == p) {
            path.add(root);
            return true;
        }
        if (root == null) {
            return false;
        }
        path.addLast(root);
        if (getPath(root.left, p, path) || getPath(root.right, p, path)) {
            return true;
        }
        path.removeLast();
        return false;
    }
}
