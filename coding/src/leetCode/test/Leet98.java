package leetCode.test;

public class Leet98 {
	
	private long min = Long.MIN_VALUE;

	public boolean isValidBST(TreeNode root) {
		if (root == null) {
			return true;
		}
		boolean flag = true;
		flag = isValidBST(root.left);
		if (min>=root.val) {
			return false;
		}
		min = root.val;
		flag &= isValidBST(root.right);
		return flag;
	}

}
