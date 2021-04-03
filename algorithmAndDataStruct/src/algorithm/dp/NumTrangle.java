package algorithm.dp;

/**
 * 数字三角形
 * 
 * @author mchen
 *
 */
public class NumTrangle {
	private static final int NUM = 5;
	private static int[][] d = new int[NUM][NUM];

	private static int[][] maxSum = new int[NUM][NUM];// 记录数据产生的结构

	// 递归获取从i,j到底部的路径长度 超时算法O(2^N)
	public static int fMax(int i, int j) {
		if (i == NUM - 1) {
			return d[i][j];
		} else {
			return d[i][j] + Math.max(fMax(i - 1, j), fMax(i - 1, j + 1));
		}
	}

	// 记忆化的递归方法
	public static int fMaxMember(int i, int j) {
		if (maxSum[i][j] != -1) {
			return maxSum[i][j];
		}
		if (i == NUM - 1) {
			maxSum[i][j] = d[i][j];
		} else {
			maxSum[i][j] = d[i][j] + Math.max(fMaxMember(i - 1, j), fMaxMember(i - 1, j + 1));
		}
		return maxSum[i][j];
	}

	// 递归递推
	public static int maxPush(int i, int j) {
		for (int k = 0; k < NUM; k++) {
			maxSum[NUM - 1][k] = d[NUM - 1][k];
		}
		for (int k = NUM - 2; k >= 0; k--) {
			for (int t = 0; t <= k; t++) {
				maxSum[k][t] = d[k][t] + Math.max(maxSum[k + 1][t], maxSum[k + 1][t + 1]);
			}
		}
		return maxSum[0][0];
	}

	// 空间优化的递归
	public static int maxOptizimePush(int i, int j) {
		int[] dp = new int[NUM];
		for (int k = 0; k < NUM; k++) {
			dp[k] = d[NUM - 1][k];
		}
		for (int k = NUM - 2; k >= 0; k--) {
			for (int t = 0; t <= k; t++) {
				dp[k] = d[k][t] + Math.max(dp[t], dp[t + 1]);
			}
		}
		return dp[0];
	}

	// 利用原数组的空间,进一步节省空间
	public static int maxOptizimePush1(int i, int j) {
		for (int k = NUM - 2; k >= 0; k--)
			for (int t = 0; t <= k; t++) {
				d[NUM-1][t] = d[k][t]+Math.max(d[NUM-1][t], d[NUM-1][t+1]);
			}
		return d[NUM-1][0];
	}

}
