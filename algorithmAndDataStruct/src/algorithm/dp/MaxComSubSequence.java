package algorithm.dp;

/**
 * 最长公共子序列
 */
public class MaxComSubSequence {
	private static final int n1 = 100;
	private static final int n2 = 60;
	private static char[] c1 = new char[n1];
	private static char[] c2 = new char[n2];

	// 递归求取
	public static String maxSequence(int i, int j) {
		if (i == 0 || j == 0) {
			return "";
		}
		String str = "";
		if (c1[i] == c2[j]) {
			str = maxSequence(i - 1, j - 1) + c1[i];
		}
		String str1 = maxSequence(i - 1, j);
		str = str.length() > str1.length() ? str : str1;
		str1 = maxSequence(i, j - 1);
		str = str.length() > str1.length() ? str : str1;
		return str;
	}

	// 递推求取
	public static int maxSequence1(int i, int j) {
		if (i == 0 || j == 0) {
			return 0;
		}

		int[][] maxLen = new int[i + 1][j + 1];
		for (int k = 0; k < i; k++)
			for (int t = 0; t < j; t++) {
				if (c1[k] == c2[t]) {
					maxLen[k + 1][t + 1] = maxLen[k][t] + 1;
				} else {
					maxLen[k + 1][t + 1] = Math.max(maxLen[k][t + 1], maxLen[k + 1][t]);
				}
			}

		return maxLen[i][j];

	}

}
