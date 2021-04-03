package leetCode.test;

public class Leet101 {
	public boolean isSymmetric(TreeNode root) {
		if (root==null) {
			return true;
		}
		return isSymmetric(root.left,root.right);
	}
	
	public boolean isSymmetric(TreeNode left,TreeNode right) {
        if (left==null &right == null) {
			return true;
		}else if(left!=null&&right!=null&&left.val==right.val) {
			return isSymmetric(left.left,right.right)&&isSymmetric(left.right,right.left);
		}
        return false;
    }

}
