package leetCode.test;

import java.util.ArrayList;
import java.util.List;

public class Leet116 {
	public Node connect(Node root) {
		List<List<Node>> lists = new ArrayList<>();
		connect(0, root, lists);
		for (int i = 0; i < lists.size(); i++) {
			List<Node> nodes = lists.get(i);
			for(int j = 0;j<nodes.size()-1;j++) {
				Node left = nodes.get(j);
				Node right = nodes.get(j+1);
				left.next = right;
			}
		}
		return root;
	}

	public void connect(int cur, Node node, List<List<Node>> lists) {
		if (node != null) {
			if (lists.size()>= cur) {
				lists.add(new ArrayList<Node>());
			}
			List<Node> nodes  =lists.get(cur);
			nodes.add(node);
			connect(cur + 1, node.left, lists);
			connect(cur + 1, node.right, lists);
		}
	}

}

class Node {
	public int val;
	public Node left;
	public Node right;
	public Node next;

	public Node() {
	}

	public Node(int _val, Node _left, Node _right, Node _next) {
		val = _val;
		left = _left;
		right = _right;
		next = _next;
	}
}
