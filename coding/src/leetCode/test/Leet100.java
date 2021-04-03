package leetCode.test;

public class Leet100 {

	public boolean isSameTree(TreeNode p, TreeNode q) {
		if (p==null&&q == null) {
			return true;
		}else if(p!=null&&q!=null&&p.val==q.val) {
			return isSameTree(p.left, q.left)&&isSameTree(p.right, q.right);
		}
		return false;
	}

}
