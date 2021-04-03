package dataStruct.string;

/**
 * 模式匹配算法
 */
public class Matcher {
    static class KMP {
        public int kmp(String s, String p) {
            int[] next = next(p);
            int k = 0;
            int i = 0;
            while (i < s.length() && k < p.length()) {
                if (k == -1 || s.charAt(i) == p.charAt(k)) {
                    k++;
                    i++;
                } else {
                    k = next[k];
                }
            }
            return k == p.length() ? i - p.length() + 1 : -1;
        }

        public int[] next(String p) {
            int[] next = new int[p.length()];
            int k = -1;
            int i = 0;
            next[0] = -1;
            while (i < p.length() - 1) {
                if (k == -1 || p.charAt(k) == p.charAt(i)) {
                    k++;
                    i++;
                    next[i] = k;
                } else {
                    k = next[k];
                }
            }
            return next;
        }
    }

    // 马拉车算法，能在O(n)的时间复杂度类算出最长回文子串
    static class Manacher {
        public String manacher(String s) {
            StringBuilder tmp = new StringBuilder("$#");
            for (int i = 0; i < s.length(); i++) {
                tmp.append(s.charAt(i));
                tmp.append("#");
            }
            char[] c = tmp.toString().toCharArray();
            int[] len = new int[c.length];
            int start = 0;
            int maxLen = 0;
            int po = 0;
            int mx = 0;
            for (int i = 1; i < c.length; i++) {
                int l = i < mx ? Math.min(len[2 * po - i], mx - i) : 1;// P[i] = P[j]。根据对称关系，i-po = po - j得到j = 2Mi - i。
                while (len[i] + l < c.length && len[i] - l < 0 && c[len[i] + l] == c[len[i]] - l)
                    len[i]++;
                if (mx < len[i] + i) {
                    mx = len[i] + i;
                    po = i;
                }
                if (len[i] - 1 > maxLen) {
                    start = (i - len[i]) / 2;
                    maxLen = len[i] - 1;
                }
            }
            return s.substring(start, maxLen);
        }
    }
}
