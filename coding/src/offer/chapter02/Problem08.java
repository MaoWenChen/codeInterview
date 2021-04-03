package offer.chapter02;

import offer.ListNode;
import offer.TreeNode;

/**
 * 判断树的子结构
 */
public class Problem08 {

    public static boolean solution(TreeNode l1, TreeNode l2) {
        if (l2 == null) {
            return true;
        } else if (l1 == null) {
            return false;
        }
        if (l1.val == l2.val) {
            return match(l1, l2);
        } else {
            return solution(l1.left, l2) || solution(l1.right, l2);
        }

    }

    private static boolean match(TreeNode l1, TreeNode l2) {
        if (l2 == null) {
            return true;
        }
        if (l1 == null) {
            return false;
        }
        if (l1.val != l2.val) {
            return false;
        }
        return match(l1.left, l2.left) && match(l1.right, l2.right);
    }
}
