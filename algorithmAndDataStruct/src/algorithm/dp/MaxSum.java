package algorithm.dp;

/**
 * 最大子数组和
 */
public class MaxSum {
    public int maxSubArray(int[] A) {
        int sum = 0;
        int maxSum = Integer.MIN_VALUE;
        for (int i = 0; i < A.length; i++) {
            if (sum <= 0) {
                sum = A[i];
            } else {
                sum += A[i];
            }
            maxSum = maxSum > sum ? maxSum : sum;
        }
        return maxSum;
    }
}
