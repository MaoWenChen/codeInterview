package leetCode.test;

public class Leet117 {
	public Node connect(Node root) {
		if (root==null) {
			return root;
		}
		if(root.right!=null) {
			root.right.next = next(root);
		}
		if (root.left !=null) {
			root.left.next = root.right!=null?root.right:next(root);
		}
		connect(root.right);
		connect(root.left);
		return root;

	}

	public Node next(Node node) {
		if (node==null||node.next==null) {
			return null;
		}
		if (node.next.left!=null) {
			return node.next.left;
		}else if(node.next.right !=null){
			return node.next.right;
		}else {
			return next(node.next);
		}
	}
}
