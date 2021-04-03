package offer.chapter01;

/**
 * 求斐波那契（Fibonacci) 数列的第n项
 */
public class Problem08 {

    /**
     * 使用递归
     */
    public static int solution1(int n) {
        if (n == 0) return 0;
        if (n == 1 || n == 2) return 1;
        return solution1(n - 1) + solution1(n - 2);
    }

    /**
     * 使用动规
     */
    public static int solution2(int n) {
        if (n == 0) return 0;
        if (n == 1 || n == 2) return 1;

        int f1 = 1;
        int f2 = 1;

        for (int i = 3; i <= n; i++) {
            int tmp = f1 + f2;
            f1 = f2;
            f2 = tmp;
        }
        return f2;
    }
}
