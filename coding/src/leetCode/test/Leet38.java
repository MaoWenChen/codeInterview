package leetCode.test;

public class Leet38 {

    public static void main(String[] args) {
        System.out.println(countAndSay(8));
    }

    public static String countAndSay(int n) {
        String res = "1";
        for (int i = 1; i < n; i++) {
            char[] cs = res.toCharArray();
            StringBuilder sb = new StringBuilder();
            char tc = cs[0];
            int cnt = 1;
            for (int j = 1; j < cs.length; j++) {
                if (cs[j] == tc) {
                    cnt++;
                    continue;
                } else {
                    sb.append((char) ('0' + cnt)).append(tc);
                    cnt = 1;
                    tc = cs[j];
                }
            }
            sb.append((char) ('0' + cnt)).append(tc);
            res = sb.toString();
        }
        return res;
    }

}
