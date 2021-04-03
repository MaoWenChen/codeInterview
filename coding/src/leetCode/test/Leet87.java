package leetCode.test;

public class Leet87 {

	public static void main(String[] args) {
		System.out.println(isScramble("abcde", "caebd"));
	}

	// time exceeded
	public static boolean isScramble(String s1, String s2) {
		if (s1.length() != s2.length()) {
			return false;
		}
		if (s1.equals(s2)) {
			return true;
		}
		for (int i = 1; i < s1.length(); i++) {
			String t1 = s1.substring(0, i);
			String t2 = s1.substring(i, s1.length());
			String t3 = s2.substring(0, s1.length() - i);
			String t4 = s2.substring(s1.length() - i, s2.length());
			String t5 = s2.substring(0, i);
			String t6 = s2.substring(i, s2.length());
			if (isScramble(t1, t5) && isScramble(t2, t6) || isScramble(t1, t4) && isScramble(t2, t3)) {
				return true;
			}
		}
		return false;
	}

	public static boolean isc(String s1, String s2) {
		if (s1.equals(s2))
			return true;
		int s1Array[] = new int[26];
		int s2Array[] = new int[26];
		for (int i = 0; i < s1.length(); i++) {
			s1Array[s1.charAt(i) - 'a']++;
			s2Array[s2.charAt(i) - 'a']++;
		}
		for (int i = 0; i < 26; i++)
			if (s1Array[i] != s2Array[i])
				return false;
		for (int i = 1; i < s1.length(); i++) {
			if (isScramble(s1.substring(0, i), s2.substring(0, i)) && isScramble(s1.substring(i), s2.substring(i)))
				return true;
			if (isScramble(s1.substring(0, i), s2.substring(s1.length() - i))
					&& isScramble(s1.substring(i), s2.substring(0, s1.length() - i)))
				return true;
		}
		return false;
	}

	public static boolean iscram(String s1, String s2) {
		if (s1.length() != s2.length()) {
			return false;
		}
		char[] c1 = s1.toCharArray();
		char[] c2 = s2.toCharArray();

		int len = s1.length();

		// DP: s1[i], s2[j], length
		boolean[][][] dp = new boolean[len][len][len + 1];

		for (int i = 0; i < len; i++)
			for (int j = 0; j < len; j++) {
				if (c1[i] == c2[j]) {
					dp[i][j][1] = true;
				}
			}

		for (int l = 2; l <= len; l++) {
			for (int i = 0; i < len - l + 1; i++)
				for (int j = 0; j < len - l + 1; j++) {
					for (int k = 1; k < l; k++) {
						if (dp[i][j][k]&&dp[i+k][j+l][l-k]||
								dp[i][j+l-k][k]&&dp[i+k][j][l-k]) {
							dp[i][j][l] = true;
						}
					}
				}
		}
		return dp[0][0][len];

	}

}
