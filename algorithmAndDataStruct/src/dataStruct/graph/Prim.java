package dataStruct.graph;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;

public class Prim {

	// 一般的prim算法,不进行时间优化
	public static int prim(int[][] grah, int n) {
		int totalW = 0;
		int[] vdis = new int[n];
		boolean[] vis = new boolean[n];
		for (int i = 0; i < n; i++) {
			vdis[i] = Integer.MAX_VALUE;
			vis[i] = false;
		}
		vdis[0] = 0;
		int j = 0;
		while (j < n) {
			int mixD = Integer.MAX_VALUE;
			int k = -1;
			for (int i = 0; i < n; i++) {
				if (!vis[i] && vdis[i] < mixD) {
					k = i;
					mixD = vdis[i];
				}
			}
			if (k == -1) {
				break;
			}
			vis[k] = true;
			totalW += k;
			for (int i = 0; i < n; i++) {
				if (!vis[i] && grah[k][i] < vdis[i]) {
					vdis[i] = grah[k][i];
				}
			}
		}
		return j < n ? -1 : totalW;

	}

	// 用优先队列的方法优化prim算法,时间复杂度为o(e*logn) e为边数,n为顶点数
	public static int prim(List<Edge>[] grah, int n) {

		Queue<Edge> pq = new PriorityQueue<Edge>();// 存放顶点到生成树的距离,优化获取最小边的时间
		int[] vDist = new int[n];// 各顶点到已经建好的那部分树的距离。
		boolean[] vUsed = new boolean[n];// 标记各个顶点是否已经加入了生成树
		int nDoneNum = 0; // 已经加入最小生成树的顶点个数;
		for (int t = 0; t < n; t++) {
			vDist[t] = Integer.MAX_VALUE;
			vUsed[t] = false;
		}
		int nTotalW = 0;// 最小生成树的总权值
		pq.add(new Edge(0, 0));// 以顶点0开始
		while (nDoneNum < n && !pq.isEmpty()) {
			Edge edge = null;
			do {
				edge = pq.poll();
			} while (vUsed[edge.v] && !pq.isEmpty());
			if (!vUsed[edge.v]) {
				nTotalW += edge.w;
				nDoneNum++;
				vUsed[edge.v] = true;
				for (int t = 0; t < grah[edge.v].size(); t++) {
					Edge tmp = grah[edge.v].get(t);
					if (!vUsed[tmp.v] && vDist[tmp.v] > tmp.w) {
						vDist[tmp.v] = tmp.w;
						pq.add(tmp);
					}
				}
			}
		}
		if (nDoneNum < n) {
			return -1;
		}
		return nTotalW;
	}
}

//用邻接表表示图
class Edge implements Comparable<Edge> {

	int v;// 边的端点,另一个端点已知
	int w;// 边的权值,也用来表示v到在建生成树的距离

	public Edge(int v, int w) {
		this.v = v;
		this.w = w;
	}

	// 用于优先队列的比较
	@Override
	public int compareTo(Edge o) {
		return this.w - o.w;
	}
}
