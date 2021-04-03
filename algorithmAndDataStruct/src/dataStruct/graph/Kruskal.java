package dataStruct.graph;

import java.util.List;

public class Kruskal {
	// 村庄布线问题
	public static int kruskal11(List<Edge1> edges, int n) {
		parent = new int[n];
		for (int i = 0; i < n; i++) {
			parent[i] = -1;
		}
		int count = 0;
		for (int i = 0; i < edges.size(); i++) {
			Edge1 edge = edges.get(i);
			if (getRoot(edge.s) != getRoot(edge.e)) {
				count++;
				if (count == 6) {
					return edge.w;
				}
			}
		}
		return -1;
	}

	private static int[] parent;// 并查集
	// 时间复杂度o(eloge)

	public static int kruskal(List<Edge1> edges, int n) {
		parent = new int[n];
		for (int i = 0; i < n; i++) {
			parent[i] = -1;
		}
		int done = 0;
		int totalW = 0;
		for (Edge1 edge : edges) {
			if (getRoot(edge.s) != getRoot(edge.e)) {
				merge(edge.s, edge.e);
				++done;
				totalW += edge.w;
			}
			if (done == n - 1)
				break;
		}
		if (done < n - 1) {
			return -1;
		}
		return totalW;
	}

	// 获取并查集的父节点
	public static int getRoot(int c) {
		if (parent[c] == -1) {
			return c;
		} else {
			parent[c] = getRoot(parent[c]);
			return parent[c];
		}
	}

	// 合并并查集
	public static void merge(int a, int b) {
		int p1 = getRoot(a);
		int p2 = getRoot(b);
		if (p1 == p2) {
			return;
		}
		parent[p2] = p1;
	}

}

class Edge1 implements Comparable<Edge1> {

	int s, e, w;// 起点,终点,权值;

	public Edge1(int s, int e, int w) {
		this.s = s;
		this.e = e;
		this.w = w;
	}

	@Override
	public int compareTo(Edge1 o) {

		return this.w - o.w;
	}

}
