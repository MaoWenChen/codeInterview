package offer.chapter05;

/**
 * 求1+2+3+....+n
 */
public class Problem09 {
    private static int sum = 0;
    private static int[] nums;

    public static int solution1(int n) {
        nums = new int[n];
        try {
            sum(0);
        } catch (ArrayIndexOutOfBoundsException e) {
        }
        return sum;
    }

    public static void sum(int n) throws ArrayIndexOutOfBoundsException {
        sum += nums[n] + n + 1;
        sum(n + 1);
    }


}
