package leetCode.test;

public class Leet124 {

	int maxSum = 0;

	public int maxPathSum(TreeNode root) {
		if (root == null) {
			return maxSum;
		}
		maxSum = root.val;
		inorder(root);
		return maxSum;
	}
	public void inorder(TreeNode root) {
		if (root!=null) {
			maxSum = Math.max(maxSum(root), maxSum);
			inorder(root.left);
			inorder(root.right);
		}
	}

	public int maxSum(TreeNode node) {
		int tmpmax = 0;
		if (node == null) {
			return 0;
		} else if (node.left == null && node.right == null) {
			return node.val;
		} else {
			int left = maxpath(node.left);
			int right = maxpath(node.right);
			tmpmax = Math.max(left, right);
			return Math.max(node.val + right + left, Math.max(tmpmax + node.val, node.val));
		}
	}

	public int maxpath(TreeNode node) {
		int tmpMax = 0;
		if (node == null) {
			return 0;
		} else if (node.left == null && node.right == null) {
			return node.val;
		} else {
			tmpMax = Math.max(maxpath(node.left), maxpath(node.right));
			return Math.max(tmpMax + node.val, node.val);
		}
	}
	
	
	//高效算法
	

	    public int maxPathSum1(TreeNode root) {
	        maxSum = Integer.MIN_VALUE;
	        helper(root);
	        return maxSum;
	    }
	    
	    int helper(TreeNode root){
	        if(root == null){
	            return 0;
	        }
	        
	        int left = Math.max(0, helper(root.left));
	        int right = Math.max(0, helper(root.right));
	        
	        maxSum = Math.max(left + right + root.val, maxSum);
	        
	        return Math.max(left, right) + root.val;
	    }

}
