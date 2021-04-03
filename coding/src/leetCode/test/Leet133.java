package leetCode.test;

import java.util.*;

public class Leet133 {

	public static void main(String[] args) {
		Leet133 l = new Leet133();
		Node node1 = new Node(1, new ArrayList<>());
		Node node2 = new Node(2, new ArrayList<>());
		Node node3 = new Node(3, new ArrayList<>());
		Node node4 = new Node(4, new ArrayList<>());
		node1.neighbors.add(node2);
		node1.neighbors.add(node4);
		node2.neighbors.add(node1);
		node2.neighbors.add(node3);
		node3.neighbors.add(node2);
		node3.neighbors.add(node4);
		node4.neighbors.add(node1);
		node4.neighbors.add(node3);

		Node node = l.cloneGraph(node1);
		System.out.println(node);
	}

	public Node cloneGraph(Node node) {
		if (node == null)
			return null;
		LinkedList<Node> queue = new LinkedList<>();
		Set<Node> visited = new HashSet<>();
		Map<Node, Node> map = new HashMap<>();
		queue.add(node);
		Node tmp = null;
		Node clone = null;
		while (!queue.isEmpty()) {
			if (visited.contains(queue.peek())) {
				queue.poll();
				continue;
			}
			tmp = queue.poll();
			if (!map.containsKey(tmp)) {
				map.put(tmp, new Node(tmp.val, new ArrayList<Node>()));
			}
			clone = map.get(tmp);
			visited.add(tmp);
			for (Node nd : tmp.neighbors) {
				if (!visited.contains(nd)) {
					queue.push(nd);
				}
				if (!map.containsKey(nd)) {
					map.put(nd, new Node(nd.val, new ArrayList<Node>()));
				}
				clone.neighbors.add(map.get(nd));
			}
		}
		return map.get(node);

	}

	static class Node {
		public int val;
		public List<Node> neighbors;

		public Node() {
		}

		public Node(int _val, List<Node> _neighbors) {
			val = _val;
			neighbors = _neighbors;
		}
	}

}

class fasterSolution {
	Map<Integer, Node> map;

	public Node cloneGraph(Node node) {
		map = new HashMap<Integer, Node>();
		return cloneUtil(node);
	}

	private Node cloneUtil(Node node) {
		if (!map.containsKey(node.val)) {
			Node clone = new Node();
			clone.val = node.val;
			clone.neighbors = new LinkedList<Node>();
			map.put(node.val, clone);
			for (Node nei : node.neighbors) {
				clone.neighbors.add(cloneUtil(nei));
			}
		}
		return map.get(node.val);
	}

	static class Node {
		public int val;
		public List<Node> neighbors;

		public Node() {
		}

		public Node(int _val, List<Node> _neighbors) {
			val = _val;
			neighbors = _neighbors;
		}
	}
}
