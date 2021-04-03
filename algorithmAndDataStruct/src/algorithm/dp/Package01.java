package algorithm.dp;

/**
 * 01背包问题（n个物品，不超过m重量的最大价值）
 *
 */
public class Package01 {
	private static int[] w;
	private static int[] v;

	// 递归实现版本
	public static int package01(int n, int m) {
		if (n == 0 || m == 0) {
			return 0;
		} else if (n == 1) {
			if (w[n - 1] <= m) {
				return v[n - 1];
			} else {
				return 0;
			}
		} else {
			int max = package01(n - 1, m);
			if (w[n - 1] >= m) {
				max = Math.max(max, package01(n - 1, m - w[n - 1]));
			}
			return max;
		}
	}

	// 递推版本
	public static int package010(int n, int m) {
		int[][] dp = new int[n + 1][m + 1];

		for (int i = 1; i <= n; i++) {
			for (int j = 1; j <= m; j++) {
				dp[i][j] = dp[i - 1][j];
				if (w[i - 1] >= j) {
					dp[i][j] = Math.max(dp[i][j], dp[i - 1][j - w[i - 1]] + v[i - 1]);
				}
			}
		}
		return dp[n][m];
	}

	// 递推版本优化空间
	public static int package011(int n, int m) {
		int[] dp = new int[m + 1];
		for (int i = 0; i < n; i++) {
			for (int j = w[i]; j <= m; j++) {
				dp[j] = Math.max(dp[j], dp[j - w[i]] + v[i]);
			}
		}
		return dp[m];
	}
}
