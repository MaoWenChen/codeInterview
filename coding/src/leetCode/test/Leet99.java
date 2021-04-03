package leetCode.test;

public class Leet99 {
	
	private long min = Long.MIN_VALUE;
	private TreeNode pre = null;
	
	private TreeNode node1 = null;
	private TreeNode node2 = null;

	public void recoverTree(TreeNode root) {
		dfs(root);
		int tmp = node1.val;
		node1.val = node2.val;
		node2.val = tmp;
	}

	public void dfs(TreeNode root) {
		if (root == null) {
			return ;
		}
		dfs(root.left);
		if (root.val<=min) {
			if (node1==null) {
				node1 = pre;
				node2 = root;
			}else if (node2!=null) {
				node2= root;
			}
		}
		min = root.val;
		pre = root;
		dfs(root.right);
	
	}
}
