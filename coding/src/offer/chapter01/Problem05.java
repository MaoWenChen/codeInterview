package offer.chapter01;

import offer.TreeNode;

/**
 * 根据前序和中序重构二叉树(不含重复数字)
 */
public class Problem05 {

    public static TreeNode solution(int[] preOrder, int[] inOrder) {
        if (preOrder == null || inOrder == null || preOrder.length != inOrder.length || inOrder.length < 1) {
            return null;
        }
        return constructTree(preOrder,0,preOrder.length-1,inOrder,0,inOrder.length-1);
    }

    public static TreeNode constructTree(int[] preOrder, int preStart, int preEnd, int[] inOrder, int inStart, int inEnd) {
        if (preStart > preEnd) {
            return null;
        }

        int rootVal = preOrder[preStart];
        int index = inStart;
        //查找中序遍历的根节点
        while(index<=inEnd && inOrder[index]!=rootVal){
            index++;
        }
        if (index>inEnd){
            throw new IllegalArgumentException("无法重构二叉树");
        }

        TreeNode root = new TreeNode();
        root.val = rootVal;
        root.left = constructTree(preOrder,preStart+1,preStart+index-inStart,inOrder,inStart,index-1);
        root.right = constructTree(preOrder,preStart+index-inStart+1,preEnd,inOrder,index+1,inEnd);
        return root;

    }
}
