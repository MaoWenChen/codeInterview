package offer.chapter07;

import offer.TreeNode;

import java.util.List;

/**
 * 序列化二叉树
 */
public class Problem12 {

    static class Solution {


        public static void serialize(TreeNode root, List<TreeNode> list) {
            if (root == null) {
                list.add(null);
            } else {
                list.add(root);
                serialize(root.left, list);
                serialize(root.right, list);
            }
        }

        public static TreeNode deSerialize(List<TreeNode> list) {
            if (list == null || list.isEmpty()) {
                return null;
            }
            TreeNode root = list.remove(0);
            if (root == null) {
                return root;
            }
            root.left = deSerialize(list);
            root.right = deSerialize(list);
            return root;

        }
    }
}
