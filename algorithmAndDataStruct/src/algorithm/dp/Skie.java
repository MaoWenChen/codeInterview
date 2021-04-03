package algorithm.dp;

import java.util.Arrays;

/**
 * 滑雪｛在矩阵中求最长滑行距离，（当前格子的值大于旁边格子时才能滑行）｝
 *
 */
public class Skie {

	private static int[][] area;
	private static int[] dx = new int[] { 0, 1, 0, -1 };
	private static int[] dy = new int[] { 1, 0, -1, 0 };
	private static int[][] dp;
	private static SkieStruct[] sd;

	public static boolean check(int i, int j) {
		if (i < 0 || i >= area.length || j < 0 || j >= area[0].length) {
			return false;
		}
		return true;
	}

	// 递归版本算法
	public static int skie(int i, int j) {
		if (!check(i, j)) {
			return 0;
		}
		int max = 1;
		for (int t = 0; t < dx.length; t++) {
			if (check(i + dx[t], j + dy[t]) && area[i][j] >= area[i + dx[t]][j + dy[t]]) {
				max = Math.max(max, skie(i + dx[t], j + dy[t]) + 1);
			}
		}
		return max;
	}

	// 记忆化的递归
	public static int skie1(int i, int j) {
		if (!check(i, j)) {
			return 0;
		}
		if (dp[i][j] == 0) {
			int max = 1;
			for (int t = 0; t < dx.length; t++) {
				if (check(i + dx[t], j + dy[t]) && area[i][j] >= area[i + dx[t]][j + dy[t]]) {
					max = Math.max(max, skie(i + dx[t], j + dy[t]) + 1);
				}
			}
			dp[i][j] = max;
		}
		return dp[i][j];
	}

	// 递推版的算法 1.先对高度排序, 2.然后从小到大的更新这点周围比他高的点
	public static int dpSkie(int i, int j) {
		// i,j 代表二维数组的长度
		Arrays.sort(sd);
		for (int k = 0; k < i; k++) {
			for (int t = 0; t < j; t++) {
				dp[k][t] = 1;
			}
		}
		int max = 0;
		for (int t = 0; t < sd.length; t++) {
			SkieStruct st = sd[t];
			for (int k = 0; k < dx.length; k++) {
				if (check(st.x + dx[k], st.y + dy[k]) && st.h >= area[st.x + dx[k]][st.y + dy[k]]) {
					dp[st.x + dx[k]][st.y + dy[k]] = Math.max(dp[st.x + dx[k]][st.y + dy[k]], dp[st.x][st.y] + 1);
					max = Math.max(dp[st.x + dx[k]][st.y + dy[k]], max);
				}
			}

		}
		return max;
	}

}

class SkieStruct implements Comparable<SkieStruct> {
	int x;
	int y;
	int h;

	@Override
	public int compareTo(SkieStruct o) {
		return this.h - o.h;
	}
}
