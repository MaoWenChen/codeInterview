package leetCode.test;

public class Leet72 {
	public static void main(String[] args) {
		System.out.println(minDistance("abc", "acb"));
	}
	public static int minDistance(String word1, String word2) {
		int[][] dp = new int[word1.length() + 1][word2.length() + 1];
		for (int i = 1; i <= word2.length(); i++) {
			dp[0][i] = i;
		}
		for (int i = 1; i <= word1.length(); i++) {
			dp[i][0] = i;
		}
		for (int i = 1; i <= word1.length(); i++) {
			for (int j = 1; j <= word2.length(); j++) {
				char i1 = word1.charAt(i-1);
				char i2 = word2.charAt(j-1);
				int min = Integer.MAX_VALUE;
				if (i1==i2) {
					min = dp[i-1][j-1];
				}
				min = Math.min(min, dp[i-1][j]+1);
				min = Math.min(min, dp[i-1][j-1]+1);
				min = Math.min(min, dp[i][j-1]+1);
				dp[i][j] = min;
			}
		}
		return dp[word1.length()][word2.length()];
	}

}
