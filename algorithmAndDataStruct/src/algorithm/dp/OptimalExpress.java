package algorithm.dp;

/**
 * 最佳表达式(在n串中放置m个加号，使值最小)
 *
 */
public class OptimalExpress {
	public static void main(String[] args) {
		System.out.println(express("12345678", 3));
	}

	public static int express(String n, int m) {
		if (m == 0) {
			return Integer.valueOf(n);
		}
		int res = Integer.MAX_VALUE;
		for (int i = 1; i < n.length() - m; i++) {
			int tmp = Integer.valueOf(n.substring(n.length() - i, n.length()));
			int tmp1 = express(n.substring(0, n.length() - i), m - 1);
			res = Math.min(res, tmp + tmp1);
		}
		return res;
	}
	//O(mn2)
	public static int express1(String n, int m) {
		int[][] dp = new int[n.length()][m + 1];
		for (int i = 0; i < n.length(); i++) {
			dp[i][0] = Integer.valueOf(n.substring(0, i + 1));
		}
		for (int i = 1; i <= m; i++) {
			for (int j = i; j < n.length(); j++) {
				int min = Integer.MAX_VALUE;
				for(int k = j;k>=i;k--) {
					int tmp = Integer.valueOf(n.substring(k, j+1));
					min = Math.min(min, tmp+dp[j-(j-k+1)][i-1]);
				}
				dp[j][i] = min;
			}
		}
		return dp[n.length()-1][m];
	}
}
