package offer.chapter05;

import offer.TreeNode;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * 二叉树的深度
 */
public class Problem02 {

    public static int solution(TreeNode root) {
        return deepth(root);
    }

    private static int deepth(TreeNode root) {
        if (root == null) return 0;
        return Math.max(deepth(root.left), deepth(root.right)) + 1;
    }

    /**
     * 判断是否是平衡二叉树
     */
    static class BalanceTree {


        public static boolean solution1(TreeNode root) {
            if (root == null) return true;
            return isBalance(root);
        }

        public static boolean solution2(TreeNode root) {
            if (root == null) return true;
            return isBalanceFast(root,new AtomicInteger(0));
        }

        public static boolean isBalanceFast(TreeNode root, AtomicInteger h) {
            if (root == null) {
                h.set(0);
                return true;
            }
            AtomicInteger lh = new AtomicInteger(0);
            AtomicInteger rh = new AtomicInteger(0);
            if (isBalanceFast(root.left, lh) && isBalanceFast(root.right, rh)) {
                h.set(Math.max(lh.get(), rh.get()) + 1);
                if (Math.abs(lh.get() - rh.get()) <= 1) {
                    return true;
                }
            }
            return false;
        }

        private static boolean isBalance(TreeNode root) {
            if (root == null) return true;
            return isBalance(root.left) && isBalance(root.right) && Math.abs(deepth(root.left) - deepth(root.right)) <= 1;
        }
    }
}
