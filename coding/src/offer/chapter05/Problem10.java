package offer.chapter05;

/**
 * 不用加减乘除做加法
 */
public class Problem10 {

    public static int solution(int n, int m) {
        int num, carry;
        do {
            num = n ^ m;
            carry = (n & m) << 1;
            n = num;
            m = carry;
        } while (m != 0);
        return n;
    }
}
