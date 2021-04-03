package offer.chapter04;

/**
 * 连续子数组的最大和
 */
public class Problem03 {

    //动态规划
    public static int solution(int[] arr) {
        if (arr == null || arr.length == 0) {
            throw new IllegalArgumentException("invalid input");
        }
        int sum = -1;
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < arr.length; i++) {
            if (sum <= 0) {
                sum = arr[i];
            } else {
                sum += arr[i];
            }
            max = Math.max(sum, max);
        }
        return max;

    }
}
