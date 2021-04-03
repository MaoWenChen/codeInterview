package leetCode.test;

import java.util.HashMap;
import java.util.Map;


public class Leet106 {
	
	public static void main(String[] args) {
		Leet106 leet106 = new Leet106();
		System.out.println(leet106.buildTree(new int[]{9,3,15,20,7},new int[]{9,15,7,20,3}));
	}
	
	Map<Integer, Integer> map = new HashMap<>();
	public TreeNode buildTree(int[] inorder, int[] postorder) {
		if (inorder.length==0) {
			return null;
		}
		for(int i = 0;i<inorder.length;i++) {
			int tmp = inorder[i];
			map.put(tmp, i);
		}
		return build(inorder, 0, inorder.length-1, postorder,0, postorder.length-1);
	
	}
	

	public TreeNode build(int[] inorder, int is, int ie, int[] postorder, int ps, int pe) {
		if (is>ie) {
			return null;
		}
		int val = postorder[pe];
		int index = map.get(val);
		TreeNode root = new TreeNode(val);
		root.left = build(inorder, is, index-1, postorder, ps, ps+index-is-1);
		root.right = build(inorder, index+1, ie, postorder, pe-(ie-index), pe-1);
		return root;
		
	}

}
