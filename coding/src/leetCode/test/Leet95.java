package leetCode.test;

import java.util.ArrayList;
import java.util.List;

public class Leet95 {

	public List<TreeNode> generateTrees(int n) {
		return dfs(1, n);
	}
	
	List<TreeNode> dfs(int start,int end){
		if (start>end) {
			return new  ArrayList<TreeNode>();
		}else if (start==end) {
			TreeNode node = new TreeNode(start);
			List<TreeNode> list = new ArrayList();
			list.add(node);
			return list;
		}else {
			List<TreeNode> list = new ArrayList();
			for(int i = start;i<=end;i++) {
				List<TreeNode> left = dfs(start,i-1);
				List<TreeNode> right = dfs(i+1, end);
				if (left.isEmpty()) {
					for(int j = 0;j<right.size();j++) {
						TreeNode root = new TreeNode(i);
						root.right = right.get(j);
						list.add(root);
					}
				}else if(right.isEmpty()) {
					for(int j = 0;j<left.size();j++) {
						TreeNode root = new TreeNode(i);
						root.left = left.get(j);
						list.add(root);
					}
				}else {
					for(int k = 0;k<right.size();k++)
					for(int j = 0;j<left.size();j++) {
						TreeNode root = new TreeNode(i);
						root.left = left.get(j);
						root.right = right.get(k);
						list.add(root);
					}
				}
			}
			return list;
		}
	}
}
