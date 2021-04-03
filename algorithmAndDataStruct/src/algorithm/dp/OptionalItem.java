package algorithm.dp;

import java.util.Arrays;

/**
 * 数组中组成m的子序列个数
 */
public class OptionalItem {
	public static void main(String[] args) {
		int[] arrs = new int[] { 1, 2, 3, 4, 5, 6, 7, 8, 9 };
		System.out.println(optional(arrs, 10));
	}

	public static int option(int[] arrs, int m) {
		if (m == 0) {
			return 1;
		} else if (arrs.length == 0) {
			return 0;
		}
		int[] tmpArrs = Arrays.copyOfRange(arrs, 0, arrs.length - 1);
		return option(tmpArrs, m) + option(tmpArrs, m - arrs[arrs.length - 1]);
	}

	public static int optional(int[] arr, int m) {
		int[][] dp = new int[arr.length + 1][m + 1];
		for(int i = 0;i<arr.length;i++) {
			if (arr[i]<=m) {
				dp[i][0]=1;
			}
		}
		dp[0][0] = 1;
		for (int i = 1; i <= arr.length; i++) {
			for (int j = 1; j <= m; j++) {
				dp[i][j] = dp[i-1][j];
				if (j-arr[i-1]>=0) {
					dp[i][j]+=dp[i-1][j-arr[i-1]];
				}
			}
		}
		return dp[arr.length][m];
	}
}
