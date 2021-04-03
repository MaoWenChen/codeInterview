package leetCode.test;

public class Leet91 {

	public static void main(String[] args) {
		System.out.println(numDecodings("110203"));
	}

	public static int numDecodings(String s) {
		if (s.length() == 0 || s.startsWith("0")) {
			return 0;
		}
		int[] dp = new int[s.length() + 1];
		char[] c = s.toCharArray();
		dp[0] = 1;
		dp[1] = 1;
		for (int i = 1; i < c.length; i++) {
			int val = Integer.valueOf(s.substring(i - 1, i + 1));
			if (c[i] == '0') {
				dp[i + 1] = 0;
			} else {
				dp[i + 1] = dp[i];
			}
			if (10 <= val && val <= 26) {
				dp[i + 1] += dp[i - 1];
			}
		}
		return dp[c.length];
	}

	public static int numDecodings1(String s) {
		if (s.length() == 0 || s.startsWith("0")) {
			return 0;
		}
		char[] c = s.toCharArray();
		int f0 = 1;
		int f1 = 1;
		int f = 0;
		for (int i = 1; i < c.length; i++) {
			int val = (c[i-1]-'0')*10+c[i]-'0';
			if (c[i] == '0') {
				f = 0;
			} else {
				f = f1;
			}
			if (10 <= val && val <= 26) {
				f += f0;
			}
			f0 = f1;
			f1 = f;
		}
		return f;
	}
}
