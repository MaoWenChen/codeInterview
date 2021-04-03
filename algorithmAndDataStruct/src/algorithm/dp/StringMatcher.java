package algorithm.dp;

/**
 * 正则匹配
 */
public class StringMatcher {
    public static void main(String[] args) {
        System.out.println(isMatchs("aa", ".*"));
    }

    public boolean isMatch(String s, String p) {
        if (s.isEmpty() && p.isEmpty()) {
            return true;
        }
        if (!s.isEmpty() && p.isEmpty()) {
            return false;
        }
        if (p.length() >= 2 && p.charAt(1) == '*') {
            return matchStar(s, p);
        }
        return matchFirst(s, p) && isMatch(s.substring(1), p.substring(1));
    }

    boolean matchStar(String s, String p) {
        return isMatch(s, p.substring(2)) || (matchFirst(s, p) && isMatch(s.substring(1), p));
    }

    boolean matchFirst(String s, String p) {
        return !s.isEmpty() && !p.isEmpty() && (p.charAt(0) == '.' || s.charAt(0) == p.charAt(0));
    }

    public static boolean isMatchs(String s, String p) {
        if (s.isEmpty() && p.isEmpty()) {
            return true;
        }
        boolean[][] dp = new boolean[p.length() + 1][s.length() + 1];
        dp[0][0] = true;
        for (int i = 2; i <= p.length(); i += 2) {
            if (p.charAt(i - 1) == '*' && dp[i - 2][0]) {
                dp[i][0] = true;
            }
        }

        for (int i = 1; i <= p.length(); i++) {
            for (int j = 1; j <= s.length(); j++) {
                if (p.charAt(i - 1) == s.charAt(j - 1) || p.charAt(i - 1) == '.') {
                    dp[i][j] = dp[i - 1][j - 1];
                }
                if (p.charAt(i - 1) == '*') {
                    dp[i][j] = dp[i - 2][j];
                    if (dp[i][j]) {
                        continue;
                    }
                    boolean flag = false;
                    for (int k = j; k >= 1 && (p.charAt(i - 2) == s.charAt(k - 1)||p.charAt(i-2)=='.'); k--) {
                        if (dp[i - 1][k]) {
                            flag = true;
                            break;
                        }
                    }
                    dp[i][j] = flag;

                }
            }
        }
        return dp[p.length()][s.length()];
    }
}
