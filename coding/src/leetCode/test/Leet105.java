package leetCode.test;

public class Leet105 {

	public TreeNode buildTree(int[] preorder, int[] inorder) {
		return build(preorder, 0, preorder.length-1, inorder, 0, inorder.length-1);
	}

	public TreeNode build(int[] preorder, int ps, int pe, int[] inorder, int is, int ie) {
		if (is > ie) {
			return null;
		} else {
			TreeNode root = new TreeNode(preorder[ps]);
			int index = -1;
			for (int i = is; i <= ie; i++) {
				if (preorder[ps]==inorder[i]) {
					index = i;
					break;
				}
			}
			TreeNode left = build(preorder, ps+1, index-is+ps, inorder, is, index-1);
			TreeNode right = build(preorder, ps+index-is+1, pe, inorder, index+1, ie);
			root.left = left;
			root.right = right;
			return root;
		}

	}
}
