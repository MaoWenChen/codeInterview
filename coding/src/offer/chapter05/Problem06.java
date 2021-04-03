package offer.chapter05;

import java.util.Arrays;

/**
 * n个骰子的点数和的概率
 */
public class Problem06 {
    //基于递归低于num个骰子点数的概率,num表示骰子的个数，max表示骰子的最大点数
    public static void solution1(int num, int max) {
        if (num < 1 || max < 1) return;
        int[] nums = new int[max * num - num + 1];
        probability(num, nums, num, 0, max);
        double total = 1;
        for (int i = 0; i < num; i++) {
            total *= max;
        }
        for (int pro : nums) {
            System.out.printf("%-8.4f", pro / total);
        }
    }

    private static void probability(int num, int[] nums, int curIndex, int curNum, int max) {
        if (curIndex == 0) {
            nums[curNum - num]++;
        } else {
            for (int i = 1; i <= max; i++) {
                probability(num, nums, curIndex - 1, curNum + i, max);
            }
        }
    }

    //基于递推低于num个骰子点数的概率,num表示骰子的个数，max表示骰子的最大点数
    public static void solution2(int num, int max) {
        if (num < 1 || max < 1) return;
        int maxSum = max * num;
        int[][] nums = new int[num][maxSum];
        double total = 1;
        for (int i = 0; i < num; i++) {
            total *= max;
        }
        for (int i = 0; i < max; i++) {
            nums[0][i] = 1;
        }
        for (int j = 1; j < num; j++)
            for (int i = j; i < (j + 1) * max; i++) {
                for (int k = 1; k <= max; k++) {
                    if (i < k) {
                        break;
                    }
                    nums[j][i] += nums[j - 1][i - k];
                }
            }
        for (int i = num - 1; i < maxSum; i++) {
            System.out.printf("%-8.4f", nums[num - 1][i] / total);
        }
    }

}
