package leetCode.test;


public class Leet1009 {
	public TreeNode bstFromPreorder(int[] preorder) {
		if (preorder.length == 0) {
			return null;
		}
		int index = 1;
		TreeNode root = new TreeNode(preorder[0]);
		while(index<preorder.length) {
			TreeNode node = root;
			TreeNode parent = null;
			while(node!=null) {
				parent = node;
				if (node.val>preorder[index]) {
					node = node.left;
				}else {
					node = node.right;
				}
			}
			node = new TreeNode(preorder[index]);
			if (parent.val>preorder[index]) {
				parent.left = node;
			}else {
				parent.right = node;
			}
			index++;
		}
		return root;
	}

}
