package algorithm.math;

public class Sqrt {
    // 普通方法
    public int mySqrt(int x) {
        long n = x;
        while ((n * n) > x) {
            n >>= 1;
        }
        while ((n * n) < x) {
            n++;
        }
        return (int) n;
    }

    // 二分法
    public static int mySqrt1(int x) {
        int start = 1;
        int end = x;
        while (start <= end) {
            long mid = start + (end - start) / 2;
            if (mid * mid == x) {
                return (int) mid;
            } else if (mid * mid < x) {
                start = (int) (mid + 1);
            } else {
                end = (int) (mid - 1);
            }
        }
        return start - 1;
    }

    // 牛顿迭代法
    public int sqart2(int x) {

        double k = 1.0;
        while(Math.abs(k*k - x)>1e-9) {
            k = (k + x/k)/2;
        }
        return (int) k;
    }
}
