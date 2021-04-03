package offer.chapter01;

/**
 * 求整数中1的个数
 */
public class Problem09 {

    public static int solution1(int n) {
        int res = 0;
        for (int i = 0; i < 32; i++) {
            res += (n & 1);
            n >>>= 1;
        }
        return res;
    }

    public static int solution2(int n) {
        int res = 0;
        while (n != 0) {
            res += 1;
            n &= (n - 1);
        }
        return res;
    }
}
