package leetCode.test;

public class Leet129 {

	public static void main(String[] args) {
		Leet129 le = new Leet129();
		TreeNode root = new TreeNode(1);
		root.left = new TreeNode(2);
		root.right = new TreeNode(3);
		le.sumNumbers(root);
	}

	private int sum = 0;

	public int sumNumbers(TreeNode root) {
		preOrder("", root);
		return sum;
	}

	public void preOrder(String s, TreeNode root) {
		if (root == null) {
			return;
		} else if (root.left == null && root.right == null) {
			sum += Integer.valueOf(s + root.val);
		} else {

			preOrder(s + root.val, root.left);
			preOrder(s + root.val, root.right);
		}
	}

	public void preOrder1(int num, TreeNode root) {
		if (root == null) {
			return;
		} else if (root.left == null && root.right == null) {
			sum += Integer.valueOf(num * 10 + root.val);
		} else {
			preOrder1(num * 10 + root.val, root.left);
			preOrder1(num * 10 + root.val, root.right);
		}
	}

}
