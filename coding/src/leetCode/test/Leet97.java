package leetCode.test;

public class Leet97 {
	
	public static void main(String[] args) {
		System.out.println(isInterleave1("aabcc","dbbca","aadbbcbcac"));
	}

	// time exceed
	public boolean isInterleave(String s1, String s2, String s3) {
		if (s3.length() == 0 && s1.length() == 0 && s2.length() == 0) {
			return true;
		}
		if (s3.length() == 0) {
			return false;
		}

		if (s1.length() > 0 && s1.charAt(s1.length() - 1) == s3.charAt(s3.length() - 1)
				&& isInterleave(s1.substring(0, s1.length() - 1), s2, s3.substring(0, s3.length() - 1))) {
			return true;
		}

		if (s2.length() > 0 && s2.charAt(s2.length() - 1) == s3.charAt(s3.length() - 1)
				&& isInterleave(s1, s2.substring(0, s2.length() - 1), s3.substring(0, s3.length() - 1))) {
			return true;
		}
		return false;
	}

	public static boolean isInterleave1(String s1, String s2, String s3) {
		if (s3.length() == 0 && s1.length() == 0 && s2.length() == 0) {
			return true;
		}
		if (s3.length() == 0) {
			return false;
		}
		boolean[][][] dp = new boolean[s1.length() + 1][s2.length() + 1][s3.length() + 1];
		char[] c1 = s1.toCharArray();
		char[] c2 = s2.toCharArray();
		char[] c3 = s3.toCharArray();
		dp[0][0][0] = true;

		for (int k = 1; k <= c3.length; k++)
			for (int i = 0; i <= k&&i<=c1.length; i++) {
					if (k-i>c2.length) {
						continue;
					}
					int j = k - i;
					if (i>0&&c1[i-1]==c3[k-1]) {
						dp[i][j][k] = dp[i-1][j][k-1];
					}
					if (j>0&&c2[j-1]==c3[k-1]) {
						dp[i][j][k] |= dp[i][j-1][k-1];
					}
				}
		
		return dp[c1.length][c2.length][c3.length];
	}
}
