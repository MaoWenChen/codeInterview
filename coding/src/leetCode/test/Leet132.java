package leetCode.test;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class Leet132 {

	public static void main(String[] args) {
		double d = 1.124;
		BigDecimal decimal = new BigDecimal(d);
		System.out.println(decimal.setScale(2,RoundingMode.HALF_UP).doubleValue());
		System.out.println(Integer.parseInt("1A", 16));
		
	}

	int max = Integer.MAX_VALUE;

	public int minCut(String s) {
		if (s.length() == 0) {
			return 0;
		}
		dfs(s, 0, 0);
		return max;
	}

	public void dfs(String s, int count, int l) {
		if (s.length() <= l) {
			max = Math.min(count - 1, max);
		} else {
			for (int i = s.length() - 1; i >= l; i--) {
				if (check(s.substring(l, i + 1)) && count < max) {
					dfs(s, count + 1, i + 1);
				}
			}
		}
	}

	public int minCutDp(String s) {
		if (s.length() <= 1) {
			return 0;
		}
		int[] dp = new int[s.length() + 1];
		dp[0] = -1;
		for (int i = 0, len = s.length(); i < len; i++) {
			dp[i + 1] = dp[i] + 1;
			for (int j = i; j >= 0; j--) {
				if (check(s.substring(j, i + 1))) {
					dp[i + 1] = Math.min(dp[i + 1], dp[j] + 1);
				}
			}
		}
		return dp[s.length()];
	}

	public boolean check(String s) {
		int start = 0;
		int end = s.length() - 1;
		while (start < end) {
			if (s.charAt(start) != s.charAt(end)) {
				return false;
			}
			start++;
			end--;
		}
		return true;
	}
}
